<template>
    <div class="mod-config">
        <tablefield :pathUrl="pathUrl" ref="tablefield" :dataFormDisabled="dataFormDisabled" :formButton="formButton":dataForm.sync="dataForm"  :setListSelections="setListSelections" :saveForm="saveForm" :model="model" :operation.sync="operation"></tablefield>
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
              dataFormDisabled:{
                //上传附件必须为上传表格类型
                accessory:function(data){
                  return data.type=='1';
                },
                //上传文章必须为文章类型
                center:function(data){
                  return data.type=='0';
                },
              },
                model: 'lp',
                pathUrl: 'lparticle',
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
                    title: '',
                    type: '',
                    state: '',
                    columnId: '',
                    source: '',
                    author: '',
                    center: ''
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
