package com.szt.modules.sys.constant;

/**
 * 系统验证码常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-11-15 09:19:36
 */
public interface  SysCaptchaConstant{
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - sys_captcha_delete_flag
     */
    //存在
    String SYS_CAPTCHA_DELETE_FLAG_0 = "0";
    //隐藏
    String SYS_CAPTCHA_DELETE_FLAG_1 = "1";
    //删除
    String SYS_CAPTCHA_DELETE_FLAG_2 = "2";
    //停用
    String SYS_CAPTCHA_DELETE_FLAG_3 = "3";
}
