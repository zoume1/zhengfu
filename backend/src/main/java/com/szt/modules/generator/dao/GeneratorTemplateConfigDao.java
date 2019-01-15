package com.szt.modules.generator.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.szt.modules.generator.entity.GeneratorTemplateConfigEntity;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * 模板系统参数
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-29 02:26:57
 */
@Mapper
public interface GeneratorTemplateConfigDao extends BaseMapper<GeneratorTemplateConfigEntity> {
    /**
     * 查询Map方式的模板系统参数
     * @return
     */
    @MapKey("modelKey")
    @Select("select c.id,c.model_key,c.model_val from generator_template_config c where c.delete_flag='0'")
    Map<String,GeneratorTemplateConfigEntity> queryGeneratorTemplateConfig();
}
