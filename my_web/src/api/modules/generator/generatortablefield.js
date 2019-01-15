import request from '../../request'
import requestUrl from '../../requestUrl'
import requestParam from '../../requestParam'
import isInteger from 'lodash/isInteger'

// 获取列表
export function list (params) {
  return request({
    url: requestUrl('/generator/generatortablefield/list'),
    method: 'get',
    params: requestParam(params, 'get')
  })
}

// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/generator/generatortablefield/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}

// 添加
export function add (params) {
  return request({
    url: requestUrl('/generator/generatortablefield/save'),
    method: 'post',
    data: requestParam(params)
  })
}
// 添加
export function saveAll (params) {
  return request({
    url: requestUrl('/generator/generatortablefield/saveAll'),
    method: 'post',
    data: requestParam(params)
  })
}
// 修改
export function update (params) {
  return request({
    url: requestUrl('/generator/generatortablefield/update'),
    method: 'post',
    data: requestParam(params)
  })
}

// 删除
export function del (params) {
  return request({
    url: requestUrl('/generator/generatortablefield/delete'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
// 批量隐藏表格字段
export function hideTableField (params) {
  return request({
    url: requestUrl('/generator/generatortablefield/hideTableField'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}

// 批量隐藏设置字段
export function hideSetField (params) {
  return request({
    url: requestUrl('/generator/generatortablefield/hideSetField'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}

// 批量显示搜索
export function showSeekField (params) {
  return request({
    url: requestUrl('/generator/generatortablefield/showSeekField'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}

// 批量显示导出
export function showExportField (params) {
  return request({
    url: requestUrl('/generator/generatortablefield/showExportField'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
export function sort (params) {
  return request({
    url: requestUrl('/generator/generatortablefield/sort'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
