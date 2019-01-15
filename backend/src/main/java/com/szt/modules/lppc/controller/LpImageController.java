package com.szt.modules.lppc.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import com.szt.common.validator.ValidatorUtils;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.szt.modules.lp.entity.LpImageEntity;
import com.szt.modules.lppc.service.LpImageService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 图片列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:28
 */
@Slf4j
@Api(value = "图片列表接口", tags = "图片列表接口")
@RestController
@RequestMapping("lppc/lpimage")
@Controller("lppclpimage")
public class LpImageController {
    @Autowired
    private LpImageService lpImageService;

    /**
     * 图片列表列表
     */
    @ApiOperation("图片列表列表")
    @RequestMapping(value="/list",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",paramType="query"),
            @ApiImplicitParam(name="limit",value="每页数量",paramType="query"),
            @ApiImplicitParam(name="type",value="0-活动剪影,1-领导风采,2-资质荣誉,3-展销会",paramType="query"),
    })
    public R list(@ApiParam(hidden = true)@RequestParam Map<String, Object> params) {
        PageUtils page = lpImageService.queryPage(params,null);
        return R.ok().put("data", page);
    }



}
