<template>
  <div class="mod-config">
    <tablefield :pathUrl="pathUrl" ref="tablefield" :formButton="formButton" :seekForm="seekForm" :dataForm="dataForm"    :model="model" :operation.sync="operation" :setListSelections="setListSelections"></tablefield>
  </div>
</template>

<script>
  import API from '@/api'
  import tablefield from '@/components/generator/tablefield.vue'
  export default {
    components: {
      tablefield
    },
    data: function () {
      return {
        tableId:null,
        model: 'generator',
        pathUrl: 'generatortablefield',
        busConfig: this.busConfig,
        tableFieldMap: this.tableFieldMap,
        dataForm: {},
        dataListSelections: [],
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
        {type:"danger",'scope': 'delete', fun: this.hideTableField, name: '隐藏表格字段',disabled:function(dataListSelections){
              return dataListSelections.length<=0;
            }},
        {type:"danger",'scope': 'delete', fun: this.hideSetField, name: '隐藏修改字段',disabled:function(dataListSelections){
              return dataListSelections.length<=0;
            }},
        {type:"danger",'scope': 'delete', fun: this.showSeekField, name: '显示搜索字段',disabled:function(dataListSelections){
              return dataListSelections.length<=0;
            }},
        {type:"danger",'scope': 'delete', fun: this.showExportField, name: '显示导出字段',disabled:function(dataListSelections){
              return dataListSelections.length<=0;
            }},
        ],
        seekForm: {

        }
      }
    },
    methods: {
      addAllOrUpdateHandle () {
        this.$nextTick(() => {
          this.$refs.tablefield.addAllOrUpdateHandle()
        })
      },
      init: function (id) {
        this.seekForm={tableId:id}
        this.dataForm={tableId:id}
        this.getDataList();
      },  // 多选
      getDataList () {
        this.$nextTick(() => {
          this.$refs.tablefield.getDataList()
        })
      },
      addOrUpdateHandle (row) {
        this.$nextTick(() => {
          this.$refs.tablefield.addOrUpdateHandle(row,{tableId:this.tableId})
        })
      },
      deleteHandle (row) {
        this.$nextTick(() => {
          this.$refs.tablefield.deleteHandle(row)

        })
      },
      setListSelections (val) {
        this.dataListSelections = val
      },    // 多选
      hideTableField (scope) {
        //console.log(scope)
        var ids = scope ? [scope] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${scope ? '隐藏' : '批量隐藏'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          API.generatortablefield.hideTableField(ids).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      },
      hideSetField (scope) {
        var ids = scope ? [scope] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${scope ? '隐藏' : '批量隐藏'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          API.generatortablefield.hideSetField(ids).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      },
      showSeekField (scope) {
        var ids = scope ? [scope] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${scope ? '隐藏' : '批量显示'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          API.generatortablefield.showSeekField(ids).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      },
      showExportField (scope) {
        var ids = scope ? [scope] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${scope ? '隐藏' : '批量显示'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          API.generatortablefield.showExportField(ids).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
