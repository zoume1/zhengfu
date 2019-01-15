package com.szt.modules.lppc.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.szt.common.validator.ValidatorUtils;
import com.szt.modules.lp.constant.LpActivityConstant;
import com.szt.modules.lp.constant.LpTalentConstant;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.szt.modules.lp.entity.LpTalentEntity;
import com.szt.modules.lppc.service.LpTalentService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 人才库管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:28
 */
@Slf4j
@Api(value = "人才库管理接口", tags = "人才库管理接口")
@RestController
@RequestMapping("lppc/lptalent")
@Controller("lppclptalent")
public class LpTalentController {
    @Autowired
    private LpTalentService lpTalentService;

    /**
     * 人才库列表
     */
    @ApiOperation("人才库列表")
    @GetMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",required = true,paramType="query",dataType = "int"),
            @ApiImplicitParam(name="limit",value="每页数量",required = true,paramType="query",dataType = "int"),
            @ApiImplicitParam(name="age",value="年龄传入[1,2]",paramType="query"),
            @ApiImplicitParam(name="sex",value="性别@0-女,1-男,2保密",paramType="query"),
    })
    public R list(@ApiParam(hidden = true) @RequestParam Map<String, Object> params) {
        params.put("state",LpActivityConstant.LP_ACTIVITY_AUDIT_STATE_1);
        PageUtils page = lpTalentService.queryPage(params,null);
        return R.ok().put("data", page);
    }

    /**
     * 人才库申请
     */
    @ApiOperation("人才库申请")
    @PostMapping("/save")
    public R save(@RequestBody LpTalentEntity lpTalent) {
        lpTalent.setState(LpTalentConstant.LP_TALENT_STATE_0);
        lpTalentService.insertEntity(lpTalent);
        return R.ok();
    }
    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
            LpTalentEntity lpTalent = lpTalentService.selectById(id);
        return R.ok().put("data", lpTalent);
    }


    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("lppc:lptalent:save")
    public R save(@RequestBody List<LpTalentEntity> lpTalent) {
            lpTalentService.saveAll(lpTalent);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("lppc:lptalent:update")
    public R update(@RequestBody LpTalentEntity lpTalent) {
            lpTalentService.updateEntity(lpTalent);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("lppc:lptalent:delete")
    public R delete(@RequestBody Long[]ids) {
            lpTalentService.deleteBatchIds(Arrays.asList(ids));
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
         lpTalentService.sort(ids[0],ids[1]);
        return R.ok();
    }
}
