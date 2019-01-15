package com.szt.modules.sys.entity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 区域
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-09-20 16:55:00
 */
@TableName("ke_region")
public class KeRegionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 
         */
        @TableId
        @ApiModelProperty(value = "",required = false)
    private Integer id;
        /**
         * 名称
         */
            @NotBlank(message="名称不能为空")
        @ApiModelProperty(value = "名称",required = false)
    private String name;
        /**
         * 上级ID
         */
            @NotNull(message="上级ID不能为空")
        @ApiModelProperty(value = "上级ID",required = false)
    private Integer pid;
        /**
         * 1省级 2市级 3区县级 4乡镇街道级
         */
            @NotNull(message="1省级 2市级 3区县级 4乡镇街道级不能为空")
        @ApiModelProperty(value = "1省级 2市级 3区县级 4乡镇街道级",required = false)
    private Integer type;
        /**
         * 行政区域
         */
            @NotNull(message="行政区域不能为空")
        @ApiModelProperty(value = "行政区域",required = false)
    private Long code;
        /**
         * 运费
         */
        @ApiModelProperty(value = "运费",required = true)
    private Integer fee;
        /**
         * 1、参与免邮 2、不参与
         */
        @ApiModelProperty(value = "1、参与免邮 2、不参与",required = true)
    private Integer feeType;
        /**
         * 免邮金额
         */
        @ApiModelProperty(value = "免邮金额",required = true)
    private Integer freeFee;

        /**
         * 设置：
         */
        public void setId(Integer id) {
            this.id = id;
        }
        /**
         * 获取：
         */
        public Integer getId() {
            return id;
        }
        /**
         * 设置：名称
         */
        public void setName(String name) {
            this.name = name;
        }
        /**
         * 获取：名称
         */
        public String getName() {
            return name;
        }
        /**
         * 设置：上级ID
         */
        public void setPid(Integer pid) {
            this.pid = pid;
        }
        /**
         * 获取：上级ID
         */
        public Integer getPid() {
            return pid;
        }
        /**
         * 设置：1省级 2市级 3区县级 4乡镇街道级
         */
        public void setType(Integer type) {
            this.type = type;
        }
        /**
         * 获取：1省级 2市级 3区县级 4乡镇街道级
         */
        public Integer getType() {
            return type;
        }
        /**
         * 设置：行政区域
         */
        public void setCode(Long code) {
            this.code = code;
        }
        /**
         * 获取：行政区域
         */
        public Long getCode() {
            return code;
        }
        /**
         * 设置：运费
         */
        public void setFee(Integer fee) {
            this.fee = fee;
        }
        /**
         * 获取：运费
         */
        public Integer getFee() {
            return fee;
        }
        /**
         * 设置：1、参与免邮 2、不参与
         */
        public void setFeeType(Integer feeType) {
            this.feeType = feeType;
        }
        /**
         * 获取：1、参与免邮 2、不参与
         */
        public Integer getFeeType() {
            return feeType;
        }
        /**
         * 设置：免邮金额
         */
        public void setFreeFee(Integer freeFee) {
            this.freeFee = freeFee;
        }
        /**
         * 获取：免邮金额
         */
        public Integer getFreeFee() {
            return freeFee;
        }

    public void insert(){
//        this.createTime = new Date();
//        this.updateTime = new Date();
//        this.sort = this.sort == null ? 0 : this.sort;
//        if(this.deleteFlag == null || this.deleteFlag.length()==0){
//            this.deleteFlag = "0";
//        }
//        this.versionNo=1;
    }
    public void update(){
       // this.updateTime = new Date();
    }
}
