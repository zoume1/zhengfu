
package com.szt.modules.generator.controller;

import com.szt.common.annotation.SysLog;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.utils.StringUtll;
import com.szt.common.validator.ValidatorUtils;
import com.szt.modules.generator.entity.GeneratorTemplateEntity;
import com.szt.modules.generator.service.GeneratorTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 模板配置
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-27 21:07:36
 */
@Slf4j
@Api(value = "模板配置接口", tags = "模板配置接口")
@RestController
@RequestMapping("generator/generatortemplate")
public class GeneratorTemplateController {
    @Autowired
    private GeneratorTemplateService generatorTemplateService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("generator:generatortemplate:list")
    public R list(@RequestParam Map<String, Object> params) throws InvocationTargetException, IllegalAccessException {
        PageUtils page = generatorTemplateService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("generator:generatortemplate:info")
    public R info(@PathVariable("id") Long id) {
            GeneratorTemplateEntity generatorTemplate = generatorTemplateService.selectById(id);

        return R.ok().put("data", generatorTemplate);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("generator:generatortemplate:save")
    public R save(@RequestBody GeneratorTemplateEntity generatorTemplate,HttpServletRequest request) throws FileNotFoundException {
             generatorTemplate.insert();
        //校验类型
        generatorTemplate.setText(StringUtll.dealSpace4OneLine(StringEscapeUtils.unescapeHtml(generatorTemplate.getText())));
        ValidatorUtils.validateEntity(generatorTemplate);
        generatorTemplateService.insertFile(generatorTemplate);
        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("generator:generatortemplate:update")
    public R update(@RequestBody GeneratorTemplateEntity generatorTemplate) throws IOException {
            generatorTemplate.update();
        generatorTemplate.setText(StringUtll.dealSpace4OneLine(StringEscapeUtils.unescapeHtml(generatorTemplate.getText())));
        //校验类型
        ValidatorUtils.validateEntity(generatorTemplate);
        generatorTemplateService.updateByIdFile(generatorTemplate);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("generator:generatortemplate:delete")
    public R delete(@RequestBody Long[]ids) {
        generatorTemplateService.deleteFile(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 查询当前所有存在的模板
     */
    @ApiOperation("查询当前所有存在的模板")
    @PostMapping("/queryGeneratorTemplateList")
    @RequiresPermissions("generator:generatortemplate:queryGeneratorTemplateList")
    public R queryGeneratorTemplateList() {
        return R.ok().put("data",generatorTemplateService.queryGeneratorTemplateList());
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
        generatorTemplateService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",generatorTemplateService.selectTableConfig());
    }
}
