import request from '../../request'
import requestUrl from '../../requestUrl'
import requestParam from '../../requestParam'
import isInteger from 'lodash/isInteger'

// 获取列表
export function list (params) {
  return request({
    url: requestUrl('/generator/generatortemplate/list'),
    method: 'get',
    params: requestParam(params, 'get')
  })
}

// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/generator/generatortemplate/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}

// 添加
export function add (params) {
  return request({
    url: requestUrl('/generator/generatortemplate/save'),
    method: 'post',
    data: requestParam(params)
  })
}

// 修改
export function update (params) {
  return request({
    url: requestUrl('/generator/generatortemplate/update'),
    method: 'post',
    data: requestParam(params)
  })
}

// 删除
export function del (params) {
  return request({
    url: requestUrl('/generator/generatortemplate/delete'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}

// 查询所有存在的模板
export function queryGeneratorTemplateList () {
  return request({
    url: requestUrl('/generator/generatortemplate/queryGeneratorTemplateList'),
    method: 'post',
    data: requestParam({}, 'post', false)
  })
}
export function sort (params) {
  return request({
    url: requestUrl('/generator/generatortemplate/sort'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
