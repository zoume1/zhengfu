package com.szt.modules.generator.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.szt.common.CommonServiceImpl;
import com.szt.common.exception.RRException;
import com.szt.common.exception.SqlException;
import com.szt.common.utils.GenUtils;
import com.szt.modules.generator.constant.GeneratorTableFieldConstant;
import com.szt.modules.generator.dao.GeneratorModulesDao;
import com.szt.modules.generator.dao.SysGeneratorDao;
import com.szt.modules.generator.entity.*;
import com.szt.modules.generator.service.*;
import com.szt.modules.sys.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.szt.modules.generator.constant.GeneratorTableFieldConstant.*;

/**
 * 模块管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-27 19:01:10
 */
@Slf4j
@Service("generatorModulesService")
public class GeneratorModulesServiceImpl extends CommonServiceImpl<GeneratorModulesDao, GeneratorModulesEntity> implements GeneratorModulesService {
    @Autowired
    private SysGeneratorDao sysGeneratorDao;
    @Autowired
    private GeneratorBusConfigService generatorBusConfigService;
    @Autowired
    private GeneratorTemplateConfigService generatorTemplateConfigService;
    @Autowired
    private GeneratorTableFieldService generatorTableFieldService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private GeneratorTableService generatorTableService;
    @Autowired
    private GeneratorModulesDao generatorModulesDao;

    @Override
    public List<GeneratorModulesEntity> queryGeneratorModulesList() {
        Wrapper wrapper = Condition.create();
        wrapper.eq("delete_flag", "0");
        return baseMapper.selectList(wrapper);
    }

    @Transactional
    @Override
    public void generatorCode(List<GeneratorTableEntity> tableNames) {
        List<ColumnListEntity> lists = new ArrayList<ColumnListEntity>();
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        Map<String, GeneratorTemplateConfigEntity> config = generatorTemplateConfigService.queryGeneratorTemplateConfig();
        for (GeneratorTableEntity tableName : tableNames) {
            insertTable(tableName, lists, map, config);
        }
    }

    @Override
    public void insertTable(GeneratorTableEntity tableName, List<ColumnListEntity> lists, Map<String, Boolean> map, Map<String, GeneratorTemplateConfigEntity> config) {
        //查询表信息
        GeneratorTableEntity tab = sysGeneratorDao.queryTable(tableName.getTableName());
        //查询列信息
        List<GeneratorTableFieldEntity> columns = sysGeneratorDao.queryColumns(tableName.getTableName());
        tab.setColumns(columns);
        Map<String, Object> obj = new HashMap<>();
        tab = GenUtils.readerTable(tab, map, lists, config, false, obj);
        GeneratorTableEntity t = new GeneratorTableEntity();
        t.insert();
        t.setTableComment(tab.getTableComment());
        t.setTableName(tab.getTableName());
        t.setModulesId(tableName.getModulesId());
        generatorTableService.insert(t);

        //根据模块id查询模块名称
        GeneratorModulesEntity moduleName = generatorModulesDao.selectById(tableName.getModulesId());
        if (moduleName == null) {
            throw new SqlException("模块不存在");
        }
        //保存权限
        sysMenuService.insertPermission((String) obj.get("comments"), moduleName.getName(), (String) obj.get("pathName"));
        int i = 30;
        for (GeneratorTableFieldEntity fieldEntity : tab.getColumns()) {
           if( "sort".equals(fieldEntity.getFieldName()) ||  "create_time".equals(fieldEntity.getFieldName())){
               fieldEntity.setTableSet(GENERATOR_TABLE_FIELD_TABLE_SET_0);
           }else{
               fieldEntity.setTableSet(GENERATOR_TABLE_FIELD_TABLE_SET_1);
           }
            if( "sort".equals(fieldEntity.getFieldName())){
                fieldEntity.setIsSet(GENERATOR_TABLE_FIELD_IS_SET_0);
            }else{
                fieldEntity.setIsSet(GENERATOR_TABLE_FIELD_IS_SET_1);
            }
            this.insertTableField(fieldEntity, i++, t);
        }

    }

    /**
     * 保存字段
     *
     * @param fieldEntity
     * @param i
     * @param t
     */
    @Override
    public void insertTableField(GeneratorTableFieldEntity fieldEntity, int i, GeneratorTableEntity t) {
        if (fieldEntity.getSelectKey() != null) {
            generatorBusConfigService.insertSysBusConfigPar(fieldEntity.getSelectKey(), fieldEntity.getList(),t.getId());
        }
        ///GeneratorTableFieldEntity tableEntity = new GeneratorTableFieldEntity();
        fieldEntity.insert();
        fieldEntity.setDictionaryIndex((t.getTableName() + "_" + fieldEntity.getFieldName()));
        fieldEntity.setSort(i);
        fieldEntity.setTableId(t.getId());
        if(fieldEntity.getDataLength()==null && fieldEntity.getColumnType()!=null) {
            if(fieldEntity.getColumnType().indexOf("(")!=-1){
                fieldEntity.setDataLength( fieldEntity.getColumnType().substring(fieldEntity.getColumnType().indexOf("(")+1,fieldEntity.getColumnType().indexOf(")")));
            }else{
                fieldEntity.setDataLength("0");
            }
        }
        if (fieldEntity.getDeleteFlag() == null) {
            fieldEntity.setDeleteFlag(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_DELETE_FLAG_0);
        }
        if (fieldEntity.getIsExport() == null) {
            fieldEntity.setIsExport(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_IS_EXPORT_1);
        }
        if(fieldEntity.getIsSeek()==null){
        fieldEntity.setIsSeek(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_IS_EXPORT_1);
        }
        if(fieldEntity.getTableSet()==null){
            fieldEntity.setTableSet(GENERATOR_TABLE_FIELD_TABLE_SET_0);
        }
        if(fieldEntity.getIsDataBase()==null){
        fieldEntity.setIsDataBase(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_IS_DATA_BASE_0);
        }
        if(fieldEntity.getIsSet()==null){
         fieldEntity.setIsSet(GENERATOR_TABLE_FIELD_IS_SET_0);
        }
        if(fieldEntity.getIsUpdate()==null){
            fieldEntity.setIsUpdate(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_IS_UPDATE_0);
        }
        fieldEntity.setDataType(fieldEntity.getFieldType());
        Map<String, GeneratorBusConfigEntity> map = generatorBusConfigService.querySysBusConfigByCodeKey("generator_table_field_field_type");
        for (Map.Entry<String, GeneratorBusConfigEntity> item : map.entrySet()) {
            if (item.getValue().getConfName().equals(fieldEntity.getDataType())) {
                fieldEntity.setFieldType(item.getValue().getConfVue());
                break;
            }
        }
        //判断上拉
        if(fieldEntity.getInputType()==null){
            if (fieldEntity.getAttrType().equals("Date")) {
                fieldEntity.setInputType(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_INPUT_TYPE_2);
            } else if (fieldEntity.getAttrType().equals("Integer")) {
                fieldEntity.setInputType(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_INPUT_TYPE_1);
            } //判断是否下拉
            else if (fieldEntity.getSelectKey() != null) {
                if (fieldEntity.getComment().indexOf("@") != -1) {
                    fieldEntity.setInputType(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_INPUT_TYPE_4);
                } else {
                    fieldEntity.setInputType(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_INPUT_TYPE_5);
                }
            } else {
                fieldEntity.setInputType(GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_INPUT_TYPE_0);
            }
        }
        generatorTableFieldService.insert(fieldEntity);
    }
}
