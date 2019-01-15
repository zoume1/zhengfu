package com.szt.modules.generator.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.generator.entity.GeneratorTableFieldEntity;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月19日 下午3:32:04
 */
@Mapper
public interface SysGeneratorDao {
	
	List<Map<String, Object>> queryList(Page<Map<String, Object>> page, Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	GeneratorTableEntity queryTable(String tableName);
	
	List<GeneratorTableFieldEntity> queryColumns(String tableName);
	@Select("select * from information_schema.tables")
	Map<String, String> queryTables();
	@MapKey("fieldName")
    Map<String,GeneratorTableFieldEntity> queryColumnsMap(String tableName);
}
