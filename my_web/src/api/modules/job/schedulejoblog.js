import request from '../../request'
import requestUrl from '../../requestUrl'
import requestParam from '../../requestParam'
import isInteger from 'lodash/isInteger'

// 获取列表
export function list (params) {
  return request({
    url: requestUrl('/job/schedulejoblog/list'),
    method: 'get',
    params: requestParam(params, 'get')
  })
}

// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/job/schedulejoblog/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}

// 添加
export function add (params) {
  return request({
    url: requestUrl('/job/schedulejoblog/save'),
    method: 'post',
    data: requestParam(params)
  })
}

// 修改
export function update (params) {
  return request({
    url: requestUrl('/job/schedulejoblog/update'),
    method: 'post',
    data: requestParam(params)
  })
}

// 删除
export function del (params) {
  return request({
    url: requestUrl('/job/schedulejoblog/delete'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
export function sort (params) {
  return request({
    url: requestUrl('/job/schedulejoblog/sort'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
