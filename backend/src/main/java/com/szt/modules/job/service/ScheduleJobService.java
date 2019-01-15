package com.szt.modules.job.service;

import com.szt.common.CommonService;
import com.szt.common.utils.PageUtils;
import com.szt.modules.job.entity.ScheduleJobEntity;

import java.util.List;
import java.util.Map;

/**
 * 定时任务管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 17:51:32
 */
public interface ScheduleJobService extends CommonService<ScheduleJobEntity> {
    /**
     * 批量更新定时任务状态
     */
    void updateBatch(Long[] jobIds, String status);

    /**
     * 立即执行
     */
    void run(Long[] jobIds);

    /**
     * 暂停运行
     */
    void pause(Long[] jobIds);

    /**
     * 恢复运行
     */
    void resume(Long[] jobIds);

    /**
     * 新增定时任务
     * @param scheduleJob
     */
    void insertSchedule(ScheduleJobEntity scheduleJob);

    /**
     * 修改定时任务
     * @param scheduleJob
     */
    void updateSchedule(ScheduleJobEntity scheduleJob);

    /**
     * 删除定时任务
     * @param longs
     */
    void deleteSchedule(List<Long> longs);
}