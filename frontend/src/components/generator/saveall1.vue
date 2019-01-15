<template>
  <el-dialog
    title="批量新增" :modal-append-to-body="false" :close-on-click-modal="false"
    :visible.sync="visible" width="75%" :append-to-body="true" >

      <div style="float:right;    margin-bottom: 10px;">
        <el-button  type="primary" @click="addOrUpdateHandle(dataForm)">新增</el-button>
        <el-button  type="primary" @click="dataFormSubmit()">保存</el-button>
      </div>

    <el-form :inline="true"  ref="dataForm" @keyup.enter.native="dataFormSubmit()" >
  <el-table :data="tableData" class="tb-edit" style="width: 100%"  height="500"  size="mini" border highlight-current-row >
    <el-table-column v-for="(item,index) in columns" :key="index" v-if="item.isSet=='0'"
                     sortable="custom"
                     :prop="item.fieldName"
                     header-align="center"
                     align="center" :label="item.pageComment" height="10" >
      <template slot-scope="scope">
        <formItem v-model="scope.row[item.fieldName]" :dataRule="dataRule"  :dataForm="scope.row"  :pathUrl="pathUrl" :field="item"   :model="model" :isPage="false"></formItem>
      </template>
    </el-table-column>
    <el-table-column label="操作" fixed="right"   header-align="center"
                     align="center"
                     width="100">
      <template slot-scope="scope">
        <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
    </el-form>
  </el-dialog>

</template>

<script>
  import API from '@/api'
  import {getAddress,queryAddressById,treeDataTranslate} from '@/utils'
  import linkage from '@/components/input/linkage.vue'
  import password from '@/components/input/password.vue'
  import tree from '@/components/input/tree.vue'
  import upload from '@/components/input/upload.vue'
  import formItem from '@/components/generator/formItem.vue'
  export default {
    name: 'saveall',
    components: {
      linkage,
      upload,
      password,
      tree,
      formItem
    },
    data () {
      return {
        imgUrl: API.sysoss.upload(this.$cookie.get('token')),
        visible: false,
        tableData: [],
        dataForm:{},
      }
    },
    props: {
      defaultForm:{
        type:Object,
        default:{}
      },

      dataRule: {
        default: function () {
          return {}
        },
        type: Object
      },
      pathUrl: {
        type: String
      },
      model: {

      },
      list: {
        type: Array
      },
      updateFunction: {
        type: Function
      },
      tableFieldMap: {
        type:Object
      },
      busConfig: {
        type:Object
      },
      columns: {
        type:Array,
        default:[]
      },
    },
    methods: {
      // 初始化方法
      init: function (id) {
        this.tableData=[];
        var dataForm = {};
        dataForm.id = id || 0
        for (var i = 0; i < this.columns.length; i++) {
          var cou = this.tableFieldMap.columns[i];
          if(cou.isSet=='0'){
            if (cou.isNull === '1') {
              this.dataRule[cou.fieldName] = [
                { required: cou.checkout==null?false:JSON.parse(cou.checkout).indexOf("1")!=-1, message: cou.pageComment+'不能为空', trigger: 'blur' },
                { fieldName:cou.fieldName,checkout:cou.checkout,validator: function(rule, value, callback) {
                    if(rule.checkout!=null  ){
                      var che = JSON.parse(rule.checkout);
                      var boo=true;
                      for(var i in che){
                        var item = che[i];
                        //0-手机号,1-非空,2-身份证,3-邮箱,4-数字,5-小数
                        if (item==="0" && !isMobile(value)) {
                          callback(new Error('手机号格式错误'))
                        }else if(item==="1" && !isNull(value)){
                          callback(new Error('不能为空'))
                          boo=false;
                        }else if(item==="2" && ! isIdentityCard(value)){
                          callback(new Error('身份证格式错误'))
                          boo=false;
                        }else if(item==="3" && !isEmail(value)){
                          callback(new Error('邮箱格式错误'))
                          boo=false;
                        }else if(item==="4" && !isInteger(value)){
                          callback(new Error('数字格式错误'))
                          boo=false;
                        }else if(item==="5" && !isDecimals(value)){
                          callback(new Error('小数格式错误'))
                          boo=false;
                        }
                      }
                      if(boo){
                        callback()
                      }
                    }else{
                      callback()
                    }
                  }
                  , trigger: 'blur' }
              ]
            }
            if(cou.inputType === '9'  || cou.inputType === '5'  || cou.inputType === '11'|| cou.inputType === '13'||cou.inputType === '15' ||cou.inputType === '19'){
              dataForm[cou.fieldName]=[];
            }
            else{
                dataForm[cou.fieldName]=cou.dataDefault;
            }
          }
        }
        Object.assign(dataForm,this.defaultForm);
        this.visible = true
        var that = this;
        this.$nextTick(() => {
          that.dataForm=dataForm;
          that.addOrUpdateHandle(that.dataForm);
        });
      },
      // 表单提交
      dataFormSubmit () {
        console.log(this.$refs['dataForm']);
       this.$refs['dataForm'].validate((valid) => {
         console.log(valid);
         if (valid) {
            var params = {}
            Object.assign(params, this.tableData)
            //console.log(this.tableData);
            var tick = API[this.pathUrl].saveAll(this.tableData)

            tick.then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false;
                      this.reloadBusConfig(this.model+this.pathUrl,this.tableFieldMap.tableName);
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
       })
      },
      handleDelete(index, row) {
        this.tableData.splice(index,1)

      },
      addOrUpdateHandle(dataForm){
        console.log(dataForm);
        var sort = this.defaultForm.sort;
        console.log(this.defaultForm.sort);
        if( this.tableData.length>0){
           sort = this.tableData[this.tableData.length-1].sort
        }
        console.log(this.tableData);
        this.tableData.push(JSON.parse(JSON.stringify(dataForm)));
        this.tableData[this.tableData.length-1].sort=sort+1;
      }
    }
  }
</script>
<style>
  /*.tb-edit .el-input {*/
    /*display: none*/
  /*}*/
  /*.tb-edit .current-row .el-input {*/
    /*display: block*/
  /*}*/
  /*.tb-edit .current-row .el-input+span {*/
    /*display: none*/
  /*}*/

</style>
