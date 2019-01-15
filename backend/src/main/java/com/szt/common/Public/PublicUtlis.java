package com.szt.common.Public;

import com.szt.common.utils.IPUtils;
import com.szt.common.utils.MacUtils;
import com.szt.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author zhengjinhua
 * @date 2018-07-12
 */
public class PublicUtlis {
    private String userName;
    private Long userId;
    private String ip;
    private String mac;
    private Date date;

    /**
     * 构造函数用于从初始化字段
     * @param request
     */
    public PublicUtlis(HttpServletRequest request){
        userName = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUsername();
        userId = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getId();
        ip = IPUtils.getIpAddr(request);
        mac = MacUtils.getMacAddress(ip);
        date = new Date();
    }

    /**
     * 插入时是添加数据
     * @param publicEntity
     */
    public void insertCommon(PublicEntity publicEntity){
        publicEntity.setCreateUserName(this.userName);
        publicEntity.setCreateBy(this.userId);
        publicEntity.setCreateIp(this.ip);
        publicEntity.setCreateMac(this.mac);
        publicEntity.setCreateTime(this.date);
        publicEntity.setUpdateUserName(this.userName);
        publicEntity.setUpdateBy(this.userId);
        publicEntity.setUpdateIp(this.ip);
        publicEntity.setUpdateMac(this.mac);
        publicEntity.setUpdateTime(this.date);
    }

    /**
     * 逻辑删除时插入|更新数据
     * @param publicEntity
     */
    public void deleteCommon(PublicEntity publicEntity){
        publicEntity.setDeleteUserName(this.userName);
        publicEntity.setDeleteBy(this.userId);
        publicEntity.setDeleteIp(this.ip);
        publicEntity.setDeleteMac(this.mac);
        publicEntity.setDeleteTime(this.date);
    }

    /**
     * 更新数据
     * @param publicEntity
     */
    public void updateCommon(PublicEntity publicEntity){
        publicEntity.setUpdateUserName(this.userName);
        publicEntity.setUpdateBy(this.userId);
        publicEntity.setUpdateIp(this.ip);
        publicEntity.setUpdateMac(this.mac);
        publicEntity.setUpdateTime(this.date);
    }
}
