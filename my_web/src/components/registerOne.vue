<template>
  <div class="myIn">
    <div class="headMine">填写个人会员信息</div>
    <div style="width: 100%;height: 5rem;display: flex;align-items: center;justify-content: center">
      <div style="" class="headIptFather">
        <div style="" class="headIpt">
          <span>会员账号:</span>
          <input/>
        </div>
        <div class="headIpt">
          <span>密码:</span>
          <input/>
        </div>
        <div class="headIpt">
          <span>确认密码:</span>
          <input/>
        </div>
      </div>
    </div>

    <div class="bodyRow">
      <div class="bodyRowOne">
        <div>
          <img src="../assets/images/headImg.jpg"/>
          <input type="button" accept="*/*" value="上传头像"/>
        </div>

      </div>
      <div class="bodyRowTwo">
        <div class="bodyInpt">
          <span>所在工商联</span><em>*</em>
          <el-select v-model="value" :width="300" placeholder="请选择" class="my_select">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </div>
        <div class="bodyInpt">
          <span>姓名</span><em>*</em>
          <input/>
        </div>
        <div class="bodyInpt">
          <span>出生日期</span><em>*</em>
          <input/>
        </div>
        <div class="bodyInpt">
          <span>证件类型</span><em>*</em>

          <el-select v-model="idCardvalue" :width="300" placeholder="请选择" class="my_select">
            <el-option
              v-for="item in cardOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </div>
        <div class="bodyInpt">
          <span>籍贯</span><em>*</em>
          <el-select v-model="idCardvalue" :width="300" placeholder="请选择" class="my_select">
            <el-option
              v-for="item in cardOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </div>
        <div class="bodyInpt">
          <span>曾用名</span><em>*</em>
          <input/>
        </div>
        <div class="bodyInpt">
          <span>证件类型</span><em>*</em>
          <el-select v-model="idCardvalue" :width="300" placeholder="请选择" class="my_select">
            <el-option
              v-for="item in cardOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </div>
        <div class="bodyInpt">
          <span>学历</span><em>*</em>
          <el-select v-model="studyValue" :width="300" placeholder="请选择" class="my_select">
            <el-option
              v-for="item in study"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </div>
        <div class="bodyInpt">
          <span>邮编</span><em>*</em>
          <input/>
        </div>
        <div class="bodyInpt">
          <span>QQ</span><em>*</em>
          <input/>
        </div>
        <div class="bodyInpt">
          <span>入会时间</span><em>*</em>
          <input/>
        </div>
      </div>

      <!--第二排-->
      <div class="bodyRowThree">
        <div class="bodyInpt">
          <span>人员分类</span><em>*</em>

          <el-select v-model="userTypeValue" :width="300" placeholder="请选择" class="my_select">
            <el-option
              v-for="item in userType"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </div>
        <div class="bodyInpt">
          <span>性别</span><em>*</em>
          <el-select v-model="userTypeValue" :width="300" placeholder="请选择" class="my_select">
            <el-option value="0" label="男">
            </el-option>
            <el-option value="1" label="女">
            </el-option>
          </el-select>
        </div>
        <div class="bodyInpt">
          <span>名族</span><em>*</em>
          <input/>
        </div>
        <div class="bodyInpt">
          <span>出生地</span><em>*</em>
          <input/>
        </div>
        <div class="bodyInpt">
          <span>政治面貌</span><em>*</em>
          <el-dropdown>
          <span class="el-dropdown-link">
            请选择<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>党员</el-dropdown-item>
              <el-dropdown-item>群众</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
        <div class="bodyInpt">
          <span>联系人手机号码</span><em>*</em>
          <input/>
        </div>
        <div class="bodyInpt">
          <span>座机</span><em>*</em>
          <input/>
        </div>
        <div class="bodyInpt">
          <span>邮箱</span><em>*</em>
          <input/>
        </div>
        <div class="bodyInpt">
          <span>微信</span><em>*</em>
          <input/>
        </div>
      </div>

    </div>
  </div>

</template>

<script>
  import {API} from '../services/index'
  import footerNav from './footer_nav'

  export default {
    name: 'activityList',
    data () {
      return {
        options: [{
          value: '桂林市工商联',
          label: '桂林市工商联'
        }, {
          value: '六盘水市工商联',
          label: '六盘水市工商联'
        }],
        value: '',
        idCardvalue: '',
        cardOptions: [{  // 身份证选择
          value: '0',
          label: '身份证'
        }, {
          value: '1',
          label: '驾驶证'
        }],
        studyValue: '',
        study: [{  // 身份证选择
          value: '0',
          label: '身份证'
        }, {
          value: '1',
          label: '驾驶证'
        }],
        userTypeValue: '',
        userType: [{  // 身份证选择
          value: '0',
          label: '个体工商户'
        },
        {  // 身份证选择
          value: '0',
          label: '工商联干部'
        },
        {  // 身份证选择
          value: '0',
          label: '非公企业主要出资人和经营者'
        },
        {  // 身份证选择
          value: '0',
          label: '在内地投资的港澳工商界代表人士'
        },
        {  // 身份证选择
          value: '0',
          label: '有关单位代表'
        }, {  // 身份证选择
          value: '0',
          label: '原工商业者'
        }, {  // 身份证选择
          value: '0',
          label: '其他'
        }]
      }
    },
    methods: {},
    components: {
      footerNav
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
    background: #ffffff;
    opacity: 0.9;
  }

  .headMine {
    width: 100%;
    height: 3rem;
    font-size: 24px;
    font-weight: 700;
    text-indent: 20px;
    line-height: 3rem;
    border: 1px solid #333;
  }

  .headIptFather {
    width: 90%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    border: 1px solid #333333;
  }

  .headIpt {
    width: 33%;
    height: 100%;
    display: flex;
    align-items: center;
  }

  .headIpt span {
    width: 30%;
    font-size: 18px;
  }

  .headIpt input {
    width: 70%;
    height: 50%;
  }

  .bodyRow {
    width: 95%;
    height: 30rem;
    display: flex;
    flex-direction: row;
    align-items: center;
  }

  .bodyRowOne {
    width: 20%;
    height: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
  }

  .bodyRowTwo {
    width: 40%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  .bodyRowThree {
    width: 40%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  .bodyInpt {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
  }

  .bodyInpt span {
    width: 20%;
    padding-right: 10px;
    font-size: 20px;
    font-weight: 600;
    text-align: right;
  }

  .bodyInpt em {
    width: 5%;
    color: red;
    padding-right: 35px;
    font-size: 20px;
  }

  .my_select {
    width: 70%;
  }

</style>
