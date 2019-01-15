package com.szt.modules.job.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.szt.common.CommonEntitiy;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 17:51:32
 */
@TableName("schedule_job")
public class ScheduleJobEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 任务调度参数key
     */
    public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value = "主键", required = false)
    private Long id;
    /**
     * spring bean名称
     */
    @ApiModelProperty(value = "spring bean名称", required = true)
    private String beanName;
    /**
     * 方法名
     */
    @ApiModelProperty(value = "方法名", required = true)
    private String methodName;
    /**
     * 参数
     */
    @ApiModelProperty(value = "参数", required = true)
    private String params;
    /**
     * cron表达式
     */
    @ApiModelProperty(value = "cron表达式", required = true)
    private String cronExpression;
    /**
     * 任务状态@schedule_job_status:0-正常,1-暂停
     */
    @ApiModelProperty(value = "任务状态@schedule_job_status:0-正常,1-暂停", required = true)
    private String status;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", required = true)
    private String remarks;
    /**
     * 版本号
     */
    @NotNull(message = "版本号不能为空")
    @ApiModelProperty(value = "版本号", required = false)
    private Integer versionNo;
    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id", required = true)
    private Long createBy;
    /**
     * 创建时间
     */
    @NotNull(message = "创建时间不能为空")
    @ApiModelProperty(value = "创建时间", required = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改人id
     */
    @ApiModelProperty(value = "修改人id", required = true)
    private Long updateBy;
    /**
     * 修改时间
     */
    @NotNull(message = "修改时间不能为空")
    @ApiModelProperty(value = "修改时间", required = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用
     */
    @NotBlank(message = "逻辑删除@0-存在,1-隐藏,2-删除,3-停用不能为空")
    @ApiModelProperty(value = "逻辑删除@0-存在,1-隐藏,2-删除,3-停用", required = false)
    private String deleteFlag;
    /**
     * 排序
     */
    @NotNull(message = "排序不能为空")
    @ApiModelProperty(value = "排序", required = false)
    private Integer sort;

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
     * 设置：spring bean名称
     */
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    /**
     * 获取：spring bean名称
     */
    public String getBeanName() {
        return beanName;
    }

    /**
     * 设置：方法名
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 获取：方法名
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置：参数
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取：参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置：cron表达式
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * 获取：cron表达式
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * 设置：任务状态@schedule_job_status:0-正常,1-暂停
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取：任务状态@schedule_job_status:0-正常,1-暂停
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

    public void insert() {
        this.createTime = new Date();
        this.updateTime = new Date();
        this.sort = this.sort == null ? 0 : this.sort;
        if (this.deleteFlag == null || this.deleteFlag.length() == 0) {
            this.deleteFlag = "0";
        }
        this.versionNo = 1;
    }

    public void update() {
        this.updateTime = new Date();
    }
}
