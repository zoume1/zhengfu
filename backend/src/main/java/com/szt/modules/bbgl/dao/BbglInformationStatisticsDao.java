package com.szt.modules.bbgl.dao;

import com.szt.modules.bbgl.entity.BbglInformationStatisticsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员情况综合统计
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-30 12:00:32
 */
@Mapper
public interface BbglInformationStatisticsDao extends BaseMapper<BbglInformationStatisticsEntity> {
    String fileds="        id,        remarks,        version_no,        create_by,        create_time,        update_by,        update_time,        delete_flag,        sort";

}
