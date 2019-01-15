package com.szt.modules.generator.service.impl;

import com.szt.common.CommonServiceImpl;
import com.szt.modules.generator.dao.GeneratorTemplateConfigDao;
import com.szt.modules.generator.entity.GeneratorTemplateConfigEntity;
import com.szt.modules.generator.service.GeneratorTemplateConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 模板系统参数
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-29 02:26:57
 */
@Slf4j
@Service("generatorTemplateConfigService")
public class GeneratorTemplateConfigServiceImpl extends CommonServiceImpl<GeneratorTemplateConfigDao, GeneratorTemplateConfigEntity> implements GeneratorTemplateConfigService {


    @Override
    public Map<String, GeneratorTemplateConfigEntity> queryGeneratorTemplateConfig() {
        return baseMapper.queryGeneratorTemplateConfig();
    }
}
