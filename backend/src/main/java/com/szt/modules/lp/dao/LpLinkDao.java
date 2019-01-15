package com.szt.modules.lp.dao;

import com.szt.modules.lp.entity.LpLinkEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 底部友情链接设置
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Mapper
public interface LpLinkDao extends BaseMapper<LpLinkEntity> {
    String fileds="        id,        remarks,        version_no,        create_by,        create_time,        update_by,        update_time,        delete_flag,        sort,        pic,        href";

}
