import $ from "jquery";
import requestUrl from "./requestUrl";
import {getCookie} from '@/utils'
var map = {};
//自动配置路由
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
        map[names]=require('@/api/modules/' + name[0]+'/'+name[1] + '.js');
        //list.push({path:"/n/"+str,component:_import( str+'/index'),name:names,desc:item.name,meta: { isTab: true }})
      }catch (e) {
         console.error(url+"路由不存在");
      }
    }
  }
})

map.common=require('@/api/modules/common.js');
export default map

