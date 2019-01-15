package com.szt.modules.lpgzh.controller;

import com.szt.common.annotation.SysLog;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.modules.lp.entity.LpGovernmentEntity;
import com.szt.modules.lpgzh.service.LpGovernmentService;
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
 * 政府职务
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 10:18:57
 */
@Slf4j
@Api(value = "政府职务接口", tags = "政府职务接口")
@RestController
@RequestMapping("lpgzh/lpgovernment")
@Controller("lpgzhlpgovernment")
public class LpGovernmentController {
    @Autowired
    private LpGovernmentService lpGovernmentService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("lpgzh:lpgovernment:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpGovernmentService.queryPage(params, null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("lpgzh:lpgovernment:info")
    public R info(@PathVariable("id") Long id) {
        LpGovernmentEntity lpGovernment = lpGovernmentService.selectById(id);

        return R.ok().put("data", lpGovernment);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("lpgzh:lpgovernment:save")
    public R save(@RequestBody LpGovernmentEntity lpGovernment) {
        lpGovernmentService.insertEntity(lpGovernment);
        return R.ok();
    }

    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("lpgzh:lpgovernment:save")
    public R save(@RequestBody List<LpGovernmentEntity> lpGovernment) {
        lpGovernmentService.saveAll(lpGovernment);
        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("lpgzh:lpgovernment:update")
    public R update(@RequestBody LpGovernmentEntity lpGovernment) {
        lpGovernmentService.updateEntity(lpGovernment);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("lpgzh:lpgovernment:delete")
    public R delete(@RequestBody Long[] ids) {
        lpGovernmentService.deleteBatchIds(Arrays.asList(ids));
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
        lpGovernmentService.sort(ids[0], ids[1]);
        return R.ok();
    }
}
