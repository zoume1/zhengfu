<template>
  <div>
    <Nav></Nav>
    <div class="content">
      <div class="contLeft">
        <list-left></list-left>
      </div>
      <div class="contRig">
        <div class="contMbx">
          <a>商会风采</a> > <a>领导风采</a> > <a>图片详情页</a>
        </div>
        <div style="border: 1px solid #e4e4e4;margin-top:10px;">
          <div class="pic_detail">
            <h2>工商联主席</h2>
            <div class="deta_type">
              <span>2018-8-1 11:19:23</span>
              <span>http://www.lpssgsl.com</span>
              <span>来源：六盘水市工商简报</span>
            </div>
            <p>
              <img src="../assets/images/img1.png" alt="">
            </p>
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
  import {API} from '../services'
  import ListLeft from '../components/ListLeft';
  import footerNav from '../components/footer_nav'

  export default {
    name: 'Img_detail',
    data () {
      return {
      }
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

  .pic_detail {
    text-align: center;
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

  .pic_detail p {
    margin-top: 40px;
  }
</style>
