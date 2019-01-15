package com.szt.modules.generator.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.szt.common.utils.Query;
import com.szt.modules.generator.entity.GeneratorTemplateEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 模板配置
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-27 21:07:36
 */
@Mapper
public interface GeneratorTemplateDao extends BaseMapper<GeneratorTemplateEntity> {
    String sqlFeild = "id,text,remark,url,file_name,version_no,create_by,create_time,update_by,update_time,delete_flag,sort";
    @Select("select "+sqlFeild+" from generator_template te where te.delete_flag='0' \n" +
            "order by te.sort")
    List<GeneratorTemplateEntity> queryGeneratorTemplateList();
    @Select("select "+sqlFeild+"  from generator_template where delete_flag in ('0','1')")
    List<GeneratorTemplateEntity> queryList(Query query);
    @Select("select count(id) from generator_template where delete_flag in ('0','1') ")
    int queryTotal(Query query);

    @Select("select "+sqlFeild+"  from generator_template where delete_flag ='2'")
    List<GeneratorTemplateEntity> queryGeneratorTemplateListByDelete();

}
