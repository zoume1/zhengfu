package com.szt.modules.job.entity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.szt.common.CommonEntitiy;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务日志管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 18:14:06
 */
@TableName("schedule_job_log")
public class ScheduleJobLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 主键
         */
        @TableId
        @ApiModelProperty(value = "主键",required = false)
    private Long id;
        /**
         * 任务id
         */
            @NotNull(message="任务id不能为空")
        @ApiModelProperty(value = "任务id",required = false)
    private Long jobId;
        /**
         * spring bean名称
         */
        @ApiModelProperty(value = "spring bean名称",required = true)
    private String beanName;
        /**
         * 方法名
         */
        @ApiModelProperty(value = "方法名",required = true)
    private String methodName;
        /**
         * 参数
         */
        @ApiModelProperty(value = "参数",required = true)
    private String params;
        /**
         * 任务状态    0：成功    1：失败
         */
            @NotNull(message="任务状态    0：成功    1：失败不能为空")
        @ApiModelProperty(value = "任务状态    0：成功    1：失败",required = false)
    private Integer status;
        /**
         * 失败信息
         */
        @ApiModelProperty(value = "失败信息",required = true)
    private String error;
        /**
         * 耗时(单位：毫秒)
         */
            @NotNull(message="耗时(单位：毫秒)不能为空")
        @ApiModelProperty(value = "耗时(单位：毫秒)",required = false)
    private Integer times;
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
            @NotBlank(message="逻辑删除@0-存在,1-隐藏,2-删除,3-停用不能为空")
        @ApiModelProperty(value = "逻辑删除@0-存在,1-隐藏,2-删除,3-停用",required = false)
    private String deleteFlag;
        /**
         * 排序
         */
            @NotNull(message="排序不能为空")
        @ApiModelProperty(value = "排序",required = false)
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
         * 设置：任务id
         */
        public void setJobId(Long jobId) {
            this.jobId = jobId;
        }
        /**
         * 获取：任务id
         */
        public Long getJobId() {
            return jobId;
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
         * 设置：任务状态    0：成功    1：失败
         */
        public void setStatus(Integer status) {
            this.status = status;
        }
        /**
         * 获取：任务状态    0：成功    1：失败
         */
        public Integer getStatus() {
            return status;
        }
        /**
         * 设置：失败信息
         */
        public void setError(String error) {
            this.error = error;
        }
        /**
         * 获取：失败信息
         */
        public String getError() {
            return error;
        }
        /**
         * 设置：耗时(单位：毫秒)
         */
        public void setTimes(Integer times) {
            this.times = times;
        }
        /**
         * 获取：耗时(单位：毫秒)
         */
        public Integer getTimes() {
            return times;
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
