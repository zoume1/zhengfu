package com.szt.modules.generator.service;

import com.szt.common.CommonService;
import com.szt.modules.generator.entity.ColumnListEntity;
import com.szt.modules.generator.entity.GeneratorBusConfigEntity;
import com.szt.modules.sys.vo.QuerySysBusConfigListVO;

import java.util.List;
import java.util.Map;

/**
 * 自动生成参数管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 15:18:03
 */
public interface GeneratorBusConfigService extends CommonService<GeneratorBusConfigEntity>  {

    /**
     * 查询所有业务参数
     * @param codes
     */
    Map<String, QuerySysBusConfigListVO> querySysBusConfigList(String[] codes);

    /**
     * 插入业务参数
     * @param selectKey
     * @param list
     * @param id
     */
    void insertSysBusConfigPar(String selectKey, List<ColumnListEntity> list, Long id);

    /**
     * 查询app业务参数
     * * @return
     */
    Map<String,Object> queryAppSysBusConfigList();

    QuerySysBusConfigListVO querySysBusConfigByKey(String key);

    /**
     * 查询表格业务参数
     * @param key
     * @return
     */
    Map<String,GeneratorBusConfigEntity> querySysBusConfigByCodeKey(String key);

    /**
     * 根据模块查询所需的业务参数
     * @param module
     * @return
     */
    Map<String, QuerySysBusConfigListVO> queryModuleBusConfig(String module);

    /**
     * 查询tree表格数据
     * @param key
     * @return
     */
    Object queryTreeConfigByKey(String key);

    /**
     * 重新加载业务参数tabId
     */
    void reloadBusconfig();
}

