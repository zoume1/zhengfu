package com.szt.modules.generator.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import com.szt.common.CommonServiceImpl;
import com.szt.common.exception.RRException;
import com.szt.common.exception.SqlException;
import com.szt.common.utils.GenUtils;
import com.szt.common.utils.R;
import com.szt.common.utils.StringUtll;
import com.szt.modules.generator.constant.GeneratorTableFieldConstant;
import com.szt.modules.generator.dao.GeneratorModulesDao;
import com.szt.modules.generator.dao.GeneratorTableFieldDao;
import com.szt.modules.generator.dao.SysGeneratorDao;
import com.szt.modules.generator.entity.*;
import com.szt.modules.generator.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字段管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-13 12:52:07
 */
@Slf4j
@Service("generatorTableFieldService")
public class GeneratorTableFieldServiceImpl extends CommonServiceImpl<GeneratorTableFieldDao, GeneratorTableFieldEntity> implements GeneratorTableFieldService {
    @Autowired
    private GeneratorTableService generatorTableService;
    @Autowired
    private SysGeneratorDao sysGeneratorDao;
    @Autowired
    private GeneratorTableFieldService generatorTableFieldService;
    @Autowired
    private GeneratorModulesService generatorModulesService;
    @Autowired
    private GeneratorTemplateConfigService generatorTemplateConfigService;
    @Autowired
    private GeneratorBusConfigService generatorBusConfigService;
    @Autowired
    private GeneratorModulesDao generatorModulesDao;
    @Override
    @Transactional
    public void hideTableField(List<Long> longs) {
        for (Long id : longs) {
            GeneratorTableFieldEntity entity = new GeneratorTableFieldEntity();
            entity.setId(id);
            entity.setTableSet(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_TABLE_SET_1);
            this.updateEntity(entity);
        }
    }

    @Override
    @Transactional
    public void hideSetField(List<Long> longs) {
        for (Long id : longs) {
            GeneratorTableFieldEntity entity = new GeneratorTableFieldEntity();
            entity.setId(id);
            entity.setIsSet(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_IS_SET_1);
            this.updateEntity(entity);
        }
    }

    @Override
    @Transactional
    public void showExportField(List<Long> longs) {
        for (Long id : longs) {
            GeneratorTableFieldEntity entity = new GeneratorTableFieldEntity();
            entity.setId(id);
            entity.setIsExport(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_IS_EXPORT_0);
            this.updateEntity(entity);
        }
    }

    @Override
    @Transactional
    public void showSeekField(List<Long> longs) {
        for (Long id : longs) {
            GeneratorTableFieldEntity entity = new GeneratorTableFieldEntity();
            entity.setId(id);
            entity.setIsSeek(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_IS_SEEK_0);
            this.updateEntity(entity);
        }
    }

    @Override
    @Transactional(rollbackFor={Exception.class,MySQLSyntaxErrorException.class})
    public void insertEntity(GeneratorTableFieldEntity generatorTableField) {
        GeneratorTableEntity tab = generatorTableService.selectById(generatorTableField.getTableId());
        if (tab == null) {
            throw new RRException("您的表不存在");
        }
        //查询字段类型
        Map<String, GeneratorBusConfigEntity> map =  generatorBusConfigService.querySysBusConfigByCodeKey("generator_table_field_field_type");
        for(Map.Entry<String, GeneratorBusConfigEntity> item : map.entrySet()){
            if(item.getValue().getConfVue().equals(generatorTableField.getFieldType())){
                generatorTableField.setDataType(item.getKey());
                break;
            }
        }
        //设置字段数据
        generatorTableField.setTabName(tab.getTableName());
        //设置索引
        if(generatorTableField.getDictionaryIndex()==null){
            generatorTableField.setDictionaryIndex(tab.getTableName()+"_"+generatorTableField.getFieldName());
        }
        generatorTableField.insert();
        //判断是否为数据库字段,增加到数据库
        if (GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_IS_DATA_BASE_0.equals(generatorTableField.getIsDataBase())) {
            if(baseMapper.fieldExist(generatorTableField.getFieldName(),tab.getTableName())){
                throw  new RRException("字段已经存在");
            }else{
                try{
                    baseMapper.addField(generatorTableField);
                }catch (Exception e){
                    //删除字段
                    baseMapper.deleteFields(tab.getTableName(),generatorTableField.getFieldName());
                }
            }
        }
        //查询列信息
        List<GeneratorTableFieldEntity> columns =new ArrayList<>();
        columns.add(generatorTableField);
        tab.setColumns(columns);
        List<ColumnListEntity> lists = new ArrayList<ColumnListEntity>();
        Map<String, GeneratorTemplateConfigEntity> config  = generatorTemplateConfigService.queryGeneratorTemplateConfig();
        Map<String,Boolean> obj = new HashMap<>();
        GenUtils.parseTableField(generatorTableField,tab,lists,obj,false,config);
        generatorModulesService.insertTableField(generatorTableField,1,tab);
    }

