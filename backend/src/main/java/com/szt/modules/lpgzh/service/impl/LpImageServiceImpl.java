package com.szt.modules.lpgzh.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpImageDao;
import com.szt.modules.lp.entity.LpImageEntity;
import com.szt.modules.lpgzh.service.LpImageService;
import lombok.extern.slf4j.Slf4j;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.Query;
import java.util.Map;
/**
 * 图片列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 10:18:57
 */
@Service("lpgzhlpImageService")
public class LpImageServiceImpl extends CommonServiceImpl<LpImageDao, LpImageEntity> implements LpImageService {



}
