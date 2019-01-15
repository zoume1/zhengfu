package com.szt.modules.lppc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.szt.common.validator.ValidatorUtils;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.szt.modules.lp.entity.LpColumnEntity;
import com.szt.modules.lppc.service.LpColumnService;
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
 * @date 2018-10-17 09:55:29
 */
@Slf4j
@Api(value = "栏目管理接口", tags = "栏目管理接口")
@RestController
@RequestMapping("lppc/lpcolumn")
@Controller("lppclpcolumn")
public class LpColumnController {
    @Autowired
    private LpColumnService lpColumnService;

    /**
     * 查询首页菜单
     */
    @ApiOperation("查询首页菜单")
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public R level1() {
        return R.ok().put("data", lpColumnService.selectList(null));
    }



}
