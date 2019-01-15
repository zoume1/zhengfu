<template>
  <div class="mod-config">
    <!--<el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()" style="padding-bottom:70px;">
      <seek ref="seek" :dataForm.sync="dataForm" :pathUrl="pathUrl"></seek>
      <div style="float:right">
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth(model+':'+pathUrl+':save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth(model+':'+pathUrl+':delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
        <el-button type="primary" @click="configHandle()">云存储配置</el-button>
        <el-button type="primary" @click="uploadHandle()">上传文件</el-button>
      </div>
    </el-form>-->
    <tablefield :pathUrl="pathUrl" ref="tablefield" :formButton="formButton":dataForm.sync="dataForm"  :setListSelections="setListSelections" :saveForm="saveForm" :model="model" :operation.sync="operation"></tablefield>
    <!-- 弹窗, 云存储配置 -->
    <config v-if="configVisible" ref="config"></config>
    <!-- 弹窗, 上传文件 -->
    <upload v-if="uploadVisible" ref="upload" @refreshDataList="getDataList"></upload>
  </div>
</template>

<script>
  import tablefield from '@/components/generator/tablefield.vue'
  import Config from './config'
  import Upload from './upload'
  export default {
    components: {
      tablefield,
      Config,
      Upload
    },
    data () {
      return {
        uploadVisible: false,
        configVisible: false,
        model: 'oss',
        pathUrl: 'sysoss',
        sysurl: window.SITE_CONFIG.baseUrl,
        dataForm: {},
        dataListSelections: [],
        // 操作按钮
        // 操作按钮
        operation: [
          {type:"primary",'scope': 'save', fun: this.addOrUpdateHandle, name: '修改',disabled:function(row){
              return false;
            }},
          {type:"danger",'scope': 'delete', fun: this.deleteHandle, name: '删除',disabled:function(row){
              return false;
            }},

        ],
        //表格按钮
        formButton:[
          {type:"primary",'scope': 'save', fun: this.addOrUpdateHandle, name: '新增',},
          {type:"primary",'scope': 'delete', fun: this.addAllOrUpdateHandle, name: '批量新增',},
          {type:"danger",'scope': 'delete', fun: this.deleteHandle, name: '批量删除',disabled:function(dataListSelections){
              return dataListSelections.length<=0;
            }},
          {type:"primary",'scope': 'delete', fun: this.configHandle, name: '云存储配置',disabled:function(row){
              return false;
            }},
          {type:"primary",'scope': 'delete', fun: this.uploadHandle, name: '上传图片',disabled:function(row){
              return false;
            }},
        ],
        saveForm: {
          id: 0,
          url: '',
          remarks: '',
          versionNo: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          deleteFlag: '',
          sort: '',
        }
      }
    },
    activated () {
      this.getDataList()
    },
    methods: {
      addAllOrUpdateHandle () {
        this.$nextTick(() => {
          this.$refs.tablefield.addAllOrUpdateHandle()
        })
      },
      addOrUpdateHandle (row) {
        this.$nextTick(() => {
          this.$refs.tablefield.addOrUpdateHandle(row)
        })
      },
      deleteHandle (row) {
        this.$nextTick(() => {
          this.$refs.tablefield.deleteHandle(row)
        })
      },
      setListSelections (val) {
        this.dataListSelections = val
      },
      getDataList () {
        this.$nextTick(() => {
          this.$refs.tablefield.getDataList()
        })
      },
      configHandle () {
        this.configVisible = true
        this.$nextTick(() => {
          this.$refs.config.init()
        })
      },
      // 上传文件
      uploadHandle () {
        this.uploadVisible = true
        this.$nextTick(() => {
          this.$refs.upload.init()
        })
      }
    }
  }
</script>
