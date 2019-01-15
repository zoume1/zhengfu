<template>
 <!-- <div>
    <el-row :span="24">
      <el-col :span="10">
        <basic-container>
          <div class="info">
            <div class="img-border">
              <a href="#">
                <div class="img"><img src="https://gitee.com/uploads/61/632261_smallweigit.jpg"></div>
              </a><img alt="用户等级"
                   src="data:image/png;base64,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"
                   class="img-v"></div>
            <div class="user">
              <div class="user-img">
                <a href="#">
                  <span style="user-title">smallwei</span>
                </a>
                <div class="user-subtitle">VIP用户1</div>
              </div>
              <div class="user-item">绑定机构：Avue后台模版</div>
              <div class="user-item">认证信息：hello 大家好！</div>
            </div>
          </div>
        </basic-container>
      </el-col>
      <el-col :span="14">
        <basic-container>
          <avue-data-icons :option="easyDataOption2"></avue-data-icons>
        </basic-container>
      </el-col>
    </el-row>
    <basic-container>
      <avue-data-box :option="easyDataOption"></avue-data-box>
    </basic-container>
    <basic-container>
      <avue-crud :data="data"
                 :option="tableOption">
        <template slot-scope="scope"
                  slot="username">
          <el-tag>{{scope.row.username}}</el-tag>
        </template>
        <template slot-scope="scope"
                  slot="stars">
          <a :href='scope.row.git'
             target="_blank">
            <img :src="scope.row.stars"
                 alt='star' />
          </a>
        </template>
        <template slot-scope="scope"
                  slot="address">
          <a :href="scope.row.git"
             target="_blank">{{scope.row.address}}</a>
        </template>
      </avue-crud>
    </basic-container>
  </div>-->
  <div class="site-content site-content--home">
    <el-card >
      <el-form ref="form"  label-position="left" :model="form" label-width="100px" style="width:50%">
        <el-form-item label="网站名称" >
          <el-input v-model="form.siteName.value" size="mini"></el-input>
        </el-form-item>
        <el-form-item label="站点根网站">
          <el-input v-model="form.webSite.value"  size="mini"></el-input>
        </el-form-item>
        <!--创建条目输入框-->
        <el-form-item  label="请填写关键字"   >
          <el-input  v-model="form.selectKey.value"  size="mini"></el-input>
        </el-form-item>
        <!--文本域-->
        <el-form-item label="站点描述">
          <el-input v-model="form.siteDescribe.value" :rows="2" :autosize="{ minRows: 10, maxRows: 4}" type="textarea" size="mini"></el-input>
        </el-form-item>
        <el-form-item label="公司地址">
          <el-input  v-model="form.companyAddress.value"  size="mini"></el-input>
        </el-form-item>
        <el-form-item label="网站备案号">
          <el-input v-model="form.aq.value"  size="mini"></el-input>
        </el-form-item>
        <el-form-item label="网站版权信息">
          <el-input v-model="form.copyright.value"  size="mini"></el-input>
        </el-form-item>
        <el-form-item label="网站logo">
          <upload   v-model="form.logo.value" :isMultiple="false"  size="mini"></upload>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">保存</el-button>
          <el-button @click="restore">还原</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>






</template>

<script>
  import {getAddress,queryAddressById,treeDataTranslate} from '@/utils'
  import linkage from '@/components/input/linkage.vue'
  import upload from '@/components/input/upload.vue'
  import API from '@/api'
  export default {
    components: {
      API,
      upload,
      linkage
    },
    data () {
      return {
        defaultData:{},
        form: {
          siteName:{value:''},
          webSite:{value:''},
          selectKey:{value:''},
          siteDescribe:{value:''},
          companyAddress:{value:''},
          copyright:{value:''},
          aq:{value:''},
          logo:{value:''},
        }
      }
    },
    created () {
      API.sysconfig.getConfig({}).then(({data})=>{
        this.defaultData=data.data;
        this.form=JSON.parse(JSON.stringify(data.data));
      });
    },
    methods: {
      onSubmit(){
        API.sysconfig.updateConfig(this.form).then(({data})=>{
          this.$message({
            message: '操作成功',
            type: 'success',
            duration: 1500,
            onClose: () => {
              this.defaultData=JSON.parse(JSON.stringify(this.form));
            }
          })

        });
      },
      restore(){
        this.form=JSON.parse(JSON.stringify(this.defaultData));
      }
    }
  }
</script>

