package com.szt.modules.generator.service;

import com.szt.common.CommonService;
import com.szt.modules.generator.entity.GeneratorTemplateConfigEntity;

import java.util.Map;

/**
 * 模板系统参数
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-29 02:26:57
 */
public interface GeneratorTemplateConfigService extends CommonService<GeneratorTemplateConfigEntity> {
    /**
     * 查询系统map参数
     * @return
     */
    Map<String,GeneratorTemplateConfigEntity> queryGeneratorTemplateConfig();

}

