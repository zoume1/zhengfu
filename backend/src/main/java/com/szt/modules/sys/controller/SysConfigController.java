package com.szt.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.szt.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.sys.entity.SysConfigEntity;
import com.szt.modules.sys.service.SysConfigService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 系统字典管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 20:36:35
 */
@Slf4j
@Api(value = "系统字典管理接口", tags = "系统字典管理接口")
@RestController
@RequestMapping("sys/sysconfig")
@Controller("syssysconfig")
public class SysConfigController {
    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:sysconfig:list")
    public R list(@RequestParam Map<String, Object> params) {
        Wrapper wrapper = Condition.create();
        wrapper.notIn("data_key",new Object[]{
                "CLOUD_STORAGE_CONFIG_KEY"
        });
        PageUtils page = sysConfigService.queryPage(params,wrapper);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:sysconfig:info")
    public R info(@PathVariable("id") Long id) {
            SysConfigEntity sysConfig = sysConfigService.selectById(id);

        return R.ok().put("data", sysConfig);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("sys:sysconfig:save")
    public R save(@RequestBody SysConfigEntity sysConfig) {
             sysConfig.insert();
            //校验类型
            ValidatorUtils.validateEntity(sysConfig);
            sysConfigService.save(sysConfig);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("sys:sysconfig:update")
    public R update(@RequestBody SysConfigEntity sysConfig) {
            sysConfig.update();
            //校验类型
             ValidatorUtils.validateEntity(sysConfig);
            sysConfigService.update(sysConfig);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("sys:sysconfig:delete")
    public R delete(@RequestBody Long[]ids) {
            sysConfigService.deleteBatch(ids);
        return R.ok();
    }
    /**
     * 网站配置
     */
    @ApiOperation("网站配置")
    @PostMapping("/getConfig")
    //@RequiresPermissions("")
    public R getConfig() {
        return R.ok().put("data",sysConfigService.getConfig());
    }
    /**
     * 保存网站配置
     */
    @ApiOperation("保存网站配置")
    @PostMapping("/updateConfig")
    @RequiresPermissions("sys:sysconfig:updateConfig")
    public R updateConfig(@RequestBody Map<String,SysConfigEntity> map) {
        sysConfigService.updateConfig(map);
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
        sysConfigService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",sysConfigService.selectTableConfig());
    }
}
