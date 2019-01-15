package com.szt.common;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.szt.common.utils.PageUtils;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.sys.entity.SysCommcomFieldEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 公共业务层
 */
public interface CommonService<T> extends IService<T> {
    /**
     * 自动分页查询
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params, Wrapper<T> wr);

    /**
     * 逻辑删除
     *
     * @param ids
     * @param sysCommcomFieldEntity
     */
    void deleteFlagIds(Long[] ids, SysCommcomFieldEntity sysCommcomFieldEntity);

    /**
     * 新增
     */
    void insertEntity(T entity);

    /**
     * 批量新增
     *
     * @param list
     */
    @Transactional
    void saveAll(List<T> list);

    /**
     * 修改数据
     *
     * @param entity
     */
    void updateEntity(T entity);

    /**
     * 删除用户信息
     *
     * @param ids
     */
    void deleteList(List<Long> ids);

    void sort(Long id, Long id1);
    /**
     * 升级版表格字段数据查询
     */
    GeneratorTableEntity selectTableConfig();
}
