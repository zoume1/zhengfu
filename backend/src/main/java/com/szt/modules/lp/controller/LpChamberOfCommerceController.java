package com.szt.modules.lp.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.szt.modules.lp.vo.SysUserLpChamberOfCommerceVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.lp.entity.LpChamberOfCommerceEntity;
import com.szt.modules.lp.service.LpChamberOfCommerceService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * 商会列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-22 17:08:35
 */
@Slf4j
@Api(value = "商会列表接口", tags = "商会列表接口")
@RestController
@RequestMapping("lp/lpchamberofcommerce")
@Controller("lplpchamberofcommerce")
public class LpChamberOfCommerceController {
    @Autowired
    private LpChamberOfCommerceService lpChamberOfCommerceService;

    /**
     * 列表
     */
   @ApiOperation("列表")
   @RequestMapping(value="/list",method = RequestMethod.GET)
   @RequiresPermissions("lp:lpchamberofcommerce:list")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",required = true,paramType="query",dataType = "int"),
            @ApiImplicitParam(name="limit",value="每页数量",required = true,paramType="query",dataType = "int"),
            @ApiImplicitParam(name="sidx",value="排序字段",required = true,paramType="query"),
            @ApiImplicitParam(name="order",value="升序降序",required = true,paramType="query"),
    })
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpChamberOfCommerceService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
   @ApiOperation("信息")
   @RequestMapping(value="/info/{id}",method = RequestMethod.GET)
   @RequiresPermissions("lp:lpchamberofcommerce:info")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data",  lpChamberOfCommerceService.info(id));
    }

    /**
     * 保存
     */
   @SysLog("保存信息")
   @ApiOperation("保存")
   @RequestMapping(value="/save",method = RequestMethod.POST)
   @RequiresPermissions("lp:lpchamberofcommerce:save")
    public R save(@RequestBody SysUserLpChamberOfCommerceVO vo) {
           if(vo.getUser()==null || StringUtils.isBlank(vo.getUser().getUsername()) || StringUtils.isBlank(vo.getUser().getPassword())){
                    return R.error("会员账户信息异常");
           }
           if(vo.getCommerce()==null){
               return R.error("商户信息异常");
           }
            lpChamberOfCommerceService.insertEntity(vo);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @RequestMapping(value="/saveAll",method = RequestMethod.POST)
    @RequiresPermissions("lp:lpchamberofcommerce:save")
    public R save(@RequestBody List<LpChamberOfCommerceEntity> lpChamberOfCommerce) {
            lpChamberOfCommerceService.saveAll(lpChamberOfCommerce);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @RequiresPermissions("lp:lpchamberofcommerce:update")
    public R update(@RequestBody SysUserLpChamberOfCommerceVO vo) {
            lpChamberOfCommerceService.updateEntity(vo);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @RequiresPermissions("lp:lpchamberofcommerce:delete")
    public R delete(@RequestBody Long[]ids) {
            lpChamberOfCommerceService.deleteBatchIds(Arrays.asList(ids));
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
         lpChamberOfCommerceService.sort(ids[0],ids[1]);
        return R.ok();
    }

    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig(String type) {
        //默认查询所有
        return R.ok().put("data",lpChamberOfCommerceService.selectTableConfig(type));
    }

}
