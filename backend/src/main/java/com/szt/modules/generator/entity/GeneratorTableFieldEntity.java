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
import com.szt.modules.generator.constant.GeneratorTableFieldConstant;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 字段管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-13 23:45:43
 */
@TableName("generator_table_field")
public class GeneratorTableFieldEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(value = "主键",required = false)
	private Long id;
	/**
	 * 表id
	 */
	@NotNull(message="表id不能为空")
	@ApiModelProperty(value = "表id",required = false)
	private Long tableId;
	/**
	 * 字段名称
	 */
	@NotBlank(message="字段名称不能为空")
	@ApiModelProperty(value = "字段名称",required = false)
	private String fieldName;
	/**
	 * 字段类型
	 */
	@NotBlank(message="字段类型不能为空")
	@ApiModelProperty(value = "字段类型",required = false)
	private String fieldType;
	/**
	 * 是否为空@genterate_table_field_is_null:0-可以空,1-非空
	 */
	@NotBlank(message="是否为空@genterate_table_field_is_null:0-可以空,1-非空不能为空")
	@ApiModelProperty(value = "是否为空@genterate_table_field_is_null:0-可以空,1-非空",required = false)
	private String isNull;
	/**
	 * 是否搜索@genterate_table_field_is_seek:0-搜索,1-非搜索
	 */
	@NotBlank(message="是否搜索@genterate_table_field_is_seek:0-搜索,1-非搜索不能为空")
	@ApiModelProperty(value = "是否搜索@genterate_table_field_is_seek:0-搜索,1-非搜索",required = false)
	private String isSeek;
	/**
	 * 正则校验&genterate_table_field_checkout:0-手机号,1-非空,2-身份证,3-邮箱,4-数字,5-小数
	 */
	@NotBlank(message="正则校验&genterate_table_field_checkout:0-手机号,1-非空,2-身份证,3-邮箱,4-数字,5-小数不能为空")
	@ApiModelProperty(value = "正则校验&genterate_table_field_checkout:0-手机号,1-非空,2-身份证,3-邮箱,4-数字,5-小数",required = false)
	private String checkout;
	/**
	 * 是否导出@genterate_table_field_is_export:0-导出,1-非导出
	 */
	@NotBlank(message="是否导出@genterate_table_field_is_export:0-导出,1-非导出不能为空")
	@ApiModelProperty(value = "是否导出@genterate_table_field_is_export:0-导出,1-非导出",required = false)
	private String isExport;
	/**
	 * 页面注释
	 */
	@ApiModelProperty(value = "页面注释",required = true)
	private String pageComment;
	/**
	 * 字段注释
	 */
	@ApiModelProperty(value = "字段注释",required = true)
	private String comment;
	/**
	 * 表格中字段是否显示@generator_table_field_table_set:0-是,1-否
	 */
	@NotBlank(message="表格中字段是否显示@generator_table_field_table_set:0-是,1-否不能为空")
	@ApiModelProperty(value = "表格中字段是否显示@generator_table_field_table_set:0-是,1-否",required = false)
	private String tableSet;
	/**
	 * 是否数据库字段@generator_table_field_is_data_base:0-是,1-否
	 */
	@NotBlank(message="是否数据库字段@generator_table_field_is_data_base:0-是,1-否不能为空")
	@ApiModelProperty(value = "是否数据库字段@generator_table_field_is_data_base:0-是,1-否",required = false)
	private String isDataBase;
	/**
	 * 修改时是否显示@generator_table_field_is_set:0-是,1-否
	 */
	@NotBlank(message="修改时是否显示@generator_table_field_is_set:0-是,1-否不能为空")
	@ApiModelProperty(value = "修改时是否显示@generator_table_field_is_set:0-是,1-否",required = false)
	private String isSet;
	/**
	 * 输入框类型@generator_table_field_input_type:0-text,1-number,2-date,3-datetime,4-select,5-chebox,6-richText
	 */
	@NotBlank(message="输入框类型@generator_table_field_input_type:0-text,1-number,2-date,3-datetime,4-select,5-chebox,6-richText不能为空")
	@ApiModelProperty(value = "输入框类型@generator_table_field_input_type:0-text,1-number,2-date,3-datetime,4-select,5-chebox,6-richText",required = false)
	private String inputType;
	/**
	 * 数据默认值
	 */
	@ApiModelProperty(value = "数据默认值",required = true)
	private String dataDefault;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注",required = true)
	private String remarks;
	/**
	 * 是否主键@generator_table_field_select_key:0-是,1-否
	 */
	@ApiModelProperty(value = "是否主键@generator_table_field_select_key:0-是,1-否",required = true)
	private String columnKey;
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
	 * 逻辑删除@delete_flag:0-存在,1-隐藏,2-删除,3-停用
	 */
	@NotBlank(message="逻辑删除@delete_flag:0-存在,1-隐藏,2-删除,3-停用不能为空")
	@ApiModelProperty(value = "逻辑删除@delete_flag:0-存在,1-隐藏,2-删除,3-停用",required = false)
	private String deleteFlag;
	/**
	 * 数据长度
	 */
	@ApiModelProperty(value = "数据长度",required = true)
	private String dataLength;
	/**
	 * 宽度
	 */
	@ApiModelProperty(value = "宽度",required = true)
	private String widthLength;
	/**
	 * 字典索引
	 */
	@ApiModelProperty(value = "字典索引",required = true)
	private String dictionaryIndex;
	/**
	 * 排序
	 */
	@NotNull(message="排序不能为空")
	@ApiModelProperty(value = "排序",required = false)
	private Integer sort;
	/**
	 * 树主键
	 */
	@ApiModelProperty(value = "树主键",required = true)
	private String treeKey;
	/**
	 * 树层级
	 */
	@ApiModelProperty(value = "树层级",required = true)
	private String levelKey;
	/**
	 * 树父id
	 */
	@ApiModelProperty(value = "树父id",required = true)
	private String parentKey;
	/**
	 * 是否允许修改@0-是,1-否
	 */
	@NotBlank(message="是否允许修改不能为空")
	@ApiModelProperty(value = "是否允许修改@0-是,1-否",required = false)
	private String isUpdate;
	@TableField(exist = false)
	private String thisComment;
	@TableField(exist = false)
	private String dataType;
	@TableField(exist = false)
	private List<ColumnListEntity> list;
	@TableField(exist = false)
	private String selectKey;
	@TableField(exist = false)
	private String extra;
	@TableField(exist = false)
	private boolean nullable;
	@TableField(exist = false)
	private String attrName;
	@TableField(exist = false)
	private String attrname;
	@TableField(exist = false)
	private String attrType;
	@TableField(exist = false)
	private String fieldnames;
	@TableField(exist = false)
	private String columnType;

	/**
	 * 表名称
	 */
	@TableField(exist = false)
	private String tabName;
	/**
	 * 是否复选框
	 */
	@TableField(exist = false)
	private boolean isChebox;
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
	 * 设置：表id
	 */
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	/**
	 * 获取：表id
	 */
	public Long getTableId() {
		return tableId;
	}
	/**
	 * 设置：字段名称
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * 获取：字段名称
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * 设置：字段类型
	 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	/**
	 * 获取：字段类型
	 */
	public String getFieldType() {
		return fieldType;
	}
	/**
	 * 设置：是否为空@genterate_table_field_is_null:0-可以空,1-非空
	 */
	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}
	/**
	 * 获取：是否为空@genterate_table_field_is_null:0-可以空,1-非空
	 */
	public String getIsNull() {
		return isNull;
	}
	/**
	 * 设置：是否搜索@genterate_table_field_is_seek:0-搜索,1-非搜索
	 */
	public void setIsSeek(String isSeek) {
		this.isSeek = isSeek;
	}
	/**
	 * 获取：是否搜索@genterate_table_field_is_seek:0-搜索,1-非搜索
	 */
	public String getIsSeek() {
		return isSeek;
	}
	/**
	 * 设置：正则校验&genterate_table_field_checkout:0-手机号,1-非空,2-身份证,3-邮箱,4-数字,5-小数
	 */
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	/**
	 * 获取：正则校验&genterate_table_field_checkout:0-手机号,1-非空,2-身份证,3-邮箱,4-数字,5-小数
	 */
	public String getCheckout() {
		return checkout;
	}
	/**
	 * 设置：是否导出@genterate_table_field_is_export:0-导出,1-非导出
	 */
	public void setIsExport(String isExport) {
		this.isExport = isExport;
	}
	/**
	 * 获取：是否导出@genterate_table_field_is_export:0-导出,1-非导出
	 */
	public String getIsExport() {
		return isExport;
	}
	/**
	 * 设置：页面注释
	 */
	public void setPageComment(String pageComment) {
		this.pageComment = pageComment;
	}
	/**
	 * 获取：页面注释
	 */
	public String getPageComment() {
		return pageComment;
	}
	/**
	 * 设置：字段注释
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 获取：字段注释
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * 设置：表格中字段是否显示@generator_table_field_table_set:0-是,1-否
	 */
	public void setTableSet(String tableSet) {
		this.tableSet = tableSet;
	}
	/**
	 * 获取：表格中字段是否显示@generator_table_field_table_set:0-是,1-否
	 */
	public String getTableSet() {
		return tableSet;
	}
	/**
	 * 设置：是否数据库字段@generator_table_field_is_data_base:0-是,1-否
	 */
	public void setIsDataBase(String isDataBase) {
		this.isDataBase = isDataBase;
	}
	/**
	 * 获取：是否数据库字段@generator_table_field_is_data_base:0-是,1-否
	 */
	public String getIsDataBase() {
		return isDataBase;
	}
	/**
	 * 设置：修改时是否显示@generator_table_field_is_set:0-是,1-否
	 */
	public void setIsSet(String isSet) {
		this.isSet = isSet;
	}
	/**
	 * 获取：修改时是否显示@generator_table_field_is_set:0-是,1-否
	 */
	public String getIsSet() {
		return isSet;
	}
	/**
	 * 设置：输入框类型@generator_table_field_input_type:0-text,1-number,2-date,3-datetime,4-select,5-chebox,6-richText
	 */
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
	/**
	 * 获取：输入框类型@generator_table_field_input_type:0-text,1-number,2-date,3-datetime,4-select,5-chebox,6-richText
	 */
	public String getInputType() {
		return inputType;
	}
	/**
	 * 设置：数据默认值
	 */
	public void setDataDefault(String dataDefault) {
		this.dataDefault = dataDefault;
	}
	/**
	 * 获取：数据默认值
	 */
	public String getDataDefault() {
		return dataDefault;
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
	 * 设置：是否主键@generator_table_field_select_key:0-是,1-否
	 */
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	/**
	 * 获取：是否主键@generator_table_field_select_key:0-是,1-否
	 */
	public String getColumnKey() {
		return columnKey;
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
	 * 设置：逻辑删除@delete_flag:0-存在,1-隐藏,2-删除,3-停用
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	/**
	 * 获取：逻辑删除@delete_flag:0-存在,1-隐藏,2-删除,3-停用
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
			this.deleteFlag = GeneratorTableFieldConstant.GENERATOR_TABLE_FIELD_DELETE_FLAG_0;
		}
		this.versionNo=1;
	}
	public void update(){
		this.updateTime = new Date();
	}

	public String getThisComment() {
		return thisComment;
	}

	public void setThisComment(String thisComment) {
		this.thisComment = thisComment;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public List<ColumnListEntity> getList() {
		return list;
	}

	public void setList(List<ColumnListEntity> list) {
		this.list = list;
	}

	public String getSelectKey() {
		return selectKey;
	}

	public void setSelectKey(String selectKey) {
		this.selectKey = selectKey;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrname() {
		return attrname;
	}

	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}

	public String getAttrType() {
		return attrType;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}

	public String getFieldnames() {
		return fieldnames;
	}

	public void setFieldnames(String fieldnames) {
		this.fieldnames = fieldnames;
	}

	public boolean getIsChebox() {
		return isChebox;
	}

	public void setIsChebox(boolean isChebox) {
		this.isChebox = isChebox;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public boolean isChebox() {
		return isChebox;
	}

	public void setChebox(boolean chebox) {
		isChebox = chebox;
	}

	public String getDataLength() {
		return dataLength;
	}

	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}

	public String getWidthLength() {
		return widthLength;
	}

	public void setWidthLength(String widthLength) {
		this.widthLength = widthLength;
	}

	public String getDictionaryIndex() {
		return dictionaryIndex;
	}

	public void setDictionaryIndex(String dictionaryIndex) {
		this.dictionaryIndex = dictionaryIndex;
	}

//	public String getTreeKey() {
//		return treeKey;
//	}
//
//	public void setTreeKey(String treeKey) {
//		this.treeKey = treeKey;
//	}
//
//	public String getParentKey() {
//		return parentKey;
//	}
//
//	public void setParentKey(String parentKey) {
//		this.parentKey = parentKey;
//	}

	public String getTreeKey() {
		return treeKey;
	}

	public void setTreeKey(String treeKey) {
		this.treeKey = treeKey;
	}

	public String getLevelKey() {
		return levelKey;
	}

	public void setLevelKey(String levelKey) {
		this.levelKey = levelKey;
	}

	public String getParentKey() {
		return parentKey;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}
}
