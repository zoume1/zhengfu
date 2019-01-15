package com.szt.modules.lp.dao;

import com.szt.modules.lp.entity.LpArticleEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.szt.modules.lp.entity.LpColumnEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 文章管理
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Mapper
public interface LpArticleDao extends BaseMapper<LpArticleEntity> {
    String fileds="        id,        remarks,        version_no,        create_by,        create_time,        update_by,        update_time,        delete_flag,        sort,        title,        type,        state,        column_id,        source,        author,        center,        pageview";
    List<LpColumnEntity> searchHomeArticle();

    List<LpColumnEntity> dynamicNotification();
    @Update("update lp_article set pageview=pageview+1 where id=#{id}")
    void readerArticle(Long id);
}
