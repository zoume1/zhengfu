package com.szt.modules.job.controller;

import java.util.Arrays;
import java.util.Map;
import com.szt.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.job.entity.ScheduleJobEntity;
import com.szt.modules.job.service.ScheduleJobService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 定时任务管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 17:51:32
 */
@Slf4j
@Api(value = "定时任务管理接口", tags = "定时任务管理接口")
@RestController
@RequestMapping("job/schedulejob")
@Controller("jobschedulejob")
public class ScheduleJobController {
    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("job:schedulejob:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = scheduleJobService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("job:schedulejob:info")
    public R info(@PathVariable("id") Long id) {
            ScheduleJobEntity scheduleJob = scheduleJobService.selectById(id);

        return R.ok().put("data", scheduleJob);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("job:schedulejob:save")
    public R save(@RequestBody ScheduleJobEntity scheduleJob) {
             scheduleJob.insert();
            //校验类型
            ValidatorUtils.validateEntity(scheduleJob);
            scheduleJobService.insertSchedule(scheduleJob);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("job:schedulejob:update")
    public R update(@RequestBody ScheduleJobEntity scheduleJob) {
            scheduleJob.update();
            //校验类型
             ValidatorUtils.validateEntity(scheduleJob);
            scheduleJobService.updateSchedule(scheduleJob);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("job:schedulejob:delete")
    public R delete(@RequestBody Long[]ids) {
            scheduleJobService.deleteSchedule(Arrays.asList(ids));
        return R.ok();
    }
    /**
     * 立即执行任务
     */
    @SysLog("立即执行任务")
    @RequestMapping("/run")
    @RequiresPermissions("job:schedulejob:run")
    public R run(@RequestBody Long[] jobIds){
        scheduleJobService.run(jobIds);
        return R.ok();
    }

    /**
     * 暂停定时任务
     */
    @SysLog("暂停定时任务")
    @RequestMapping("/pause")
    @RequiresPermissions("job:schedulejob:pause")
    public R pause(@RequestBody Long[] jobIds){
        scheduleJobService.pause(jobIds);
        return R.ok();
    }
    /**
     * 恢复定时任务
     */
    @SysLog("恢复定时任务")
    @RequestMapping("/resume")
    @RequiresPermissions("job:schedulejob:resume")
    public R resume(@RequestBody Long[] jobIds){
        scheduleJobService.resume(jobIds);
        return R.ok();
    }
    /**
     * 拖拽行排序
     */
    @ApiOperation("拖拽行排序")
    @PostMapping("/sort")
    public R sort(@RequestBody Long[]ids) {
        if(ids.length!=2){
            return R.error("数据错误");
        }
        scheduleJobService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",scheduleJobService.selectTableConfig());
    }
}
