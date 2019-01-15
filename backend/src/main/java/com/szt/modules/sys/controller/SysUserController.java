package com.szt.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.szt.common.utils.AdminUserUtils;
import com.szt.modules.sys.constant.SysUserConstant;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.sys.entity.SysUserEntity;
import com.szt.modules.sys.service.SysUserService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 后端用户管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-09-30 21:24:29
 */
@Slf4j
@Api(value = "后端用户管理接口", tags = "后端用户管理接口")
@RestController
@RequestMapping("sys/sysuser")
@Controller("syssysuser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:sysuser:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysUserService.queryPage(params,null);

        return R.ok().put("data", page);
    }

    /**
     * 获取登录的用户信息
     */
    @GetMapping("/info")
    public R info(){
        return R.ok().put("user", AdminUserUtils.getUser());
    }
    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:sysuser:info")
    public R info(@PathVariable("id") Long id) {
            SysUserEntity sysUser = sysUserService.selectById(id);

        return R.ok().put("data", sysUser);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("sys:sysuser:save")
    public R save(@RequestBody SysUserEntity sysUser) {
        sysUser.setUserType(SysUserConstant.SYS_USER_USER_TYPE_0);
        sysUserService.insertEntity(sysUser);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("sys:sysuser:save")
    public R save(@RequestBody List<SysUserEntity> sysUser) {
            sysUserService.saveAll(sysUser);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("sys:sysuser:update")
    public R update(@RequestBody SysUserEntity sysUser) {
        sysUserService.updateEntity(sysUser);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("sys:sysuser:delete")
    public R delete(@RequestBody Long[]ids) {
        if(ArrayUtils.contains(ids, 1L)){
            return R.error("系统管理员不能删除");
        }
        if(ArrayUtils.contains(ids, AdminUserUtils.getUserId())){
            return R.error("当前用户不能删除");
        }
        sysUserService.deleteBatchIds(Arrays.asList(ids));
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
        sysUserService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",sysUserService.selectTableConfig());
    }
}
