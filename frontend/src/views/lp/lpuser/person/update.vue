<template>
  <div v-if="isUpdate" id="update">
    <el-form :inline="true" :validate-on-rule-change="false":model="chamberOfCommerce" :rules="chamberOfCommerceRule" ref="chamberOfCommerceRule" @keyup.enter.native="dataFormSubmits()" class="demo-form-inline" label-position="right" label-width="120px">
      <el-row :gutter="24">
        <el-col class="col" :lg="8"  >
          <formItem v-model="chamberOfCommerce.userName" :dataRule="chamberOfCommerce" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.userName" :model="model" :isPage="true" :size="size"></formItem>
        </el-col>
        <el-col class="col" :lg="16">
          <formItem v-model="chamberOfCommerce.password" :dataRule="chamberOfCommerce" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.password"   :model="model" :isPage="true" :size="size"></formItem>
        </el-col>
      </el-row>
    <!--图片上传-->
      <el-row :gutter="24">
        <el-col :lg="4">
          <formItem v-model="chamberOfCommerce.headPortrait" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.headPortrait"   :model="model" :isPage="true" :size="size"></formItem>
          <div style="padding-top:30px;">
            (大小不超过1M,尺寸:605*1080)
          </div>
        </el-col>
        <el-col :lg="20">
          <!--归属商会-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.coceralId" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :model="coceralModule" :pathUrl="coceralPathUrl" :field="fieldMap.coceralId"    :isPage="true" :size="size"></formItem>
          </el-col>
          <!--人员分类-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.grade" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.grade"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--姓名-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.name" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.name"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--性别-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.sex" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.sex"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--出生日期-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.dateOfBirth" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.dateOfBirth"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--民族-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.ethnic" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.ethnic"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--证件类型-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.papersType" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.papersType"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--证件号码-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.papersNumber" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.papersNumber"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--籍贯-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.nativePlace" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.nativePlace"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--出生地-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.birthplace" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.birthplace"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--曾用名-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.formerName" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.formerName"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--政治面貌-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.politicsStatus" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.politicsStatus"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--学历-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.education" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.education"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--联系人手机号码-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.contactPhone" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.contactPhone"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--通讯地址-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.postalAddress" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.postalAddress"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--座机-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.specialPlane" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.specialPlane" :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--邮编-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.postcode" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.postcode"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--邮箱-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.eMail" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.eMail"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--qq-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.qq" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.qq"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--微信-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.wx" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.wx"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
          <!--入会时间-->
          <el-col class="col" :lg="12">
            <formItem v-model="chamberOfCommerce.initiationTime" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.initiationTime"   :model="model" :isPage="true" :size="size"></formItem>
          </el-col>
        </el-col>

      </el-row>
      <div>

        <!--企业职务--->
        <el-form-item   prop="enterprisePosition">
          <el-card class="box-card">
            <div slot="header" class="clearfix" >
              <span>企业职务</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="enterprisePosition" :rules="enterprisePositionForm" ref="enterprisePositionForm" @keyup.enter.native="addEnterprisePosition()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="name">
                      <el-input :size="size" v-model="enterprisePosition.name" placeholder="企业名称"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">企业名称</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="department">
                      <el-input :size="size" v-model="enterprisePosition.department" placeholder="部门"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">部门</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="duty">
                      <el-input :size="size" v-model="enterprisePosition.duty" placeholder="职务"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">职务</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addEnterprisePosition()">添加企业职务</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.enterprisePosition"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="name"
                  label="企业名称"  >
                </el-table-column>
                <el-table-column
                  prop="department"
                  label="部门"  >
                </el-table-column>
                <el-table-column
                  prop="duty"
                  label="职务"  >
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.enterprisePosition.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>
        <!--工商联职务--->
        <el-form-item   prop="fbcciJob">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>工商联职务</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="fbcciJob" :rules="fbcciJobForm" ref="fbcciJobForm" @keyup.enter.native="addFbcciJob()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="name">
                      <el-input :size="size" v-model="fbcciJob.name" placeholder="组织机构名称"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">组织机构名称</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <!--四级联动-->
                  <el-col class="col" :lg="8">
                  <el-form-item  prop="address" >
                    <linkage    :level="3" pageComment="全国工商联" v-model="fbcciJob.address"  :isPage="true" :size="size"> </linkage>
                  </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="period">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">届</label></div>
                        <el-input-number v-model="fbcciJob.period"  :size="size"  :min="1"   placeholder="届"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="duty">
                      <el-input :size="size" v-model="fbcciJob.duty" placeholder="职务"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">职务</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="isInService">
                      <el-switch :size="size" v-model="fbcciJob.isInService"
                                 active-text="是否在职"
                      >
                      </el-switch>
                    </el-form-item>

                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addFbcciJob()">添加工商联职务</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.fbcciJob"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="name"
                  label="组织机构名称"  >
                </el-table-column>
                <el-table-column
                  prop="address"
                  label="全国工商联"  >
                </el-table-column>
                <el-table-column
                  prop="period"
                  label="届"  >
                </el-table-column>
                <el-table-column
                  prop="duty"
                  label="职务"  >
                </el-table-column>
                <el-table-column
                  prop="isInService"
                  label="是否在职"  >
                  <template  slot-scope="scope">
                    <span v-text="scope.row.isInService?'是':'否'"></span>
                  </template>
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.fbcciJob.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>
        <!--人大职务--->
        <el-form-item   prop="npcJob">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>人大职务</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="npcJob" :rules="npcJobForm"  ref="npcJobForm" @keyup.enter.native="addNpcJob()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="code">
                        <el-input :size="size" v-model="npcJob.code" placeholder="行政区划代码"  >
                          <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">行政区划代码</label></template>
                        </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="name">
                      <el-input :size="size" v-model="npcJob.name" placeholder="行政区划名称"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">行政区划名称</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="period">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">届</label></div>
                        <el-input-number v-model="npcJob.period"  :size="size"  :min="1"   placeholder="届"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="duty">
                      <el-input :size="size" v-model="npcJob.duty" placeholder="职务"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">职务</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="isInService">

                      <el-switch :size="size" v-model="npcJob.isInService" placeholder="是否在职"
                                 active-text="是否在职"
                      >
                      </el-switch>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addNpcJob()">添加人大职务</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.npcJob"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="code"
                  label="行政区划分代码"  >
                </el-table-column>
                <el-table-column
                  prop="name"
                  label="行政区划分名称"  >
                </el-table-column>
                <el-table-column
                  prop="period"
                  label="届"  >
                </el-table-column>
                <el-table-column
                  prop="duty"
                  label="职务"  >
                </el-table-column>
                <el-table-column
                  prop="isInService"
                  label="是否在职"  >
                  <template  slot-scope="scope">
                    <span v-text="scope.row.isInService?'是':'否'"></span>
                  </template>
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.npcJob.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>
        <!--政府职务--->
        <el-form-item   prop="publicPositions">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>政府职务</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="publicPositions" :rules="publicPositionsFrom"  ref="publicPositionsFrom" @keyup.enter.native="addpublicPositions()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="code">

                      <el-input :size="size"  v-model="publicPositions.code" placeholder="行政区划代码"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">行政区划代码</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="name">
                      <el-input :size="size" v-model="publicPositions.name" placeholder="行政区划名称"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">行政区划名称</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="period">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">届</label></div>
                        <el-input-number v-model="publicPositions.period"  :size="size"  :min="1"   placeholder="届"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="duty">
                      <el-input :size="size" v-model="publicPositions.duty" placeholder="职务"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">职务</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="isInService">
                      <el-switch :size="size"
                                 v-model="publicPositions.isInService"
                        active-text="是否在职"
                      >
                      </el-switch>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addpublicPositions()">添加政府职务</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.publicPositions"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="code"
                  label="行政区划分代码"  >
                </el-table-column>
                <el-table-column
                  prop="name"
                  label="行政区划分名称"  >
                </el-table-column>
                <el-table-column
                  prop="period"
                  label="届"  >
                </el-table-column>
                <el-table-column
                  prop="duty"
                  label="职务"  >
                </el-table-column>
                <el-table-column
                  prop="isInService"
                  label="是否在职"  >
                  <template  slot-scope="scope">
                    <span v-text="scope.row.isInService?'是':'否'"></span>
                  </template>
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.publicPositions.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>
        <!--政协职务-->
        <el-form-item   prop="functionsOfcppcc">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>政协职务</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="functionsOfcppcc" :rules="functionsOfcppccFrom"  ref="functionsOfcppccFrom" @keyup.enter.native="addfunctionsOfcppcc()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="code">
                      <el-input :size="size" v-model="functionsOfcppcc.code" placeholder="行政区划代码"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">行政区划代码</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="name">
                      <el-input :size="size" v-model="functionsOfcppcc.name" placeholder="行政区划名称"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">行政区划名称</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="period">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">届</label></div>
                        <el-input-number v-model="functionsOfcppcc.period"  :size="size"  :min="1"   placeholder="届"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="duty">
                      <el-input :size="size" v-model="functionsOfcppcc.duty" placeholder="职务"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">职务</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="isInService">
                      <el-switch :size="size"
                                 v-model="functionsOfcppcc.isInService"
                                 active-text="是否在职"
                      >
                      </el-switch>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addfunctionsOfcppcc()">添加政协职务</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.functionsOfcppcc"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="code"
                  label="行政区划分代码"  >
                </el-table-column>
                <el-table-column
                  prop="name"
                  label="行政区划分名称"  >
                </el-table-column>
                <el-table-column
                  prop="period"
                  label="届"  >
                </el-table-column>
                <el-table-column
                  prop="duty"
                  label="职务"  >
                </el-table-column>
                <el-table-column
                  prop="isInService"
                  label="是否在职"  >
                  <template  slot-scope="scope">
                    <span v-text="scope.row.isInService?'是':'否'"></span>
                  </template>
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.functionsOfcppcc.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>
        <!--其他职务-->
        <el-form-item   prop="otherDuties">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>其他职务</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="otherDuties" :rules="otherDutiesFrom"  ref="otherDutiesFrom" @keyup.enter.native="addotherDuties()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="code">
                      <el-input :size="size"v-model="otherDuties.code" placeholder="行政区划代码"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">行政区划代码</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="name">
                      <el-input :size="size" v-model="otherDuties.name" placeholder="行政区划名称"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">行政区划名称</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="period">
                      <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                        <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">届</label></div>
                        <el-input-number v-model="otherDuties.period"  :size="size"  :min="1"   placeholder="届"> </el-input-number>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="duty">
                      <el-input :size="size" v-model="otherDuties.duty" placeholder="职务"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">职务</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="isInService">
                        <el-switch
                          v-model="otherDuties.isInService"
                          active-text="是否在职"
                        >
                        </el-switch>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addotherDuties()">添加政协职务</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.otherDuties"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="code"
                  label="行政区划分代码"  >
                </el-table-column>
                <el-table-column
                  prop="name"
                  label="行政区划分名称"  >
                </el-table-column>
                <el-table-column
                  prop="period"
                  label="届"  >
                </el-table-column>
                <el-table-column
                  prop="duty"
                  label="职务"  >
                </el-table-column>
                <el-table-column
                  prop="isInService"
                  label="是否在职"  >
                  <template  slot-scope="scope">
                    <span v-text="scope.row.isInService?'是':'否'"></span>
                  </template>
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.otherDuties.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>
        <!--个人荣誉-->
        <el-form-item   prop="personalHonor">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>个人荣誉</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="chamberOfCommerce.personalHonor" :rules="personalHonorFrom"  ref="personalHonorFrom" >
                <el-row    :gutter="40">
                  <el-col :lg="12"  v-for="(item,indexs) in chamberOfCommerce.personalHonor.list"  :key="indexs"    >
                    <el-card class="box-card">
                      <div slot="header" class="clearfix" style="text-align: center">
                        <span v-text="item.name"></span>
                      </div>
                      <div class="text item">
                        <el-row class="ry-item" v-for="(obj,objIndex) in item.list" :key="objIndex">
                            <el-col :lg="23">
                              <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                                <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;" v-text="obj.name+':'"></label></div>
                                <el-date-picker  :size="size" v-model="obj.date" type="date" style="width:100%;" value-format="yyyy-MM-dd"  placeholder="全国年份" format="yyyy-MM-dd">
                                  <template slot="prepend">
                                    <label  class="el-form-item__label" style="padding: 0;line-height: initial;" v-text="obj.name">全国年份</label>
                                  </template> </el-date-picker>
                              </div>
                          </el-col>
                        </el-row>
                      </div>
                    </el-card>

                  </el-col>
                  <el-col :lg="12"   >
                    <el-card class="box-card">
                      <div slot="header" class="clearfix" style="text-align: center">
                        <span >其他</span>
                      </div>
                      <div class="text item">
                        <el-input :size="size" :autosize="{ minRows: 9, maxRows: 4}" v-model="chamberOfCommerce.personalHonor.retas" type="textarea" resize="none" :rows="2" placeholder="其他">
                        </el-input>
                      </div>
                    </el-card>
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
      <el-button @click="isUpdate=false">返回</el-button>
    </span>
  </div>
