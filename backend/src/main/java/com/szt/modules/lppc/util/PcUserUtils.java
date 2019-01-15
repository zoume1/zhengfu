package com.szt.modules.lppc.util;

import com.szt.modules.lp.entity.LpUserEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class PcUserUtils {
    public static String PC_USER_KEY = "PC_USER_KEY";
    public static LpUserEntity getUser() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return (LpUserEntity) attrs.getRequest().getAttribute(PC_USER_KEY);
    }

    public static void setUser(LpUserEntity user) {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        attrs.getRequest().setAttribute(PC_USER_KEY, user);
    }

    public static Long getUserId() {
        return getUser().getId();
    }

}
