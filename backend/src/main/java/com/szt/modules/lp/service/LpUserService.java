package com.szt.modules.lp.service;

import com.szt.common.CommonService;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.lp.entity.LpUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 会员列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
public interface LpUserService extends CommonService<LpUserEntity> {

    @Override
    void insertEntity(LpUserEntity entity);

    @Override
    void updateEntity(LpUserEntity entity);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    LpUserEntity info(Long id);

    /**
     * 查询表字段
     * @param type
     * @return
     */
    GeneratorTableEntity selectTableConfig(String type);

    /**
     * 会员统计查询
     * @param type
     * @param coceralId
     * @param address
     * @return
     */
    List<Map<String,Object>> memberStatistics(String type, Long coceralId, String address);

    /**
     * 会员信息报表
     * @param type
     * @param coceralId
     * @param address
     * @return
     */
    Object informationReport(String type, Long coceralId, String address);

    /**
     * 会员增长报表
     * @param userType
     * @param coceralId
     * @param address
     * @param createTime
     * @return
     */
    List<Map<String, Object>> growthStatements(String userType, Long coceralId, String address, String createTime);
}