package com.szt.modules.lppc.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import com.szt.common.validator.ValidatorUtils;
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
import com.szt.modules.lp.entity.LpCppccEntity;
import com.szt.modules.lppc.service.LpCppccService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 政协职务
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:29
 */
@Slf4j
@Api(value = "政协职务接口", tags = "政协职务接口")
@RestController
@RequestMapping("lppc/lpcppcc")
@Controller("lppclpcppcc")
public class LpCppccController {
    @Autowired
    private LpCppccService lpCppccService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("lppc:lpcppcc:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpCppccService.queryPage(params,null);

        return R.ok().put("data", page);
    }


}
