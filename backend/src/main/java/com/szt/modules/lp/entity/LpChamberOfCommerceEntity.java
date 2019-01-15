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
 * 商会列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-11-01 17:22:54
 */
@TableName("lp_chamber_of_commerce")
public class LpChamberOfCommerceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 历任秘书长信息
     */
    @NotBlank(message="历任秘书长信息不能为空")
    @ApiModelProperty(value = "历任秘书长信息",required = false)
    private String secretarygeneralsInfo;
    /**
     * 是否在民政部门登记
     */
    @ApiModelProperty(value = "是否在民政部门登记",required = false)
    private Boolean civilAffairs;
    /**
     * 后台用户id
     */
    @NotNull(message="后台用户id不能为空")
    @ApiModelProperty(value = "后台用户id",required = false)
    private Long sysUserId;
    /**
     * 常务理事数
     */
    @NotNull(message="常务理事数不能为空")
    @ApiModelProperty(value = "常务理事数",required = false)
    private Integer standingDirectorSize;
    /**
     * 秘书数
     */
    @NotNull(message="秘书数不能为空")
    @ApiModelProperty(value = "秘书数",required = false)
    private Integer secretarySize;
    /**
     * 团体所在行政区域
     */
    @NotBlank(message="团体所在行政区域不能为空")
    @ApiModelProperty(value = "团体所在行政区域",required = false)
    private String groupAdministrativeRegion;
    /**
     * 座机
     */
    @NotBlank(message="座机不能为空")
    @ApiModelProperty(value = "座机",required = false)
    private String specialPlane;
    /**
     * 邮编
     */
    @NotBlank(message="邮编不能为空")
    @ApiModelProperty(value = "邮编",required = false)
    private String postcode;
    /**
     * 会员数
     */
    @NotNull(message="会员数不能为空")
    @ApiModelProperty(value = "会员数",required = false)
    private Integer memberSize;
    /**
     * 企业网站
     */
    @NotBlank(message="企业网站不能为空")
    @ApiModelProperty(value = "企业网站",required = false)
    private String website;
    /**
     * 商会联系人
     */
    @NotBlank(message="商会联系人不能为空")
    @ApiModelProperty(value = "商会联系人",required = false)
    private String contact;
    /**
     * 历任会长信息
     */
    @NotBlank(message="历任会长信息不能为空")
    @ApiModelProperty(value = "历任会长信息",required = false)
    private String chairmansInfo;
    /**
     * 地址
     */
    @NotBlank(message="地址不能为空")
    @ApiModelProperty(value = "地址",required = false)
    private String address;
    /**
     * 商会法人
     */
    @NotBlank(message="商会法人不能为空")
    @ApiModelProperty(value = "商会法人",required = false)
    private String legalPerson;
    /**
     * 未在民政部登记原因
     */
    @NotBlank(message="未在民政部登记原因不能为空")
    @ApiModelProperty(value = "未在民政部登记原因",required = false)
    private String civilRegistrationCause;
    /**
     * 董事长姓名
     */
    @NotBlank(message="董事长姓名不能为空")
    @ApiModelProperty(value = "董事长姓名",required = false)
    private String presidentName;
    /**
     * 秘书处内设部门
     */
    @NotBlank(message="秘书处内设部门不能为空")
    @ApiModelProperty(value = "秘书处内设部门",required = false)
    private String secretariats;
    /**
     * 是否建立政党组织
     */
    @ApiModelProperty(value = "是否建立政党组织",required = false)
    private Boolean partyOrganization;
    /**
     * 商会类别@0-行业商会,1-乡镇商会,2-街道商会,3-村商会,4-异地商会,5-市场商会,6-园区商会,7-楼宇商会,8-其他
     */
    @NotBlank(message="商会类别不能为空")
    @ApiModelProperty(value = "商会类别@0-行业商会,1-乡镇商会,2-街道商会,3-村商会,4-异地商会,5-市场商会,6-园区商会,7-楼宇商会,8-其他",required = false)
    private String category;
    /**
     * 商会名称
     */
    @NotBlank(message="商会名称不能为空")
    @ApiModelProperty(value = "商会名称",required = false)
    private String name;
    /**
     * 成立时间
     */
    @NotNull(message="成立时间不能为空")
    @ApiModelProperty(value = "成立时间",required = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date establishedTime;
    /**
     * 手机
     */
    @NotBlank(message="手机不能为空")
    @ApiModelProperty(value = "手机",required = false)
    private String phone;
    /**
     * 传真
     */
    @NotBlank(message="传真不能为空")
    @ApiModelProperty(value = "传真",required = false)
    private String groupFox;
    /**
     * 邮箱
     */
    @NotBlank(message="邮箱不能为空")
    @ApiModelProperty(value = "邮箱",required = false)
    private String eMail;
    /**
     * 理事数
     */
    @NotNull(message="理事数不能为空")
    @ApiModelProperty(value = "理事数",required = false)
    private Integer directorSize;
    /**
     * 信用代码
     */
    @NotBlank(message="信用代码不能为空")
    @ApiModelProperty(value = "信用代码",required = false)
    private String creditCode;
    /**
     * 副会长数
     */
    @NotNull(message="副会长数不能为空")
    @ApiModelProperty(value = "副会长数",required = false)
    private Integer viceChairmanSize;
    /**
     * 专委会
     */
    @NotBlank(message="专委会不能为空")
    @ApiModelProperty(value = "专委会",required = false)
    private String specialCommittees;
    /**
     * 私人电话
     */
    @NotBlank(message="私人电话不能为空")
    @ApiModelProperty(value = "私人电话",required = false)
    private String personalCall;
    /**
     * 介绍
     */
    @NotBlank(message="介绍不能为空")
    @ApiModelProperty(value = "介绍",required = false)
    private String introduce;
    /**
     * 会长姓名
     */
    @NotBlank(message="会长姓名不能为空")
    @ApiModelProperty(value = "会长姓名",required = false)
    private String chairmanName;
    /**
     * 未建立党组原因
     */
    @NotBlank(message="未建立党组原因不能为空")
    @ApiModelProperty(value = "未建立党组原因",required = false)
    private String partyOrganizationCause;
    /**
     * 秘书长姓名
     */
    @NotBlank(message="秘书长姓名不能为空")
    @ApiModelProperty(value = "秘书长姓名",required = false)
    private String secretaryGeneralName;
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
     * 设置：历任秘书长信息
     */
    public void setSecretarygeneralsInfo(String secretarygeneralsInfo) {
        this.secretarygeneralsInfo = secretarygeneralsInfo;
    }
    /**
     * 获取：历任秘书长信息
     */
    public String getSecretarygeneralsInfo() {
        return secretarygeneralsInfo;
    }
    /**
     * 设置：是否在民政部门登记
     */
    public void setCivilAffairs(Boolean civilAffairs) {
        this.civilAffairs = civilAffairs;
    }
    /**
     * 获取：是否在民政部门登记
     */
    public Boolean getCivilAffairs() {
        return civilAffairs;
    }
    /**
     * 设置：后台用户id
     */
    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }
    /**
     * 获取：后台用户id
     */
    public Long getSysUserId() {
        return sysUserId;
    }
    /**
     * 设置：常务理事数
     */
    public void setStandingDirectorSize(Integer standingDirectorSize) {
        this.standingDirectorSize = standingDirectorSize;
    }
    /**
     * 获取：常务理事数
     */
    public Integer getStandingDirectorSize() {
        return standingDirectorSize;
    }
    /**
     * 设置：秘书数
     */
    public void setSecretarySize(Integer secretarySize) {
        this.secretarySize = secretarySize;
    }
    /**
     * 获取：秘书数
     */
    public Integer getSecretarySize() {
        return secretarySize;
    }
    /**
     * 设置：团体所在行政区域
     */
    public void setGroupAdministrativeRegion(String groupAdministrativeRegion) {
        this.groupAdministrativeRegion = groupAdministrativeRegion;
    }
    /**
     * 获取：团体所在行政区域
     */
    public String getGroupAdministrativeRegion() {
        return groupAdministrativeRegion;
    }
    /**
     * 设置：座机
     */
    public void setSpecialPlane(String specialPlane) {
        this.specialPlane = specialPlane;
    }
    /**
     * 获取：座机
     */
    public String getSpecialPlane() {
        return specialPlane;
    }
    /**
     * 设置：邮编
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    /**
     * 获取：邮编
     */
    public String getPostcode() {
        return postcode;
    }
    /**
     * 设置：会员数
     */
    public void setMemberSize(Integer memberSize) {
        this.memberSize = memberSize;
    }
    /**
     * 获取：会员数
     */
    public Integer getMemberSize() {
        return memberSize;
    }
    /**
     * 设置：企业网站
     */
    public void setWebsite(String website) {
        this.website = website;
    }
    /**
     * 获取：企业网站
     */
    public String getWebsite() {
        return website;
    }
    /**
     * 设置：商会联系人
     */
    public void setContact(String contact) {
        this.contact = contact;
    }
    /**
     * 获取：商会联系人
     */
    public String getContact() {
        return contact;
    }
    /**
     * 设置：历任会长信息
     */
    public void setChairmansInfo(String chairmansInfo) {
        this.chairmansInfo = chairmansInfo;
    }
    /**
     * 获取：历任会长信息
     */
    public String getChairmansInfo() {
        return chairmansInfo;
    }
    /**
     * 设置：地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * 获取：地址
     */
    public String getAddress() {
        return address;
    }
    /**
     * 设置：商会法人
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }
    /**
     * 获取：商会法人
     */
    public String getLegalPerson() {
        return legalPerson;
    }
    /**
     * 设置：未在民政部登记原因
     */
    public void setCivilRegistrationCause(String civilRegistrationCause) {
        this.civilRegistrationCause = civilRegistrationCause;
    }
    /**
     * 获取：未在民政部登记原因
     */
    public String getCivilRegistrationCause() {
        return civilRegistrationCause;
    }
    /**
     * 设置：董事长姓名
     */
    public void setPresidentName(String presidentName) {
        this.presidentName = presidentName;
    }
    /**
     * 获取：董事长姓名
     */
    public String getPresidentName() {
        return presidentName;
    }
    /**
     * 设置：秘书处内设部门
     */
    public void setSecretariats(String secretariats) {
        this.secretariats = secretariats;
    }
    /**
     * 获取：秘书处内设部门
     */
    public String getSecretariats() {
        return secretariats;
    }
    /**
     * 设置：是否建立政党组织
     */
    public void setPartyOrganization(Boolean partyOrganization) {
        this.partyOrganization = partyOrganization;
    }
    /**
     * 获取：是否建立政党组织
     */
    public Boolean getPartyOrganization() {
        return partyOrganization;
    }
    /**
     * 设置：商会类别@0-行业商会,1-乡镇商会,2-街道商会,3-村商会,4-异地商会,5-市场商会,6-园区商会,7-楼宇商会,8-其他
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     * 获取：商会类别@0-行业商会,1-乡镇商会,2-街道商会,3-村商会,4-异地商会,5-市场商会,6-园区商会,7-楼宇商会,8-其他
     */
    public String getCategory() {
        return category;
    }
    /**
     * 设置：商会名称
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：商会名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：成立时间
     */
    public void setEstablishedTime(Date establishedTime) {
        this.establishedTime = establishedTime;
    }
    /**
     * 获取：成立时间
     */
    public Date getEstablishedTime() {
        return establishedTime;
    }
    /**
     * 设置：手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * 获取：手机
     */
    public String getPhone() {
        return phone;
    }
    /**
     * 设置：传真
     */
    public void setGroupFox(String groupFox) {
        this.groupFox = groupFox;
    }
    /**
     * 获取：传真
     */
    public String getGroupFox() {
        return groupFox;
    }
    /**
     * 设置：邮箱
     */
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }
    /**
     * 获取：邮箱
     */
    public String getEMail() {
        return eMail;
    }
    /**
     * 设置：理事数
     */
    public void setDirectorSize(Integer directorSize) {
        this.directorSize = directorSize;
    }
    /**
     * 获取：理事数
     */
    public Integer getDirectorSize() {
        return directorSize;
    }
    /**
     * 设置：信用代码
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }
    /**
     * 获取：信用代码
     */
    public String getCreditCode() {
        return creditCode;
    }
    /**
     * 设置：副会长数
     */
    public void setViceChairmanSize(Integer viceChairmanSize) {
        this.viceChairmanSize = viceChairmanSize;
    }
    /**
     * 获取：副会长数
     */
    public Integer getViceChairmanSize() {
        return viceChairmanSize;
    }
    /**
     * 设置：专委会
     */
    public void setSpecialCommittees(String specialCommittees) {
        this.specialCommittees = specialCommittees;
    }
    /**
     * 获取：专委会
     */
    public String getSpecialCommittees() {
        return specialCommittees;
    }
    /**
     * 设置：私人电话
     */
    public void setPersonalCall(String personalCall) {
        this.personalCall = personalCall;
    }
    /**
     * 获取：私人电话
     */
    public String getPersonalCall() {
        return personalCall;
    }
    /**
     * 设置：介绍
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    /**
     * 获取：介绍
     */
    public String getIntroduce() {
        return introduce;
    }
    /**
     * 设置：会长姓名
     */
    public void setChairmanName(String chairmanName) {
        this.chairmanName = chairmanName;
    }
    /**
     * 获取：会长姓名
     */
    public String getChairmanName() {
        return chairmanName;
    }
    /**
     * 设置：未建立党组原因
     */
    public void setPartyOrganizationCause(String partyOrganizationCause) {
        this.partyOrganizationCause = partyOrganizationCause;
    }
    /**
     * 获取：未建立党组原因
     */
    public String getPartyOrganizationCause() {
        return partyOrganizationCause;
    }
    /**
     * 设置：秘书长姓名
     */
    public void setSecretaryGeneralName(String secretaryGeneralName) {
        this.secretaryGeneralName = secretaryGeneralName;
    }
    /**
     * 获取：秘书长姓名
     */
    public String getSecretaryGeneralName() {
        return secretaryGeneralName;
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
