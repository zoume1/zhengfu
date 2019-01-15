package com.szt.common.utils;

import com.szt.modules.sys.entity.SysUserEntity;
import com.szt.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;

public class AdminUserUtils {
    public static SysUserEntity getUser() {
        return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    public static Long getUserId() {
        return getUser().getId();
    }
}
