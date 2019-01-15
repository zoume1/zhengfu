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
import com.szt.modules.lp.entity.LpLinkEntity;
import com.szt.modules.lppc.service.LpLinkService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 底部友情链接设置
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:28
 */
@Slf4j
@Api(value = "底部友情链接设置接口", tags = "底部友情链接设置接口")
@RestController
@RequestMapping("lppc/lplink")
@Controller("lppclplink")
public class LpLinkController {
    @Autowired
    private LpLinkService lpLinkService;

    /**
     * 底部图片链接列表
     */
    @ApiOperation("底部图片链接列表")
    @GetMapping("/list")
    public R list() {
        List<LpLinkEntity> list = lpLinkService.selectList(null);
        return R.ok().put("data", list);
    }


}
