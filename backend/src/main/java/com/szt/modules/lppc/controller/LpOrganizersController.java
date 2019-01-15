package com.szt.modules.lppc.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import com.szt.common.validator.ValidatorUtils;
import com.szt.modules.lppc.interceptor.AnalysisPcActuator;
import com.szt.modules.lppc.util.PcUserUtils;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.lp.entity.LpOrganizersEntity;
import com.szt.modules.lppc.service.LpOrganizersService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 活动人员
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:28
 */
@Slf4j
@Api(value = "活动人员接口", tags = "活动人员接口")
@RestController
@RequestMapping("lppc/lporganizers")
@Controller("lppclporganizers")
public class LpOrganizersController {
    @Autowired
    private LpOrganizersService lpOrganizersService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("lppc:lporganizers:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpOrganizersService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("lppc:lporganizers:info")
    public R info(@PathVariable("id") Long id) {
            LpOrganizersEntity lpOrganizers = lpOrganizersService.selectById(id);

        return R.ok().put("data", lpOrganizers);
    }

    /**
     * 报名
     */
    @ApiOperation("报名")
    @GetMapping("/save")
    @AnalysisPcActuator
    public R save(@ApiParam(required = true,value="活动id",name="id") Long id) {
        lpOrganizersService.insertEntity(id);
        return R.ok();
    }

}
