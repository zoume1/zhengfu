<template>
<div v-if="isUpdate" id="update" class="table-container pull-chheight">
    <basic-container>
  <el-form :inline="true" :validate-on-rule-change="false" :model="user" :rules="userRule" ref="userRule" @keyup.enter.native="dataFormSubmits()" class="demo-form-inline" label-position="right" label-width="120px">
    <el-row :gutter="24">
      <el-col class="col" :lg="8"  >
        <formItem v-model="user.username" :dataRule="userRule" :dataForm="user" :pathUrl="userPathUrl" :field="fieldMap.user.username" :model="userModule" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="16">
        <formItem v-model="user.password" :dataRule="userRule" :dataForm="user" :pathUrl="userPathUrl" :field="fieldMap.user.password"   :model="userModule" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="user.grade" :dataRule="userRule" :dataForm="user" :pathUrl="userPathUrl" :field="fieldMap.user.grade"  :model="userModule" :isPage="true" :size="size"></formItem>
      </el-col>
    </el-row>
  </el-form>
  <el-form :inline="true" :validate-on-rule-change="false" :model="chamberOfCommerce" :rules="chamberOfCommerceRule" ref="chamberOfCommerceRule" @keyup.enter.native="dataFormSubmits()" class="demo-form-inline" label-position="right" label-width="120px">
    <!--图片上传-->
    <el-row :gutter="24">
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.name" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.name" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.category" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.category" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.standingDirectorSize" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.standingDirectorSize" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.directorSize" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.directorSize" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.memberSize" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.memberSize" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.viceChairmanSize" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.viceChairmanSize" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.secretarySize" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.secretarySize" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.creditCode" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.creditCode" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.specialPlane" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.specialPlane" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
       <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.groupFox" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.groupFox" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.eMail" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.eMail" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <!--<el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.postcode" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.postcode" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>-->
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.groupAdministrativeRegion" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.groupAdministrativeRegion" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
      <formItem v-model="chamberOfCommerce.legalPerson" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.legalPerson" :model="model" :isPage="true" :size="size"></formItem>
    </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.phone" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.phone" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.chairmanName" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.chairmanName" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.presidentName" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.presidentName" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.secretaryGeneralName" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.secretaryGeneralName" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.contact" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.contact" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.establishedTime" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.establishedTime" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.personalCall" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.personalCall" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.address" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.address" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.postcode" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.postcode" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
      <el-col class="col" :lg="8">
        <formItem v-model="chamberOfCommerce.website" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.website" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
    </el-row>
    <el-row>
      <el-col class="col" :lg="24">
        <formItem v-model="chamberOfCommerce.introduce" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.introduce" :model="model" :isPage="true" :size="size"></formItem>
      </el-col>
    </el-row>
    <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
            <formItem v-model="chamberOfCommerce.civilAffairs" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.civilAffairs" :model="model" :isPage="false" :size="size"></formItem>
      </div>
      <div  class="text item">
        <formItem v-model="chamberOfCommerce.civilRegistrationCause" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.civilRegistrationCause" :model="model" :isPage="false" :size="size"></formItem>
      </div>
    </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <formItem v-model="chamberOfCommerce.partyOrganization" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.partyOrganization" :model="model" :isPage="false" :size="size"></formItem>
        </div>
        <div  class="text item">
          <formItem v-model="chamberOfCommerce.partyOrganizationCause" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.chamberOfCommerce.partyOrganizationCause" :model="model" :isPage="false" :size="size"></formItem>
        </div>
      </el-card>
      <el-form-item   prop="secretariats">
    <el-card class="box-card">
      <div slot="header" class="clearfix" >
        <span>秘书处内设部门</span>
      </div>
      <div class="text item">
        <el-form  class="demo-ruleForm" :model="secretariats" :rules="secretariatsForm" ref="secretariatsForm" @keyup.enter.native="addSecretariats()">
          <!--普通文本框-->
            <el-row :gutter="24">
              <el-col class="col" :lg="8">
                <el-form-item   prop="name">
                <el-input :size="size" v-model="secretariats.name" placeholder="部门名称"  >
                  <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">部门名称</label></template>
                </el-input>
                </el-form-item>
              </el-col>
              <el-col class="col" :lg="8">
                <el-button type="success" @click="addSecretariats()">添加部门</el-button>
              </el-col>
            </el-row>
        </el-form>
        <el-table
          :data="chamberOfCommerce.secretariats"
          height="250"
          border
          style="width: 100%">
          <el-table-column
            prop="name"
            label="部门名称"  >
          </el-table-column>
          <el-table-column
            fixed="right"
            header-align="center"
            align="center"
            width="300"
            label="操作">
            <template slot-scope="scope">
              <el-button  :size="size"  @click="chamberOfCommerce.secretariats.splice(scope.$index,1)">删除</el-button>
            </template>
          </el-table-column>
               </el-table>
      </div>
    </el-card>
      </el-form-item>
      <el-form-item   prop="specialCommittees">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>专委会</span>
      </div>
      <div class="text item">
        <el-form  class="demo-ruleForm" :model="specialCommittees" :rules="specialCommitteesForm" ref="specialCommitteesForm" @keyup.enter.native="addCommitteeMember()">
          <!--普通文本框-->
            <el-row :gutter="24">
              <el-col class="col" :lg="8">
                <el-form-item  prop="name" >
                <el-input :size="size" v-model="specialCommittees.name" placeholder="委员名称"  >
                  <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">委员名称</label></template>
                </el-input>
                </el-form-item>
              </el-col>
              <el-col class="col" :lg="8">
                <el-button type="success" @click="addCommitteeMember()">添加委员</el-button>
              </el-col>
            </el-row>
        </el-form>
        <el-table
          :data="chamberOfCommerce.specialCommittees"
          height="250"
          border
          style="width: 100%">
          <el-table-column
            prop="name"
            label="委员名称"  >
          </el-table-column>
          <el-table-column
            fixed="right"
            header-align="center"
            align="center"
            width="300"
            label="操作">
            <template slot-scope="scope">
              <el-button  :size="size"  @click="chamberOfCommerce.specialCommittees.splice(scope.$index,1)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-card>
      </el-form-item>
      <el-form-item   prop="chairmansInfo">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>历任会长信息</span>
      </div>
      <div class="text item">
        <el-form  class="demo-ruleForm" :model="chairmansInfo" :rules="chairmansInfoForm"  ref="chairmansInfoForm" @keyup.enter.native="addChairmansInfo()">
          <!--普通文本框-->
          <el-row :gutter="24">
            <el-col class="col" :lg="8">
              <el-form-item   prop="name">
                <el-input :size="size" v-model="chairmansInfo.name" placeholder="会长姓名"  >
                  <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">会长姓名</label></template>
                </el-input>
              </el-form-item>
            </el-col>
            <el-col class="col" :lg="8">
              <el-form-item   prop="startTime">
                <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                  <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">起始时间</label></div>
                  <el-date-picker v-model="chairmansInfo.startTime" :size="size"  type="date" style="width:100%;" value-format="yyyy-MM-dd"  placeholder="起始时间" format="yyyy-MM-dd">
                    <template slot="prepend"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">开始时间</label></template>
                  </el-date-picker>
                </div>
              </el-form-item>
            </el-col>
            <el-col class="col" :lg="8">
              <el-form-item   prop="endTime">
                <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                  <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">结束时间</label></div>
                  <el-date-picker v-model="chairmansInfo.endTime" :size="size"  type="date" style="width:100%;" value-format="yyyy-MM-dd"  placeholder="结束时间" format="yyyy-MM-dd">
                    <template slot="prepend"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">结束时间</label></template>
                  </el-date-picker>
                </div>
              </el-form-item>
            </el-col>
            <el-col class="col" :lg="8">
              <el-form-item   prop="unit">
                <el-input :size="size" v-model="chairmansInfo.unit" placeholder="单位"  >
                  <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">单位</label></template>
                </el-input>
              </el-form-item>
            </el-col>
            <el-col class="col" :lg="8">
              <el-form-item   prop="duty">
                <el-input :size="size" v-model="chairmansInfo.duty" placeholder="职务"  >
                  <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">职务</label></template>
                </el-input>
              </el-form-item>
            </el-col>
            <el-col class="col" :lg="8">
              <el-button type="success" @click="addChairmansInfo()">添加会长</el-button>
            </el-col>
          </el-row>
        </el-form>
        <el-table
          :data="chamberOfCommerce.chairmansInfo"
          height="250"
          border
          style="width: 100%">
          <el-table-column
            prop="name"
            label="会长姓名"  >
          </el-table-column>
          <el-table-column
            prop="startTime"
            label="创建时间"  >
          </el-table-column>
          <el-table-column
            prop="endTime"
            label="结束时间"  >
          </el-table-column>
          <el-table-column
            prop="unit"
            label="单位"  >
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
              <el-button  :size="size"  @click="chamberOfCommerce.chairmansInfo.splice(scope.$index,1)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-card>
      </el-form-item>
      <el-form-item   prop="secretarygeneralsInfo">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>历任秘书长信息</span>
      </div>
      <div class="text item">
        <el-form  class="demo-ruleForm" :model="secretarygeneralsInfo" :rules="secretarygeneralsInfoFrom"  ref="secretarygeneralsInfoFrom" @keyup.enter.native="addSecretarygeneralsInfo()">
          <!--普通文本框-->
            <el-row :gutter="24">
              <el-col class="col" :lg="8">
                <el-form-item   prop="name">
                <el-input :size="size" v-model="secretarygeneralsInfo.name" placeholder="秘书长姓名"  >
                  <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">秘书长姓名</label></template>
                </el-input>
                </el-form-item>
              </el-col>
              <el-col class="col" :lg="8">
                <el-form-item   prop="startTime">
                <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                  <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">起始时间</label></div>
                  <el-date-picker v-model="secretarygeneralsInfo.startTime" :size="size"  type="date" style="width:100%;" value-format="yyyy-MM-dd"  placeholder="起始时间" format="yyyy-MM-dd">
                    <template slot="prepend"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">开始时间</label></template>
                  </el-date-picker>
                </div>
                </el-form-item>
              </el-col>
              <el-col class="col" :lg="8">
                <el-form-item   prop="endTime">
                <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                  <div class="el-input-group__prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">结束时间</label></div>
                  <el-date-picker v-model="secretarygeneralsInfo.endTime" :size="size"  type="date" style="width:100%;" value-format="yyyy-MM-dd"  placeholder="结束时间" format="yyyy-MM-dd">
                    <template slot="prepend"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">结束时间</label></template>
                  </el-date-picker>
                </div>
                </el-form-item>
              </el-col>
              <el-col class="col" :lg="8">
                <el-form-item   prop="unit">
                <el-input :size="size" v-model="secretarygeneralsInfo.unit" placeholder="单位"  >
                  <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">单位</label></template>
                </el-input>
                </el-form-item>
              </el-col>
              <el-col class="col" :lg="8">
                <el-form-item   prop="duty">
                <el-input :size="size" v-model="secretarygeneralsInfo.duty" placeholder="职务"  >
                  <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">职务</label></template>
                </el-input>
                </el-form-item>
              </el-col>
              <el-col class="col" :lg="8">
                <el-button type="success" @click="addSecretarygeneralsInfo()">添加秘书长</el-button>
              </el-col>
            </el-row>
        </el-form>
        <el-table
          :data="chamberOfCommerce.secretarygeneralsInfo"
          height="250"
          border
          style="width: 100%">
          <el-table-column
            prop="name"
            label="秘书长姓名"  >
          </el-table-column>
          <el-table-column
            prop="startTime"
            label="创建时间"  >
          </el-table-column>
          <el-table-column
            prop="endTime"
            label="结束时间"  >
          </el-table-column>
          <el-table-column
            prop="unit"
            label="单位"  >
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
              <el-button  :size="size"  @click="chamberOfCommerce.secretarygeneralsInfo.splice(scope.$index,1)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-card>
      </el-form-item>
      <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="dataFormSubmits()">保存提交商会信息</el-button>
      <el-button @click="isUpdate=false">返回</el-button>
    </span>
    </div>
  </el-form>

    </basic-container>
