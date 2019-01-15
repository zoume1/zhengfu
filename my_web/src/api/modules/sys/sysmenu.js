import request from '../../request'
import requestUrl from '../../requestUrl'
import requestParam from '../../requestParam'
import isInteger from 'lodash/isInteger'

// 获取列表
export function list (params) {
  return request({
    url: requestUrl('/sys/sysmenu/list'),
    method: 'get',
    params: requestParam(params, 'get')
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
// 获取导航菜单列表 / 权限
export function menuLevel () {
  return request({
    url: requestUrl('/sys/sysmenu/menuLevel'),
    method: 'get',
    params: requestParam({}, 'get')
  })
}
// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/sys/sysmenu/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}

// 添加
export function add (params) {
  return request({
    url: requestUrl('/sys/sysmenu/save'),
    method: 'post',
    data: requestParam(params)
  })
}
// 批量添加
export function saveAll (params) {
    return request({
        url: requestUrl('/sys/sysmenu/saveAll'),
        method: 'post',
        data: requestParam(params)
    })
}
// 修改
export function update (params) {
  return request({
    url: requestUrl('/sys/sysmenu/update'),
    method: 'post',
    data: requestParam(params)
  })
}

// 删除
export function del (params) {
  return request({
    url: requestUrl('/sys/sysmenu/delete'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
// 删除
export function sort (params) {
  return request({
    url: requestUrl('/sys/sysmenu/sort'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
