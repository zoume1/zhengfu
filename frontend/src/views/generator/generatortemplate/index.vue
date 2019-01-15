<template>
  <div class="mod-config">
    <tablefield :pathUrl="pathUrl" ref="tablefield" :formButton="formButton":dataForm.sync="dataForm"  :setListSelections="setListSelections" :saveForm="saveForm" :model="model" :operation.sync="operation"></tablefield>
  </div>
</template>

<script>
  import tablefield from '@/components/generator/tablefield.vue'
  export default {
    components: {
      tablefield
    },
    data () {
      return {
        model: 'generator',
        pathUrl: 'generatortemplate',
        busConfig: this.busConfig,
        tableFieldMap: this.tableFieldMap,
        sysurl: window.SITE_CONFIG.baseUrl,
        dataForm: {},
        dataListSelections: [],
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
          {type:"primary",'scope': 'save', fun: this.addAllOrUpdateHandle, name: '批量新增',},
          {type:"danger",'scope': 'delete', fun: this.deleteHandle, name: '批量删除',disabled:function(dataListSelections){
              return dataListSelections.length<=0;
            }},
        ],
        saveForm: {
          id: 0,
          text: '',
          remark: '',
          url: '',
          fileName: '',
          versionNo: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          deleteFlag: '',
          sort: ''
        }
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
      getDataList () {
        this.$nextTick(() => {
          this.$refs.tablefield.getDataList()
        })
      }
    }
  }
</script>
