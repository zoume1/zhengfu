package com.szt.modules.generator.service;

import com.szt.common.CommonService;
import com.szt.common.utils.PageUtils;
import com.szt.modules.generator.entity.GeneratorModulesEntity;

import java.util.Map;

/**
 * 代码生成器
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月19日 下午3:33:38
 */

public interface GeneratorService  extends CommonService<GeneratorModulesEntity> {

    PageUtils queryList(Map<String,Object> params);

    byte[] generatorCode(String[] tableNames);
}
