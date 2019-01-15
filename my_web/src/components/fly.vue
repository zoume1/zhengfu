<template>
  <div id="wrap">
    <ul id="list" style="display: flex;
    flex-direction: row;">
      <li v-for="item in list">
        <img :src="item.pic"/>
      </li>
    </ul>
  </div>
</template>
<script>
  export default {
    name: 'fly',
    props: {
      list: {
        type: Array,
        default: []
      }
    },
    data() {
      return {
        animate: false,
        items: this.list,
        page: [1, 2, 3, 4, 5]
      }
    },
    created() {
      console.log('==========================================================================================')
      console.log(this.list);
      setInterval(this.scroll, 2500)
    },
    watch: {
      list: function (val) {
      //  this.items = val;
      }
    },
    methods: {
      scroll() {
        this.animate = true
        setTimeout(() => {
          this.items.push(this.items[0]);
          this.items.shift();
          this.animate = false;  // 这个地方如果不把animate 取反会出现消息回滚的现象，此时把ul 元素的过渡属性取消掉就可以完美实现无缝滚动的效果了
        }, 1500)
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  * {
    margin: 0;
    padding: 0;
  }

  #wrap {
    width: 100%;
    height: 270px;
    position: relative;
    overflow: hidden;
  }

  #list {
    position: absolute;
    left: 0;
    top: 0;
    margin: 0;
    padding: 0;
    -webkit-animation: 15s move infinite linear;
    width: 100%;
  }

  #list li {
    list-style: none;
    width: 460px;
    height:270px;
    color: #fff;
    font: 50px/98px Arial;
    text-align: center;
    float: left;
    padding-left: 50px;
    padding-right: 50px;
  }
  #list li img {
    width: 350px;
    height: 100%;
    object-fit: cover;
  }

  @-webkit-keyframes move {
    0% {
      left: 0;
    }
    100% {
      left: -500px;
    }
  }

  @keyframes move {
    0% {
      left: 0;
    }
    100% {
      left: -500px;
    }
  }
  #wrap:hover #list {
    -webkit-animation-play-state: paused; /*动画暂停播放*/
  }
</style>
