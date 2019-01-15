package com.szt.modules.lp.constant;

/**
 * 活动列表常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
public interface  LpActivityConstant{
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - lp_activity_delete_flag
     */
    //存在
    String LP_ACTIVITY_DELETE_FLAG_0 = "0";
    //隐藏
    String LP_ACTIVITY_DELETE_FLAG_1 = "1";
    //删除
    String LP_ACTIVITY_DELETE_FLAG_2 = "2";
    //停用
    String LP_ACTIVITY_DELETE_FLAG_3 = "3";
    /**
     * 活动状态@0-未开始,1-进行中,2-已结束 - lp_activity_state
     */
    //未开始
    String LP_ACTIVITY_STATE_0 = "0";
    //进行中
    String LP_ACTIVITY_STATE_1 = "1";
    //已结束
    String LP_ACTIVITY_STATE_2 = "2";
    /**
     * 审核状态@0-待审核,1-已通过,2-拒绝 - lp_activity_audit_state
     */
    //待审核
    String LP_ACTIVITY_AUDIT_STATE_0 = "0";
    //已通过
    String LP_ACTIVITY_AUDIT_STATE_1 = "1";
    //拒绝
    String LP_ACTIVITY_AUDIT_STATE_2 = "2";
}
