package com.szt.modules.lpgzh.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpActivityDao;
import com.szt.modules.lp.entity.LpActivityEntity;
import com.szt.modules.lpgzh.service.LpActivityService;
import lombok.extern.slf4j.Slf4j;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.Query;
import java.util.Map;
/**
 * 活动列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 10:18:58
 */
@Service("lpgzhlpActivityService")
public class LpActivityServiceImpl extends CommonServiceImpl<LpActivityDao, LpActivityEntity> implements LpActivityService {



}
