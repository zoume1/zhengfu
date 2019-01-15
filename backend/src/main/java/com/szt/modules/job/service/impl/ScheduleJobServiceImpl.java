package com.szt.modules.job.service.impl;

import com.szt.common.utils.Constant;
import com.szt.modules.job.utils.ScheduleUtils;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.job.dao.ScheduleJobDao;
import com.szt.modules.job.entity.ScheduleJobEntity;
import com.szt.modules.job.service.ScheduleJobService;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 定时任务管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 17:51:32
 */
@Service("jobscheduleJobService")
public class ScheduleJobServiceImpl extends CommonServiceImpl<ScheduleJobDao, ScheduleJobEntity> implements ScheduleJobService {
//    @Override
//    public PageUtils queryPage(Map<String, Object> params,Wrapper<ScheduleJobEntity> wrapper) {
//        Page<ScheduleJobEntity> page = this.selectPage( new Query<ScheduleJobEntity>(params).getPage(),wrapper  );
//        return new PageUtils(page);
//    }

    @Override
    public void insertSchedule(ScheduleJobEntity scheduleJob) {
        scheduleJob.setStatus(Constant.ScheduleStatus.NORMAL.getValue()+"");
        schedulerJobDao.insert(scheduleJob);
        ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
    }

    @Override
    public void updateSchedule(ScheduleJobEntity scheduleJob) {
        ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
        schedulerJobDao.updateById(scheduleJob);
    }

    @Override
    public void deleteSchedule(List<Long> jobIds) {
        for(Long jobId : jobIds){
            ScheduleUtils.deleteScheduleJob(scheduler, jobId);
        }

        //删除数据
        schedulerJobDao.deleteBatchIds(jobIds);
    }

    @Autowired
    private Scheduler scheduler;
    @Autowired
    private ScheduleJobDao schedulerJobDao;
    @Transactional
    public void run(Long[] jobIds) {
        for(Long jobId : jobIds){
            ScheduleJobEntity job=selectById(jobId);
            ScheduleUtils.run(scheduler,job );
        }
    }

    @Transactional
    public void pause(Long[] jobIds) {
        for(Long jobId : jobIds){
            ScheduleUtils.pauseJob(scheduler, jobId);
        }
        updateBatch(jobIds, Constant.ScheduleStatus.PAUSE.getValue()+"");
    }
    @Transactional
    public void updateBatch(Long[] jobIds, String status){
        Map<String, Object> map = new HashMap<>();
        for(Long id : jobIds){
            ScheduleJobEntity entity = new ScheduleJobEntity();
            entity.setId(id);
            entity.setStatus(status);
            this.updateById(entity);
        }
    }
    @Transactional
    public void resume(Long[] jobIds) {
        for(Long jobId : jobIds){
            ScheduleUtils.resumeJob(scheduler, jobId);
        }
        updateBatch(jobIds, Constant.ScheduleStatus.NORMAL.getValue()+"");
    }


}
