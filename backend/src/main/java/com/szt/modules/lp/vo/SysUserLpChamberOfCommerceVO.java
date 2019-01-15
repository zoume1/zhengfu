package com.szt.modules.lp.vo;

import com.szt.modules.lp.entity.LpChamberOfCommerceEntity;
import com.szt.modules.sys.entity.SysUserEntity;

import java.io.Serializable;

public class SysUserLpChamberOfCommerceVO  implements Serializable {
    private SysUserEntity user;
    private LpChamberOfCommerceEntity commerce;

    public SysUserEntity getUser() {
        return user;
    }

    public void setUser(SysUserEntity user) {
        this.user = user;
    }

    public LpChamberOfCommerceEntity getCommerce() {
        return commerce;
    }

    public void setCommerce(LpChamberOfCommerceEntity commerce) {
        this.commerce = commerce;
    }
}
