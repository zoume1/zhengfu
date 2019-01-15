package com.szt.modules.lppc.service;

import com.szt.common.CommonService;
import com.szt.modules.lp.entity.LpOrganizersEntity;

import java.util.Map;

/**
 * 活动人员
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:28
 */
public interface LpOrganizersService extends CommonService<LpOrganizersEntity> {

    /**
     * 用户报名
     * @param id
     */
    void insertEntity(Long id);
}