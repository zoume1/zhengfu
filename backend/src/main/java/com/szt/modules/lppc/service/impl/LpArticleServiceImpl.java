package com.szt.modules.lppc.service.impl;

import com.szt.modules.lp.entity.LpColumnEntity;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpArticleDao;
import com.szt.modules.lp.entity.LpArticleEntity;
import com.szt.modules.lppc.service.LpArticleService;
import lombok.extern.slf4j.Slf4j;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * 文章管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:29
 */
@Service("lppclpArticleService")
public class LpArticleServiceImpl extends CommonServiceImpl<LpArticleDao, LpArticleEntity> implements LpArticleService {
    @Override
    public List<LpColumnEntity> searchHomeArticle() {
        return baseMapper.searchHomeArticle();
    }

    @Override
    public List<LpColumnEntity> dynamicNotification() {
        return baseMapper.dynamicNotification();
    }

    @Override
    @Transactional
    public LpArticleEntity info(Long id) {
        baseMapper.readerArticle(id);
        return baseMapper.selectById(id);
    }


}
