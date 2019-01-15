package com.szt.modules.lppc.service;

import com.szt.common.CommonService;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.lp.entity.LpUserEntity;

import java.util.Map;

/**
 * 会员管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:28
 */
public interface LpUserService extends CommonService<LpUserEntity> {

    /**
     * 官网登录发发
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    LpUserEntity login(String userName, String password);

    /**
     * 官网注册方法
     * @param user
     */
    void register(LpUserEntity user);


}