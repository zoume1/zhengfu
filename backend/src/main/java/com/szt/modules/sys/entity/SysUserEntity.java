package com.szt.modules.sys.entity;
import com.szt.common.CommonConstant;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
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
 * 后端用户管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-23 01:59:26
 */
@TableName("sys_user")
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @NotBlank(message="权限id不能为空")
    @ApiModelProperty(value = "权限id",required = false)
    private String roleIdJson;
    /**
     * 商会归属用户级别@0-市级工商联会员,1-分会/县级商会会员
     */
    @NotBlank(message="商会归属用户级别不能为空")
    @ApiModelProperty(value = "商会归属用户级别@0-市级工商联会员,1-分会/县级商会会员",required = false)
    private String grade;
    /**
     * 用户类型@0-系统用户,1-商会用户
     */
    @NotBlank(message="用户类型不能为空")
    @ApiModelProperty(value = "用户类型@0-系统用户,1-商会用户",required = false)
    private String userType;
    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value = "主键",required = false)
    private Long id;
    /**
     * 用户名
     */
    @NotBlank(message="用户名不能为空")
    @ApiModelProperty(value = "用户名",required = false)
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",required = true)
    private String password;
    /**
     * 盐
     */
    @ApiModelProperty(value = "盐",required = true)
    private String salt;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱",required = true)
    private String email;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号",required = true)
    private String mobile;
    /**
     * 用户状态@0-禁用,1-正常
     */
    @ApiModelProperty(value = "用户状态@0-禁用,1-正常",required = true)
    private String status;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注",required = true)
    private String remarks;
    /**
     * 版本号
     */
    @NotNull(message="版本号不能为空")
    @ApiModelProperty(value = "版本号",required = false)
    private Integer versionNo;
    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id",required = true)
    private Long createBy;
    /**
     * 创建时间
     */
    @NotNull(message="创建时间不能为空")
    @ApiModelProperty(value = "创建时间",required = false)
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
    @NotNull(message="修改时间不能为空")
    @ApiModelProperty(value = "修改时间",required = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用
     */
    @NotBlank(message="逻辑删除不能为空")
    @ApiModelProperty(value = "逻辑删除@0-存在,1-隐藏,2-删除,3-停用",required = false)
    private String deleteFlag;
    /**
     * 排序
     */
    @NotNull(message="排序不能为空")
    @ApiModelProperty(value = "排序",required = false)
    private Integer sort;

    /**
     * 设置：权限id
     */
    public void setRoleIdJson(String roleIdJson) {
        this.roleIdJson = roleIdJson;
    }
    /**
     * 获取：权限id
     */
    public String getRoleIdJson() {
        return roleIdJson;
    }
    /**
     * 设置：商会归属用户级别@0-市级工商联会员,1-分会/县级商会会员
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
    /**
     * 获取：商会归属用户级别@0-市级工商联会员,1-分会/县级商会会员
     */
    public String getGrade() {
        return grade;
    }
    /**
     * 设置：用户类型@0-系统用户,1-商会用户
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }
    /**
     * 获取：用户类型@0-系统用户,1-商会用户
     */
    public String getUserType() {
        return userType;
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
     * 设置：用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * 获取：用户名
     */
    public String getUsername() {
        return username;
    }
    /**
     * 设置：密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * 获取：密码
     */
    public String getPassword() {
        return password;
    }
    /**
     * 设置：盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }
    /**
     * 获取：盐
     */
    public String getSalt() {
        return salt;
    }
    /**
     * 设置：邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * 获取：邮箱
     */
    public String getEmail() {
        return email;
    }
    /**
     * 设置：手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**
     * 获取：手机号
     */
    public String getMobile() {
        return mobile;
    }
    /**
     * 设置：用户状态@0-禁用,1-正常
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * 获取：用户状态@0-禁用,1-正常
     */
    public String getStatus() {
        return status;
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
