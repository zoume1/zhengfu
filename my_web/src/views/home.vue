<template>
  <div id="page" style="background: #f7f5f6;">
    <Nav></Nav>
    <!--<div>-->
    <!--<el-row :gutter="0">-->
    <!--<el-carousel trigger="click" height="350px">-->
    <!--<el-carousel-item v-for="(item,index) in dataimg" :key="index">-->
    <!--<div class="banner_img" style="height:350px;">-->
    <!--<img :src="item.pic"/>-->
    <!--</div>-->
    <!--</el-carousel-item>-->
    <!--</el-carousel>-->
    <!--</el-row>-->
    <!--</div>-->
    <div style="    " class="bodyCenter">
      <div class="newsRow" style="display: flex;justify-content: space-between;width:95%;margin:0 auto;">
        <div class="newsTwo" style="width:26%;">
          <div class="newsOneHeader">
            <img src="../assets/images/u42.png"/>
          </div>
          <el-carousel :interval="5000000" style="width:100%;    height: 88%;" indicator-position="none">
            <el-carousel-item v-for="(leader,index) in leaderImgs" :key="index" style="    display: flex;
    width: 100%;
    justify-content: space-between;">
              <div style="width: 100%;height: 100%;display: flex;flex-direction: column;align-items: center;">
                <div style="width: 100%;height:230px;display: flex;flex-direction: row;align-items: center">
                  <div class="newOneBodyIn" style="height: 14rem;"><img :src="leader.pic"/></div>
                  <div class="newOneBodyIn" style="padding:10px">
                    <p class="re-class">{{leader.remarks}}</p>
                  </div>
                </div>
                <div class="newHeadText">
                  姓名:{{leader.name}}
                </div>
                <div class="newHeadText newHeadTexts">
                   六盘水工商业联合会成立于2002年，简称六盘水市工商联，又称六盘水市总商会。工商联是党和政府联系非公有制经济人士的桥梁纽带，是政府管理和服务非公有制经济的助手，是中国人民政治协商会议的重要组成部分。
                </div>
              </div>

            </el-carousel-item>
          </el-carousel>
          <!--<el-row>-->
          <!--<el-col :lg="8" v-for="(leader,index) in leaderImgs" :key="index" style="overflow: hidden;-->
          <!--text-overflow: ellipsis;-->

          <!--white-space: nowrap;text-align: center">{{leader.name}}-->
          <!--</el-col>-->
          <!--</el-row>-->
        </div>

        <div class="newsTwo" :style="[{width:myindex===0 ? '52%' : '20%'}]" v-for="(item,myindex) in dataList[0]">
          <div class="newsOneHeader"
               @click=" goToUrl('/news_list',0,{itemName:item.parentName,objName:item.name,columnId:item.id});">
            <img v-show="myindex===0" src="../assets/images/u44.png"/>
            <img v-show="myindex===1" src="../assets/images/u162.png"/>
            <p style="width: 100%;text-align: right">更多>></p>
          </div>
          <div class="newsTwoBody">
            <div v-for="(obj,index) in item.list" :key="index" class="newsMsgWith"
                 @click="goToUrl('/news_detail',0,{itemName:item.name,objName:item.parentName,title:obj.title,id:obj.id})">
              <p>{{obj.title}}</p>
              <span v-text="timeFormat(obj.createTime)"></span>
            </div>
          </div>
          <div>
          </div>
        </div>
      </div>
      <!--图库展示区域-->
      <div class="imgAllIn">
        <div class="imgNeedIn"
             style="display: flex;justify-content: space-between;width:95%;margin:0 auto;    flex-direction: row;">
          <div class="myImgshow">
            <img src="../assets/images/u48.png"/>
          </div>
          <fly :list="list"></fly>
        </div>
      </div>

      <div class="newsRowMiddle" style="display: flex;justify-content: space-between;width:95%;margin:0 auto;">
        <!--   <div class="newsMiddleIn" >
             <div class="newsOneHeader">
               <p>组织机构</p>
               <span>morre></span>
             </div>
             <div class="newsTwoBody">
               <div v-for="(leader,index) in 7" :key="index" class="newsMsgWith">
                 .
                 <p :value="leader">关于六盘水市工商联通知</p>
                 <span>2018-08-08</span>
               </div>
             </div>
           </div>-->
        <div class="newsMiddleOn" v-for="(item,myindex) in dataList[1]">
          <div class="newsOneHeader"
               @click=" goToUrl('/news_list',0,{itemName:item.parentName,objName:item.name,columnId:item.id});">
      
            <img v-show="myindex===0" src="../assets/images/u152.png"/>
            <img v-show="myindex===1" src="../assets/images/u148.png"/>
            <img v-show="myindex===2" src="../assets/images/u145.png"/>
            <p style="width: 100%;text-align: right">更多>></p>
          </div>
          <div class="newsTwoBody">
            <div v-for="(obj,index) in item.list" :key="index" class="newsMsgWith"
                 @click="goToUrl('/news_detail',0,{itemName:item.name,objName:item.parentName,title:obj.title,id:obj.id})">
              <p>{{obj.title}}</p>
              <span v-text="timeFormat(obj.createTime)"></span>
            </div>
          </div>
        </div>
        <!-- <div class="newsMiddleIn">
           <div class="newsOneHeader">
             <p>组织机构</p>
             <span>morre></span>
           </div>
           </div>
           <div class="newsTwoBody">
             <div v-for="(leader,index) in 7" :key="index" class="newsMsgWith">
               .
               <p :value="leader">关于六盘水市工商联通知</p>
               <span>2018-08-08</span>
             </div>
           </div>
         </div>-->
      </div>
      <!--第三排文章-->
      <div class="newsRowMiddle" style="display: flex;justify-content: space-between;width:95%;margin:0 auto;">
        <div class="newsMiddleOn" v-for="(item,myindex) in dataList[2]">
          <div class="newsOneHeader"
               @click=" goToUrl('/news_list',0,{itemName:item.parentName,objName:item.name,columnId:item.id});">
            <img v-show="myindex===0" src="../assets/images/u150.png"/>
            <img v-show="myindex===1" src="../assets/images/u146.png"/>
            <img v-show="myindex===2" src="../assets/images/u72.png"/>
            <p style="width: 100%;text-align: right">更多>></p>
          </div>
          <div class="newsTwoBody">
            <div v-for="(obj,index) in item.list" :key="index" class="newsMsgWith"
                 @click="goToUrl('/news_detail',0,{itemName:item.name,objName:item.parentName,title:obj.title,id:obj.id})">
              <p>{{obj.title}}</p>
              <span v-text="timeFormat(obj.createTime)"></span>
            </div>
          </div>
        </div>
        <!--    <div class="newsMiddleOn">
              <div class="newsOneHeader">
                <p>组织机构</p>
                <span>morre></span>
              </div>
              <div class="newsTwoBody">
                <div v-for="(leader,index) in 7" :key="index" class="newsMsgWith">
                  .
                  <p :value="leader">关于六盘水市工商联通知</p>
                  <span>2018-08-08</span>
                </div>
              </div>
            </div>-->
        <!-- <div class="newsMiddleIn">
           <div class="newsOneHeader">
             <p>组织机构</p>
             <span>morre></span>
           </div>
           <div class="newsTwoBody">
             <div v-for="(leader,index) in 7" :key="index" class="newsMsgWith">
               .
               <p :value="leader">关于六盘水市工商联通知</p>
               <span>2018-08-08</span>
             </div>
           </div>
         </div>-->
      </div>
      <div style="width: 100%;height: 100%;display: flex;align-items: center;justify-content: center">
        <div class="endLongImg">
          <img src="../assets/images/WechatIMG50.png"/>
        </div>
      </div>
      <div style="width: 100%;height: 100%;display: flex;align-items: center;justify-content: center">
        <div class="endLongImgEnd" style="background-image: url('http://image.lpsgsl.com/dibu.png');    background-size: 100% 100%;
    background-repeat: no-repeat;">
        </div>
      </div>
      <footer_nav></footer_nav>
    </div>
  </div>
