package com.szt.modules.lppc.service.impl;

import com.szt.common.CommonServiceImpl;
import com.szt.common.exception.RRException;
import com.szt.modules.lp.dao.LpChamberOfCommerceDao;
import com.szt.modules.lp.entity.LpChamberOfCommerceEntity;
import com.szt.modules.lp.vo.SysUserLpChamberOfCommerceVO;
import com.szt.modules.lppc.service.LpChamberOfCommerceService;
import com.szt.modules.sys.constant.SysUserConstant;
import com.szt.modules.sys.entity.SysUserEntity;
import com.szt.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 商会列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-11-14 08:07:55
 */
@Service("lppclpChamberOfCommerceService")
public class LpChamberOfCommerceServiceImpl extends CommonServiceImpl<LpChamberOfCommerceDao, LpChamberOfCommerceEntity> implements LpChamberOfCommerceService {

}
