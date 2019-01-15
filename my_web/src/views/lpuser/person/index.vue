<template>
  <div>
    <update ref="update" v-model="isUpdate"  :model="model" :pathUrl="pathUrl" :tabData="tabData"></update>
  </div>
</template>

<script>
  import API from '@/api'
  import update from './update.vue'
  export default {
    components: {
      update
    },
    data() {
      return {
        isUpdate: false,
        model: 'lppc',
        pathUrl: 'lpuser',
        dataForm: {},
        dataListSelections: [],
        // 操作按钮
        operation: [
          {
            type: "primary", 'scope': 'save', fun: this.addOrUpdateHandle, name: '修改', disabled: function (row) {
              return false;
            }
          },
          {
            type: "danger", 'scope': 'delete', fun: this.deleteHandle, name: '删除', disabled: function (row) {
              return false;
            }
          },
        ],
        //表格按钮
        formButton: [
          {type: "primary", 'scope': 'save', fun: this.addOrUpdateHandle, name: '新增',},
          //    {type: "primary", 'scope': 'save', fun: this.addAllOrUpdateHandle, name: '批量新增',},
          {
            type: "danger",
            'scope': 'delete',
            fun: this.deleteHandle,
            name: '批量删除',
            disabled: function (dataListSelections) {
              return dataListSelections.length <= 0;
            }
          },
        ],
        tabData:{},
    }
    },
    created(){
      var that =this;
      API.common.jqueryRequest('/'+this.model+'/'+this.pathUrl+'/selectTableConfig',"get",{type:"0"},function(data) {
        that.tabData=data.data;
        that.addOrUpdateHandle(that.user);
      },false,false);
    },
    methods: {
      addAllOrUpdateHandle() {
        this.$nextTick(() => {
          this.$refs.tablefield.addAllOrUpdateHandle()
        })
      },
      addOrUpdateHandle(row) {
       this. isUpdate=true,
              this.$nextTick(() => {
                this.$refs.update.addOrUpdateHandle(row)
        })
      },
      deleteHandle(row) {
        this.$nextTick(() => {
          this.$refs.tablefield.deleteHandle(row)
        })
      },
      setListSelections(val) {
        this.dataListSelections = val
      },
      getDataList() {
        this.$nextTick(() => {
          this.$refs.tablefield.getDataList()
        })
      }
    }
  }
</script>
<style scoped>

</style>
