package com.szt.modules.generator.vo;

import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.generator.entity.GeneratorTableFieldEntity;

import java.util.List;

/**
 * 表格与字段结合
 */
public class TableFieldVo extends GeneratorTableEntity {

    /**
     * 字段结果集合
     */
    List<GeneratorTableFieldEntity> list;
    /**
     * 模块名称
     */
    private String modulesName;
    public List<GeneratorTableFieldEntity> getList() {
        return list;
    }

    public void setList(List<GeneratorTableFieldEntity> list) {
        this.list = list;
    }

    public String getModulesName() {
        return modulesName;
    }

    public void setModulesName(String modulesName) {
        this.modulesName = modulesName;
    }
}
