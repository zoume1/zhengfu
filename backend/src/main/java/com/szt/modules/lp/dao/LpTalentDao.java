package com.szt.modules.lp.dao;

import com.szt.modules.lp.entity.LpTalentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 人才库管理
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Mapper
public interface LpTalentDao extends BaseMapper<LpTalentEntity> {
    String fileds="        id,        remarks,        version_no,        create_by,        create_time,        update_by,        update_time,        delete_flag,        sort,        pic,        text,        name,        age,        sex,        interest,        speciality,        contact_way,        introduce,        state";

}
