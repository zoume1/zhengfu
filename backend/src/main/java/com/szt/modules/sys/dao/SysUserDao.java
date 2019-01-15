package com.szt.modules.sys.dao;

import com.szt.modules.sys.entity.SysUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 后端用户管理
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-09-30 21:24:29
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    /**
     * 根据用户名，查询系统用户
     */
    SysUserEntity queryByUserName(String username);
}