<style scoped >
  /*  !*.site-content--home {*!
    !*line-height: 1.5;*!
    !*}*!*/
  ul {
    margin: 0;
    padding: 0;
  }

  .home {
    padding: 20px;
    background: #fff;
  }

  .home_model {
    width: 100%;
    height: 120px;
    text-align: center;
    color: #fff;
    font-size: 16px;
    line-height: 120px;
    margin: 0 auto;
    cursor: pointer;
  }

  .swiper-container {
    height: auto !important;
    margin-left: auto;
    margin-right: auto;
    padding: 0 40px;
  }

  .swiper-slide {
    background: rgba(107, 107, 107, 1);
  }

  .home_slide {
    width: 100%;
  }

  .swiper-button-prev {
    left: 0;
  }

  .file-card {
    border: 1px solid #ccc;
    border-radius: 10px;
    margin-bottom: 40px;
  }

  .file_work {
    display: table;
    width: 100%;
    margin-top: 50px;
  }

  .file_cab {
    width: 50%;
    float: left;
    padding: 0 30px;
  }

  .work_jour {
    width: 50%;
    float: left;
    padding: 0 30px;
  }

  .file_top {
    border-bottom: 1px solid #ccc;
  }

  .el-card__body {
    padding: 0;
  }

  .file_top {
    padding: 15px;
    position: relative;
  }

  .file_top p {
    margin: 0;
    font-size: 20px;
    font-weight: bold;
  }

  .file_cont {
    display: table;
    width: 100%;
    padding: 60px 20px;
    min-height: 350px;
  }

  .file_cont ul {
    margin: 0;
    padding: 0;
  }

  .file_cont li {
    display: inline-block;
    border-radius: 10px;
    background: #FF9900;
    box-shadow: 0 0 5px #000;
    list-style: none;
    width: 39%;
    text-align: center;
    color: #fff;
    font-size: 18px;
    font-weight: bold;
    margin: 0 22px;
    margin-bottom: 30px;
    padding: 40px;
    cursor: pointer;
  }

  .file_cont li:nth-child(2) {
    background: #FF0000
  }

  .file_cont li:nth-child(3) {
    background: #00CC99;
    margin-bottom: 0;
  }

  .file_cont li:nth-child(4) {
    background: #3399CC;
    margin-bottom: 0;
  }

  .file_top span {
    position: absolute;
    right: 0;
    display: inline-block;
    top: 0;
    width: 73px;
    height: 100%;
    text-align: center;
    font-size: 32px;
    border-left: 1px solid #ccc;
    line-height: 55px;
    cursor: pointer;
  }

  .file_top span:hover {
    background: rgba(102, 102, 102, 1);
    color: #fff;
  }

  .file_cont li:hover {
    opacity: 0.7;
  }

  .work_top p {
    display: inline-block;
  }

  .work_top ul {
    display: inline-block;
    margin-left: 40px;
  }

  .work_top li {
    display: inline-block;
    margin-right: 10px;
    position: relative;
    cursor: pointer;
    padding: 0 10px;
  }

  .work_top li:hover {
    color: #3399CC;
  }

  .work_top li:hover:after {
    content: "";
    position: absolute;
    height: 2px;
    background: #3399CC;
    width: 100%;
    left: 0;
    bottom: -18px;
  }

  .work_deta .vdp-datepicker .vdp-datepicker__calendar {
    /*padding:15px;*/
    width: 100% !important;
    border: none;
  }

  .work_deta button {
    width: 122px;
    height: 40px;
    color: #fff;
    font-size: 18px;
    line-height: 40px;
    border: none;
    background: #3399CC;
    border-radius: 4px;
    float: right;
    margin-right: 20px;
    cursor: pointer;
  }

  .work_deta {
    /*padding-bottom: 30px;*/
    display: table;
    min-height: 350px;
    width: 100%;
  }

  .work_deta button:hover {
    opacity: 0.7;
  }

  .work_deta li {
    border-bottom: 1px solid #ccc;
    /*padding:15px 0;*/
    list-style: none;
    display: table;
    width: 100%;
  }

  .work_tit {
    float: left;
    width: 60%;
    padding: 15px 0;
    padding-left: 15px;
  }

  .work_tit:hover, .work_man:hover {
    background: rgba(242, 242, 242, 1);
  }

  .work_man {
    float: left;
    width: 40%;
    padding: 15px 0;
    padding-left: 15px;
  }

  .work_hui {
    padding: 15px 0;
    padding-left: 15px;
    display: table;
    width: 100%;
  }

  .work_hui:hover {
    background: rgba(242, 242, 242, 1);
  }

  .home_page{
    text-align: center;
    margin:30px 0;
  }
</style>
