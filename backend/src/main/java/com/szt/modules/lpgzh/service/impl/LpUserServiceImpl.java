package com.szt.modules.lpgzh.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpUserDao;
import com.szt.modules.lp.entity.LpUserEntity;
import com.szt.modules.lpgzh.service.LpUserService;
import lombok.extern.slf4j.Slf4j;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.Query;
import java.util.Map;
/**
 * 会员管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 10:18:56
 */
@Service("lpgzhlpUserService")
public class LpUserServiceImpl extends CommonServiceImpl<LpUserDao, LpUserEntity> implements LpUserService {



}
