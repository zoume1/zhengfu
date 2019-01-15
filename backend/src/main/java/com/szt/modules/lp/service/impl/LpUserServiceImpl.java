package com.szt.modules.lp.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.szt.common.exception.RRException;
import com.szt.modules.generator.dao.GeneratorBusConfigDao;
import com.szt.modules.generator.dao.GeneratorTableDao;
import com.szt.modules.generator.entity.GeneratorBusConfigEntity;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.generator.entity.GeneratorTableFieldEntity;
import com.szt.modules.lp.constant.LpUserConstant;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szt.common.CommonServiceImpl;
import com.szt.modules.lp.dao.LpUserDao;
import com.szt.modules.lp.entity.LpUserEntity;
import com.szt.modules.lp.service.LpUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 会员列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Service("lplpUserService")
public class LpUserServiceImpl extends CommonServiceImpl<LpUserDao, LpUserEntity> implements LpUserService {
    @Autowired
    private GeneratorTableDao generatorTableDao;
    @Autowired
    private GeneratorBusConfigDao generatorBusConfigDao;
    @Override
    public void insertEntity(LpUserEntity entity) {
        LpUserEntity entity1 = new LpUserEntity();
        entity1.setUserName(entity.getUserName());
        if(baseMapper.selectOne(entity1)!=null){
            throw new RRException("用户名已存在！");
        }
        entity.insert();
        entity.setState(LpUserConstant.LP_USER_STATE_0);
        String salt = RandomStringUtils.randomAlphanumeric(20);
        entity.setPassword(new Sha256Hash(entity.getPassword(), salt).toHex());
        entity.setSalt(salt);
        baseMapper.insert(entity);
    }

    @Override
    public void updateEntity(LpUserEntity entity) {
        if(StringUtils.isBlank(entity.getPassword())){
            entity.setPassword(null);
        }else{
            entity.setPassword(new Sha256Hash(entity.getPassword(), entity.getSalt()).toHex());
        }
        entity.update();
        baseMapper.updateById(entity);
    }

    @Override
    public LpUserEntity info(Long id) {
        LpUserEntity user = baseMapper.selectById(id);
        user.setPassword(null);
        return user;
    }

    @Override
    public GeneratorTableEntity selectTableConfig(String type) {
        GeneratorTableEntity tab=super.selectTableConfig();
        //取出个人类型
         if(LpUserConstant.LP_USER_USER_TYPE_0.equals(type)){

        }
        //取出企业类型
        else if(LpUserConstant.LP_USER_USER_TYPE_1.equals(type)){
             Map<String,Map<String,Boolean>> map = new HashMap<>();
             map.put("entrepreneurName",new HashMap<String,Boolean>(){{
                 put("tab",true);
                 put("isSeek",true);
             }});
             map.put("industryType",new HashMap<String,Boolean>(){{
                 put("tab",true);
                 put("isSeek",true);
             }});
             map.put("classificationOfIndustry",new HashMap<String,Boolean>(){{
                 put("tab",true);
                 put("isSeek",true);
             }});
             map.put("administrativeRegion",new HashMap<String,Boolean>(){{
                 put("tab",true);
                 put("isSeek",true);
             }});
             map.put("sex",new HashMap<String,Boolean>(){{
                 put("tab",false);
                 put("isSeek",false);
             }});
             map.put("name",new HashMap<String,Boolean>(){{
                 put("tab",false);
                 put("isSeek",false);
             }});
             map.put("politicsStatus",new HashMap<String,Boolean>(){{
                 put("tab",false);
                 put("isSeek",false);
             }});
             map.put("education",new HashMap<String,Boolean>(){{
                 put("tab",false);
                 put("isSeek",false);
             }});
             map.put("grade",new HashMap<String,Boolean>(){{
                 put("tab",false);
                 put("isSeek",false);
             }});
             map.put("contactPhone",new HashMap<String,Boolean>(){{
                 put("tab",false);
                 put("isSeek",false);
             }});
//             map.put("groupStatutoryRepresentativeName",new HashMap<String,Boolean>(){{
//                 put("tab",true);
//                 put("isSeek",false);
//             }});
             //遍历所有字段
             for(GeneratorTableFieldEntity item : tab.getColumns()){
                 Map<String, Boolean> obj = map.get(item.getFieldName());
                 if(obj!=null){
                     item.setTableSet(obj.get("tab")?"0":"1");
                     item.setIsSeek(obj.get("isSeek")?"0":"1");
                 }
             }
        }
        //取出团体类型
        else if(LpUserConstant.LP_USER_USER_TYPE_2.equals(type)){
             Map<String,Map<String,Boolean>> map = new HashMap<>();
             map.put("groupName",new HashMap<String,Boolean>(){{
                 put("tab",true);
                 put("isSeek",true);
             }});
             map.put("groupCategory",new HashMap<String,Boolean>(){{
                 put("tab",true);
                 put("isSeek",true);
             }});
             map.put("groupAdministrativeRegion",new HashMap<String,Boolean>(){{
                 put("tab",true);
                 put("isSeek",true);
             }});
             map.put("grade",new HashMap<String,Boolean>(){{
                 put("tab",false);
                 put("isSeek",false);
             }});
             map.put("sex",new HashMap<String,Boolean>(){{
                 put("tab",false);
                 put("isSeek",false);
             }});
             map.put("name",new HashMap<String,Boolean>(){{
                 put("tab",false);
                 put("isSeek",false);
             }});
            map.put("politicsStatus",new HashMap<String,Boolean>(){{
                 put("tab",false);
                 put("isSeek",false);
             }});
             map.put("education",new HashMap<String,Boolean>(){{
                 put("tab",false);
                 put("isSeek",false);
             }});
             map.put("contactPhone",new HashMap<String,Boolean>(){{
                 put("tab",false);
                 put("isSeek",false);
             }});
              map.put("groupStatutoryRepresentativeName",new HashMap<String,Boolean>(){{
                 put("tab",true);
                 put("isSeek",false);
             }});
             //遍历所有字段
            for(GeneratorTableFieldEntity item : tab.getColumns()){
                Map<String, Boolean> obj = map.get(item.getFieldName());
                if(obj!=null){
                    item.setTableSet(obj.get("tab")?"0":"1");
                    item.setIsSeek(obj.get("isSeek")?"0":"1");
                }
            }
         }
        return tab;
    }

