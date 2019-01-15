import request from '../../request'
import requestUrl from '../../requestUrl'
import requestParam from '../../requestParam'
import isInteger from 'lodash/isInteger'
import service from '../../jqRequest'
// 获取列表
export function list (params) {
  return request({
    url: requestUrl('/generator/generatorbusconfig/list'),
    method: 'get',
    params: requestParam(params, 'get')
  })
}

// 获取信息
export function info (id) {
  return request({
    url: requestUrl('/generator/generatorbusconfig/info' + (isInteger(id) ? `/${id}` : '')),
    method: 'get',
    params: requestParam({}, 'get')
  })
}

// 添加
export function add (params) {
  return request({
    url: requestUrl('/generator/generatorbusconfig/save'),
    method: 'post',
    data: requestParam(params)
  })
}

// 修改
export function update (params) {
  return request({
    url: requestUrl('/generator/generatorbusconfig/update'),
    method: 'post',
    data: requestParam(params)
  })
}

// 删除
export function del (params) {
  return request({
    url: requestUrl('/generator/generatorbusconfig/delete'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
// 查询所有业务参数
export function querySysBusConfigList () {
  return request({
    url: requestUrl('/generator/generatorbusconfig/querySysBusConfigList'),
    method: 'get',
    data: requestParam({}, 'get', false)
  })
}

//根据key查询业务参数
export function querySysBusConfigByKey (params) {
  return request({
    url: requestUrl('/generator/generatorbusconfig/querySysBusConfigByKey'),
    method: 'get',
    params: requestParam(params, 'get', false)
  })
}
//根据模块查询所需的业务参数
export function queryModuleBusConfig (params,fun) {
  service.request('/generator/generatorbusconfig/queryModuleBusConfig',"get",params,fun,true,false);
}
//查询tree业务参数
export function queryTreeConfigByKey (params) {
  return request({
    url: requestUrl('/generator/generatorbusconfig/queryTreeConfigByKey'),
    method: 'get',
    params: requestParam(params, 'get', false)
  })
}
export function sort (params) {
  return request({
    url: requestUrl('/generator/generatorbusconfig/sort'),
    method: 'post',
    data: requestParam(params, 'post', false)
  })
}
