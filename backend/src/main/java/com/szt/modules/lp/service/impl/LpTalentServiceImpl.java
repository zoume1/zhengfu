package com.szt.modules.lp.service.impl;

import com.szt.common.exception.RRException;
import com.szt.modules.lp.constant.LpTalentConstant;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpTalentDao;
import com.szt.modules.lp.entity.LpTalentEntity;
import com.szt.modules.lp.service.LpTalentService;
import lombok.extern.slf4j.Slf4j;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.Query;

import java.util.Date;
import java.util.Map;
/**
 * 人才库管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Service("lplpTalentService")
public class LpTalentServiceImpl extends CommonServiceImpl<LpTalentDao, LpTalentEntity> implements LpTalentService {


    @Override
    public void audit(Long id, boolean boo) {
        LpTalentEntity entity = baseMapper.selectById(id);
        if(entity==null){
            throw new RRException("人才不存在");
        }
        entity.setState(boo?LpTalentConstant.LP_TALENT_STATE_1:LpTalentConstant.LP_TALENT_STATE_2);
        entity.setAuditTime(new Date());
        baseMapper.updateById(entity);
    }
}
