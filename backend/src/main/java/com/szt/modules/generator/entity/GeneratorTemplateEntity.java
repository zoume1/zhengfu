package com.szt.modules.generator.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.szt.common.CommonEntitiy;
import com.szt.modules.generator.constant.GeneratorTemplateConstant;
import com.szt.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.ApiModelProperty;
import org.apache.shiro.SecurityUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 模板配置
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-28 04:27:38
 */
@TableName("generator_template")
public class GeneratorTemplateEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiModelProperty(value = "ID", required = true)
    private Long id;
    /**
     * 模板内容
     */
    @NotBlank(message = "模板内容不能为空")
    @ApiModelProperty(value = "模板内容", required = true)
    private String text;
    /**
     * 模板备注
     */
    @NotBlank(message = "模板备注不能为空")
    @ApiModelProperty(value = "模板备注", required = true)
    private String remark;
    /**
     * 模板路径
     */
    @NotBlank(message = "模板路径不能为空")
    @ApiModelProperty(value = "模板路径", required = true)
    private String url;
    /**
     * 文件名
     */
    @NotBlank(message = "文件名不能为空")
    @ApiModelProperty(value = "文件名", required = true)
    private String fileName;
    /**
     * 版本号
     */
    @NotNull(message = "版本号不能为空")
    @ApiModelProperty(value = "版本号", required = true)
    private Integer versionNo;
    /**
     * 创建人id
     */
    @NotNull(message = "创建人id不能为空")
    @ApiModelProperty(value = "创建人id", required = true)
    private Long createBy;
    /**
     * 创建时间
     */
    @NotNull(message = "创建时间不能为空")
    @ApiModelProperty(value = "创建时间", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改人id
     */
    @NotNull(message = "修改人id不能为空")
    @ApiModelProperty(value = "修改人id", required = true)
    private Long updateBy;
    /**
     * 修改时间
     */
    @NotNull(message = "修改时间不能为空")
    @ApiModelProperty(value = "修改时间", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 状态
     */
    @NotBlank(message = "状态不能为空")
    @ApiModelProperty(value = "状态", required = true)
    private String deleteFlag;
    /**
     * 排序
     */
    @NotNull(message = "排序不能为空")
    @ApiModelProperty(value = "排序", required = true)
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
     * 设置：模板内容
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取：模板内容
     */
    public String getText() {
        return text;
    }

    /**
     * 设置：模板备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：模板备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置：模板路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：模板路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置：文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取：文件名
     */
    public String getFileName() {
        return fileName;
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
     * 设置：状态
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取：状态
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
        //用id
        Long id = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getId();
        this.createBy = id;
        this.updateBy = id;
        this.sort = this.sort == null ? 1 : this.sort;
        if (this.deleteFlag == null || this.deleteFlag.length() == 0) {
            this.deleteFlag = GeneratorTemplateConstant.DELETE_FLAG_0;
        }
        this.versionNo = 1;
    }

    public void update() {
        this.updateTime = new Date();
        //用id
    }
}