</template>

<script>
  import API from '@/api'
  import {getAddress, queryAddressById,getCookie} from '@/utils'
  import formItem from '@/components/generator/formItem.vue'
  import {regularBinding} from '@/utils/validate'
  import linkage from '@/components/input/linkage.vue'
  export default {
    name: "update",
    components: {
      formItem,
      linkage
    },
    data(){
      return {
        personalHonorFrom:{},
        //后台信息验证
        userRule:{},
        //商会信息验证
        chamberOfCommerceRule:{},
        //其他职务
        otherDuties:{isInService:false,period:0},
        //其他职务验证规则
        otherDutiesFrom:{
          name:[
            { required: true, message: '行政区域名称不能为空', trigger: 'blur' }
          ],
          code:[
            { required: true, message: '行政划分代码不能为空', trigger: 'blur' }
          ],
          isInService: [
            {required: true, message: '是否在职', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '职能不能为空', trigger: 'blur'}
          ],
          period:[
            {required: true, message: '届不能为空', trigger: 'blur'}
          ]
        },
        //政协职务
        functionsOfcppcc:{isInService:false,period:0},
        //政协验证规则
        functionsOfcppccFrom:{
          name:[
            { required: true, message: '行政区域名称不能为空', trigger: 'blur' }
          ],
          code:[
            { required: true, message: '行政划分代码不能为空', trigger: 'blur' }
          ],
          isInService: [
            {required: true, message: '是否在职', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '职能不能为空', trigger: 'blur'}
          ],
          period:[
            {required: true, message: '届不能为空', trigger: 'blur'}
          ]
        },
        //政府职务
        publicPositions:{isInService:false,period:0},
        //政府验证规则
        publicPositionsFrom:{
          name:[
            { required: true, message: '行政区域名称不能为空', trigger: 'blur' }
          ],
          code:[
            { required: true, message: '行政划分代码不能为空', trigger: 'blur' }
          ],
          isInService: [
            {required: true, message: '是否在职', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '职能不能为空', trigger: 'blur'}
          ],
          period:[
            {required: true, message: '届不能为空', trigger: 'blur'}
          ]
        },
        //会长信息
        npcJob:{isInService:false,period:0},
        npcJobForm:{
          name:[
            { required: true, message: '行政区域名称不能为空', trigger: 'blur' }
          ],
          code:[
            { required: true, message: '行政划分代码不能为空', trigger: 'blur' }
          ],
          isInService: [
            {required: true, message: '是否在职', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '职能不能为空', trigger: 'blur'}
          ],
          period:[
            {required: true, message: '届不能为空', trigger: 'blur'}
          ]
        },
        //会长规则校验
        secretary:{},
        chairman:{},
        fbcciJob:{isInService:false,period:0},
        fbcciJobForm: {
          name: [
            {required: true, message: '企业名称不能为空', trigger: 'blur'}
          ],
          isInService: [
            {required: true, message: '是否在职', trigger: 'blur'}
          ],
          address: [
            {required: true, message: '全国工商联', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '职能不能为空', trigger: 'blur'}
          ],
          period:[
            {required: true, message: '届不能为空', trigger: 'blur'}
          ]
        },
        enterprisePosition:{},
        enterprisePositionForm: {
          name: [
            {required: true, message: '企业名称不能为空', trigger: 'blur'}
          ],
          department: [
            {required: true, message: '部门不能为空', trigger: 'blur'}
          ],
          duty:[
            {required: true, message: '职能不能为空', trigger: 'blur'}
          ],
        },
        coceralModule:'lp',
        coceralPathUrl:'lpchamberofcommerce',
        size: "medium",
        isUpdate: this.value,
        chamberOfCommerce:{
          enterprisePosition:[],
          personalHonor: {
            retas: "",
            list: []
          }
        },
        fieldMap: {

        },
      }
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
        type:Boolean,
        default:false
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
        var  fieldMap={}
        for(var i in chamberOfCommerce.columns){
          var item = chamberOfCommerce.columns[i];
          fieldMap[item.fieldName]=item;
        }
        that.fieldMap=fieldMap;
    },
    methods:{
      addOrUpdateHandle(row){
        var that = this;
        var chamberOfCommerceRule={}
        var chamberOfCommerce={
          fbcciJob:[],
          npcJob:[],
          publicPositions:[],
          functionsOfcppcc:[],
          otherDuties:[],
          enterprisePosition:[],
          personalHonor:{
            retas:"",
            list:[
              {name:"劳动模范",list:[
                  {name:"全国年份",chebox:false,date:""},
                  {name:"省年份",chebox:false,date:""},
                  {name:"市年份",chebox:false,date:""},
                  {name:"县年份",chebox:false,date:""},
                ]},
              {name:"五一奖章",list:[
                  {name:"全国年份",chebox:false,date:""},
                  {name:"省年份",chebox:false,date:""},
                  {name:"市年份",chebox:false,date:""},
                  {name:"县年份",chebox:false,date:""},
                ]},
              {name:"三八红旗手",list:[
                  {name:"全国年份",chebox:false,date:""},
                  {name:"省年份",chebox:false,date:""},
                  {name:"市年份",chebox:false,date:""},
                  {name:"县年份",chebox:false,date:""},
                ]},
              {name:"五四奖章",list:[
                  {name:"全国年份",chebox:false,date:""},
                  {name:"省年份",chebox:false,date:""},
                  {name:"市年份",chebox:false,date:""},
                  {name:"县年份",chebox:false,date:""},
                ]},
              {name:"优秀社会主义建设者",list:[
                  {name:"全国年份",chebox:false,date:""},
                  {name:"省年份",chebox:false,date:""},
                  {name:"市年份",chebox:false,date:""},
                  {name:"县年份",chebox:false,date:""},
                ]},
              {name:"光彩事业奖章",list:[
                  {name:"全国年份",chebox:false,date:""},
                  {name:"省年份",chebox:false,date:""},
                  {name:"市年份",chebox:false,date:""},
                  {name:"县年份",chebox:false,date:""},
                ]},
              {name:"光彩事业国土绿化贡献奖",list:[
                  {name:"全国年份",chebox:false,date:""},
                  {name:"省年份",chebox:false,date:""},
                  {name:"市年份",chebox:false,date:""},
                  {name:"县年份",chebox:false,date:""},
                ]},
            ]
          },}
         chamberOfCommerce.id=row==undefined?0:row.id;
        regularBinding(chamberOfCommerceRule,that.fieldMap,chamberOfCommerce,function(){
          return that.chamberOfCommerce;
        });
        this.$nextTick(() => {
          this.$refs['chamberOfCommerceRule'].resetFields();
          this.chamberOfCommerce=chamberOfCommerce;
         this.chamberOfCommerceRule=chamberOfCommerceRule;
          if (chamberOfCommerce.id) {
            API[that.pathUrl].info(chamberOfCommerce.id).then(({data}) => {
              if (data && data.code === 0) {
                data.data.enterprisePosition=(data.data.enterprisePosition!='' && data.data.enterprisePosition!=undefined)?JSON.parse(data.data.enterprisePosition):[];
                data.data.nativePlace=(data.data.nativePlace!='' && data.data.nativePlace!=undefined)?JSON.parse(data.data.nativePlace):[];
                data.data.fbcciJob=(data.data.fbcciJob!='' && data.data.fbcciJob!=undefined)?JSON.parse(data.data.fbcciJob):[];
                data.data.npcJob=(data.data.npcJob!='' && data.data.npcJob!=undefined)?JSON.parse(data.data.npcJob):[];
                data.data.publicPositions=(data.data.publicPositions!='' && data.data.publicPositions!=undefined)?JSON.parse(data.data.publicPositions):[];
                data.data.otherDuties=(data.data.otherDuties!='' && data.data.otherDuties!=undefined)?JSON.parse(data.data.otherDuties):[];
                data.data.functionsOfcppcc=(data.data.functionsOfcppcc!='' && data.data.functionsOfcppcc!=undefined)?JSON.parse(data.data.functionsOfcppcc):[];
                data.data.groupAdministrativeRegion=(data.data.groupAdministrativeRegion!='' && data.data.groupAdministrativeRegion!=undefined)?JSON.parse(data.data.groupAdministrativeRegion):[];
                data.data.personalHonor=(data.data.personalHonor!='' && data.data.personalHonor!=undefined)?JSON.parse(data.data.personalHonor):{};
                this.chamberOfCommerce=data.data;
              }
            })
          }
        })
      },
      //添加人大职务
      addNpcJob(){
        if(this.chamberOfCommerce.npcJob===undefined  || this.chamberOfCommerce.npcJob===''){
          this.chamberOfCommerce.npcJob=[];
        }
        this.chamberOfCommerce.npcJob.push(this.npcJob);
        this.npcJob={};
      },
      //添加政府职务
      addpublicPositions(){
        this.$refs['publicPositionsFrom'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.publicPositions === undefined || this.chamberOfCommerce.publicPositions==='') {
              this.chamberOfCommerce.publicPositions = [];
            }
            this.chamberOfCommerce.publicPositions.push(this.publicPositions);
            this.publicPositions = {isInService:false,period:0}
          }
        });
      },
      //添加政协职务
      addfunctionsOfcppcc(){
        this.$refs['functionsOfcppccFrom'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.functionsOfcppcc === undefined || this.chamberOfCommerce.functionsOfcppcc==='') {
              this.chamberOfCommerce.functionsOfcppcc = [];
            }
            this.chamberOfCommerce.functionsOfcppcc.push(this.functionsOfcppcc);
            this.functionsOfcppcc = {isInService:false,period:0};
          }
        });
      },
      //添加其他职务
      addotherDuties(){
        this.$refs['otherDutiesFrom'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.otherDuties === undefined || this.chamberOfCommerce.otherDuties==='') {
              this.chamberOfCommerce.otherDuties = [];
            }
            this.chamberOfCommerce.otherDuties.push(this.otherDuties);
            this.otherDuties = {isInService:false,period:0};
          }
        });
      },
      //添加委员
      addFbcciJob(){
        this.$refs['fbcciJobForm'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.fbcciJob === undefined || this.chamberOfCommerce.fbcciJob==='') {
              this.chamberOfCommerce.fbcciJob = [];
            }
            this.chamberOfCommerce.fbcciJob.push(this.fbcciJob);
            this.fbcciJob = {isInService:false,period:0,address:[]};
          }
        });
      },
      //添加部门
      addEnterprisePosition(){
        this.$refs['enterprisePositionForm'].validate((valid) => {
          if (valid) {
            //console.log(this.chamberOfCommerce.enterprisePosition);
            if (this.chamberOfCommerce.enterprisePosition === undefined || this.chamberOfCommerce.enterprisePosition==='') {
              this.chamberOfCommerce.enterprisePosition = [];
            }
            this.chamberOfCommerce.enterprisePosition.push(this.enterprisePosition);
            this.enterprisePosition = {};
          }})
      },
      dataFormSubmits(dataForm){
        var that =this;
       // that.chamberOfCommerce.personalHonor=that.personalHonor;
          that.$refs['chamberOfCommerceRule'].validate((valid) => {
            if (valid) {
              var params = {}
              that.chamberOfCommerce.userType="0"
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
                      that.isUpdate = false;
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

</style>
