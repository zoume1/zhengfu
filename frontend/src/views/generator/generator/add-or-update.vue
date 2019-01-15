<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="表名" prop="tableName">
        <el-input v-model="dataForm.tableName" placeholder="表名"></el-input>
      </el-form-item>
      <el-form-item label="模块名称" prop="modulesId">
        <el-select v-model="dataForm.modulesId" placeholder="请选择" style="width:100%;">
          <el-option
            v-for="item in queryGeneratorModulesList"
            :key="item.name"
            :label="item.theme"
            :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <!--<el-form-item label="Engine" prop="engine">-->
        <!--<el-input v-model="dataForm.engine" placeholder="Engine"></el-input>-->
      <!--</el-form-item>-->
      <el-form-item label="表注释" prop="tableComment">
        <el-input v-model="dataForm.tableComment" placeholder="表注释"></el-input>
      </el-form-item>
      <el-form-item label="状态" prop="deleteFlag">
        <el-select v-model="dataForm.deleteFlag" placeholder="请选择" style="width:100%;">
          <el-option
            key="存在"
            label="存在"
            value="0">
          </el-option>
          <el-option
            key="隐藏"
            label="隐藏"
            value="1">
          </el-option>
        </el-select>
      </el-form-item>
<!--      <el-form-item label="排序" prop="sort">
        <el-input v-model="dataForm.sort" placeholder="排序"></el-input>

      </el-form-item>-->
     <!-- <el-form-item label="创建时间" prop="createTime">
        <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
      </el-form-item>-->
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import API from '@/api'
  export default {
    data () {
      return {
        pathUrl: this.$route.path.split('/')[this.$route.path.split('/').length - 1],
        queryGeneratorModulesList: [],
        busConfig: this.busConfig,
        sysurl: window.SITE_CONFIG.baseUrl,
        visible: false,
        dataForm: {
          tableName: '',
          modulesId: '',
          engine: '',
          tableComment: '',
          versionNo: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          deleteFlag: '',
          sort: ''
        },
        dataRule: {
          tableName: [
            { required: true, message: '表名不能为空', trigger: 'blur' }
          ],
          modulesId: [
            { required: true, message: '模块名不能为空', trigger: 'blur' }
          ],
          tableComment: [
            { required: true, message: '表备注不能为空', trigger: 'blur' }
          ],
          deleteFlag: [
            { required: true, message: '状态不能为空', trigger: 'blur' }
          ]
        }
      }
    },
  // {
 //   "tableName": "sys_notice_message"
  //   "engine": "InnoDB",
  //   "tableComment": "提醒消息",
  //
    //   "createTime": "2018-05-25 02:35:44",
  // }
    methods: {
      init (row) {
        this.visible = true
        API.generatormodules.queryGeneratorModulesList().then(({data}) => {
          if (data && data.code === 0) {
            this.queryGeneratorModulesList = data.data
          } else {
            this.queryGeneratorModulesList = []
          }
        })
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
            // API.yczjmanufacturers.info(this.dataForm.id).then(({data}) => {
            //   if (data && data.code === 0) {
          this.dataForm.tableName = row.tableName
          this.dataForm.tableComment = row.tableComment
           //     this.dataForm.engine = row.engine
            //   }
            // })
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            var params = {
              'tableName': this.dataForm.tableName,
              'engine': this.dataForm.engine,
              'tableComment': this.dataForm.tableComment,
              'modulesId': this.dataForm.modulesId,
              'createTime': this.dataForm.createTime,
              'sort': this.dataForm.sort
            }
            var tick = !this.dataForm.id ? API.generator.add(JSON.stringify([params])) : API.generator.update(JSON.stringify([params]))
            tick.then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
