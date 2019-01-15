<template>
  <div class="footer">
    <div class="container">
      <div style="display: table;">
        <div class="foot_contact">
          <h2>联系我们</h2>
          <p>{{comp_name}} 版权所有 </p>
          <p>地址:{{comp_address}}</p>
        </div>
        <div class="foot_contact">
          <h2>网站导航</h2>
          <ul>
            <li v-for="web_dao in web_nav"><a href="javascript:;" @click="$router.push({path:web_dao.path})">{{web_dao.web_add}}</a>
            </li>
          </ul>
        </div>
        <div class="foot_contact">
          <h2>旗下企业</h2>
          <ul>
            <li v-for="under in comp_under"><a href="javascript:;" @click="$router.push({path:'/under_enterprise'})">{{under.under_comp_name}}</a>
            </li>
          </ul>
        </div>
        <div class="foot_contact">
          <h2>法律声明</h2>
          <ul>
            <li v-for="law_state in law_state"><a href="javascript:;">{{law_state.law}}</a></li>
          </ul>
        </div>
        <div class="foot_contact">
          <h2>关于</h2>
          <ul>
            <li v-for="foot_ab in foot_about"><a href="javascript:;" @click="$router.push({path:'/about_szt'})">{{foot_ab.ab_comp}}</a>
            </li>
          </ul>
        </div>
        <div class="foot_contact" style="margin: 0;float: right;padding:0;">
          <img :src="com_code" alt="">
          <h4>关注我们</h4>
        </div>
      </div>
      <div class="foot_bq">@2017三智头技能科技(佛山)有限公司 粤icp备17111238号</div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'footer_bottom',
    data() {
      return {
        comp_name: '佛山三智头智能科技集团',
        comp_address: '佛山市禅城区季华西路133号3座15层 | 电话:13790019395 | QQ:594663478 | 邮箱:594663478@qq.com | 83559231',
        web_nav: [
          {web_add: '首页', path: '/home'},
          {web_add: '走进三智头', path: '/about_szt'},
          {web_add: '产业布局', path: '/enterprise_layout'}
        ],
        comp_under: [
          {under_comp_name: '深圳三智头网络科技有限公司'},
          {under_comp_name: '佛山工业壹号科技有限公司'},
          {under_comp_name: '三智头大数据产业创投基金'}
        ],
        law_state: [
          {law: '服务条款'},
          {law: '用户协议'},
          {law: '版权声明'},
          {law: '商标声明'}
        ],
        foot_about: [
          {ab_comp: '公司介绍'},
          {ab_comp: '团队展示'},
          {ab_comp: '服务介绍'},
          {ab_comp: '疑难解答'}
        ],
        com_code: require('../assets/images/ic_qrcode.png')
      }
    }
  }
</script>

<style scoped>
  .footer {
    width: 100%;
    background: url("http://website.3zhit.cn/jtgw_foot_bg.png");
    /*background: #333333;*/
    color: #fff;
    display: table;
    padding: 25px 0;
    background-size: 35px;
  }
 .home .foot_contact {
    float: left;
    max-width: 20%;
    line-height: 25px;
    margin-right: 67px;
    padding-top: 40px;
  }
  .foot_contact {
    float: left;
    max-width: 15%;
    line-height: 25px;
    margin-right: 67px;
    padding-top: 40px;
  }

  .foot_contact h2 {
    font-size: 20px !important;
    margin: 0;
    margin-bottom: 34px;
  }

  .foot_contact p {
    font-size: 14px;
    color: #929292;
    text-align: left;
  }

  .foot_contact img{
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  .foot_contact ul {
    padding: 0;
  }

  .foot_contact li {
    list-style: none;
    margin-bottom: 10px;
  }

  .foot_contact li a {
    color: #929292;
    font-size: 14px;
  }

  .foot_contact h4 {
    text-align: center;
  }

  .foot_bq {
    text-align: center;
    color: #fff;
    font-size: 14px;
    margin-top: 74px;
  }

</style>
