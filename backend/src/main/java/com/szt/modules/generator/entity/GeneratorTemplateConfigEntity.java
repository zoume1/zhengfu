package com.szt.modules.generator.entity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.szt.common.CommonEntitiy;
import com.szt.modules.generator.constant.GeneratorTemplateConfigConstant;
import com.szt.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.ApiModelProperty;
import org.apache.shiro.SecurityUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 模板系统参数
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-29 02:26:57
 */
@TableName("generator_template_config")
public class GeneratorTemplateConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(value = "ID",required = true)
	private Long id;
	/**
	 * 模板key
	 */
    @NotBlank(message="模板key不能为空")
	@ApiModelProperty(value = "模板key",required = true)
	private String modelKey;
	/**
	 * 模板val
	 */
    @NotBlank(message="模板val不能为空")
	@ApiModelProperty(value = "模板val",required = true)
	private String modelVal;
	/**
	 * 版本号
	 */
	@NotNull(message="版本号不能为空")
	@ApiModelProperty(value = "版本号",required = true)
	private Integer versionNo;
	/**
	 * 创建人id
	 */
	@NotNull(message="创建人id不能为空")
	@ApiModelProperty(value = "创建人id",required = true)
	private Long createBy;
	/**
	 * 创建时间
	 */
	@NotNull(message="创建时间不能为空")
	@ApiModelProperty(value = "创建时间",required = true)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date createTime;
	/**
	 * 修改人id
	 */
	@NotNull(message="修改人id不能为空")
	@ApiModelProperty(value = "修改人id",required = true)
	private Long updateBy;
	/**
	 * 修改时间
	 */
	@NotNull(message="修改时间不能为空")
	@ApiModelProperty(value = "修改时间",required = true)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date updateTime;
	/**
	 * 状态
	 */
    @NotBlank(message="状态不能为空")
	@ApiModelProperty(value = "状态",required = true)
	private String deleteFlag;
	/**
	 * 排序
	 */
	@NotNull(message="排序不能为空")
	@ApiModelProperty(value = "排序",required = true)
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
	 * 设置：模板key
	 */
	public void setModelKey(String modelKey) {
		this.modelKey = modelKey;
	}
	/**
	 * 获取：模板key
	 */
	public String getModelKey() {
		return modelKey;
	}
	/**
	 * 设置：模板val
	 */
	public void setModelVal(String modelVal) {
		this.modelVal = modelVal;
	}
	/**
	 * 获取：模板val
	 */
	public String getModelVal() {
		return modelVal;
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

    public void insert(){
        this.createTime = new Date();
        this.updateTime = new Date();
        //用id
        Long id = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getId();
        this.createBy = id;
        this.updateBy= id;
        this.sort = this.sort == null ? 1 : this.sort;
        if(this.deleteFlag == null || this.deleteFlag.length()==0){
            this.deleteFlag = GeneratorTemplateConfigConstant.DELETE_FLAG_0;
        }
        this.versionNo=1;
    }
    public void update(){
        this.updateTime = new Date();
        //用id
        Long id = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getId();
        this.updateBy= id;
    }
}
