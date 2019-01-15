package com.szt.modules.lp.entity;
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

/**
 * 文章管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-12-01 23:17:43
 */
@TableName("lp_article")
public class LpArticleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 文章类型@0-文章,1-上传表格
     */
    @NotBlank(message="文章类型不能为空")
    @ApiModelProperty(value = "文章类型@0-文章,1-上传表格",required = false)
    private String type;
    /**
     * 栏目
     */
    @NotNull(message="栏目不能为空")
    @ApiModelProperty(value = "栏目",required = false)
    private Long columnId;
    /**
     * 阅读数
     */
    @NotNull(message="阅读数不能为空")
    @ApiModelProperty(value = "阅读数",required = false)
    private Integer pageview;
    /**
     * 封面图
     */
    @NotBlank(message="封面图不能为空")
    @ApiModelProperty(value = "封面图",required = false)
    private String pic;
    /**
     * 作者
     */
    @NotBlank(message="作者不能为空")
    @ApiModelProperty(value = "作者",required = false)
    private String author;
    /**
     * 状态@0-启用,1-禁用
     */
    @NotBlank(message="状态不能为空")
    @ApiModelProperty(value = "状态@0-启用,1-禁用",required = false)
    private String state;
    /**
     * 标题
     */
    @NotBlank(message="标题不能为空")
    @ApiModelProperty(value = "标题",required = false)
    private String title;
    /**
     * 表格
     */
    @NotBlank(message="表格不能为空")
    @ApiModelProperty(value = "表格",required = false)
    private String accessory;
    /**
     * 来源
     */
    @NotBlank(message="来源不能为空")
    @ApiModelProperty(value = "来源",required = false)
    private String source;
    /**
     * 内容
     */
    @NotBlank(message="内容不能为空")
    @ApiModelProperty(value = "内容",required = false)
    private String center;
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
     * 设置：文章类型@0-文章,1-上传表格
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * 获取：文章类型@0-文章,1-上传表格
     */
    public String getType() {
        return type;
    }
    /**
     * 设置：栏目
     */
    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }
    /**
     * 获取：栏目
     */
    public Long getColumnId() {
        return columnId;
    }
    /**
     * 设置：阅读数
     */
    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }
    /**
     * 获取：阅读数
     */
    public Integer getPageview() {
        return pageview;
    }
    /**
     * 设置：封面图
     */
    public void setPic(String pic) {
        this.pic = pic;
    }
    /**
     * 获取：封面图
     */
    public String getPic() {
        return pic;
    }
    /**
     * 设置：作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * 获取：作者
     */
    public String getAuthor() {
        return author;
    }
    /**
     * 设置：状态@0-启用,1-禁用
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * 获取：状态@0-启用,1-禁用
     */
    public String getState() {
        return state;
    }
    /**
     * 设置：标题
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * 获取：标题
     */
    public String getTitle() {
        return title;
    }
    /**
     * 设置：表格
     */
    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }
    /**
     * 获取：表格
     */
    public String getAccessory() {
        return accessory;
    }
    /**
     * 设置：来源
     */
    public void setSource(String source) {
        this.source = source;
    }
    /**
     * 获取：来源
     */
    public String getSource() {
        return source;
    }
    /**
     * 设置：内容
     */
    public void setCenter(String center) {
        this.center = center;
    }
    /**
     * 获取：内容
     */
    public String getCenter() {
        return center;
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
}
