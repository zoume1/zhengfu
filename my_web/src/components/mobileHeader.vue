<template>
    <div class="mobHeader">
      <span class="el-icon-arrow-left" @click="$router.go(-1)"></span>
      <div></div>
    </div>
</template>

<script>
  export default {
    name: 'mobileHeader'
  }
</script>

<style scoped>
  .mobHeader{
    border-bottom:1px solid #ccc;
    padding:10px 10px;
  }
</style>
