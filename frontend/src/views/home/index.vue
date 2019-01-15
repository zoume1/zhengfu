<template>
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

