package com.szt.modules.lp.constant;

/**
 * 文章管理常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
public interface  LpArticleConstant{
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - lp_article_delete_flag
     */
    //存在
    String LP_ARTICLE_DELETE_FLAG_0 = "0";
    //隐藏
    String LP_ARTICLE_DELETE_FLAG_1 = "1";
    //删除
    String LP_ARTICLE_DELETE_FLAG_2 = "2";
    //停用
    String LP_ARTICLE_DELETE_FLAG_3 = "3";
    /**
     * 文章类型@0-文章,1-上传表格 - lp_article_type
     */
    //文章
    String LP_ARTICLE_TYPE_0 = "0";
    //上传表格
    String LP_ARTICLE_TYPE_1 = "1";
    /**
     * 状态@0-启用,1-禁用 - lp_article_state
     */
    //启用
    String LP_ARTICLE_STATE_0 = "0";
    //禁用
    String LP_ARTICLE_STATE_1 = "1";
}
