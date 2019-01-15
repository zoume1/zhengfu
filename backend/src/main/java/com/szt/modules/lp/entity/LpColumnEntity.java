package com.szt.modules.lp.entity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.szt.common.CommonConstant;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.shiro.SecurityUtils;
import com.szt.modules.sys.entity.SysUserEntity;
import com.szt.modules.sys.entity.SysCommcomFieldEntity;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 栏目管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-18 18:14:04
 */
@TableName("lp_column")
public class LpColumnEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 栏目名
     */
    @NotBlank(message="栏目名不能为空")
    @ApiModelProperty(value = "栏目名",required = false)
    private String name;
    /**
     * 父栏目
     */
    @NotNull(message="父栏目不能为空")
    @ApiModelProperty(value = "父栏目",required = false)
    private Long parentId;
    /**
     * 层级
     */
    @NotNull(message="层级不能为空")
    @ApiModelProperty(value = "层级",required = false)
    private Integer level;
    /**
     * 是否首页推荐@0-是,1-否
     */
    @NotBlank(message="是否首页推荐不能为空")
    @ApiModelProperty(value = "是否首页推荐@0-是,1-否",required = false)
    private String isRecommend;
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
    @TableField(exist = false)
    private List<LpArticleEntity> list;
    /**
     * 父名称
     */
    @TableField(exist = false)
    private String parentName;
    /**
     * 设置：栏目名
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：栏目名
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：父栏目
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    /**
     * 获取：父栏目
     */
    public Long getParentId() {
        return parentId;
    }
    /**
     * 设置：层级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
    /**
     * 获取：层级
     */
    public Integer getLevel() {
        return level;
    }
    /**
     * 设置：是否首页推荐@0-是,1-否
     */
    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }
    /**
     * 获取：是否首页推荐@0-是,1-否
     */
    public String getIsRecommend() {
        return isRecommend;
    }
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
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

    public List<LpArticleEntity> getList() {
        return list;
    }

    public void setList(List<LpArticleEntity> list) {
        this.list = list;
    }
}
