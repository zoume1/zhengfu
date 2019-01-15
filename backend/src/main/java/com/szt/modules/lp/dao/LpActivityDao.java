package com.szt.modules.lp.dao;

import com.szt.modules.lp.entity.LpActivityEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * 活动列表
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Mapper
public interface LpActivityDao extends BaseMapper<LpActivityEntity> {
    String fileds="        id,        remarks,        version_no,        create_by,        create_time,        update_by,        update_time,        delete_flag,        sort,        name,        state,        pageview,        apply_size,        apply_start_time,        apply_end_time,        audit_state,        user_id,        activity_time,        address,        content";

    @Update("update lp_activity set pageview=pageview+1 where id=#{id}")
    void reader(Long id);
}
