package com.szt.modules.lp.entity;
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
 * 人才库管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-11-15 02:46:39
 */
@TableName("lp_talent")
public class LpTalentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    @NotBlank(message="姓名不能为空")
    @ApiModelProperty(value = "姓名",required = false)
    private String name;
    /**
     * 照片
     */
    @NotBlank(message="照片不能为空")
    @ApiModelProperty(value = "照片",required = false)
    private String pic;
    /**
     * 自我介绍
     */
    @NotBlank(message="自我介绍不能为空")
    @ApiModelProperty(value = "自我介绍",required = false)
    private String introduce;
    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间",required = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date auditTime;
    /**
     * 性别@0-女,1-男,2保密
     */
    @NotBlank(message="性别不能为空")
    @ApiModelProperty(value = "性别@0-女,1-男,2保密",required = false)
    private String sex;
    /**
     * 专长
     */
    @NotBlank(message="专长不能为空")
    @ApiModelProperty(value = "专长",required = false)
    private String speciality;
    /**
     * 年龄
     */
    @NotNull(message="年龄不能为空")
    @ApiModelProperty(value = "年龄",required = false)
    private Integer age;
    /**
     * 行业
     */
    @NotBlank(message="行业不能为空")
    @ApiModelProperty(value = "行业",required = false)
    private String text;
    /**
     * 审核状态@0-待审核,1-已审核
     */
    @NotBlank(message="审核状态不能为空")
    @ApiModelProperty(value = "审核状态@0-待审核,1-已审核",required = false)
    private String state;
    /**
     * 出生日期
     */
    @NotNull(message="出生日期不能为空")
    @ApiModelProperty(value = "出生日期",required = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date birthdate;
    /**
     * 兴趣
     */
    @NotBlank(message="兴趣不能为空")
    @ApiModelProperty(value = "兴趣",required = false)
    private String interest;
    /**
     * 联系方式
     */
    @NotBlank(message="联系方式不能为空")
    @ApiModelProperty(value = "联系方式",required = false)
    private String contactWay;
    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value = "主键",required = false)
    private Long id;
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
     * 设置：姓名
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：姓名
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：照片
     */
    public void setPic(String pic) {
        this.pic = pic;
    }
    /**
     * 获取：照片
     */
    public String getPic() {
        return pic;
    }
    /**
     * 设置：自我介绍
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    /**
     * 获取：自我介绍
     */
    public String getIntroduce() {
        return introduce;
    }
    /**
     * 设置：审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
    /**
     * 获取：审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }
    /**
     * 设置：性别@0-女,1-男,2保密
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * 获取：性别@0-女,1-男,2保密
     */
    public String getSex() {
        return sex;
    }
    /**
     * 设置：专长
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    /**
     * 获取：专长
     */
    public String getSpeciality() {
        return speciality;
    }
    /**
     * 设置：年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     * 获取：年龄
     */
    public Integer getAge() {
        return age;
    }
    /**
     * 设置：行业
     */
    public void setText(String text) {
        this.text = text;
    }
    /**
     * 获取：行业
     */
    public String getText() {
        return text;
    }
    /**
     * 设置：审核状态@0-待审核,1-已审核
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * 获取：审核状态@0-待审核,1-已审核
     */
    public String getState() {
        return state;
    }
    /**
     * 设置：出生日期
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    /**
     * 获取：出生日期
     */
    public Date getBirthdate() {
        return birthdate;
    }
    /**
     * 设置：兴趣
     */
    public void setInterest(String interest) {
        this.interest = interest;
    }
    /**
     * 获取：兴趣
     */
    public String getInterest() {
        return interest;
    }
    /**
     * 设置：联系方式
     */
    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }
    /**
     * 获取：联系方式
     */
    public String getContactWay() {
        return contactWay;
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
