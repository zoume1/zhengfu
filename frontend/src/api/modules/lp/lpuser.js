import request from '../../request'
import jqRequest from '../../jqRequest'
import requestUrl from '../../requestUrl'
import requestParam from '../../requestParam'
import isInteger from 'lodash/isInteger'

// 获取列表
export function list (params) {
  return request({
    url: requestUrl('/lp/lpuser/list'),
    method: 'get',
    params: requestParam(params, 'get')
  })
}

// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/lp/lpuser/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}

// 添加
export function add (params) {
  return request({
    url: requestUrl('/lp/lpuser/save'),
    method: 'post',
    data: requestParam(params)
  })
}
// 批量添加
export function saveAll (params) {
    return request({
        url: requestUrl('/lp/lpuser/saveAll'),
        method: 'post',
        data: requestParam(params)
    })
}
// 修改
export function update (params) {
  return request({
    url: requestUrl('/lp/lpuser/update'),
    method: 'post',
    data: requestParam(params)
  })
}

// 删除
export function del (params) {
  return request({
    url: requestUrl('/lp/lpuser/delete'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
// 删除
export function sort (params) {
  return request({
    url: requestUrl('/lp/lpuser/sort'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
//统计个人会员人员分类
export function memberStatistics (params) {
  return request({
    url: requestUrl('/lp/lpuser/memberStatistics'),
    method: 'get',
    params: requestParam(params, 'get', false)
  })
}
//会员信息报表
export function informationReport (params) {
  return request({
    url: requestUrl('/lp/lpuser/informationReport'),
    method: 'get',
    params: requestParam(params, 'get', false)
  })
}
//会员信息报表
export function growthStatements (params) {
  return request({
    url: requestUrl('/lp/lpuser/growthStatements'),
    method: 'get',
    params: requestParam(params, 'get', false)
  })
}



