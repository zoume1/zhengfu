package com.szt.modules.sys.service;

import com.szt.common.CommonService;
import com.szt.common.utils.PageUtils;
import com.szt.modules.sys.entity.SysPbAreaEntity;

import java.util.List;
import java.util.Map;

/**
 * 地址管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-08-20 00:11:07
 */
public interface SysPbAreaService extends CommonService<SysPbAreaEntity> {

    /**
     * 更新地址
     */
    void addressReload();

    /**
     * 刷新redis地址缓存
     */
    List<SysPbAreaEntity> addressRedisReload();

    /**
     * 获取数据
     */
    void defaultData();
}