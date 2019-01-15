<template>
  <div class="Lileft">
    <div class="ggOne" v-for="item in list">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>{{item.name}}</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click=" goToUrl('/news_list',0,{itemName:item.parentName,objName:item.name,columnId:item.id});">more</el-button>
        </div>

        <div v-for="obj in item.list" class="text item"@click="goToUrl('/news_detail',0,{itemName:item.name,objName:item.parentName,title:obj.title,id:obj.id,columnId:item.id})">
          <div>
            <span> {{obj.title}}</span>
          </div>
        </div>
      </el-card>
    </div>
   <!-- <div class="ggOne">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>商会新闻</span>
          <el-button style="float: right; padding: 3px 0" type="text">more</el-button>
        </div>
        <div v-for="item in tzgg" class="text item">
          {{item}}
        </div>
      </el-card>
    </div>
    <div class="ggOne">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>会员动态</span>
          <el-button style="float: right; padding: 3px 0" type="text">more</el-button>
        </div>
        <div v-for="item in tzgg" class="text item">
          {{item}}
        </div>
      </el-card>
    </div>
    <div class="ggOne">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>招商投资</span>
          <el-button style="float: right; padding: 3px 0" type="text">more</el-button>
        </div>
        <div v-for="item in tzgg" class="text item">
          {{item}}
        </div>
      </el-card>
    </div>
    <div class="ggOne">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>法律维权</span>
          <el-button style="float: right; padding: 3px 0" type="text">more</el-button>
        </div>
        <div v-for="item in tzgg" class="text item">
          {{item}}
        </div>
      </el-card>
    </div>
    <div class="ggOne">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>商会文化</span>
          <el-button style="float: right; padding: 3px 0" type="text">more</el-button>
        </div>
        <div v-for="item in tzgg" class="text item">
          {{item}}
        </div>
      </el-card>
    </div>-->
  </div>
</template>

<script>
  import {Card} from 'element-ui'
  import API from '@/api'

  export default {
    name: 'list-left',
    data() {
      return {
        tzgg: [
          '关于通知工商联',
          '关于六盘水市的通',
          '关于六盘水市工商联通知'
        ],
        list:[],

      }
    },


    components: {
      Card
    },
    mounted(){
      this.getList();
    },
    methods:{
      getList(){
        API.lparticle.dynamicNotification().then(({data})=>{
          this.list=data.data;
        });
      }
    }
  }
</script>

<style scoped>
  .text {
    font-size: 14px;
  }

  .item {
    /*margin-bottom: 18px;*/
    border-bottom: 1px dashed #4681C3;
    padding: 8px 0;
    cursor: pointer;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 100%;
    border: 1px solid #4681C3;
  }

  .el-card{
    color:#4681C3
  }

  .ggOne{
    margin-bottom:30px;
  }

</style>
