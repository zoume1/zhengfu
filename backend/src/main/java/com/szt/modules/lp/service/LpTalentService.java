package com.szt.modules.lp.service;

import com.szt.common.CommonService;
import com.szt.modules.lp.entity.LpTalentEntity;

import java.util.Map;

/**
 * 人才库管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
public interface LpTalentService extends CommonService<LpTalentEntity> {

    /**
     * 审核人才
     * @param id
     * @param boo
     */
    void audit(Long id, boolean boo);
}