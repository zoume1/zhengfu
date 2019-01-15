package com.szt.modules.generator.dao;

import com.szt.modules.generator.entity.GeneratorTableFieldEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 字段管理
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-13 12:52:07
 */
@Mapper
public interface GeneratorTableFieldDao extends BaseMapper<GeneratorTableFieldEntity> {

    /**
     * 增加字段
     * @param generatorTableField
     */
    void addField(GeneratorTableFieldEntity generatorTableField);

    /**
     * 查询当前所有表格字段
     * @param id
     * @return
     */
    @Select("select * from generator_table_field f where f.table_id=#{id}")
    @MapKey("fieldName")
    Map<String,GeneratorTableFieldEntity> selectFieldMap(Long id);

    void deleteFields(@Param("tableName") String tableName,@Param("fieldName") String fieldName);

    /**
     * 刷新表格索引
     */
    @Update("update generator_table_field set dictionary_index= (select CONCAT(tb.table_name,'_',field_name) as nn from generator_table tb where  tb.id=table_id )")
    void tabFieldIndexReload();
    @Select("select id,field_name,comment from generator_table_field where\n" +
            "table_id=#{leftId} and field_name not in(\n" +
            "select field_name from generator_table_field where table_id=#{rightId});\n")
    List<GeneratorTableFieldEntity> fieldCopyConfig(@Param("leftId") Long leftId, @Param("rightId")Long rightId);
    @Select("select count(1) from information_schema.columns " +
            "  where table_name = '${tabName}' and table_schema = (select database()) and  column_name='${fieldName}'")
    boolean fieldExist(@Param("fieldName") String fieldName, @Param("tabName") String tabName);


}