    @Override
    public List<Map<String,Object>> memberStatistics(String type, Long coceralId, String address) {
        //会员综合情况统计表
        if("0".equals(type)) {
            return baseMapper.sumStatistics(coceralId);
        }
        //企业会员按地区查询
        else if("1".equals(type)){
               return  baseMapper.enterpriseAreaStatistics(coceralId);
        }
        //企业会员按地区注册类型统计表
        else if("2".equals(type)){
             return  baseMapper.corporateMemberStatistics(coceralId);
        }//团体会员统计表
        else if("3".equals(type)){
            return  baseMapper.teamMembersStatistics(coceralId);
        }
        //个人会员统计表
        else if("4".equals(type)){
            return  baseMapper.individualMembershipStatistics(coceralId);
        }else{
            throw new RRException("统计类型不存在");
        }
    }

    @Override
    public Object informationReport(String type, Long coceralId, String address) {
        //会员情况综合统计表
        if("0".equals(type)) {
            return baseMapper.sumStatistics(coceralId);
        }
        //企业会员按地区行业统计表
        else if("1".equals(type)){
            List<GeneratorBusConfigEntity> list = generatorBusConfigDao.queryGeneratorBusConfigList("lp_user_classification_of_industry");
            Map<String,Object> map = new HashMap<String,Object>(){{
               put("list",list) ;
               put("data",baseMapper.enterpriseAreaReportForms(list,coceralId,address));
            }};
            return  map;
        }
        //企业会员按地区注册类型统计表
        else if("2".equals(type)){
            List<GeneratorBusConfigEntity> list = generatorBusConfigDao.queryGeneratorBusConfigList("lp_user_industry_type");
            Map<String,Object> map = new HashMap<String,Object>(){{
                put("list",list) ;
                put("data",baseMapper.corporateMemberReportForms(list,coceralId,address));
            }};
            return  map;
        }
        //团体会员
        else if("3".equals(type)){
            List<GeneratorBusConfigEntity> list = generatorBusConfigDao.queryGeneratorBusConfigList("lp_user_group_category");
            Map<String,Object> map = new HashMap<String,Object>(){{
                put("list",list) ;
                put("data",baseMapper.teamMembersReportForms(list,coceralId,address));
            }};
            return  map;
        }
        //团体会员统计表
        else if("4".equals(type)){
            List<GeneratorBusConfigEntity> list = generatorBusConfigDao.queryGeneratorBusConfigList("lp_user_grade");
            Map<String,Object> map = new HashMap<String,Object>(){{
                put("list",list) ;
                put("data",baseMapper.individualMembershipReportForms(list,coceralId,address));
            }};
            return  map;  }
        //个人会员统计表
        else if("4".equals(type)){
            return  baseMapper.individualMembershipStatistics(coceralId);
        }
        //会员类型及行业统计表（本级）
        else if("4".equals(type)){
            return  baseMapper.individualMembershipStatistics(coceralId);
        }
        //会员类型及行业统计表（合计）
        else if("4".equals(type)){
            return  baseMapper.individualMembershipStatistics(coceralId);
        }else{
            throw new RRException("统计类型不存在");
        }
    }

    @Override
    public List<Map<String, Object>> growthStatements(String userType, Long coceralId, String address, String createTime) {
        JSONArray jsonStr = JSONArray.parseArray(createTime);
        String startDate = (String) jsonStr.get(0);
        String endDate = (String) jsonStr.get(1);
        return baseMapper.growthStatements(userType, coceralId, address,startDate,endDate);
    }
}
