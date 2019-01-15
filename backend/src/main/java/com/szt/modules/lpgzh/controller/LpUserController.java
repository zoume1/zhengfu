package com.szt.modules.lpgzh.controller;

import com.szt.common.annotation.SysLog;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.modules.lp.entity.LpUserEntity;
import com.szt.modules.lpgzh.service.LpUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 会员管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 10:18:56
 */
@Slf4j
@Api(value = "会员管理接口", tags = "会员管理接口")
@RestController
@RequestMapping("lpgzh/lpuser")
@Controller("lpgzhlpuser")
public class LpUserController {
    @Autowired
    private LpUserService lpUserService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("lpgzh:lpuser:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpUserService.queryPage(params, null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("lpgzh:lpuser:info")
    public R info(@PathVariable("id") Long id) {
        LpUserEntity lpUser = lpUserService.selectById(id);

        return R.ok().put("data", lpUser);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("lpgzh:lpuser:save")
    public R save(@RequestBody LpUserEntity lpUser) {
        lpUserService.insertEntity(lpUser);
        return R.ok();
    }

    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("lpgzh:lpuser:save")
    public R save(@RequestBody List<LpUserEntity> lpUser) {
        lpUserService.saveAll(lpUser);
        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("lpgzh:lpuser:update")
    public R update(@RequestBody LpUserEntity lpUser) {
        lpUserService.updateEntity(lpUser);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("lpgzh:lpuser:delete")
    public R delete(@RequestBody Long[] ids) {
        lpUserService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 拖拽行排序
     */
    @ApiOperation("拖拽行排序")
    @PostMapping("/sort")
    public R sort(@RequestBody Long[] ids) {
        if (ids.length != 2) {
            return R.error("数据错误");
        }
        lpUserService.sort(ids[0], ids[1]);
        return R.ok();
    }
}
