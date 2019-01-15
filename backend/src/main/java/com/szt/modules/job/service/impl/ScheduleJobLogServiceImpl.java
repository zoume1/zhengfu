package com.szt.modules.job.service.impl;

import org.springframework.stereotype.Service;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.job.dao.ScheduleJobLogDao;
import com.szt.modules.job.entity.ScheduleJobLogEntity;
import com.szt.modules.job.service.ScheduleJobLogService;

/**
 * 定时任务日志管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 18:14:06
 */
@Service("jobscheduleJobLogService")
public class ScheduleJobLogServiceImpl extends CommonServiceImpl<ScheduleJobLogDao, ScheduleJobLogEntity> implements ScheduleJobLogService {



}
