package com.szt.modules.lppc.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpTalentDao;
import com.szt.modules.lp.entity.LpTalentEntity;
import com.szt.modules.lppc.service.LpTalentService;
import lombok.extern.slf4j.Slf4j;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.Query;
import java.util.Map;
/**
 * 人才库管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:28
 */
@Service("lppclpTalentService")
public class LpTalentServiceImpl extends CommonServiceImpl<LpTalentDao, LpTalentEntity> implements LpTalentService {



}
