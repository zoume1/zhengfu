package com.szt.modules.sys.service.impl;

import com.szt.common.exception.RRException;
import com.szt.modules.sys.constant.SysUserConstant;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.sys.dao.SysUserDao;
import com.szt.modules.sys.entity.SysUserEntity;
import com.szt.modules.sys.service.SysUserService;

/**
 * 后端用户管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-09-30 21:24:29
 */
@Service("syssysUserService")
public class SysUserServiceImpl extends CommonServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    public SysUserEntity queryByUserName(String username) {
        return baseMapper.queryByUserName(username);
    }

    @Override
    public void insertEntity(SysUserEntity entity) {
        SysUserEntity users = new SysUserEntity();
        users.setUsername(entity.getUsername());
        users=baseMapper.selectOne(users);
        if(users!=null){
            throw new RRException("用户名已存在");
        }
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        entity.setPassword(new Sha256Hash(entity.getPassword(), salt).toHex());
        entity.setSalt(salt);
        long id = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getId();
        entity.setCreateBy(id);
        entity.setUpdateBy(id);
        super.insertEntity(entity);
    }

    @Override
    public void updateEntity(SysUserEntity entity) {
        long id = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getId();
        entity.setUpdateBy(id);
        if(StringUtils.isBlank(entity.getPassword())){
            entity.setPassword(null);
        }else{
            entity.setPassword(new Sha256Hash(entity.getPassword(), entity.getSalt()).toHex());
        }
        super.updateEntity(entity);
    }
}
