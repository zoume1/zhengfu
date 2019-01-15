import request from '../request'
import requestUrl from '../requestUrl'
import requestParam from '../requestParam'
import isInteger from "lodash/isInteger";
import service from "../jqRequest";

// 获取验证码
export function captcha (uuid) {
  return requestUrl(`/captcha.jpg?uuid=${uuid}`)
}

// 登录
export function login (params) {
  return request({
    url: requestUrl('/sys/login'),
    method: 'post',
    data: requestParam(params)
  })
}

// 退出
export function logout () {
  return request({
    url: requestUrl('/sys/logout'),
    method: 'post',
    data: requestParam()
  })
}
// 获取系统业务参数
export function getSysBuConfig (key) {
  return request({
    url: requestUrl('sys/sysbusconfig/querySysBusConfigList'),
    method: 'get',
    data: requestParam()
  })
}
// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/sys/sysuser/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}
// 获取导航菜单列表 / 权限
export function nav () {
  return request({
    url: requestUrl('/sys/sysmenu/nav'),
    method: 'get',
    params: requestParam({}, 'get')
  })
}
//根据模块查询所需的业务参数
export function jqueryRequest (url,type,params,fun=function(){},isLoad=true,async=true) {
  service.request(url,type,params,fun,isLoad,async);
}
