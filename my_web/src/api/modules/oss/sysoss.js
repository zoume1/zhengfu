import request from '../../request'
import requestUrl from '../../requestUrl'
import requestParam from '../../requestParam'
import isInteger from 'lodash/isInteger'

// 获取列表
export function list (params) {
  return request({
    url: requestUrl('/oss/sysoss/list'),
    method: 'get',
    params: requestParam(params, 'get')
  })
}
// 获取云存储配置信息
export function config () {
  return request({
    url: requestUrl('/oss/sysoss/config'),
    method: 'get',
    params: requestParam({}, 'get')
  })
}
// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/oss/sysoss/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}

// 添加
export function add (params) {
  return request({
    url: requestUrl('/oss/sysoss/save'),
    method: 'post',
    data: requestParam(params)
  })
}
// 保存云存储配置信息
export function addConfig (params) {
  return request({
    url: requestUrl('/oss/sysoss/saveConfig'),
    method: 'post',
    data: requestParam(params)
  })
}
// 上传文件
export function upload (token) {
  return requestUrl(`/oss/sysoss/upload?token=${token}`)
}
// 修改
export function update (params) {
  return request({
    url: requestUrl('/oss/sysoss/update'),
    method: 'post',
    data: requestParam(params)
  })
}

// 删除
export function del (params) {
  return request({
    url: requestUrl('/oss/sysoss/delete'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
// 删除
export function sort (params) {
  return request({
    url: requestUrl('/oss/sysoss/sort'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
