<template>
  <div>
    <Nav></Nav>
    <div class="content">
      <div class="contLeft">
        <list-left></list-left>
      </div>
      <div class="contRig">
        <div class="contMbx">
          <a>商会首页</a> > <a>活动报名列表</a>
        </div>
        <div style="border: 1px solid #e4e4e4;margin-top:10px;">
          <div class="newsList">
            <ul>
              <li v-for="item in newsData.list" @click="goToUrl('/activitySignUp',0,item)">
                <p>{{item.name}}</p>
                <span>{{item.applyStartTime}}</span>
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
              :total="newsData.totalCount">
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
    name: 'activityList',
    data () {
      return {
        newsData: {},
        formData:{
          page:1,
          limit:10
        },
      }
    },
    mounted(){
      this.getList();


    },
    methods: {
      getList(){
        var that = this;
        API.lpactivity.list(this.formData).then(({data})=>{
          that.newsData=data.data;
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
  }

  .contMbx {
    width: 100%;
    border-bottom: 2px solid #e4e4e4;
    padding: 8px 0;
  }

  .contMbx a {
    font-size: 16px;
  }

  .imgblock {
    text-align: center;
    padding-top: 20px;
    padding-bottom: 20px;
    border-top: 1px solid #ccc
  }

  .newsList {
    display: table;
    width: 100%;
    padding: 10px;
    box-sizing: border-box;
  }

  .newsList ul {
    margin: 0;
    padding: 0;
  }

  .newsList li {
    font-size: 13px;
    list-style: none;
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: 1px dashed #e4e4e4;
    cursor: pointer;
  }

  .imgblock {
    text-align: center;
    padding-top: 20px;
    padding-bottom: 20px;
    border-top: 1px solid #ccc
  }
</style>
