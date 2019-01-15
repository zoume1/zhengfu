package com.szt.modules.lppc.service.impl;

import com.szt.common.exception.RRException;
import com.szt.modules.lppc.util.PcUserUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpOrganizersDao;
import com.szt.modules.lp.entity.LpOrganizersEntity;
import com.szt.modules.lppc.service.LpOrganizersService;
import lombok.extern.slf4j.Slf4j;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.Query;
import java.util.Map;
/**
 * 活动人员
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:28
 */
@Service("lppclpOrganizersService")
public class LpOrganizersServiceImpl extends CommonServiceImpl<LpOrganizersDao, LpOrganizersEntity> implements LpOrganizersService {


    @Override
    public void insertEntity(Long id) {
        //获取用户id
        LpOrganizersEntity lpOrganizers = new LpOrganizersEntity();
        lpOrganizers.setUserId(PcUserUtils.getUserId());
        lpOrganizers.setActivityId(id);

        if(baseMapper.selectOne(lpOrganizers)!=null){
            throw new RRException("您已经报名了");
        }
        this.insertEntity(lpOrganizers);
    }
}
