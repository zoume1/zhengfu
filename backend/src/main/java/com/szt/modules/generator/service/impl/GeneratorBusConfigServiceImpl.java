package com.szt.modules.generator.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.szt.common.CommonServiceImpl;
import com.szt.common.exception.RRException;
import com.szt.common.utils.MybatsMap;
import com.szt.common.utils.TreeUtils;
import com.szt.modules.generator.dao.GeneratorBusConfigDao;
import com.szt.modules.generator.entity.ColumnListEntity;
import com.szt.modules.generator.entity.GeneratorBusConfigEntity;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.generator.service.GeneratorBusConfigService;
import com.szt.modules.generator.service.GeneratorTableService;
import com.szt.modules.sys.vo.QuerySysBusConfigListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自动生成参数管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 15:18:03
 */
@Service("generatorgeneratorBusConfigService")
public class GeneratorBusConfigServiceImpl extends CommonServiceImpl<GeneratorBusConfigDao, GeneratorBusConfigEntity> implements GeneratorBusConfigService {
    @Autowired
    private GeneratorTableService  generatorTableService;
    @Override
    public Map<String, QuerySysBusConfigListVO> querySysBusConfigList(String[] codes) {
        Map<String, QuerySysBusConfigListVO> map  = baseMapper.querySysBusConfigList(codes);
        for (Map.Entry<String, QuerySysBusConfigListVO> entry : map.entrySet()) {
            Map<String,String> map1 = new HashMap<>();
            QuerySysBusConfigListVO quer =  entry.getValue();
            for(GeneratorBusConfigEntity item : quer.getList()){
                map1.put(item.getConfVue(),item.getConfName());
            }
            quer.setMap(map1);
        }

        return map ;
    }

    @Override
    public void insertSysBusConfigPar(String selectKey, List<ColumnListEntity> list, Long id) {
        for(ColumnListEntity item : list){
            Map<String, Object> map = new HashMap<>();
            map.put("conf_code",selectKey);
            map.put("conf_vue",item.getMapKey());

            if (baseMapper.selectByMap(map).size() == 0) {
                GeneratorBusConfigEntity entity = new GeneratorBusConfigEntity();
                try {
                    entity.setTableId(id);
                    entity.setConfCode(selectKey);
                    entity.setConfVue(item.getMapKey());
                    entity.setConfName(item.getMapValue());
                    this.insertEntity(entity);
                }catch (Exception e){
                    e.printStackTrace();
                    throw new RRException("业务参数异常"+ JSON.toJSONString(entity),e);
                }
            }

        }
    }

    @Override
    public Map<String, Object> queryAppSysBusConfigList() {
        return baseMapper.queryAppSysBusConfigList();
    }

    @Override
    public QuerySysBusConfigListVO querySysBusConfigByKey(String key) {
        EntityWrapper<GeneratorTableEntity> wr = new EntityWrapper<GeneratorTableEntity> ();
        //查询所有业务表
        wr.eq("table_name",key);
       List<GeneratorTableEntity> list =  generatorTableService.selectList(wr);
        QuerySysBusConfigListVO quer = new QuerySysBusConfigListVO() ;
       for(GeneratorTableEntity tab : list){
           quer.setConfCode(tab.getTableName());
           Map<String,String> map1 = new HashMap<>();
           List<GeneratorBusConfigEntity> lists = generatorTableService.queryData(tab.getTableName(),tab.getBusinessKey(),tab.getBusinessValue());
           if(key.equals("generator_bus_config")){
               List<GeneratorTableEntity> tabList = generatorTableService.selectList(new EntityWrapper<>());
               for(GeneratorTableEntity item: tabList){
                   GeneratorBusConfigEntity tabEn=new GeneratorBusConfigEntity();
                   tabEn.setConfName(item.getTableName());
                   tabEn.setConfVue(item.getTableName());
                   lists.add(tabEn);
               }
           }
           quer.setList(lists);
           for(GeneratorBusConfigEntity items : quer.getList()){
               map1.put(items.getConfVue(),items.getConfName());
           }
           quer.setMap(map1);
       }
        return quer;
    }

    @Override
    public Map<String, GeneratorBusConfigEntity> querySysBusConfigByCodeKey(String key) {
        return  baseMapper.querySysBusConfigByCodeKey(key);
    }

    @Override
    public Map<String, QuerySysBusConfigListVO> queryModuleBusConfig(String module) {

        Map<String, QuerySysBusConfigListVO> map  = baseMapper.queryModuleBusConfig(module);
        for (Map.Entry<String, QuerySysBusConfigListVO> entry : map.entrySet()) {
            Map<String,String> map1 = new HashMap<>();
            QuerySysBusConfigListVO quer =  entry.getValue();
            for(GeneratorBusConfigEntity item : quer.getList()){
                map1.put(item.getConfVue(),item.getConfName());
            }
            quer.setMap(map1);
        }
        return map;
    }

    @Override
    public Object queryTreeConfigByKey(String key) {
        EntityWrapper<GeneratorTableEntity> wr = new EntityWrapper<GeneratorTableEntity> ();
        //查询所有业务表
        wr.eq("table_name",key);
        GeneratorTableEntity tab =  generatorTableService.selectOne(wr);
        if(tab==null){
            return new ArrayList<Object>();
        }
        Map<String,Object> map = new HashMap<String,Object>();
        List<MybatsMap> list =  generatorTableService.queryTreeConfigByKey(tab.getTableName());
        if(key.equals("sys_menu")){
            //添加顶级菜单
            MybatsMap root = new MybatsMap();
            root.put("id",0L);
            root.put("name","一级菜单");
            root.put("parent_id",-1L);
            root.put("open",true);
            list.add(0,root);
        }
        JSONArray result = TreeUtils.listToTree(JSONArray.parseArray(JSON.toJSONString(list)),tab.getTreeKey(),tab.getParentKey(),"children");
        map.put("data",result);
        map.put("label",tab.getTreeFieldName());
        return map;
    }

    @Override
    @Transactional
    public void reloadBusconfig() {
        List<GeneratorTableEntity> list = generatorTableService.selectList(null);
        for(GeneratorTableEntity tab  : list){
            EntityWrapper<GeneratorBusConfigEntity> ew = new EntityWrapper<GeneratorBusConfigEntity>();
            ew.like("conf_code",tab.getTableName());
            List<GeneratorBusConfigEntity> bus = baseMapper.selectList(ew);
            for(GeneratorBusConfigEntity item : bus){
                item.setTableId(tab.getId());
                 baseMapper.updateById(item);
            }
        }
    }

    @Override
    public void insertEntity(GeneratorBusConfigEntity entity){
        entity.insert();
        baseMapper.insert(entity);
        //InitBusConfig.updateBuConfig(entity.getConfCode());
    }
    @Override
    public void updateEntity(GeneratorBusConfigEntity entity){
        entity.update();
        baseMapper.updateById(entity);
       // InitBusConfig.updateBuConfig(entity.getConfCode());
    }
}
