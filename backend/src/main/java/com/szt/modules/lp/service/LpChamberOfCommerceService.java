package com.szt.modules.lp.service;

import com.szt.common.CommonService;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.lp.entity.LpChamberOfCommerceEntity;
import com.szt.modules.lp.vo.SysUserLpChamberOfCommerceVO;

import java.util.Map;

/**
 * 商会列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-22 17:08:35
 */
public interface LpChamberOfCommerceService extends CommonService<LpChamberOfCommerceEntity> {

    /**
     * 插入商会信息
     * @param lpChamberOfCommerce
     */
    void insertEntity(SysUserLpChamberOfCommerceVO lpChamberOfCommerce);

    Object selectTableConfig(String type);

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    Object info(Long id);

    /**
     * 修改商户信息
     * @param vo
     */
    void updateEntity(SysUserLpChamberOfCommerceVO vo);
}