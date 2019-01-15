
package com.szt.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.szt.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.generator.entity.GeneratorTableFieldEntity;
import com.szt.modules.generator.service.GeneratorTableFieldService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;

/**
 * 字段管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-13 12:52:07
 */
@Slf4j
@Api(value = "字段管理接口", tags = "字段管理接口")
@RestController
@RequestMapping("generator/generatortablefield")
public class GeneratorTableFieldController {
    @Autowired
    private GeneratorTableFieldService generatorTableFieldService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("generator:generatortablefield:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = generatorTableFieldService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("generator:generatortablefield:info")
    public R info(@PathVariable("id") Long id) {
            GeneratorTableFieldEntity generatorTableField = generatorTableFieldService.selectById(id);
        return R.ok().put("data", generatorTableField);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("generator:generatortablefield:save")
    public R save(@RequestBody GeneratorTableFieldEntity generatorTableField) {
            generatorTableFieldService.insertEntity(generatorTableField);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("generator:generatortablefield:save")
    public R save(@RequestBody List<GeneratorTableFieldEntity> generatorTableField) {
        return generatorTableFieldService.saveAlls(generatorTableField);
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("generator:generatortablefield:update")
    public R update(@RequestBody GeneratorTableFieldEntity generatorTableField) {
            generatorTableFieldService.updateEntity(generatorTableField);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("generator:generatortablefield:delete")
    public R delete(@RequestBody Long[]ids) {
        generatorTableFieldService.deleteFields(Arrays.asList(ids));
        return R.ok();
    }
    @SysLog("隐藏表格字段")
    @ApiOperation("隐藏表格字段")
    @PostMapping("/hideTableField")
    public R hideTableField(@RequestBody Long[]ids) {
        generatorTableFieldService.hideTableField(Arrays.asList(ids));
        return R.ok();
    }
    @SysLog("隐藏表格字段")
    @ApiOperation("隐藏表格字段")
    @PostMapping("/hideSetField")
    public R hideSetField(@RequestBody Long[]ids) {
        generatorTableFieldService.hideSetField(Arrays.asList(ids));
        return R.ok();
    }
    @SysLog("显示搜索字段")
    @ApiOperation("显示搜索字段")
    @PostMapping("/showSeekField")
    public R showSeekField(@RequestBody Long[]ids) {
        generatorTableFieldService.showSeekField(Arrays.asList(ids));
        return R.ok();
    }
    @SysLog("显示导出字段")
    @ApiOperation("显示导出字段")
    @PostMapping("/showExportField")
    public R showExportField(@RequestBody Long[]ids) {
        generatorTableFieldService.showExportField(Arrays.asList(ids));
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
        generatorTableFieldService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",generatorTableFieldService.selectTableConfig());
    }
}
