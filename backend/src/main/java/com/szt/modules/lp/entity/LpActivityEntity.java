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
    import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@TableName("lp_activity")
public class LpActivityEntity implements Serializable {
    private static final long serialVersionUID = 1L;

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
         * 活动名
         */
            @NotBlank(message="活动名不能为空")
        @ApiModelProperty(value = "活动名",required = false)
    private String name;
        /**
         * 活动状态@0-未开始,1-进行中,2-已结束
         */
            @NotBlank(message="活动状态不能为空")
        @ApiModelProperty(value = "活动状态@0-未开始,1-进行中,2-已结束",required = false)
    private String state;
        /**
         * 阅读数
         */
            @NotNull(message="阅读数不能为空")
        @ApiModelProperty(value = "阅读数",required = false)
    private Integer pageview;
        /**
         * 报名数
         */
            @NotNull(message="报名数不能为空")
        @ApiModelProperty(value = "报名数",required = false)
    private Integer applySize;
        /**
         * 报名开始时间
         */
            @NotNull(message="报名开始时间不能为空")
        @ApiModelProperty(value = "报名开始时间",required = false)
        @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date applyStartTime;
        /**
         * 报名结束时间
         */
            @NotNull(message="报名结束时间不能为空")
        @ApiModelProperty(value = "报名结束时间",required = false)
        @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date applyEndTime;
        /**
         * 审核状态@0-待审核,1-已通过,2-拒绝
         */
            @NotBlank(message="审核状态不能为空")
        @ApiModelProperty(value = "审核状态@0-待审核,1-已通过,2-拒绝",required = false)
    private String auditState;
        /**
         * 提交单位
         */
            @NotNull(message="提交单位不能为空")
        @ApiModelProperty(value = "提交单位",required = false)
    private Long userId;
        /**
         * 活动时间
         */
            @NotNull(message="活动时间不能为空")
        @ApiModelProperty(value = "活动时间",required = false)
        @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date activityTime;
        /**
         * 活动地址
         */
            @NotBlank(message="活动地址不能为空")
        @ApiModelProperty(value = "活动地址",required = false)
    private String address;
        /**
         * 活动内容
         */
            @NotBlank(message="活动内容不能为空")
        @ApiModelProperty(value = "活动内容",required = false)
    private String content;

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
        /**
         * 设置：活动名
         */
        public void setName(String name) {
            this.name = name;
        }
        /**
         * 获取：活动名
         */
        public String getName() {
            return name;
        }
        /**
         * 设置：活动状态@0-未开始,1-进行中,2-已结束
         */
        public void setState(String state) {
            this.state = state;
        }
        /**
         * 获取：活动状态@0-未开始,1-进行中,2-已结束
         */
        public String getState() {
            return state;
        }
        /**
         * 设置：阅读数
         */
        public void setPageview(Integer pageview) {
            this.pageview = pageview;
        }
        /**
         * 获取：阅读数
         */
        public Integer getPageview() {
            return pageview;
        }
        /**
         * 设置：报名数
         */
        public void setApplySize(Integer applySize) {
            this.applySize = applySize;
        }
        /**
         * 获取：报名数
         */
        public Integer getApplySize() {
            return applySize;
        }
        /**
         * 设置：报名开始时间
         */
        public void setApplyStartTime(Date applyStartTime) {
            this.applyStartTime = applyStartTime;
        }
        /**
         * 获取：报名开始时间
         */
        public Date getApplyStartTime() {
            return applyStartTime;
        }
        /**
         * 设置：报名结束时间
         */
        public void setApplyEndTime(Date applyEndTime) {
            this.applyEndTime = applyEndTime;
        }
        /**
         * 获取：报名结束时间
         */
        public Date getApplyEndTime() {
            return applyEndTime;
        }
        /**
         * 设置：审核状态@0-待审核,1-已通过,2-拒绝
         */
        public void setAuditState(String auditState) {
            this.auditState = auditState;
        }
        /**
         * 获取：审核状态@0-待审核,1-已通过,2-拒绝
         */
        public String getAuditState() {
            return auditState;
        }
        /**
         * 设置：提交单位
         */
        public void setUserId(Long userId) {
            this.userId = userId;
        }
        /**
         * 获取：提交单位
         */
        public Long getUserId() {
            return userId;
        }
        /**
         * 设置：活动时间
         */
        public void setActivityTime(Date activityTime) {
            this.activityTime = activityTime;
        }
        /**
         * 获取：活动时间
         */
        public Date getActivityTime() {
            return activityTime;
        }
        /**
         * 设置：活动地址
         */
        public void setAddress(String address) {
            this.address = address;
        }
        /**
         * 获取：活动地址
         */
        public String getAddress() {
            return address;
        }
        /**
         * 设置：活动内容
         */
        public void setContent(String content) {
            this.content = content;
        }
        /**
         * 获取：活动内容
         */
        public String getContent() {
            return content;
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
