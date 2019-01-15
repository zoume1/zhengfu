package com.szt.modules.sys.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.szt.modules.sys.entity.SysPbAreaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 地址管理
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-08-20 00:11:07
 */
@Mapper
public interface SysPbAreaDao extends BaseMapper<SysPbAreaEntity> {


    List<SysPbAreaEntity> queryList(Page<SysPbAreaEntity> page, Map<String,Object> params);
}
