package com.szt.modules.lp.constant;

/**
 * 图片列表常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
public interface  LpImageConstant{
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - lp_image_delete_flag
     */
    //存在
    String LP_IMAGE_DELETE_FLAG_0 = "0";
    //隐藏
    String LP_IMAGE_DELETE_FLAG_1 = "1";
    //删除
    String LP_IMAGE_DELETE_FLAG_2 = "2";
    //停用
    String LP_IMAGE_DELETE_FLAG_3 = "3";
    /**
     * 摆放区@0-活动剪影,1-领导风采,2-资质荣誉,3-展销会 - lp_image_type
     */
    //活动剪影
    String LP_IMAGE_TYPE_0 = "0";
    //领导风采
    String LP_IMAGE_TYPE_1 = "1";
    //资质荣誉
    String LP_IMAGE_TYPE_2 = "2";
    //展销会
    String LP_IMAGE_TYPE_3 = "3";
}
