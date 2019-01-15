package com.szt.modules.sys.constant;

/**
 * 系统日志管理常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 20:14:29
 */
public interface  SysLogConstant{
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - sys_log_delete_flag
     */
    //存在
    String SYS_LOG_DELETE_FLAG_0 = "0";
    //隐藏
    String SYS_LOG_DELETE_FLAG_1 = "1";
    //删除
    String SYS_LOG_DELETE_FLAG_2 = "2";
    //停用
    String SYS_LOG_DELETE_FLAG_3 = "3";
}
