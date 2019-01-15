package com.szt.modules.lppc.service;

import com.szt.common.CommonService;
import com.szt.modules.lp.entity.LpActivityEntity;

/**
 * 活动列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:29
 */
public interface LpActivityService extends CommonService<LpActivityEntity> {
    /**
     * 阅读活动
     * @param id
     */
    LpActivityEntity reader(Long id);
}