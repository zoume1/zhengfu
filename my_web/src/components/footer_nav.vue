<template>
  <div class="footer_cont">
    <div class="footer_nav">
      <ul>
       <!-- <li><a @click="goToUrl('/home')">网站首页</a></li>-->
        <li v-for="item in list"><a @click="goToUrl(item.href)">{{item.name}}</a></li>
      <!--  <li><a>会长致辞</a></li>
        <li><a>商会章程</a></li>
        <li><a>组织机构</a></li>
        <li><a>商会服务</a></li>
        <li><a>商会纪事</a></li>
        <li><a>站点地图</a></li>
        <li><a>版权所有</a></li>-->
      </ul>
    </div>
    <div class="footer_txt">
      <p>六盘水市工商联 版权所有 LIUPANSHUI BUSINESS ORGANIZATION CORPORATION.ALL Rights Reserved</p>
      <p>地址： 累计访问量：14121 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贵公网安备 520101021520111</p>
    </div>
  </div>
</template>

<script>
  import API from "@/api"
  export default {
    name: 'footer_nav',
    data(){
      return {
        list:[]
      }
    },
    mounted(){
      API.lplink.list().then(({data})=>{
        this.list=data.data;
      });
    },

    methods:{

    }
  }
</script>

<style scoped>
  .footer_cont {
    width: 100%;
    margin-top: 50px;
    display: flex;
    flex-direction: column;
    align-items: center;

  }

  .footer_nav {
    width: 95%;
    background: #1179bf;
    color: #fff;
    padding: 10px 0;
    height: 72px;
    font-size: 20px;
    line-height: 72px;
    text-align: center;
  }
  .footer_nav ul {
    width: 1200px;
    margin: 0 auto;
    padding: 0;
    display: flex;
    justify-content: space-around;
    align-items: center;
  }

  .footer_nav ul li{
    font-size:20px;
    list-style: none;
  }
  .footer_txt{
    height: 74px;
  }

  .footer_txt p{
    text-align: center;
    font-size:14px;
  }
</style>
