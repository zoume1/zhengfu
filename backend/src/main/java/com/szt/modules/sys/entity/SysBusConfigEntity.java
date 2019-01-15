package com.szt.modules.sys.entity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.szt.common.CommonEntitiy;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import com.szt.modules.sys.constant.SysBusConfigConstant;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统业务参数
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-15 14:09:50
 */
@TableName("sys_bus_config")
public class SysBusConfigEntity implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * ID
         */
        @TableId
        @ApiModelProperty(value = "ID",required = false)
    private Long id;
        /**
         * 参数名称
         */
            @NotBlank(message="参数名称不能为空")
        @ApiModelProperty(value = "参数名称",required = false)
    private String confName;
        /**
         * 参数代码
         */
            @NotBlank(message="参数代码不能为空")
        @ApiModelProperty(value = "参数代码",required = false)
    private String confCode;
        /**
         * 参数值
         */
            @NotBlank(message="参数值不能为空")
        @ApiModelProperty(value = "参数值",required = false)
    private String confVue;
        /**
         * 版本号
         */
            @NotNull(message="版本号不能为空")
        @ApiModelProperty(value = "版本号",required = false)
    private Integer versionNo;
        /**
         * 创建人id
         */
            @NotNull(message="创建人id不能为空")
        @ApiModelProperty(value = "创建人id",required = false)
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
            @NotNull(message="修改人id不能为空")
        @ApiModelProperty(value = "修改人id",required = false)
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
         * 状态@0-显示,1-隐藏,2-删除
         */
            @NotBlank(message="状态@0-显示,1-隐藏,2-删除不能为空")
        @ApiModelProperty(value = "状态@0-显示,1-隐藏,2-删除",required = false)
    private String deleteFlag;
        /**
         * 排序
         */
            @NotNull(message="排序不能为空")
        @ApiModelProperty(value = "排序",required = false)
    private Integer sort;

        /**
         * 设置：ID
         */
        public void setId(Long id) {
            this.id = id;
        }
        /**
         * 获取：ID
         */
        public Long getId() {
            return id;
        }
        /**
         * 设置：参数名称
         */
        public void setConfName(String confName) {
            this.confName = confName;
        }
        /**
         * 获取：参数名称
         */
        public String getConfName() {
            return confName;
        }
        /**
         * 设置：参数代码
         */
        public void setConfCode(String confCode) {
            this.confCode = confCode;
        }
        /**
         * 获取：参数代码
         */
        public String getConfCode() {
            return confCode;
        }
        /**
         * 设置：参数值
         */
        public void setConfVue(String confVue) {
            this.confVue = confVue;
        }
        /**
         * 获取：参数值
         */
        public String getConfVue() {
            return confVue;
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
         * 设置：状态@0-显示,1-隐藏,2-删除
         */
        public void setDeleteFlag(String deleteFlag) {
            this.deleteFlag = deleteFlag;
        }
        /**
         * 获取：状态@0-显示,1-隐藏,2-删除
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
        this.sort = this.sort == null ? 1 : this.sort;
        if(this.deleteFlag == null || this.deleteFlag.length()==0){
            this.deleteFlag = SysBusConfigConstant.SYS_BUS_CONFIG_DELETE_FLAG_0;
        }
        this.versionNo=1;
    }
    public void update(){
        this.updateTime = new Date();
    }
}
