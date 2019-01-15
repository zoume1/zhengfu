package com.szt.modules.lp.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.lp.entity.LpUserEntity;
import com.szt.modules.lp.service.LpUserService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * 会员列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 17:33:41
 */
@Slf4j
@Api(value = "会员列表接口", tags = "会员列表接口")
@RestController
@RequestMapping("lp/lpuser")
@Controller("lplpuser")
public class LpUserController {
    @Autowired
    private LpUserService lpUserService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @RequestMapping(value="/list",method = RequestMethod.GET)
    @RequiresPermissions("lp:lpuser:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpUserService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @RequestMapping(value="/info/{id}",method = RequestMethod.GET)
    @RequiresPermissions("lp:lpuser:info")
    public R info(@PathVariable("id") Long id) {
        LpUserEntity lpUser = lpUserService.info(id);

        return R.ok().put("data", lpUser);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @RequestMapping(value="/save",method = RequestMethod.POST)
    @RequiresPermissions("lp:lpuser:save")
    public R save(@RequestBody LpUserEntity lpUser) {
        LpUserEntity user = new LpUserEntity();
        String password = lpUser.getPassword();
        lpUserService.insertEntity(lpUser);
        user.setPassword(password);
        user.setUserName(lpUser.getUserName());
        user.setCreateTime(lpUser.getCreateTime());
        return R.ok().put("data",user);
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @RequestMapping(value="/saveAll",method = RequestMethod.POST)
    @RequiresPermissions("lp:lpuser:save")
    public R save(@RequestBody List<LpUserEntity> lpUser) {
        lpUserService.saveAll(lpUser);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @RequiresPermissions("lp:lpuser:update")
    public R update(@RequestBody LpUserEntity lpUser) {
        lpUserService.updateEntity(lpUser);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @RequiresPermissions("lp:lpuser:delete")
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
        return R.ok().put("data",lpUserService.selectTableConfig(type));
    }
    /**
     * 会员统计查询
     */
    @ApiOperation("会员统计查询")
    @RequestMapping(value = "/memberStatistics",method = RequestMethod.GET)
    public R memberStatistics(String type,Long coceralId,String address) {
        return R.ok().put("data",lpUserService.memberStatistics(type,coceralId,address));
    }
    /**
     * 会员信息报表
     */
    @ApiOperation("会员信息报表")
    @RequestMapping(value = "/informationReport",method = RequestMethod.GET)
    public R informationReport(String type,Long coceralId,String address) {
        return R.ok().put("data",lpUserService.informationReport(type,coceralId, address));
    }
    /**
     * 会员增长报表
     */
    @ApiOperation("会员增长报表")
    @RequestMapping(value = "/growthStatements",method = RequestMethod.GET)
    public R growthStatements(String userType,Long coceralId,String address,String createTime) {
        return R.ok().put("data",lpUserService.growthStatements(userType,coceralId, address,createTime));
    }
}
