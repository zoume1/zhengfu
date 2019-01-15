<template>
  <div class="table-container pull-chheight"id="update">
    <basic-container>
    <!--创建一个echarts的容器-->
    <el-form :inline="true" :model="formData" :rules="formRules" ref="dataForm" style="margin-bottom:60px;">
      <el-row :gutter="24">
        <el-col :lg="8">
          <el-form-item>
            <!--三四级联动-->
            <linkage    v-model="formData.address"  pageComment="企业地区"  :isPage="true" size="small"> </linkage>
          </el-form-item>
        </el-col>
        <el-col :lg="8">
          <el-form-item>
            <!--下拉选择-->
            <div  class="el-input el-input-group el-input-group--prepend el-input--suffix" >
              <div class="el-input-group__prepend">商会</div>
              <el-select clearable v-model="formData.coceralId" placeholder="商会" style="width:100%;" size="small">
                <el-option
                  v-for="(itemss,itemssIndex) in getBusConfig(model+pathUrl,'lp_chamber_of_commerce').list"
                  :key="itemssIndex"
                  :label="itemss.confName"
                  :value="itemss.confVue">
                </el-option>
              </el-select>
            </div>
          </el-form-item>
        </el-col>
        <el-col :lg="8">
          <el-form-item>
            <!--下拉选择-->
            <div  class="el-input el-input-group el-input-group--prepend el-input--suffix" >
              <div class="el-input-group__prepend">会员级别</div>
              <el-select clearable v-model="formData.userType" placeholder="会员级别" style="width:100%;" size="small">
                <el-option
                  v-for="(itemss,itemssIndex) in getBusConfig(model+pathUrl,'lp_user_user_type').list"
                  :key="itemssIndex"
                  :label="itemss.confName"
                  :value="itemss.confVue">
                </el-option>
              </el-select>
            </div>
          </el-form-item>
        </el-col>
        <el-col :lg="8">
          <el-form-item  prop="createTime">
            <!--时间选择框-->
            <div  class="el-input el-input-group el-input-group--prepend el-input--suffix" >
              <div class="el-input-group__prepend date">注册时间</div>
              <el-date-picker style="line-height: 18px;"
                              v-model="formData.createTime" value-format="yyyy-MM-dd"
                              type="daterange"
                              size="mini"
                              range-separator="至"
                              start-placeholder="开始日期"
                              end-placeholder="结束日期">
              </el-date-picker>
            </div>
          </el-form-item>
        </el-col>
        <el-col :lg="8">
          <el-form-item>
            <el-button type="primary"  size="small" @click="getDataList()">查询</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <div  >
      <h3 style="text-align: center;">六盘水市会员情况综合统计表</h3>
      <el-table
        :data="tableData6"
        border size="mini"
        height="500"
        show-summary
        style="width: 100%; margin-top: 20px;margin:0 auto;">
        <el-table-column
          type="index"
          label="序号">
        </el-table-column>
        <el-table-column
          prop="name"
          label="组织机构">
        </el-table-column>
        <el-table-column
          prop="startCount"
          :label="dateTitle[0]">
        </el-table-column>
        <el-table-column
          prop="endCount"
          :label="dateTitle[1]">
        </el-table-column>
        <el-table-column
          prop="count"
          :label="dateTitle[0]+'至'+dateTitle[1]">
        </el-table-column>
      </el-table>
    </div>
    </basic-container>
  </div>
</template>
<script>
  import API from '@/api'
  import linkage from '@/components/input/linkage.vue'
  import ECharts from 'vue-echarts/components/ECharts'
  import 'echarts/lib/chart/bar'
  import 'echarts/lib/component/tooltip'
  export default {
    components: {
      "v-char": ECharts,
      linkage
    },
    data() {
      return {
        formRules:{
          createTime:[
            { required: true, message: "注册时间不能为空", trigger: "blur" }
          ],

        },
        dateTitle:['',''],
        types:[
        ],
        formData:{
        },
        model: 'lp',
        pathUrl: 'lpuser',
        tableData6: [],
        colList:[],
        rowList: []
      }
    },
    mounted() {
      //this.getDataList();
    },
    methods: {
      getDataList(){
        this.$refs["dataForm"].validate(valid => {
          if (valid) {
            var par = {}
            Object.assign(par,this.formData);
            par.createTime=JSON.stringify(par.createTime);
            this.dateTitle[0]=this.formData.createTime[0]
            this.dateTitle[1]=this.formData.createTime[1]
            this.userType = this.formData.userType;
            API[this.pathUrl].growthStatements(par).then(({data}) => {
                this.tableData6 = data.data;
            });
          }});
      },
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
