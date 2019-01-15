package com.szt.common.utils;

import com.szt.common.exception.RRException;
import com.szt.modules.generator.entity.*;
import com.szt.modules.generator.service.GeneratorBusConfigService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static com.szt.common.utils.StringUtll.columnToJava;

/**
 * 代码生成器   工具类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月19日 下午11:40:24
 */
@Slf4j
public class GenUtils {
    private static GeneratorBusConfigService generatorBusConfigService = SpringContextUtils.getBean("generatorgeneratorBusConfigService",GeneratorBusConfigService.class);
    public static final String TEMPLATE="template";
    /*public static List<String> getTemplates(){
        List<String> templates = new ArrayList<String>();
        templates.add("template/Constant.java.vm");
        templates.add("template/menu1.sql.vm");
        templates.add("template/Entity.java.vm");
        templates.add("template/Dao.java.vm");
        templates.add("template/Dao.xml.vm");
        templates.add("template/Service.java.vm");
        templates.add("template/ServiceImpl.java.vm");
        templates.add("template/Controller.java.vm");
        templates.add("template/menu.sql.vm");

        templates.add("template/adminlte/list.html.vm");
        templates.add("template/adminlte/list.js.vm");

        templates.add("template/elementui/index.vue.vm");
        templates.add("template/elementui/add-or-update.vue.vm");
        templates.add("template/elementui/index.js.vm");


        return templates;
    }*/
    public static void GeneratorTableFieldParse(){

    }
    public static GeneratorTableEntity readerTable(GeneratorTableEntity tableEntitys, Map<String, Boolean> maps, List<ColumnListEntity> lists, Map<String, GeneratorTemplateConfigEntity> config, boolean hasBigDecimal, Map<String, Object> map){
        //Configuration config = getConfig();
        //表信息
       // TableEntity tableEntity = new TableEntity();
//        tableEntity.setTableName(table.get("tableName" ));
//        tableEntity.setComments(table.get("tableComment" ));
      //  tableEntitys.setTComments(table.get("tableComment" ));
        //表名转换成Java类名
        //String className = tableToJava(tableEntity.getTableName(), config.get("tablePrefix" ).getModelVal());
        String className = tableToJava(tableEntitys.getTableName(), config.get("tablePrefix" ).getModelVal());
//        tableEntity.setClassName(className);
//        tableEntity.setClassname(StringUtils.uncapitalize(className));
        tableEntitys.setClassName(className);
        tableEntitys.setClassname(StringUtils.uncapitalize(className));

        for(GeneratorTableFieldEntity columnEntity : tableEntitys.getColumns()){
          parseTableField(columnEntity,tableEntitys,lists,maps,hasBigDecimal,config);
//            if (columnEntity.getSelectKey() != null) {
//                generatorBusConfigService.insertSysBusConfigPar(columnEntity.getSelectKey(), columnEntity.getList(),311L);
//            }
        }

        //没主键，则第一个字段为主键
        if (tableEntitys.getPk() == null) {
            tableEntitys.setPk(tableEntitys.getColumns().get(0));
        }
        String mainPath =  config.get("mainPath").getModelVal();
        mainPath = StringUtils.isBlank(mainPath) ? "io.renren" : mainPath;
        map.put("null", null);
        map.put("tableName", tableEntitys.getTableName());
        map.put("pathUrl", tableEntitys.getTableName().replaceAll("_",""));
        map.put("comments", tableEntitys.getTableComment());
        map.put("pk", tableEntitys.getPk());
        map.put("className", tableEntitys.getClassName());
        map.put("classname", tableEntitys.getClassname());
        map.put("pathName", tableEntitys.getClassname().toLowerCase());
        map.put("columns", tableEntitys.getColumns());
        map.put("lists",lists);
        map.put("hasBigDecimal", hasBigDecimal);
        map.put("mainPath", mainPath);
        map.put("package", config.get("package").getModelVal());
        map.put("moduleName", config.get("moduleName").getModelVal());
        map.put("moduleNames", StringUtll.captureName(config.get("moduleName").getModelVal()));
        map.put("author",config.get("author").getModelVal());
        map.put("email", config.get("email").getModelVal());
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        return tableEntitys;
    }
    public static void parseTableField(GeneratorTableFieldEntity columnEntity, GeneratorTableEntity tableEntitys, List<ColumnListEntity> lists, Map<String, Boolean> maps, boolean hasBigDecimal, Map<String, GeneratorTemplateConfigEntity> config){
        //GeneratorTableFieldEntity columnEntity = new GeneratorTableFieldEntity();
//            columnEntity.setFieldName(columnEntity.getFieldName());
//            column.setFieldType(columnEntity.getDataType());
//            column.setComment(column.getComment());
//            column.setThisComment(column.getComment());
        String note = columnEntity.getComment();
        //columnEntity.setComment(columnEntity.getComment());
//            column.setFieldName(column.getFieldName());
//            column.setDataType(column.getDataType());
        //解析字段中的变量
        int i=-1;
        List<ColumnListEntity> list = new ArrayList<ColumnListEntity>();
        columnEntity.setList(list);
        for(int n =0;n<1;n++){
            String key = null;
            if((i=note.indexOf("@"))!=-1 || (i=note.indexOf("&"))!=-1) {
                String box = "@";
                columnEntity.setIsChebox(false);
                if(note.indexOf("&")!=-1){
                    box="&";
                    columnEntity.setIsChebox(true);
                }
                String [] noteArr = note.split(box);
                if (noteArr.length != 2) {
                    log.error(tableEntitys.getTableName() + "的" + columnEntity.getFieldName() + "注释存在异常请调整数据!");
                    throw new RRException(tableEntitys.getTableName() + "的" + columnEntity.getFieldName() + "注释存在异常请调整数据!");
                }
                String note1 = noteArr[1];
                log.info(note1);
                note =  noteArr[0];
                key=tableEntitys.getTableName().replaceAll("_","")+columnEntity.getFieldName().replaceAll("_","");
//                    String[] array = note1.split(":");
//                    if (array.length != 2) {
//                        log.error(tableEntitys.getTableName() + "的" + columnEntity.getFieldName() + "注释存在异常请调整数据!");
//                        throw new RRException(tableEntitys.getTableName() + "的" + columnEntity.getFieldName() + "注释存在异常请调整数据!");
//                    }
//                    key = array[0];
//
//                    String value = array[1];
                //分割间隔符号
                int j = -1;
                if ((j = note1.indexOf(",")) == -1) {
                    log.error(tableEntitys.getTableName() + "的" + columnEntity.getFieldName() + "注释存在异常请调整数据!");
                    throw new RRException(tableEntitys.getTableName() + "的" + columnEntity.getFieldName() + "注释存在异常请调整数据!");
                } else {
                    String[] arr2 = note1.split(",");
                    int k = -1;
                    for (String item : arr2) {
                        if ((k = item.indexOf("-")) != -1) {
                            String k1 = item.substring(0, k);
                            String k2 = item.substring(k+1, item.length());
                            ColumnListEntity ce = new ColumnListEntity();
                            ce.setKey(key);
                            ce.setMapKey(k1);
                            ce.setMapValue(k2);
                            list.add(ce);
                        }
                    }

                }
                lists.addAll(list);
                columnEntity.setSelectKey(tableEntitys.getTableName()+"_"+columnEntity.getFieldName());
            }
            if(maps.get(key)!=null){
                break;
            }
            maps.put(key,true);
        }
        columnEntity.setWidthLength("100");
        columnEntity.setPageComment(note);
        columnEntity.setExtra(columnEntity.getExtra());
        columnEntity.setNullable(columnEntity.getIsNull().equals("0"));
        //columnEntity.setIsNull(columnEntity.getIsNull().equals("0")?GeneratorTableFieldConstant.GENTERATE_TABLE_FIELD_IS_NULL_0:GeneratorTableFieldConstant.GENTERATE_TABLE_FIELD_IS_NULL_0);
        //列名转换成Java属性名
        String attrName = columnToJava(columnEntity.getFieldName());

        columnEntity.setAttrName(attrName);
        columnEntity.setAttrname(StringUtils.uncapitalize(attrName));
        //列的数据类型，转换成Java类型
        GeneratorTemplateConfigEntity attr = config.get(columnEntity.getFieldType());
        String attrType =  attr==null  ?"unknowType":attr.getModelVal();
        columnEntity.setAttrType(attrType);
        if (!hasBigDecimal && attrType.equals("BigDecimal" )) {
            hasBigDecimal = true;
        }
        //是否主键
        if ("0".equalsIgnoreCase(columnEntity.getColumnKey()) && tableEntitys.getPk() == null) {
            tableEntitys.setPk(columnEntity);
        }

    }
    /**
     * 生成代码
     */
    public static void generatorCode(GeneratorTableEntity table,ZipOutputStream zip, List<ColumnListEntity> lists, Map<String, Boolean> maps, Map<String, GeneratorTemplateConfigEntity> config, List<GeneratorTemplateEntity> templates) {
        //配置信息
        boolean hasBigDecimal = false;
        //封装模板数据
        Map<String, Object> map = new HashMap<>();
        table=readerTable(table,maps,lists,config,hasBigDecimal,map);
        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
        Velocity.init(prop);
        VelocityContext context = new VelocityContext(map);
        //获取模板列表
        //List<String> templates = getTemplates();
        for (GeneratorTemplateEntity template : templates) {
            //渲染模板
//            StringWriter sw = new StringWriter();
//            Template tpl = Velocity.getTemplate(GenUtils.TEMPLATE+"/"+template.getFileName(), "UTF-8" );
//            tpl.merge(context, sw);
            //渲染模板
            StringWriter sw = new StringWriter();
//
            //   String str = "We are using $project $name to render this. $now";
            Velocity.evaluate(context, sw, "mystring", template.getText());
            try {
                //添加到zip
                zip.putNextEntry(new ZipEntry(getFileName( table.getClassName(),config,template, map)));
                IOUtils.write(sw.toString(), zip, "UTF-8" );
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RRException("渲染模板失败，表名：" + table.getTableName(), e);
            }
        }
    }




