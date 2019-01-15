package com.szt.modules.lp.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import com.szt.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.lp.entity.LpColumnEntity;
import com.szt.modules.lp.service.LpColumnService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 栏目管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Slf4j
@Api(value = "栏目管理接口", tags = "栏目管理接口")
@RestController
@RequestMapping("lp/lpcolumn")
@Controller("lplpcolumn")
public class LpColumnController {
    @Autowired
    private LpColumnService lpColumnService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("lp:lpcolumn:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpColumnService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("lp:lpcolumn:info")
    public R info(@PathVariable("id") Long id) {
            LpColumnEntity lpColumn = lpColumnService.selectById(id);

        return R.ok().put("data", lpColumn);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("lp:lpcolumn:save")
    public R save(@RequestBody LpColumnEntity lpColumn) {
            lpColumnService.insertEntity(lpColumn);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("lp:lpcolumn:save")
    public R save(@RequestBody List<LpColumnEntity> lpColumn) {
            lpColumnService.saveAll(lpColumn);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("lp:lpcolumn:update")
    public R update(@RequestBody LpColumnEntity lpColumn) {
            lpColumnService.updateEntity(lpColumn);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("lp:lpcolumn:delete")
    public R delete(@RequestBody Long[]ids) {
            lpColumnService.deleteBatchIds(Arrays.asList(ids));
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
         lpColumnService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",lpColumnService.selectTableConfig());
    }
}
