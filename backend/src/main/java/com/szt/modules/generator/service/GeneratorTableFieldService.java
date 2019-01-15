package com.szt.modules.generator.service;

import com.szt.common.CommonService;
import com.szt.common.utils.R;
import com.szt.modules.generator.entity.GeneratorTableFieldEntity;

import java.util.List;
import java.util.Map;

/**
 * 字段管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-13 12:52:07
 */
public interface GeneratorTableFieldService extends CommonService<GeneratorTableFieldEntity> {

    /**
     * 批量隐藏表格字段
     * @param longs
     */
    void hideTableField(List<Long> longs);

    /**
     * 批量隐藏设置字段
     * @param longs
     */
    void hideSetField(List<Long> longs);

    /**
     * 显示导出字段
     * @param longs
     */
    void showExportField(List<Long> longs);

    /**
     * 显示搜索字段
     * @param longs
     */
    void showSeekField(List<Long> longs);

    /**
     * 增加字段
     * @param generatorTableField
     */
    void insertEntity(GeneratorTableFieldEntity generatorTableField);

    /**
     * 删除字段
     * @param longs
     */
    void deleteFields(List<Long> longs);

    /**
     * 刷新表格索引
     */
    void tabFieldIndexReload();

    /**
     * 刷新表格字段
     */
    void tabFieldTypeReload();

    /**
     * 刷新字段表格的数据长度
     */
    void updateDataLength();

    /**
     * 行政批量数据
     * @param list
     * @return
     */
    R saveAlls(List<GeneratorTableFieldEntity> list);
}