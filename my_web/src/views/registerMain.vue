<template>
  <div class="myIn">
    <div class="myMain">
      <div class="headIn">
        <div class="headRight">
          <p>六盘市工商联</p>
          <span>-会员加入</span>
        </div>
        <div class="headLeft">
          <div>
            已有账号?<span style="color: red" @click="goToUrl('/login')">去登录</span>
          </div>
          <div style="margin-left: 50px;">
            <a @click="goToUrl('/home')">商会首页</a>
            |
            <a>注册须知</a>
          </div>
        </div>
      </div>
    </div>
   <!-- <div class="headJump">
      <span :class="myIndex===0?'lookIn':''" @click="showIndex(0)" style=" border-top-left-radius: 12px;">个人会员</span>
      <span :class="myIndex===1?'lookIn':''" @click="showIndex(1)">企业会员</span>
      <span :class="myIndex===2?'lookIn':''" @click="showIndex(2)" style="border-top-right-radius: 12px;">团体会员</span>
    </div>-->
    <div style="width: 95%;height: 100%">
     <user-info></user-info>
    </div>
    <footer-nav></footer-nav>
  </div>
</template>

<script>
  import {API} from '../services'
  import footerNav from '../components/footer_nav'
  import userInfo from './lpuser/index.vue'

  export default {
    name: 'activityList',
    data() {
      return {
        myIndex: 0,
        serverId: 0
      }
    },
    methods: {

      showIndex(val) {
        var that = this
        that.myIndex = val
        if (val === 0) {
          this.$router.replace({path: '/personal', query: {serverId: this.serverId}})
        } else if (val === 1) {
          this.$router.replace({path: '/enterprise', query: {serverId: this.serverId}})
        } else {
          this.$router.replace({path: '/group', query: {serverId: this.serverId}})
        }
      }
    },
    components: {
      footerNav,
      userInfo
    }
  }
</script>

<style scoped>
  .myIn {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background-image: url("../assets/images/u509.png");
    background-size: 100% 100%;
  }

  .myMain {
    width: 95%;
    height: 100%;

  }

  .headIn {
    width: 100%;
    height: 5rem;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
  }

  .headRight {
    width: 60%;
    height: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
  }

  .headRight p {
    font-size: 25px;
    font-weight: 400;
    color: #ffffff;
  }

  .headRight span {
    font-size: 18px;
    font-weight: 500;
    color: #ffffff;
  }

  .headLeft {
    width: 40%;
    height: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
  }

  .headJump {
    width: 95%;
    height: 2rem;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    border-top-left-radius: 12px;
    border-top-right-radius: 12px;
    border: 1px solid #333333;
  }

  .headJump span {
    width: 33.3%;
    height: 2rem;
    align-items: center;
    justify-content: center;
    text-align: center;
    line-height: 2rem;
    color: #333333;
    background: #ffffff;
    border-right: 1px solid #333333;


  }

  .lookIn {
    background: #4681C3 !important;
    color: #ffffff !important;
  }
</style>
