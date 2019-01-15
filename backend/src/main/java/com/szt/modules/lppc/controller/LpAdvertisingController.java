package com.szt.modules.lppc.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.szt.common.validator.ValidatorUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.lp.entity.LpAdvertisingEntity;
import com.szt.modules.lppc.service.LpAdvertisingService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 广告管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:29
 */
@Slf4j
@Api(value = "广告管理接口", tags = "广告管理接口")
@RestController
@RequestMapping("lppc/lpadvertising")
@Controller("lppclpadvertising")
public class LpAdvertisingController {
    @Autowired
    private LpAdvertisingService lpAdvertisingService;

    /**
     * 首页轮播图
     */
    @ApiOperation("首页轮播图")
    @RequestMapping(value="/list",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "0-首页轮播图,1-首页中部广告图",name = "type",required=true,paramType="query"),
    })
    public R list(String type) {
        if(StringUtils.isBlank(type)){
            return R.error("图片类型不能为空");
        }
        //0-首页轮播图,1-首页中部广告图
        EntityWrapper<LpAdvertisingEntity> ew = new EntityWrapper<LpAdvertisingEntity>();
        ew.eq("type",type);
        List<LpAdvertisingEntity> list = lpAdvertisingService.selectList(ew);
        return R.ok().put("data", list);
    }



}
