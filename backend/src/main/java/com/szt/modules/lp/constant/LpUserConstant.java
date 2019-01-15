package com.szt.modules.lp.constant;

/**
 * 会员列表常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-28 03:39:33
 */
public interface  LpUserConstant{
    /**
     * 用户级别@0-市级工商联级别,1-分会/县级商会级别,2-县级工商联级别 - lp_user_grade
     */
    //市级工商联级别
    String LP_USER_GRADE_0 = "0";
    //分会/县级商会级别
    String LP_USER_GRADE_1 = "1";
    //县级工商联级别
    String LP_USER_GRADE_2 = "2";
    /**
     * 证件类型@0-身份证,1-护照,2-军人证,3-驾驶证,4-工作证,5-学生证,6-户口本,7-暂住证,8-警官证,9-单位介绍信,10-营业执照,11-武警身份证,12-港澳居民来往内地通行证,13-台湾居民来往大陆通行证,14-事业单位法人证书,15-其他 - lp_user_papers_type
     */
    //身份证
    String LP_USER_PAPERS_TYPE_0 = "0";
    //护照
    String LP_USER_PAPERS_TYPE_1 = "1";
    //军人证
    String LP_USER_PAPERS_TYPE_2 = "2";
    //驾驶证
    String LP_USER_PAPERS_TYPE_3 = "3";
    //工作证
    String LP_USER_PAPERS_TYPE_4 = "4";
    //学生证
    String LP_USER_PAPERS_TYPE_5 = "5";
    //户口本
    String LP_USER_PAPERS_TYPE_6 = "6";
    //暂住证
    String LP_USER_PAPERS_TYPE_7 = "7";
    //警官证
    String LP_USER_PAPERS_TYPE_8 = "8";
    //单位介绍信
    String LP_USER_PAPERS_TYPE_9 = "9";
    //营业执照
    String LP_USER_PAPERS_TYPE_10 = "10";
    //武警身份证
    String LP_USER_PAPERS_TYPE_11 = "11";
    //港澳居民来往内地通行证
    String LP_USER_PAPERS_TYPE_12 = "12";
    //台湾居民来往大陆通行证
    String LP_USER_PAPERS_TYPE_13 = "13";
    //事业单位法人证书
    String LP_USER_PAPERS_TYPE_14 = "14";
    //其他
    String LP_USER_PAPERS_TYPE_15 = "15";
    /**
     * 学历@0-研究生,1-本科生,2-大专生,3-中专及以下 - lp_user_education
     */
    //研究生
    String LP_USER_EDUCATION_0 = "0";
    //本科生
    String LP_USER_EDUCATION_1 = "1";
    //大专生
    String LP_USER_EDUCATION_2 = "2";
    //中专及以下
    String LP_USER_EDUCATION_3 = "3";
    /**
     * 企业规模@0-大型,1-中型,2-小型,3-微型 - lp_user_scale
     */
    //大型
    String LP_USER_SCALE_0 = "0";
    //中型
    String LP_USER_SCALE_1 = "1";
    //小型
    String LP_USER_SCALE_2 = "2";
    //微型
    String LP_USER_SCALE_3 = "3";
    /**
     * 团体会员分类@0-私营企业协会,1-个体劳动者协会,2-乡镇企业协会,3-行业商(协)会,4-乡镇商会,5-街道商会,6-村商会,7-异地商会,8-市场商会,9-园区商会,10-楼宇商会,11-外企协会,12-其他 - lp_user_group_category
     */
    //私营企业协会
    String LP_USER_GROUP_CATEGORY_0 = "0";
    //个体劳动者协会
    String LP_USER_GROUP_CATEGORY_1 = "1";
    //乡镇企业协会
    String LP_USER_GROUP_CATEGORY_2 = "2";
    //行业商(协)会
    String LP_USER_GROUP_CATEGORY_3 = "3";
    //乡镇商会
    String LP_USER_GROUP_CATEGORY_4 = "4";
    //街道商会
    String LP_USER_GROUP_CATEGORY_5 = "5";
    //村商会
    String LP_USER_GROUP_CATEGORY_6 = "6";
    //异地商会
    String LP_USER_GROUP_CATEGORY_7 = "7";
    //市场商会
    String LP_USER_GROUP_CATEGORY_8 = "8";
    //园区商会
    String LP_USER_GROUP_CATEGORY_9 = "9";
    //楼宇商会
    String LP_USER_GROUP_CATEGORY_10 = "10";
    //外企协会
    String LP_USER_GROUP_CATEGORY_11 = "11";
    //其他
    String LP_USER_GROUP_CATEGORY_12 = "12";
    /**
     * 是否被认证为高新技术企业@0-是,1-否 - lp_user_is_advanced_technology
     */
    //是
    String LP_USER_IS_ADVANCED_TECHNOLOGY_0 = "0";
    //否
    String LP_USER_IS_ADVANCED_TECHNOLOGY_1 = "1";
    /**
     * 用户类型@0-个人会员,1-企业会员,2-团体会员 - lp_user_user_type
     */
    //个人会员
    String LP_USER_USER_TYPE_0 = "0";
    //企业会员
    String LP_USER_USER_TYPE_1 = "1";
    //团体会员
    String LP_USER_USER_TYPE_2 = "2";
    /**
     * 状态@0-正常,1-禁用 - lp_user_state
     */
    //正常
    String LP_USER_STATE_0 = "0";
    //禁用
    String LP_USER_STATE_1 = "1";
    /**
     * 性别@0-女,1-男 - lp_user_sex
     */
    //女
    String LP_USER_SEX_0 = "0";
    //男
    String LP_USER_SEX_1 = "1";
    /**
     * 政治面貌@0-中共党员,1-中共预备党员,2-共青团员,3-民革党员,4-民盟盟员,5-民建会员,6-民进会员,7-农工党党员,8-致公党党员,9-九三学社社员,10-台盟盟员,11-无党派人士,12-群众 - lp_user_politics_status
     */
    //中共党员
    String LP_USER_POLITICS_STATUS_0 = "0";
    //中共预备党员
    String LP_USER_POLITICS_STATUS_1 = "1";
    //共青团员
    String LP_USER_POLITICS_STATUS_2 = "2";
    //民革党员
    String LP_USER_POLITICS_STATUS_3 = "3";
    //民盟盟员
    String LP_USER_POLITICS_STATUS_4 = "4";
    //民建会员
    String LP_USER_POLITICS_STATUS_5 = "5";
    //民进会员
    String LP_USER_POLITICS_STATUS_6 = "6";
    //农工党党员
    String LP_USER_POLITICS_STATUS_7 = "7";
    //致公党党员
    String LP_USER_POLITICS_STATUS_8 = "8";
    //九三学社社员
    String LP_USER_POLITICS_STATUS_9 = "9";
    //台盟盟员
    String LP_USER_POLITICS_STATUS_10 = "10";
    //无党派人士
    String LP_USER_POLITICS_STATUS_11 = "11";
    //群众
    String LP_USER_POLITICS_STATUS_12 = "12";
    /**
     * 工商登记注册类型@0-私营独资企业,1-私营合伙企业,2-私营有限责任公司,3-私营股份有限公司,4-港澳台合资企业,5-港澳台合作企业,6-港澳台独资企业,7-港澳台股份有限公司,8-中外合资企业,9-中外合作企业,10-外资企业,11-外商股份有限公司,12-国有企业,13-集体企业,14-股份合作企业,15-联营企业,16-其他有限责任公司,17-其他股份有限公司,18-其他企业 - lp_user_industry_type
     */
    //私营独资企业
    String LP_USER_INDUSTRY_TYPE_0 = "0";
    //私营合伙企业
    String LP_USER_INDUSTRY_TYPE_1 = "1";
    //私营有限责任公司
    String LP_USER_INDUSTRY_TYPE_2 = "2";
    //私营股份有限公司
    String LP_USER_INDUSTRY_TYPE_3 = "3";
    //港澳台合资企业
    String LP_USER_INDUSTRY_TYPE_4 = "4";
    //港澳台合作企业
    String LP_USER_INDUSTRY_TYPE_5 = "5";
    //港澳台独资企业
    String LP_USER_INDUSTRY_TYPE_6 = "6";
    //港澳台股份有限公司
    String LP_USER_INDUSTRY_TYPE_7 = "7";
    //中外合资企业
    String LP_USER_INDUSTRY_TYPE_8 = "8";
    //中外合作企业
    String LP_USER_INDUSTRY_TYPE_9 = "9";
    //外资企业
    String LP_USER_INDUSTRY_TYPE_10 = "10";
    //外商股份有限公司
    String LP_USER_INDUSTRY_TYPE_11 = "11";
    //国有企业
    String LP_USER_INDUSTRY_TYPE_12 = "12";
    //集体企业
    String LP_USER_INDUSTRY_TYPE_13 = "13";
    //股份合作企业
    String LP_USER_INDUSTRY_TYPE_14 = "14";
    //联营企业
    String LP_USER_INDUSTRY_TYPE_15 = "15";
    //其他有限责任公司
    String LP_USER_INDUSTRY_TYPE_16 = "16";
    //其他股份有限公司
    String LP_USER_INDUSTRY_TYPE_17 = "17";
    //其他企业
    String LP_USER_INDUSTRY_TYPE_18 = "18";
    /**
     * 其他企业代码类型@0-工商营业执照注册号,1-企业税务登记证号,2-组织机构代码 - lp_user_enterprise_code_type
     */
    //工商营业执照注册号
    String LP_USER_ENTERPRISE_CODE_TYPE_0 = "0";
    //企业税务登记证号
    String LP_USER_ENTERPRISE_CODE_TYPE_1 = "1";
    //组织机构代码
    String LP_USER_ENTERPRISE_CODE_TYPE_2 = "2";
    /**
     * 行业分类@0-农林、牧、渔业,1-采矿业,2-制造业,3-电力热力、燃气及水生产和供应业,4-建筑业,5-批发和零售业,6-交通运输、仓储和邮政业,7-住宿和餐饮业,8-信息传输、软件和信息技术服务业,9-金融业,10-房地产业,11-租赁和商务服务业,12-科学研究和技术服务业,13-水利、环境和公共设施管理业,14-居民服务、修理和其他服务业,15-教育,16-卫生和社会工作,17-文化、体育和娱乐业,18-公共管理、社会保障和社会组织 - lp_user_classification_of_industry
     */
    //农林、牧、渔业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_0 = "0";
    //采矿业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_1 = "1";
    //制造业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_2 = "2";
    //电力热力、燃气及水生产和供应业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_3 = "3";
    //建筑业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_4 = "4";
    //批发和零售业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_5 = "5";
    //交通运输、仓储和邮政业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_6 = "6";
    //住宿和餐饮业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_7 = "7";
    //信息传输、软件和信息技术服务业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_8 = "8";
    //金融业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_9 = "9";
    //房地产业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_10 = "10";
    //租赁和商务服务业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_11 = "11";
    //科学研究和技术服务业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_12 = "12";
    //水利、环境和公共设施管理业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_13 = "13";
    //居民服务、修理和其他服务业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_14 = "14";
    //教育
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_15 = "15";
    //卫生和社会工作
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_16 = "16";
    //文化、体育和娱乐业
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_17 = "17";
    //公共管理、社会保障和社会组织
    String LP_USER_CLASSIFICATION_OF_INDUSTRY_18 = "18";
    /**
     * 信用级别@0-是,1-否 - lp_user_credit_ratings
     */
    //是
    String LP_USER_CREDIT_RATINGS_0 = "0";
    //否
    String LP_USER_CREDIT_RATINGS_1 = "1";
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - lp_user_delete_flag
     */
    //存在
    String LP_USER_DELETE_FLAG_0 = "0";
    //隐藏
    String LP_USER_DELETE_FLAG_1 = "1";
    //删除
    String LP_USER_DELETE_FLAG_2 = "2";
    //停用
    String LP_USER_DELETE_FLAG_3 = "3";
}
