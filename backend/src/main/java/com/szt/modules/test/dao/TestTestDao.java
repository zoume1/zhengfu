package com.szt.modules.test.dao;

import com.szt.modules.test.entity.TestTestEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 测试表管理
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-11-21 23:07:53
 */
@Mapper
public interface TestTestDao extends BaseMapper<TestTestEntity> {
    String fileds="        id,        remarks,        version_no,        create_by,        create_time,        update_by,        update_time,        delete_flag,        sort,        video";

}
