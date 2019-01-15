package com.szt.modules.generator.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.szt.common.CommonServiceImpl;
import com.szt.common.exception.RRException;
import com.szt.common.exception.SqlException;
import com.szt.common.utils.*;
import com.szt.modules.generator.constant.GeneratorTableFieldConstant;
import com.szt.modules.generator.dao.*;
import com.szt.modules.generator.entity.*;
import com.szt.modules.generator.service.*;
import com.szt.modules.sys.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.Velocity;

/**
 * 数据表管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-13 12:44:03
 */
@Slf4j
@Service("generatorTableService")
public class GeneratorTableServiceImpl extends CommonServiceImpl<GeneratorTableDao, GeneratorTableEntity> implements GeneratorTableService {
    @Autowired
    private GeneratorTemplateDao generatorTemplateDao;
    @Autowired
    private GeneratorTableFieldDao generatorTableFieldDao;
    @Autowired
    private GeneratorTableFieldService generatorTableFieldService;
    @Autowired
    private GeneratorBusConfigService generatorBusConfigService;
    @Autowired
    private GeneratorTemplateConfigService generatorTemplateConfigService;
    @Autowired
    private GeneratorModulesDao generatorModulesDao;
    @Autowired
    private SysGeneratorDao sysGeneratorDao;
    @Autowired
    private SysMenuService sysMenuService;
    @Override
    public String preview(Long tableId, Long id) {

        List<GeneratorTableEntity> tableEntityList = baseMapper.queryTableFilePreviewVO(new String[]{baseMapper.selectById(tableId).getTableName()});
        if (tableEntityList.size() == 0) {
            throw new RRException("表格不存在");
        }
        GeneratorTableEntity tableEntity = tableEntityList.get(0);
        GeneratorTemplateEntity template = generatorTemplateDao.selectById(id);
        //设置velocity资源加载器
        List<ColumnListEntity> lists = new ArrayList<ColumnListEntity>();
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);
        Map<String, GeneratorTemplateConfigEntity> config = generatorTemplateConfigService.queryGeneratorTemplateConfig();
        String mainPath = config.get("mainPath").getModelVal();
        mainPath = StringUtils.isBlank(mainPath) ? "io.renren" : mainPath;
        Map<String, Object> map = new HashMap<>();
        tableEntity = GenUtils.readerTable(tableEntity, new HashMap<String, Boolean>(), lists, config, false, map);
        String className = GenUtils.tableToJava(tableEntity.getTableName(), config.get("tablePrefix").getModelVal());
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));
        map.put("moduleName", tableEntity.getModulesName());
        //封装模板数据
       /*
        map.put("tableName", tableEntity.getTableName());
        map.put("comments", tableEntity.getTableComment());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname().toLowerCase());
        map.put("columns", tableEntity.getColumns());
        map.put("lists", lists);
        map.put("hasBigDecimal", true);
        map.put("mainPath", mainPath);
        map.put("package", config.get("package").getModelVal());
        map.put("moduleName", config.get("moduleName").getModelVal());
        map.put("author", config.get("author").getModelVal());
        map.put("email", config.get("email").getModelVal());
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));*/
        VelocityContext context = new VelocityContext(map);
        //渲染模板
        StringWriter sw = new StringWriter();
        Velocity.evaluate(context, sw, "mystring", template.getText());
        return sw.toString();
    }

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        Page<GeneratorTableEntity> page = new Page<GeneratorTableEntity>(
//                Integer.parseInt((String) params.get("page")),
//                Integer.parseInt((String) params.get("limit"))
//        );
//        page.setRecords(baseMapper.selectPageList(page, params));
//        return new PageUtils(page);
//    }

    @Override
    public byte[] generate(Long[] ids) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        List<ColumnListEntity> lists = new ArrayList<ColumnListEntity>();
        Map<String, GeneratorTemplateConfigEntity> config = generatorTemplateConfigService.queryGeneratorTemplateConfig();
        List<GeneratorTemplateEntity> templates = generatorTemplateDao.queryGeneratorTemplateList();
        List<GeneratorTableEntity> tableEntitys = baseMapper.queryTableFieldVO(Arrays.asList(ids));
        Map<String, Boolean> maps = new HashMap<String, Boolean>();
        for (GeneratorTableEntity tableEntity : tableEntitys) {
            //封装模板数据
            Map<String, Object> map = new HashMap<>();
//            map.put("tableName", tableEntity.getTableName());
//            map.put("comments", tableEntity.getTableComment());
//            map.put("pk", tableEntity.getPk());
//            map.put("className", tableEntity.getClassName());
//            map.put("classname", tableEntity.getClassname());
//            map.put("pathName", tableEntity.getClassname().toLowerCase());
//            map.put("columns", tableEntity.getColumns());
//            map.put("lists", lists);
//            map.put("hasBigDecimal", true);
//            map.put("mainPath", mainPath);
//            map.put("package", config.get("package").getModelVal());
//            map.put("moduleName", config.get("moduleName").getModelVal());
//            map.put("author", config.get("author").getModelVal());
//            map.put("email", config.get("email").getModelVal());
//            map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
            tableEntity = GenUtils.readerTable(tableEntity,maps,lists,config,true,map);
            map.put("moduleName", tableEntity.getModulesName());
            config.get("moduleName").setModelVal(tableEntity.getModulesName());
            //生成代码
            //设置velocity资源加载器
            Properties prop = new Properties();
            prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            Velocity.init(prop);
            String mainPath = config.get("mainPath").getModelVal();
            mainPath = StringUtils.isBlank(mainPath) ? "io.renren" : mainPath;
            String className = GenUtils.tableToJava(tableEntity.getTableName(), config.get("tablePrefix").getModelVal());
            tableEntity.setClassName(className);
            tableEntity.setClassname(StringUtils.uncapitalize(className));
            VelocityContext context = new VelocityContext(map);
            //获取模板列表
            //List<String> templates = getTemplates();
            //渲染模板
            for (GeneratorTemplateEntity template : templates) {
                //渲染模板
                StringWriter sw = new StringWriter();
                //   String str = "We are using $project $name to render this. $now";
                Velocity.evaluate(context, sw, "mystring", template.getText());
                try {
                    //添加到zip
                    zip.putNextEntry(new ZipEntry(GenUtils.getFileName(tableEntity.getClassName(), config, template,map)));
                    IOUtils.write(sw.toString(), zip, "UTF-8");
                    IOUtils.closeQuietly(sw);
                    zip.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RRException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
                }
            }
        }
        IOUtils.closeQuietly(zip);
        //def
        return outputStream.toByteArray();
    }

    @Override
    public Map<String, GeneratorTableEntity> queryTableFilePreviewVO(String[] ids) {
        List<GeneratorTableEntity> list = baseMapper.queryTableFilePreviewVO(ids);
        Map<String, GeneratorTableEntity> map = new HashMap<String, GeneratorTableEntity>();
        for (GeneratorTableEntity tab : list) {
            //搜索字段
            List<GeneratorTableFieldEntity> isSeekList = new ArrayList<>();
            //表格字段
            List<GeneratorTableFieldEntity> tableSetList = new ArrayList<>();
            //修改字段
            List<GeneratorTableFieldEntity> isSetList = new ArrayList<>();
            tab.setIsSeekList(isSeekList);
            tab.setIsSetList(isSetList);
            tab.setTableSetList(tableSetList);
            for (GeneratorTableFieldEntity field : tab.getColumns()) {
                String attrName = StringUtll.columnToJava(field.getFieldName());
                field.setFieldnames(field.getFieldName().replaceAll("_", ""));
                field.setFieldName(org.apache.commons.lang.StringUtils.uncapitalize(attrName));
                if (GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_TABLE_SET_0.equals(field.getTableSet())) {
                    tableSetList.add(CloneOper.deepCloneObject(field));
                }
                if (GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_IS_SET_0.equals(field.getIsSet())) {
                    isSetList.add(CloneOper.deepCloneObject(field));
                }
                if (GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_IS_SEEK_0.equals(field.getIsSeek())) {
                    isSeekList.add(CloneOper.deepCloneObject(field));
                }
            }
            map.put(tab.getTableName().replaceAll("_", ""), tab);
        }

        return map;
    }

    @Override
    @Transactional
    public void deleteTableBatchIds(List<Long> longs) {
        for (Long tableId : longs) {
            Map<String, Object> map = new HashMap<>();
            map.put("table_id", tableId);
            generatorTableFieldDao.deleteByMap(map);
            baseMapper.deleteById(tableId);
        }
    }
    @Autowired
    private GeneratorModulesService generatorModulesService;
    @Override
    public void synchronizationStructure(Long[] ids) {
        //查询数据
        EntityWrapper<GeneratorTableEntity> ew = new EntityWrapper<GeneratorTableEntity>();
        ew.in("id",ids);
        List<GeneratorTableEntity> list= baseMapper.selectList(ew);
        List<ColumnListEntity> lists = new ArrayList<ColumnListEntity>();
        for(GeneratorTableEntity item : list){
            item.setColumns(sysGeneratorDao.queryColumns(item.getTableName()));
            //查询列信息
            int i=item.getColumns().size();
            //查询当前表格数据
            Map<String,GeneratorTableFieldEntity> map= generatorTableFieldDao.selectFieldMap(item.getId());
            Map<String, GeneratorTemplateConfigEntity> config  = generatorTemplateConfigService.queryGeneratorTemplateConfig();
            Map<String,Object> obj = new HashMap<>();
            Map<String,Boolean> map1 = new HashMap<String,Boolean>();
            item=GenUtils.readerTable(item,map1,lists,config,false,obj);
            for(GeneratorTableFieldEntity co : item.getColumns()){
                if(map.get(co.getFieldName())==null){
                    i++;
                    generatorModulesService.insertTableField(co,i,item);
                }
            }
        }
    }

    @Override
    @Transactional
    public void insertEntity(GeneratorTableEntity generatorTable) {
        generatorTable.insert();
        //根据模块id查询模块名称
        GeneratorModulesEntity moduleName = generatorModulesDao.selectById(generatorTable.getModulesId());
        if(moduleName==null){
            throw new RRException("模块不存在");
        }
        String tabName= moduleName.getName()+"_"+generatorTable.getTableName();
        generatorTable.setTableName(tabName);
        //新增表
        if(baseMapper.tableExist(generatorTable.getTableName())){
            throw new RRException("您要创建的表格已经存在");
        }else{
            try{
                baseMapper.createTable(generatorTable);
            }catch (Exception e){
                baseMapper.deleteTable(generatorTable.getTableName());
                throw new RRException("建表语句有误");
            }

        }
        List<ColumnListEntity> lists = new ArrayList<ColumnListEntity>();
        Map<String,Boolean> map = new HashMap<String,Boolean>();
        Map<String, GeneratorTemplateConfigEntity> config  = generatorTemplateConfigService.queryGeneratorTemplateConfig();
        generatorModulesService.insertTable(generatorTable,lists,map,config);
    }
    /**
     * 修改
     * @param generatorTable
     */
    @Override
    public void updateEntity(GeneratorTableEntity generatorTable){
        generatorTable.update();
        baseMapper.updateById(generatorTable);
       // InitBusConfig.updateTabConfig(generatorTable.getClass().getAnnotation(TableName.class).value());
    }
    @Override
    public List<GeneratorBusConfigEntity> queryData(String tableName, String key, String value) {
        try{
        return baseMapper.queryData(tableName,key,value);
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<GeneratorBusConfigEntity>();
        }
    }

    @Override
    public GeneratorTableEntity queryTabeConfig(String module) {
        GeneratorTableEntity tab =baseMapper.queryTabeConfig(module);
        for(GeneratorTableFieldEntity field : tab.getColumns()){
            String attrName = StringUtll.columnToJava(field.getFieldName());
            field.setFieldName(org.apache.commons.lang.StringUtils.uncapitalize(attrName));
        }

        return tab;
    }

    @Override
    public void excelModule(String module) {

        String fileName = "员工信息表"; //模板名称
        String[] handers = {"姓名","性别","证件类型","证件号码","服务结束时间","参保地","民族"}; //列标题

        //下拉框数据
        List<String[]> downData = new ArrayList();
        String[] str1 = {"男","女","未知"};
        String[] str2 = {"北京","上海","广州","深圳","武汉","长沙","湘潭"};
        String[] str3 = {"01-汉族","02-蒙古族","03-回族","04-藏族","05-维吾尔族","06-苗族","07-彝族","08-壮族","09-布依族","10-朝鲜族","11-满族","12-侗族","13-瑶族","14-白族","15-土家族","16-哈尼族","17-哈萨克族","18-傣族","19-黎族","20-傈僳族",
                "21-佤族","22-畲族","23-高山族","24-拉祜族","25-水族","26-东乡族","27-纳西族","28-景颇族","29-柯尔克孜族","30-土族",
                "31-达斡尔族","32-仫佬族","33-羌族","34-布朗族","35-撒拉族","36-毛难族","37-仡佬族","38-锡伯族","39-阿昌族","40-普米族",
                "41-塔吉克族","42-怒族","43-乌孜别克族","44-俄罗斯族","45-鄂温克族","46-德昂族","47-保安族","48-裕固族","49-京族","50-塔塔尔族",
                "51-独龙族","52-鄂伦春族","53-赫哲族","54-门巴族","55-珞巴族","56-基诺族","98-外国血统","99-其他"};
        downData.add(str1);
        downData.add(str2);
        downData.add(str3);
        String [] downRows = {"1","5","6"}; //下拉的列序号数组(序号从0开始)

        try {

           // ExcelUtil.getExcelTemplate(fileName, handers, downData, downRows, request, response);

        } catch (Exception e) {
            log.error("批量导入信息异常：" + e.getMessage());
        }
    }

    @Override
    public List<GeneratorTableFieldEntity> fieldCopyConfig(Long leftId, Long rightId) {
        return generatorTableFieldDao.fieldCopyConfig(leftId,rightId);
    }

    @Override
    public void fieldCopyRun(Long id, String ids) {
        EntityWrapper<GeneratorTableFieldEntity> ew = new EntityWrapper<GeneratorTableFieldEntity>();
        List<Long> b = JSON.parseArray(ids,Long.class);
        ew.in("id",b);
       List<GeneratorTableFieldEntity> list =  generatorTableFieldDao.selectList(ew);
       for(GeneratorTableFieldEntity item : list){
           item.setTableId(id);
          generatorTableFieldService.insertEntity(item);
       }
    }

    @Override
    public List<MybatsMap> queryTreeConfigByKey(String tableName) {
          return baseMapper.queryTreeConfigByKey(tableName);
    }

    @Transactional
    @Override
    public R saveAlls(List<GeneratorTableEntity> list) {
        try{
            super.saveAll(list);
        }catch (RRException e){
            for(GeneratorTableEntity generatorTable :list){
                //根据模块id查询模块名称
                GeneratorModulesEntity moduleName = generatorModulesDao.selectById(generatorTable.getModulesId());
                if(moduleName==null){
                    throw new RRException("模块不存在");
                }
                GeneratorTableEntity generatorTable1 = new GeneratorTableEntity();
                generatorTable1.setTableName(generatorTable.getTableName());
                //如果数据库存在该表格则删除该表格
               if(baseMapper.tableExist(generatorTable.getTableName())){
                   //通过表名查询表格数据
                   generatorTable=baseMapper.selectOne(generatorTable1);
                   if(generatorTable!=null){
                   //删除表格数据
                   baseMapper.deleteById(generatorTable.getId());
                   EntityWrapper en = new  EntityWrapper();
                   en.eq("table_id",generatorTable.getId());
                   //删除字段数据
                   generatorTableFieldService.delete(en);
                   //删除业务数据
                   generatorBusConfigService.delete(en);
                   }

               }
            }
            return R.error("创建表格失败");
        }
        return R.ok();
    }
}
