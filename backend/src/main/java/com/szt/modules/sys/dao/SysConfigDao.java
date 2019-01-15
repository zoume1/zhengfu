package com.szt.modules.sys.dao;

import com.szt.modules.sys.entity.SysConfigEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * 系统字典管理
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 20:36:35
 */
@Mapper
public interface SysConfigDao extends BaseMapper<SysConfigEntity> {
    String fields = "id,        data_key,        value,        status,        remarks,        version_no,        create_by,        create_time,        update_by,        update_time,        delete_flag,        sort";
    /**
     * 根据key，查询value
     */
    SysConfigEntity queryByKey(String paramKey);

    /**
     * 根据key，更新value
     */
    int updateValueByKey(@Param("key") String key, @Param("value") String value);
    @MapKey("dataKey")
    @Select("SELECT "+fields+" FROM `sys_config` where data_key !='CLOUD_STORAGE_CONFIG_KEY';")
    Map<String,SysConfigEntity> getConfig();
}
