package com.szt.modules.lppc.service.impl;

import com.szt.common.CommonServiceImpl;
import com.szt.common.exception.RRException;
import com.szt.config.RedisUtil;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.generator.entity.GeneratorTableFieldEntity;
import com.szt.modules.lp.constant.LpUserConstant;
import com.szt.modules.lp.dao.LpUserDao;
import com.szt.modules.lp.entity.LpUserEntity;
import com.szt.modules.lppc.interceptor.AnalysisPcActuatorAspect;
import com.szt.modules.lppc.service.LpUserService;
import com.szt.modules.sys.oauth2.TokenGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 会员管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:28
 */
@Service("lppclpUserService")
public class LpUserServiceImpl extends CommonServiceImpl<LpUserDao, LpUserEntity> implements LpUserService {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public LpUserEntity login(String userName, String password) {
        //判断用户是否存在
        LpUserEntity user = new LpUserEntity();
        user.setUserName(userName);
        user = baseMapper.selectOne(user);

        if (user == null) {
            throw new RRException("用户账号或密码错误!");
        }

        if (!user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
            throw new RRException("用户账号或密码错误!");
        }

        String token = TokenGenerator.generateValue();
        user.setToken(token);
        user.setPassword(null);
        user.setSalt(null);
        //将用户信息存入到redis中
        redisUtil.set(AnalysisPcActuatorAspect.TOKEN + token, user, AnalysisPcActuatorAspect.TOCKEN_EXPIRE);

        return user;
    }

    @Override
    public void register(LpUserEntity user) {

    }

}
