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

/**
 * 会员列表
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-31 18:49:21
 */
@TableName("lp_user")
@ApiModel(value = "用户信息")
public class LpUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    @NotBlank(message="姓名不能为空")
    @ApiModelProperty(value = "姓名",required = false)
    private String name;
    /**
     * 状态@0-正常,1-禁用
     */
    @NotBlank(message="状态不能为空")
    @ApiModelProperty(value = "状态@0-正常,1-禁用",required = false)
    private String state;
    /**
     * 证件号
     */
    @NotBlank(message="证件号不能为空")
    @ApiModelProperty(value = "证件号",required = false)
    private String papersNumber;
    /**
     * 密钥
     */
    @NotBlank(message="密钥不能为空")
    @ApiModelProperty(value = "密钥",required = false)
    private String salt;
    /**
     * 出生地
     */
    @NotBlank(message="出生地不能为空")
    @ApiModelProperty(value = "出生地",required = false)
    private String birthplace;
    /**
     * 性别@0-女,1-男
     */
    @NotBlank(message="性别不能为空")
    @ApiModelProperty(value = "性别@0-女,1-男",required = false)
    private String sex;
    /**
     * 政治面貌@0-中共党员,1-中共预备党员,2-共青团员,3-民革党员,4-民盟盟员,5-民建会员,6-民进会员,7-农工党党员,8-致公党党员,9-九三学社社员,10-台盟盟员,11-无党派人士,12-群众
     */
    @NotBlank(message="政治面貌不能为空")
    @ApiModelProperty(value = "政治面貌@0-中共党员,1-中共预备党员,2-共青团员,3-民革党员,4-民盟盟员,5-民建会员,6-民进会员,7-农工党党员,8-致公党党员,9-九三学社社员,10-台盟盟员,11-无党派人士,12-群众",required = false)
    private String politicsStatus;
    /**
     * 民族
     */
    @NotBlank(message="民族不能为空")
    @ApiModelProperty(value = "民族",required = false)
    private String ethnic;
    /**
     * 手机
     */
    @NotBlank(message="手机不能为空")
    @ApiModelProperty(value = "手机",required = false)
    private String phone;
    /**
     * 企业所在行政区域
     */
    @NotBlank(message="企业所在行政区域不能为空")
    @ApiModelProperty(value = "企业所在行政区域",required = false)
    private String administrativeRegion;
    /**
     * 座机
     */
    @NotBlank(message="座机不能为空")
    @ApiModelProperty(value = "座机",required = false)
    private String specialPlane;
    /**
     * 工商登记注册类型@0-私营独资企业,1-私营合伙企业,2-私营有限责任公司,3-私营股份有限公司,4-港澳台合资企业,5-港澳台合作企业,6-港澳台独资企业,7-港澳台股份有限公司,8-中外合资企业,9-中外合作企业,10-外资企业,11-外商股份有限公司,12-国有企业,13-集体企业,14-股份合作企业,15-联营企业,16-其他有限责任公司,17-其他股份有限公司,18-其他企业
     */
    @NotBlank(message="工商登记注册类型不能为空")
    @ApiModelProperty(value = "工商登记注册类型@0-私营独资企业,1-私营合伙企业,2-私营有限责任公司,3-私营股份有限公司,4-港澳台合资企业,5-港澳台合作企业,6-港澳台独资企业,7-港澳台股份有限公司,8-中外合资企业,9-中外合作企业,10-外资企业,11-外商股份有限公司,12-国有企业,13-集体企业,14-股份合作企业,15-联营企业,16-其他有限责任公司,17-其他股份有限公司,18-其他企业",required = false)
    private String industryType;
    /**
     * 邮编
     */
    @NotBlank(message="邮编不能为空")
    @ApiModelProperty(value = "邮编",required = false)
    private String postcode;
    /**
     * 企业所在国家或地区
     */
    @NotBlank(message="企业所在国家或地区不能为空")
    @ApiModelProperty(value = "企业所在国家或地区",required = false)
    private String country;
    /**
     * 微信
     */
    @NotBlank(message="微信不能为空")
    @ApiModelProperty(value = "微信",required = false)
    private String wx;
    /**
     * 社会保险登记号
     */
    @NotBlank(message="社会保险登记号不能为空")
    @ApiModelProperty(value = "社会保险登记号",required = false)
    private String insuranceRegistrationNumber;
    /**
     * 其他企业代码类型@0-工商营业执照注册号,1-企业税务登记证号,2-组织机构代码
     */
    @NotBlank(message="其他企业代码类型不能为空")
    @ApiModelProperty(value = "其他企业代码类型@0-工商营业执照注册号,1-企业税务登记证号,2-组织机构代码",required = false)
    private String enterpriseCodeType;
    /**
     * 当前总资产(万元)
     */
    @NotBlank(message="当前总资产(万元)不能为空")
    @ApiModelProperty(value = "当前总资产(万元)",required = false)
    private String totalAssets;
    /**
     * 行业分类@0-农林、牧、渔业,1-采矿业,2-制造业,3-电力热力、燃气及水生产和供应业,4-建筑业,5-批发和零售业,6-交通运输、仓储和邮政业,7-住宿和餐饮业,8-信息传输、软件和信息技术服务业,9-金融业,10-房地产业,11-租赁和商务服务业,12-科学研究和技术服务业,13-水利、环境和公共设施管理业,14-居民服务、修理和其他服务业,15-教育,16-卫生和社会工作,17-文化、体育和娱乐业,18-公共管理、社会保障和社会组织
     */
    @NotBlank(message="行业分类不能为空")
    @ApiModelProperty(value = "行业分类@0-农林、牧、渔业,1-采矿业,2-制造业,3-电力热力、燃气及水生产和供应业,4-建筑业,5-批发和零售业,6-交通运输、仓储和邮政业,7-住宿和餐饮业,8-信息传输、软件和信息技术服务业,9-金融业,10-房地产业,11-租赁和商务服务业,12-科学研究和技术服务业,13-水利、环境和公共设施管理业,14-居民服务、修理和其他服务业,15-教育,16-卫生和社会工作,17-文化、体育和娱乐业,18-公共管理、社会保障和社会组织",required = false)
    private String classificationOfIndustry;
    /**
     * 法人电话(座机)
     */
    @NotBlank(message="法人电话(座机)不能为空")
    @ApiModelProperty(value = "法人电话(座机)",required = false)
    private String legalPersonPhone;
    /**
     * 企业网站
     */
    @NotBlank(message="企业网站不能为空")
    @ApiModelProperty(value = "企业网站",required = false)
    private String website;
    /**
     * 企业通讯地址
     */
    @NotBlank(message="企业通讯地址不能为空")
    @ApiModelProperty(value = "企业通讯地址",required = false)
    private String mailingAddress;
    /**
     * 中文名称
     */
    @NotBlank(message="中文名称不能为空")
    @ApiModelProperty(value = "中文名称",required = false)
    private String groupChineseName;
    /**
     * 职工人数
     */
    @NotBlank(message="职工人数不能为空")
    @ApiModelProperty(value = "职工人数",required = false)
    private String staffNumber;
    /**
     * 入会时间
     */
    @NotNull(message="入会时间不能为空")
    @ApiModelProperty(value = "入会时间",required = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date groupInitiationTime;
    /**
     * 信用级别@0-是,1-否
     */
    @NotBlank(message="信用级别不能为空")
    @ApiModelProperty(value = "信用级别@0-是,1-否",required = false)
    private String creditRatings;
    /**
     * 法定代表人姓名
     */
    @NotBlank(message="法定代表人姓名不能为空")
    @ApiModelProperty(value = "法定代表人姓名",required = false)
    private String groupStatutoryRepresentativeName;
    /**
     * 团体会员分类@0-私营企业协会,1-个体劳动者协会,2-乡镇企业协会,3-行业商(协)会,4-乡镇商会,5-街道商会,6-村商会,7-异地商会,8-市场商会,9-园区商会,10-楼宇商会,11-外企协会,12-其他
     */
    @NotBlank(message="团体会员分类不能为空")
    @ApiModelProperty(value = "团体会员分类@0-私营企业协会,1-个体劳动者协会,2-乡镇企业协会,3-行业商(协)会,4-乡镇商会,5-街道商会,6-村商会,7-异地商会,8-市场商会,9-园区商会,10-楼宇商会,11-外企协会,12-其他",required = false)
    private String groupCategory;
    /**
     * 邮政编码
     */
    @NotBlank(message="邮政编码不能为空")
    @ApiModelProperty(value = "邮政编码",required = false)
    private String groupPostalCode;
    /**
     * 批准登记机关
     */
    @NotBlank(message="批准登记机关不能为空")
    @ApiModelProperty(value = "批准登记机关",required = false)
    private String groupRegistrationAuthority;
    /**
     * 下属企业会员数量
     */
    @NotNull(message="下属企业会员数量不能为空")
    @ApiModelProperty(value = "下属企业会员数量",required = false)
    private Integer groupSubordinateCompanySize;
    /**
     * 通讯地址
     */
    @NotBlank(message="通讯地址不能为空")
    @ApiModelProperty(value = "通讯地址",required = false)
    private String groupPostalAddress;
    /**
     * 下属个人会员数量
     */
    @NotNull(message="下属个人会员数量不能为空")
    @ApiModelProperty(value = "下属个人会员数量",required = false)
    private Integer groupIndividualMemberSize;
    /**
     * 电子邮箱
     */
    @NotBlank(message="电子邮箱不能为空")
    @ApiModelProperty(value = "电子邮箱",required = false)
    private String groupEmailAddress;
    /**
     * 团体代表人列表
     */
    @NotBlank(message="团体代表人列表不能为空")
    @ApiModelProperty(value = "团体代表人列表",required = false)
    private String groupRepresentativeList;
    /**
     * 工商联职务
     */
    @NotBlank(message="工商联职务不能为空")
    @ApiModelProperty(value = "工商联职务",required = false)
    private String fbcciJob;
    /**
     * 用户类型@0-个人会员,1-企业会员,2-团体会员
     */
    @NotBlank(message="用户类型不能为空")
    @ApiModelProperty(value = "用户类型@0-个人会员,1-企业会员,2-团体会员",required = false)
    private String userType;
    /**
     * 政府职务
     */
    @NotBlank(message="政府职务不能为空")
    @ApiModelProperty(value = "政府职务",required = false)
    private String publicPositions;
    /**
     * 企业名称
     */
    @NotBlank(message="企业名称不能为空")
    @ApiModelProperty(value = "企业名称",required = false)
    private String entrepreneurName;
    /**
     * 其他职务
     */
    @NotBlank(message="其他职务不能为空")
    @ApiModelProperty(value = "其他职务",required = false)
    private String otherDuties;
    /**
     * 联系人手机号码
     */
    @NotBlank(message="联系人手机号码不能为空")
    @ApiModelProperty(value = "联系人手机号码",required = false)
    private String contactPhone;
    /**
     * 企业经营情况(万元)
     */
    @NotBlank(message="企业经营情况(万元)不能为空")
    @ApiModelProperty(value = "企业经营情况(万元)",required = false)
    private String businessCircumstance;
    /**
     * 是否有纳税信用级别
     */
    @ApiModelProperty(value = "是否有纳税信用级别",required = false)
    private Boolean ifCreditRatings;
    /**
     * 参与社会公益事业情况
     */
    @NotBlank(message="参与社会公益事业情况不能为空")
    @ApiModelProperty(value = "参与社会公益事业情况",required = false)
    private String thePublicIs;
    /**
     * 认证部门
     */
    @NotBlank(message="认证部门不能为空")
    @ApiModelProperty(value = "认证部门",required = false)
    private String certificationDepartment;
    /**
     * 企业创新技术
     */
    @NotBlank(message="企业创新技术不能为空")
    @ApiModelProperty(value = "企业创新技术",required = false)
    private String technicalInnovation;
    /**
     * 企业代表人列表
     */
    @NotBlank(message="企业代表人列表不能为空")
    @ApiModelProperty(value = "企业代表人列表",required = false)
    private String corporateRepresentativeList;
    /**
     * 用户名
     */
    @NotBlank(message="用户名不能为空")
    @ApiModelProperty(value = "用户名",required = false)
    private String userName;
    /**
     * 用户级别@0-市级工商联级别,1-分会/县级商会级别,2-县级工商联级别
     */
    @NotBlank(message="用户级别不能为空")
    @ApiModelProperty(value = "用户级别@0-市级工商联级别,1-分会/县级商会级别,2-县级工商联级别",required = false)
    private String grade;
    /**
     * 证件类型@0-身份证,1-护照,2-军人证,3-驾驶证,4-工作证,5-学生证,6-户口本,7-暂住证,8-警官证,9-单位介绍信,10-营业执照,11-武警身份证,12-港澳居民来往内地通行证,13-台湾居民来往大陆通行证,14-事业单位法人证书,15-其他
     */
    @NotBlank(message="证件类型不能为空")
    @ApiModelProperty(value = "证件类型@0-身份证,1-护照,2-军人证,3-驾驶证,4-工作证,5-学生证,6-户口本,7-暂住证,8-警官证,9-单位介绍信,10-营业执照,11-武警身份证,12-港澳居民来往内地通行证,13-台湾居民来往大陆通行证,14-事业单位法人证书,15-其他",required = false)
    private String papersType;
    /**
     * 密码
     */
    @NotBlank(message="密码不能为空")
    @ApiModelProperty(value = "密码",required = false)
    private String password;
    /**
     * 籍贯
     */
    @NotBlank(message="籍贯不能为空")
    @ApiModelProperty(value = "籍贯",required = false)
    private String nativePlace;
    /**
     * 头像
     */
    @NotBlank(message="头像不能为空")
    @ApiModelProperty(value = "头像",required = false)
    private String headPortrait;
    /**
     * 曾用名
     */
    @NotBlank(message="曾用名不能为空")
    @ApiModelProperty(value = "曾用名",required = false)
    private String formerName;
    /**
     * 出生日期
     */
    @NotNull(message="出生日期不能为空")
    @ApiModelProperty(value = "出生日期",required = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date dateOfBirth;
    /**
     * 学历@0-研究生,1-本科生,2-大专生,3-中专及以下
     */
    @NotBlank(message="学历不能为空")
    @ApiModelProperty(value = "学历@0-研究生,1-本科生,2-大专生,3-中专及以下",required = false)
    private String education;
    /**
     * 入会时间
     */
    @NotNull(message="入会时间不能为空")
    @ApiModelProperty(value = "入会时间",required = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date initiationTime;
    /**
     * 通讯地址
     */
    @NotBlank(message="通讯地址不能为空")
    @ApiModelProperty(value = "通讯地址",required = false)
    private String postalAddress;
    /**
     * 企业工商登记名称
     */
    @NotBlank(message="企业工商登记名称不能为空")
    @ApiModelProperty(value = "企业工商登记名称",required = false)
    private String industryiName;
    /**
     * 邮箱
     */
    @NotBlank(message="邮箱不能为空")
    @ApiModelProperty(value = "邮箱",required = false)
    private String eMail;
    /**
     * 法定代表人姓名
     */
    @NotBlank(message="法定代表人姓名不能为空")
    @ApiModelProperty(value = "法定代表人姓名",required = false)
    private String statutoryRepresentativeName;
    /**
     * qq
     */
    @NotBlank(message="qq不能为空")
    @ApiModelProperty(value = "qq",required = false)
    private String qq;
    /**
     * 信用代码
     */
    @NotBlank(message="信用代码不能为空")
    @ApiModelProperty(value = "信用代码",required = false)
    private String creditCode;
    /**
     * 电子邮箱
     */
    @NotBlank(message="电子邮箱不能为空")
    @ApiModelProperty(value = "电子邮箱",required = false)
    private String emailAddress;
    /**
     * 企业代码号
     */
    @NotBlank(message="企业代码号不能为空")
    @ApiModelProperty(value = "企业代码号",required = false)
    private String enterpriseCodeNumber;
    /**
     * 法人职务
     */
    @NotBlank(message="法人职务不能为空")
    @ApiModelProperty(value = "法人职务",required = false)
    private String legalPersonPosition;
    /**
     * 企业规模@0-大型,1-中型,2-小型,3-微型
     */
    @NotBlank(message="企业规模不能为空")
    @ApiModelProperty(value = "企业规模@0-大型,1-中型,2-小型,3-微型",required = false)
    private String scale;
    /**
     * 法人手机号
     */
    @NotBlank(message="法人手机号不能为空")
    @ApiModelProperty(value = "法人手机号",required = false)
    private String legalPersonPhoneNumber;
    /**
     * 成立时间
     */
    @NotNull(message="成立时间不能为空")
    @ApiModelProperty(value = "成立时间",required = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date establishedTime;
    /**
     * 团体所在行政区域
     */
    @NotBlank(message="团体所在行政区域不能为空")
    @ApiModelProperty(value = "团体所在行政区域",required = false)
    private String groupAdministrativeRegion;
    /**
     * 注册资金(万元)
     */
    @NotBlank(message="注册资金(万元)不能为空")
    @ApiModelProperty(value = "注册资金(万元)",required = false)
    private String registeredFund;
    /**
     * 英文名称
     */
    @NotBlank(message="英文名称不能为空")
    @ApiModelProperty(value = "英文名称",required = false)
    private String groupEnglishName;
    /**
     * 合同率
     */
    @NotNull(message="合同率不能为空")
    @ApiModelProperty(value = "合同率",required = false)
    private Integer theContractRate;
    /**
     * 成立时间
     */
    @NotNull(message="成立时间不能为空")
    @ApiModelProperty(value = "成立时间",required = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date groupEstablishedTime;
    /**
     * 是否被认证为高新技术企业@0-是,1-否
     */
    @NotBlank(message="是否被认证为高新技术企业不能为空")
    @ApiModelProperty(value = "是否被认证为高新技术企业@0-是,1-否",required = false)
    private String isAdvancedTechnology;
    /**
     * 业务主管单位
     */
    @NotBlank(message="业务主管单位不能为空")
    @ApiModelProperty(value = "业务主管单位",required = false)
    private String groupCompetentOrganization;
    /**
     * 团体网站
     */
    @NotBlank(message="团体网站不能为空")
    @ApiModelProperty(value = "团体网站",required = false)
    private String groupWebsite;
    /**
     * 统一社会信用代码
     */
    @NotBlank(message="统一社会信用代码不能为空")
    @ApiModelProperty(value = "统一社会信用代码",required = false)
    private String groupUniformCreditCode;
    /**
     * 下属团体会员数量
     */
    @NotNull(message="下属团体会员数量不能为空")
    @ApiModelProperty(value = "下属团体会员数量",required = false)
    private Integer groupMembersSize;
    /**
     * 办公电话
     */
    @NotBlank(message="办公电话不能为空")
    @ApiModelProperty(value = "办公电话",required = false)
    private String groupOfficePhone;
    /**
     * 商会id
     */
    @NotNull(message="商会id不能为空")
    @ApiModelProperty(value = "商会id",required = false)
    private Long coceralId;
    /**
     * 传真
     */
    @NotBlank(message="传真不能为空")
    @ApiModelProperty(value = "传真",required = false)
    private String groupFox;
    /**
     * 个人荣誉
     */
    @NotBlank(message="个人荣誉不能为空")
    @ApiModelProperty(value = "个人荣誉",required = false)
    private String personalHonor;
    /**
     * 企业职务
     */
    @NotBlank(message="企业职务不能为空")
    @ApiModelProperty(value = "企业职务",required = false)
    private String enterprisePosition;
    /**
     * 团体联系人列表
     */
    @NotBlank(message="团体联系人列表不能为空")
    @ApiModelProperty(value = "团体联系人列表",required = false)
    private String groupContactList;
    /**
     * 人大职务
     */
    @NotBlank(message="人大职务不能为空")
    @ApiModelProperty(value = "人大职务",required = false)
    private String npcJob;
    /**
     * 团体名称
     */
    @NotBlank(message="团体名称不能为空")
    @ApiModelProperty(value = "团体名称",required = false)
    private String groupName;
    /**
     * 政协职能
     */
    @NotBlank(message="政协职能不能为空")
    @ApiModelProperty(value = "政协职能",required = false)
    private String functionsOfCppcc;
    /**
     * 企业简介
     */
    @NotBlank(message="企业简介不能为空")
    @ApiModelProperty(value = "企业简介",required = false)
    private String enterpriseProfile;
    /**
     * 主要下属企业
     */
    @NotBlank(message="主要下属企业不能为空")
    @ApiModelProperty(value = "主要下属企业",required = false)
    private String theMainAffiliate;
    /**
     * 是否被认证为高新技术企业
     */
    @ApiModelProperty(value = "是否被认证为高新技术企业",required = false)
    private Boolean ifHighTechnology;
    /**
     * 纳税信用级别
     */
    @NotBlank(message="纳税信用级别不能为空")
    @ApiModelProperty(value = "纳税信用级别",required = false)
    private String taxCreditRating;
    /**
     * 参加社会保险情况
     */
    @NotBlank(message="参加社会保险情况不能为空")
    @ApiModelProperty(value = "参加社会保险情况",required = false)
    private String socialInsurance;
    /**
     * 企业联系人列表
     */
    @NotBlank(message="企业联系人列表不能为空")
    @ApiModelProperty(value = "企业联系人列表",required = false)
    private String corporateContactList;
    /**
     * 企业组织
     */
    @NotBlank(message="企业组织不能为空")
    @ApiModelProperty(value = "企业组织",required = false)
    private String businessOrganization;
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
    private String token;
    /**
     * 设置：姓名
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：姓名
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：状态@0-正常,1-禁用
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * 获取：状态@0-正常,1-禁用
     */
    public String getState() {
        return state;
    }
    /**
     * 设置：证件号
     */
    public void setPapersNumber(String papersNumber) {
        this.papersNumber = papersNumber;
    }
    /**
     * 获取：证件号
     */
    public String getPapersNumber() {
        return papersNumber;
    }
    /**
     * 设置：密钥
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }
    /**
     * 获取：密钥
     */
    public String getSalt() {
        return salt;
    }
    /**
     * 设置：出生地
     */
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    /**
     * 获取：出生地
     */
    public String getBirthplace() {
        return birthplace;
    }
    /**
     * 设置：性别@0-女,1-男
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * 获取：性别@0-女,1-男
     */
    public String getSex() {
        return sex;
    }
    /**
     * 设置：政治面貌@0-中共党员,1-中共预备党员,2-共青团员,3-民革党员,4-民盟盟员,5-民建会员,6-民进会员,7-农工党党员,8-致公党党员,9-九三学社社员,10-台盟盟员,11-无党派人士,12-群众
     */
    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }
    /**
     * 获取：政治面貌@0-中共党员,1-中共预备党员,2-共青团员,3-民革党员,4-民盟盟员,5-民建会员,6-民进会员,7-农工党党员,8-致公党党员,9-九三学社社员,10-台盟盟员,11-无党派人士,12-群众
     */
    public String getPoliticsStatus() {
        return politicsStatus;
    }
    /**
     * 设置：民族
     */
    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }
    /**
     * 获取：民族
     */
    public String getEthnic() {
        return ethnic;
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
     * 设置：企业所在行政区域
     */
    public void setAdministrativeRegion(String administrativeRegion) {
        this.administrativeRegion = administrativeRegion;
    }
    /**
     * 获取：企业所在行政区域
     */
    public String getAdministrativeRegion() {
        return administrativeRegion;
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
     * 设置：工商登记注册类型@0-私营独资企业,1-私营合伙企业,2-私营有限责任公司,3-私营股份有限公司,4-港澳台合资企业,5-港澳台合作企业,6-港澳台独资企业,7-港澳台股份有限公司,8-中外合资企业,9-中外合作企业,10-外资企业,11-外商股份有限公司,12-国有企业,13-集体企业,14-股份合作企业,15-联营企业,16-其他有限责任公司,17-其他股份有限公司,18-其他企业
     */
    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }
    /**
     * 获取：工商登记注册类型@0-私营独资企业,1-私营合伙企业,2-私营有限责任公司,3-私营股份有限公司,4-港澳台合资企业,5-港澳台合作企业,6-港澳台独资企业,7-港澳台股份有限公司,8-中外合资企业,9-中外合作企业,10-外资企业,11-外商股份有限公司,12-国有企业,13-集体企业,14-股份合作企业,15-联营企业,16-其他有限责任公司,17-其他股份有限公司,18-其他企业
     */
    public String getIndustryType() {
        return industryType;
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
     * 设置：企业所在国家或地区
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * 获取：企业所在国家或地区
     */
    public String getCountry() {
        return country;
    }
    /**
     * 设置：微信
     */
    public void setWx(String wx) {
        this.wx = wx;
    }
    /**
     * 获取：微信
     */
    public String getWx() {
        return wx;
    }
    /**
     * 设置：社会保险登记号
     */
    public void setInsuranceRegistrationNumber(String insuranceRegistrationNumber) {
        this.insuranceRegistrationNumber = insuranceRegistrationNumber;
    }
    /**
     * 获取：社会保险登记号
     */
    public String getInsuranceRegistrationNumber() {
        return insuranceRegistrationNumber;
    }
    /**
     * 设置：其他企业代码类型@0-工商营业执照注册号,1-企业税务登记证号,2-组织机构代码
     */
    public void setEnterpriseCodeType(String enterpriseCodeType) {
        this.enterpriseCodeType = enterpriseCodeType;
    }
    /**
     * 获取：其他企业代码类型@0-工商营业执照注册号,1-企业税务登记证号,2-组织机构代码
     */
    public String getEnterpriseCodeType() {
        return enterpriseCodeType;
    }
    /**
     * 设置：当前总资产(万元)
     */
    public void setTotalAssets(String totalAssets) {
        this.totalAssets = totalAssets;
    }
    /**
     * 获取：当前总资产(万元)
     */
    public String getTotalAssets() {
        return totalAssets;
    }
    /**
     * 设置：行业分类@0-农林、牧、渔业,1-采矿业,2-制造业,3-电力热力、燃气及水生产和供应业,4-建筑业,5-批发和零售业,6-交通运输、仓储和邮政业,7-住宿和餐饮业,8-信息传输、软件和信息技术服务业,9-金融业,10-房地产业,11-租赁和商务服务业,12-科学研究和技术服务业,13-水利、环境和公共设施管理业,14-居民服务、修理和其他服务业,15-教育,16-卫生和社会工作,17-文化、体育和娱乐业,18-公共管理、社会保障和社会组织
     */
    public void setClassificationOfIndustry(String classificationOfIndustry) {
        this.classificationOfIndustry = classificationOfIndustry;
    }
    /**
     * 获取：行业分类@0-农林、牧、渔业,1-采矿业,2-制造业,3-电力热力、燃气及水生产和供应业,4-建筑业,5-批发和零售业,6-交通运输、仓储和邮政业,7-住宿和餐饮业,8-信息传输、软件和信息技术服务业,9-金融业,10-房地产业,11-租赁和商务服务业,12-科学研究和技术服务业,13-水利、环境和公共设施管理业,14-居民服务、修理和其他服务业,15-教育,16-卫生和社会工作,17-文化、体育和娱乐业,18-公共管理、社会保障和社会组织
     */
    public String getClassificationOfIndustry() {
        return classificationOfIndustry;
    }
    /**
     * 设置：法人电话(座机)
     */
    public void setLegalPersonPhone(String legalPersonPhone) {
        this.legalPersonPhone = legalPersonPhone;
    }
    /**
     * 获取：法人电话(座机)
     */
    public String getLegalPersonPhone() {
        return legalPersonPhone;
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
     * 设置：企业通讯地址
     */
    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
    /**
     * 获取：企业通讯地址
     */
    public String getMailingAddress() {
        return mailingAddress;
    }
    /**
     * 设置：中文名称
     */
    public void setGroupChineseName(String groupChineseName) {
        this.groupChineseName = groupChineseName;
    }
    /**
     * 获取：中文名称
     */
    public String getGroupChineseName() {
        return groupChineseName;
    }
    /**
     * 设置：职工人数
     */
    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }
    /**
     * 获取：职工人数
     */
    public String getStaffNumber() {
        return staffNumber;
    }
    /**
     * 设置：入会时间
     */
    public void setGroupInitiationTime(Date groupInitiationTime) {
        this.groupInitiationTime = groupInitiationTime;
    }
    /**
     * 获取：入会时间
     */
    public Date getGroupInitiationTime() {
        return groupInitiationTime;
    }
    /**
     * 设置：信用级别@0-是,1-否
     */
    public void setCreditRatings(String creditRatings) {
        this.creditRatings = creditRatings;
    }
    /**
     * 获取：信用级别@0-是,1-否
     */
    public String getCreditRatings() {
        return creditRatings;
    }
    /**
     * 设置：法定代表人姓名
     */
    public void setGroupStatutoryRepresentativeName(String groupStatutoryRepresentativeName) {
        this.groupStatutoryRepresentativeName = groupStatutoryRepresentativeName;
    }
    /**
     * 获取：法定代表人姓名
     */
    public String getGroupStatutoryRepresentativeName() {
        return groupStatutoryRepresentativeName;
    }
    /**
     * 设置：团体会员分类@0-私营企业协会,1-个体劳动者协会,2-乡镇企业协会,3-行业商(协)会,4-乡镇商会,5-街道商会,6-村商会,7-异地商会,8-市场商会,9-园区商会,10-楼宇商会,11-外企协会,12-其他
     */
    public void setGroupCategory(String groupCategory) {
        this.groupCategory = groupCategory;
    }
    /**
     * 获取：团体会员分类@0-私营企业协会,1-个体劳动者协会,2-乡镇企业协会,3-行业商(协)会,4-乡镇商会,5-街道商会,6-村商会,7-异地商会,8-市场商会,9-园区商会,10-楼宇商会,11-外企协会,12-其他
     */
    public String getGroupCategory() {
        return groupCategory;
    }
    /**
     * 设置：邮政编码
     */
    public void setGroupPostalCode(String groupPostalCode) {
        this.groupPostalCode = groupPostalCode;
    }
    /**
     * 获取：邮政编码
     */
    public String getGroupPostalCode() {
        return groupPostalCode;
    }
    /**
     * 设置：批准登记机关
     */
    public void setGroupRegistrationAuthority(String groupRegistrationAuthority) {
        this.groupRegistrationAuthority = groupRegistrationAuthority;
    }
    /**
     * 获取：批准登记机关
     */
    public String getGroupRegistrationAuthority() {
        return groupRegistrationAuthority;
    }
    /**
     * 设置：下属企业会员数量
     */
    public void setGroupSubordinateCompanySize(Integer groupSubordinateCompanySize) {
        this.groupSubordinateCompanySize = groupSubordinateCompanySize;
    }
    /**
     * 获取：下属企业会员数量
     */
    public Integer getGroupSubordinateCompanySize() {
        return groupSubordinateCompanySize;
    }
    /**
     * 设置：通讯地址
     */
    public void setGroupPostalAddress(String groupPostalAddress) {
        this.groupPostalAddress = groupPostalAddress;
    }
    /**
     * 获取：通讯地址
     */
    public String getGroupPostalAddress() {
        return groupPostalAddress;
    }
    /**
     * 设置：下属个人会员数量
     */
    public void setGroupIndividualMemberSize(Integer groupIndividualMemberSize) {
        this.groupIndividualMemberSize = groupIndividualMemberSize;
    }
    /**
     * 获取：下属个人会员数量
     */
    public Integer getGroupIndividualMemberSize() {
        return groupIndividualMemberSize;
    }
    /**
     * 设置：电子邮箱
     */
    public void setGroupEmailAddress(String groupEmailAddress) {
        this.groupEmailAddress = groupEmailAddress;
    }
    /**
     * 获取：电子邮箱
     */
    public String getGroupEmailAddress() {
        return groupEmailAddress;
    }
    /**
     * 设置：团体代表人列表
     */
    public void setGroupRepresentativeList(String groupRepresentativeList) {
        this.groupRepresentativeList = groupRepresentativeList;
    }
    /**
     * 获取：团体代表人列表
     */
    public String getGroupRepresentativeList() {
        return groupRepresentativeList;
    }
    /**
     * 设置：工商联职务
     */
    public void setFbcciJob(String fbcciJob) {
        this.fbcciJob = fbcciJob;
    }
    /**
     * 获取：工商联职务
     */
    public String getFbcciJob() {
        return fbcciJob;
    }
    /**
     * 设置：用户类型@0-个人会员,1-企业会员,2-团体会员
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }
    /**
     * 获取：用户类型@0-个人会员,1-企业会员,2-团体会员
     */
    public String getUserType() {
        return userType;
    }
    /**
     * 设置：政府职务
     */
    public void setPublicPositions(String publicPositions) {
        this.publicPositions = publicPositions;
    }
    /**
     * 获取：政府职务
     */
    public String getPublicPositions() {
        return publicPositions;
    }
    /**
     * 设置：企业名称
     */
    public void setEntrepreneurName(String entrepreneurName) {
        this.entrepreneurName = entrepreneurName;
    }
    /**
     * 获取：企业名称
     */
    public String getEntrepreneurName() {
        return entrepreneurName;
    }
    /**
     * 设置：其他职务
     */
    public void setOtherDuties(String otherDuties) {
        this.otherDuties = otherDuties;
    }
    /**
     * 获取：其他职务
     */
    public String getOtherDuties() {
        return otherDuties;
    }
    /**
     * 设置：联系人手机号码
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    /**
     * 获取：联系人手机号码
     */
    public String getContactPhone() {
        return contactPhone;
    }
    /**
     * 设置：企业经营情况(万元)
     */
    public void setBusinessCircumstance(String businessCircumstance) {
        this.businessCircumstance = businessCircumstance;
    }
    /**
     * 获取：企业经营情况(万元)
     */
    public String getBusinessCircumstance() {
        return businessCircumstance;
    }
    /**
     * 设置：是否有纳税信用级别
     */
    public void setIfCreditRatings(Boolean ifCreditRatings) {
        this.ifCreditRatings = ifCreditRatings;
    }
    /**
     * 获取：是否有纳税信用级别
     */
    public Boolean getIfCreditRatings() {
        return ifCreditRatings;
    }
    /**
     * 设置：参与社会公益事业情况
     */
    public void setThePublicIs(String thePublicIs) {
        this.thePublicIs = thePublicIs;
    }
    /**
     * 获取：参与社会公益事业情况
     */
    public String getThePublicIs() {
        return thePublicIs;
    }
    /**
     * 设置：认证部门
     */
    public void setCertificationDepartment(String certificationDepartment) {
        this.certificationDepartment = certificationDepartment;
    }
    /**
     * 获取：认证部门
     */
    public String getCertificationDepartment() {
        return certificationDepartment;
    }
    /**
     * 设置：企业创新技术
     */
    public void setTechnicalInnovation(String technicalInnovation) {
        this.technicalInnovation = technicalInnovation;
    }
    /**
     * 获取：企业创新技术
     */
    public String getTechnicalInnovation() {
        return technicalInnovation;
    }
    /**
     * 设置：企业代表人列表
     */
    public void setCorporateRepresentativeList(String corporateRepresentativeList) {
        this.corporateRepresentativeList = corporateRepresentativeList;
    }
    /**
     * 获取：企业代表人列表
     */
    public String getCorporateRepresentativeList() {
        return corporateRepresentativeList;
    }
    /**
     * 设置：用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * 获取：用户名
     */
    public String getUserName() {
        return userName;
    }
    /**
     * 设置：用户级别@0-市级工商联级别,1-分会/县级商会级别,2-县级工商联级别
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
    /**
     * 获取：用户级别@0-市级工商联级别,1-分会/县级商会级别,2-县级工商联级别
     */
    public String getGrade() {
        return grade;
    }
    /**
     * 设置：证件类型@0-身份证,1-护照,2-军人证,3-驾驶证,4-工作证,5-学生证,6-户口本,7-暂住证,8-警官证,9-单位介绍信,10-营业执照,11-武警身份证,12-港澳居民来往内地通行证,13-台湾居民来往大陆通行证,14-事业单位法人证书,15-其他
     */
    public void setPapersType(String papersType) {
        this.papersType = papersType;
    }
    /**
     * 获取：证件类型@0-身份证,1-护照,2-军人证,3-驾驶证,4-工作证,5-学生证,6-户口本,7-暂住证,8-警官证,9-单位介绍信,10-营业执照,11-武警身份证,12-港澳居民来往内地通行证,13-台湾居民来往大陆通行证,14-事业单位法人证书,15-其他
     */
    public String getPapersType() {
        return papersType;
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
     * 设置：籍贯
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
    /**
     * 获取：籍贯
     */
    public String getNativePlace() {
        return nativePlace;
    }
    /**
     * 设置：头像
     */
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }
    /**
     * 获取：头像
     */
    public String getHeadPortrait() {
        return headPortrait;
    }
    /**
     * 设置：曾用名
     */
    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }
    /**
     * 获取：曾用名
     */
    public String getFormerName() {
        return formerName;
    }
    /**
     * 设置：出生日期
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * 获取：出生日期
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * 设置：学历@0-研究生,1-本科生,2-大专生,3-中专及以下
     */
    public void setEducation(String education) {
        this.education = education;
    }
    /**
     * 获取：学历@0-研究生,1-本科生,2-大专生,3-中专及以下
     */
    public String getEducation() {
        return education;
    }
    /**
     * 设置：入会时间
     */
    public void setInitiationTime(Date initiationTime) {
        this.initiationTime = initiationTime;
    }
    /**
     * 获取：入会时间
     */
    public Date getInitiationTime() {
        return initiationTime;
    }
    /**
     * 设置：通讯地址
     */
    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }
    /**
     * 获取：通讯地址
     */
    public String getPostalAddress() {
        return postalAddress;
    }
    /**
     * 设置：企业工商登记名称
     */
    public void setIndustryiName(String industryiName) {
        this.industryiName = industryiName;
    }
    /**
     * 获取：企业工商登记名称
     */
    public String getIndustryiName() {
        return industryiName;
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
     * 设置：法定代表人姓名
     */
    public void setStatutoryRepresentativeName(String statutoryRepresentativeName) {
        this.statutoryRepresentativeName = statutoryRepresentativeName;
    }
    /**
     * 获取：法定代表人姓名
     */
    public String getStatutoryRepresentativeName() {
        return statutoryRepresentativeName;
    }
    /**
     * 设置：qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }
    /**
     * 获取：qq
     */
    public String getQq() {
        return qq;
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
     * 设置：电子邮箱
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    /**
     * 获取：电子邮箱
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    /**
     * 设置：企业代码号
     */
    public void setEnterpriseCodeNumber(String enterpriseCodeNumber) {
        this.enterpriseCodeNumber = enterpriseCodeNumber;
    }
    /**
     * 获取：企业代码号
     */
    public String getEnterpriseCodeNumber() {
        return enterpriseCodeNumber;
    }
    /**
     * 设置：法人职务
     */
    public void setLegalPersonPosition(String legalPersonPosition) {
        this.legalPersonPosition = legalPersonPosition;
    }
    /**
     * 获取：法人职务
     */
    public String getLegalPersonPosition() {
        return legalPersonPosition;
    }
    /**
     * 设置：企业规模@0-大型,1-中型,2-小型,3-微型
     */
    public void setScale(String scale) {
        this.scale = scale;
    }
    /**
     * 获取：企业规模@0-大型,1-中型,2-小型,3-微型
     */
    public String getScale() {
        return scale;
    }
    /**
     * 设置：法人手机号
     */
    public void setLegalPersonPhoneNumber(String legalPersonPhoneNumber) {
        this.legalPersonPhoneNumber = legalPersonPhoneNumber;
    }
    /**
     * 获取：法人手机号
     */
    public String getLegalPersonPhoneNumber() {
        return legalPersonPhoneNumber;
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
     * 设置：注册资金(万元)
     */
    public void setRegisteredFund(String registeredFund) {
        this.registeredFund = registeredFund;
    }
    /**
     * 获取：注册资金(万元)
     */
    public String getRegisteredFund() {
        return registeredFund;
    }
    /**
     * 设置：英文名称
     */
    public void setGroupEnglishName(String groupEnglishName) {
        this.groupEnglishName = groupEnglishName;
    }
    /**
     * 获取：英文名称
     */
    public String getGroupEnglishName() {
        return groupEnglishName;
    }
    /**
     * 设置：合同率
     */
    public void setTheContractRate(Integer theContractRate) {
        this.theContractRate = theContractRate;
    }
    /**
     * 获取：合同率
     */
    public Integer getTheContractRate() {
        return theContractRate;
    }
    /**
     * 设置：成立时间
     */
    public void setGroupEstablishedTime(Date groupEstablishedTime) {
        this.groupEstablishedTime = groupEstablishedTime;
    }
    /**
     * 获取：成立时间
     */
    public Date getGroupEstablishedTime() {
        return groupEstablishedTime;
    }
    /**
     * 设置：是否被认证为高新技术企业@0-是,1-否
     */
    public void setIsAdvancedTechnology(String isAdvancedTechnology) {
        this.isAdvancedTechnology = isAdvancedTechnology;
    }
    /**
     * 获取：是否被认证为高新技术企业@0-是,1-否
     */
    public String getIsAdvancedTechnology() {
        return isAdvancedTechnology;
    }
    /**
     * 设置：业务主管单位
     */
    public void setGroupCompetentOrganization(String groupCompetentOrganization) {
        this.groupCompetentOrganization = groupCompetentOrganization;
    }
    /**
     * 获取：业务主管单位
     */
    public String getGroupCompetentOrganization() {
        return groupCompetentOrganization;
    }
    /**
     * 设置：团体网站
     */
    public void setGroupWebsite(String groupWebsite) {
        this.groupWebsite = groupWebsite;
    }
    /**
     * 获取：团体网站
     */
    public String getGroupWebsite() {
        return groupWebsite;
    }
    /**
     * 设置：统一社会信用代码
     */
    public void setGroupUniformCreditCode(String groupUniformCreditCode) {
        this.groupUniformCreditCode = groupUniformCreditCode;
    }
    /**
     * 获取：统一社会信用代码
     */
    public String getGroupUniformCreditCode() {
        return groupUniformCreditCode;
    }
    /**
     * 设置：下属团体会员数量
     */
    public void setGroupMembersSize(Integer groupMembersSize) {
        this.groupMembersSize = groupMembersSize;
    }
    /**
     * 获取：下属团体会员数量
     */
    public Integer getGroupMembersSize() {
        return groupMembersSize;
    }
    /**
     * 设置：办公电话
     */
    public void setGroupOfficePhone(String groupOfficePhone) {
        this.groupOfficePhone = groupOfficePhone;
    }
    /**
     * 获取：办公电话
     */
    public String getGroupOfficePhone() {
        return groupOfficePhone;
    }
    /**
     * 设置：商会id
     */
    public void setCoceralId(Long coceralId) {
        this.coceralId = coceralId;
    }
    /**
     * 获取：商会id
     */
    public Long getCoceralId() {
        return coceralId;
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
     * 设置：个人荣誉
     */
    public void setPersonalHonor(String personalHonor) {
        this.personalHonor = personalHonor;
    }
    /**
     * 获取：个人荣誉
     */
    public String getPersonalHonor() {
        return personalHonor;
    }
    /**
     * 设置：企业职务
     */
    public void setEnterprisePosition(String enterprisePosition) {
        this.enterprisePosition = enterprisePosition;
    }
    /**
     * 获取：企业职务
     */
    public String getEnterprisePosition() {
        return enterprisePosition;
    }
    /**
     * 设置：团体联系人列表
     */
    public void setGroupContactList(String groupContactList) {
        this.groupContactList = groupContactList;
    }
    /**
     * 获取：团体联系人列表
     */
    public String getGroupContactList() {
        return groupContactList;
    }
    /**
     * 设置：人大职务
     */
    public void setNpcJob(String npcJob) {
        this.npcJob = npcJob;
    }
    /**
     * 获取：人大职务
     */
    public String getNpcJob() {
        return npcJob;
    }
    /**
     * 设置：团体名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    /**
     * 获取：团体名称
     */
    public String getGroupName() {
        return groupName;
    }
    /**
     * 设置：政协职能
     */
    public void setFunctionsOfCppcc(String functionsOfCppcc) {
        this.functionsOfCppcc = functionsOfCppcc;
    }
    /**
     * 获取：政协职能
     */
    public String getFunctionsOfCppcc() {
        return functionsOfCppcc;
    }
    /**
     * 设置：企业简介
     */
    public void setEnterpriseProfile(String enterpriseProfile) {
        this.enterpriseProfile = enterpriseProfile;
    }
    /**
     * 获取：企业简介
     */
    public String getEnterpriseProfile() {
        return enterpriseProfile;
    }
    /**
     * 设置：主要下属企业
     */
    public void setTheMainAffiliate(String theMainAffiliate) {
        this.theMainAffiliate = theMainAffiliate;
    }
    /**
     * 获取：主要下属企业
     */
    public String getTheMainAffiliate() {
        return theMainAffiliate;
    }
    /**
     * 设置：是否被认证为高新技术企业
     */
    public void setIfHighTechnology(Boolean ifHighTechnology) {
        this.ifHighTechnology = ifHighTechnology;
    }
    /**
     * 获取：是否被认证为高新技术企业
     */
    public Boolean getIfHighTechnology() {
        return ifHighTechnology;
    }
    /**
     * 设置：纳税信用级别
     */
    public void setTaxCreditRating(String taxCreditRating) {
        this.taxCreditRating = taxCreditRating;
    }
    /**
     * 获取：纳税信用级别
     */
    public String getTaxCreditRating() {
        return taxCreditRating;
    }
    /**
     * 设置：参加社会保险情况
     */
    public void setSocialInsurance(String socialInsurance) {
        this.socialInsurance = socialInsurance;
    }
    /**
     * 获取：参加社会保险情况
     */
    public String getSocialInsurance() {
        return socialInsurance;
    }
    /**
     * 设置：企业联系人列表
     */
    public void setCorporateContactList(String corporateContactList) {
        this.corporateContactList = corporateContactList;
    }
    /**
     * 获取：企业联系人列表
     */
    public String getCorporateContactList() {
        return corporateContactList;
    }
    /**
     * 设置：企业组织
     */
    public void setBusinessOrganization(String businessOrganization) {
        this.businessOrganization = businessOrganization;
    }
    /**
     * 获取：企业组织
     */
    public String getBusinessOrganization() {
        return businessOrganization;
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