</template>

<script>
  import Nav from '../components/Nav'
  import API from '@/api'
  import {Message} from 'element-ui'
  import footer_nav from '../components/footer_nav'
  import fly from '../components/fly'

  export default {
    name: 'home',

    components: {
      Nav,
      API,
      Message,
      footer_nav,
      fly
    },
    data() {
      return {
        dataimg: [],
        dataList: [],
        list: [],
        leaderImgs: []
      }
    },
    computed: {},
    mounted() {
      var that = this
      that.getNewsImg()
      that.getBussniesNews()
      this.getLpadvertising();
    },
    methods: {
      getLpadvertising() {
        var that = this;
        API.lpadvertising.list({
          page: 1,
          limit: 10,
          type: "1"
        }).then(({data}) => {
          that.list = data.data
        });
        API.lpadvertising.list({
          page: 1,
          limit: 10,
          type: "0"
        }).then(({data}) => {
          that.dataimg = data.data
        });
      },
      // 获取领导风采
      getNewsImg() {
        var that = this
        var params = {
          page: 1,
          limit: 6,
          type: 1
        }
        API.lpimage.list(params).then(({data}) => {
          that.leaderImgs = data.data.list
        
        })
      },
      getBussniesNews() {
        var that = this

        var params = {
          page: 1,
          limit: 9,
          type: 1
        }

        API.lparticle.searchHomeArticles().then(({data}) => {
          console.log(data.data);
          that.dataList = data.data;
        })
      }
    },
    watch: {}
  }
</script>

