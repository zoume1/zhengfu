<template>
  <el-form class="login-form"
           status-icon
           :rules="dataRule"
           ref="dataForm"
           :model="dataForm"
           label-width="0">
    <el-form-item prop="userName">
      <el-input size="small"
                @keyup.enter.native="dataFormSubmit"
                v-model="dataForm.userName"
                auto-complete="off"
                placeholder="请输入用户名">
        <i slot="prefix"
           class="icon-yonghu"></i>
      </el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input size="small"
                @keyup.enter.native="dataFormSubmit"
                :type="passwordType"
                v-model="dataForm.password"
                auto-complete="off"
                placeholder="请输入密码">
        <i class="el-icon-view el-input__icon"
           slot="suffix"  @click="showPassword"></i>
        <i slot="prefix"
           class="icon-mima"></i>
      </el-input>
    </el-form-item>
    <el-form-item prop="captcha">
      <el-row :span="24">
        <el-col :span="14">
          <el-input size="small"
                    @keyup.enter.native="dataFormSubmit"
                    v-model="dataForm.captcha"
                    auto-complete="off"
                    placeholder="请输入验证码">
            <i slot="prefix"
               class="icon-yanzhengma"></i>
          </el-input>
        </el-col>
        <el-col :span="10">
          <div class="login-code">
            <!--<span class="login-code-img"></span>-->
                 <!-- @click="getCaptcha()"
                  v-if="code.type == 'text'">captchaPath</span>-->
            <img  :src="captchaPath" @click="getCaptcha()"  class="login-code-img"  />
            <!-- <i class="icon-shuaxin login-code-icon" @click="refreshCode"></i> -->
          </div>
        </el-col>
      </el-row>

    </el-form-item>
    <el-checkbox v-model="checked">记住账号</el-checkbox>
    <el-form-item>
      <el-button type="primary"
                 size="small"
                 @click.native.prevent="dataFormSubmit"
                 class="login-submit">登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { isvalidUsername } from "@/util/validate";
import { randomLenNum } from "@/util/util";
import { mapGetters } from "vuex";
import API from "@/api";
import { getUUID } from '@/utils'
export default {
  name: "userlogin",
  data () {
    const validateUsername = (rule, value, callback) => {
      if (!isvalidUsername(value)) {
        callback(new Error("请输入正确的用户名"));
      } else {
        callback();
      }
    };
    const validateCode = (rule, value, callback) => {
      if (this.code.value != value) {
        this.loginForm.code = "";
        this.refreshCode();
        callback(new Error("请输入正确的验证码"));
      } else {
        callback();
      }
    };
    return {
      dataForm: {
        userName: '',
        password: '',
        uuid: '',
        captcha: ''
      },
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
      checked: false,
      passwordType: "password"
    };
  },
  created () {
      this.getCaptcha()

  },
  mounted () { },
  computed: {
    ...mapGetters(["tagWel"])
  },
  props: [],
  methods: {
    // 提交表单
    dataFormSubmit () {
      var that = this;
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          var params = {
            'username': that.dataForm.userName,
            'password': that.dataForm.password,
            'uuid': that.dataForm.uuid,
            'captcha': that.dataForm.captcha
          }
          API.common.login(params).then(({data}) => {
            if (data && data.code === 0) {
              that.$cookie.set('token', data.token)
              that.reloadConfig();
              that.$router.push({ path: that.tagWel.value });
            } else {
              that.getCaptcha()
              that.$message.error(data.msg)
            }
          })
        }
      })
    },
    // 获取验证码
    getCaptcha () {
      var that = this;
      that.dataForm.uuid = getUUID()
      that.captchaPath = API.common.captcha(that.dataForm.uuid)
    },
    showPassword () {
      this.passwordType == ""
        ? (this.passwordType = "password")
        : (this.passwordType = "");
    },
    handleLogin () {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.$store.dispatch("LoginByUsername", this.loginForm).then(() => {
            this.$router.push({ path: this.tagWel.value });
          });
        }
      });
    }
  }
};
</script>

<style>
</style>
