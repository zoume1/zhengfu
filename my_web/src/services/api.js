import Vue from 'vue'
import { baseUrl } from '@/config/env'
console.log(baseUrl);
var API_ROOT = baseUrl
export const home = {
  getServerList(data) {
    return Vue.http.get(API_ROOT + '/lppc/lpimage/list?&sidx=createTime&order=desc&page=' + data.page + '&limit=' + data.limit + '&type=' + data.type)
  },
  // 商会新闻
  getBussniesNews(data) {
    return Vue.http.get(API_ROOT + '/lppc/lparticle/searchHomeArticles')
  },
  // 广告轮播图
  getLpadvertising(data) {
    return Vue.http.get(API_ROOT + '/lppc/lpadvertising/list?type='+data.type)
  },

}

// 首页导航栏请求
export const nav = {
  //查询首页菜单数据
  getUrlList(data) {
    return Vue.http.get(API_ROOT + '/lppc/lpcolumn/list')
  },
  //查询首页消息通知

  getLparticleList(data) {
    return Vue.http.get(API_ROOT + '/lppc/lparticle/list')
  }

}
