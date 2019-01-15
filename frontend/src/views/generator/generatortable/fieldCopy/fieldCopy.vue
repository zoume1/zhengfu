<template>
    <el-dialog title="字段拷贝"  :visible.sync="fieldCopy"  width="75%"  >
  <div style="text-align: center" id="fieldCopy">
    <el-transfer
      :filter-method="filterMethod"
      filter-placeholder="请输入字段注释"
      style="text-align: left; display: inline-block"
      v-model="value4"
      filterable
      :left-default-checked="[]"
      :right-default-checked="[]"
      :titles="titles"
      :button-texts="['到左边', '到右边']"
      :format="{
        noChecked: '${total}',
        hasChecked: '${checked}/${total}'
      }"
      :data="data">
      <span slot-scope="{ option }">{{ option.key }} - {{ option.label }}</span>
     <!-- <el-button class="transfer-footer" slot="left-footer" size="small">操作</el-button>
      <el-button class="transfer-footer" slot="right-footer" size="small">操作</el-button>-->
    </el-transfer>

  </div>
    <div style="text-align: center;padding:20px;">
      <el-button type="primary"  class="transfer-footer" :disabled="value4.length==0" slot="left-footer" size="medium " @click="sub()">立即拷贝</el-button>
      <el-button type="primary"  class="transfer-footer" slot="right-footer" size="medium " @click="interchanger()">交换拷贝源</el-button>
    </div>
    </el-dialog>
</template>

<style>
  .transfer-footer {
    margin-left: 20px;
    padding: 6px 5px;
  }
</style>

<script>
  import API from "@/api";
  export default {
    data() {
      const generateData = _ => {
        const data = [];
        return data;
      };
      return {
        fieldCopy:false,
        leftId:null,
        rightId:null,
        titles:[],
        data: [],
        value4: [],
        renderFunc(h, option) {
          return "<span>{ option.key } - { option.label }</span>";
        }
      };
    },
    created(){

    },
    methods: {
      filterMethod(query, item) {
        return item.label.indexOf(query) > -1;
      },
      init(leftId,rightId){
        this.value4=[];
        this. fieldCopy=true;
        this.leftId=leftId;
        this.rightId=rightId;
        this.titles=[leftId.tableName,rightId.tableName]
        this
        var datas=[];
        API.generatortable.fieldCopyConfig({leftId:this.leftId.id,rightId:this.rightId.id}).then(({data})=>{
          for (let i in data.data) {
            var item = data.data[i];
            datas.push({
              key: item.id,
              label: item.fieldName+"("+item.comment+")",
              disabled: false
            });
            this.data=datas;
          }
        })
      },
      interchanger(){
        this.init(this.rightId,this.leftId);
      },
      sub(){
        API.generatortable.fieldCopyRun({id:this.rightId.id,ids:JSON.stringify(this.value4)}).then(({data})=>{
          if (data && data.code === 0) {
            this.$message({
              message: '操作成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.fieldCopy=false;
                this.$emit('refreshDataList')
              }
            })
          } else {
            this.$message.error(data.msg)
          }
        })
      }
    }
  };
</script>
<style scoped>
  #fieldCopy >>> .el-transfer-panel{
    width: 40%;
  }
  #fieldCopy>>>.el-transfer {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
</style>
