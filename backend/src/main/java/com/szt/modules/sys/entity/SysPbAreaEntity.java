package com.szt.modules.sys.entity;
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

/**
 * 地址管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-08-20 00:11:07
 */
@TableName("sys_pb_area")
public class SysPbAreaEntity  implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * ID
         */
        @TableId
        @ApiModelProperty(value = "ID",required = false)
    private Long id;
        /**
         * 栏目名
         */
            @NotBlank(message="栏目名不能为空")
        @ApiModelProperty(value = "栏目名",required = false)
    private String areaname;
        /**
         * 父栏目
         */
            @NotNull(message="父栏目不能为空")
        @ApiModelProperty(value = "父栏目",required = false)
    private Long parentid;
        /**
         * 经度
         */
        @ApiModelProperty(value = "经度",required = true)
    private String lng;
        /**
         * 纬度
         */
        @ApiModelProperty(value = "纬度",required = true)
    private String lat;
        /**
         * 层级
         */
            @NotNull(message="层级不能为空")
        @ApiModelProperty(value = "层级",required = false)
    private Integer level;
        /**
         * 创建时间
         */
            @NotNull(message="创建时间不能为空")
        @ApiModelProperty(value = "创建时间",required = false)
        @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
        /**
         * 备注
         */
        @ApiModelProperty(value = "备注",required = true)
    private String remarks;
        /**
         * 排序
         */
        @ApiModelProperty(value = "排序",required = true)
    private Integer sort;
        /**
         * 版本号
         */
        @ApiModelProperty(value = "版本号",required = true)
    private Integer versionNo;
        /**
         * 创建人id
         */
        @ApiModelProperty(value = "创建人id",required = true)
    private Long createBy;
        /**
         * 修改人id
         */
        @ApiModelProperty(value = "修改人id",required = true)
    private Long updateBy;
        /**
         * 修改时间
         */
        @ApiModelProperty(value = "修改时间",required = true)
        @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;
        /**
         * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用
         */
            @NotBlank(message="逻辑删除不能为空")
        @ApiModelProperty(value = "逻辑删除@0-存在,1-隐藏,2-删除,3-停用",required = false)
    private String deleteFlag;
    @TableField(exist = false)
    private String isNext;
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
         * 设置：栏目名
         */
        public void setAreaname(String areaname) {
            this.areaname = areaname;
        }
        /**
         * 获取：栏目名
         */
        public String getAreaname() {
            return areaname;
        }
        /**
         * 设置：父栏目
         */
        public void setParentid(Long parentid) {
            this.parentid = parentid;
        }
        /**
         * 获取：父栏目
         */
        public Long getParentid() {
            return parentid;
        }
        /**
         * 设置：经度
         */
        public void setLng(String lng) {
            this.lng = lng;
        }
        /**
         * 获取：经度
         */
        public String getLng() {
            return lng;
        }
        /**
         * 设置：纬度
         */
        public void setLat(String lat) {
            this.lat = lat;
        }
        /**
         * 获取：纬度
         */
        public String getLat() {
            return lat;
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

    public String getIsNext() {
        return isNext;
    }

    public void setIsNext(String isNext) {
        this.isNext = isNext;
    }
}
