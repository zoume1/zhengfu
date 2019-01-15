package com.szt.modules.generator.controller;


import com.alibaba.fastjson.JSON;
import com.szt.common.utils.R;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.generator.service.GeneratorModulesService;
import com.szt.modules.generator.service.GeneratorService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月19日 下午9:12:58
 */
@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController {
    @Autowired
    private GeneratorService sysGeneratorService;
    @Autowired
    private GeneratorModulesService generatorModulesService;

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        return R.ok().put("data", sysGeneratorService.queryList(params));
    }

    /**
     * 生成代码
     */
    @RequestMapping("/code")
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] tableNames = new String[]{};
        String tables = request.getParameter("tables");
        tableNames = JSON.parseArray(tables).toArray(tableNames);
        byte[] data = sysGeneratorService.generatorCode(tableNames);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"renren.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

    /**
     * 导入本地
     */
    @ApiOperation("导入本地")
    @PostMapping("/exportTables")
    @ResponseBody
    public R exportDataBase(@RequestBody List<GeneratorTableEntity> tab) {
        generatorModulesService.generatorCode(tab);
        return R.ok();
    }

    public static void main(String[] args) throws Exception {
        String str = "&#19978;&#28023;&#22768;&#20687;&#20986;";
        String newStr = StringEscapeUtils.unescapeXml(str);
        // 下边这个也行
        // String newStr=StringEscapeUtils.unescapeHtml(str);
        //转义之后的字符
        System.out.println(newStr);
    }
}
