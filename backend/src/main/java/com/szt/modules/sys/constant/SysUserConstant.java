package com.szt.modules.sys.constant;

/**
 * 后端用户管理常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-22 18:33:45
 */
public interface  SysUserConstant{
    /**
     * 用户类型@0-系统用户,1-商会用户 - sys_user_user_type
     */
    //系统用户
    String SYS_USER_USER_TYPE_0 = "0";
    //商会用户
    String SYS_USER_USER_TYPE_1 = "1";
    /**
     * 用户状态@0-禁用,1-正常 - sys_user_status
     */
    //禁用
    String SYS_USER_STATUS_0 = "0";
    //正常
    String SYS_USER_STATUS_1 = "1";
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - sys_user_delete_flag
     */
    //存在
    String SYS_USER_DELETE_FLAG_0 = "0";
    //隐藏
    String SYS_USER_DELETE_FLAG_1 = "1";
    //删除
    String SYS_USER_DELETE_FLAG_2 = "2";
    //停用
    String SYS_USER_DELETE_FLAG_3 = "3";
}
