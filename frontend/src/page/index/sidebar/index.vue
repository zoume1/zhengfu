<template>
  <div class="sidebar-container"
       :class="{'is-active':isCollapse}">
    <logo :isCollapse="isCollapse"></logo>
    <el-menu unique-opened
             :default-active="index+''"
             mode="vertical"
             :show-timeout="200"
             background-color="#00142a"
             text-color="hsla(0,0%,100%,.65)"
             active-text-color="#409eff"
             :collapse="isCollapse">
      <sidebar-item v-for="menuNav in menu" :key="menuNav.id" :menu="menuNav"   :isCollapse="isCollapse"></sidebar-item>
    </el-menu>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  import SidebarItem from './sidebarItem'
  import logo from './logo'
  export default {
    name: 'sidebar',
    props:{
      menu:{
        type:Array,
      }
    },
    components: { SidebarItem, logo },
    data () {
      return {
        index:1
      }
    },
    created () {

    },
    computed: {
      ...mapGetters([ 'tag', 'isCollapse']),
    },
    mounted () {
      this.index=this.$route.query.index;
    },
    methods: {}
  }
</script>
<style lang="scss" scoped>
</style>

