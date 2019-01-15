<template>
  <div v-if="isUpdate" id="update">
    <el-form :inline="true" :validate-on-rule-change="false" :model="chamberOfCommerce" :rules="chamberOfCommerceRule" ref="chamberOfCommerceRule" @keyup.enter.native="dataFormSubmits()" class="demo-form-inline" label-position="right" label-width="120px">
      <el-row :gutter="24">
        <el-col class="col" :lg="8"  >
          <formItem v-model="chamberOfCommerce.userName" :dataRule="chamberOfCommerce" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.userName" :model="model" :isPage="true" :size="size"></formItem>
        </el-col>
        <el-col class="col" :lg="16">
          <formItem v-model="chamberOfCommerce.password" :dataRule="chamberOfCommerce" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.password"   :model="model" :isPage="true" :size="size"></formItem>
        </el-col>
      </el-row>
      <el-row>
        <!--导航栏-->
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" style="margin-bottom:20px;">
          <el-menu-item index="1" >企业基本信息</el-menu-item>
          <el-menu-item index="2">企业代表人</el-menu-item>
        </el-menu>
        <div class="line" v-show="activeIndex==1">
          <!--图片上传-->
          <el-row :gutter="24">
            <!--企业所在行政区域-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.administrativeRegion" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :model="coceralModule" :pathUrl="coceralPathUrl" :field="fieldMap.administrativeRegion"    :isPage="true" :size="size"></formItem>
            </el-col>
            <!--企业名称-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.entrepreneurName" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :model="coceralModule" :pathUrl="coceralPathUrl" :field="fieldMap.entrepreneurName"    :isPage="true" :size="size"></formItem>
            </el-col>
            <!--入会时间-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.initiationTime" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.initiationTime"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--企业工商登记名-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.industryiName" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.industryiName"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--工商登记类型-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.industryType" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.industryType"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--归属商会-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.coceralId" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.coceralId"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--法定代表人姓名-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.statutoryRepresentativeName" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.statutoryRepresentativeName"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--企业所在国家或地区-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.country" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.country"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--统一社会信用代码-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.creditCode" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.creditCode"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--其他企业代码类型-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.enterpriseCodeType" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.enterpriseCodeType"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--企业代码号-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.enterpriseCodeNumber" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.enterpriseCodeNumber"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--行业分类-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.classificationOfIndustry" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.classificationOfIndustry"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--企业规模-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.scale" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.scale"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--企业网站-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.website" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.website"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--成立时间-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.establishedTime" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.establishedTime"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--社会保险登记号-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.insuranceRegistrationNumber" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.insuranceRegistrationNumber"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--电子邮箱-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.emailAddress" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.emailAddress" :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--当前总资产-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.totalAssets" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.totalAssets"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--	法人职务-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.legalPersonPosition" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.legalPersonPosition"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--法人电话-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.legalPersonPhone" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.legalPersonPhone"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--法人手机号-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.legalPersonPhoneNumber" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.legalPersonPhoneNumber"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--企业通讯地址-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.mailingAddress" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.mailingAddress"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--注册资金-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.registeredFund" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.registeredFund"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--职工总人数-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.staffNumber" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.staffNumber"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--职工劳动合同-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.theContractRate" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.theContractRate"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
            <!--是否有纳税信用级别-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.ifCreditRatings" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.ifCreditRatings"   :model="model" :isPage="false" :size="size"></formItem>
            </el-col>
            <!--是否被认证为高新技术企业-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.ifHighTechnology" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.ifHighTechnology"   :model="model" :isPage="false" :size="size"></formItem>
            </el-col>
            <!--认证部门-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.certificationDepartment" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.certificationDepartment"   :model="model" :isPage="true" :size="size"></formItem>
            </el-col>
          </el-row>
        </div>
        <div class="line" v-show="activeIndex==2">
          <!--企业代表人-->
          <el-form-item   prop="corporateRepresentativeList">
            <el-card class="box-card">
              <div slot="header" class="clearfix" >
                <span>企业代表人列表</span>
              </div>
              <div class="text item">
                <el-form  class="demo-ruleForm" :model="corporateRepresentativeList" :rules="corporateRepresentativeListFrom"  ref="corporateRepresentativeListFrom" @keyup.enter.native="addcorporateRepresentativeList()">
                  <!--普通文本框-->
                  <el-row :gutter="24">
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="name">
                        <el-input :size="size" v-model="corporateRepresentativeList.name" placeholder="姓名"  >
                          <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">姓名</label></template>
                        </el-input>
                      </el-form-item>
                    </el-col>
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="sex">
                        <!--下拉选select-->
                        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                          <div class="el-input-group__prepend"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">性别</label></div>
                          <el-select v-model="corporateRepresentativeList.sex"   :size="size" :filterable="true" placeholder="性别" style="width:100%;">
                            <el-option
                              label="男"
                              value="1">
                            </el-option>
                            <el-option
                              label="女"
                              value="0">
                            </el-option>
                          </el-select>
                        </div>
                      </el-form-item>
                    </el-col>
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="birthDate">
                        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                          <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">出生日期</label></div>
                          <el-date-picker v-model="corporateRepresentativeList.birthDate" :size="size"  type="date" style="width:100%;" value-format="yyyy-MM-dd"  placeholder="出生日期" format="yyyy-MM-dd">

                          </el-date-picker>
                        </div>
                      </el-form-item>
                    </el-col>
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="organization">
                        <el-input :size="size" v-model="corporateRepresentativeList.organization" placeholder="所在企业"  >
                        </el-input>
                      </el-form-item>
                    </el-col>
                    <el-col class="col" :lg="8">
                      <el-button type="success" @click="addcorporateRepresentativeList()">添加企业代表人</el-button>
                    </el-col>
                  </el-row>
                </el-form>
                <el-table
                  :data="chamberOfCommerce.corporateRepresentativeList"
                  height="250"
                  border
                  style="width: 100%">
                  <el-table-column
                    prop="name"
                    label="姓名"  >
                  </el-table-column>
                  <el-table-column
                    prop="sex"
                    label="性别"  >
                    <template slot-scope="scope">
                      <span v-text="scope.row.sex=='1'?'男':'女'"></span>
                    </template>
                  </el-table-column>
                  <el-table-column
                    prop="birthDate"
                    label="出生日期"  >
                  </el-table-column>
                  <el-table-column
                    prop="organization"
                    label="所在组织"  >
                  </el-table-column>
                  <el-table-column
                    fixed="right"
                    header-align="center"
                    align="center"
                    width="300"
                    label="操作">
                    <template slot-scope="scope">
                      <el-button  :size="size"  @click="chamberOfCommerce.corporateRepresentativeList.splice(scope.$index,1)">删除</el-button>
                    </template>
                  </el-table-column>
                </el-table>
              </div>
            </el-card>
          </el-form-item>
        </div>
      </el-row>
      <div>
        <!--企业联系人--->
        <el-form-item   prop="corporateContactList">
          <el-card class="box-card">
            <div slot="header" class="clearfix" >
              <span>企业联系人</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="corporateContactList" :rules="corporateContactListForm" ref="corporateContactListForm" @keyup.enter.native="addcorporateContactList()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="name">
                      <el-input :size="size" v-model="corporateContactList.linkman" placeholder="联系人"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">联系人</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="department">
                      <el-input :size="size" v-model="corporateContactList.contactPhone" placeholder="联系人手机号"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">联系人手机号</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="duty">
                      <el-input :size="size" v-model="corporateContactList.duty" placeholder="联系人职务"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">联系人职务</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addcorporateContactList()">添加企业联系人</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.corporateContactList"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="linkman"
                  label="联系人"  >
                </el-table-column>
                <el-table-column
                  prop="contactPhone"
                  label="联系人手机号"  >
                </el-table-column>
                <el-table-column
                  prop="duty"
                  label="联系人职务"  >
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.corporateContactList.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>
        <!--企业简介--->
        <el-form-item   prop="enterpriseProfile">
          <el-card class="box-card">
            <div slot="header" class="clearfix" >
              <span>企业简介</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" id="enter" label-position="right" :model="chamberOfCommerce.enterpriseProfile" :rules="enterpriseProfileForm" ref="enterpriseProfileForm" @keyup.enter.native="addenterpriseProfile()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="24">
                    <el-form-item   prop="primaryService" label="主要业务">
                      <el-input :size="size":autosize="{ minRows: 4, maxRows: 4}"
                                type="textarea"
                                :rows="2" v-model="chamberOfCommerce.enterpriseProfile.primaryService" placeholder="主营业务"  >

                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="24">
                    <el-form-item   prop="majorProduct" label="主要产品和服务">
                      <el-input :size="size" :autosize="{ minRows: 4, maxRows: 4}"
                                type="textarea"
                                :rows="2"v-model="chamberOfCommerce.enterpriseProfile.majorProduct" placeholder="主要产品和服务"  >

                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="24">
                    <el-form-item   prop="synopsis" label="企业基本情况简介">
                      <el-input :size="size" :autosize="{ minRows: 4, maxRows: 4}"
                                type="textarea"
                                :rows="2"v-model="chamberOfCommerce.enterpriseProfile.synopsis" placeholder="企业基本情况简介"  >

                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="24">
                    <el-form-item   prop="outstandingFeature" label="企业突出特点">
                      <el-input :size="size":autosize="{ minRows: 4, maxRows: 4}"
                                type="textarea"
                                :rows="2" v-model="chamberOfCommerce.enterpriseProfile.outstandingFeature" placeholder="企业突出特点"  >

                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="24">
                    <el-form-item   prop="influence" label="行业地位及影响">
                      <el-input :size="size":autosize="{ minRows: 4, maxRows: 4}"
                                type="textarea"
                                :rows="2" v-model="chamberOfCommerce.enterpriseProfile.influence" placeholder="行业地位及影响"  >

                      </el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-form>
            </div>
          </el-card>
        </el-form-item>
        <!--企业组织情况--->
        <el-form-item   prop="businessOrganization">
          <el-card class="box-card">
            <div slot="header" class="clearfix" >
              <span>企业组织情况</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="chamberOfCommerce.businessOrganization"  ref="businessOrganizationForm" @keyup.enter.native="addbusinessOrganization()">
                <!--党组织情况-->
                <div>
                <h4 style="text-align: center">企业党组织情况</h4>
                <el-row :gutter="24">
                  <!--是否建立党组织-->
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="ifPartyOrganization">
                      <el-switch clearable
                                 v-model="chamberOfCommerce.businessOrganization.ifPartyOrganization"
                                 active-text="是否建立党组织" >
                      </el-switch>
                    </el-form-item>
                  </el-col>
                  <!--党组织机构-->
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="ifPartyOrganization">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">党组织机构</label></div>
                        <el-radio-group  v-model="chamberOfCommerce.businessOrganization.partyStructure" style="    padding: 6px;border: 1px solid #dcdfe6;border-radius: 0 4px 4px 0;" :size="size" clearable>
                        <el-radio label="党委"  key="0"   :size="size">党委</el-radio>
                        <el-radio label="党总支"  key="1"   :size="size">党总支</el-radio>
                        <el-radio label="党支部"  key="2"   :size="size">党支部</el-radio>
                      </el-radio-group>
                      </div>
                    </el-form-item>
                  </el-col>
                  <!--成立时间-->
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="date">
                        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                          <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">成立时间</label></div>
                          <el-date-picker v-model="chamberOfCommerce.businessOrganization.partyDate" clearable :size="size"  type="date" style="width:100%;" value-format="yyyy-MM-dd"  placeholder="成立时间" format="yyyy-MM-dd">

                          </el-date-picker>
                        </div>
                    </el-form-item>
                  </el-col>
                  <!--党员人数-->
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="size">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">党员人数</label></div>
                        <el-input-number clearable v-model="chamberOfCommerce.businessOrganization.partySize"   :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <!--团委(总支或支部)书记姓名-->
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="name">
                      <el-input :size="size" v-model="chamberOfCommerce.businessOrganization.partyName" placeholder="党委(总支或支部)书记姓名"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">党委(总支或支部)书记姓名</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                </div>
                <!--企业团组织情况-->
                <div>
                  <h4 style="text-align: center">企业团组织情况</h4>
                  <el-row :gutter="24">
                    <!--是否建立团组织-->
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="ifPartyOrganization">
                        <el-switch clearable
                                   v-model="chamberOfCommerce.businessOrganization.ifMissionOrganization"
                                   active-text="是否建立团组织"
                        >
                        </el-switch>
                      </el-form-item>
                    </el-col>
                    <!--团组织机构-->
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="ifPartyOrganization">
                        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                          <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">团组织机构</label></div>
                          <el-radio-group  v-model="chamberOfCommerce.businessOrganization.regimentStructure" style="    padding: 6px;border: 1px solid #dcdfe6;border-radius: 0 4px 4px 0;" :size="size" clearable>
                            <el-radio label="党委"  key="0"   :size="size">团委</el-radio>
                            <el-radio label="党总支"  key="1"   :size="size">团总支</el-radio>
                            <el-radio label="党支部"  key="2"   :size="size">团支部</el-radio>
                          </el-radio-group>
                        </div>
                      </el-form-item>
                    </el-col>
                    <!--成立时间-->
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="date">
                        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                          <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">成立时间</label></div>
                          <el-date-picker v-model="chamberOfCommerce.businessOrganization.regimentDate" clearable :size="size"  type="date" style="width:100%;" value-format="yyyy-MM-dd"  placeholder="成立时间" format="yyyy-MM-dd">

                          </el-date-picker>
                        </div>
                      </el-form-item>
                    </el-col>
                    <!--党员人数-->
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="size">
                        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                          <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">团员人数</label></div>
                          <el-input-number clearable v-model="chamberOfCommerce.businessOrganization.regimentSize"   :min="0"  :size="size"> </el-input-number>
                        </div>
                      </el-form-item>
                    </el-col>
                    <!--团委(总支或支部)书记姓名-->
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="name">
                        <el-input :size="size" v-model="chamberOfCommerce.businessOrganization.regimentName" placeholder="团委(总支或支部)书记姓名"  >
                          <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">团委(总支或支部)书记姓名</label></template>
                        </el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </div>
                <!--企业工会组织情况-->
                <div>
                  <h4 style="text-align: center">企业工会织情况</h4>
                  <el-row :gutter="24">
                    <!--企业工会织情况-->
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="iflaborUnion">
                        <el-switch clearable
                                   v-model="chamberOfCommerce.businessOrganization.iflaborUnion"
                                   active-text="是否建立工会组织"
                        >
                        </el-switch>
                      </el-form-item>
                    </el-col>
                    <!--工会主席姓名-->
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="laborUnionName">
                          <el-input :size="size" v-model="chamberOfCommerce.businessOrganization.laborUnionName" placeholder="工会主席姓名"  >
                            <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">工会主席姓名</label></template>
                          </el-input>
                      </el-form-item>
                    </el-col>
                    <!--成立时间-->
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="laborUnionDate">
                        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                          <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">成立时间</label></div>
                          <el-date-picker v-model="chamberOfCommerce.businessOrganization.laborUnionDate" clearable :size="size"  type="date" style="width:100%;" value-format="yyyy-MM-dd"  placeholder="成立时间" format="yyyy-MM-dd">

                          </el-date-picker>
                        </div>
                      </el-form-item>
                    </el-col>
                    <!--党员人数-->
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="laborUnionSize">
                        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                          <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">团员人数</label></div>
                          <el-input-number clearable v-model="chamberOfCommerce.businessOrganization.laborUnionSize"   :min="0"  :size="size"> </el-input-number>
                        </div>
                      </el-form-item>
                    </el-col>
                    <!--占职工数比例-->
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="proportion">
                          <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                            <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">占职工数比例</label></div>
                            <el-input-number clearable v-model="chamberOfCommerce.businessOrganization.proportion"   :min="0"  :size="size"> </el-input-number>
                          </div>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </div>
              </el-form>
            </div>
          </el-card>
        </el-form-item>
        <!--企业经营情况(万元)--->
        <el-form-item   prop="businessCircumstance">
          <el-card class="box-card">
            <div slot="header" class="clearfix" >
              <span>企业经营情况(万元)</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="businessCircumstance"  ref="businessCircumstanceForm" @keyup.enter.native="addbusinessCircumstance()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="year">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">年份</label></div>
                        <el-date-picker v-model="businessCircumstance.year" format="yyyy" value-format="yyyy" clearable :size="size"  type="year" style="width:100%;"   placeholder="年份" >
                           </el-date-picker>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="contactPhone">
                    <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                      <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">所有者权益(经济指标,万元)</label></div>
                      <el-input-number clearable  v-model="businessCircumstance.contactPhone"  :min="0"  :size="size"> </el-input-number>
                    </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="registeredFund">
                    <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                      <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">注册资金(万元)</label></div>
                      <el-input-number clearable  v-model="businessCircumstance.registeredFund"  :min="0"  :size="size"> </el-input-number>
                    </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="totalAssets">
                    <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                      <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">总资产(万元)</label></div>
                      <el-input-number clearable  v-model="businessCircumstance.totalAssets"  :min="0"  :size="size"> </el-input-number>
                    </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="netAsset">
                    <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                      <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">净资产(万元)</label></div>
                      <el-input-number clearable  v-model="businessCircumstance.netAsset"  :min="0"  :size="size"> </el-input-number>
                    </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="assetsAndLiabilities">
                    <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                      <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">资产负债(万元)</label></div>
                      <el-input-number clearable  v-model="businessCircumstance.assetsAndLiabilities"  :min="0"  :size="size"> </el-input-number>
                    </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="totalSales">
                    <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                      <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">销售总额(万元)</label></div>
                      <el-input-number clearable  v-model="businessCircumstance.totalSales"  :min="0"  :size="size"> </el-input-number>
                    </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="totalRevenue">
                    <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                      <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">营业收入总额(万元)</label></div>
                      <el-input-number clearable  v-model="businessCircumstance.totalRevenue"  :min="0"  :size="size"> </el-input-number>
                    </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="totalProfit">
                    <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                      <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">利润总额(万元)</label></div>
                      <el-input-number clearable  v-model="businessCircumstance.totalProfit"  :min="0"  :size="size"> </el-input-number>
                    </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="totalTax">
                    <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                      <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">纳税总额(万元)</label></div>
                      <el-input-number clearable  v-model="businessCircumstance.totalTax"  :min="0"  :size="size"> </el-input-number>
                    </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addbusinessCircumstance()">添加联系人</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.businessCircumstance"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="year"
                  label="年份"  >
                </el-table-column>
                <el-table-column
                  prop="registeredFund"
                  label="注册资金(万元)"  >
                </el-table-column>
                <el-table-column
                  prop="totalAssets"
                  label="总资产(万元)"  >
                </el-table-column>
                 <el-table-column
                  prop="netAsset"
                  label="净资产(万元)"  >
                </el-table-column>
                <el-table-column
                  prop="assetsAndLiabilities"
                  label="资产负债(万元)"  >
                </el-table-column>
                 <el-table-column
                  prop="totalSales"
                  label="销售总额(万元)"  >
                </el-table-column>
                <el-table-column
                  prop="totalRevenue"
                  label="营业收入总额(万元)"  >
                </el-table-column>
                <el-table-column
                  prop="totalTax"
                  label="利润总额(万元)"  >
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.businessCircumstance.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>

        <!--主要下属企业--->
        <el-form-item   prop="theMainAffiliate">
          <el-card class="box-card">
            <div slot="header" class="clearfix" >
              <span>主要下属企业</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="theMainAffiliate"  ref="theMainAffiliateForm" @keyup.enter.native="addtheMainAffiliate()">
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="code">
                      <el-input :size="size" v-model="theMainAffiliate.code" placeholder="统一社会信用代码"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">统一社会信用代码</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="name">
                      <el-input :size="size" v-model="theMainAffiliate.name" placeholder="企业名称"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">企业名称</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addtheMainAffiliate()">添加下属企业</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.theMainAffiliate"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="code"
                  label="统一社会信用代码"  >
                </el-table-column>
                <el-table-column
                  prop="name"
                  label="企业名称"  >
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.theMainAffiliate.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>
        <!--参加社会保险情况--->
        <el-form-item   prop="socialInsurance">
          <el-card class="box-card">
            <div slot="header" class="clearfix" >
              <span>参加社会保险情况</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="socialInsurance"  ref="socialInsuranceForm" @keyup.enter.native="addsocialInsurance()">
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="year">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">年份</label></div>
                        <el-date-picker v-model="socialInsurance.year" format="yyyy" value-format="yyyy" clearable :size="size"  type="year" style="width:100%;"   placeholder="年份" >
                       </el-date-picker>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="contributorsIn">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">社会保险参加人数</label></div>
                        <el-input-number clearable  v-model="socialInsurance.contributorsIn"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="insuranceProbability">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">社会保险参保率</label></div>
                        <el-input-number clearable  v-model="socialInsurance.insuranceProbability"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="insuranceType">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">纳税信用级别</label></div>
                        <el-select v-model="socialInsurance.insuranceType" clearable   :size="size" :filterable="true" placeholder="纳税信用级别" style="width:100%;">
                          <el-option
                            label="基本养老保险"
                            value="基本养老保险">
                          </el-option>
                          <el-option
                            label="基本医疗保险"
                            value="基本医疗保险">
                          </el-option>
                          <el-option
                            label="失业保险"
                            value="失业保险">
                          </el-option>
                          <el-option
                            label="生育保险"
                            value="生育保险">
                          </el-option>
                          <el-option
                            label="公积金"
                            value="公积金">
                          </el-option>
                          <el-option
                            label="五险合一"
                            value="五险合一">
                          </el-option>
                        </el-select>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="thePayableAmount">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">社会保险应缴额(万元)</label></div>
                        <el-input-number clearable  v-model="socialInsurance.thePayableAmount"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="theActuallyPaidAmount">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">社会保险实缴额(万元)</label></div>
                        <el-input-number clearable  v-model="socialInsurance.theActuallyPaidAmount"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addsocialInsurance()">确认添加</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.socialInsurance"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="year"
                  label="年份"  >
                </el-table-column>
                <el-table-column
                  prop="contributorsIn"
                  label="社会保险参加人数"  >
                </el-table-column>
                <el-table-column
                  prop="insuranceProbability"
                  label="社会保险参保率"  >
                </el-table-column>
                <el-table-column
                  prop="insuranceType"
                  label="社会保险参加类型"  >
                </el-table-column>
                <el-table-column
                  prop="thePayableAmount"
                  label="社会保险应缴额(万元)"  >
                </el-table-column>
                <el-table-column
                  prop="theActuallyPaidAmount"
                  label="社会保险实缴额(万元)"  >
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.socialInsurance.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>
        <!--参与社会公益事业情况--->
        <el-form-item   prop="thePublicIs">
          <el-card class="box-card">
            <div slot="header" class="clearfix" >
              <span>参与社会公益事业情况</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="thePublicIs"  ref="thePublicIsForm" @keyup.enter.native="addthePublicIs()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="year">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">年份</label></div>
                        <el-date-picker v-model="thePublicIs.year" format="yyyy" value-format="yyyy" clearable :size="size"  type="year" style="width:100%;"   placeholder="年份" >
                         </el-date-picker>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="unit">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">参与单位</label></div>
                        <el-input-number clearable  v-model="thePublicIs.unit"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="aRecipient">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">受助对象</label></div>
                        <el-input-number clearable  v-model="thePublicIs.aRecipient"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="donationsToProject">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">捐助项目</label></div>
                        <el-input-number clearable  v-model="thePublicIs.donationsToProject"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="actualContributionAmount">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">实际捐款金额(万元)</label></div>
                        <el-input-number clearable  v-model="thePublicIs.actualContributionAmount"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="theActualGift">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">实际捐物/捐物价值(万元)</label></div>
                        <el-input-number clearable  v-model="thePublicIs.theActualGift"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addthePublicIs()">确认添加</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.thePublicIs"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="year"
                  label="年份"  >
                </el-table-column>
                <el-table-column
                  prop="unit"
                  label="参与单位"  >
                </el-table-column>
                <el-table-column
                  prop="aRecipient"
                  label="受助对象"  >
                </el-table-column>
                <el-table-column
                  prop="donationsToProject"
                  label="捐助项目"  >
                </el-table-column>
                <el-table-column
                  prop="actualContributionAmount"
                  label="实际捐款金额(万元)"  >
                </el-table-column>
                <el-table-column
                  prop="theActualGift"
                  label="实际捐物/捐物价值(万元)"  >
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.thePublicIs.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>
        <!--纳税信用级别--->
        <el-form-item   prop="taxCreditRating">
          <el-card class="box-card">
            <div slot="header" class="clearfix" >
              <span>纳税信用级别</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="taxCreditRating"  ref="taxCreditRatingForm" @keyup.enter.native="addtaxCreditRating()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="year">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">年份</label></div>
                        <el-date-picker v-model="taxCreditRating.year" format="yyyy" value-format="yyyy" clearable :size="size"  type="year" style="width:100%;"   placeholder="年份" >
                        </el-date-picker>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="creditRatings">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">纳税信用级别</label></div>
                        <el-select v-model="taxCreditRating.creditRatings" clearable   :size="size" :filterable="true" placeholder="纳税信用级别" style="width:100%;">
                          <el-option
                            label="A"
                            value="A">
                          </el-option>
                          <el-option
                            label="B"
                            value="B">
                          </el-option>
                          <el-option
                            label="C"
                            value="C">
                          </el-option>
                          <el-option
                            label="D"
                            value="D">
                          </el-option>
                        </el-select>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addtaxCreditRating()">添加联系人</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.taxCreditRating"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="year"
                  label="年份"  >
                </el-table-column>
                <el-table-column
                  prop="creditRatings"
                  label="纳税信用级别"  >
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.taxCreditRating.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>
        <!--企业创新技术--->
        <el-form-item   prop="technicalInnovation">
          <el-card class="box-card">
            <div slot="header" class="clearfix" >
              <span>企业创新技术</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="technicalInnovation"  ref="technicalInnovationForm" @keyup.enter.native="addtechnicalInnovation()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="researchSizeNationalLevel">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">研发数量(国家级)</label></div>
                        <el-input-number clearable  v-model="chamberOfCommerce.technicalInnovation.researchSizeNationalLevel"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="researchSizeProvincialLevel">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">研发数量(省级)</label></div>
                        <el-input-number clearable  v-model="chamberOfCommerce.technicalInnovation.researchSizeProvincialLevel"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="researchSizeCityAndCounty">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">研发数量(市县级)</label></div>
                        <el-input-number clearable  v-model="chamberOfCommerce.technicalInnovation.researchSizeCityAndCounty"  :min="0"  :size="size"> </el-input-number>
                      </div>

                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="patentForInvention">
                      <el-input :size="size" v-model="chamberOfCommerce.technicalInnovation.patentForInvention" placeholder="发明专利"   clearable>
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">发明专利</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="assetsAndLiabilities">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">科技进步奖数量(国家级)</label></div>
                        <el-input-number clearable  v-model="chamberOfCommerce.technicalInnovation.progressPrizeSizeNationalLevel"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="totalSales">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">科技进步奖数量(省级)</label></div>
                        <el-input-number clearable  v-model="chamberOfCommerce.technicalInnovation.progressPrizeSizeProvincialLevel"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="totalRevenue">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">科技进步奖数量(市县级)</label></div>
                        <el-input-number clearable  v-model="chamberOfCommerce.technicalInnovation.progressPrizeSizeCityAndCounty"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="totalTax">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">研发费用占销售收入比例(%)</label></div>
                        <el-input-number clearable  v-model="chamberOfCommerce.technicalInnovation.proportion"  :min="0"  :size="size"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-form>
            </div>
          </el-card>
        </el-form-item>
      </div>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="dataFormSubmits()">提交</el-button>
      <el-button @click="$router.go(-1)">返回</el-button>

    </span>
  </div>
