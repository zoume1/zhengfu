<template>
  <div class="head_nav">
    <div class="container-fluid" style="padding:0;">
      <div class="nav_top">
        <nav class="navbar navbar-default navbar-mobile bootsnav">
          <div class="head_center">
            <div class="head_one_row">
              <img src="../assets/images/shangbiao.jpg"/>
              <div class="head_one_row_text">
                <b>六盘水市工商业联合会（商会)</b>
                <b>LIUPANSHUI FEDERATION INDUSTRY &COMMERCE</b>
              </div>
            </div>
            <div class="head_row_two">
              <div>
                <a>会员中心</a>&nbsp;&nbsp;| &nbsp;&nbsp;
                <a @click="setHome(this);">设为首页</a>&nbsp;&nbsp;| &nbsp;&nbsp;
                <a>收藏本站</a>
              </div>
              <div class="search_btn">
                <img style="width: 25px;height: 25px;" src="../assets/images/search.png"/>
                <input style="width: 100%;border: none;padding-left: 15px;" placeholder="请输入关键字搜索"/>
              </div>
            </div>
          </div>
          <div class="indexMenu">
            <div class="smallMenu" :class="hoverIndex===0 ?  'hourOn':'' " @mouseover="setIndex(0)">首页</div>
            <div class="smallMenu" :class="hoverIndex===1 ?  'hourOn':'' " @mouseover="setIndex(1)">概况</div>
            <div class="smallMenu" :class="hoverIndex===2 ?  'hourOn':'' " @mouseover="setIndex(2)">动态</div>
            <div class="smallMenu" :class="hoverIndex===3 ?  'hourOn':'' " @mouseover="setIndex(3)">图库</div>
            <div class="smallMenu" :class="hoverIndex===4 ?  'hourOn':'' " @mouseover="setIndex(4)">会员</div>
            <div class="smallMenu" :class="hoverIndex===5 ?  'hourOn':'' " @mouseover="setIndex(5)">互动</div>
          </div>
          <div class="toUrl">
            <div v-show="hoverIndex===0" class="flyText">
              <div>
                [通知] :
              </div>
              <div class="inner-container">
                <p class="text" v-for="(text, index) in arr" :key="index">{{text}}</p>
              </div>
            </div>
            <div v-show="hoverIndex===1" class="urlList">
              <div class="showUrl">
                商会简介
              </div>
              <div class="showUrl">
                会长致辞
              </div>
              <div class="showUrl">
                章程职责
              </div>
              <div class="showUrl">
                组织机构
              </div>
              <div class="showUrl">
                商会服务
              </div>
              <div class="showUrl">
                商会纪事
              </div>
            </div>
            <div v-show="hoverIndex===2" class="urlList" style="padding-left: 25rem;">
              <div class="showUrl">
                通知公告
              </div>
              <div class="showUrl">
                商会新闻
              </div>
              <div class="showUrl">
                会员动态
              </div>
              <div class="showUrl">
                招商投资
              </div>
              <div class="showUrl">
                法律维权
              </div>
              <div class="showUrl">
                商会文化
              </div>

            </div>
            <div v-show="hoverIndex===3" class="urlList" style="padding-left: 35rem;">
              <div class="showUrl">
                活动剪影
              </div>
              <div class="showUrl">
                领导风采
              </div>
              资质荣誉
              <div class="showUrl">
                展销会
              </div>
            </div>
            <div v-show="hoverIndex===4" class="urlList" style="padding-left: 55rem;">

              <div class="showUrl">
                企业风采
              </div>
              <div class="showUrl">
                联系我们
              </div>
              <div class="showUrl">
                免费注册
              </div>
              <div class="showUrl">
                快速登录
              </div>

            </div>
            <div v-show="hoverIndex===5" class="urlList" style="padding-left: 65rem;">
              <div class="showUrl">
                活动报名
              </div>
              <div class="showUrl">
                企业招聘
              </div>
              <div class="showUrl">
                人才库
              </div>
              <div class="showUrl">
                在线交流
              </div>
              <div class="showUrl">
                表格
              </div>
            </div>

          </div>
        </nav>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'headerNav',
    data() {
      return {
        hoverIndex: 0,
        arr: [
          '1 不是被郭德纲发现的，也不是一开始就收为徒弟。',
          '2 现在雅阁这个状态像极了新A4L上市那段日子。',
          '3 低配太寒碜，各种需要加装，中配定价过高，又没啥特色',
          '4 然后各种机油门、经销商造反什么的幺蛾子。',
          '5 看五月销量，建议参考A4，打8折吧。',
          '1 不是被郭德纲发现的，也不是一开始就收为徒弟。',
        ]

      }
    },
    mounted() {

    },
    methods: {
      setIndex(index) {
        this.hoverIndex = index
      }
    },
    watch: {
      'url': 'lookWay'
    }

  }
