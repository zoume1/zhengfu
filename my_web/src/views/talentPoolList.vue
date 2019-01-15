<template>
  <div>
    <Nav></Nav>
    <div class="content">
      <div class="contLeft">
        <list-left></list-left>
      </div>
      <div class="contRig">
        <div class="contMbx">
          <a>商会首页</a> > <a>人才库</a>
        </div>
        <div style="border: 1px solid #e4e4e4;margin-top:10px;">
          <div class="taleChoose">
            <el-form ref="form" :model="form" label-width="70px" size="mini" @keyup.enter.native="getList()">

              <el-row>
                <el-col :span="6">
                  <el-form-item label="行业">
                    <el-select v-model="form.text" placeholder="请选择" clearable>
                      <el-option :label="item.confName" :value="item.confVue" v-for="(item,index) in sysConfig['lp_talent_text'].list" :key="index"> </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>

                <el-col :span="6">
                  <el-form-item label="年龄范围">
                    <el-col :span="11">
                      <el-input v-model="form.age[0]"></el-input>
                    </el-col>
                    <el-col class="line" :span="2">-</el-col>
                    <el-col :span="11">
                      <el-input v-model="form.age[1]"></el-input>
                    </el-col>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="性别">
                    <el-select v-model="form.sex" placeholder="请选择" clearable>
                      <el-option :label="item.confName" :value="item.confVue" v-for="(item,index) in sysConfig['lp_talent_sex'].list" :key="index"> </el-option>
                    </el-select>
                  </el-form-item>

                </el-col>
                <el-col :span="6">
                  <el-button type="primary" @click="getList()">筛选</el-button>
                  <el-button type="primary" @click="goToUrl('/talentPoolApply')">申请加入人才库</el-button>
                </el-col>
              </el-row>
            </el-form>

          </div>
          <div class="imgCont">
            <ul>
              <li v-for="item in picData.list" @click="goToUrl('/talentPoolDetail',0,item)" >
                <img :src="item.pic" alt="">
                <p>行业：{{sysConfig['lp_talent_text'].map[item.text]}}</p>
                <p>姓名：{{item.name}}</p>
                <p>年龄：{{item.age}}</p>
                <p>性别：{{sysConfig['lp_talent_sex'].map[item.sex]}}</p>
              </li>
            </ul>


          </div>
          <div class="imgblock">
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="formData.page"
              :page-sizes="[10, 20, 50, 100]"
              :page-size="10"
              layout="total, sizes, prev, pager, next, jumper"
              :total="picData.totalCount">
            </el-pagination>
          </div>
        </div>
      </div>
    </div>
    <div style="position: relative;bottom: -730px;">
      <footer-nav></footer-nav>
    </div>
  </div>
</template>

<script>
  import Nav from '../components/Nav'
  import API from '@/api'
  import ListLeft from '../components/ListLeft';
  import footerNav from '../components/footer_nav'

  export default {
    name: 'talentPoolList',
    data () {
      return {
        picData: [
          {
            imgUrl: require('../assets/images/total1.png'),
            industry: '管理',
            name: '姜大明',
            age: '28',
            sex: '男'
          },
          {
            imgUrl: require('../assets/images/total1.png'),
            industry: '管理',
            name: '姜大明',
            age: '28',
            sex: '男'
          },
          {
            imgUrl: require('../assets/images/total1.png'),
            industry: '管理',
            name: '姜大明',
            age: '28',
            sex: '男'
          },
          {
            imgUrl: require('../assets/images/total1.png'),
            industry: '管理',
            name: '姜大明',
            age: '28',
            sex: '男'
          },
          {
            imgUrl: require('../assets/images/total1.png'),
            industry: '管理',
            name: '姜大明',
            age: '28',
            sex: '男'
          },
          {
            imgUrl: require('../assets/images/total1.png'),
            industry: '管理',
            name: '姜大明',
            age: '28',
            sex: '男'
          },
          {
            imgUrl: require('../assets/images/total1.png'),
            industry: '管理',
            name: '姜大明',
            age: '28',
            sex: '男'
          },
          {
            imgUrl: require('../assets/images/total1.png'),
            industry: '管理',
            name: '姜大明',
            age: '28',
            sex: '男'
          },
          {
            imgUrl: require('../assets/images/total1.png'),
            industry: '管理',
            name: '姜大明',
            age: '28',
            sex: '男'
          }
        ],
        currentPage4: 4,
        form: {
          page:1,
          limit:10,
          region: '',
          age: [0,100],
          sex:''
        },
        formData:{

        }
      }
    },
    mounted(){
      this.getList();
    },
    methods: {
      getList(){
        var par = {}
        Object.assign(par,this.form)
        par.age=JSON.stringify(par.age)

        API.lptalent.list(par).then(({data})=>{
          this.picData=data.data
        });
      },
      handleSizeChange (val) {
        this.formData.limit=val;
        this.getList();
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange (val) {
        this.formData.page=val;
        this.getList();
        console.log(`当前页: ${val}`);
      }
    },
    components: {
      ListLeft,
      Nav,
      footerNav
    }
  }
</script>

<style scoped>
  .content {
    width: 95%;
    margin: 0 auto;
    margin-top: 30px;
    display: flex;
    justify-content: space-between;
    /*align-items: center;*/
  }

  .contLeft {
    width: 22%;
    position: absolute;
    top: 530px;
  }


  .contRig {
    width: 72%;
    position: absolute;
    top: 530px;
    left: 26%;
    height: 1110px;
    overflow: scroll;
  }
  .contMbx {
    width: 100%;
    border-bottom: 2px solid #e4e4e4;
    padding: 8px 0;
  }

  .contMbx a {
    font-size: 16px;
  }

  .imgCont {
  }

  .imgCont ul {
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
  }

  .imgCont li {
    list-style: none;
    text-align: center;
    width: 29.3%;
    padding: 20px;
    box-sizing: border-box;
  }

  .imgCont li img {
    width: 100%;
    margin-bottom: 10px;
  }

  .imgCont li p {
    font-size: 16px;
    margin: 0;
    margin-bottom: 5px;

  }

  .imgblock {
    text-align: center;
    padding-top: 20px;
    padding-bottom: 20px;
    border-top: 1px solid #ccc
  }

  .taleChoose{
    padding:10px;
  }

  .taleChoose .el-button{
    padding: 5px 10px;
  }
</style>
