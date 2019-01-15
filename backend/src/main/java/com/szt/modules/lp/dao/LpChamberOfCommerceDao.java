package com.szt.modules.lp.dao;

import com.szt.modules.lp.entity.LpChamberOfCommerceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商会列表
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-22 17:08:35
 */
@Mapper
public interface LpChamberOfCommerceDao extends BaseMapper<LpChamberOfCommerceEntity> {
    String fileds="        id,        remarks,        version_no,        create_by,        create_time,        update_by,        update_time,        delete_flag,        sort,        name,        sys_user_id,        category,        grade,        standing_director_size,        director_size,        member_size,        vice_chairman_size,        secretary_size,        phone,        special_plane,        e_mail,        postcode,        credit_code,        website,        established_time,        group_administrative_region,        group_fox,        legal_person,        chairman_name,        president_name,        secretary_general_name,        contact,        personal_call,        address,        introduce";

}
