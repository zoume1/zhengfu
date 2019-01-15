package com.szt.modules.generator.schedule;

import com.szt.modules.generator.service.GeneratorTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Component
public class GeneratorTemplateSchedule {
    @Autowired
    private GeneratorTemplateService service;
    /**
     * 删除文件
     */
    public void removeFile(String s){
        service.removeFile();
    }
}
