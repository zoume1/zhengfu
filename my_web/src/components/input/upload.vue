<template>
  <div>
    <div class="el-input el-input-group el-input-group--prepend el-input--suffix one-img">
      <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{pageComment}}</label></div>
      <!--上传图片-->
      <el-upload size="mini" :disabled="disabled"
                 :action="imgUrl"
                 :file-list="imgList"
                 :class="(imgList.length!=0 &&imgList!=''&&imgList!=null &&!isMultiple)?'disabled':''"
                 list-type="picture-card"
                 :show-file-list="true"
                 :on-remove="handleRemove"
                 :on-success="handleAvatarSuccess"
                 :before-upload="beforeAvatarUpload" :on-preview="handlePictureCardPreview">
        <i class="el-icon-plus"></i>
      </el-upload>
    </div>
    <el-dialog :visible.sync="prewImgLoad" :modal="false">
      <img width="100%" :src="prewImg" alt="">
    </el-dialog>
  </div>
</template>

<script>
  import API from '@/api'

  export default {
    name: "UploadImg",
    data() {
      return {
        imgList: [],
        prewImgLoad: false,
        prewImg: null,
        imgUrl: API.sysoss.upload(this.$cookie.get('PC_TOKEN')),
      }
    },
    watch:{
      value(list){
      if (list instanceof Array ) {
          this.imgList = list;
      } else if(list!=''){
        this.imgList = [{urd: 888, name: 4564, url: list}];
      }else{
        this.imgList=[];
      }
      },
      imgList (val) {
          if(this.isMultiple){
            this.$emit('input', val)
          }else{
            if(val.length==0){
              this.$emit('input', '')
            }else{
              this.$emit('input',val[0].url)
            }
          }
      },
    },
    props: {
      isPage:{
        type:Boolean,
        default:false
      },
      disabled:{
        type:Boolean,
      default:false
      },
      isMultiple:{
        type:Boolean,
        default:false
      },
      // 使用v-module必须要使用value
      value: {
        default: null,
      },
      //注释
      pageComment: {
        type: String,
        default: ''
      }
    },
    methods: {
      oneImgText(val, fieldNmae) {
        if (val == null || val === '') {
          return [];
        }
        return [{urd: 888, name: fieldNmae, url: val}];
      },
      uploadDisabled(size) {
        return size != null && size != '' && size.length!=0;
      },
      // 多图片上传删除事件
      handleRemove(file, fileList) {
        if(this.isMultiple){
          this.imgList=fileList;
        }else{
          this.imgList=[];
        }
      },
      // 预览多图片事件
      handlePictureCardPreview: function (file) {
        this.prewImgLoad = true
        this.prewImg = file.url
      },
      // 添加多图片上传事件
      handleAvatarSuccess: function (res, file) {
        console.log(res);
        if(this.isMultiple){
          this.imgList.push({urd: 888,name:23423, url: res.url})
        }else{
          this.imgList=[{urd: 888,name:23423, url: res.url}]
        }
      },
      // 图片上传格式验证
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg'
        const isLt2M = file.size / 1024 / 1024 < 2
        return true
      },
    }
  }
</script>
<style lang="scss">
  .disabled .el-upload--picture-card {
    display: none;
  }
</style>
<!--
<style scoped>
  .disabled .el-upload&#45;&#45;picture-card {
    display: none;
  }
</style>
-->
