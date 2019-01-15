<template>
  <div>
    <mobile-header></mobile-header>
    <div class="newsTab">
      <ul>
        <li @click="tab('one')" v-bind:class="{'tabActive':tabsOne}">资讯</li>
        <li @click="tab('two')" v-bind:class="{'tabActive':tabsTwo}">通知</li>
      </ul>
    </div>
    <div class="newsMsg" v-show="isActive">
      <ul>
        <li v-for="msg in newsMsg">
          <router-link :to="'/newsDetailMob?id='+msg.id">
            <img :src="msg.pic" alt="">
            <div class="newsTxt">
              <h4>{{msg.title}}</h4>
              <p  v-text="timeFormat(msg.createTime)"></p>
            </div>
          </router-link>
        </li>
      </ul>
    </div>
    <div class="newsMsg" v-show="isActive2">
      <ul>
        <li v-for="tz in newsTz">
          <router-link to="/newsDetailMob">
            <img :src="tz.newImg" alt="">
            <div class="newsTxt">
              <h4>{{tz.newsTit}}</h4>
              <p>{{tz.newsDate}}</p>
            </div>
          </router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
  import MobileHeader from '../../components/mobileHeader';
  import API from '@/api';

  export default {
    name: 'newsListMob',
    data () {
      return {
        tabsOne: true,
        tabsTwo: false,
        isActive: true,
        isActive2: false,
        newsMsg: [

        ],
        newsTz: [

        ]
      }
    },
    mounted(){
      this.getInfo();
    },
    methods: {
      getInfo(){
        API.lpgzharticle.list({
          page:1,
          limit:10,
          sidx:"createTime",
          order:"desc",
          columnId:parseInt(this.$route.query.id)
        }).then(({data})=>{
          this.newsMsg=data.data.list;
        });
      },
      tab (type) {
        if (type === 'one') {
          this.tabsOne = true;
          this.tabsTwo = false;
          this.isActive = true;
          this.isActive2 = false;
        } else {
          this.tabsOne = false;
          this.tabsTwo = true;
          this.isActive = false;
          this.isActive2 = true;
        }
      }
    },
    components: {MobileHeader}
  }
</script>

<style scoped>
  .newsTab {
    display: table;
    width: 100%;
    padding: 20px 10px;
    box-sizing: border-box;
  }

  .newsTab ul {
    display: flex;
    justify-content: start;
    align-items: center;
    padding: 0;
    margin: 0;
  }

  .newsTab li {
    list-style: none;
    border-radius: 4px;
    background: #ccc;
    padding: 5px 15px;
    font-size: 14px;
    margin-right: 20px;
  }

  .tabActive {
    background: #2e6da4 !important;
    color: #fff;
  }

  .newsMsg ul {
    padding: 0;
    margin: 0;
  }

  .newsMsg li {
    list-style: none;
    /*align-items: center;*/
    border-bottom: 8px solid #f7f5f5;
    padding: 15px 10px;
  }

  .newsMsg li a{
    display: flex;
    justify-content: space-around;
    text-decoration: none;
    color:#000;
  }

  .newsMsg li img {
    width: 30%;
    height: 100%;
  }

  .newsTxt h4 {
    margin: 0;
    margin-bottom: 10px;
    font-weight: normal;
    font-size: 16px;
  }

  .newsTxt p {
    font-size: 12px;
    color: #C8C8CD;
  }
</style>
