package com.szt.modules.sys.service.impl;

import com.google.gson.Gson;
import com.szt.common.exception.RRException;
import com.szt.modules.sys.redis.SysConfigRedis;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.sys.dao.SysConfigDao;
import com.szt.modules.sys.entity.SysConfigEntity;
import com.szt.modules.sys.service.SysConfigService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Map;

/**
 * 系统字典管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 20:36:35
 */
@Service("syssysConfigService")
public class SysConfigServiceImpl extends CommonServiceImpl<SysConfigDao, SysConfigEntity> implements SysConfigService {

    @Autowired
    private SysConfigRedis sysConfigRedis;



    @Override
    public void save(SysConfigEntity config) {
        this.insert(config);
        sysConfigRedis.saveOrUpdate(config);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysConfigEntity config) {
        this.updateById(config);
        sysConfigRedis.saveOrUpdate(config);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateValueByKey(String key, String value) {
        baseMapper.updateValueByKey(key, value);
        sysConfigRedis.delete(key);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] ids) {
        for(Long id : ids){
            SysConfigEntity config = this.selectById(id);
            sysConfigRedis.delete(config.getDataKey());
        }

        this.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public String getValue(String key) {
        SysConfigEntity config = sysConfigRedis.get(key);
        if(config == null){
            config = baseMapper.queryByKey(key);
            sysConfigRedis.saveOrUpdate(config);
        }

        return config == null ? null : config.getValue();
    }

    @Override
    public <T> T getConfigObject(String key, Class<T> clazz) {
        String value = getValue(key);
        if(StringUtils.isNotBlank(value)){
            return new Gson().fromJson(value, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RRException("获取参数失败");
        }
    }

    @Override
    public Map<String, SysConfigEntity> getConfig() {
        return baseMapper.getConfig();
    }

    @Override
    @Transactional
    public void updateConfig(Map<String, SysConfigEntity> map) {
        for(Map.Entry<String, SysConfigEntity> item : map.entrySet()){
            SysConfigEntity entitiy = item.getValue();
            this.update(entitiy);
        }
    }

}
