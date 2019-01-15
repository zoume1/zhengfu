package com.szt.modules.job.utils;

import com.szt.common.utils.SpringContextUtils;
import com.szt.modules.job.entity.ScheduleJobEntity;
import com.szt.modules.job.entity.ScheduleJobLogEntity;
import com.szt.modules.job.service.ScheduleJobLogService;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 定时任务
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月30日 下午12:44:21
 */
public class ScheduleJob extends QuartzJobBean {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ExecutorService service = Executors.newSingleThreadExecutor(); 
	
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    	Class<?> jobClass= context.getMergedJobDataMap().get(ScheduleJobEntity.JOB_PARAM_KEY).getClass();

		ScheduleJobEntity scheduleJob = (ScheduleJobEntity) context.getMergedJobDataMap().get(ScheduleJobEntity.JOB_PARAM_KEY);

        //获取spring bean
        ScheduleJobLogService scheduleJobLogService = (ScheduleJobLogService) SpringContextUtils.getBean("jobscheduleJobLogService");
        ScheduleJobLogEntity log = new ScheduleJobLogEntity();
        //任务开始时间
        long startTime = System.currentTimeMillis();
        try {
        //数据库保存执行记录

        log.setJobId(scheduleJob.getId());
        log.setBeanName(jobClass.getMethod("getBeanName").invoke(scheduleJob, null).toString());
        log.setMethodName(jobClass.getMethod("getMethodName").invoke(scheduleJob, null).toString());
        log.setParams(""+jobClass.getMethod("getParams").invoke(scheduleJob, null));
        log.setCreateTime(new Date());
   
            //执行任务
        	logger.info("任务准备执行，任务ID：" +scheduleJob.getId().toString());
            ScheduleRunnable task = new ScheduleRunnable(jobClass.getMethod("getBeanName").invoke(scheduleJob, null).toString(),
            		jobClass.getMethod("getMethodName").invoke(scheduleJob, null).toString(), 
            		jobClass.getMethod("getParams").invoke(scheduleJob, null)+"");
            Future<?> future = service.submit(task);

			future.get();

			//任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			log.setTimes((int)times);
			//任务状态    0：成功    1：失败
			log.setStatus(0);

			logger.info("任务执行完毕，任务ID：" + scheduleJob.getId().toString()+ "  总共耗时：" + times + "毫秒");
		} catch (Exception e) {
			try {
				logger.error("任务执行失败，任务ID：" + scheduleJob.getId().toString(), e);
			} catch (Exception e1) { } 
			//任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			log.setTimes((int)times);
			//任务状态    0：成功    1：失败
			log.setStatus(1);
			log.setError(StringUtils.substring(e.toString(), 0, 2000));
		}finally {
			log.insert();
			scheduleJobLogService.insert(log);
		}
    }
}