    @Override
    @Transactional
    public void deleteFields(List<Long> longs) {
        for (Long lo : longs) {
            //查询字段信息
            GeneratorTableFieldEntity generatorTableField = generatorTableFieldService.selectById(lo);
            //查询表信息
            GeneratorTableEntity tab = generatorTableService.selectById(generatorTableField.getTableId());
            if (tab == null) {
                throw new RRException("您的表不存在");
            }
            generatorTableField.setTabName(tab.getTableName());
//            //删除业务数据
//            Wrapper<GeneratorBusConfigEntity> ew=new EntityWrapper<GeneratorBusConfigEntity>();
//            ew.eq("table_id",tab.getId());
//            generatorBusConfigService.delete(ew);
            //判断是否为数据库字段
            if (GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_IS_DATA_BASE_0.equals(generatorTableField.getIsDataBase())) {
                baseMapper.deleteFields(tab.getTableName(),generatorTableField.getFieldName());
            }

        }
        baseMapper.deleteBatchIds(longs);

    }

    @Override
    public void tabFieldIndexReload() {
        baseMapper.tabFieldIndexReload();
    }

    @Override
    @Transactional
    public void tabFieldTypeReload() {
        List<GeneratorTableFieldEntity> list = baseMapper.selectList(null);
        for(GeneratorTableFieldEntity item : list){
            try{
                //判断是否为数字
                Integer.parseInt(item.getFieldType());
            }catch (Exception e){
                EntityWrapper<GeneratorBusConfigEntity> ew = new EntityWrapper<>();
                ew.eq("conf_code","generator_table_field_field_type");
                List<GeneratorBusConfigEntity> types =generatorBusConfigService.selectList(ew);;
                for(GeneratorBusConfigEntity type : types){
                    if(type.getConfName().equals(item.getFieldType())){
                        item.setFieldType(type.getConfVue());
                        baseMapper.updateById(item);
                        break;
                    }
                }
            }

        }
    }

    @Override
    public void updateDataLength() {
       Map<String, GeneratorTableEntity> tab =  generatorTableService.queryTableFilePreviewVO(null);
       for(Map.Entry<String, GeneratorTableEntity> map : tab.entrySet()){
           GeneratorTableEntity tableName = map.getValue();
           //查询列信息
           Map<String, GeneratorTableFieldEntity> columnsMap = sysGeneratorDao.queryColumnsMap(tableName.getTableName());
           Map<String,GeneratorTableFieldEntity> fielMap = new HashMap<>();
           for(Map.Entry<String, GeneratorTableFieldEntity> a : columnsMap.entrySet()){
               String attrName = StringUtll.columnToJava(a.getKey());
               fielMap.put(org.apache.commons.lang.StringUtils.uncapitalize(attrName),a.getValue());
           }
           for(GeneratorTableFieldEntity fieldEntity : tableName.getColumns()){
               String columnType=fielMap.get(fieldEntity.getFieldName()).getColumnType();
               if(columnType.indexOf("(")!=-1){
                   fieldEntity.setDataLength( columnType.substring(columnType.indexOf("(")+1,columnType.indexOf(")")));
               }else{
                   fieldEntity.setDataLength("0");
               }

               GeneratorTableFieldEntity gefe = new GeneratorTableFieldEntity();
               gefe.setId(fieldEntity.getId());
               if(fieldEntity.getIsNull().equals("1")){
                   gefe.setCheckout("[\"1\"]");
               }else{
                   gefe.setCheckout("[]");
               }
               gefe.setDataLength(fieldEntity.getDataLength());
               generatorTableFieldService.updateEntity(gefe);
           }
       }
    }

    @Override
    public void updateEntity(GeneratorTableFieldEntity entity){
        entity.update();
        baseMapper.updateById(entity);

        //InitBusConfig.updateTabConfig(generatorTableService.selectById(baseMapper.selectById(entity).getTableId()).getTableName());
    }

    @Override
    @Transactional
    public R saveAlls(List<GeneratorTableFieldEntity> list) {
        try{
            super.saveAll(list);
        }catch (SqlException e){
            for(GeneratorTableFieldEntity field :list){
                //根据模块id查询模块名称
                GeneratorTableEntity tab = generatorTableService.selectById(field.getTableId());
                GeneratorTableFieldEntity field1 = new GeneratorTableFieldEntity();
                field1.setTabName(tab.getTableName());
                field1.setFieldName(field.getFieldName());
                //如果数据库存在该表格则删除该表格
                if(baseMapper.fieldExist(field.getFieldName(), tab.getTableName())){
                    //通过通过字段名查询字段数据查询表格数据
                    field=baseMapper.selectOne(field1);
                    if(field!=null){
                        //删除字段数据
                        generatorTableFieldService.deleteById(field);
                        //删除业务数据
                        EntityWrapper<GeneratorBusConfigEntity> en = new EntityWrapper<GeneratorBusConfigEntity>();
                        en.like("conf_code",tab.getTableName()+"_"+field.getFieldName());
                        generatorBusConfigService.delete(en);
                    }

                }
            }
            return R.error("新增字段失败!");
        }
        return R.ok();
    }
}
