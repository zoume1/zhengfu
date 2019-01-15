import request from '../../request'
import requestUrl from '../../requestUrl'
import requestParam from '../../requestParam'
import isInteger from 'lodash/isInteger'

// 获取列表
export function list (params) {
  return request({
    url: requestUrl('/lp/lptalent/list'),
    method: 'get',
    params: requestParam(params, 'get')
  })
}

// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/lp/lptalent/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}

// 添加
export function add (params) {
  return request({
    url: requestUrl('/lp/lptalent/save'),
    method: 'post',
    data: requestParam(params)
  })
}
// 批量添加
export function saveAll (params) {
    return request({
        url: requestUrl('/lp/lptalent/saveAll'),
        method: 'post',
        data: requestParam(params)
    })
}
// 修改
export function update (params) {
  return request({
    url: requestUrl('/lp/lptalent/update'),
    method: 'post',
    data: requestParam(params)
  })
}

// 删除
export function del (params) {
  return request({
    url: requestUrl('/lp/lptalent/delete'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
export function sort (params) {
  return request({
    url: requestUrl('/lp/lptalent/sort'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
export function audit (params) {
  return request({
    url: requestUrl('/lp/lptalent/audit'),
    method: 'get',
    params: requestParam(params, 'get', false)
  })
}
