package com.szt.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import com.szt.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.sys.entity.SysProtocolHistoryEntity;
import com.szt.modules.sys.service.SysProtocolHistoryService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 协议历史记录
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-08-21 18:20:21
 */
@Slf4j
@Api(value = "协议历史记录接口", tags = "协议历史记录接口")
@RestController
@RequestMapping("sys/sysprotocolhistory")
@Controller("syssysprotocolhistory")
public class SysProtocolHistoryController {
    @Autowired
    private SysProtocolHistoryService sysProtocolHistoryService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:sysprotocolhistory:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysProtocolHistoryService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:sysprotocolhistory:info")
    public R info(@PathVariable("id") Long id) {
            SysProtocolHistoryEntity sysProtocolHistory = sysProtocolHistoryService.selectById(id);

        return R.ok().put("data", sysProtocolHistory);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("sys:sysprotocolhistory:save")
    public R save(@RequestBody SysProtocolHistoryEntity sysProtocolHistory) {
            sysProtocolHistoryService.insertEntity(sysProtocolHistory);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("sys:sysprotocolhistory:save")
    public R save(@RequestBody List<SysProtocolHistoryEntity> sysProtocolHistory) {
            sysProtocolHistoryService.saveAll(sysProtocolHistory);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("sys:sysprotocolhistory:update")
    public R update(@RequestBody SysProtocolHistoryEntity sysProtocolHistory) {
            sysProtocolHistory.update();
            //校验类型
             ValidatorUtils.validateEntity(sysProtocolHistory);
            sysProtocolHistoryService.updateById(sysProtocolHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("sys:sysprotocolhistory:delete")
    public R delete(@RequestBody Long[]ids) {
            sysProtocolHistoryService.deleteBatchIds(Arrays.asList(ids));
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
        sysProtocolHistoryService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",sysProtocolHistoryService.selectTableConfig());
    }
}
