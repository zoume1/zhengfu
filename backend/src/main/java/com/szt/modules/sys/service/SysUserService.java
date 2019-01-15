package com.szt.modules.sys.service;

import com.szt.common.CommonService;
import com.szt.modules.sys.entity.SysUserEntity;

import java.util.Map;

/**
 * 后端用户管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-09-30 21:24:29
 */
public interface SysUserService extends CommonService<SysUserEntity> {

    /**
     * 根据用户名，查询系统用户
     */
    SysUserEntity queryByUserName(String username);

    /**
     * 创建后台用户
     * @param entity
     */
    @Override
    void insertEntity(SysUserEntity entity);

    @Override
    void updateEntity(SysUserEntity entity);
}