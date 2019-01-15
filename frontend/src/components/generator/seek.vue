<template>
  <div style="margin-top:10px;" id="update">
    <el-row :gutter="24">
      <el-col :lg="8" v-for="(item,index) in tableFieldMap.columns" v-if="item.isSeek=='0'" :key="index">
        <el-form-item  >
          <!--时间选择框-->
          <div v-if="item.inputType=='2'|| item.inputType=='3'" class="el-input el-input-group el-input-group--prepend el-input--suffix" >
            <div class="el-input-group__prepend date">{{item.pageComment}}</div>
            <el-date-picker style="line-height: 18px;"
                            v-model="data[item.fieldName]" value-format="yyyy-MM-dd"
                            type="daterange"
                            size="mini"
                            range-separator="至"
                            start-placeholder="开始日期"
                            end-placeholder="结束日期">
            </el-date-picker>
          </div>
          <!--三四级联动-->
          <linkage     v-else-if="item.inputType=='11'|| item.inputType=='12'"  :level="item.inputType=='11'?4:3" :pageComment="item.pageComment"v-model="data[item.fieldName]"  :isPage="true" size="small"> </linkage>
          <!--下拉选择-->
          <div v-else-if="item.inputType=='4' || item.inputType=='5' || item.inputType=='17'" class="el-input el-input-group el-input-group--prepend el-input--suffix" >
            <div class="el-input-group__prepend">{{item.pageComment}}</div>
            <el-select clearable v-model="data[item.fieldName]" :placeholder="item.pageComment" style="width:100%;" size="small">
              <el-option
                v-for="(itemss,itemssIndex) in getBusConfig(model+pathUrl,item.dictionaryIndex).list"
                :key="itemssIndex"
                :label="itemss.confName"
                :value="itemss.confVue">
              </el-option>
            </el-select>
          </div>
          <!--普通输入框-->
          <el-input v-model="data[item.fieldName]" :content="item.pageComment" :placeholder="item.pageComment" clearable size="small"v-else>
            <template slot="prepend">{{item.pageComment}}</template>
          </el-input>
        </el-form-item>
      </el-col>

    </el-row>

  </div>
</template>

<script>
  import linkage from '@/components/input/linkage.vue'
  export default {
    name: 'seek',
    data() {
      return {
          data:this.value
      }
    },
    components:{
      linkage
    },
    watch:{
      data:{
        handler: function (seekData) {
          console.log(seekData);
          this.$emit('input', seekData)
        },
        deep: true    //深度监听
      },
      value:function (val) {
        this.data=val;
      },
    },
    props: {
      // 使用v-module必须要使用value
      value: {
        default: '',
      },
      pathUrl: {
        type: String
      },
      model: {
        type: String
      },
      tableFieldMap: {
        type:Object
      },
    },
    methods:{

    }
  }
</script>

<style scoped>
  i.el-input__icon.el-range__icon.el-icon-date {
    padding-top: 4px;
  }
  #update >>> .el-form-item{
    justify-content: center;
    display: flex;
  }
  #update >>> .el-form-item__content{
    width: 189%;
  }

  #update >>> .el-form-item {
    margin-bottom: 10px;
  }
</style>
