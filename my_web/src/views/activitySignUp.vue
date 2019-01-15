<template>
  <div>
    <Nav></Nav>
    <div class="content">
      <div class="contLeft">
        <list-left></list-left>
      </div>
      <div class="contRig">
        <div class="contMbx">
          <a>商会首页</a> > <a>活动报名列表</a> > <a>活动报名</a>
        </div>
        <div style="border: 1px solid #e4e4e4;margin-top:10px;">
          <div class="activiCont">
            <h4>活动名：</h4>
            <p v-text="query.name"></p>
            <h4>活动状态：</h4>
            <p>{{sysConfig['lp_activity_state'].map[query.state]}}</p>

            <h4>报名时间：</h4>
            <p>{{query.applyStartTime}} ~ {{query.applyEndTime}}</p>
            <h4>活动时间：</h4>
            <p>{{query.activityTime}}</p>
            <h4>活动地点：</h4>
            <p>{{query.address}}</p>
            <h4>活动内容：</h4>
            <p v-html="query.content">
              12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！12月中旬举办联欢会，有兴趣的报名参加！
            </p>
            <div class="activiBtn">
              <button @click="save(query.id)">报名</button>
              <button @click="$router.go(-1)">返回</button>
              <button>分享</button>
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
  import ListLeft from '../components/ListLeft';
  import API from '@/api';
  import footerNav from '../components/footer_nav'

  export default {
    name: 'activitySignUp',
    data() {
      return {
        query: {}
      }
    },
    components: {
      ListLeft,
      Nav,
      footerNav
    },
    mounted() {
      API.lpactivity.info(this.$route.query.id).then(({data})=>{
        this.query=data.data
      })
    },
    methods: {
      save(id) {
        var that = this;
        API.lporganizers.add({id:id}).then(({data})=>{
          if(data.code==0){
            that.$message({
              message: '操作成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                that.$router.go(-1);
              }
            })
          }else{
            that.$message.error(data.msg)
          }

        })
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

  .activiCont {
    padding: 0 20px;
    padding-bottom: 60px;
  }

  .activiCont h4 {
    margin: 0;
    margin-top: 30px;
  }

  .activiCont p {
    margin: 0;
    line-height: 27px;
  }

  .activiBtn {
    display: table;
    width: 100%;
    margin: 0 auto;
    text-align: center;
    margin: 70px 0;
  }

  .activiBtn button {
    padding: 5px 20px;
    background: #fff;
    border: 1px solid #ccc;
    margin: 0 20px;
    border-radius: 3px;
  }

  .activiBtn button:first-child {
    background: rgb(0, 102, 204);
    color: #fff;
  }

</style>
