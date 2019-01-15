<template>
  <div class="loginBg">
    <div class="logTit">
      <div class="titLeft">
        <p>六盘水市工商联 <span>--会员登录</span></p>
      </div>
      <div class="titRig">
        <p>还没账号？<a @click="goToUrl('/register')">去注册</a></p>
        <p><a @click="goToUrl('/home')">商会首页</a>| <a>注册须知</a></p>
      </div>
    </div>
    <div class="loginCont">
      <h2>商会会员登录平台</h2>
      <div class="logBig" style="background:#fff;">
        <div class="logincontent">
          <div class="logImg">
            <img src="../assets/images/logImg.png" alt="">
          </div>
          <div class="logForm">
            <el-form ref="form" :model="dataForm"  :rules="dataRule" label-width="80px" @>
              <el-form-item label="会员账号" prop="userName">
                <el-input v-model="dataForm.userName"></el-input>
              </el-form-item>
              <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="dataForm.password" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="验证码" prop="captcha">
                <el-row>
                  <el-col :span="12">
                    <el-input v-model="dataForm.captcha"></el-input>
                  </el-col>
                  <el-col :span="12"><img :src="captchaPath" alt="" @click="getCaptcha" style="height: 40px;"></el-col>
                </el-row>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="onSubmit">登录</el-button>
                <el-button @click="$router.go(-1)">取消</el-button>
              </el-form-item>
            </el-form>
          </div>
        </div>
        <div class="formBottom">
          <ul>
            <li><a @click="goToUrl('/home')">返回首页</a></li>
            <li><a>商会简介</a></li>
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
  import { getUUID } from '@/utils'
  import API from '@/api'
  export default {
    name: 'login',
    data () {
      return {
          dataRule: {
          userName: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
            password: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
            captcha: [
            { required: true, message: '验证码不能为空', trigger: 'blur' }
          ]
          },
        captchaPath:null,
        dataForm: {

        }
      }
    },
    created(){

      this.getCaptcha();
    },
    components: {
      footerNav
    },
    methods:{
      // 获取验证码
      getCaptcha () {
        var that = this;
        that.dataForm.uuid = getUUID()
        that.captchaPath = API.common.captcha(that.dataForm.uuid)
      },
      onSubmit(){
        var that = this;
        this.$refs['form'].validate((valid) => {
          if (valid) {
            API.lpuser.login(that.dataForm).then(({data})=>{
              if(data.code==0){
                that.setUser(data.data);

                this.goToUrl('/home');
              }else{
                that.getCaptcha();
              }

            });
          } else {
            that.getCaptcha();
            return false;
          }
        });
      }

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
    padding:30px 0;
    margin:0;
  }

  .logincontent {
    display: flex;
    justify-content: space-around;
    align-items: center;

    padding: 60px 0;
  }

  .logForm {
    border: 1px solid #ccc;
    padding: 20px;
    width: 55%;
  }

  .formBottom{
    border-top:1px solid #000;
    padding:15px 0;
    margin-top:40px;
  }

  .formBottom ul{
    margin:0;
    padding:0;
    display: flex;
    justify-content: space-around;
    align-items: center;
  }

  .formBottom li{
    list-style:none;
  }

  .logBig{
    background: #fff;
    width: 80%;
    margin: 0 auto;
    padding: 0 55px;
    box-sizing: border-box;
  }

  .footer_txt p{
    color:#fff;
  }

</style>
