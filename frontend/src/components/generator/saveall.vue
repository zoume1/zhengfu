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
        <el-table-column v-for="(item,index) in tableFieldMap.columns" :key="index" v-if="item.isSet=='0'"
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
  import {regularBinding} from '@/utils/validate'
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
      }
    },
    methods: {
      // 初始化方法
      init: function (id) {
        var that =this;
       // this.tableData=[];
        var dataForm = {};
        dataForm.id = id || 0
        regularBinding(this.dataRule,this.tableFieldMap.columns,dataForm,function(){
          return that.dataForm;
        });
        Object.assign(dataForm,this.defaultForm);
        this.visible = true
        this.$nextTick(() => {
          that.dataForm=dataForm;
          that.addOrUpdateHandle(that.dataForm);
        });
      },
      // 表单提交
      dataFormSubmit () {
        console.log(this.$refs['dataForm']);
        // this.$refs['dataForm'].validate((valid) => {
        //   console.log(valid);
        //   if (valid) {
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
                    this.tableData=[];
                    this.visible = false;
                    this.reloadBusConfig(this.model+this.pathUrl,this.tableFieldMap.tableName);
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
        //   }
        // })
      },
      handleDelete(index, row) {
        this.tableData.splice(index,1)
      },
      addOrUpdateHandle(dataForm){
        var sort = this.defaultForm.sort;
        if( this.tableData.length>0){
          sort = this.tableData[this.tableData.length-1].sort
        }
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
