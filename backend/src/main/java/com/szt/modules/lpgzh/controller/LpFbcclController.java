package com.szt.modules.lpgzh.controller;

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
import com.szt.modules.lp.entity.LpFbcclEntity;
import com.szt.modules.lpgzh.service.LpFbcclService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 工商联职务
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 10:18:58
 */
@Slf4j
@Api(value = "工商联职务接口", tags = "工商联职务接口")
@RestController
@RequestMapping("lpgzh/lpfbccl")
@Controller("lpgzhlpfbccl")
public class LpFbcclController {
    @Autowired
    private LpFbcclService lpFbcclService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("lpgzh:lpfbccl:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpFbcclService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("lpgzh:lpfbccl:info")
    public R info(@PathVariable("id") Long id) {
            LpFbcclEntity lpFbccl = lpFbcclService.selectById(id);

        return R.ok().put("data", lpFbccl);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("lpgzh:lpfbccl:save")
    public R save(@RequestBody LpFbcclEntity lpFbccl) {
            lpFbcclService.insertEntity(lpFbccl);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("lpgzh:lpfbccl:save")
    public R save(@RequestBody List<LpFbcclEntity> lpFbccl) {
            lpFbcclService.saveAll(lpFbccl);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("lpgzh:lpfbccl:update")
    public R update(@RequestBody LpFbcclEntity lpFbccl) {
            lpFbcclService.updateEntity(lpFbccl);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("lpgzh:lpfbccl:delete")
    public R delete(@RequestBody Long[]ids) {
            lpFbcclService.deleteBatchIds(Arrays.asList(ids));
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
         lpFbcclService.sort(ids[0],ids[1]);
        return R.ok();
    }
}
