<template>
  <div>
    <mobile-header></mobile-header>
    <div class="signCont">
      <el-form ref="form" :model="form" label-width="70px">
        <el-form-item label="会员账号">
          <el-input v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pass">
          <el-input type="password" v-model="form.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-button type="primary" style="width: 60%;">登录</el-button>
      </el-form>
    </div>

  </div>
</template>

<script>
  import MobileHeader from '../../components/mobileHeader';

  export default {
    name: 'SignIn',
    data () {
      return {
        form: {
          username: '',
          pass: ''
        }
      }
    },
    components: {MobileHeader}
  }
</script>

<style scoped>
  .signCont{
    padding:0 40px;
    margin-top: 60px;
    text-align: center;
  }

  .signCont button{
    margin-top: 50px;
  }
</style>