    public static void main(String[] args) {
//        //testing for data base column-key to java field
//        String[] dbKeys = {"id", "user_age", "user_addr_"};
//        GenUtils. convertToJava(dbKeys);
//        System.out.println("-----------------------------------");
//        //testing for Java field to data base column-key
//        String javaFieldNames[] = {"id","userAge","userHomeAddr"};
//       String naem = getDBKey("1233");
    }
    /*
     * Java field to data base column-key
     */

    public static String getDBKey(String javaFieldNames){
                StringBuffer buffer = new StringBuffer();
                char[] array = javaFieldNames.toCharArray();
                List<Integer> insertIndexes = new ArrayList<>();
                for(int i=0;i<array.length;i++){
                    Character c = array[i];
                    if(i != 0 && Character.isUpperCase(c)){
                        insertIndexes.add(i);
                    }
                }
                if(insertIndexes.size() > 0){
                    int flag = 0;
                    for(int j=0;j<insertIndexes.size();j++){
                        String word = toLowercase4FirstLetter(javaFieldNames.substring(flag, insertIndexes.get(j)));
                        buffer.append(word).append("_");
                        flag = insertIndexes.get(j);
                    }
                    String last = toLowercase4FirstLetter(javaFieldNames.substring(flag));
                    buffer.append(last);
                    return buffer.toString();
                } else {
                    return javaFieldNames;
                 }
    }

