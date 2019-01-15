<template>
  <div class="head_nav">
    <div class="container-fluid" style="display: flex;flex-direction: column;align-items: center;padding-bottom: 30px">
      <div class="head_center">
        <div class="head_one_row" @click="goToUrl('/home')">
          <img src="../assets/images/u2.png"/>
          <div>
            <p>
              <span class="fontBig">六盘水市工商业联合会（商会)</span>
            </p>
            <p>
              <span class="fontBigSmall">LIUPANSHUI FEDERATION INDUSTRY &COMMERCE</span>
            </p>
          </div>
        </div>
        <div class="head_two_row_body">
          <div class="head_row_two">
            <div style="color: #4681C3">
               <a @click="goToUrl('/home')" >首页&nbsp;&nbsp;| &nbsp;&nbsp;</a>
              <a @click="goToUrl('/register')" v-if="user==null">免费注册&nbsp;&nbsp;| &nbsp;&nbsp;</a>
              <a v-if="user!=null" @click="goToUrl('/register')">会员中心&nbsp;&nbsp;| &nbsp;&nbsp;</a>
              <a @click="setHome(this);"> 设为首页</a>&nbsp;&nbsp;| &nbsp;&nbsp;
              <a @click="AddFavorite('加入收藏');">收藏本站</a>
            </div>
          </div>
          <div class="search_btn">
            <div class="mysearch">
              <img style="width: 30px;height: 30px;" src="../assets/images/search.png"/>
              <input style="width: 75%;border: none;padding-left: 15px;font-size: 15px" placeholder="请输入关键字搜索"/>
            </div>
          </div>
        </div>
      </div>
      <div class="indexMenu">
        <div v-for="(item,index) in menu" class="smallMenu" :class="hoverIndex===index ?  'hourOn':'' "
             @mouseover="setIndex(index)">{{item.name}}
        </div>

      </div>


      <div class="toUrl">
        <div v-show="hoverIndex==index" :class="[index===1?'urlListOne':'urlList']" v-for="(item,index) in menu"
             :style="'margin-left: '+(100*index)+'px;'">
          <div  class="showUrl" v-for="(obj,indexs) in item.children" @click="clickMenu(item,obj)">
            {{obj.name}}
          </div>
        </div>

      </div>

      <div style="width: 95%;margin-bottom: 30px;">
        <div  class="flyText">
          <div>
            [通知] :
          </div>
          <div class="inner-container">
            <p class="text" v-for="(text, index) in arr" :key="index">&nbsp;&nbsp;&nbsp;&nbsp;{{(index+1)+'：'+text.title}}</p>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
  import API from '@/api'
  import {Message} from 'element-ui'
  import {treeDataTranslate} from '@/utils'

  export default {
    name: 'headerNav',
    data() {
      return {
        menu: [],
        hoverIndex: 0,
        urlList: [],
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
      this.getUrlList()
      this.getArticleList()
    },
    methods: {
      clickMenu(item, obj) {
        if (obj.name == '免费注册') {
          this.goToUrl('/register');
        } else if (obj.name == '活动报名') {
          this.goToUrl('/activityList');
        } else if (obj.name == '快速登录') {
          this.goToUrl('/login');
        } else if (obj.name == '活动报名') {
          this.goToUrl('/activityList')
        } else if (obj.name == '人才库') {
          this.goToUrl('/talentPoolList');
        } else if (obj.name == '在线交流') {
          this.goToUrl('/onlineMsg');
        } else if (item.name == '图库') {
          this.goToUrl('/Img_list', 0, {itemName: item.name, objName: obj.name, columnId: obj.id});
        } else {
          this.goToUrl('/news_list', 0, {itemName: item.name, objName: obj.name, columnId: obj.id});
        }
      },
      setHome(obj) {
        var vrl = window.location;
        console.log(vrl);
        try {
          obj.style.behavior = 'url(#default#homepage)';
          obj.setHomePage(vrl);
        }
        catch (e) {
          if (window.netscape) {
            try {
              netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
            }
            catch (e) {
              alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
            }
            var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
            prefs.setCharPref('browser.startup.homepage', vrl);
          } else {
            alert("您的浏览器不支持，请按照下面步骤操作：1.打开浏览器设置。2.点击设置网页。3.输入：" + vrl + "点击确定。");
          }
        }
      },
      AddFavorite(title) {
        var url = window.location.href;
        try {
          window.external.addFavorite(url, title);
        } catch (e) {
          try {
            window.slidebar.addPanel(title, url, "");
          } catch (e) {
            alert("加入收藏失败，\n请使用Ctrl+D进行添加！");
          }
        }
      },
      setIndex(index) {
        this.hoverIndex = index
      },
      // goToUrl(value) {
      //   this.$router.push({path: value});
      // },
      getUrlList() {
        var that = this;
        API.lpcolumn.list({}).then(({data}) => {
          that.menu = treeDataTranslate(data.data, "id")
        })
      },
      getArticleList() {
        API.lparticle.list({
          page: 1,
          limit: 10,
          order: "desc",
          sidx: "createTime"
        }).then(({data}) => {
          this.arr = data.data.list
        })
      }
    },
    components: {
      API,
      Message
    },
    watch: {
      'url': 'lookWay'
    }

  }
</script>

<style scoped>
  .head_nav {
    background-image: url("../assets/images/u0.png");
    background-repeat: no-repeat;
    background-size: 100% 110%;
    height: 840px;
  }
a{
  cursor: pointer;
}
  .hourOn {
    background: #0f639b !important;
    color: #ffffff !important;;
  }

  .indexMenu {
    width: 95%;
    height: 83px;
    display: flex;
    align-items: center;
    flex-direction: row;
    background: #1179bf;
    /*padding-left: 150px;*/
  }

  .toUrl {
    background: #ffffff;
    color: #1179bf;
    width: 95%;
    height: 66px;
    border-bottom: 1px solid #e4e4e4;
    display: flex;
    flex-direction: row;
    align-items: center;
  }

  .showUrl {
    cursor: pointer;
    color: #1179bf;
    font-size: 24px;
    padding-left: 1rem;
    padding-right: 1rem;
  }

  .urlList {
    width: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
    height: 66px;
  }


  .urlListOne {
    width: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
    height: 3rem;
    margin-left: 0 !important;
  }

  .smallMenu {
    cursor: pointer;
    width: 10%;
    height: 83px;
    margin-right: 1rem;
    background: #1179bf;
    color: #ffffff;
    line-height: 83px;
    font-size: 28px;
    text-align: center;
    font-weight: 540;
    z-index: 9999;

  }

  /**
   头部
  */
  .head_center {
    width: 100%;
    height: 335px;
    display: flex;
    flex-direction: column;
    align-items: center;
    position: relative;
    top: 80px;
  }

  .head_one_row {
    width: 100%;
    height: 160px;
    display: flex;
    flex-direction: row;
    align-items: center;
  }

  .head_one_row img {
    width: 160px;
    height: 160px;
    margin-right: 50px;
    margin-left: 85px;
  }

  .head_one_row_text {
    width: 60%;
    display: flex;
    flex-direction: column;
    padding-left: 50px;
    font-style: normal;
    color: #1179BF;
    text-align: center;
  }
  .head_two_row_body{
    display: flex;
    position: relative;
    align-items: center;
    justify-content: flex-end;
    width: 100%;
    flex-direction: row;
    top: 15px;
    right: 35px;
  }

  .head_row_two {
    width: 75%;
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    height: 90px;
    padding-right: 15px;
    justify-content: center;
    font-size: 24px;
  }

  .search_btn {
    width: 20%;
    display: flex;
    flex-direction: row;
    border-radius: 16px;
    padding: 5px 5px;
    right: 50px;
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

  .flyText {
    width: 100%;
    height: 2rem;
    overflow: hidden;
    display: flex;
    flex-direction: row;
    align-items: center;
    padding: 0 15px;
    box-sizing: border-box;
    color: #4681C3;
  }

  .mysearch {
    width: 100%;
    height:2rem;
    background: #ffffff;
    border-radius: 1.5rem;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .mysearch img {
    width: 30px;
    height: 30px;
    margin-left: 15px;
  }

  .fontBig {
    font-family: 'Arial Negreta', 'Arial Normal', 'Arial';
    font-weight: 700;
    font-style: normal;
    font-size: 73px;
    color: #1179BF;
    text-align: center;
  }
  .fontBigSmall {
    font-family: 'Arial Negreta', 'Arial Normal', 'Arial';
    font-weight: 700;
    font-style: normal;
    font-size: 36px;
    color: #1179BF;
    text-align: center;
  }
</style>
