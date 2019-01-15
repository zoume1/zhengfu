<template>
    <div class="mod-config">
        <tablefield  v-if="!isUpdate" :pathUrl="pathUrl" ref="tablefield" :formButton="formButton":dataForm.sync="dataForm"  :setListSelections="setListSelections" :saveForm="saveForm" :model="model" :operation.sync="operation" :updateDataFormSubmit="dataFormSubmits"></tablefield>
        <update ref="update" v-model="isUpdate"  :model="model" :pathUrl="pathUrl" ></update>
    </div>
</template>

<script>
  import API from "@/api"
    import tablefield from '@/components/generator/tablefield.vue'
    import update from './update.vue'
    export default {
        components: {
            tablefield,
          update
        },
        data () {
            return {
                fields:{},
                isUpdate:false,
                model: 'lp',
                pathUrl: 'lpchamberofcommerce',
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
                    remarks: '',
                    versionNo: '',
                    createBy: '',
                    createTime: '',
                    updateBy: '',
                    updateTime: '',
                    deleteFlag: '',
                    sort: '',
                    name: '',
                    sysUserId: '',
                    category: '',
                    grade: '',
                    standingDirectorSize: '',
                    directorSize: '',
                    memberSize: '',
                    viceChairmanSize: '',
                    secretarySize: '',
                    phone: '',
                    specialPlane: '',
                    eMail: '',
                    postcode: '',
                    creditCode: '',
                    website: '',
                    establishedTime: '',
                    groupAdministrativeRegion: '',
                    groupFox: '',
                    legalPerson: '',
                    chairmanName: '',
                    presidentName: '',
                    secretaryGeneralName: '',
                    contact: '',
                    personalCall: '',
                    address: '',
                    introduce: ''
        }
        }
        },
        methods: {
          fieldData(val){
            var fieldMap ={};
            for(var i in val){
              var item =val[i];
              fieldMap[item.fieldName]=item;
            }
            this.fields=fieldMap;
          },
            addAllOrUpdateHandle () {
                      this.$nextTick(() => {

                                 this.$refs.tablefield.addAllOrUpdateHandle()
                })
            },
            addOrUpdateHandle (row) {
                  this.isUpdate=true;
               this.$nextTick(() => {
                                 this.$refs.update.addOrUpdateHandle(row)
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
          dataFormSubmits(dataForm){
            var params = {
              user:{username:"12",password:"123465"},
              commerce:dataForm
            }
            Object.assign(params, dataForm)
            var tick = !this.dataForm.id ? API[this.pathUrl].add(params) : API[this.pathUrl].update(params)
            tick.then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false;
                    this.getDataList();
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
            }
        }
    }
</script>
