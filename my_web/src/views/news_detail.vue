<template>
  <div>
    <Nav></Nav>
    <div class="content">
      <div class="contLeft">
        <list-left></list-left>
      </div>
      <div class="contRig">
        <div class="contMbx">
          <a>{{query.itemName}} </a> > <a>{{query.objName}} </a> > <a>{{query.title}}</a>
        </div>
        <div style="border: 1px solid #e4e4e4;margin-top:10px;">
          <div class="pic_detail">
            <h2>{{data.title}}</h2>
            <div class="deta_type">
              <span>{{data.createTime}}</span>
              <span>{{nwesDeta.newsWeb}}</span>
              <span>来源：{{data.source}}</span>
            </div>
            <div v-html="data.center" >

            </div>

           <!-- <h3>{{nwesDeta.newsCont1}}</h3>
            <p>{{nwesDeta.newsCont2}}</p>
            <p>{{nwesDeta.newsCont3}}</p>
            <p>{{nwesDeta.newsCont4}}</p>
            <p>{{nwesDeta.newsCont5}}</p>
            <p>{{nwesDeta.newsCont6}}</p>
            <p>{{nwesDeta.newsCont7}}</p>-->

            <button @click="$router.go(-1)">返回</button>
            <div class="ab_news">
              <p>相关新闻：</p>
              <ul>
                <li v-for="item in abNews" @click="info(item)">{{item.title}}</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div style="position: relative;bottom: -730px;">
      <footer-nav></footer-nav>
    </div>
  </div>
</template>

<script>
  import Nav from '../components/Nav'
  import API from '@/api'
  import ListLeft from '../components/ListLeft';
  import footerNav from '../components/footer_nav'

  export default {
    name: 'news_detail',
    data () {
      return {
        nwesDeta: {
          newsTitle: '工商联主席',
          newsTime: '2018-8-1 11:19:23',
          newsWeb: 'http://www.lpssgsl.com ',
          newsFrom: '六盘水市工商简报',
          newsCont1: '六盘水市工商联简报',
          newsCont2: '六盘水市工商联办公室主办                    2018年 8月1日',
          newsCont3: '六盘水市工商联八一慰问公安消防官兵',
          newsCont4: '值中国人民解放军建军91周年之际，六盘水市工商联走访慰问了公安消防大队子弟兵。',
          newsCont5: '2018年7月31日，会长XXX、秘书长XXX带领商会领导班子成员，常务副会长XXX、副会长XXX、商会顾问XXX、办公室人员和XXX有限公司部分员工一行来到XXX县公安消防大队，看望慰问消防官兵，向消防官兵致以节日的问候并送去了消暑饮品及副食慰问品。',
          newsCont6: 'XXX县消防大队官兵对六盘水市工商联在炎炎夏日慰问消防官兵表示热烈的欢迎和真诚的感谢，表示将不忘初心，牢记使命，为企业健康发展提供良好的消防安全环境。同时，商会将继续做好拥军工作，积极支持消防部队建设，携手并进为经济发展和社会和谐稳定作出积极贡献。',
          newsCont7: '此次走访慰问活动加深了军民鱼水一家亲，体现了军地和谐、军民团结的鱼水深情。'
        },
        abNews: [
          {abNews: '关于通知工商联'},
          {abNews: '关于六盘水市的通知'},
          {abNews: '关于六盘水市工商联通知'},
          {abNews: '关于通知工商'}
        ],
        query:{},
        data:{}
      }
    },
    watch: {
      // 方法1
      '$route' (to, from) {
        this.query=to.query
        this.getInfo();
      }
    },
    components: {
      ListLeft,
      Nav,
      footerNav
    },
    mounted(){
      this.query=this.$route.query
      this.getInfo();
    },
    methods:{
      info(item){
        if(item.type=='0'){
          this.goToUrl('/news_detail',0,{itemName:this.query.itemName,objName:this.query.objName,title:item.title,id:item.id,columnId:item.columnId});
        }else if(item.type=='1'){
          if(item.accessory!=null && item.accessory!=''){
            var obj=JSON.parse(item.accessory);
            location.href=obj[0].url;
          }
        }
      },
      getInfo(){
        API.lparticle.info(parseInt(this.query.id)).then(({data})=>{
          this.data=data.data;
        });

        API.lparticle.list({
          page:1,
          limit:10,
          columnId:this.query.columnId
        }).then(({data})=>{
          this.abNews=data.data.list
        });
      }
    }

  }
</script>

<style scoped>
  .content {
    width: 95%;
    margin: 0 auto;
    margin-top: 30px;
    display: flex;
    justify-content: space-between;
    /*align-items: center;*/
  }

  .contLeft {
    width: 22%;
    position: absolute;
    top: 530px;
  }


  .contRig {
    width: 72%;
    position: absolute;
    top: 530px;
    left: 26%;
    height: 1110px;
    overflow: scroll;
  }
  .contMbx {
    width: 100%;
    border-bottom: 2px solid #e4e4e4;
    padding: 8px 0;
  }

  .contMbx a {
    font-size: 16px;
  }

  .pic_detail {
    text-align: center;
    padding: 0 40px;
    position: relative;
  }

  .pic_detail h2 {
    border-bottom: 1px solid #e4e4e4;
    margin: 0;
    padding: 20px 0;
  }

  .deta_type {
    margin-top: 20px;
  }

  .deta_type span {
    margin: 0 20px;
  }

  .pic_detail h3 {
    margin-bottom: 30px;
  }

  .pic_detail p {
    margin-top: 20px;
    text-align: left;
    line-height: 30px;
  }

  .pic_detail button {
    font-size: 12px;
    background: transparent;
    border: 1px solid #e4e4e4;
    border-radius: 3px;
    padding: 5px 30px;
    margin-top: 60px;
  }

  .ab_news {
    width: 100%;
    padding: 30px 0;
  }

  .ab_news p {
    border-bottom: 1px solid #e4e4e4;
    font-size: 15px;
    font-weight: bold;
    margin: 0;
  }

  .ab_news ul {
    margin: 0;
    padding: 0;
  }

  .ab_news li {
    text-align: left;
    list-style: inside;
    padding: 7px 0;
    font-size: 14px;
    border-bottom: 1px dashed #ccc;
  }

  .ab_news li:nth-last-child(1) {
    border-bottom: none;
  }
</style>
