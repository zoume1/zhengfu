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
import com.szt.modules.lp.entity.LpOtherDutiesEntity;
import com.szt.modules.lpgzh.service.LpOtherDutiesService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 其他职务
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 10:18:57
 */
@Slf4j
@Api(value = "其他职务接口", tags = "其他职务接口")
@RestController
@RequestMapping("lpgzh/lpotherduties")
@Controller("lpgzhlpotherduties")
public class LpOtherDutiesController {
    @Autowired
    private LpOtherDutiesService lpOtherDutiesService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("lpgzh:lpotherduties:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpOtherDutiesService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("lpgzh:lpotherduties:info")
    public R info(@PathVariable("id") Long id) {
            LpOtherDutiesEntity lpOtherDuties = lpOtherDutiesService.selectById(id);

        return R.ok().put("data", lpOtherDuties);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("lpgzh:lpotherduties:save")
    public R save(@RequestBody LpOtherDutiesEntity lpOtherDuties) {
            lpOtherDutiesService.insertEntity(lpOtherDuties);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("lpgzh:lpotherduties:save")
    public R save(@RequestBody List<LpOtherDutiesEntity> lpOtherDuties) {
            lpOtherDutiesService.saveAll(lpOtherDuties);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("lpgzh:lpotherduties:update")
    public R update(@RequestBody LpOtherDutiesEntity lpOtherDuties) {
            lpOtherDutiesService.updateEntity(lpOtherDuties);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("lpgzh:lpotherduties:delete")
    public R delete(@RequestBody Long[]ids) {
            lpOtherDutiesService.deleteBatchIds(Arrays.asList(ids));
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
         lpOtherDutiesService.sort(ids[0],ids[1]);
        return R.ok();
    }
}
