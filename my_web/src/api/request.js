import Vue from 'vue'
import axios from 'axios'
import router from '@/router'

// 创建axios实例
const service = axios.create({
  timeout: 1000 * 30,
  withCredentials: true,
  headers: {
    'Content-Type': 'application/json; charset=utf-8'
  }
})
var loading=null;

// request拦截器
service.interceptors.request.use(config => {
  config.headers['PC_TOKEN'] = Vue.cookie.get('PC_TOKEN');
  //  loading = Vue.prototype.$loading({
  //   lock: true,
  //   text: 'Loading',
  //   spinner: 'el-icon-loading',
  //   background: 'rgba(0, 0, 0, 0.7)'
  // });
  return config
}, error => {
  return Promise.reject(error)
})

// response拦截器
service.interceptors.response.use(response => {
  if (response.data && response.data.code === 401) { // 401, token失效
    Vue.cookie.delete('PC_TOKEN')
    router.push({ path: '/login' })
  }else if (response.data && response.data.code === 1 || response.data.code===500) { // 401, token失效
    Vue.prototype.$message.error(response.data.msg);
   }
  return response
}, error => {
  return Promise.reject(error)
})

export default service