</template>

<script>
  import {getAddress, queryAddressById,getCookie} from '@/utils'
  import formItem from '@/components/generator/formItem.vue'
  import API from '@/api'
  import {regularBinding} from '@/utils/validate'
  import linkage from '@/components/input/linkage.vue'
  export default {
    name: "update",
    data(){
      return {
        activeIndex: '1',
        chamberOfCommerce:{
          technicalInnovation:{},
          businessOrganization:{
            size:0
          },
          enterpriseProfile:{}
        },
        //商会信息验证
        chamberOfCommerceRule:{},
        //团体代表人列表
        corporateRepresentativeList:{},
        //团体代表人列表验证规则
        corporateRepresentativeListFrom:{
          name:[
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          sex:[
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          birthDate:[
            {required: true, message: '出生日期不能为空', trigger: 'blur'}
          ],
          organization:[
            {required: true, message: '所在组织不能为空', trigger: 'blur'}
          ]
        },
        enterpriseProfile:{},
        enterpriseProfileForm: {
          influence: [
            {required: true, message: '行业地位及影响不能为空', trigger: 'blur'}
          ],
          outstandingFeature:[
            {required: true, message: '企业突出特点不能为空', trigger: 'blur'}
          ],
          synopsis:[
            {required: true, message: '企业基本情况简介不能为空', trigger: 'blur'}
          ],
          majorProduct:[
            {required: true, message: '主要产品与服务不能为空', trigger: 'blur'}
          ],
          primaryService:[
            {required: true, message: '主营业务不能为空', trigger: 'blur'}
          ],
        },
        businessOrganizationForm: {
          linkman: [
            {required: true, message: '联系人不能为空', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '联系人职务不能为空', trigger: 'blur'}
          ],
          contactPhone:[
            {required: true, message: '联系人手机号不能为空', trigger: 'blur'}
          ]
        },
        theMainAffiliate:{},
        theMainAffiliateForm: {
          linkman: [
            {required: true, message: '联系人不能为空', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '联系人职务不能为空', trigger: 'blur'}
          ],
          contactPhone:[
            {required: true, message: '联系人手机号不能为空', trigger: 'blur'}
          ]
        },
        thePublicIs:{},
        thePublicIsForm: {
          linkman: [
            {required: true, message: '联系人不能为空', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '联系人职务不能为空', trigger: 'blur'}
          ],
          contactPhone:[
            {required: true, message: '联系人手机号不能为空', trigger: 'blur'}
          ]
        },
        taxCreditRating:{},
        taxCreditRatingForm: {
          linkman: [
            {required: true, message: '联系人不能为空', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '联系人职务不能为空', trigger: 'blur'}
          ],
          contactPhone:[
            {required: true, message: '联系人手机号不能为空', trigger: 'blur'}
          ]
        },
        technicalInnovation:{},
        technicalInnovationForm: {
          linkman: [
            {required: true, message: '联系人不能为空', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '联系人职务不能为空', trigger: 'blur'}
          ],
          contactPhone:[
            {required: true, message: '联系人手机号不能为空', trigger: 'blur'}
          ]
        },
        businessCircumstance:{},
        businessCircumstanceForm: {
          linkman: [
            {required: true, message: '联系人不能为空', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '联系人职务不能为空', trigger: 'blur'}
          ],
          contactPhone:[
            {required: true, message: '联系人手机号不能为空', trigger: 'blur'}
          ]
        },
        socialInsurance:{},
        socialInsuranceForm: {
          linkman: [
            {required: true, message: '联系人不能为空', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '联系人职务不能为空', trigger: 'blur'}
          ],
          contactPhone:[
            {required: true, message: '联系人手机号不能为空', trigger: 'blur'}
          ]
        },
        corporateContactList:{},
        corporateContactListForm: {
          linkman: [
            {required: true, message: '联系人不能为空', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '联系人职务不能为空', trigger: 'blur'}
          ],
          contactPhone:[
            {required: true, message: '联系人手机号不能为空', trigger: 'blur'}
          ]
        },
        coceralModule:'lp',
        coceralPathUrl:'lpchamberofcommerce',
        size: "medium",
        isUpdate: this.value,
        fieldMap: {

        },
      }
    },
    components:{
      formItem,
      linkage
    },
    watch:{

      isUpdate:function(val){
        this.$emit('input', val)
      },
      value:function(val){
        this.isUpdate=val;
      },

    },
    props:{
      value: {

      },
      pathUrl: {
        type: String
      },
      model: {
        type: String
      },
      tabData:{

      }
    },
    created(){
      var that =this;
      var chamberOfCommerce = this.tabData;
      for(var i in chamberOfCommerce.columns){
        var item = chamberOfCommerce.columns[i];
        that.fieldMap[item.fieldName]=item;
      }
    },
    mounted(){
      console.log(111);
    },
    methods:{
      handleSelect(key, keyPath) {
        this.activeIndex=key;
      },
      addOrUpdateHandle(row){
        var that = this;
        var chamberOfCommerceRule={}
        var chamberOfCommerce={
          corporateRepresentativeList:[],
          corporateContactList:[],
         // enterpriseProfile:[],
        //  businessOrganization:[],
          businessCircumstance:[],
          theMainAffiliate:[],
          socialInsurance:[],
          thePublicIs:[],
          taxCreditRating:[],
       //   technicalInnovation:[],
          technicalInnovation:{},
          businessOrganization:{
            size:0
          },
          enterpriseProfile:{}}
        chamberOfCommerce.id=row==undefined?0:row.id;
        regularBinding(chamberOfCommerceRule,that.fieldMap,chamberOfCommerce,function(){
          return that.chamberOfCommerce;
        });
        this.$nextTick(() => {
          this.$refs['chamberOfCommerceRule'].resetFields();
          that.chamberOfCommerce=chamberOfCommerce;
          that.chamberOfCommerceRule=chamberOfCommerceRule
          if (chamberOfCommerce.id) {
            API[that.pathUrl].info(chamberOfCommerce.id).then(({data}) => {
              if (data && data.code === 0) {
                data.data.enterpriseProfile=(data.data.enterpriseProfile!=undefined && data.data.enterpriseProfile!='')?JSON.parse(data.data.enterpriseProfile):[];
                data.data.businessOrganization=(data.data.businessOrganization!=undefined && data.data.businessOrganization!='')?JSON.parse(data.data.businessOrganization):{};
                data.data.theMainAffiliate=(data.data.theMainAffiliate!=undefined && data.data.theMainAffiliate!='')?JSON.parse(data.data.theMainAffiliate):[];
                data.data.socialInsurance=(data.data.socialInsurance!=undefined && data.data.socialInsurance!='')?JSON.parse(data.data.socialInsurance):[];
                data.data.administrativeRegion=(data.data.administrativeRegion!=undefined && data.data.administrativeRegion!='')?JSON.parse(data.data.administrativeRegion):[];
                data.data.thePublicIs=(data.data.thePublicIs!=undefined && data.data.thePublicIs!='')?JSON.parse(data.data.thePublicIs):[];
                data.data.taxCreditRating=(data.data.taxCreditRating!=undefined && data.data.taxCreditRating!='')?JSON.parse(data.data.taxCreditRating):[];
                data.data.technicalInnovation=(data.data.technicalInnovation!=undefined && data.data.technicalInnovation!='')?JSON.parse(data.data.technicalInnovation):{};
                data.data.businessCircumstance=(data.data.businessCircumstance!=undefined && data.data.businessCircumstance!='')?JSON.parse(data.data.businessCircumstance):[];
                data.data.corporateContactList=(data.data.corporateContactList!=undefined && data.data.corporateContactList!='')?JSON.parse(data.data.corporateContactList):[];
                data.data.corporateRepresentativeList=(data.data.corporateRepresentativeList!=undefined && data.data.corporateRepresentativeList!='')?JSON.parse(data.data.corporateRepresentativeList):[];
                this.chamberOfCommerce=data.data;
              }
            })
          }
        })
      },
      //添加企业代表人
      addcorporateRepresentativeList(){
        this.$refs['corporateRepresentativeListFrom'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.corporateRepresentativeList === undefined || this.chamberOfCommerce.corporateRepresentativeList==='') {
              this.chamberOfCommerce.corporateRepresentativeList = [];
            }
            this.chamberOfCommerce.corporateRepresentativeList.push(this.corporateRepresentativeList);
            this.corporateRepresentativeList = {};
          }
        });
      },
      //添加企业联系人
      addcorporateContactList(){
        this.$refs['corporateContactListForm'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.corporateContactList === undefined || this.chamberOfCommerce.corporateContactList==='') {
              this.chamberOfCommerce.corporateContactList = [];
            }
            this.chamberOfCommerce.corporateContactList.push(this.corporateContactList);
            this.corporateContactList = {};
          }})
      },
      //添加下属企业
      addtheMainAffiliate(){
        this.$refs['theMainAffiliateForm'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.theMainAffiliate === undefined || this.chamberOfCommerce.theMainAffiliate==='') {
              this.chamberOfCommerce.theMainAffiliate = [];
            }
            this.chamberOfCommerce.theMainAffiliate.push(this.theMainAffiliate);
            this.theMainAffiliate = {};
          }})
      },
      //添加企业经营情况(万元)
      addsocialInsurance(){
        this.$refs['socialInsuranceForm'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.socialInsurance === undefined || this.chamberOfCommerce.socialInsurance==='') {
              this.chamberOfCommerce.socialInsurance = [];
            }
            this.chamberOfCommerce.socialInsurance.push(this.socialInsurance);
            this.socialInsurance = {};
          }})
      },
      //添加企业经营情况(万元)
      addthePublicIs(){
        this.$refs['thePublicIsForm'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.thePublicIs === undefined || this.chamberOfCommerce.thePublicIs==='') {
              this.chamberOfCommerce.thePublicIs = [];
            }
            this.chamberOfCommerce.thePublicIs.push(this.thePublicIs);
            this.thePublicIs = {};
          }})
      },
      //添加纳税信用级别
      addtaxCreditRating(){
        this.$refs['taxCreditRatingForm'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.taxCreditRating === undefined || this.chamberOfCommerce.taxCreditRating==='') {
              this.chamberOfCommerce.taxCreditRating = [];
            }
            this.chamberOfCommerce.taxCreditRating.push(this.taxCreditRating);
            this.taxCreditRating = {};
          }})
      },
      //添加企业创新技术
      addtechnicalInnovation(){
        this.$refs['technicalInnovationForm'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.technicalInnovation === undefined || this.chamberOfCommerce.technicalInnovation==='') {
              this.chamberOfCommerce.technicalInnovation = [];
            }
            this.chamberOfCommerce.technicalInnovation.push(this.technicalInnovation);
            this.technicalInnovation = {};
          }})
      },
      //添加企业经营情况(万元)
      addbusinessCircumstance(){
        this.$refs['businessCircumstanceForm'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.businessCircumstance === undefined || this.chamberOfCommerce.businessCircumstance==='') {
              this.chamberOfCommerce.businessCircumstance = [];
            }
            this.chamberOfCommerce.businessCircumstance.push(this.businessCircumstance);
            this.businessCircumstance = {};
          }})
      },
      //添加企业联系人
      addgroupContactList(){
        this.$refs['groupContactListForm'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.groupContactList === undefined || this.chamberOfCommerce.groupContactList==='') {
              this.chamberOfCommerce.groupContactList = [];
            }
            this.chamberOfCommerce.groupContactList.push(this.groupContactList);
            this.groupContactList = {};
          }})
      },
      dataFormSubmits(dataForm){
        var that =this;
        that.chamberOfCommerce.personalHonor=that.personalHonor;
        that.$refs['chamberOfCommerceRule'].validate((valid) => {
          if (valid) {
            var params = {}
            that.chamberOfCommerce.userType="1"
            Object.assign(params,that.chamberOfCommerce);
            //console.log(that.chamberOfCommerce);
            var tick = !that.chamberOfCommerce.id ? API[that.pathUrl].add(params) : API[that.pathUrl].update(params)
            tick.then(({data}) => {
              if (data && data.code === 0) {
                that.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    if(that.chamberOfCommerce.id!=null){
                      that.$router.go(-1);
                    }else{
                      that.goToUrl('/registerSuc',1,data.data);
                    }
                  }
                })
              } else {
                that.$message.error(data.msg)
              }
            })
          }
        });
      }

    }

  }
</script>

<style scoped>
  #update >>> .el-form-item{
    justify-content: center;
    display: flex;
  }
  #update >>> .el-form-item__content{
    width: 189%;
  }
  #update >>> .el-card__header {
    padding: 3px 0 0 20px;
  }
  .clearfix{
    height:46px;
  }
  .box-card{
    margin-bottom:20px;
  }
  .demo-ruleForm .col{
    margin-bottom:20px;
  }
  .ry-item{
    margin-bottom:10px;
  }
#enter >>> .el-form-item__label{
    float: none;
    display: inline-block;
  width:200px;
}
</style>
