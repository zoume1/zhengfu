package com.szt.modules.sys.dao;

import com.szt.modules.sys.entity.SysCaptchaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统验证码
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-11-15 09:19:36
 */
@Mapper
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {
    String fileds="        id,        remarks,        version_no,        create_by,        create_time,        update_by,        update_time,        delete_flag,        sort,        uuid,        code,        expire_time";

}