<style scoped>
  .el-carousel__container {
    height: 180px !important;
  }
  .smallMenu{
    cursor: pointer;
  }
  .showUrl{
    cursor: pointer;
  }
  a{
    cursor: pointer;
  }
  .banner_img {
    width: 100%;
    height: 350px;
  }

  .banner_img img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  .newsRow {
    width: 100%;
    height: 30rem;
    display: flex;
    flex-direction: row;
    justify-content: center;
    padding-top: 20px;
  }

  .newsOne {
    width: 25%;
    height: 100%;
    border: 1px solid #e4e4e4;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .newsTwo {

    height: 100%;
    display: flex;
    border: 1px solid #e4e4e4;
    align-items: center;
    /*justify-content: center;*/
    flex-direction: column;
  }

  .newsThree {
    width: 25%;
    height: 100%;
    border: 1px solid #e4e4e4;
    align-items: center;
    display: flex;
    justify-content: center;
    flex-direction: column;
  }

  .newsOneHeader {
    width: 95%;
    height: 4rem;
    display: flex;
    flex-direction: row;
    align-items: center;
    border-bottom: 1px solid #e4e4e4;
    cursor: pointer;
  }

  .newsOneHeader img {
    position: absolute;
    margin-top: 7px;
  }

  .newsOneHeader span {
    text-align: center;
    text-indent: 60px;
    line-height: 50px;
    width: 190px;
    height: 58px;
    justify-content: flex-start;
    font-weight: 500;
    color: #e4e4e4;
    font-size: 20px;
    background-repeat: no-repeat;
    background-image: url("../assets/images/myBack.png");
  }

  .newsOneBody {
    width: 95%;
    height: 10rem;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    border-bottom: 2px solid #e4e4e4;
  }

  .newOneBodyIn {
    width: 50%;
    height: 8rem;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .newOneBodyIn img {
    width: 170px;
    height: 200px;
    object-fit: cover;
  }

  .newOneBodyIn p {
    margin: 0 0;
    font-size: 20px;
    overflow: hidden;
    color: #4781c3;
    padding-left: 5px;
  }

  .newsOneEnd {
    width: 115%;
    height: 5rem;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    flex-wrap: wrap;
  }

  .newsOneEnd p {
    width: 30%;
    font-size: 16px;
    text-align: center;
  }

  .newsTwoBody {
    width: 95%;
    height: 15rem;
    display: flex;
    flex-direction: column;

  }

  .newsMsgWith {
    width: 100%;
    overflow: hidden;
    display: flex;
    flex-direction: row;
    cursor: pointer;
  }

  .newsTwoBody p {
    margin: 0 0;
    width: 56%;
    height:40px;
    font-size: 22px;
    line-height: 40px;
    overflow: hidden;
  }

  .newsTwoBody span {
    margin: 0 0;
    width: 40%;
    height: 2.3rem;
    line-height: 2.3rem;
    text-align: right;
    color: #BCBCBC;
  }

  .imgAllIn {
    width: 100%;
    height: 270px;
    padding-top: 25px;
    padding-bottom: 50px;
    display: flex;
    justify-content: center;
  }

  .imgNeedIn {
    width: 96.5%;
    height: 270px;
    border: 1px solid #e4e4e4;
    display: flex;
    justify-content: center;
    flex-direction: column;
  }

  .imgHeader {
    width: 99%;
    height: 2rem;
    display: flex;
    flex-direction: row;
    border-bottom: 2px solid #e4e4e4;
  }

  .imgHeader p {
    width: 80%;
    margin: 0 0;
    height: 2rem;
    line-height: 2rem;
    text-indent: 10px;
  }

  .imgHeader span {
    width: 20%;
    text-align: right;
  }

  .newsRowMiddle {
    width: 100%;
    height: 346px;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    padding-top: 20px;
    padding-bottom: 20px;
  }

  .newsMiddleIn {
    width: 30%;
    height: 100%;
    border: 1px solid #e4e4e4;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .newsMiddleOn {
    width: 32.5%;
    height: 100%;
    border: 1px solid #e4e4e4;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .middleImg {
    width: 100%;
    height: 10rem;
  }

  .middleImg img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  .endLongImgEnd {
    width: 95%;
    height: 326px;
    padding-bottom: 30px;
  }

  .endLongImgEnd img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  .endLongImg {
    width: 95%;
    height: 12rem;
    padding-bottom: 30px;
  }

  .endLongImg img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  /*  .inner-container_one {
    animation: myMove 5s linear infinite;
    animation-fill-mode: forwards;
    display: flex;
  }
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }*/
  #page >>> .el-carousel__container {
    height: 100%;

  }

  .re-class {
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 7;

  }

  .myImgshow {
    width: 13rem;
    height: 270px;
  }

  .myImgshow img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  .newHeadText {
    width: 98%;
    background: #f7f6f5;
    display: flex;
    align-items: center;
    justify-content: flex-start;
    height: 4rem;
    font-size: 18px;
    text-indent: 15px;
    margin-bottom: 15px;
  }
 .newHeadTexts{
  color: #FF8787;
  font-size: 16px;
  /* padding-top: 16px; */
  height: 7rem;
  margin-bottom: 0;
  overflow: hidden;
  background: url("../assets/images/bg.jpg") no-repeat 100%;
  background-size: 100% 100%;
  padding: 22px;

 
   

 }
  .bodyCenter{
    width: 95%;
    position: absolute;
    top: 530px;
    left: 2.5%;
    background: #fff;
  }
</style>
