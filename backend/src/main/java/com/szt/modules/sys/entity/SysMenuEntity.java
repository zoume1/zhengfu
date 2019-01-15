package com.szt.modules.sys.entity;
import com.szt.common.CommonConstant;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.szt.common.CommonEntitiy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.shiro.SecurityUtils;
import com.szt.modules.sys.entity.SysUserEntity;
import com.szt.modules.sys.entity.SysCommcomFieldEntity;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import java.io.Serializable;
import java.util.Date;

/**
 * 菜单管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-10 18:31:47
 */
@TableName("sys_menu")
public class SysMenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 类型@0-目录,1-菜单 ,2-按钮
     */
    @ApiModelProperty(value = "类型@0-目录,1-菜单 ,2-按钮",required = true)
    private String type;
    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称",required = true)
    private String name;
    /**
     * 层级
     */
    @NotNull(message="层级不能为空")
    @ApiModelProperty(value = "层级",required = false)
    private Integer level;
    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value = "主键",required = false)
    private Long id;
    /**
     * 父菜单ID
     */
    @ApiModelProperty(value = "父菜单ID",required = true)
    private Long parentId;
    /**
     * 菜单URL
     */
    @ApiModelProperty(value = "菜单URL",required = true)
    private String url;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    @ApiModelProperty(value = "授权(多个用逗号分隔，如：user:list,user:create)",required = true)
    private String perms;
    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标",required = true)
    private String icon;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注",required = true)
    private String remarks;
    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号",required = true)
    private Integer versionNo;
    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id",required = true)
    private Long createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",required = true)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改人id
     */
    @ApiModelProperty(value = "修改人id",required = true)
    private Long updateBy;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间",required = true)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用
     */
    @ApiModelProperty(value = "逻辑删除@0-存在,1-隐藏,2-删除,3-停用",required = true)
    private String deleteFlag;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序",required = true)
    private Integer sort;

    /**
     * 设置：类型@0-目录,1-菜单 ,2-按钮
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * 获取：类型@0-目录,1-菜单 ,2-按钮
     */
    public String getType() {
        return type;
    }
    /**
     * 设置：菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：菜单名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：层级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
    /**
     * 获取：层级
     */
    public Integer getLevel() {
        return level;
    }
    /**
     * 设置：主键
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：主键
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：父菜单ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    /**
     * 获取：父菜单ID
     */
    public Long getParentId() {
        return parentId;
    }
    /**
     * 设置：菜单URL
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * 获取：菜单URL
     */
    public String getUrl() {
        return url;
    }
    /**
     * 设置：授权(多个用逗号分隔，如：user:list,user:create)
     */
    public void setPerms(String perms) {
        this.perms = perms;
    }
    /**
     * 获取：授权(多个用逗号分隔，如：user:list,user:create)
     */
    public String getPerms() {
        return perms;
    }
    /**
     * 设置：菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
    /**
     * 获取：菜单图标
     */
    public String getIcon() {
        return icon;
    }
    /**
     * 设置：备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    /**
     * 获取：备注
     */
    public String getRemarks() {
        return remarks;
    }
    /**
     * 设置：版本号
     */
    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }
    /**
     * 获取：版本号
     */
    public Integer getVersionNo() {
        return versionNo;
    }
    /**
     * 设置：创建人id
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
    /**
     * 获取：创建人id
     */
    public Long getCreateBy() {
        return createBy;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：修改人id
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
    /**
     * 获取：修改人id
     */
    public Long getUpdateBy() {
        return updateBy;
    }
    /**
     * 设置：修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
     * 获取：修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 设置：逻辑删除@0-存在,1-隐藏,2-删除,3-停用
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    /**
     * 获取：逻辑删除@0-存在,1-隐藏,2-删除,3-停用
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }
    /**
     * 设置：排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    /**
     * 获取：排序
     */
    public Integer getSort() {
        return sort;
    }

    public void insert(){
        this.createTime = new Date();
        this.updateTime = new Date();
        this.sort = this.sort == null ? 0 : this.sort;
        if(this.deleteFlag == null || this.deleteFlag.length()==0){
            this.deleteFlag = "0";
        }
        this.versionNo=1;
    }
    public void update(){
        this.updateTime = new Date();
    }
}
