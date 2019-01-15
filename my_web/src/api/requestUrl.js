/**
 * 请求地址统一处理／组装
 * @param {*} actionName action方法名称
 */
import { baseUrl } from '@/config/env'
export default function (actionName) {
  return baseUrl + actionName
}
