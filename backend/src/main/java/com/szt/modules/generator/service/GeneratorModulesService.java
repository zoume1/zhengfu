package com.szt.modules.generator.service;

import com.szt.common.CommonService;
import com.szt.modules.generator.entity.*;

import java.util.List;
import java.util.Map;

/**
 * 模块管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-27 19:01:10
 */
public interface GeneratorModulesService extends CommonService<GeneratorModulesEntity> {

    /**
     * 查询所有显示的模块
     * @return
     */
    List<GeneratorModulesEntity> queryGeneratorModulesList();

    /**
     * 导入本地
     * @param tableNames
     */
    void generatorCode(List<GeneratorTableEntity> tableNames);

    /**
     * 保存表
     * @param tableName
     * @param lists
     * @param map
     * @param config
     */
    void insertTable(GeneratorTableEntity tableName, List<ColumnListEntity> lists, Map<String, Boolean> map, Map<String, GeneratorTemplateConfigEntity> config);

    /**
     * 插入字段
     * @param fieldEntity
     * @param i
     * @param t
     */
     void insertTableField(GeneratorTableFieldEntity fieldEntity, int i, GeneratorTableEntity t);
}

