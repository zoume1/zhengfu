<template>
  <div>
    <Nav></Nav>
    <div class="content">
      <div class="contLeft">
        <list-left></list-left>
      </div>
      <div class="contRig">
        <div class="contMbx">
          <a v-text="query.itemName"></a> > <a v-text="query.objName">领导风采</a>
        </div>
        <div style="border: 1px solid #e4e4e4;margin-top:10px;">
          <div class="imgCont">
            <ul>
              <li v-for="item in picData.list">
                <img :src="item.pic" alt="">
                <p>{{item.name}}</p>
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
    name: 'img_list',
    data () {
      return {
        picData: {},
        formData:{
          page:1,
          limit:10
        },
        query:{}
      }

    },
    watch: {
      // 方法1
      '$route' (to, from) {
        this.query = to.query;
        this.getList();
      }
    },
    mounted(){
      this.query=this.$route.query
      this.getList();
    },
    methods: {
      getList(){
        var that = this;
        var type =null
        var list = this.sysConfig['lp_image_type'].list;
        for(var i in list){
          var item =list[i]
          if(item.confName===this.query.objName){
            type=item.confVue
          }
        }
        this.formData.type=type;
        API.lpimage.list(this.formData).then(({data})=>{
          that.picData=data.data;
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
    padding: 10px;
  }

  .imgCont li img {
    width: 100%;
  }

  .imgCont li p {
    font-size: 16px;
  }

  .imgblock {
    text-align: center;
    padding-top: 20px;
    padding-bottom: 20px;
    border-top: 1px solid #ccc
  }
</style>
