
package com.szt.modules.generator.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.szt.common.validator.ValidatorUtils;
import com.szt.modules.generator.config.InitBusConfig;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.generator.service.GeneratorTableService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;

/**
 * 数据表管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-13 12:44:03
 */
@Slf4j
@Api(value = "数据表管理接口", tags = "数据表管理接口")
@RestController
@RequestMapping("generator/generatortable")
public class GeneratorTableController {
    @Autowired
    private GeneratorTableService generatorTableService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("generator:generatortable:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = generatorTableService.queryPage(params,null);
        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("generator:generatortable:info")
    public R info(@PathVariable("id") Long id) {
        GeneratorTableEntity generatorTable = generatorTableService.selectById(id);
        return R.ok().put("data", generatorTable);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("generator:generatortable:save")
    public R save(@RequestBody GeneratorTableEntity generatorTable) {
        generatorTableService.insertEntity(generatorTable);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("generator:generatortable:save")
    public R save(@RequestBody List<GeneratorTableEntity> list) {

        return  generatorTableService.saveAlls(list);
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("generator:generatortable:update")
    public R update(@RequestBody GeneratorTableEntity generatorTable) {
        generatorTableService.updateEntity(generatorTable);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("generator:generatortable:delete")
    public R delete(@RequestBody Long[]ids) {
        generatorTableService.deleteTableBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 预览模板
     * @param tableId 表id
     * @param templateId 模板id
     * @return
     */
    @ApiOperation("预览")
    @GetMapping("/preview")
    @RequiresPermissions("generator:generatortable:preview")
    public R preview(Long tableId,Long templateId) {
        return R.ok().put("data",generatorTableService.preview(tableId,templateId));
    }

    /**
     * 生成
     * @param ids
     * @return
     */
    @ApiOperation("生成")
    @GetMapping("/generate")
    //@RequiresPermissions("generator:generatortable:generate")
    public void generate(javax.servlet.http.HttpServletRequest request, HttpServletResponse response ,String ids) throws IOException {
       List<Long> list =  JSON.parseArray(ids,Long.class);
        Long[] strings = new Long[list.size()];
        list.toArray(strings);
       byte[] data = generatorTableService.generate(strings);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"renren.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
    /**
     * 查询显示字段
     */
    @ApiOperation("查询显示字段")
    @GetMapping("/selectTableFieldlist")
    @RequiresPermissions("generator:generatortable:selectTableFieldlist")
    public R selectTableFieldlist(@RequestParam Map<String, Object> params) throws InvocationTargetException, IllegalAccessException {
        PageUtils page = generatorTableService.queryPage(params,null);
        return R.ok().put("page", page);
    }
    /**
     * 查询修改字段
     */
    @ApiOperation("查询修改字段")
    @GetMapping("/selectUpdateFieldlist")
    @RequiresPermissions("generator:generatortable:selectUpdateFieldlist")
    public R selectUpdateFieldlist(@RequestParam Map<String, Object> params) throws InvocationTargetException, IllegalAccessException {
        PageUtils page = generatorTableService.queryPage(params,null);
        return R.ok().put("page", page);
    }
    /**
     * 查询导出excel表格字段
     */
    @ApiOperation("查询导出excel表格字段")
    @GetMapping("/selectExcelFieldlist")
    @RequiresPermissions("generator:generatortable:selectExcelFieldlist")
    public R selectExcelFieldlist(@RequestParam Map<String, Object> params) throws InvocationTargetException, IllegalAccessException {
        PageUtils page = generatorTableService.queryPage(params,null);
        return R.ok().put("page", page);
    }
//    /**
//     * 查询所有表格字段数据
//     */
//    @ApiOperation("查询所有表格字段数据")
//    @GetMapping("/queryTableFilePreviewVO")
//    public R queryTableFilePreview()  {
//        return R.ok().put("data",InitBusConfig.getTabConfig());
//    }
    /**
     * 数据库结构同步
     */
    @ApiOperation("数据库结构同步")
    @PostMapping("/synchronizationStructure")
    public R synchronizationStructure(@RequestBody  Long[] ids)  {
        if(ids==null || ids.length==0){
            return R.error("没有选中数据");
        }
        generatorTableService.synchronizationStructure(ids);
        return R.ok();
    }
    /**
     * 根据模块获取对应的表格信息
     */
    @ApiOperation("根据模块获取对应的表格信息")
    @GetMapping("/queryTabeConfig")
    public R queryTabeConfig(String module)  {
        return R.ok().put("data",generatorTableService.queryTabeConfig(module));
    }
    /**
     * 查询字段拷贝中两表中没有的字段
     */
    @ApiOperation("查询字段拷贝中两表中没有的字段")
    @GetMapping("/fieldCopyConfig")
    public R fieldCopyConfig(Long leftId,Long rightId)  {
        return R.ok().put("data",generatorTableService.fieldCopyConfig(leftId,rightId));
    }
    /**
     * 字段拷贝
     */
    @ApiOperation("字段拷贝")
    @GetMapping("/fieldCopyRun")
    public R fieldCopyRun(Long id,String ids)  {
        generatorTableService.fieldCopyRun(id,ids);
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
        generatorTableService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",generatorTableService.selectTableConfig());
    }
}
