package com.szt.modules.generator.service;

import com.szt.common.CommonService;
import com.szt.common.utils.MybatsMap;
import com.szt.common.utils.R;
import com.szt.modules.generator.entity.GeneratorBusConfigEntity;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.generator.entity.GeneratorTableFieldEntity;

import java.util.List;
import java.util.Map;

/**
 * 数据表管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-13 12:44:03
 */
public interface GeneratorTableService extends CommonService<GeneratorTableEntity> {

    /**
     * 预览生成
     * @param tableId
     * @param id
     */
    String preview(Long tableId, Long id);

    /**
     * 生成代码
     * @param ids
     */
    byte[] generate(Long[] ids);

    /**
     * 查询所有表格数据
     * @param ids
     * @return
     */
    Map<String, GeneratorTableEntity> queryTableFilePreviewVO(String[] ids);

    /**
     * 批量删除
     * @param longs
     */
    void deleteTableBatchIds(List<Long> longs);

    /**
     * 同步数据库结构
     * @param ids
     * @return
     */
    void synchronizationStructure(Long[] ids);

    /**
     * 新增表
     * @param generatorTable
     */
    void insertEntity(GeneratorTableEntity generatorTable);

    /**
     * 查询业务数据
     * @param tableName
     * @param key
     * @param value
     * @return
     */
    List<GeneratorBusConfigEntity> queryData(String tableName, String key, String value);

    /**
     * 根据模块查询所需表格字段
     * @param module
     * @return
     */
    GeneratorTableEntity queryTabeConfig(String module);

    /**
     * 模板导出
     * @param module
     */
    void excelModule(String module);

    List<GeneratorTableFieldEntity> fieldCopyConfig(Long leftId, Long rightId);

    void fieldCopyRun(Long id, String ids);

    List<MybatsMap> queryTreeConfigByKey(String tableName);
    R saveAlls(List<GeneratorTableEntity> list);


}

