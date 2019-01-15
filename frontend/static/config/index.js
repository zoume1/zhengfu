/**
 * 开发环境
 */
;(function () {
  window.SITE_CONFIG = {}
  // api接口请求地址
  window.SITE_CONFIG.baseUrl = 'http://lp.siring.cn/lp/'

  // 嵌套iframe地址
  window.SITE_CONFIG.nestIframeUrl = 'http://localhost:8082/lp/'
  // 嵌套iframe路由名称列表
  window.SITE_CONFIG.nestIframeRouteNameList = ['sql']

  // 静态资源文件夹名称
  window.SITE_CONFIG.staticFileName = ''
  // cdn地址
  window.SITE_CONFIG.cdnUrl = './' + window.SITE_CONFIG.staticFileName
  // $.ajax({
  //   url: window.SITE_CONFIG.baseUrl+'/sys/sysconfig/getConfig',
  //   type: 'post', // GET
  //   data:{},
  //   async: false, // 或false,是否异步
  //   dataType: 'json', // 返回的数据格式：
  //   success: function (data, textStatus, jqXHR) {
  //     $("#icon").attr("href",data.data.logo.value);
  //     $("#title").text(data.data.siteName.value);
  //   }
  // })
})();
