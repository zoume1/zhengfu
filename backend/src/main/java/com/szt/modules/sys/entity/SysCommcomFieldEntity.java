package com.szt.modules.sys.entity;
import com.szt.common.CommonConstant;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.szt.common.CommonEntitiy;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.shiro.SecurityUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 公共字段
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-27 01:02:49
 */
@TableName("sys_commcom_field")
public class SysCommcomFieldEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(value = "ID",required = true)
	private Long id;
	/**
	 * 版本号
	 */
	@ApiModelProperty(value = "版本号",required = true)
	@NotNull(message="版本号不能为空")
	private Integer versionNo;
	/**
	 * 创建人id
	 */
	@ApiModelProperty(value = "创建人id",required = true)
	@NotNull(message="创建人id不能为空")
	private Long createBy;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	@NotNull(message="创建时间不能为空")
    	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date createTime;
	/**
	 * 修改人id
	 */
	@ApiModelProperty(value = "修改人id",required = true)
	@NotNull(message="修改人id不能为空")
	private Long updateBy;
	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "修改时间",required = true)
	@NotNull(message="修改时间不能为空")
    	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date updateTime;
	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态",required = true)
	@NotBlank(message="状态不能为空")
	private String deleteFlag;
	/**
	 * 排序
	 */
	@ApiModelProperty(value = "排序",required = true)
	@NotNull(message="排序不能为空")
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
		Long username = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getId();
		this.createBy = username;
		this.updateBy= username;
		this.sort = this.sort == null ? 1 : this.sort;
		if(this.deleteFlag == null || this.deleteFlag.length()==0){
			this.deleteFlag = CommonConstant.DELETE_FLAG_0;
		}
		this.versionNo=1;
	}
	public void update(){
		this.updateTime = new Date();
		//用id
		Long username = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getId();
		this.updateBy= username;
	}
}