    private static String toLowercase4FirstLetter(String word){
        if(word != null && word.length() > 0){
            String firstLetter = word.substring(0,1);
            String others = word.substring(1);
            return firstLetter.toLowerCase() + others;
        }else{
            return "";
        }
    }

    /*
     * data base column-key to java field
     */
    public static void convertToJava(String... dbKeys) {
        if(dbKeys != null && dbKeys.length > 0){
            for(String key : dbKeys){
                String[] words = key.split("_");
                String result = toUppercase4FirstLetter(words);
                System.out.println(result);
            }
        }
    }

    private static String toUppercase4FirstLetter(String... words){
        StringBuffer buffer = new StringBuffer();
        if(words != null && words.length > 0){
            for(int i=0;i<words.length;i++){
                String word = words[i];
                String firstLetter = word.substring(0, 1);
                String others = word.substring(1);
                String upperLetter = null;
                if(i != 0){
                    upperLetter = firstLetter.toUpperCase();
                } else {
                    upperLetter = firstLetter;
                }
                buffer.append(upperLetter).append(others);
            }
            return buffer.toString();
        }
        return "";
    }

    /**
     * 表名转换成Java类名
     */
    public static String tableToJava(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "" );
        }
        return columnToJava(tableName);
    }

    /**
     * 获取配置信息
     */
    public static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties" );
        } catch (ConfigurationException e) {
            throw new RRException("获取配置文件失败，", e);
        }
    }


    /**
     * 获取文件名
     */
    public static String getFileName(String className, Map<String, GeneratorTemplateConfigEntity> config, GeneratorTemplateEntity templates, Map<String, Object> map1) {
        Pattern p = Pattern.compile("(\\$\\[[^\\]]*\\])");
        String test = templates.getUrl();
        Matcher m = p.matcher(test);
        Map<String, String> map = new HashMap<String, String>();
        map.put("className.toLowerCase()", className.toLowerCase());
        map.put("className", className);
        //${moduleNames}
        map.put("moduleNames", (String) map1.get("moduleNames"));
        map.put("packagePath",config.get("package").getModelVal().replace(".", File.separator));
        StringBuilder bu = new StringBuilder();
        while (m.find()) {
            try{
                String key = m.group().substring(2, m.group().length() - 1);
                String str = null;
                if ((str = map.get(key)) != null) {
                    test = test.replace("$[" + key + "]", str);
                } else if ((config.get(key)) != null) {
                    test = test.replace("$[" + key + "]", config.get(key).getModelVal());
                } else {
                    log.error("配置异常请检查" + templates.getRemark() + "的url文件语法");
                    throw new RRException("配置异常请检查" + templates.getRemark() + "的url文件语法");
                }
            }catch (Exception e){
               log.error(templates.getRemark());
            }
        }
        return test;
    }

