package com.szt.modules.generator.entity;
import com.baomidou.mybatisplus.annotations.TableField;
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
import java.util.List;

/**
 * 数据表管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 21:04:24
 */
@TableName("generator_table")
public class GeneratorTableEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 树主键
	 */
	@ApiModelProperty(value = "树主键",required = true)
	private String treeKey;
	/**
	 * 表注释
	 */
	@NotBlank(message="表注释不能为空")
	@ApiModelProperty(value = "表注释",required = false)
	private String tableComment;
	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(value = "主键",required = false)
	private Long id;
	/**
	 * 树父id
	 */
	@ApiModelProperty(value = "树父id",required = true)
	private String parentKey;
	/**
	 * 模块id
	 */
	@NotNull(message="模块id不能为空")
	@ApiModelProperty(value = "模块id",required = false)
	private Long modulesId;
	/**
	 * 树绑定字段
	 */
	@ApiModelProperty(value = "树绑定字段",required = true)
	private String treeFieldName;
	/**
	 * 树层级key
	 */
	@ApiModelProperty(value = "树层级key",required = true)
	private String levelKey;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注",required = true)
	private String remarks;
	/**
	 * 表名
	 */
	@NotBlank(message="表名不能为空")
	@ApiModelProperty(value = "表名",required = false)
	private String tableName;
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
	 * 业务key
	 */
	@ApiModelProperty(value = "业务key",required = true)
	private String businessKey;
	/**
	 * 业务取值
	 */
	@ApiModelProperty(value = "业务取值",required = true)
	private String businessValue;

	@TableField(exist = false)
	private List<GeneratorTableFieldEntity> columns;
	@TableField(exist = false)
	private String className;
	@TableField(exist = false)
	private String classname;
	@TableField(exist = false)
	private GeneratorTableFieldEntity pk;
	/**
	 *模块名称
	 */
	@TableField(exist = false)
	private String modulesName;
	/**
	 * 搜索字段
	 */
	@TableField(exist = false)
	private List<GeneratorTableFieldEntity> isSeekList;
	/**
	 * 表格字段
	 */
	@TableField(exist = false)
	private List<GeneratorTableFieldEntity> tableSetList;
	/**
	 * 修改字段
	 */
	@TableField(exist = false)
	private List<GeneratorTableFieldEntity> isSetList;
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
	 * 设置：表注释
	 */
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	/**
	 * 获取：表注释
	 */
	public String getTableComment() {
		return tableComment;
	}
	/**
	 * 设置：模块id
	 */
	public void setModulesId(Long modulesId) {
		this.modulesId = modulesId;
	}
	/**
	 * 获取：模块id
	 */
	public Long getModulesId() {
		return modulesId;
	}
	/**
	 * 设置：表名
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * 获取：表名
	 */
	public String getTableName() {
		return tableName;
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

	public List<GeneratorTableFieldEntity> getColumns() {
		return columns;
	}

	public void setColumns(List<GeneratorTableFieldEntity> columns) {
		this.columns = columns;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public GeneratorTableFieldEntity getPk() {
		return pk;
	}

	public void setPk(GeneratorTableFieldEntity pk) {
		this.pk = pk;
	}

	public String getModulesName() {
		return modulesName;
	}

	public void setModulesName(String modulesName) {
		this.modulesName = modulesName;
	}

	public List<GeneratorTableFieldEntity> getIsSeekList() {
		return isSeekList;
	}

	public void setIsSeekList(List<GeneratorTableFieldEntity> isSeekList) {
		this.isSeekList = isSeekList;
	}

	public List<GeneratorTableFieldEntity> getTableSetList() {
		return tableSetList;
	}

	public void setTableSetList(List<GeneratorTableFieldEntity> tableSetList) {
		this.tableSetList = tableSetList;
	}

	public List<GeneratorTableFieldEntity> getIsSetList() {
		return isSetList;
	}

	public void setIsSetList(List<GeneratorTableFieldEntity> isSetList) {
		this.isSetList = isSetList;
	}

	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}


	public String getBusinessValue() {
		return businessValue;
	}

	public void setBusinessValue(String businessValue) {
		this.businessValue = businessValue;
	}

	public String getTreeKey() {
		return treeKey;
	}

	public void setTreeKey(String treeKey) {
		this.treeKey = treeKey;
	}

	public String getParentKey() {
		return parentKey;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

	public String getTreeFieldName() {
		return treeFieldName;
	}

	public void setTreeFieldName(String treeFieldName) {
		this.treeFieldName = treeFieldName;
	}

	public String getLevelKey() {
		return levelKey;
	}

	public void setLevelKey(String levelKey) {
		this.levelKey = levelKey;
	}
}
