import request from '../../request'
import requestUrl from '../../requestUrl'
import requestParam from '../../requestParam'
import isInteger from 'lodash/isInteger'

// 获取列表
export function list (params) {
  return request({
    url: requestUrl('/job/schedulejob/list'),
    method: 'get',
    params: requestParam(params, 'get')
  })
}

// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/job/schedulejob/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}

// 添加
export function add (params) {
  return request({
    url: requestUrl('/job/schedulejob/save'),
    method: 'post',
    data: requestParam(params)
  })
}

// 修改
export function update (params) {
  return request({
    url: requestUrl('/job/schedulejob/update'),
    method: 'post',
    data: requestParam(params)
  })
}

// 删除
export function del (params) {
  return request({
    url: requestUrl('/job/schedulejob/delete'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}

// 运行定时任务
export function run (params) {
  return request({
    url: requestUrl('/job/schedulejob/run'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}

// 暂停定时任务
export function pause (params) {
  return request({
    url: requestUrl('/job/schedulejob/pause'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}

// 恢复定时任务
export function resume (params) {
  return request({
    url: requestUrl('/job/schedulejob/resume'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
export function sort (params) {
  return request({
    url: requestUrl('/job/schedulejob/sort'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
