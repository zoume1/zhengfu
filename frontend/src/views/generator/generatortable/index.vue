<template>
  <div class="mod-config">
    <tablefield :pathUrl="pathUrl" ref="tablefield" :formButton="formButton"   :setListSelections="setListSelections"  :model="model" :operation.sync="operation"></tablefield>
    <el-dialog title="字段列表"  :visible.sync="generatortablefield" :append-to-body="true" :modal-append-to-body="false"width="75%"  >
      <generatortablefield  ref="generatortablefield" @refreshDataList="getDataList"></generatortablefield>
    </el-dialog>
    <el-dialog title="模板预览"  :visible.sync="preview"  width="75%"  >
      <preview  ref="preview" @refreshDataList="getDataList"></preview>
    </el-dialog>
      <fieldCopy  ref="fieldCopy" @refreshDataList="getDataList"></fieldCopy>
  </div>
</template>

<script>
  import API from '@/api'
  import generatortablefield from '../generatortablefield/index'
  import preview from './preview/preview'
  import fieldCopy from './fieldCopy/fieldCopy'
  import tablefield from '@/components/generator/tablefield.vue'
  export default {
    components: {
      tablefield,
      generatortablefield,
      preview,
      fieldCopy
    },
    data () {
      return {

        dataForm:{},
        model: 'generator',
        pathUrl: 'generatortable',
        dataListSelections: [],
        generatortablefield: false,
        preview: false,
        // 操作按钮
        operation: [
        {type:"primary",'scope': 'save', fun: this.addOrUpdateHandle, name: '修改',disabled:function(row){
            return false;
          }},
        {type:"danger",'scope': 'delete', fun: this.deleteHandle, name: '删除',disabled:function(row){
            return false;
          }},
          {type:"primary",scope: 'delete', fun: this.queryField, name: '字段列表',disabled:function(row){
              return false;
            }},
          {type:"primary",'scope': 'delete', fun: this.queryPreviw, name: '模板预览',disabled:function(row){
              return false;
            }},
          {type:"primary",'scope': 'delete', fun: this.synchronizationStructure, name: '结构同步',disabled:function(row){
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

          {type:"danger",'scope': 'delete', fun: this.synchronizationStructure, name: '批量同步',disabled:function(dataListSelections){
              return dataListSelections.length<=0;
            }},{type:"danger",'scope': 'delete', fun: this.generate, name: '生成',disabled:function(dataListSelections){
              return dataListSelections.length<=0;
            }},
          {type:"danger",'scope': 'delete', fun: this.fieldCopyFun, name: '字段拷贝',disabled:function(dataListSelections){
              return dataListSelections.length!=2;
            }},
        ],
      }
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
      init: function (id) {
        //this.getDataList()
      },  // 多选
      getDataList () {
        this.$nextTick(() => {
          this.$refs.tablefield.getDataList()
        })
      },
      // 生成
      generate (id) {
        var self = this;

        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '生成' : '批量生成'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          location.href =window.SITE_CONFIG.baseUrl+ '/generator/generatortable/generate?ids=' + JSON.stringify(ids)
        })
      },
      // 查看字段
      queryField (scope) {
        this.generatortablefield = true
        this.$nextTick(() => {
          this.$refs.generatortablefield.init(scope.id)
        })
      },
      // 模板预览
      queryPreviw (scope) {
        this.preview = true
        this.$nextTick(() => {
          this.$refs.preview.init(scope.id)
        })
      },
      //同步当前连接的数据库结构
      synchronizationStructure (id) {
    var self = this;
    if(id!=null){
      id=id.id;
    }
    var ids = id ? [id] : this.dataListSelections.map(item => {
      return item.id
    })
    this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '结构同步' : '批量结构同步'}]操作?`, '提示', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }).then(() => {
      API[this.pathUrl].synchronizationStructure(ids).then(({data}) => {
        if (data && data.code === 0) {
        this.getDataList();
        }
      })
    })
  },
      //字段拷贝
      fieldCopyFun(id){
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item
        })
         this.fieldCopy = true;
        this.$nextTick(() => {
          this.$refs.fieldCopy.init(ids[0],ids[1])
        })
      }
    }
  }
</script>
<style>
  .transfer-footer {
    margin-left: 20px;
    padding: 6px 5px;
  }
</style>
