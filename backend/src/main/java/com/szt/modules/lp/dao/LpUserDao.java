package com.szt.modules.lp.dao;

import com.szt.modules.generator.entity.GeneratorBusConfigEntity;
import com.szt.modules.lp.entity.LpUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 会员列表
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@Mapper
public interface LpUserDao extends BaseMapper<LpUserEntity> {
    String fileds="        id,        remarks,        version_no,        create_by,        create_time,        update_by,        update_time,        delete_flag,        sort,        user_name,        name,        grade,        state";

    /**
     * 统计个人用户
     * @return
     * @param coceralId
     */
//    @Select("select c.conf_name name,count(u.id) count from generator_bus_config c \n" +
//            "left join lp_user u on c.conf_vue=u.grade and  u.user_type='0'\n" +
//            "where c.conf_code='lp_user_grade'\n" +
//            "group by c.conf_vue")
    List<Map<String,Object>> individualMembershipStatistics(@Param("coceralId") Long coceralId);
//    @Select("select " +
//            "c.conf_name name,count(u.id) count from generator_bus_config c \n" +
//            "left join lp_user u on c.conf_vue=u.industry_type and  u.user_type='1'\n" +
//            "where c.conf_code='lp_user_industry_type'\n" +
//            "group by c.conf_vue")
    List<Map<String,Object>> corporateMemberStatistics(@Param("coceralId") Long coceralId);
//    @Select("select c.conf_name name,count(u.id) count from generator_bus_config c \n" +
//            "left join lp_user u on c.conf_vue=u.group_category and  u.user_type='2'\n" +
//            "where c.conf_code='lp_user_group_category'\n" +
//            "group by c.conf_vue")
    List<Map<String,Object>> teamMembersStatistics(@Param("coceralId") Long coceralId);
//    @Select("select c.conf_name name,count(u.id) count from generator_bus_config c \n" +
//            "left join lp_user u on c.conf_vue=u.classification_of_industry and  u.user_type='1'\n" +
//            "where c.conf_code='lp_user_classification_of_industry'\n" +
//            "group by c.conf_vue")
    List<Map<String,Object>> enterpriseAreaStatistics(@Param("coceralId") Long coceralId);

    List<Map<String,Object>> sumStatistics(@Param("coceralId") Long coceralId);

    List<Map<String,Object>> enterpriseAreaReportForms(@Param("list") List<GeneratorBusConfigEntity> list, @Param("coceralId") Long coceralId,@Param("address")  String address);


    List<Map<String,Object>> corporateMemberReportForms(@Param("list") List<GeneratorBusConfigEntity> list, @Param("coceralId") Long coceralId,@Param("address")  String address);

    List<Map<String,Object>> teamMembersReportForms(@Param("list") List<GeneratorBusConfigEntity> list, @Param("coceralId") Long coceralId,@Param("address")  String address);

    List<Map<String,Object>> individualMembershipReportForms(@Param("list") List<GeneratorBusConfigEntity> list, @Param("coceralId") Long coceralId,@Param("address")  String address);

    List<Map<String,Object>> growthStatements(@Param("userType") String userType, @Param("coceralId") Long coceralId, @Param("address") String address,@Param("startDate") String startDate,@Param("endDate") String endDate);
}
