<template>
  <div>
    <!--用户表格-->
    <tablefield  v-if="!isUpdate" :pathUrl="pathUrl" ref="tablefield" :formButton="formButton" :dataForm.sync="dataForm" :setListSelections="setListSelections"  :model="model"
                 :operation.sync="operation" :tabData="tabData" :seekForm="{userType:'2'}"></tablefield>
    <update ref="update" v-model="isUpdate"  :model="model" :pathUrl="pathUrl" :tabData="tabData"></update>
  </div>
</template>

<script>
  import tablefield from '@/components/generator/tablefield.vue'
  import API from '@/api'
  import update from './update.vue'
  export default {
    components: {
      tablefield,
      update
    },
    data() {
      return {
        isUpdate: false,
        model: 'lp',
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
      API.common.jqueryRequest('/'+this.model+'/'+this.pathUrl+'/selectTableConfig',"get",{type:"2"},function(data) {
        that.tabData=data.data;
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
