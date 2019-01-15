import request from '../../request'
import requestUrl from '../../requestUrl'
import requestParam from '../../requestParam'
import isInteger from 'lodash/isInteger'

// 获取列表
export function list (params) {
  return request({
    url: requestUrl('/sys/sysconfig/list'),
    method: 'get',
    params: requestParam(params, 'get')
  })
}

// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/sys/sysconfig/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}

// 添加
export function add (params) {
  return request({
    url: requestUrl('/sys/sysconfig/save'),
    method: 'post',
    data: requestParam(params)
  })
}

// 修改
export function update (params) {
  return request({
    url: requestUrl('/sys/sysconfig/update'),
    method: 'post',
    data: requestParam(params)
  })
}

// 删除
export function del (params) {
  return request({
    url: requestUrl('/sys/sysconfig/delete'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
// 获取网站配置
export function getConfig (params) {
  return request({
    url: requestUrl('/sys/sysconfig/getConfig'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
// 保存网站配置
export function updateConfig (params) {
  return request({
    url: requestUrl('/sys/sysconfig/updateConfig'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
