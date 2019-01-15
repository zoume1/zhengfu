<template>
  <div class="loginBg">
    <div class="logTit">
      <div class="titLeft">
        <p>六盘水市工商联 <span>--会员加入</span></p>
      </div>
      <div class="titRig">
        <p><a @click="goToUrl('/home')">商会首页</a>| <a>注册须知</a></p>
      </div>
    </div>
    <div class="loginCont">
      <h2>恭喜您，注册成功！</h2>
      <div class="logBig">
        <div class="logincontent">
          <h3>请牢记您的注册信息！</h3>
          <div class="logForm">
            <ul>
              <li>您的账号：{{username}}</li>
              <li>您的密码：{{password}}</li>
              <li>您的注册时间：{{registerDeta}}</li>
            </ul>
          </div>
        </div>

        <button @click="goToUrl('/login')">好的，我记住了</button>
        <div class="formBottom">
          <ul>
            <li><a @click="goToUrl('/home')">返回首页</a></li>
            <li><a>完善资料</a></li>
            <li><a>商会章程</a></li>
            <li><a>商会服务</a></li>
          </ul>
        </div>
      </div>
    </div>
    <footer-nav style="color:#fff;"></footer-nav>
  </div>
</template>

<script>
  import footerNav from '../components/footer_nav'

  export default {
    name: 'registerSuc',
    data () {
      return {

        username: 'DADA',
        password: '111111',
        registerDeta: '2018.04.21 12:22:22'
      }
    },
    created(){
      const routerParams = this.$route.query;
      this.username=this.$route.query.userName
      this.password=this.$route.query.password
      this.registerDeta=this.$route.query.createTime
      console.log(routerParams);
    },
    components: {
      footerNav
    }
  }
</script>

<style scoped>
  .loginBg {
    background: url("../assets/images/u509.png") no-repeat center;
    background-size: 100% 100%;
    padding-top: 50px;
    padding-bottom: 20px;
  }

  .logTit {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 1200px;
    margin: 0 auto;
    color: #fff;
    margin-bottom: 15px;
  }

  .titLeft p {
    font-size: 26px;
    font-weight: bold;
    margin: 0;
  }

  .titLeft p span {
    font-size: 16px;
    margin-left: 50px;
  }

  .titRig {
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: #000;
  }

  .titRig p {
    margin: 0;
    font-size: 16px;
  }

  .titRig p a {
    margin: 0 10px;
  }

  .loginCont {
    width: 1200px;
    background: rgba(255, 255, 255, 0.85);
    margin: 0 auto;
    text-align: center;
    padding: 50px 20px;
  }

  .loginCont h2 {
    border-top: 1px solid #ccc;
    padding: 30px 0;
    margin: 0;
  }

  .logincontent {
    display: table;
    width: 100%;
    padding: 60px 0;
    margin: 0 auto;
  }

  .logincontent h3 {
    color: red;
  }

  .logForm {
    border: 1px solid #ccc;
    padding: 20px 65px;
    width: 70%;
    box-sizing: border-box;
    margin: 0 auto;
  }

  .formBottom {
    border-top: 1px solid #000;
    padding: 15px 0;
    margin-top: 40px;
  }

  .formBottom ul {
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: space-around;
    align-items: center;
  }

  .formBottom li {
    list-style: none;
  }

  .logBig {
    background: #fff;
    width: 80%;
    margin: 0 auto;
    padding: 0 55px;
    box-sizing: border-box;
  }

  .logBig button {
    background: rgba(70, 129, 195, 1);
    border: none;
    color: #fff;
    padding: 13px 40px;
    border-radius: 6px;
  }

  .footer_txt p {
    color: #fff;
  }

  .logForm ul {
    padding: 0;
    margin: 0;
  }

  .logForm li {
    list-style: none;
    text-align: left;
    padding: 20px 0px;
  }
</style>
