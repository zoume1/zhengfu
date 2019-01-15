package com.szt.modules.job.constant;

/**
 * 定时任务日志管理常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 18:14:06
 */
public interface  ScheduleJobLogConstant{
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - schedule_job_log_delete_flag
     */
    //存在
    String SCHEDULE_JOB_LOG_DELETE_FLAG_0 = "0";
    //隐藏
    String SCHEDULE_JOB_LOG_DELETE_FLAG_1 = "1";
    //删除
    String SCHEDULE_JOB_LOG_DELETE_FLAG_2 = "2";
    //停用
    String SCHEDULE_JOB_LOG_DELETE_FLAG_3 = "3";
}
