<template>
  <div id="app" style="width: 100%;height: 100%">
    <router-view transition="fade" transition-mode="out-in" keep-alive></router-view>
  </div>
</template>

<script>

  import {API} from './services'

  export default {
    name: 'app',
    components: {},
    data() {
      return {
        isIndex: true,
        cityMsg: {},
        active: {
          home: true,
          find: false,
          car: false,
          user: false
        }
      }
    },
    mounted() {

    },
    methods: {
      fetchDate: function () {

      }
    },
    watch: {
      '$route': 'fetchDate'
    }
  }
</script>

<style>
  [v-cloak] {
    display: none;
  }
</style>
