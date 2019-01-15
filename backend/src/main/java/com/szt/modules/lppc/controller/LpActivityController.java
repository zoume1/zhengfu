package com.szt.modules.lppc.controller;

import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.modules.lp.entity.LpOrganizersEntity;
import com.szt.modules.lppc.service.LpActivityService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 活动列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:29
 */
@Slf4j
@Api(value = "活动列表接口", tags = "活动列表接口")
@RestController
@RequestMapping("lppc/lpactivity")
@Controller("lppclpactivity")
public class LpActivityController {
    @Autowired
    private LpActivityService lpActivityService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "sidx", value = "排序字段", required = true, paramType = "query"),
            @ApiImplicitParam(name = "order", value = "升序降序", required = true, paramType = "query"),
    })
    public R list(@ApiParam(hidden = true) @RequestParam Map<String, Object> params) {
        PageUtils page = lpActivityService.queryPage(params, null);
        return R.ok().put("data", page);
    }
    /**
     * 阅读活动
     */
    @ApiOperation("阅读活动")
    @GetMapping("/info/{id}")
    public R reader(@PathVariable("id") Long id) {

        return R.ok().put("data", lpActivityService.reader(id));
    }

}
