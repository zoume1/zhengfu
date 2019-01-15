package com.szt.modules.bbgl.controller;
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
import com.szt.modules.bbgl.entity.BbglInformationStatisticsEntity;
import com.szt.modules.bbgl.service.BbglInformationStatisticsService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * 会员情况综合统计
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-30 12:00:32
 */
@Slf4j
@Api(value = "会员情况综合统计接口", tags = "会员情况综合统计接口")
@RestController
@RequestMapping("bbgl/bbglinformationstatistics")
@Controller("bbglbbglinformationstatistics")
public class BbglInformationStatisticsController {
    @Autowired
    private BbglInformationStatisticsService bbglInformationStatisticsService;

    /**
     * 列表
     */
   @ApiOperation("列表")
   @RequestMapping(value="/list",method = RequestMethod.GET)
   @RequiresPermissions("bbgl:bbglinformationstatistics:list")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",required = true,paramType="query",dataType = "int"),
            @ApiImplicitParam(name="limit",value="每页数量",required = true,paramType="query",dataType = "int"),
            @ApiImplicitParam(name="sidx",value="排序字段",required = true,paramType="query"),
            @ApiImplicitParam(name="order",value="升序降序",required = true,paramType="query"),
    })
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = bbglInformationStatisticsService.queryPage(params,null);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
   @ApiOperation("信息")
   @RequestMapping(value="/info/{id}",method = RequestMethod.GET)
   @RequiresPermissions("bbgl:bbglinformationstatistics:info")
    public R info(@PathVariable("id") Long id) {
            BbglInformationStatisticsEntity bbglInformationStatistics = bbglInformationStatisticsService.selectById(id);

        return R.ok().put("data", bbglInformationStatistics);
    }

    /**
     * 保存
     */
   @SysLog("保存信息")
   @ApiOperation("保存")
   @RequestMapping(value="/save",method = RequestMethod.POST)
   @RequiresPermissions("bbgl:bbglinformationstatistics:save")
    public R save(@RequestBody BbglInformationStatisticsEntity bbglInformationStatistics) {
            bbglInformationStatisticsService.insertEntity(bbglInformationStatistics);
        return R.ok();
    }
    /**
     * 批量保存
     */
    @SysLog("批量保存信息")
    @ApiOperation("批量保存")
    @RequestMapping(value="/saveAll",method = RequestMethod.POST)
    @RequiresPermissions("bbgl:bbglinformationstatistics:save")
    public R save(@RequestBody List<BbglInformationStatisticsEntity> bbglInformationStatistics) {
            bbglInformationStatisticsService.saveAll(bbglInformationStatistics);
        return R.ok();
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @RequiresPermissions("bbgl:bbglinformationstatistics:update")
    public R update(@RequestBody BbglInformationStatisticsEntity bbglInformationStatistics) {
            bbglInformationStatisticsService.updateEntity(bbglInformationStatistics);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @RequiresPermissions("bbgl:bbglinformationstatistics:delete")
    public R delete(@RequestBody Long[]ids) {
            bbglInformationStatisticsService.deleteBatchIds(Arrays.asList(ids));
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
         bbglInformationStatisticsService.sort(ids[0],ids[1]);
        return R.ok();
    }
 /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",bbglInformationStatisticsService.selectTableConfig());
    }
}
