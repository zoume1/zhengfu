package com.szt.modules.lppc.service;

import com.szt.common.CommonService;
import com.szt.modules.lp.entity.LpArticleEntity;
import com.szt.modules.lp.entity.LpColumnEntity;

import java.util.List;
import java.util.Map;

/**
 * 文章管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:29
 */
public interface LpArticleService extends CommonService<LpArticleEntity> {

    /**
     * 查询首页文章数据
     * @return
     */
    List<LpColumnEntity> searchHomeArticle();

    /**
     * 动态通知
     * @return
     */
    List<LpColumnEntity> dynamicNotification();

    /**
     * 阅读文章
     * @param id
     * @return
     */
    LpArticleEntity info(Long id);
}