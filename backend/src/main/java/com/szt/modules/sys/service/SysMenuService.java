package com.szt.modules.sys.service;

import com.alibaba.fastjson.JSONArray;
import com.szt.common.CommonService;
import com.szt.modules.sys.entity.SysMenuEntity;

import java.util.List;

/**
 * 菜单管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-01 17:29:19
 */
public interface SysMenuService extends CommonService<SysMenuEntity> {
    /**
     * 查询所有路由
     */
    List<SysMenuEntity> router();
    /**
     * 获取用户菜单列表
     */
    JSONArray getUserMenuList(Long userId);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     * @param menuIdList  用户菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    void insertPermission(String comments, String moduleName, String pathName);

    void reMuneLevel();

    Object menuLevel(Long userId);
}