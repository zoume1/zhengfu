package com.szt.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.szt.common.utils.AdminUserUtils;
import com.szt.common.utils.Constant;
import com.szt.modules.sys.dao.*;
import com.szt.modules.sys.entity.*;
import com.szt.modules.sys.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysUserTokenDao sysUserTokenDao;
    @Value("${spring.profiles.active}")
    private String active;
    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList = new ArrayList<String>();
        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN || active.equals("dev")){
            List<SysMenuEntity> menuList = sysMenuDao.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(SysMenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            EntityWrapper<SysRoleEntity> ews = new EntityWrapper<SysRoleEntity>();
            ews.in("id",JSON.parseArray(AdminUserUtils.getUser().getRoleIdJson(),Long.class));
            List<SysRoleEntity> roleList = sysRoleDao.selectList(ews);
            Set<Long> set = new HashSet<Long>();
            for(SysRoleEntity a : roleList){
                set.addAll(JSON.parseArray(a.getMenuIdJson(),Long.class));
            }
            EntityWrapper<SysMenuEntity> wr = new EntityWrapper<SysMenuEntity> ();
            //查询所有业务表
            wr.in("id",set);
            List<SysMenuEntity> menuList =  sysMenuDao.selectList(wr);
            permsList = new ArrayList<>(menuList.size());
            for(SysMenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserTokenEntity queryByToken(String token) {
        return sysUserTokenDao.queryByToken(token);
    }

    @Override
    public SysUserEntity queryUser(Long userId) {
        return sysUserDao.selectById(userId);
    }
}