</script>

<style scoped>
  @import "../assets/css/bootsnav.css";

  .hourOn {
    background: #ffffff !important;
    color: #2e6da4 !important;;
  }
  a{
    cursor: pointer;
  }

  .indexMenu {
     cursor: pointer;
    width: 100%;
    height: 5rem;
    display: flex;
    align-items: center;
    justify-content: flex-start;
    flex-direction: row;
    background: #4681c3;
    padding-left: 150px;
  }

  .toUrl {
    background: #ffffff;
    color: #4681c3;
    width: 100%;
    height: 4rem;
  }
.showUrl{
  cursor: pointer;
  color: #4681c3;
  font-size: 15px;
  padding-left: 2rem;
  padding-right: 2rem;
}
.urlList{
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
  height: 100%;
}
  .smallMenu {
    width: 9%;
    height: 4rem;
    margin-left: 1rem;
    margin-right: 1rem;
    background: #4681c3;
    color: #ffffff;
    line-height: 4rem;
    font-size: 20px;
    text-align: center;
    border: 1px solid #ffffff;
    border-radius: 6px;
  }

  /**
   头部
  */
  .head_center {
    width: 100%;
    height: 95px;
    background-color: #FFF;
    display: flex;
    flex-direction: row;
  }

  .head_one_row {
    width: 65%;
    height: 90px;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
  }

  .head_one_row_text {
    width: 60%;
    display: flex;
    flex-direction: column;
    padding-left: 50px;
    color: #6485b0;
    font-size: 20px;
  }

  .head_row_two {
    width: 35%;
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    height: 90px;
    padding-right: 120px;
    justify-content: center;
  }

  .search_btn {
    width: 60%;
    display: flex;
    flex-direction: row;
    border: 1px solid #287fc6;
    border-radius: 6px;
  }

  .head_one_img {

  }

  .no_check {
    color: #ffffff !important;
  }

  .one_check {
    color: #c12828 !important;
  }

  .nav_top {
    position: absolute;
    width: 100%;
  }

  /*导航*/
  .jq22-header h1 {
    text-align: center;
    font-size: 28px;
    color: #939393
  }

  .navbar-brand {
    padding: 29px 15px;
    height: auto;
  }

  /*首页banner 图片宽度*/
  .home .home_banner {
    height: 680px;
  }

  /*about_szt   图片宽度*/
  .ab_szt .home_banner {
    height: 580px;
  }

  /*App   图片宽度*/
  .app .home_banner {
    height: 580px;
  }

  /*404页面   图片宽度*/
  .not .home_banner {
    height: 580px;
  }

  /*corporate_culture页面   图片宽度*/
  .corporate .home_banner {
    height: 580px;
  }

  /*enterprise_internet    图片宽度*/
  .internet .home_banner {
    height: 580px;
  }

  /*enterprise_layout  图片宽度 */
  .enterprise .home_banner {
    height: 580px;
  }

  /*home  图片宽度 */
  .home .home_banner {
    height: 580px;
  }

  /*news_center  图片宽度 */
  .news .home_banner {
    height: 580px;
  }

  /*news_details   图片宽度*/
  .news_detail .home_banner {
    height: 580px;
  }

  nav.navbar.bootsnav {
    border: none;
    margin-bottom: 0px;
    background: rgba(0, 0, 0, 0.4);
  }

  .navbar-nav {
    float: left;
    padding-left: 90px;
    /*padding-top: 10px;*/
  }

  nav.navbar.bootsnav ul.nav > li > a {
    color: #fff;
    text-transform: uppercase;
    padding: 25px;
    font-size: 18px;
    /*font-size: 15px;*/
    font-weight: normal;
  }

  nav.navbar.bootsnav ul.nav > li:hover {
    background: none;
  }

  nav.navbar.bootsnav ul.nav > li:hover .dropdown-menu {
    display: block;
  }

  .nav > li:after {
    content: "";
    width: 0;
    height: 5px;
    background: #c12828;
    position: absolute;
    bottom: 0;
    left: 0;
    transition: all 0.5s ease 0s;
  }

  .nav > li:hover:after {
    width: 100%;
  }

  nav.navbar.bootsnav ul.nav > li.dropdown > a.dropdown-toggle:after {
    content: "";
    font-family: 'FontAwesome';
    font-size: 16px;
    font-weight: 500;
    position: absolute;
    top: 35%;
    right: 10%;
    /* transition: all 0.4s ease 0s;*/
  }

  nav.navbar.bootsnav ul.nav > li.dropdown.on > a.dropdown-toggle:after {
    transform: rotate(90deg);
  }

  .dropdown-menu.multi-dropdown {
    position: absolute;
    left: -100% !important;
  }

  nav.navbar.bootsnav li.dropdown ul.dropdown-menu {
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    border: none;
  }

  @media only screen and (max-width: 990px) {
    nav.navbar.bootsnav ul.nav > li.dropdown > a.dropdown-toggle:after, nav.navbar.bootsnav ul.nav > li.dropdown.on > a.dropdown-toggle:after {
      content: " ";
      background: #1b6d85;
    }

    .dropdown-menu.multi-dropdown {
      left: 0 !important;
    }

    nav.navbar.bootsnav ul.nav > li:hover {
      background: transparent;
    }

    nav.navbar.bootsnav ul.nav > li > a {
      margin: 0;
    }
  }

  .top_logo {
    display: inline-block;
  }

  .navbar-header {
    padding: 20px 0;
  }

  @media screen and ( max-width: 1920px ) {
    .top_logo {
      margin-left: 110px;
    }
  }

  @media screen and ( max-width: 1080px ) {
    .top_logo {
      margin-left: 50px;
    }
  }

  @media ( min-width: 900px ) and ( max-width: 1110px ) {
    .top_logo {
      margin-left: 0px;
    }
  }

  /*
  .nav_top{display:table;}

  .nav_top nav{position:fixed;width:100%;top:0;}

  .swiper-container{margin-top:87px;}
  */
  @media screen and ( max-width: 1125px ) {
    .list-inline > li {
      margin: 0px 19px 25px 19px !important;
    }
  }

  nav.navbar.bootsnav ul.nav ul.dropdown-menu > li > a:hover {
    background: #D12929;
    color: #fff;
  }

  /*****banner*****/
  .swiper-container {
    width: 100%;
    height: 100%;
  }

  .swiper-slide {
    text-align: center;
    font-size: 18px;
    background: #fff;

    /* Center slide text vertically */
    display: -webkit-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    -webkit-justify-content: center;
    justify-content: center;
    -webkit-box-align: center;
    -ms-flex-align: center;
    -webkit-align-items: center;
    align-items: center;
  }

  .swiper-container-horizontal > .swiper-pagination-progressbar {
    bottom: 0;
    top: auto;
  }

  .swiper-pagination-progressbar .swiper-pagination-progressbar-fill {
    background: #D12929;
  }

  .swiper-pagination-bullet-active {
    background: #D12929;
  }

  .home_banner img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  .inner-container {
    animation: myMove 5s linear infinite;
    animation-fill-mode: forwards;
  }
  /*文字无缝滚动*/
  @keyframes myMove {
    0% {
      transform: translateY(0);
    }
    100% {
      transform: translateY(-150px);
    }
  }
  .flyText{
    width: 100%;
    height: 4rem;
    overflow: hidden;
    display: flex;
    flex-direction: row;
    align-items: center;
    padding-left: 3rem;
  }
</style>
