package com.szt.modules.lppc.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import com.szt.common.validator.ValidatorUtils;
import com.szt.modules.lp.constant.LpLeaveWordConstant;
import com.szt.modules.lp.entity.LpUserEntity;
import com.szt.modules.lppc.interceptor.AnalysisPcActuator;
import com.szt.modules.lppc.util.PcUserUtils;
import com.szt.modules.sys.service.SysCaptchaService;
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
import com.szt.modules.lp.entity.LpLeaveWordEntity;
import com.szt.modules.lppc.service.LpLeaveWordService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 在线交流
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:28
 */
@Slf4j
@Api(value = "在线交流接口", tags = "在线交流接口")
@RestController
@RequestMapping("lppc/lpleaveword")
@Controller("lppclpleaveword")
public class LpLeaveWordController {
    @Autowired
    private LpLeaveWordService lpLeaveWordService;
    @Autowired
    private SysCaptchaService sysCaptchaService;
    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpLeaveWordService.queryPage(params,null);
        return R.ok().put("data", page);
    }
    /**
     * 提交留言
     */
    @ApiOperation("提交留言")
    @PostMapping("/save")
    @AnalysisPcActuator
    public R save(@RequestBody LpLeaveWordEntity lpLeaveWord) {
        LpUserEntity a = PcUserUtils.getUser();
            if(!sysCaptchaService.validate(lpLeaveWord.getUuid(),lpLeaveWord.getCaptcha() )){
                return R.error("验证码不正确");
            }
            lpLeaveWord.setUserId(PcUserUtils.getUserId());
        lpLeaveWord.setState(LpLeaveWordConstant.LP_LEAVE_WORD_STATE_0);
            lpLeaveWordService.insertEntity(lpLeaveWord);
        return R.ok();
    }

}
