package com.szt.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;
import com.szt.common.validator.ValidatorUtils;
import com.szt.modules.generator.config.InitBusConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.generator.entity.GeneratorBusConfigEntity;
import com.szt.modules.generator.service.GeneratorBusConfigService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 自动生成参数管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 15:18:03
 */
@Slf4j
@Api(value = "自动生成参数管理接口", tags = "自动生成参数管理接口")
@RestController
@RequestMapping("generator/generatorbusconfig")
@Controller("generatorgeneratorbusconfig")
public class GeneratorBusConfigController {
    @Autowired
    private GeneratorBusConfigService generatorBusConfigService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("generator:generatorbusconfig:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = generatorBusConfigService.queryPage(params,null);
        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("generator:generatorbusconfig:info")
    public R info(@PathVariable("id") Long id) {
        GeneratorBusConfigEntity generatorBusConfig = generatorBusConfigService.selectById(id);
        return R.ok().put("data", generatorBusConfig);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("generator:generatorbusconfig:save")
    public R save(@RequestBody GeneratorBusConfigEntity generatorBusConfig) {
            generatorBusConfigService.insertEntity(generatorBusConfig);
        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("generator:generatorbusconfig:update")
    public R update(@RequestBody GeneratorBusConfigEntity generatorBusConfig) {
        generatorBusConfigService.updateEntity(generatorBusConfig);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("generator:generatorbusconfig:delete")
    public R delete(@RequestBody Long[]ids) {
            generatorBusConfigService.deleteList(Arrays.asList(ids));
        return R.ok();
    }
    /**
     * 查询所有业务参数
     */
    @ApiOperation("查询所有业务参数")
    @GetMapping("/querySysBusConfigList")
    public R querySysBusConfigList() {
        return R.ok().put("data",generatorBusConfigService.querySysBusConfigList(null));
    }
    /**
     * 根据业务参数的key查询表格业务参数
     */
    @ApiOperation("查询所有表格业务参数")
    @GetMapping("/querySysBusConfigByKey")
    public R querySysBusConfigByKey(String key) {
        return R.ok().put("data",generatorBusConfigService.querySysBusConfigByKey(key));
    }
    /**
     * 根据业务参数的tree查询表格业务参数
     */
    @ApiOperation("根据业务参数的tree查询表格业务参数")
    @GetMapping("/queryTreeConfigByKey")
    public R queryTreeConfigByKey(String key) {
        return R.ok().put("data",generatorBusConfigService.queryTreeConfigByKey(key));
    }
    /**
     * 根据模块查询所需的业务参数
     */
    @ApiOperation("根据模块查询所需的业务参数")
    @GetMapping("/queryModuleBusConfig")
    public R queryModuleBusConfig(String module) {
        return R.ok().put("data",generatorBusConfigService.queryModuleBusConfig(module));
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
        generatorBusConfigService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",generatorBusConfigService.selectTableConfig());
    }
}
