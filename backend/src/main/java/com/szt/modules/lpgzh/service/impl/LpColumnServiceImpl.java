package com.szt.modules.lpgzh.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpColumnDao;
import com.szt.modules.lp.entity.LpColumnEntity;
import com.szt.modules.lpgzh.service.LpColumnService;
import lombok.extern.slf4j.Slf4j;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.Query;
import java.util.Map;
/**
 * 栏目管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 10:18:58
 */
@Service("lpgzhlpColumnService")
public class LpColumnServiceImpl extends CommonServiceImpl<LpColumnDao, LpColumnEntity> implements LpColumnService {



}
