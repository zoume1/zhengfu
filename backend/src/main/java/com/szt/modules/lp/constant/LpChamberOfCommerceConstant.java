package com.szt.modules.lp.constant;

/**
 * 商会列表常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-22 17:08:35
 */
public interface  LpChamberOfCommerceConstant{
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - lp_chamber_of_commerce_delete_flag
     */
    //存在
    String LP_CHAMBER_OF_COMMERCE_DELETE_FLAG_0 = "0";
    //隐藏
    String LP_CHAMBER_OF_COMMERCE_DELETE_FLAG_1 = "1";
    //删除
    String LP_CHAMBER_OF_COMMERCE_DELETE_FLAG_2 = "2";
    //停用
    String LP_CHAMBER_OF_COMMERCE_DELETE_FLAG_3 = "3";
    /**
     * 商会类别@0-行业商会,1-乡镇商会,2-街道商会,3-村商会,4-异地商会,5-市场商会,6-园区商会,7-楼宇商会,8-其他 - lp_chamber_of_commerce_category
     */
    //行业商会
    String LP_CHAMBER_OF_COMMERCE_CATEGORY_0 = "0";
    //乡镇商会
    String LP_CHAMBER_OF_COMMERCE_CATEGORY_1 = "1";
    //街道商会
    String LP_CHAMBER_OF_COMMERCE_CATEGORY_2 = "2";
    //村商会
    String LP_CHAMBER_OF_COMMERCE_CATEGORY_3 = "3";
    //异地商会
    String LP_CHAMBER_OF_COMMERCE_CATEGORY_4 = "4";
    //市场商会
    String LP_CHAMBER_OF_COMMERCE_CATEGORY_5 = "5";
    //园区商会
    String LP_CHAMBER_OF_COMMERCE_CATEGORY_6 = "6";
    //楼宇商会
    String LP_CHAMBER_OF_COMMERCE_CATEGORY_7 = "7";
    //其他
    String LP_CHAMBER_OF_COMMERCE_CATEGORY_8 = "8";
    /**
     * 商会归属用户级别@0-市级工商联会员,1-分会/县级商会会员 - lp_chamber_of_commerce_grade
     */
    //市级工商联会员
    String LP_CHAMBER_OF_COMMERCE_GRADE_0 = "0";
    //分会/县级商会会员
    String LP_CHAMBER_OF_COMMERCE_GRADE_1 = "1";
}
