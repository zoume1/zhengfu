package com.szt.modules.sys.service;

import com.szt.common.CommonService;
import com.szt.modules.sys.entity.SysConfigEntity;

import java.util.Map;

/**
 * 系统字典管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 20:36:35
 */
public interface SysConfigService extends CommonService<SysConfigEntity> {


    /**
     * 保存配置信息
     */
    public void save(SysConfigEntity config);

    /**
     * 更新配置信息
     */
    public void update(SysConfigEntity config);

    /**
     * 根据key，更新value
     */
    public void updateValueByKey(String key, String value);

    /**
     * 删除配置信息
     */
    public void deleteBatch(Long[] ids);

    /**
     * 根据key，获取配置的value值
     *
     * @param key           key
     */
    public String getValue(String key);

    /**
     * 根据key，获取value的Object对象
     * @param key    key
     * @param clazz  Object对象
     */
    public <T> T getConfigObject(String key, Class<T> clazz);

    Map<String, SysConfigEntity> getConfig();

    void updateConfig(Map<String,SysConfigEntity> map);
}