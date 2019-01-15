package com.szt.modules.lp.service.impl;

import com.szt.common.exception.RRException;
import com.szt.modules.lp.constant.LpActivityConstant;
import org.springframework.stereotype.Service;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpActivityDao;
import com.szt.modules.lp.entity.LpActivityEntity;
import com.szt.modules.lp.service.LpActivityService;

/**
 * 活动列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Service("lplpActivityService")
public class LpActivityServiceImpl extends CommonServiceImpl<LpActivityDao, LpActivityEntity> implements LpActivityService {




    @Override
    public void audit(Long id, String remake, boolean boo) {
        LpActivityEntity entity = baseMapper.selectById(id);
        if(entity==null){
            throw new RRException("活动不存在");
        }
        if(!LpActivityConstant.LP_ACTIVITY_AUDIT_STATE_0.equals(entity.getState())){
            throw new RRException("活动属于非审核状态");
        }
        entity.setAuditState(boo?LpActivityConstant.LP_ACTIVITY_AUDIT_STATE_1:LpActivityConstant.LP_ACTIVITY_AUDIT_STATE_2);
        entity.setRemarks(remake);
        baseMapper.updateById(entity);
    }
}
