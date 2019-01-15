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
      <el-table
        :span-method="objectSpanMethod"
        :data="tableData6" size="mini"
        border
        height="1000"
        show-summary
        style="width: 100%; margin-top: 20px;margin:0 auto;">
        <el-table-column
          type="index" label="序号" width="60px">
        </el-table-column>
        <el-table-column
          prop="userType"
          label="数据项目名">
        </el-table-column>
        <el-table-column
          prop="name"
          label="个人会员分类">
        </el-table-column>
        <el-table-column
          prop="count"
          label="数量">
        </el-table-column>
      </el-table>
    </div>
    <div v-else >
      <div id="echartContainer2" style="width:100%; height:800px" ></div>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>六盘水市场(包括下级组织)</span>
        </div>
        <div class="text item">
          <el-table
            :span-method="objectSpanMethod"
            :data="tableData6"
            border
            height="500"
            show-summary
            style="width: 100%; margin-top: 20px;margin:0 auto;">
            <el-table-column
              type="index" label="序号" width="60px">
            </el-table-column>
            <el-table-column
              prop="name"
              label="分类名称">
            </el-table-column>
            <el-table-column
              prop="count"
              label="数量">
            </el-table-column>
          </el-table>
        </div>
      </el-card>
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
        rowList: []
      }
    },
    mounted() {
   this.getDataList();

    },
    methods: {
      getSummaries(param) {
        const {columns, data} = param;
        const sums = [];
        columns.forEach((column, index) => {
          if (index === 0) {
            sums[index] = '总价';
            return;
          }
          const values = data.map(item => Number(item[column.property]));
          if (!values.every(value => isNaN(value))) {
            sums[index] = values.reduce((prev, curr) => {
              const value = Number(curr);
              if (!isNaN(value)) {
                return prev + curr;
              } else {
                return prev;
              }
            }, 0);
            sums[index] += ' 元';
          } else {
            sums[index] = 'N/A';
          }
        })
      },
      getDataList(){
        this.type=this.formData.type;
        API[this.pathUrl].memberStatistics(this.formData).then(({data}) => {
          var datas = this.genData(data.data);
          var list = [];
          if(this.type==0){
            for (var i in data.data) {
              var item = data.data[i];
              //如果没有初始值则赋值
              if(list[i]==undefined){
                list.push({rowspan: 0, colspan: 1})
                //第一行不判断
                for (var j in data.data) {
                  var item1 = data.data[j];
                  if (item.userType === item1.userType) {
                    if(list[j]==undefined){
                      list.push({rowspan: 0, colspan: 1})
                    }
                    list[i].rowspan++
                  }
                }
              }
            }
          }

          this.rowList = list;
          this.tableData6 = data.data;
          var echarts = require('echarts')
// 基于准备好的dom，初始化echarts实例
          var myChart = echarts.init(document.getElementById('echartContainer2'));
          var title=null;
          if(this.type==='0'){
            title='会员情况综合统计表'
          }else if(this.type==='1'){
            title='企业会员按地区行业统计表'
          }else if(this.type==='2'){
            title='企业会员按地区注册类型统计表'
          }else if(this.type==='3'){
            title='团体会员统计表'
          }else if(this.type==='4'){
            title='个人会员统计表'
          }
          myChart.setOption({
            title: {
             text: '六盘水市（包括下级组织）'+title,
             subtext: '网上工商联',
              x: 'center',
            },
            tooltip: {
              trigger: 'item',
              formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
              type: 'scroll',
              orient: 'vertical',
              left: 10,
              top: 20,
              bottom: 20,
              data: datas.legendData,

              selected: datas.selected
            },
            series: [
              {
               name: '',
                type: 'pie',
                radius: '60%',
                center: ['50%', '66%'],
                data: datas.seriesData,
                itemStyle: {
                  emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                  }
                }
              }
            ]
          });
        })
      },
      objectSpanMethod({row, column, rowIndex, columnIndex}) {
        //判断是第一纵列
        if (columnIndex === 1) {
          //如果数据行数能整除以2就能与上合并
          if (this.rowList[rowIndex] != undefined) ;
          return this.rowList[rowIndex];
        } else {
          return {
            rowspan: 1,
            colspan: 1
          };
        }
      },

      genData(data) {
        var nameList = [
          '赵', '钱', '孙', '李', '周', '吴', '郑', '王', '冯', '陈', '褚', '卫', '蒋', '沈', '韩', '杨', '朱', '秦', '尤', '许', '何', '吕', '施', '张', '孔', '曹', '严', '华', '金', '魏', '陶', '姜', '戚', '谢', '邹', '喻', '柏', '水', '窦', '章', '云', '苏', '潘', '葛', '奚', '范', '彭', '郎', '鲁', '韦', '昌', '马', '苗', '凤', '花', '方', '俞', '任', '袁', '柳', '酆', '鲍', '史', '唐', '费', '廉', '岑', '薛', '雷', '贺', '倪', '汤', '滕', '殷', '罗', '毕', '郝', '邬', '安', '常', '乐', '于', '时', '傅', '皮', '卞', '齐', '康', '伍', '余', '元', '卜', '顾', '孟', '平', '黄', '和', '穆', '萧', '尹', '姚', '邵', '湛', '汪', '祁', '毛', '禹', '狄', '米', '贝', '明', '臧', '计', '伏', '成', '戴', '谈', '宋', '茅', '庞', '熊', '纪', '舒', '屈', '项', '祝', '董', '梁', '杜', '阮', '蓝', '闵', '席', '季', '麻', '强', '贾', '路', '娄', '危'
        ];
        var seriesData = [];
        var legendData = [];
        var selected = {};
        for (var i in data) {
          var item = data[i];
          seriesData.push({name: item.name, value: item.count});
        }
        for (var i in data) {
          var item = data[i];
          legendData.push(item.name)
        }

        return {
          legendData: legendData,
          seriesData: seriesData,
          selected: selected
        };

        function makeWord(max, min) {
          var nameLen = Math.ceil(Math.random() * max + min);
          var name = [];
          for (var i = 0; i < nameLen; i++) {
            name.push(nameList[Math.round(Math.random() * nameList.length - 1)]);
          }
          return name.join('');
        }
      }
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
