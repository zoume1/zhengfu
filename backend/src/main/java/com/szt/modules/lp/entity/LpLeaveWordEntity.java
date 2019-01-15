package com.szt.modules.lp.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 在线交流
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-17 09:56:43
 */
@TableName("lp_leave_word")
public class LpLeaveWordEntity implements Serializable {
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
         * 用户留言id
         */
            @NotNull(message="用户留言id不能为空")
        @ApiModelProperty(value = "用户留言id",required = false)
    private Long userId;
        /**
         * 留言人
         */
            @NotBlank(message="留言人不能为空")
        @ApiModelProperty(value = "留言人",required = false)
    private String name;
        /**
         * 来自
         */
            @NotBlank(message="来自不能为空")
        @ApiModelProperty(value = "来自",required = false)
    private String source;
        /**
         * 联系方式
         */
            @NotBlank(message="联系方式不能为空")
        @ApiModelProperty(value = "联系方式",required = false)
    private String contactWay;
        /**
         * 性别@0-女,1-男,2-保密
         */
            @NotBlank(message="性别不能为空")
        @ApiModelProperty(value = "性别@0-女,1-男,2-保密",required = false)
    private String sex;
        /**
         * 留言内容
         */
            @NotBlank(message="留言内容不能为空")
        @ApiModelProperty(value = "留言内容",required = false)
    private String center;
        /**
         * 审核状态@0-待答复,1-已答复
         */
            @NotBlank(message="审核状态不能为空")
        @ApiModelProperty(value = "审核状态@0-待答复,1-已答复",required = false)
    private String state;
        /**
         * 答复内容
         */
        @ApiModelProperty(value = "答复内容",required = false)
        private String response;
        @TableField(exist = false)
        @ApiModelProperty(value = "生成验证码密钥",required = true)
        private String uuid;
        @TableField(exist = false)
        @ApiModelProperty(value = "验证码", required = true)
        private String captcha;
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
         * 设置：用户留言id
         */
        public void setUserId(Long userId) {
            this.userId = userId;
        }
        /**
         * 获取：用户留言id
         */
        public Long getUserId() {
            return userId;
        }
        /**
         * 设置：留言人
         */
        public void setName(String name) {
            this.name = name;
        }
        /**
         * 获取：留言人
         */
        public String getName() {
            return name;
        }
        /**
         * 设置：来自
         */
        public void setSource(String source) {
            this.source = source;
        }
        /**
         * 获取：来自
         */
        public String getSource() {
            return source;
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
         * 设置：性别@0-女,1-男,2-保密
         */
        public void setSex(String sex) {
            this.sex = sex;
        }
        /**
         * 获取：性别@0-女,1-男,2-保密
         */
        public String getSex() {
            return sex;
        }
        /**
         * 设置：留言内容
         */
        public void setCenter(String center) {
            this.center = center;
        }
        /**
         * 获取：留言内容
         */
        public String getCenter() {
            return center;
        }
        /**
         * 设置：审核状态@0-待答复,1-已答复
         */
        public void setState(String state) {
            this.state = state;
        }
        /**
         * 获取：审核状态@0-待答复,1-已答复
         */
        public String getState() {
            return state;
        }
        /**
         * 设置：答复内容
         */
        public void setResponse(String response) {
            this.response = response;
        }
        /**
         * 获取：答复内容
         */
        public String getResponse() {
            return response;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
