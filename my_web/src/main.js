import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import VueLazyLoad from 'vue-lazyload'
import {getAddress, getCookie, isAuth, treeDataTranslate} from '@/utils'
import VueCookie from 'vue-cookie'
import VueResource from 'vue-resource'
import './common/style.css' // 这里需要引入基本的样式
// 这一句必须写，用来规避ES6的语法检测slint-disable no-unused-vars
// console.log('test')
// 配置中文
import {baseUrl} from '@/config/env'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import $ from 'jquery'
import requestUrl from "@/api/requestUrl";

Vue.use(ElementUI);
Vue.use(VueCookie);
Vue.use(VueLazyLoad, {
  loading: require('./assets/lazy.png')
})

Vue.use(VueResource)

Vue.prototype.sysConfig = {};
Vue.prototype.timeFormat = function (value) {
  return value.substring(0, 11);
};
var options2 = "options2";
var data = sessionStorage.getItem(options2);
var maps = sessionStorage.getItem("maps")
//地址信息
Vue.prototype.options2 = (data != '' && data != null && data != undefined) ? JSON.parse(data) : [];
//地址联动绑定
Vue.prototype.optionsMap = (maps != '' && maps != null && maps != undefined) ? JSON.parse(maps) : {};


Vue.prototype.reloadConfig = function () {
  if (Vue.prototype.options2 == null || Vue.prototype.options2 == '' || Vue.prototype.options2 == undefined) {
    $.ajax({
      url: baseUrl + '/sys/syspbarea/getAddressConfig',
      type: 'post', // GET
      data: {},
      async: false, // 或false,是否异步
      dataType: 'json', // 返回的数据格式：
      success: function (data, textStatus, jqXHR) {
        Vue.prototype.options2 = treeDataTranslate(data.data, "id", "parentid");
        sessionStorage.setItem(options2, JSON.stringify(Vue.prototype.options2))
        for (var j = 0; j < data.data.length; j++) {
          var item1 = data.data[j];
          Vue.prototype.optionsMap[item1.id] = item1;
        }
        sessionStorage.setItem("maps", JSON.stringify(Vue.prototype.optionsMap))
      }
    })
  }
}
Vue.prototype.reloadConfig();


$.ajax({
  url: baseUrl + "/generator/generatorbusconfig/querySysBusConfigList",
  type: 'get', // GET
  data: {limit: 10000000},
  async: false, // 或false,是否异步
  dataType: 'json', // 返回的数据格式：
  success: function (data, textStatus, jqXHR) {
    Vue.prototype.sysConfig = data.data;
  }
})
var user = sessionStorage.getItem("user");
Vue.prototype.user = (user != '' && user != null && user != undefined) ? JSON.parse(user) : null;
Vue.prototype.setUser=function(user){
  Vue.prototype.user=user;
  sessionStorage.setItem("user",JSON.stringify(user));
  this.$cookie.set('PC_TOKEN', user.token);
}

Vue.prototype.busConfig = {};
Vue.prototype.treeConfig = {};
//获取业务参数
Vue.prototype.getBusConfig = function (module, key) {
  var map = Vue.prototype.sysConfig[key];

  if (map == null) {
    //查询所需业务参数
    var module = 'lppc';
    var sub = key.replace(/_/g, '')
    $.ajax({
      url: requestUrl('/' + module + '/' + sub + "/list"),
      type: 'get', // GET
      data: {limit: 10000000},
      async: false, // 或false,是否异步
      beforeSend: function (request) {
        request.setRequestHeader('PC_TOKEN', getCookie('PC_TOKEN'))
      },
      dataType: 'json', // 返回的数据格式：
      success: function (data, textStatus, jqXHR) {
        if (data.code == 0) {
          var tab = data.data.tab;
          var datas = {
            map: {},
            list: []
          };
          if (tab != null) {
            for (var i in data.data.list) {
              var item = data.data.list[i];
              datas.list.push({confName: item[tab.businessKey], confVue: item[tab.businessValue]});
              datas.map[item[tab.businessValue]] = item[tab.businessKey];
            }
          }
          Vue.prototype.busConfig[key] = datas;
          map = datas
        }
      }
    })
  }
  return map;
}


Vue.prototype.goToUrl = function (path, type = 0, json = {}) {


  if (type == 0) {
    this.$router.push({path: path, query: json});
  } else if (type == 1) {
    console.log(this.$router.replace({path: path, query: json}));
  }

};
// 挂载权限方法
Vue.config.productionTip = false
Vue.http.options.root = process.env.NODE_ENV === 'development' ? '' : ''
Vue.http.options.emulateJSON = false
Vue.http.interceptors.push((request, next) => {
  next((response) => { //  在响应之后传给then之前对response进行修改和逻辑判断。对于token时候已过期的判断，就添加在此处，页面中任何一次http请求都会先调用此处方法
    if (response.status === 911) {
      router.replace({path: 'login'})
    }
    return response
  })
})


// const routers = new VueRouter({
//   routes: router,
//   mode: 'history'
// })
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
