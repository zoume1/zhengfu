<template>
  <div class="mod-config">
    <tablefield :pathUrl="pathUrl" ref="tablefield" :formButton="formButton" :dataForm.sync="dataForm"
                :setListSelections="setListSelections" :saveForm="saveForm" :model="model"
                :operation.sync="operation"></tablefield>
    <el-dialog title="报名人员" :visible.sync="lporganizers" :append-to-body="true" :modal-append-to-body="false"
               width="75%">
      <lporganizers ref="lporganizers" @refreshDataList="getDataList"></lporganizers>
    </el-dialog>
    <el-dialog
      title="审核"
      :close-on-click-modal="false"
      :visible.sync="dialogVisible">
      <el-form :model="dataForms" :rules="dataRule" ref="dataForms" @keyup.enter.native="dataFormSubmit()" label-width="80px">
        <el-form-item label="审核说明" prop="explain">
          <el-input v-model="dataForms.explain" placeholder="审核说明"size="mini" :autosize="{ minRows: 10, maxRows: 4}"
                    type="textarea"
                    :rows="2"
                   ></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dataFormSubmit(true)">通过</el-button>
        <el-button type="info" @click="dataFormSubmit(false)">不通过</el-button>
      <el-button @click="dialogVisible = false">取消</el-button>
    </span>
    </el-dialog>

  </div>
</template>

<script>
  import tablefield from '@/components/generator/tablefield.vue'
  import lporganizers from '../lporganizers/index'
  import API from '@/api'

  export default {
    components: {
      tablefield,
      lporganizers
    },
    data() {
      return {
        dialogVisible: false,
        lporganizers: false,
        model: 'lp',
        pathUrl: 'lpactivity',
        busConfig: this.busConfig,
        tableFieldMap: this.tableFieldMap,
        sysurl: window.SITE_CONFIG.baseUrl,
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
          {
            type: "danger", 'scope': 'delete', fun: this.audit, name: '审核', disabled: function (row) {
              return false;
            },isShow:function(row){
              return row.auditState=='0';
            }
          },
          {
            type: "primary", 'scope': 'save', fun: this.personnel, name: '报名人员', disabled: function (row) {
              return false;
            }
          },
        ],
        //表格按钮
        formButton: [
          {type: "primary", 'scope': 'save', fun: this.addOrUpdateHandle, name: '新增',},
          {type: "primary", 'scope': 'save', fun: this.addAllOrUpdateHandle, name: '批量新增',},
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
        saveForm: {
          id: 0,
          remarks: '',
          versionNo: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          deleteFlag: '',
          sort: '',
          name: '',
          state: '',
          pageview: '',
          applySize: '',
          applyStartTime: '',
          applyEndTime: '',
          auditState: '',
          userId: '',
          activityTime: '',
          address: ''
        },
        dataForms:{
          explain: ''
        },
        dataRule: {
          explain: [
            { required: true, message: '审核内容不能为空', trigger: 'blur' }
          ]
        },
        rowId:null,

      }
    },
    methods: {
      addAllOrUpdateHandle() {
        this.$nextTick(() => {
          this.$refs.tablefield.addAllOrUpdateHandle()
        })
      },
      addOrUpdateHandle(row) {
        this.$nextTick(() => {
          this.$refs.tablefield.addOrUpdateHandle(row)
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
      },
      personnel(scope) {
        this.lporganizers = true;
        this.$nextTick(() => {
          this.$refs.lporganizers.init(scope.id, this.dataForm)
        })
      },
      audit(row) {
        var that = this;
        this.dialogVisible = true;
        this.rowId=row.id;
      },
      dataFormSubmit(boo){
        var that = this;
        this.$refs.dataForms.validate((valid) => {
          if (valid) {
              //判断通过还是拒绝
                this.$confirm('此操作将'+(boo?'通过审核':'拒绝审核')+' 是否继续?', '提示', {
                  confirmButtonText: '确定',
                  cancelButtonText: '取消',
                  type: 'warning'
                }).then(() => {
                  API[that.pathUrl].audit({id:that.rowId,remake:that.dataForms.explain,boo}).then(({data})=>{
                    if (data && data.code === 0) {
                      this.$message({
                        message: '操作成功',
                        type: 'success',
                        duration: 1500,
                        onClose: () => {
                          this.dialogVisible = false;
                          this.getDataList()
                        }
                      })
                    } else {
                      this.$message.error(data.msg)
                    }

                  });
                })

          }
        });
        }

    }
  }
</script>
