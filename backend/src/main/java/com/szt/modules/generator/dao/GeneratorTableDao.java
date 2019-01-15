package com.szt.modules.generator.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.szt.common.utils.MybatsMap;
import com.szt.modules.generator.entity.GeneratorBusConfigEntity;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 数据表管理
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-13 12:44:03
 */
@Mapper
public interface GeneratorTableDao extends BaseMapper<GeneratorTableEntity> {
    /**
     * 查询表格与字段的结果集
     * @param longs
     * @return
     */
    List<GeneratorTableEntity> queryTableFieldVO(List<Long> longs);

    List<GeneratorTableEntity> selectPageList(Page<GeneratorTableEntity> page, Map<String,Object> params);

    List<GeneratorTableEntity> queryTableFilePreviewVO(String[] list);

    /**
     * 创建数据表
     * @param generatorTable
     */
    void createTable(GeneratorTableEntity generatorTable);

    /**
     * 查询数据
     *
     *
     * @param tableName
     * @param key
     * @param value
     * @return
     */
    @Select("select  ${value} confVue,${key} confName  from ${tableName} group by confName")
    List<GeneratorBusConfigEntity> queryData(@Param("tableName") String tableName, @Param("key") String key, @Param("value") String value);

    GeneratorTableEntity queryTabeConfig(@Param("module")String module);
    @Select("select  * from ${tableName} ")
    List<MybatsMap> queryTreeConfigByKey(@Param("tableName")String tableName);


    void deleteTable(@Param("tabName") String tabName);
    @Select("select count(1) from information_schema.TABLES t where  t.TABLE_NAME = '${tableName}'")
    Boolean tableExist(@Param("tableName") String tableName);

    GeneratorTableEntity selectTableConfig(@Param("tabName") String tabName);

    GeneratorTableEntity lpUserTable0(@Param("tabName") String tabName);
}
