package com.szt.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;
import com.szt.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.sys.entity.SysLogEntity;
import com.szt.modules.sys.service.SysLogService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 系统日志管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 20:14:29
 */
@Slf4j
@Api(value = "系统日志管理接口", tags = "系统日志管理接口")
@RestController
@RequestMapping("sys/syslog")
@Controller("syssyslog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:syslog:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysLogService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:syslog:info")
    public R info(@PathVariable("id") Long id) {
            SysLogEntity sysLog = sysLogService.selectById(id);

        return R.ok().put("data", sysLog);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("sys:syslog:save")
    public R save(@RequestBody SysLogEntity sysLog) {
             sysLog.insert();
            //校验类型
            ValidatorUtils.validateEntity(sysLog);
            sysLogService.insert(sysLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("sys:syslog:update")
    public R update(@RequestBody SysLogEntity sysLog) {
            sysLog.update();
            //校验类型
             ValidatorUtils.validateEntity(sysLog);
            sysLogService.updateById(sysLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("sys:syslog:delete")
    public R delete(@RequestBody Long[]ids) {
            sysLogService.deleteBatchIds(Arrays.asList(ids));
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
        sysLogService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",sysLogService.selectTableConfig());
    }
}
