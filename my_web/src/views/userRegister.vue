<template>
  <div class="myIn">
    <div class="headMine">填写个人会员信息</div>
    <div style="width: 100%;height: 3rem;">
      <div style="width: 90%;height: 100%;display: flex;align-items: center;justify-content: center;">
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
  </div>

</template>

<script>
  import {API} from '../services'
  import footerNav from '../components/footer_nav'

  export default {
    name: 'activityList',
    data() {
      return {}
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
  }

  .myMain {
    width: 95%;
    height: 100%;
    background-image: url("../assets/images/u509.png");
  }

  .headIn {
    width: 100%;
    height: 5rem;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
  }

  .headRight {
    width: 60%;
    height: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: flex-start;
    padding-left: 200px;
  }

  .headRight p {
    font-size: 25px;
    font-weight: 700;
    color: #ffffff;
  }

  .headRight span {
    font-size: 18px;
    font-weight: 500;
    color: #ffffff;
  }

  .headLeft {
    width: 40%;
    height: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
  }

  .headJump {
    width: 95%;
    height: 4rem;
  }

  .toIndex {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
  }

  .toIndex p {
    width: 33%;
    height: 100%;
    text-align: center;
    line-height: 4rem;
  }

  .headMine {
    width: 100%;
    height: 2rem;

  }

  .headIpt {
    width: 33%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
  }

</style>
