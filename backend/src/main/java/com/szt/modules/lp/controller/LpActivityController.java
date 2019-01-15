package com.szt.modules.lp.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import com.szt.common.validator.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.lp.entity.LpActivityEntity;
import com.szt.modules.lp.service.LpActivityService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 活动列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Slf4j
@Api(value = "活动列表接口", tags = "活动列表接口")
@RestController
@RequestMapping("lp/lpactivity")
@Controller("lplpactivity")
public class LpActivityController {
    @Autowired
    private LpActivityService lpActivityService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("lp:lpactivity:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpActivityService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("lp:lpactivity:info")
    public R info(@PathVariable("id") Long id) {
            LpActivityEntity lpActivity = lpActivityService.selectById(id);

        return R.ok().put("data", lpActivity);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("lp:lpactivity:save")
    public R save(@RequestBody LpActivityEntity lpActivity) {
            lpActivityService.insertEntity(lpActivity);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("lp:lpactivity:save")
    public R save(@RequestBody List<LpActivityEntity> lpActivity) {
            lpActivityService.saveAll(lpActivity);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("lp:lpactivity:update")
    public R update(@RequestBody LpActivityEntity lpActivity) {
            lpActivityService.updateEntity(lpActivity);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("lp:lpactivity:delete")
    public R delete(@RequestBody Long[]ids) {
            lpActivityService.deleteBatchIds(Arrays.asList(ids));
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
         lpActivityService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 审核接口
     */
    @ApiOperation("审核接口")
    @RequestMapping(value="/audit",method = RequestMethod.GET)
    public R audit(Long id,String remake,boolean boo) {
        if(id==null){
            return R.error("活动id不能为空!");
        }
        if(StringUtils.isBlank(remake)){
            return R.error("审核内容不能为空");
        }
        lpActivityService.audit(id,remake,boo);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",lpActivityService.selectTableConfig());
    }
}
