
package com.szt.modules.generator.controller;

import com.szt.common.annotation.SysLog;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.validator.ValidatorUtils;
import com.szt.modules.generator.entity.GeneratorTemplateConfigEntity;
import com.szt.modules.generator.service.GeneratorTemplateConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 模板系统参数
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-29 02:26:57
 */
@Slf4j
@Api(value = "模板系统参数接口", tags = "模板系统参数接口")
@RestController
@RequestMapping("generator/generatortemplateconfig")
public class GeneratorTemplateConfigController {
    @Autowired
    private GeneratorTemplateConfigService generatorTemplateConfigService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("generator:generatortemplateconfig:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = generatorTemplateConfigService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("generator:generatortemplateconfig:info")
    public R info(@PathVariable("id") Long id) {
            GeneratorTemplateConfigEntity generatorTemplateConfig = generatorTemplateConfigService.selectById(id);

        return R.ok().put("data", generatorTemplateConfig);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("generator:generatortemplateconfig:save")
    public R save(@RequestBody GeneratorTemplateConfigEntity generatorTemplateConfig) {
             generatorTemplateConfig.insert();
            //校验类型
            ValidatorUtils.validateEntity(generatorTemplateConfig);
            generatorTemplateConfigService.insert(generatorTemplateConfig);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("generator:generatortemplateconfig:update")
    public R update(@RequestBody GeneratorTemplateConfigEntity generatorTemplateConfig) {
            generatorTemplateConfig.update();
            //校验类型
             ValidatorUtils.validateEntity(generatorTemplateConfig);
            generatorTemplateConfigService.updateById(generatorTemplateConfig);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("generator:generatortemplateconfig:delete")
    public R delete(@RequestBody Long[]ids) {
            generatorTemplateConfigService.deleteBatchIds(Arrays.asList(ids));
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
        generatorTemplateConfigService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",generatorTemplateConfigService.selectTableConfig());
    }
}
