<template>
  <el-dialog :title="!isMultiple ? '预览图片' : '预览图库'" :modal-append-to-body="false" :close-on-click-modal="false"  :visible.sync="visible">
    <img width="100%" height="100%" :src="url" alt="" v-if="!isMultiple">
    <el-carousel :interval="4000" arrow="always"  height="400px"  v-if="isMultiple">
      <el-carousel-item v-for="item in url" :key="item">
        <img width="100%" height="100%" :src="item.url" alt="" >
      </el-carousel-item>
    </el-carousel>
  </el-dialog>
</template>

<script>
  export default {
    name: "previewEdition",
    data() {
      return {
        visible:false,
        url:null
      }
    },
    props:{
      isMultiple:{
        type:Boolean,
        default:false
      },
    },
    watch: {

    },
    methods:{
      init(url,isMultiple){
        this.isMultiple=isMultiple;
        if(url!=null){
          this.visible=true;
          if(isMultiple){
            try{
            this.url=JSON.parse(url);
            }catch (e) {
              this.url=url
            }
          }else{
            this.url=url
          }
        }

      }
    }
  }
</script>
<style scoped>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }


</style>
