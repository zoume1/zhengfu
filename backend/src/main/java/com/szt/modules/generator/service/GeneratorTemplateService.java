package com.szt.modules.generator.service;

import com.szt.common.CommonService;
import com.szt.modules.generator.entity.GeneratorTemplateEntity;

import java.util.List;

/**
 * 模板配置
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-27 21:07:36
 */
public interface GeneratorTemplateService extends CommonService<GeneratorTemplateEntity> {
    /**
     * 删除模板文件
     * @param longs
     */
    void deleteFile(List<Long> longs);

    /**
     * 保存模板文件
     * @param generatorTemplate
     */
    void insertFile(GeneratorTemplateEntity generatorTemplate);

    /**
     * 修改文本内容
     * @param generatorTemplate
     */
    void updateByIdFile(GeneratorTemplateEntity generatorTemplate);

    /**
     * 从本地资源中删除文件
     */
    void removeFile();

    /**
     * 查询所有存在的模板
     * @return
     */
    List<GeneratorTemplateEntity> queryGeneratorTemplateList();
}

