package com.szt.modules.lp.service;

import com.szt.common.CommonService;
import com.szt.modules.lp.entity.LpActivityEntity;

/**
 * 活动列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
public interface LpActivityService extends CommonService<LpActivityEntity> {

    /**
     * 审核活动
     * @param id
     * @param remake
     * @param boo
     */
    void audit(Long id, String remake, boolean boo);
}