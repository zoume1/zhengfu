package com.szt.modules.generator.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.szt.common.utils.SpringContextUtils;
import com.szt.common.utils.TreeUtils;
import com.szt.config.RedisUtil;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.generator.service.GeneratorBusConfigService;
import com.szt.modules.generator.service.GeneratorTableService;
import com.szt.modules.sys.entity.SysPbAreaEntity;
import com.szt.modules.sys.service.SysPbAreaService;
import com.szt.modules.sys.vo.QuerySysBusConfigListVO;
import lombok.experimental.var;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 初始化系统参数
 */
@Component
public class InitBusConfig {
//    /**
//     * 业务参数key
//     */
//    public static String BU_CONFIG_KEY = "BU_CONFIG_KEY";
//    /**
//     * 表格业务参数
//     */
//    public static String TAB_CONFIG_KEY = "TAB_CONFIG_KEY";
//    /**
//     * redis地址缓存
//     */
//    public static String ADDRESS_CONFIG_KEY = "ADDRESS_CONFIG_KEY";
//
//    public static String generatortablefieldfieldtype = "generator_table_field_field_type";
//    /**
//     * 业务参数封装所有业务参数统一表名+字段名
//     */
//    public static RedisUtil redisUtils;
//    private static GeneratorBusConfigService generatorBusConfigService;
//    private static GeneratorTableService generatorTableService;
//    private static SysPbAreaService sysPbAreaService;
//    static {
//        redisUtils=SpringContextUtils.getBean("redisUtil",RedisUtil.class);
////        generatorBusConfigService=SpringContextUtils.getBean("generatorgeneratorBusConfigService",GeneratorBusConfigService.class);
////        generatorTableService=SpringContextUtils.getBean("generatorTableService",GeneratorTableService.class);
////        sysPbAreaService=SpringContextUtils.getBean("syssysPbAreaService",SysPbAreaService.class);
//        //redisUtils.hSetMap(BU_CONFIG_KEY, generatorBusConfigService.querySysBusConfigList(null));
//      //  redisUtils.hSetMap(TAB_CONFIG_KEY,  generatorTableService.queryTableFilePreviewVO(null));
////        updateAddressConfig();
//    }
//    /**
//     * 获取字段类型
//     * @return
//     */
//    public static QuerySysBusConfigListVO getFieldType() {
//        return redisUtils.hGetMap(BU_CONFIG_KEY, generatortablefieldfieldtype);
//    }
//    /**
//     * 获取业务数据
//     * @return
//     */
//    public static Map<String, GeneratorTableEntity> getBusConfig() {
//        return redisUtils.hGetMap(BU_CONFIG_KEY);
//    }
//    /**
//     * 更新业务参数
//     * @param confCode
//     */
//    public static void updateBuConfig(String confCode) {
//        redisUtils.hSetMap(BU_CONFIG_KEY,generatorBusConfigService.querySysBusConfigList(new String[]{confCode}));
//    }
//    /**
//     * 删除业务参数
//     * @param confCode
//     */
//    public static void deleteBuConfig(String confCode) {
//        redisUtils.deleteMap(BU_CONFIG_KEY,confCode);
//    }
//
//    /**
//     * 获取tab数据
//     * @return
//     */
//    public static Map<String, GeneratorTableEntity> getTabConfig() {
//        return redisUtils.hGetMap(TAB_CONFIG_KEY);
//    }
//
//    /**
//     * 更新表格数据
//     * @return
//     */
//    public static void updateTabConfig(String tabName) {
//        redisUtils.hSetMap(TAB_CONFIG_KEY,generatorTableService.queryTableFilePreviewVO(new String[]{tabName}));
//    }
//    /**
//     * 更新地址数据数据
//     * @return
//     */
//    public static void updateAddressConfig() {
//        List<SysPbAreaEntity> list =  sysPbAreaService.selectList(null);
//        JSONArray result = TreeUtils.listToTree(JSONArray.parseArray(JSON.toJSONString(list)),"id","parentid","children");
//        Map<Long,String> map = new HashMap<>();
//        Map<String,Object> obj = new HashMap<>();
//        for(SysPbAreaEntity item : list){
//            map.put(item.getId(),item.getAreaname());
//        }
//        obj.put("address",result);
//        obj.put("addressMap",map);
//         redisUtils.set(ADDRESS_CONFIG_KEY,obj);
//    }
//    /**
//     * 获取地址数据数据
//     * @return
//     */
//    public static Map<String,Object> getAddressConfig() {
//        return (Map<String, Object>) redisUtils.get(ADDRESS_CONFIG_KEY);
//    }
}
