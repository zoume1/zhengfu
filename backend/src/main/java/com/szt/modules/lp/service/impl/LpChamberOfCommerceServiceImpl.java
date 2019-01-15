package com.szt.modules.lp.service.impl;

import com.szt.common.exception.RRException;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.lp.vo.SysUserLpChamberOfCommerceVO;
import com.szt.modules.sys.constant.SysUserConstant;
import com.szt.modules.sys.entity.SysUserEntity;
import com.szt.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpChamberOfCommerceDao;
import com.szt.modules.lp.entity.LpChamberOfCommerceEntity;
import com.szt.modules.lp.service.LpChamberOfCommerceService;
import lombok.extern.slf4j.Slf4j;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 商会列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-22 17:08:35
 */
@Service("lplpChamberOfCommerceService")
public class LpChamberOfCommerceServiceImpl extends CommonServiceImpl<LpChamberOfCommerceDao, LpChamberOfCommerceEntity> implements LpChamberOfCommerceService {
    @Autowired
    private SysUserService sysUserService;

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    @Override
    @Transactional
    public void insertEntity(SysUserLpChamberOfCommerceVO vo) {
        vo.getUser().setRoleIdJson("[24]");
        vo.getUser().setUserType(SysUserConstant.SYS_USER_USER_TYPE_1);
        SysUserEntity user = new SysUserEntity();
        user.setUsername(vo.getUser().getUsername());
        if(sysUserService.queryByUserName(vo.getUser().getUsername())!=null){
            throw new RRException("用户名已存在");
        }
        //保存后台用户信息
        sysUserService.insertEntity(vo.getUser());
        vo.getCommerce().setSysUserId(vo.getUser().getId());
        //保存商户用户信息
        vo.getCommerce().insert();
        baseMapper.insert(vo.getCommerce());
    }

    @Override
    public Object selectTableConfig(String type) {
        if(type==null){
            return super.selectTableConfig();
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("user",sysUserService.selectTableConfig());
            map.put("chamberOfCommerce",super.selectTableConfig());
            return map;
        }
    }

    @Override
    public Object info(Long id) {
        Map<String,Object> map = new HashMap<String,Object>();
        LpChamberOfCommerceEntity com=  baseMapper.selectById(id);
        SysUserEntity user =sysUserService.selectById(com.getSysUserId());
        user.setPassword(null);
        map.put("user",user);
        map.put("chamberOfCommerce",com);
        return map;
    }

    @Override
    public void updateEntity(SysUserLpChamberOfCommerceVO vo) {
        vo.getUser().setUserType(SysUserConstant.SYS_USER_USER_TYPE_1);
        //保存后台用户信息
        sysUserService.updateEntity(vo.getUser());
        vo.getCommerce().setSysUserId(vo.getUser().getId());
        //保存商户用户信息
        vo.getCommerce().update();
        super.updateById(vo.getCommerce());
    }
}
