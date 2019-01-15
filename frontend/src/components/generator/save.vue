<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'" :modal-append-to-body="false" :close-on-click-modal="true"
    :visible.sync="visible" >
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" :validate-on-rule-change="false">
      <el-row :gutter="20">
        <el-col
          :lg="item.inputType=='5'||item.inputType=='7' ||item.inputType=='6' ||item.inputType=='16'||item.inputType=='8'||item.inputType=='15'||item.inputType=='14' ||item.inputType=='9' ||item.inputType=='19'  ?24:12"
          v-for="(item,index) in tableFieldMap.columns" :key="index"
          v-if="(item.isSet=='0') && (dataFormDisabled[item.fieldName]==null ||  dataFormDisabled[item.fieldName](dataForm))">
          <formItem v-model="dataForm[item.fieldName]" :dataRule="dataRule" :dataForm="dataForm" :pathUrl="pathUrl"
                    :field="item"  :model="model"
                    :isPage="true"  ></formItem>
        </el-col>
      </el-row>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import API from '@/api'
  import {getAddress, queryAddressById, treeDataTranslate} from '@/utils'
  import formItem from '@/components/generator/formItem.vue'
  import {regularBinding} from '@/utils/validate'

  export default {
    name: 'save',
    components: {
      formItem
    },
    data() {
      return {
        op: [],
        dataForm: {},
        visible: false,
        activeIndex: null,
        dataRule: {}
      }
    },
    props: {
      dataFormDisabled: {
        type: Object,
        default: function () {
          return {}
        }
      },
      defaultForm: {
        type: Object,
        default: {}
      },
      pathUrl: {
        type: String
      },
      model: {
        type: String
      },
      tableFieldMap: {
        type: Object
      },
      updateDataFormSubmit: {
        type: Function,
      }
    },
    methods: {

      isUpdate(item) {
        return item.isUpdate == '1' && !(!this.dataForm.id)
      },
      // 初始化方法
      init: function (id) {
        var that = this;
        var dataForm = {id: id};
        regularBinding(this.dataRule,this.tableFieldMap.columns,dataForm,function(){
          return that.dataForm;
        });
        Object.assign(dataForm, this.defaultForm);
        this.visible = true

        this.$nextTick(() => {
          that.$refs['dataForm'].resetFields()
          that.dataForm = dataForm;
          if (id) {
            API[this.pathUrl].info(id).then(({data}) => {
              if (data && data.code === 0) {
                for (var i = 0; i < this.tableFieldMap.columns.length; i++) {
                  var cou = this.tableFieldMap.columns[i]
                  // 多选框兼容
                  if (cou.inputType === '5' || cou.inputType === '11' || cou.inputType === '13' || cou.inputType === '15' || cou.inputType === '19') {
                    if (!data.data[cou.fieldName]) {
                      this.dataForm[cou.fieldName] = []
                    } else {
                      var arr = null
                      try {
                        arr = JSON.parse(data.data[cou.fieldName])
                      } catch (e) {
                        arr = data.data[cou.fieldName]
                      }
                      if (arr instanceof Array) {
                        this.dataForm[cou.fieldName] = arr
                      } else {
                        arr += ''
                        this.dataForm[cou.fieldName] = [arr]
                      }
                    }
                  }
                  // 多图像上传兼容
                  else if (cou.inputType === '9') {
                    if (!data.data[cou.fieldName]) {
                      this.dataForm[cou.fieldName] = []
                    } else {
                      var arrayImg = null
                      try {
                        arrayImg = JSON.parse(data.data[cou.fieldName])
                      } catch (e) {
                        arrayImg = data.data[cou.fieldName]
                      }
                      if (arrayImg instanceof Array) {
                        this.dataForm[cou.fieldName] = arrayImg
                      } else {
                        this.dataForm[cou.fieldName] = [{uid: 999, name: cou.fieldName, url: arrayImg}]
                      }
                    }
                  } else if (cou.inputType === '14') {
                    this.dataForm[cou.fieldName] = ''
                  } else {
                    this.dataForm[cou.fieldName] = data.data[cou.fieldName]
                  }
                }
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit() {
        if (this.updateDataFormSubmit != null) {
          this.updateDataFormSubmit(this.dataForm)
        } else {
          this.$refs['dataForm'].validate((valid) => {
            if (valid) {
              var params = {}
              Object.assign(params, this.dataForm)
              var tick = !this.dataForm.id ? API[this.pathUrl].add(params) : API[this.pathUrl].update(params)
              tick.then(({data}) => {
                if (data && data.code === 0) {
                  this.$message({
                    message: '操作成功',
                    type: 'success',
                    duration: 1500,
                    onClose: () => {
                      this.visible = false;
                      this.reloadBusConfig(this.model + this.pathUrl, this.tableFieldMap.tableName);
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
  }
</script>
<style lang="scss">
  .mod-menu {
    .menu-list__input {
      > .el-input__inner {
        cursor: pointer;
      }
    }
    .icon-tips {
      font-size: 18px;
      text-align: center;
      color: #e6a23c;
      cursor: pointer;
    }
  }
</style>
