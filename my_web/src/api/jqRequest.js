import Vue from 'vue'
import router from '@/router'
import $ from 'jquery'
import requestUrl from "./requestUrl";
// 创建axios实例
var service = {};
service.request=function(url,type="GET",data={},fun,isLoad=true,async=true) {
  var loading=null;
    if(isLoad){
      loading = Vue.prototype.$loading({
        lock: true,
        text: 'Loading',
        spinner: 'el-icon-loading',
        background: 'rgba(0, 0, 0, 0.7)'
      });
    }
    $.ajax({
      url: requestUrl(url),
      type: type, // GET
      data:data,
      async: async, // 或false,是否异步
      beforeSend: function (request) {
        request.setRequestHeader('PC_TOKEN', Vue.cookie.get('PC_TOKEN'))
      },
      dataType: 'json', // 返回的数据格式：
      success: function (data, textStatus, jqXHR) {
        if(isLoad){
          loading.close();
        }
        if(data.code===401){
          Vue.cookie.delete('PC_TOKEN')
          router.push({ name: 'login' })
        }else if(data.code===1 || data.code===500){
          Vue.prototype.$message.error(data.msg);
        }else{
          if(isLoad) {
            Vue.prototype.$message({
              message: '操作成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                fun(data);
              }
            })
          }
          if(fun!=undefined){
            fun(data);
          }
        }
      }
    })
}
export default service
