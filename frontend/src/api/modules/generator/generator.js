import request from '../../request'
import requestUrl from '../../requestUrl'
import requestParam from '../../requestParam'
import isInteger from 'lodash/isInteger'

// 获取列表
export function list (params) {
  return request({
    url: requestUrl('/sys/generator/list'),
    method: 'get',
    params: requestParam(params, 'get')
  })
}

// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/yczj/yczjmanufacturers/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}

// 添加
export function add (params) {
  return request({
    url: requestUrl('/sys/generator/exportTables'),
    method: 'post',
    data: params
  })
}

// 修改
export function update (params) {
  return request({
    url: requestUrl('/yczj/yczjmanufacturers/update'),
    method: 'post',
    data: requestParam(params)
  })
}

// 删除
export function del (params) {
  return request({
    url: requestUrl('/yczj/yczjmanufacturers/delete'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}

// 生成
export function generate (tableName) {
  return request({
    url: requestUrl('/sys/generator/code?tables=' + tableName),
    method: 'get',
    data: requestParam({}, 'get', false)
  })
}
