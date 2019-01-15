<template>
  <div>
    <Nav></Nav>
    <div class="content">
      <div class="contLeft">
        <list-left></list-left>
      </div>
      <div class="contRig">
        <div class="contMbx">
          <a>商会首页 </a> > <a>人才库 </a> > <a>详情</a>
        </div>
        <div style="border: 1px solid #e4e4e4;margin-top:10px;">
          <div class="taleDetail">
            <h2>{{query.name}}自我介绍</h2>
            <div class="taDeCont">
              <img :src="query.pic" alt="">
              <ul>
                <li>行业：{{sysConfig['lp_talent_text'].map[query.text]}}</li>
                <li>姓名：{{query.name}}</li>
                <li>年龄：{{query.age}}</li>
                <li>性别：{{sysConfig['lp_talent_sex'].map[query.sex]}}</li>
                <li>兴趣爱好：{{query.interest}}</li>
                <li>专长：{{query.speciality}}</li>
                <li>联系方式：{{query.contactWay}}</li>
              </ul>
            </div>

            <p>
              <span>自我介绍：</span><br>
              <span v-text="query.introduce">
                 本人叫张锐，能力很强，薪资要求不高，欢迎大家联系我~
                  本人叫张锐，能力很强，薪资要求不高，欢迎大家联系我~
                  本人叫张锐，能力很强，薪资要求不高，欢迎大家联系我~
                  本人叫张锐，能力很强，薪资要求不高，欢迎大家联系我~
                  本人叫张锐，能力很强，薪资要求不高，欢迎大家联系我~
                  本人叫张锐，能力很强，薪资要求不高，欢迎大家联系我~
              </span>
            </p>
            <b>注：本信息由本人发布，如有任何问题请联系我们！</b>
            <button @click="$router.go(-1)">返回</button>
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
    name: 'talentPoolDetail',
    data () {
      return {
        taleDeta: {
          title: '陶兴锐自我介绍'
        },
        query:{}
      }
    },
    mounted(){
      API.lptalent.info(this.$route.query.id).then(({data})=>{
        this.query=data.data
      })
    },
    components: {
      ListLeft,
      Nav,
      footerNav
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

  .taleDetail{
    text-align: center;
    padding: 0 40px;
    position: relative;
    padding-bottom: 60px;
  }

  .taleDetail h2{
    border-bottom: 1px solid #e4e4e4;
    margin: 0;
    padding: 20px 0;
  }

  .taleDetail button{
    font-size: 12px;
    background: transparent;
    border: 1px solid #e4e4e4;
    border-radius: 3px;
    padding: 5px 30px;
    margin-top: 60px;
  }

  .taDeCont{
    display: flex;
    justify-content: flex-start;
    align-items: center;
    margin: 30px 0;
  }

  .taDeCont li{
    list-style: none;
    text-align: left;
  }

  .taleDetail p{
    text-align: left;
    line-height: 25px;
  }

  .taleDetail b{
    display: table;
    width: 100%;
    margin-top: 90px;
    color:red;
    text-align: left;
  }
</style>
