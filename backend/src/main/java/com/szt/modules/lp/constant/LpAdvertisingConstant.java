package com.szt.modules.lp.constant;

/**
 * 广告管理常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
public interface  LpAdvertisingConstant{
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - lp_advertising_delete_flag
     */
    //存在
    String LP_ADVERTISING_DELETE_FLAG_0 = "0";
    //隐藏
    String LP_ADVERTISING_DELETE_FLAG_1 = "1";
    //删除
    String LP_ADVERTISING_DELETE_FLAG_2 = "2";
    //停用
    String LP_ADVERTISING_DELETE_FLAG_3 = "3";
    /**
     * 摆放区@0-首页轮播图,1-首页中部广告图 - lp_advertising_type
     */
    //首页轮播图
    String LP_ADVERTISING_TYPE_0 = "0";
    //首页中部广告图
    String LP_ADVERTISING_TYPE_1 = "1";
}
