<template>
  <div>
    <div class="bannerMob">
      <el-carousel :interval="5000" arrow="always" height="180px">
        <el-carousel-item v-for="(item,index) in banner" :key="index">
          <img :src="item.pic" alt="">
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="homeNews">
      <ul>
        <li v-for="newsHome in homeNews">
          <div  @click="clickMenu(newsHome);">
            <img :src="newsHome.newsIcon" alt="">
            <p>{{newsHome.newsName}}</p>
          </div>
        </li>
      </ul>
    </div>
    <div class="homenewsList">
      <ul>
        <li v-for="newIn in homeNewsMsg">
          <router-link :to="'/newsDetailMob?id='+newIn.id">
            <img :src="newIn.pic" alt="">
            <div class="newsTxt">
              <h4>{{newIn.title}}</h4>
              <p  v-text="timeFormat(newIn.createTime)"></p>
            </div>
          </router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
  import API from "@/api"
  export default {
    name: 'HomeMob',
    data () {
      return {
        banner: [
          {img: require('../../assets/images/1.png')},
          {img: require('../../assets/images/2.png')},
          {img: require('../../assets/images/3.png')}
        ],
        homeNews: [
          {
            id:17,
            newsIcon: require('../../assets/images/h.png'),
            newsName: '领导班子'
          },
          {
            id:22,
            newsIcon: require('../../assets/images/e.png'),
            newsName: '新闻中心'
          },
          {
            id:11,
            newsIcon: require('../../assets/images/d.png'),
            newsName: '组织架构'
          },
          {
            id:24,
            newsIcon: require('../../assets/images/c.png'),
            newsName: '政策法规'
          },
          {
            id:14,
            newsIcon: require('../../assets/images/g.png'),
            newsName: '商会服务'
          },
        
          {
            id:15,
            newsIcon: require('../../assets/images/i.png'),
            newsName: '商会文化'
          },
          {
            id:30,
            newsIcon: require('../../assets/images/f.png'),
            newsName: '招商投资'
          },
          {
            id:33,
            newsIcon: require('../../assets/images/a.png'),
            newsName: '建党工作'
          },
          //  {
          //   id:1,
          //   newsIcon: require('../../assets/images/b.png'),
          //   newsName: '活动学习'
          // }
        ],
        homeNewsMsg: [
          // {
          //   newImg: require('../../assets/images/total1.png'),
          //   newsTit: '2018年公共机构节能宣传画',
          //   newsDate: '2018年11月11日'
          // },
          // {
          //   newImg: require('../../assets/images/total1.png'),
          //   newsTit: '2018年公共机构节能宣传画',
          //   newsDate: '2018年11月11日'
          // },
          // {
          //   newImg: require('../../assets/images/total1.png'),
          //   newsTit: '2018年公共机构节能宣传画',
          //   newsDate: '2018年11月11日'
          // },
          // {
          //   newImg: require('../../assets/images/total1.png'),
          //   newsTit: '2018年公共机构节能宣传画',
          //   newsDate: '2018年11月11日'
          // },
          // {
          //   newImg: require('../../assets/images/total1.png'),
          //   newsTit: '2018年公共机构节能宣传画',
          //   newsDate: '2018年11月11日'
          // }
        ]
      }
    },
    mounted(){
      this.getImgList();
      this.getArticle();
    },
    methods:{
      clickMenu(item){
        //缺少领导风采页面，缺少活动列表页面
        if(item.newsName=='领导风采'){
          this.goToUrl('/newsListMob');
        }else{
          this.goToUrl('/newsListMob',0,{id:item.id});
        }
      },
      //查询广告图片
      getImgList(){
        API.lpgzhadvertising.list({
          page:1,
          limit:10,
          type:"0",
          sidx:"createTime",
          order:"desc"
        }).then(({data})=>{
          this.banner=data.data.list;
           console.log(data.data.list);
        });
      },
      //查询文章列表
      getArticle(){
        API.lpgzharticle.list({
          page:1,
          limit:10,
          type:"0",
          sidx:"sort",
          order:"desc"
        }).then(({data})=>{
          this.homeNewsMsg=data.data.list;
        
        });
      }
    }

  }
</script>

<style scoped>
   body{
     background: #fff !important;
   }
  .el-carousel__container{
    height: 170px !important;
  }
  .bannerMob img {
    width: 100%;
    height:100%;
  }

  .homeNews ul{
    background: #fff;
    margin:0;
    padding:0;
    display: flex;
    align-content:center;
    flex-wrap: wrap
    
  }

  .homeNews{
    display: table;
    width: 100%;
  }

  .homeNews li{
        flex-basis: 25%;
    list-style: none;
    margin-top: 10px;
    margin-bottom: 10px;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    /* padding-left: 2.1rem; */
    text-align: center;
  }
  
  .homeNews li img{
    width: 50px;
  }

  .homeNews li a{
    text-decoration: none;
  }

  .homeNews p{
    font-size:14px;
    color:#000;
    margin:0;
  }
  .homenewsList{
    background: #fff;
  }
  .homenewsList ul {
    padding: 0;
    margin: 0;
    border-top: 2px solid #f1eded;
  }

  .homenewsList li {
   list-style: none;
    border-bottom: 8px solid #f7f5f5;
    box-sizing: border-box;

  }
  .newsTxt{
    width: 16rem;
  }
  .homenewsList li a{
  display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-pack: distribute;
    justify-content: space-between;
    text-decoration: none;
    color: #000;
    padding: 0.3rem 2.1rem;

  }

  .homenewsList li img {
    width: 30%;
    height: 100%;
  }

  .homenewsList h4 {
    margin: 0;
    margin-bottom: 10px;
    font-weight: normal;
    font-size: 16px;
  }

  .homenewsList p {
    font-size: 12px;
    color: #C8C8CD;
  }
</style>
