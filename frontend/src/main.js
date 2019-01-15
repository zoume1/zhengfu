import 'babel-polyfill'
import 'classlist-polyfill';
import Vue from 'vue';
import {isAuth,treeDataTranslate,getCookie,getAddress} from '@/utils'
import $ from 'jquery'
import requestUrl from './api/requestUrl'
import VueCookie from 'vue-cookie'
import axios from './router/axios';
import VueAxios from 'vue-axios';
import App from './App';
import VueKindEditors from 'vue-kindeditor'
import 'kindeditor/kindeditor-all.js'
import 'kindeditor/themes/default/default.css'

import './permission'; // 权限
import './error'; // 日志
import router from './router/router';
import 'avue-plugin-transfer/packages'
import 'avue-plugin-ueditor/packages'
import store from './store';
import {
  loadStyle
} from './util/util'
import * as urls from '@/config/env';
import {
  iconfontUrl,
  iconfontVersion
} from '@/config/env';
import * as filters from './filters' // 全局filter
import './styles/common.scss';
// 引入avue的包
import '@smallwei/avue/lib/index.js';
// 引入avue的样式文件
import '@smallwei/avue/lib/theme-chalk/index.css';
import basicContainer from './components/basic-container/main'
import VueClipboard from 'vue-clipboard2'
// 插件 json 展示
import vueJsonTreeView from 'vue-json-tree-view'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import Avue from '@smallwei/avue';
import '@smallwei/avue/lib/theme-chalk/index.css';

Vue.use(VueCookie)
Vue.use(VueKindEditors)
Vue.use(Avue)
Vue.use(ElementUI)
Vue.use(VueClipboard)

Vue.use(vueJsonTreeView)

Vue.use(VueAxios, axios)

Vue.component('basicContainer', basicContainer)

Object.keys(urls).forEach(key => {
  Vue.prototype[key] = urls[key];
})

Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key])
})

iconfontVersion.forEach(ele => {
  loadStyle(iconfontUrl.replace('$key', ele));
})

Vue.prototype.$ELEMENT = {size: 'mini'}
Vue.config.productionTip = false
Vue.prototype.isAuth = isAuth;// 挂载权限方法
//系统配置
Vue.prototype.sysConfig={};
var options2="options2";
var data = sessionStorage.getItem(options2);
var maps = sessionStorage.getItem("maps")
//地址信息
Vue.prototype.options2= (data!=''&&data!=null&& data!=undefined)?JSON.parse(data):[];
//地址联动绑定
Vue.prototype.optionsMap= (maps!=''&&maps!=null&& maps!=undefined)?JSON.parse(maps):{};

Vue.prototype.reloadConfig = function () {
  $.ajax({
    url: requestUrl('/sys/sysconfig/getConfig'),
    type: 'post', // GET
    data:{},
    async: false, // 或false,是否异步
    beforeSend: function (request) {
      request.setRequestHeader('token', getCookie('token'))
    },
    dataType: 'json', // 返回的数据格式：
    success: function (data, textStatus, jqXHR) {
      Vue.prototype.sysConfig=data.data;
    }
  })
  if(Vue.prototype.options2==null || Vue.prototype.options2=='' || Vue.prototype.options2==undefined){
    $.ajax({
      url: requestUrl('/sys/syspbarea/getAddressConfig'),
      type: 'post', // GET
      data:{},
      async: false, // 或false,是否异步
      beforeSend: function (request) {
        request.setRequestHeader('token', getCookie('token'))
      },
      dataType: 'json', // 返回的数据格式：
      success: function (data, textStatus, jqXHR) {
        Vue.prototype.options2=treeDataTranslate(data.data,"id","parentid");
        sessionStorage.setItem(options2,JSON.stringify(Vue.prototype.options2))
        for (var j = 0; j < data.data.length; j++) {
          var item1 = data.data[j];
          Vue.prototype.optionsMap[item1.id] = item1;
        }
        sessionStorage.setItem("maps",JSON.stringify(Vue.prototype.optionsMap))
      }
    })
  }
}
Vue.prototype.reloadConfig();
Vue.prototype.busConfig={};
Vue.prototype.treeConfig={};
//获取业务参数
Vue.prototype.getBusConfig = function (module,key) {
  var map = Vue.prototype.busConfig[key];
  if(Vue.prototype.busConfig[key]==null){
    //查询所需业务参数
    $.ajax({
      url: requestUrl('/generator/generatorbusconfig/queryModuleBusConfig'),
      type: 'get', // GET
      data:{module:module},
      async: false, // 或false,是否异步
      beforeSend: function (request) {
        request.setRequestHeader('token', getCookie('token'))
      },
      dataType: 'json', // 返回的数据格式：
      success: function (data, textStatus, jqXHR) {
        Object.assign(Vue.prototype.busConfig,data.data);
        map=Vue.prototype.busConfig[key]
        if (map==null) {
          var module=key.substring(0,key.indexOf("_"));
          var sub=module+key.substring(key.indexOf("_")+1).replace(/_/g,'')

          $.ajax({
            url: requestUrl('/'+module+'/'+sub+"/list"),
            type: 'get', // GET
            data:{limit:10000000},
            async: false, // 或false,是否异步
            beforeSend: function (request) {
              request.setRequestHeader('token', getCookie('token'))
            },
            dataType: 'json', // 返回的数据格式：
            success: function (data, textStatus, jqXHR) {
              if(data.code==0){
                var tab = data.data.tab;
                var datas = {
                  map:{},
                  list:[]
                };
                if(tab!=null){
                  for(var i in data.data.list){
                    var item =data.data.list[i];
                    datas.list.push({confName:item[tab.businessKey],confVue:item[tab.businessValue]});
                    datas.map[item[tab.businessValue]]=item[tab.businessKey];
                  }
                }
                Vue.prototype.busConfig[key]=datas;
                map=datas
              }
            }
          })
        }
      }
    })
  }
  return map;
}
//获取tree数据
Vue.prototype.getTreeConfig = function (key) {
  var map = Vue.prototype.treeConfig[key];
  if (map==null) {
    var module=key.substring(0,key.indexOf("_"));
    var sub=module+key.substring(key.indexOf("_")+1)
    $.ajax({
      url: requestUrl('/'+module+'/'+sub+"/list"),
      type: 'get', // GET
      data:{limit:10000000},
      async: false, // 或false,是否异步
      beforeSend: function (request) {
        request.setRequestHeader('token', getCookie('token'))
      },
      dataType: 'json', // 返回的数据格式：
      success: function (data, textStatus, jqXHR) {
        if(data.code==0){
          var tab = data.data.tab;
          console.log(data.data);
          var treeData=treeDataTranslate([{"name":"一级菜单",parentId:-1,id:0,level:0},...data.data.list],tab.treeKey,tab.parentKey);
          var datas = {
            data:treeData,
            label:tab.treeFieldName,
            levelKey:tab.levelKey
          };
          Vue.prototype.treeConfig[key]=datas;
          map=datas
        }
      }
    })
  }
  return map;
}
Vue.prototype.reloadBusConfig = function (module,key) {
  if(Vue.prototype.busConfig[key]!=null){
    Vue.prototype.busConfig[key]=null;
  }
}
Vue.config.productionTip = false;
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
