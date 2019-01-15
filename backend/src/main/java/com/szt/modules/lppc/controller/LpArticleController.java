package com.szt.modules.lppc.controller;

import java.util.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.szt.common.validator.ValidatorUtils;
import com.szt.modules.lp.entity.LpColumnEntity;
import com.szt.modules.sys.entity.SysPbAreaEntity;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.lp.entity.LpArticleEntity;
import com.szt.modules.lppc.service.LpArticleService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
/**
 * 文章管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:55:29
 */
@Slf4j
@Api(value = "文章管理接口", tags = "文章管理接口")
@RestController
@RequestMapping("lppc/lparticle")
@Controller("lppclparticle")
public class LpArticleController {
    @Autowired
    private LpArticleService lpArticleService;
    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = lpArticleService.queryPage(params,null);
        return R.ok().put("data", page);
    }

    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        LpArticleEntity lpArticle = lpArticleService.info(id);

        return R.ok().put("data", lpArticle);
    }
    /**
     *  查询最新的动态通知
     * @return
     */
    @ApiOperation("查询最新的10条文章通知")
    @GetMapping("/dynamicNotification")
    public R dynamicNotification() {
        return R.ok().put("data", lpArticleService.dynamicNotification());
    }

    /**
     * 查询首页文章
     */
    @ApiOperation("首页菜单文章数据")
    @RequestMapping(value="/searchHomeArticles",method = RequestMethod.GET)
    public R searchHomeArticles() {
        List<LpColumnEntity> data  = lpArticleService.searchHomeArticle();
        List<List<Object>> list = new ArrayList<List<Object>>();
        if(data.size()>2){
            List<Object> obj = new ArrayList<>();
            list.add(obj);
            obj.add(data.get(0));
            obj.add(data.get(1));
            for(int i=2;i<data.size();i+=3){
                obj = new ArrayList<>();
                list.add(obj);
                if(data.get(i)!=null){
                    obj.add(data.get(i));
                }
                if(i+1<data.size()){
                    obj.add(data.get(i+1));
                }
                if(i+2<data.size()){
                    obj.add(data.get(i+2));
                }
            }
        }else{
            List<Object> obj = new ArrayList<>();
            list.add(obj);
            for(int i=0;i<data.size();i++){
                obj.add(data.get(i));
            }
        }
        return R.ok().put("data", list);
    }
}
