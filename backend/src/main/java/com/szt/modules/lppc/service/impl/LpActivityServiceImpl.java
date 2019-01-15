package com.szt.modules.lppc.service.impl;

import com.szt.common.exception.RRException;
import org.springframework.stereotype.Service;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpActivityDao;
import com.szt.modules.lp.entity.LpActivityEntity;
import com.szt.modules.lppc.service.LpActivityService;

/**
 * 活动列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:29
 */
@Service("lppclpActivityService")
public class LpActivityServiceImpl extends CommonServiceImpl<LpActivityDao, LpActivityEntity> implements LpActivityService {


    @Override
    public LpActivityEntity reader(Long id) {
        LpActivityEntity data = baseMapper.selectById(id);
        if(data==null){
            throw new RRException("活动不存在");
        }
        baseMapper.reader(id);
        return data;
    }
}
