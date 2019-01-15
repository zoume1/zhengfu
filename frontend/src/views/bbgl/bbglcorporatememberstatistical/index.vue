<template>
    <div class="mod-config">
      <!--创建一个echarts的容器-->
      <div id="echartContainer2" style="width:100%; height:500px"></div>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>六盘水市场(包括下级组织)企业会员按地区注册类型统计表</span>
        </div>
        <div  class="text item">
          <el-table
            :data="tableData6"
            border
            height="500"
            :summary-method="getSummaries"
            show-summary
            style="width: 70%; margin-top: 20px;margin:0 auto;">
            <el-table-column
              type="index" label="序号">
            </el-table-column>
            <el-table-column
              prop="name"
              label="注册类型">
            </el-table-column>
            <el-table-column
              prop="count"
              label="数量">
            </el-table-column>
          </el-table>
        </div>
      </el-card>

    </div>
</template>
<script>
  import API from '@/api'
  import ECharts from 'vue-echarts/components/ECharts'
  // import ECharts modules manually to reduce bundle size
  import 'echarts/lib/chart/bar'
  import 'echarts/lib/component/tooltip'
  // register component to use
    export default {
        components: {
          "v-char":ECharts
        },
        data () {
          return {
            model: 'lp',
            pathUrl: 'lpuser',
            tableData6: []
          }
        },
      mounted() {
        API[this.pathUrl].memberStatistics({type:"1"}).then(({data}) => {
          var datas = this.genData(data.data);
          console.log(datas);
          this.tableData6=data.data;
          var echarts = require('echarts')
// 基于准备好的dom，初始化echarts实例
          var myChart = echarts.init(document.getElementById('echartContainer2'));
          myChart.setOption({
            title : {
              text: '六盘水市场(包括下级组织)企业会员按地区注册类型统计表',
              subtext: '网上工商联',
              x:'center'
            },
            tooltip : {
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
            series : [
              {
                name: '注册类型',
                type: 'pie',
                radius : '40%',
                center: ['50%', '60%'],
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
           genData(data) {
             var nameList = [
               '赵', '钱', '孙', '李', '周', '吴', '郑', '王', '冯', '陈', '褚', '卫', '蒋', '沈', '韩', '杨', '朱', '秦', '尤', '许', '何', '吕', '施', '张', '孔', '曹', '严', '华', '金', '魏', '陶', '姜', '戚', '谢', '邹', '喻', '柏', '水', '窦', '章', '云', '苏', '潘', '葛', '奚', '范', '彭', '郎', '鲁', '韦', '昌', '马', '苗', '凤', '花', '方', '俞', '任', '袁', '柳', '酆', '鲍', '史', '唐', '费', '廉', '岑', '薛', '雷', '贺', '倪', '汤', '滕', '殷', '罗', '毕', '郝', '邬', '安', '常', '乐', '于', '时', '傅', '皮', '卞', '齐', '康', '伍', '余', '元', '卜', '顾', '孟', '平', '黄', '和', '穆', '萧', '尹', '姚', '邵', '湛', '汪', '祁', '毛', '禹', '狄', '米', '贝', '明', '臧', '计', '伏', '成', '戴', '谈', '宋', '茅', '庞', '熊', '纪', '舒', '屈', '项', '祝', '董', '梁', '杜', '阮', '蓝', '闵', '席', '季', '麻', '强', '贾', '路', '娄', '危'
             ];
             var seriesData = [];
              var legendData = [];
             var selected = {};
           for(var i in data){
             var item = data[i];
             seriesData.push({name:item.name,value:item.count});
           }
          for(var i in data){
            var item = data[i];
            legendData.push(item.name)
          }



    // for (var i = 0; i < 50; i++) {
    //   name = Math.random() > 0.65
    //     ? makeWord(4, 1) + '·' + makeWord(3, 0)
    //     : makeWord(2, 1);
    //   legendData.push(name);
    //   seriesData.push({
    //     name: name,
    //     value: Math.round(Math.random() * 100000)
    //   });
    //   selected[name] = i < 6;
    // }

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
