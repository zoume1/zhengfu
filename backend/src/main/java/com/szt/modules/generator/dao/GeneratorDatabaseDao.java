package com.szt.modules.generator.dao;

import com.szt.modules.generator.entity.GeneratorDatabaseEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据库列表
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-26 06:01:59
 */
@Mapper
public interface GeneratorDatabaseDao extends BaseMapper<GeneratorDatabaseEntity> {
	
}
