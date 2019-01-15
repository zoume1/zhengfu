<template>
    <div class="table-container pull-chheight"id="update">
      <basic-container>
    <!--创建一个echarts的容器-->
    <el-form :inline="true"  style="margin-bottom:60px;">
    <el-row :gutter="24">
      <el-col :lg="6">
        <el-form-item>
        <!--三四级联动-->
        <linkage    v-model="formData.address"  pageComment="企业地区"  :isPage="true" size="small"> </linkage>
        </el-form-item>
      </el-col>
      <el-col :lg="6">
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
      <el-col :lg="6">
        <el-form-item>
        <div  class="el-input el-input-group el-input-group--prepend el-input--suffix" >
          <div class="el-input-group__prepend">统计类型</div>
          <el-select v-model="formData.type"   placeholder="统计类型" style="width:100%;" size="small">
            <el-option
              label="会员情况综合统计表"
              value="0">
            </el-option>
            <el-option
              label="企业会员按地区行业统计表"
              value="1">
            </el-option>
            <el-option
              label="企业会员按地区注册类型统计表"
              value="2">
            </el-option>
            <el-option
              label="团体会员统计表"
              value="3">
            </el-option>
            <el-option
              label="个人会员统计表"
              value="4">
            </el-option>
            <el-option
              label="会员类型及行业统计表(本级)"
              value="5">
            </el-option>
            <el-option
              label="会员类型及行业统计表(合计)"
              value="6">
            </el-option>
          </el-select>
        </div>
        </el-form-item>
      </el-col>
      <el-col :lg="6">
        <el-form-item>
          <el-button type="primary"  size="small" @click="getDataList()">查询</el-button>
        </el-form-item>
      </el-col>
    </el-row>
    </el-form>
    <div v-if="type=='0'">
      <h3 style="text-align: center;">六盘水市会员情况综合统计表</h3>
      <el-table
        :span-method="objectSpanMethod"
        :data="tableData6" size="mini"
        border
        height="1000"
        show-summary
        style="width: 100%; margin-top: 20px;margin:0 auto;">
        <!--<el-table-column
          type="index" label="序号" width="60px">
        </el-table-column>-->
        <el-table-column
          prop="userType" align="center"
          label="组织机构">
        </el-table-column>
        <el-table-column
          prop="userType" align="center"
          label="小计">
        </el-table-column>
        <el-table-column align="center"
          prop="userType"
          label="县级县以下会员数">
        </el-table-column>
        <el-table-column align="center"
          prop="userType"
          label="企业会员数小计">
        </el-table-column>
        <el-table-column label="其中" align="center">
          <el-table-column label="私营" align="center">
          </el-table-column>
          <el-table-column label="混合型" align="center">
          </el-table-column>
        </el-table-column>
        <el-table-column align="center"
          prop="name"
          label="团体会员小计">
        </el-table-column>
        <el-table-column label="其中" align="center">
          <el-table-column label="行业商会" align="center">
          </el-table-column>
          <el-table-column label="个人协会" align="center">
          </el-table-column>
        </el-table-column>
        <el-table-column align="center"
                         prop="name"
                         label="个人会员小计">
        </el-table-column>
        <el-table-column label="其中" align="center">
          <el-table-column label="个体工商户" align="center">
          </el-table-column>
          <el-table-column label="原工商业者" align="center">
          </el-table-column>
        </el-table-column>
      </el-table>
    </div>
    <div v-else >
          <el-table
            :data="tableData6"
            border size="mini"
            height="500"
            show-summary
            style="width: 100%; margin-top: 20px;margin:0 auto;">
            <el-table-column
              prop="name"
              label="组织机构">
            </el-table-column>
            <el-table-column
              prop="count"
              label="小计">
            </el-table-column>
            <el-table-column v-for="(item,index) in colList" :key="index"
              :prop="item.confCode+item.confVue"
              :label="item.confName">
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
        type:"0",
        types:[
        ],
        formData:{
          type:"0"
        },
        model: 'lp',
        pathUrl: 'lpuser',
        tableData6: [],
        colList:[],
        rowList: []
      }
    },
    mounted() {
      this.getDataList();
    },
    methods: {
      getDataList(){
        this.type=this.formData.type;
        API[this.pathUrl].informationReport(this.formData).then(({data}) => {
         if(this.type=="0"){

         }else{
           this.colList=data.data.list;
           this.tableData6=data.data.data;
         }
        });
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