</div>
</template>

<script>
  import {getAddress, queryAddressById,getCookie} from '@/utils'
  import formItem from '@/components/generator/formItem.vue'
  import API from '@/api'
  import {regularBinding} from '@/utils/validate'
  export default {
        name: "update",
      data(){
        return {
          //后台信息验证
          userRule:{},
          //商会信息验证
          chamberOfCommerceRule:{},
          //秘书长信息
          secretarygeneralsInfo:{},
          //秘书长验证规则
          secretarygeneralsInfoFrom:{
            name:[
              { required: true, message: '秘书长姓名不能为空', trigger: 'blur' }
            ],
            startTime:[
              { required: true, message: '创建时间不能为空', trigger: 'blur' }
            ],
            endTime:[
              { required: true, message: '结束时间不能为空', trigger: 'blur' }
            ],
            unit:[
              { required: true, message: '单位不能为空', trigger: 'blur' }
            ],
            duty:[
              { required: true, message: '职务不能为空', trigger: 'blur' }
            ]
          },
          //会长信息
          chairmansInfo:{},
          chairmansInfoForm:{
            name:[
              { required: true, message: '会长姓名不能为空', trigger: 'blur' }
            ],
            startTime:[
              { required: true, message: '创建时间不能为空', trigger: 'blur' }
            ],
            endTime:[
              { required: true, message: '结束时间不能为空', trigger: 'blur' }
            ],
            unit:[
              { required: true, message: '单位不能为空', trigger: 'blur' }
            ],
            duty:[
              { required: true, message: '职务不能为空', trigger: 'blur' }
            ]
          },
          //会长规则校验
          secretary:{},
          chairman:{},
          specialCommittees:{},
          specialCommitteesForm: {
            name: [
              {required: true, message: '委员姓名不能为空', trigger: 'blur'}
            ],
          },
          secretariats:{},
          secretariatsForm: {
            name: [
              {required: true, message: '部门名称不能为空', trigger: 'blur'}
            ],
          },
          userModule:'sys',
          userPathUrl:'sysuser',
          size: "medium",
          formInline: {},
          isUpdate: this.value,
          dataForm: {},
          user: {},
          chamberOfCommerce:{},
          dataRule: {},
          fieldMap: {
            user:{},
            chamberOfCommerce:{}
          },
        }
      },
      components:{
        formItem
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
          value: [Boolean,String, Number],
          pathUrl: {
            type: String
          },
          model: {
            type: String
          },

      },
      created(){
          var that =this;
          API.common.jqueryRequest('/'+this.model+'/'+this.pathUrl+'/selectTableConfig',"get",{type:1},function(data) {
            var user = data.data.user;
            var chamberOfCommerce = data.data.chamberOfCommerce;
            for(var i in user.columns){
              var item = user.columns[i];
              that.fieldMap.user[item.fieldName]=item;
            }
            for(var i in chamberOfCommerce.columns){
              var item = chamberOfCommerce.columns[i];
              that.fieldMap.chamberOfCommerce[item.fieldName]=item;
            }
          },false,false);

      },
      methods:{
        addOrUpdateHandle(row){
          var that = this;
          var chamberOfCommerce={id:row==undefined?0:row.id};
          var user ={};
          var chamberOfCommerceRule={
            civilAffairs:false,
            partyOrganization:false
          };
          var userRule={};
          regularBinding(userRule,that.fieldMap.user,user,function(){
            return that.user;
          });
          regularBinding(chamberOfCommerceRule,that.fieldMap.chamberOfCommerce,chamberOfCommerce,function(){
            return that.chamberOfCommerce;
          });

          this.$nextTick(() => {
            that.userRule=userRule;
            that.chamberOfCommerceRule=chamberOfCommerceRule;
            that.$refs['chamberOfCommerceRule'].resetFields();
            that.$refs['userRule'].resetFields();
            this.chamberOfCommerce=chamberOfCommerce;
            this.user=user;
            ////console.log(user,chamberOfCommerce);
            if (chamberOfCommerce.id) {
              API[that.pathUrl].info(chamberOfCommerce.id).then(({data}) => {
                if (data && data.code === 0) {
                  this.user=data.data.user;
                  data.data.chamberOfCommerce.secretariats=(data.data.chamberOfCommerce.secretariats!=undefined&& data.data.chamberOfCommerce.secretariats!='')?JSON.parse(data.data.chamberOfCommerce.secretariats):[];
                  data.data.chamberOfCommerce.specialCommittees=(data.data.chamberOfCommerce.specialCommittees!=undefined&& data.data.chamberOfCommerce.specialCommittees!='')?JSON.parse(data.data.chamberOfCommerce.specialCommittees):[];
                  data.data.chamberOfCommerce.chairmansInfo=(data.data.chamberOfCommerce.chairmansInfo!=undefined&& data.data.chamberOfCommerce.chairmansInfo!='')?JSON.parse(data.data.chamberOfCommerce.chairmansInfo):[];
                  data.data.chamberOfCommerce.secretarygeneralsInfo=(data.data.chamberOfCommerce.secretarygeneralsInfo!=undefined&& data.data.chamberOfCommerce.secretarygeneralsInfo!='')?JSON.parse(data.data.chamberOfCommerce.secretarygeneralsInfo):[];
                  data.data.chamberOfCommerce.groupAdministrativeRegion=(data.data.chamberOfCommerce.groupAdministrativeRegion!=undefined&& data.data.chamberOfCommerce.groupAdministrativeRegion!='')?JSON.parse(data.data.chamberOfCommerce.groupAdministrativeRegion):[];
                  this.chamberOfCommerce=data.data.chamberOfCommerce;
                }
              })
            }
          })
          },
       //添加会长信息
        addChairmansInfo(){
          if(this.chamberOfCommerce.chairmansInfo===undefined || this.chamberOfCommerce.chairmansInfo===''){
            this.chamberOfCommerce.chairmansInfo=[];
          }
          this.chamberOfCommerce.chairmansInfo.push(this.chairmansInfo);
          this.chairmansInfo={};
        },
        //添加秘书长
        addSecretarygeneralsInfo(){
          this.$refs['secretarygeneralsInfoFrom'].validate((valid) => {
            if (valid) {
              if (this.chamberOfCommerce.secretarygeneralsInfo === undefined || this.chamberOfCommerce.secretarygeneralsInfo==='') {
                this.chamberOfCommerce.secretarygeneralsInfo = [];
              }
              this.chamberOfCommerce.secretarygeneralsInfo.push(this.secretarygeneralsInfo);
              this.secretarygeneralsInfo = {};
            }
          });
        },
        //添加委员
        addCommitteeMember(){
          this.$refs['specialCommitteesForm'].validate((valid) => {
            if (valid) {
              if (this.chamberOfCommerce.specialCommittees === undefined || this.chamberOfCommerce.specialCommittees==='') {
                this.chamberOfCommerce.specialCommittees = [];
              }
              this.chamberOfCommerce.specialCommittees.push(this.specialCommittees);
              this.specialCommittees = {};
            }
          });
        },
        //添加部门
        addSecretariats(){
          this.$refs['secretariatsForm'].validate((valid) => {
            if (valid) {
              if (this.chamberOfCommerce.secretariats === undefined || this.chamberOfCommerce.secretariats==='') {
                this.chamberOfCommerce.secretariats = [];
              }
              this.chamberOfCommerce.secretariats.push(this.secretariats);
              this.secretariats = {};
            }})
        },
        dataFormSubmits(dataForm){
          var that =this;
            that.$refs['userRule'].validate((valid) => {
              //console.log(valid);
              if (!valid) {
                return;
              }
              that.$refs['chamberOfCommerceRule'].validate((valid) => {
                if (valid) {
                  var params = {
                    user: that.user,
                    commerce: that.chamberOfCommerce
                  }
                  var tick = !that.chamberOfCommerce.id ? API[that.pathUrl].add(params) : API[that.pathUrl].update(params)
                  tick.then(({data}) => {
                    if (data && data.code === 0) {
                      that.$message({
                        message: '操作成功',
                        type: 'success',
                        duration: 1500,
                        onClose: () => {
                          that.isUpdate = false;
                          that.getDataList();
                        }
                      })
                    } else {
                      that.$message.error(data.msg)
                    }
                  })
                }
              });

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
  .el-card__header {
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
</style>
