package com.szt.modules.job.dao;

import com.szt.modules.job.entity.ScheduleJobLogEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志管理
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 18:14:06
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {


}
