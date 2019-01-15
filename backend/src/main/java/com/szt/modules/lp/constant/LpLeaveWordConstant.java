package com.szt.modules.lp.constant;

/**
 * 在线交流常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
public interface  LpLeaveWordConstant{
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - lp_leave_word_delete_flag
     */
    //存在
    String LP_LEAVE_WORD_DELETE_FLAG_0 = "0";
    //隐藏
    String LP_LEAVE_WORD_DELETE_FLAG_1 = "1";
    //删除
    String LP_LEAVE_WORD_DELETE_FLAG_2 = "2";
    //停用
    String LP_LEAVE_WORD_DELETE_FLAG_3 = "3";
    /**
     * 性别@0-女,1-男,2-保密 - lp_leave_word_sex
     */
    //女
    String LP_LEAVE_WORD_SEX_0 = "0";
    //男
    String LP_LEAVE_WORD_SEX_1 = "1";
    //保密
    String LP_LEAVE_WORD_SEX_2 = "2";
    /**
     * 审核状态@0-待答复,1-已答复 - lp_leave_word_state
     */
    //待答复
    String LP_LEAVE_WORD_STATE_0 = "0";
    //已答复
    String LP_LEAVE_WORD_STATE_1 = "1";
}
