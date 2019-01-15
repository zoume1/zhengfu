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
import com.szt.modules.lp.entity.LpEnterpriseEntity;
import com.szt.modules.lpgzh.service.LpEnterpriseService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 企业职务
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 10:18:58
 */
@Slf4j
@Api(value = "企业职务接口", tags = "企业职务接口")
@RestController
@RequestMapping("lpgzh/lpenterprise")
@Controller("lpgzhlpenterprise")
public class LpEnterpriseController {
    @Autowired
    private LpEnterpriseService lpEnterpriseService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("lpgzh:lpenterprise:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpEnterpriseService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("lpgzh:lpenterprise:info")
    public R info(@PathVariable("id") Long id) {
            LpEnterpriseEntity lpEnterprise = lpEnterpriseService.selectById(id);

        return R.ok().put("data", lpEnterprise);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("lpgzh:lpenterprise:save")
    public R save(@RequestBody LpEnterpriseEntity lpEnterprise) {
            lpEnterpriseService.insertEntity(lpEnterprise);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @PostMapping("/saveAll")
    @RequiresPermissions("lpgzh:lpenterprise:save")
    public R save(@RequestBody List<LpEnterpriseEntity> lpEnterprise) {
            lpEnterpriseService.saveAll(lpEnterprise);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("lpgzh:lpenterprise:update")
    public R update(@RequestBody LpEnterpriseEntity lpEnterprise) {
            lpEnterpriseService.updateEntity(lpEnterprise);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("lpgzh:lpenterprise:delete")
    public R delete(@RequestBody Long[]ids) {
            lpEnterpriseService.deleteBatchIds(Arrays.asList(ids));
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
         lpEnterpriseService.sort(ids[0],ids[1]);
        return R.ok();
    }
}
