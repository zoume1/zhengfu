package com.szt.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.szt.common.CommonEntitiy;
import com.szt.modules.generator.constant.GeneratorDatabaseConstant;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 系统用户Token
 */
@TableName("sys_user_token")
public class SysUserTokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	@TableId
	private Long id;
	//用户id
	private Long userId;
	//token
	private String token;
	//过期时间
	private Date expireTime;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 设置：token
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * 获取：token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * 设置：过期时间
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	/**
	 * 获取：过期时间
	 */
	public Date getExpireTime() {
		return expireTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	public void insert(){
		this.createTime = new Date();
		this.updateTime = new Date();
		this.sort = this.sort == null ? 1 : this.sort;
		if(this.deleteFlag == null || this.deleteFlag.length()==0){
			this.deleteFlag = GeneratorDatabaseConstant.DELETE_FLAG_0;
		}
		this.versionNo=1;
	}
	public void update(){
		this.updateTime = new Date();
	}

	public Integer getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
