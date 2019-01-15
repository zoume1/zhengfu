<template>
  <div id="videos">
    <!-- action必选参数, 上传的地址 -->
    <el-upload class="avatar-uploader el-upload--text" :action="imgUrl" :show-file-list="false" :on-success="handleVideoSuccess" :before-upload="beforeUploadVideo" :on-progress="uploadVideoProcess">
      <video v-if="videoForm !='' && videoFlag == false" :src="videoForm" class="avatar" controls="controls">您的浏览器不支持视频播放</video>
      <i v-else-if="videoForm =='' && videoFlag == false" class="el-icon-plus avatar-uploader-icon"></i>
      <el-progress v-if="videoFlag == true" type="circle" :percentage="videoUploadPercent" ></el-progress>
    </el-upload>
   <!-- <P class="text">请保证视频格式正确，且不超过10M</P>-->
  </div>
</template>
<script>
  import API from '@/api'
  export default {
    data() {
      return {
        imgUrl: API.sysoss.uploadVideo(this.$cookie.get('token')),
        videoForm:'',
        videoUploadPercent:0,
        videoFlag:false,
      };
    },
    watch:{
      value:function(val){
        this.videoForm=val;
      },
      videoForm:function (val) {
        this.$emit('input',val)
      }
    },
    props:{
      // 使用v-module必须要使用value
      value: {
        default: null,
      },
    },
    methods: {
      handleVideoSuccess(res, file) {                           //获取上传图片地址
        this.videoFlag = false;
        this.videoUploadPercent = 0;
        if(res.code == 0){
          this.videoForm = res.url;
        }else{
          this.$message.error('视频上传失败，请重新上传！');
        }
      },
      handleRemove(file, fileList) {
        this.list=fileList
      },
      handleAvatarSuccess(res, file) {
        this.list.push({urd: 888,name:file.name, url: res.url})
      },
      uploadVideoProcess(event, file, fileList){
        this.videoFlag = true;
        this.videoUploadPercent = file.percentage.toFixed(0);
      },
      beforeUploadVideo(file) {
        const isLt10M = file.size / 1024 / 1024  < 10;
        if (['video/mp4', 'video/ogg', 'video/flv','video/avi','video/wmv','video/rmvb'].indexOf(file.type) == -1) {
          this.$message.error('请上传正确的视频格式');
          return false;
        }
        if (!isLt10M) {
          this.$message.error('上传视频大小不能超过10MB哦!');
          return false;
        }
      },
    }
  }
</script>
<style scoped>
  #videos >>> .el-upload{
    width:100%;
  }
  #videos >>> video{
    width:100%;
  }
</style>
