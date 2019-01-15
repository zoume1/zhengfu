package com.szt.modules.sys.controller;

import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.szt.modules.sys.service.ShiroService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.sys.entity.SysMenuEntity;
import com.szt.modules.sys.service.SysMenuService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import static com.szt.common.utils.AdminUserUtils.getUserId;

/**
 * 菜单管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-01 17:29:19
 */
@Slf4j
@Api(value = "菜单管理接口", tags = "菜单管理接口")
@RestController
@RequestMapping("sys/sysmenu")
@Controller("syssysmenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;
    	@Autowired
	private ShiroService shiroService;
//	@Value("${spring.profiles.active}")
//	private String active;
	/**
	 * 导航菜单
	 */
	@GetMapping("/nav")
	public R nav(){
		return R.ok().put("menuList", sysMenuService.getUserMenuList(getUserId())).put("permissions", shiroService.getUserPermissions(getUserId()));
	}
    /**
     * 一级菜单
     */
    @GetMapping("/menuLevel")
    public R menuLevel(){
        return R.ok().put("data", sysMenuService.menuLevel(getUserId()));
    }
    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:sysmenu:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysMenuService.queryPage(params,null);
        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:sysmenu:info")
    public R info(@PathVariable("id") Long id) {
            SysMenuEntity sysMenu = sysMenuService.selectById(id);

        return R.ok().put("data", sysMenu);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("sys:sysmenu:save")
    public R save(@RequestBody SysMenuEntity sysMenu) {
            sysMenuService.insertEntity(sysMenu);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("sys:sysmenu:save")
    public R save(@RequestBody List<SysMenuEntity> sysMenu) {
            sysMenuService.saveAll(sysMenu);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("sys:sysmenu:update")
    public R update(@RequestBody SysMenuEntity sysMenu) {
            sysMenuService.updateEntity(sysMenu);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("sys:sysmenu:delete")
    public R delete(@RequestBody Long[]ids) {
            sysMenuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
	/**
	 * 查询路由
	 */
	@PostMapping("/router")
	//@RequiresPermissions("sys:menu:delete")
	public R router(){
		return R.ok().put("data",sysMenuService.router());
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
        sysMenuService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",sysMenuService.selectTableConfig());
    }
}
