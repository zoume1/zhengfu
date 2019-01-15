<template>
  <div v-if="isUpdate" id="update">
    <el-form :inline="true" :validate-on-rule-change="false" :model="chamberOfCommerce" :rules="chamberOfCommerceRule" ref="chamberOfCommerceRule" @keyup.enter.native="dataFormSubmits()" class="demo-form-inline" label-position="right" label-width="120px">
      <el-row :gutter="24">
        <el-col class="col" :lg="8"  >
          <formItem v-model="chamberOfCommerce.userName" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.userName" :model="model" :isPage="true" :size="size"></formItem>
        </el-col>
        <el-col class="col" :lg="16">
          <formItem v-model="chamberOfCommerce.password" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.password"   :model="model" :isPage="true" :size="size"></formItem>
        </el-col>
      </el-row>
      <el-row>
        <!--导航栏-->
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" style="margin-bottom:20px;">
          <el-menu-item index="1" >团体基本人信息</el-menu-item>
          <el-menu-item index="2">团体代表人</el-menu-item>
        </el-menu>
        <div class="line" v-show="activeIndex==1">
          <!--图片上传-->
          <el-row :gutter="24">
              <!--归属商会-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.coceralId" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :model="coceralModule" :pathUrl="coceralPathUrl" :field="fieldMap.coceralId"    :isPage="true" :size="size"></formItem>
              </el-col>
            <!--团体名称-->
            <el-col class="col" :lg="8">
              <formItem v-model="chamberOfCommerce.groupName" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :model="coceralModule" :pathUrl="coceralPathUrl" :field="fieldMap.groupName"    :isPage="true" :size="size"></formItem>
            </el-col>
              <!--入会时间-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupInitiationTime" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupInitiationTime"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--团体所在行政区域-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupAdministrativeRegion" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupAdministrativeRegion"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--团体会员分类-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupCategory" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupCategory"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--中文名称-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupChineseName" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupChineseName"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--英文名称-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupEnglishName" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupEnglishName"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--成立时间-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupEstablishedTime" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupEstablishedTime"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--法定代表人姓名-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupStatutoryRepresentativeName" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupStatutoryRepresentativeName"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--业务主管单位-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupCompetentOrganization" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupCompetentOrganization"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--批准登记机关-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupRegistrationAuthority" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupRegistrationAuthority"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--统一社会代码-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupUniformCreditCode" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupUniformCreditCode"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--通讯地址-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupPostalAddress" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupPostalAddress"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--办公电话-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupOfficePhone" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupOfficePhone"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--电子邮箱-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupEmailAddress" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupEmailAddress"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--传真-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupFox" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupFox"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--邮政编码-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupPostalCode" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupPostalCode" :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--团体网站-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupWebsite" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupWebsite"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--	下属企业会员数量-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupSubordinateCompanySize" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupSubordinateCompanySize"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--下属团体会员数量-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupMembersSize" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupMembersSize"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
              <!--下属个人会员数量-->
              <el-col class="col" :lg="8">
                <formItem v-model="chamberOfCommerce.groupIndividualMemberSize" :dataRule="chamberOfCommerceRule" :dataForm="chamberOfCommerce" :pathUrl="pathUrl" :field="fieldMap.groupIndividualMemberSize"   :model="model" :isPage="true" :size="size"></formItem>
              </el-col>
          </el-row>
        </div>
        <div class="line" v-show="activeIndex==2">
          <!--团体代表人-->
          <el-form-item   prop="groupRepresentativeList">
            <el-card class="box-card">
              <div slot="header" class="clearfix" >
                <span>团体代表人列表</span>
              </div>
              <div class="text item">
                <el-form  class="demo-ruleForm" :model="groupRepresentativeList" :rules="groupRepresentativeListFrom"  ref="groupRepresentativeListFrom" @keyup.enter.native="addgroupRepresentativeList()">
                  <!--普通文本框-->
                  <el-row :gutter="24">
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="name">
                        <el-input :size="size" v-model="groupRepresentativeList.name" placeholder="姓名"  >
                          <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">姓名</label></template>
                        </el-input>
                      </el-form-item>
                    </el-col>
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="sex">
                        <!--下拉选select-->
                        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
                          <div class="el-input-group__prepend"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">性别</label></div>
                          <el-select v-model="groupRepresentativeList.sex"   :size="size" :filterable="true" placeholder="性别" style="width:100%;">
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
                          <el-date-picker v-model="groupRepresentativeList.birthDate" :size="size"  type="date" style="width:100%;" value-format="yyyy-MM-dd"  placeholder="出生日期" format="yyyy-MM-dd">

                          </el-date-picker>
                        </div>
                      </el-form-item>
                    </el-col>
                    <el-col class="col" :lg="8">
                      <el-form-item   prop="organization">
                        <el-input :size="size" v-model="groupRepresentativeList.organization" placeholder="所在组织"  >
                          <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">所在组织</label></template>
                        </el-input>
                      </el-form-item>
                    </el-col>
                    <el-col class="col" :lg="8">
                      <el-button type="success" @click="addgroupRepresentativeList()">添加团体代表人</el-button>
                    </el-col>
                  </el-row>
                </el-form>
                <el-table
                  :data="chamberOfCommerce.groupRepresentativeList"
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
                      <el-button  :size="size"  @click="chamberOfCommerce.groupRepresentativeList.splice(scope.$index,1)">删除</el-button>
                    </template>
                  </el-table-column>
                </el-table>
              </div>
            </el-card>
          </el-form-item>
        </div>
      </el-row>

      <div>
        <!--联系人--->
        <el-form-item   prop="groupContactList">
          <el-card class="box-card">
            <div slot="header" class="clearfix" >
              <span>联系人</span>
            </div>
            <div class="text item">
              <el-form  class="demo-ruleForm" :model="groupContactList" :rules="groupContactListForm" ref="groupContactListForm" @keyup.enter.native="addgroupContactList()">
                <!--普通文本框-->
                <el-row :gutter="24">
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="name">
                      <el-input :size="size" v-model="groupContactList.linkman" placeholder="社团联系人"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">社团联系人</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="department">
                      <el-input :size="size" v-model="groupContactList.contactPhone" placeholder="联系人手机号"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">联系人手机号</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-form-item   prop="department">
                      <el-input :size="size" v-model="groupContactList.specialPlane" placeholder="办公电话(座机)"  >
                        <template slot="prepend" ><label  class="el-form-item__label" style="padding: 0;line-height: initial;">办公电话(座机)</label></template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col class="col" :lg="8">
                    <el-button type="success" @click="addgroupContactList()">添加联系人</el-button>
                  </el-col>
                </el-row>
              </el-form>
              <el-table
                :data="chamberOfCommerce.groupContactList"
                height="250"
                border
                style="width: 100%">
                <el-table-column
                  prop="linkman"
                  label="社团联系人"  >
                </el-table-column>
                <el-table-column
                  prop="contactPhone"
                  label="联系人手机号"  >
                </el-table-column>
                <el-table-column
                  prop="specialPlane"
                  label="办公电话(座机)"  >
                </el-table-column>
                <el-table-column
                  fixed="right"
                  header-align="center"
                  align="center"
                  width="300"
                  label="操作">
                  <template slot-scope="scope">
                    <el-button  :size="size"  @click="chamberOfCommerce.groupContactList.splice(scope.$index,1)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
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
        //商会信息验证
        chamberOfCommerceRule:{},
        //团体代表人列表
        groupRepresentativeList:{},
        //团体代表人列表验证规则
        groupRepresentativeListFrom:{
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
        groupContactList:{},
        groupContactListForm: {
          linkman: [
            {required: true, message: '社团联系人不能为空', trigger: 'blur'}
          ],
          specialPlane:[
            {required: true, message: '办公电话(座机)不能为空', trigger: 'blur'}
          ],
          contactPhone:[
            {required: true, message: '联系人手机号不能为空', trigger: 'blur'}
          ]
        },
        coceralModule:'lp',
        coceralPathUrl:'lpchamberofcommerce',
        size: "medium",
        isUpdate: this.value,
        chamberOfCommerce:{
          groupAdministrativeRegion:[],
          groupRepresentativeList:[],
          groupContactList:[]
        },
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
    methods:{
      handleSelect(key, keyPath) {
        this.activeIndex=key;
        console.log(key, keyPath);
      },
      addOrUpdateHandle(row){
        var that = this;
        var chamberOfCommerceRule={}
        var chamberOfCommerce={
          groupAdministrativeRegion:[],
          groupRepresentativeList:[],
          groupContactList:[]
        }
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
                data.data.groupAdministrativeRegion=(data.data.groupAdministrativeRegion!='' && data.data.groupAdministrativeRegion!=undefined)?JSON.parse(data.data.groupAdministrativeRegion):[];
                data.data.groupContactList=(data.data.groupContactList!=undefined && data.data.groupContactList!='')?JSON.parse(data.data.groupContactList):[];
                data.data.groupRepresentativeList=(data.data.groupRepresentativeList!=undefined && data.data.groupRepresentativeList!='')?JSON.parse(data.data.groupRepresentativeList):[];
                this.chamberOfCommerce=data.data;
              }
            })
          }
        })
      },
      //添加团体代表人
      addgroupRepresentativeList(){
        this.$refs['groupRepresentativeListFrom'].validate((valid) => {
          if (valid) {
            if (this.chamberOfCommerce.groupRepresentativeList === undefined || this.chamberOfCommerce.groupRepresentativeList==='') {
              this.chamberOfCommerce.groupRepresentativeList = [];
            }
            this.chamberOfCommerce.groupRepresentativeList.push(this.groupRepresentativeList);
            this.groupRepresentativeList = {};
          }
        });
      },
      //添加团体联系人
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
            that.chamberOfCommerce.userType="2"
            Object.assign(params,that.chamberOfCommerce);
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

</style>
