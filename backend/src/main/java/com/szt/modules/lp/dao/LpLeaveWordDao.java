package com.szt.modules.lp.dao;

import com.szt.modules.lp.entity.LpLeaveWordEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 在线交流
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Mapper
public interface LpLeaveWordDao extends BaseMapper<LpLeaveWordEntity> {
    String fileds="        id,        remarks,        version_no,        create_by,        create_time,        update_by,        update_time,        delete_flag,        sort,        user_id,        name,        source,        contact_way,        sex,        center,        state,        response";

}
