<template>
  <div>
    <mobile-header></mobile-header>
    <h3 style="text-align: center">XXX报名活动</h3>
    <div class="signUp">
      <ul>
        <li>
          <h4>活动名：</h4>
          <p>关于通知工商联的2018年上半年工作报告</p>
        </li>
        <li>
          <h4>活动状态：</h4>
          <p>进行中</p>
        </li>
        <li>
          <h4>报名时间：</h4>
          <p>2018-08-28 12:23:56 ~ 2019-08-28 12:23:56</p>
        </li>
        <li>
          <h4>活动时间：</h4>
          <p>2018-09-29 12:23:56</p>
        </li>
        <li>
          <h4>活动地点：</h4>
          <p>XXX省XXX市XXX区</p>
        </li>
        <li>
          <h4>活动内容：</h4>
          <p>12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！</p>
        </li>
        <el-button type="primary" @click="isShow=true">报名</el-button>
      </ul>
    </div>
    <div class="tank" v-show="isShow">
      <p>报名成功</p>
      <el-button type="primary" @click="isShow=false">确定</el-button>
    </div>
  </div>
</template>

<script>
  import MobileHeader from '../../components/mobileHeader';

  export default {
    name: 'signUpDetail',
    data () {
      return {
        isShow: false
      }
    },
    components: {MobileHeader}
  }
</script>

<style scoped>
  .signUp {
    width: 100%;
    display: table;
    text-align: center;
  }

  .signUp ul{
    padding:0;
    margin:0;
  }

  .signUp li {
    list-style: none;
    text-align: left;
    padding:0 20px;
  }

  .signUp li h4 {
    margin: 0;
    font-size: 16px;
  }

  .signUp li p {
    font-size: 14px;
    color: #000;
    margin: 0;
  }

  .signUp li {
    margin-bottom: 20px;
  }

  .tank{
    border:1px solid #000;
    background: #fff;
    text-align: center;
    padding:30px 20px;
    width: 75%;
    margin: 0 auto;
    position: fixed;
    top: 50%;
    margin-top: -100px;
    left: 50%;
    margin-left: -165px;
  }

  .tank p{
    border-bottom:1px solid #000;
    margin:0;
    padding:20px 0;
    margin-bottom: 30px;
  }
</style>
