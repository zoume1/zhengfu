package com.szt.modules.lp.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpArticleDao;
import com.szt.modules.lp.entity.LpArticleEntity;
import com.szt.modules.lp.service.LpArticleService;
import lombok.extern.slf4j.Slf4j;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.Query;
import java.util.Map;
/**
 * 文章管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Service("lplpArticleService")
public class LpArticleServiceImpl extends CommonServiceImpl<LpArticleDao, LpArticleEntity> implements LpArticleService {



}
