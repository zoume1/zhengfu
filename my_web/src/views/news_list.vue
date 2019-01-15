<template>
  <div>
    <Nav></Nav>
    <div class="content">
      <div class="contLeft">
        <list-left></list-left>
      </div>
      <div class="contRig">
        <div class="contMbx">
          <a>{{query.itemName}}</a> > <a>{{query.objName}}</a>
        </div>
        <div style="border: 1px solid #e4e4e4;margin-top:10px;">
          <div class="newsList">
            <ul>
              <li v-for="item in newsData.list" @click="info(query,item)">
                <p>{{item.title}}</p>
                <span>{{item.createTime}}</span>
              </li>
            </ul>
          </div>
          <div class="imgblock">
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="newsData.totalCount"
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
    name: 'news_list',
    data () {
      return {
        newsData: {
          list:[]
        },
        currentPage4: 4,
        query:{},
        par : {
          page:1,
          limit:10,
        }
      }
    },
    mounted(){
      this.query= this.$route.query;
      this.par. columnId=this.query.columnId
      this.getList();
    },
    watch: {
      // 方法1
      '$route' (to, from) {
        this.query = to.query;
        this.par. columnId=this.query.columnId
        this.getList();
      }
    },
    methods: {
      info(query,item){
        if(item.type=='0'){
          this.goToUrl('/news_detail',0,{itemName:query.itemName,objName:query.objName,title:item.title,id:item.id,columnId:query.columnId});
        }else if(item.type=='1'){
          if(item.accessory!=null && item.accessory!=''){
            var obj=JSON.parse(item.accessory);
            location.href=obj[0].url;
          }
        }
      },
      getList(){
        API.lparticle.list(this.par).then(({data})=>{
          this.newsData=data.data;
        });
      },
      handleSizeChange (val) {
        this.par.limit=val;
        console.log(`每页 ${val} 条`);
        this.getList();
      },
      handleCurrentChange (val) {
        this.par.page=val;
        console.log(`当前页: ${val}`);
        this.getList();
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