//    /**
//     * 获取文件名
//     */
//    public static String getFileName(String template, Map<String, GeneratorTemplateConfigEntity> className, GeneratorTemplateEntity packageName, Map<String, Object> moduleName) {
//        String packagePath = "main" + File.separator + "java" + File.separator;
//        if (StringUtils.isNotBlank(packageName)) {
//            packagePath += packageName.replace(".", File.separator) + File.separator + moduleName + File.separator;
//        }
//
//        if (template.contains("Entity.java.vm" )) {
//            return packagePath + "entity" + File.separator + className + "Entity.java";
//        }
//        if (template.contains("Constant.java.vm" )) {
//            return packagePath + "constant" + File.separator + className + "Constant.java";
//        }
//        if (template.contains("Dao.java.vm" )) {
//            return packagePath + "dao" + File.separator + className + "Dao.java";
//        }
//
//        if (template.contains("Service.java.vm" )) {
//            return packagePath + "service" + File.separator + className + "Service.java";
//        }
//
//        if (template.contains("ServiceImpl.java.vm" )) {
//            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
//        }
//
//        if (template.contains("Controller.java.vm" )) {
//            return packagePath + "controller" + File.separator + className + "Controller.java";
//        }
//
//        if (template.contains("Dao.xml.vm" )) {
//            return "main" + File.separator + "resources" + File.separator + "mapper" + File.separator + moduleName + File.separator + className + "Dao.xml";
//        }
//
//        if (template.contains("menu.sql.vm" )) {
//            return className.toLowerCase() + "_menu.sql";
//        }
//        if (template.contains("menu1.sql.vm" )) {
//            return className.toLowerCase() + "_menu1.sql";
//        }
//
//        if (template.contains("list.html.vm" )) {
//            return "main" + File.separator + "resources" + File.separator + "adminlte" + File.separator
//                    + "modules" + File.separator + moduleName + File.separator + className.toLowerCase() + ".html";
//        }
//
//        if (template.contains("list.js.vm" )) {
//            return "main" + File.separator + "resources" + File.separator + "adminlte" + File.separator + "js" + File.separator
//                    + "modules" + File.separator + moduleName + File.separator + className.toLowerCase() + ".js";
//        }
//
//        if (template.contains("index.vue.vm" )) {
//            return "main" + File.separator + "resources" + File.separator + "elementui" + File.separator + "src" + File.separator + "views" +
//                    File.separator + className.toLowerCase() + File.separator + "index.vue";
//        }
//
//        if (template.contains("add-or-update.vue.vm" )) {
//            return "main" + File.separator + "resources" + File.separator + "elementui" + File.separator + "src" + File.separator + "views" +
//                    File.separator + className.toLowerCase() + File.separator +"add-or-update.vue";
//        }
//
//        if (template.contains("index.js.vm" )) {
//            return "main" + File.separator + "resources" + File.separator + "elementui" + File.separator + "src" + File.separator + "api" +
//                    File.separator+ "modules" + File.separator + className.toLowerCase() + ".js";
//        }
//
//        return null;
//    }
    }

