import Vue from 'vue'
import Router from 'vue-router'
import requestUrl from "../api/requestUrl";
import {getCookie} from '@/utils'
import $ from "jquery";
// 开发环境不使用懒加载, 因为懒加载页面太多的话会造成webpack热更新太慢, 所以只有开发环境使用懒加载
const _import = require('./import-' + process.env.NODE_ENV)
Vue.use(Router)
var list = [];
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
        list.push({path:"/n/"+str,component:_import( str+'/index'),name:names,desc:item.name,meta: { isTab: true }})
      }catch (e) {
        console.error(url+"路由不存在");
      }
    }
  }
})
// 路由定义使用说明:
// 1. 代码中路由统一使用name属性跳转.
// 2. 开放path属性用做简短路由, 比如: '/a1', 访问地址: www.renren.io/#/a1
export default new Router({
  mode: 'hash',
  routes: [
    {path: '/404', component: _import('error/404'), name: '404', desc: '404未找到'},
    {path: '/login', component: _import('login/index'), name: 'login', desc: '登录'},
    {
      path: '/',
      component: _import('layout/index'),
      name: 'layout',
      redirect: {name: 'home'},
      desc: '上左右整体布局',
      children: [
        {path: '/home', component: _import('home/index'), name: 'home', desc: '首页'},
        {
          path: '/content-tabs',
          component: _import('layout/content-tabs'),
          name: 'content-tabs',
          redirect: {name: '404'},
          desc: '内容需通过tabs展示',
          children: [
            ...list,
            { path: '/n/generator/generator', component: _import('generator/generator/index'), name: 'generator', desc: '代码生成', meta: { isTab: true } },
          ]
        }

      ],
      beforeEnter (to, from, next) {
        let token = Vue.cookie.get('token')
        if (!token || !/\S/.test(token)) {
          next({name: 'login'})
        }
        next()
      }
    },
    {path: '*', redirect: {name: '404'}}

  ]
})
