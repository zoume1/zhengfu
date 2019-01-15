package com.szt.modules.lppc.controller;

import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.szt.common.utils.RestMessage;
import com.szt.modules.lppc.vo.RegisterVO;
import com.szt.modules.sys.service.SysCaptchaService;
import io.swagger.annotations.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.szt.modules.lp.entity.LpUserEntity;
import com.szt.modules.lppc.service.LpUserService;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * 会员管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:28
 */
@Slf4j
@Api(value = "会员管理接口", tags = "会员管理接口")
@RestController
@RequestMapping("lppc/lpuser")
@Controller("lppclpuser")
public class LpUserController {

    @Autowired
    private LpUserService lpUserService;
    @Autowired
    private com.szt.modules.lp.service.LpUserService service;
    @Autowired
    private SysCaptchaService sysCaptchaService;
    /**
     * 获取官网图片验证码
     */
    @ApiOperation(value = "获取官网图片验证码")
    @RequestMapping(value = "/captcha.jpg",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "生成任意uuid",name = "uuid",required=true,paramType="query"),
    })
    public void captcha(HttpServletResponse response,  String uuid)throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }
    /**
     * 官网登录
     */
    @ApiOperation(value="官网登录",notes = "首先生成任意uuid,在调用官网图片验证码")
    @RequestMapping(value="/login",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名称",name = "userName",required=true,paramType="query"),
            @ApiImplicitParam(value = "密码",name = "password",required=true,paramType="query"),
            @ApiImplicitParam(value = "验证密钥",name = "uuid",required=true,paramType="query"),
            @ApiImplicitParam(value = "验证码",name = "captcha",required=true,paramType="query"),
    })
    public RestMessage<LpUserEntity> login(String userName, String password, String uuid, String captcha) {
        if(!sysCaptchaService.validate(uuid,captcha )){
            return RestMessage.error("验证码不正确");
        }
        if(StringUtils.isBlank(userName)){
            return RestMessage.error("用户名不能为空");
        }else if(StringUtils.isBlank(password)){
            return RestMessage.error("密码不能为空");
        }
        return RestMessage.ok().put(lpUserService.login(userName,password));
    }
    /**
     * 信息
     */
    @ApiOperation("信息")
    @RequestMapping(value="/info/{id}",method = RequestMethod.GET)
    public R info(@PathVariable("id") Long id) {
        LpUserEntity lpUser = service.info(id);

        return R.ok().put("data", lpUser);
    }
    /**
     * 官网注册方法
     */
    @ApiOperation("官网注册方法")
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public RestMessage register(@RequestBody LpUserEntity user) {
        service.insertEntity(user);
        return RestMessage.ok();
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public R save(@RequestBody LpUserEntity lpUser) {
        LpUserEntity user = new LpUserEntity();

        String password = lpUser.getPassword();
        service.insertEntity(lpUser);
        user.setPassword(password);
        user.setUserName(lpUser.getUserName());
        user.setCreateTime(lpUser.getCreateTime());
        return R.ok().put("data",user);
    }
    /**
     * 批量保存
     */
    @ApiOperation("批量保存")
    @RequestMapping(value="/saveAll",method = RequestMethod.POST)
    @RequiresPermissions("lppc:lpuser:save")
    public R save(@RequestBody List<LpUserEntity> lpUser) {
            lpUserService.saveAll(lpUser);
             return R.ok();
    }
    /**
     * 修改
     */
    @ApiOperation("修改")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public R update(@RequestBody LpUserEntity lpUser) {
            service.updateEntity(lpUser);
        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @RequiresPermissions("lppc:lpuser:delete")
    public R delete(@RequestBody Long[]ids) {
            lpUserService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    /**
     * 拖拽行排序
     */
    @ApiOperation("拖拽行排序")
    @RequestMapping(value="/sort",method = RequestMethod.POST)
    public R sort(@RequestBody Long[]ids) {
        if(ids.length!=2){
            return R.error("数据错误");
        }
         lpUserService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig(String type) {
        return R.ok().put("data",service.selectTableConfig(type));
    }
}
