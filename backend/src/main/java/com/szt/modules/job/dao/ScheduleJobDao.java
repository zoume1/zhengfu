package com.szt.modules.job.dao;

import com.szt.modules.job.entity.ScheduleJobEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务管理
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 17:51:32
 */
@Mapper
public interface ScheduleJobDao extends BaseMapper<ScheduleJobEntity> {


}
