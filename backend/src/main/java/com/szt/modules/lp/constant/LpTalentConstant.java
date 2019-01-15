package com.szt.modules.lp.constant;

/**
 * 人才库管理常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
public interface  LpTalentConstant{
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - lp_talent_delete_flag
     */
    //存在
    String LP_TALENT_DELETE_FLAG_0 = "0";
    //隐藏
    String LP_TALENT_DELETE_FLAG_1 = "1";
    //删除
    String LP_TALENT_DELETE_FLAG_2 = "2";
    //停用
    String LP_TALENT_DELETE_FLAG_3 = "3";
    /**
     * 性别@0-女,1-男,2保密 - lp_talent_sex
     */
    //女
    String LP_TALENT_SEX_0 = "0";
    //男
    String LP_TALENT_SEX_1 = "1";
    /**
     * 审核状态@0-待审核,1-已审核 - lp_talent_state
     */
    //待审核
    String LP_TALENT_STATE_0 = "0";
    //审核通过
    String LP_TALENT_STATE_1 = "1";
    //审核不通过
    String LP_TALENT_STATE_2 = "2";
}
