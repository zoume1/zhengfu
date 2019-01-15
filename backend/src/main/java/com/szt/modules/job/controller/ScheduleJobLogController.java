package com.szt.modules.job.controller;

import java.util.Arrays;
import java.util.Map;
import com.szt.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.job.entity.ScheduleJobLogEntity;
import com.szt.modules.job.service.ScheduleJobLogService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 定时任务日志管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 18:14:06
 */
@Slf4j
@Api(value = "定时任务日志管理接口", tags = "定时任务日志管理接口")
@RestController
@RequestMapping("job/schedulejoblog")
@Controller("jobschedulejoblog")
public class ScheduleJobLogController {
    @Autowired
    private ScheduleJobLogService scheduleJobLogService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("job:schedulejoblog:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = scheduleJobLogService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("job:schedulejoblog:info")
    public R info(@PathVariable("id") Long id) {
            ScheduleJobLogEntity scheduleJobLog = scheduleJobLogService.selectById(id);

        return R.ok().put("data", scheduleJobLog);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("job:schedulejoblog:save")
    public R save(@RequestBody ScheduleJobLogEntity scheduleJobLog) {
             scheduleJobLog.insert();
            //校验类型
            ValidatorUtils.validateEntity(scheduleJobLog);
            scheduleJobLogService.insert(scheduleJobLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("job:schedulejoblog:update")
    public R update(@RequestBody ScheduleJobLogEntity scheduleJobLog) {
            scheduleJobLog.update();
            //校验类型
             ValidatorUtils.validateEntity(scheduleJobLog);
            scheduleJobLogService.updateById(scheduleJobLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("job:schedulejoblog:delete")
    public R delete(@RequestBody Long[]ids) {
            scheduleJobLogService.deleteBatchIds(Arrays.asList(ids));
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
        scheduleJobLogService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",scheduleJobLogService.selectTableConfig());
    }
}
