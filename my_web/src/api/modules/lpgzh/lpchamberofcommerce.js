import request from '../../request'
import requestUrl from '../../requestUrl'
import requestParam from '../../requestParam'
import isInteger from 'lodash/isInteger'
import service from '../../jqRequest'
// 获取列表
export function list (params) {
  return request({
    url: requestUrl('/lp/lpchamberofcommerce/list'),
    method: 'get',
    params: requestParam(params, 'get')
  })
}

// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/lp/lpchamberofcommerce/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}

// 添加
export function add (params) {
  return request({
    url: requestUrl('/lp/lpchamberofcommerce/save'),
    method: 'post',
    data: requestParam(params)
  })
}
// 批量添加
export function saveAll (params) {
    return request({
        url: requestUrl('/lp/lpchamberofcommerce/saveAll'),
        method: 'post',
        data: requestParam(params)
    })
}
// 修改
export function update (params) {
  return request({
    url: requestUrl('/lp/lpchamberofcommerce/update'),
    method: 'post',
    data: requestParam(params)
  })
}

// 删除
export function del (params) {
  return request({
    url: requestUrl('/lp/lpchamberofcommerce/delete'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
// 拖拽排序
export function sort(params) {
  return request({
    url: requestUrl('/lp/lpchamberofcommerce/sort'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
