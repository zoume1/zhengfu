<template>
  <div>
    <mobile-header></mobile-header>
    <div class="newsDetaCont">
      <h3 v-text="info.title">关于虚开增值税专用发票定罪量刑标准有关问题的通知</h3>
      <h5 v-text="info.createTime">2018-8-1 11:19:23</h5>
      <span>{{info.author}}编辑</span><span >来源：{{info.source}}</span>
      <div class="newsNei" v-html="info.center">
        <img src="../../assets/images/1.png" alt="">
        <p>最高人民法院</p>
        <p>关于虚开增值税专用发票定罪量刑标准有关问题的通知</p>
        <p>法〔2018〕226号</p>
        <p>各省、自治区、直辖市高级人民法院，解放军军事法院，新疆维吾尔自治区高级人民法院生产建设兵团分院：</p>
        <p>为正确适用刑法第二百零五条关于虚开增值税专用发票罪的有关规定，确保罪责刑相适应，现就有关问题通知如下：</p>
        <p>一、自本通知下发之日起，人民法院在审判工作中不再参照执行《最高人民法院关于适用<全国人民代表大会常务委员会关于惩治虚开、伪造和非法出售增值税专用发票犯罪的决定>的若干问题的解释》（法发〔1996〕30号）第一条规定的虚开增值税专用发票罪的定罪量刑标准。</p>
        <p>二、在新的司法解释颁行前，对虚开增值税专用发票刑事案件定罪量刑的数额标准，可以参照《最高人民法院关于审理骗取出口退税刑事案件具体应用法律若干问题的解释》（法释〔2002〕30号）第三条的规定执行，即虚开的税款数额在五万元以上的，以虚开增值税专用发票罪处三年以下有期徒刑或者拘役，并处二万元以上二十万元以下罚金；虚开的税款数额在五十万元以上的，认定为刑法第二百零五条规定的“数额较大”；虚开的税款数额在二百五十万元以上的，认定为刑法第二百零五条规定的“数额巨大”。</p>
        <p>以上通知，请遵照执行。执行中发现的新情况、新问题，请及时报告我院。</p>
        <p>最高人民法院</p>
        <p>2018年8月22日</p>
      </div>
    </div>
  </div>
</template>

<script>
  import MobileHeader from '../../components/mobileHeader';
  import API from '@/api';

  export default {
    name: 'newsDetailMob',
    components: {MobileHeader},
    data(){
      return {
        info:{}
      };
    },
    mounted(){
      this.getDetaiMob();
    },
    methods:{
      //查询文章列表
      getDetaiMob(){
        API.lpgzharticle.info(parseInt(this.$route.query.id)).then(({data})=>{
         this.info=data.data;
        });
      }
    }
  }
</script>

<style scoped>
  .newsDetaCont{
    display: table;
    width: 100%;
    padding:20px 20px;
    box-sizing: border-box;
    text-align: center;
  }

  .newsDetaCont h3{
    text-align: left;
  }

  .newsDetaCont h5{
    font-size:12px;
    font-weight: normal;
    margin:0;
  }

  .newsDetaCont span{
    font-size:12px;
    margin:10px 20px;
  }

  .newsNei img{
    width: 100%;
  }

  .newsNei{
    display: table;
    width: 100%;
    margin-top:20px;
  }

  .newsNei p{
    text-align: left;
    font-size:14px;
    margin:0;
    margin-bottom: 15px;
  }
</style>
