<template>
  <div class="menu-wrapper">

   <!-- &lt;!&ndash;遍历当前菜单&ndash;&gt;
    <template v-for="(item,index) in menu">
      &lt;!&ndash;处理没有子集&ndash;&gt;
      <el-menu-item v-if="validatenull(item.children) "
                    :index="item.href"
                    @click="open(item)"
                    :key="item.name">
        <i :class="item.icon"></i>
        <span slot="title">{{item.name}}</span>
      </el-menu-item>
      &lt;!&ndash;处理拥有子集&ndash;&gt;
      <el-submenu v-else
                  :index="item.id+''"
                  :key="item.id">
        <template slot="title">
          <i :class="item.icon"></i>
          <span slot="title" :class="{'el-menu&#45;&#45;display':isCollapse}">{{item.name}}</span>
        </template>
        <template v-for="(child,cindex) in item.children"  v-if="validatenull(child.children)">
          <el-menu-item  :class="{'siderbar-active':nowTagValue==child.href}"
                        :index="child.id+''"
                        @click="open(child)"
                        :key="child.name">
            <i :class="child.icon"></i>
            <span slot="title">{{child.name}}</span>
          </el-menu-item>
        </template>
        <sidebar-item v-else :menu="child.children" :key="cindex" :isCollapse="isCollapse"></sidebar-item>
      </el-submenu>
    </template>-->
    <el-submenu
      v-if="menu.children && menu.children.length >= 1"
      :data-idx="menu.id + ''"
      :index="menu.id + ''">
      <template slot="title">
        <i :class=" menu.icon ? menu.icon : 'fa fa-circle-o'"></i>
        <span>{{ menu.name }}</span>
      </template>
      <sidebar-item
        v-for="item in menu.children"
        :key="item.id"
        :menu="item">
      </sidebar-item>
    </el-submenu>
    <el-menu-item
      v-else
      :index="menu.id + ''"
      :data-idx="menu.id + ''"  @click="open(menu)" >
      <i :class=" menu.icon ? menu.icon : 'fa fa-circle-o'"></i>
      <span>{{ menu.name }}</span>
    </el-menu-item>
  </div>
</template>
<script>
  import { validatenull } from '@/util/validate';
  export default {
    name: 'SidebarItem',
    data () {
      return {}
    },
    props: {
      menu: {
        type: Object
      },
      isCollapse: {
        type: Boolean
      }
    },
    created () { },
    mounted () { },
    computed: {
      nowTagValue: function () { return this.$router.$avueRouter.getValue(this.$route) }
    },
    methods: {

      vaildRoles (item) {
        item.meta = item.meta || {};
        return item.meta.roles ? item.meta.roles.includes(this.roles) : true
      },
      validatenull (val) {
        return validatenull(val);
      },
      open (item) {
        var url='';
        console.log(item.url.substring(0,7));
        if(item.url.substring(0,7)==='modules'){
          url='/'+item.url;
        }else{
          url=item.url;
        }

        this.$router.push({
          path: this.$router.$avueRouter.getPath({
            name: item.name,
            src: url
          }),
          query: {id:item.id}
        })
      }
    }
  }
</script>
<style lang="scss" scoped>
  //刷新激活状态
  .siderbar-active {
    i,
    span {
      color: #409eff;
    }
  }
</style>

