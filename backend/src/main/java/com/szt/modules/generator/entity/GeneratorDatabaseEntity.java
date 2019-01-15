package com.szt.modules.generator.entity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
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
 * 数据库管理
 * 
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-28 04:27:38
 */
@TableName("generator_database")
public class GeneratorDatabaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(value = "ID",required = true)
	private Long id;
	/**
	 * id地址
	 */
    @NotBlank(message="id地址不能为空")
	@ApiModelProperty(value = "id地址",required = true)
	private String ip;
	/**
	 * 数据库名称
	 */
    @NotBlank(message="数据库名称不能为空")
	@ApiModelProperty(value = "数据库名称",required = true)
	private String name;
	/**
	 * port端口号
	 */
    @NotBlank(message="port端口号不能为空")
	@ApiModelProperty(value = "port端口号",required = true)
	private String port;
	/**
	 * 账号
	 */
    @NotBlank(message="账号不能为空")
	@ApiModelProperty(value = "账号",required = true)
	private String userName;
	/**
	 * 密码
	 */
    @NotBlank(message="密码不能为空")
	@ApiModelProperty(value = "密码",required = true)
	private String password;
	/**
	 * 编码
	 */
    @NotBlank(message="编码不能为空")
	@ApiModelProperty(value = "编码",required = true)
	private String encoding;
	/**
	 * 数据库类型
	 */
    @NotBlank(message="数据库类型不能为空")
	@ApiModelProperty(value = "数据库类型",required = true)
	private String type;
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
	 * 设置：id地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取：id地址
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 设置：数据库名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：数据库名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：port端口号
	 */
	public void setPort(String port) {
		this.port = port;
	}
	/**
	 * 获取：port端口号
	 */
	public String getPort() {
		return port;
	}
	/**
	 * 设置：账号
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：账号
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：编码
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	/**
	 * 获取：编码
	 */
	public String getEncoding() {
		return encoding;
	}
	/**
	 * 设置：数据库类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：数据库类型
	 */
	public String getType() {
		return type;
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
        this.sort = this.sort == null ? 1 : this.sort;
        if(this.deleteFlag == null || this.deleteFlag.length()==0){
            this.deleteFlag = GeneratorDatabaseConstant.DELETE_FLAG_0;
        }
        this.versionNo=1;
    }
    public void update(){
        this.updateTime = new Date();
    }
}
