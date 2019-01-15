<template>
  <div>
  <el-upload
    class="upload-demo"
    drag
    :action="imgUrl"
    :on-success="handleAvatarSuccess"
    :on-remove="handleRemove"
    :file-list="list" :on-preview="preview" :limit="1"  :before-upload="beforeAvatarUpload">
    <i class="el-icon-upload"></i>
    <div class="el-upload__text">将文件拖到此处，或<em >点击上传</em></div>
    <div class="el-upload__tip" slot="tip">只能上传excel文件，且不超过3M</div>
  </el-upload>
  </div>
</template>
<script>
  import API from '@/api'
  export default {
    data() {
      return {
        imgUrl: API.sysoss.uploadAccessory(this.$cookie.get('token')),
        list: this.value
      };
    },
    watch:{
      value:function(val){
        console.log(val);
        this.list=val;
      },
      list:function (val) {
        this.$emit('input',val)
      }
    },
    props:{
      // 使用v-module必须要使用value
      value: {
        default: null,
      },
    },
    created(){
      console.log(this.value);
    },
    methods: {
      handleRemove(file, fileList) {
        this.list=fileList
      },
      handleAvatarSuccess(res, file) {
        this.list.push({urd: 888,name:file.name, url: res.url})
      },
      // 图片上传格式验证
      beforeAvatarUpload(file) {
        console.log(file.type);
        const isJPG = file.type === 'application/vnd.ms-excel'
        const isLt2M = file.size / 1024 / 1024 <3
        if (!isJPG) {
          this.$message.error("上传附件格式只能是excel!");
        }
        if (!isLt2M) {
          this.$message.error("上传附件大小不能超过 3MB!");
        }
        return isJPG && isLt2M;
      },
      //下载文件
      preview(file){
          location.href=file.url;
      }
    }
  }
</script>
