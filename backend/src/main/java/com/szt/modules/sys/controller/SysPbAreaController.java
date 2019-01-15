package com.szt.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.szt.common.validator.ValidatorUtils;
import com.szt.modules.generator.config.InitBusConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.sys.entity.SysPbAreaEntity;
import com.szt.modules.sys.service.SysPbAreaService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 地址管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-08-20 00:11:07
 */
@Slf4j
@Api(value = "地址管理接口", tags = "地址管理接口")
@RestController
@RequestMapping("sys/syspbarea")
@Controller("syssyspbarea")
public class SysPbAreaController {
    @Autowired
    private SysPbAreaService sysPbAreaService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    //@RequiresPermissions("sys:syspbarea:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysPbAreaService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:syspbarea:info")
    public R info(@PathVariable("id") Long id) {
            SysPbAreaEntity sysPbArea = sysPbAreaService.selectById(id);

        return R.ok().put("data", sysPbArea);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("sys:syspbarea:save")
    public R save(@RequestBody SysPbAreaEntity sysPbArea) {
            sysPbAreaService.insertEntity(sysPbArea);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("sys:syspbarea:save")
    public R save(@RequestBody List<SysPbAreaEntity> sysPbArea) {
            sysPbAreaService.saveAll(sysPbArea);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("sys:syspbarea:update")
    public R update(@RequestBody SysPbAreaEntity sysPbArea) {
            sysPbArea.update();
            //校验类型
             ValidatorUtils.validateEntity(sysPbArea);
            sysPbAreaService.updateById(sysPbArea);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("sys:syspbarea:delete")
    public R delete(@RequestBody Long[]ids) {
            sysPbAreaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    /**
     * 查询地址信息
     */
    @ApiOperation("查询地址信息")
    @PostMapping("/getAddressConfig")
    public R getAddressConfig() {
        EntityWrapper<SysPbAreaEntity> ew  = new EntityWrapper<SysPbAreaEntity>();
        ew.notIn("level",4);
        return R.ok().put("data",sysPbAreaService.selectList(ew));
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
        sysPbAreaService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",sysPbAreaService.selectTableConfig());
    }
}
