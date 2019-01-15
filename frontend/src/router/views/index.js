import Layout from '@/page/index/'
import requestUrl from "../../api/requestUrl";
import $ from "jquery";
import {isAuth,treeDataTranslate,getCookie,getAddress} from '@/utils'
var list = [];
const _import = require('../import-' + process.env.NODE_ENV)
$.ajax({
  url: requestUrl('/sys/sysmenu/router'),
  type: 'post', // GET
  async: false, // 或false,是否异步
  beforeSend: function (request) {
    request.setRequestHeader('token', getCookie('token'))
  },
  //timeout: 5000, // 超时时间
  dataType: 'json', // 返回的数据格式：
  success: function (data, textStatus, jqXHR) {
    for(var i in data.data){
      var item = data.data[i];
      var url = item.url;
      var str = url.substring(url.indexOf("/")+1,url.lastIndexOf("."));
      var name = str.split("/");
      var names = name.length==2?name[1]:name[0];
      try{
            list.push(
              {
          path: '/',
            component: Layout,
            children: [{
            path:url,
            name: item.name,
            component: _import( str+'/index'),
            meta:{ keepAlive:true}
          }],
            meta:{ keepAlive:true}
        }
          );
      }catch (e) {
        console.error(url+"路由不存在");
      }
    }
  }
})
export default [
  ...list,
  {
    path: '/wel',
    component: Layout,
    redirect: '/wel/index',
    children: [{
        path: 'index',
        name: '首页',
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/page/wel'),
    }]
},
  {
    path: '/info',
    component: Layout,
    redirect: '/info/index',
    children: [{
        path: 'index',
        name: '个人信息',
        // meta: { tag: false },配置后不会添加到tag里
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/views/info/index')
    }]
}, {
    path: '/dev',
    component: Layout,
    redirect: '/dev/index',
    children: [{
        path: 'index',
        name: '环境变量',
        component: () =>
            import ( /* webpackChunkName: "utils" */ '@/views/dev/index')
    }]
}, {
    path: '/guide',
    component: Layout,
    redirect: '/guide/index',
    children: [{
        path: 'index',
        name: '引导页',
        component: () =>
            import ( /* webpackChunkName: "utils" */ '@/views/guide/index')
    }]
}, {
    path: '/store',
    component: Layout,
    redirect: '/store/index',
    children: [{
        path: 'index',
        name: '数据持久化',
        component: () =>
            import ( /* webpackChunkName: "utils" */ '@/views/store/index')
    }]
}, {
    path: '/clipboard',
    component: Layout,
    redirect: '/clipboard/index',
    children: [{
        path: 'index',
        name: '剪切板',
        component: () =>
            import ( /* webpackChunkName: "utils" */ '@/views/clipboard/index')
    }]
}, {
    path: '/tags',
    component: Layout,
    redirect: '/tags/index',
    children: [{
        path: 'index',
        name: '标签操作',
        component: () =>
            import ( /* webpackChunkName: "utils" */ '@/views/tags/index')
    }]
}, {
    path: '/role',
    component: Layout,
    redirect: '/role/index',
    children: [{
        path: 'index',
        name: '权限测试页',
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/views/role')
    }]
}, {
    path: '/gray',
    component: Layout,
    redirect: '/gray/index',
    children: [{
        path: 'index',
        name: '灰度模式',
        component: () =>
            import ( /* webpackChunkName: "utils" */ '@/views/gray/index')
    }]
}, {
    path: '/table',
    component: Layout,
    redirect: '/table/index',
    children: [{
            path: 'index',
            name: '表格CRUD',
            component: () =>
                import ( /* webpackChunkName: "table" */ '@/views/table/index')
        },
        {
            path: 'generator',
            name: '表格生成器',
            component: () =>
                import ( /* webpackChunkName: "table" */ '@/views/table/generator')
        },
        {
            path: 'tree',
            name: '普通的tree表格',
            component: () =>
                import ( /* webpackChunkName: "table" */ '@/views/table/table-tree/index')
        },
        {
            path: 'alltree',
            name: '自定义tree表格',
            component: () =>
                import ( /* webpackChunkName: "table" */ '@/views/table/table-tree/all')
        }
    ]
}, {
    path: '/exhibition',
    component: Layout,
    redirect: '/exhibition/index',
    children: [{
        path: 'index',
        name: '数据展示',
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/views/exhibition/index')
    }]
}, {
    path: '/forms',
    component: Layout,
    redirect: '/forms/index',
    children: [{
        path: 'index',
        name: '表单CRUD',
        component: () =>
            import ( /* webpackChunkName: "forms" */ '@/views/forms/index')
    }, {
        path: 'transfer',
        name: '表单自定义',
        component: () =>
            import ( /* webpackChunkName: "forms" */ '@/views/forms/transfer')
    }]
}, {
    path: '/select',
    component: Layout,
    redirect: '/select/index',
    children: [{
        path: 'index',
        name: '多级select联动',
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/views/select/index')
    }]
}, {
    path: '/iconfont',
    component: Layout,
    redirect: '/iconfont/index',
    children: [{
        path: 'index',
        name: '阿里图标',
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/views/iconfont/index')
    }]
}, {
    path: '/logs',
    component: Layout,
    redirect: '/logs/error',
    children: [{
        path: 'error',
        name: '错误日志',
        component: () =>
            import ( /* webpackChunkName: "utils" */ '@/page/logs/error')
    }, {
        path: 'page',
        name: '错误页面',
        component: () =>
            import ( /* webpackChunkName: "utils" */ '@/page/logs/page')
    }]
}, {
    path: '/advanced-router',
    component: Layout,
    children: [{
        path: 'mutative-router',
        name: '动态路由',
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/views/advanced-router/mutative-router')
    }, {
        path: 'argument-page',
        name: '参数路由',
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/views/advanced-router/argument-page')
    }, {
        path: 'mutative-detail/:id',
        name: '动态路由详情页',
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/views/advanced-router/mutative-detail')
    }, {
        path: 'argument-detail',
        name: '参数路由详情页',
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/views/advanced-router/argument-detail')
    }]
}, {
    path: '/admin',
    component: Layout,
    children: [{
        path: 'user',
        name: '用户管理',
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/views/admin/user/index')
    }, {
        path: 'role',
        name: '角色管理',
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/views/admin/role/index')
    }, {
        path: 'menu',
        name: '菜单管理',
        component: () =>
            import ( /* webpackChunkName: "views" */ '@/views/admin/menu/index')
    }]
}]
