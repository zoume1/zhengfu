package com.szt.modules.test.controller;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
import com.szt.modules.test.entity.TestTestEntity;
import com.szt.modules.test.service.TestTestService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * 测试表管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-11-21 23:07:53
 */
@Slf4j
@Api(value = "测试表管理接口", tags = "测试表管理接口")
@RestController
@RequestMapping("test/testtest")
@Controller("testtesttest")
public class TestTestController {
    @Autowired
    private TestTestService testTestService;

    /**
     * 列表
     */
   @ApiOperation("列表")
   @RequestMapping(value="/list",method = RequestMethod.GET)
   @RequiresPermissions("test:testtest:list")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",required = true,paramType="query",dataType = "int"),
            @ApiImplicitParam(name="limit",value="每页数量",required = true,paramType="query",dataType = "int"),
            @ApiImplicitParam(name="sidx",value="排序字段",required = true,paramType="query"),
            @ApiImplicitParam(name="order",value="升序降序",required = true,paramType="query"),
    })
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = testTestService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
   @ApiOperation("信息")
   @RequestMapping(value="/info/{id}",method = RequestMethod.GET)
   @RequiresPermissions("test:testtest:info")
    public R info(@PathVariable("id") Long id) {
            TestTestEntity testTest = testTestService.selectById(id);

        return R.ok().put("data", testTest);
    }

    /**
     * 保存
     */
   @SysLog("保存信息")
   @ApiOperation("保存")
   @RequestMapping(value="/save",method = RequestMethod.POST)
   @RequiresPermissions("test:testtest:save")
    public R save(@RequestBody TestTestEntity testTest) {
            testTestService.insertEntity(testTest);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @RequestMapping(value="/saveAll",method = RequestMethod.POST)
    @RequiresPermissions("test:testtest:save")
    public R save(@RequestBody List<TestTestEntity> testTest) {
            testTestService.saveAll(testTest);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @RequiresPermissions("test:testtest:update")
    public R update(@RequestBody TestTestEntity testTest) {
            testTestService.updateEntity(testTest);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @RequiresPermissions("test:testtest:delete")
    public R delete(@RequestBody Long[]ids) {
            testTestService.deleteBatchIds(Arrays.asList(ids));
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
         testTestService.sort(ids[0],ids[1]);
        return R.ok();
    }
 /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",testTestService.selectTableConfig());
    }
}
