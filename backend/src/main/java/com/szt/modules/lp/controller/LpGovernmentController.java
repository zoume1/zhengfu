package com.szt.modules.lp.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import com.szt.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.lp.entity.LpGovernmentEntity;
import com.szt.modules.lp.service.LpGovernmentService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 政府职务
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Slf4j
@Api(value = "政府职务接口", tags = "政府职务接口")
@RestController
@RequestMapping("lp/lpgovernment")
@Controller("lplpgovernment")
public class LpGovernmentController {
    @Autowired
    private LpGovernmentService lpGovernmentService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("lp:lpgovernment:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpGovernmentService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("lp:lpgovernment:info")
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
    @RequiresPermissions("lp:lpgovernment:save")
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
    @RequiresPermissions("lp:lpgovernment:save")
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
    @RequiresPermissions("lp:lpgovernment:update")
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
    @RequiresPermissions("lp:lpgovernment:delete")
    public R delete(@RequestBody Long[]ids) {
            lpGovernmentService.deleteBatchIds(Arrays.asList(ids));
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
         lpGovernmentService.sort(ids[0],ids[1]);
        return R.ok();
    }

    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",lpGovernmentService.selectTableConfig());
    }
}
