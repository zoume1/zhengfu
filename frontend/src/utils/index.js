import requestUrl from "../api/requestUrl";
import API from "@/api";

/**
 * 是否有权限
 * @param {*} key
 */
export function isAuth(key) {
  return JSON.parse(sessionStorage.getItem('permissions') || '[]').indexOf(key) !== -1 || false
}

/**
 * 获取路由名称, 根据url地址
 * @param {*} url
 */
export function getRouteNameByUrl(url) {
  let val = /.*\/(.*)\.html/.exec(url)
  return val && val.length >= 1 ? val[1] : ''
}

export function getCookie(name) {
  var strcookie = document.cookie// 获取cookie字符串
  var arrcookie = strcookie.split('; ')// 分割
// 遍历匹配
  for (var i = 0; i < arrcookie.length; i++) {
    var arr = arrcookie[i].split('=')
    if (arr[0] === name) {
      return arr[1]
    }
  }
  return ''
}

/**
 * 根据地址id递归查询层级
 * @param list
 * @param id
 * @param address
 */
export function queryAddressById(list, id, obj) {
  for (var i in list) {
    var item = list[i];
    if (item.id === id) {
      obj[0] = item;
      return;
    } else if (item.children != null && item.children.length > 0) {
      queryAddressById(item.children, id, obj)
    }
  }
}

/**
 * 获取联动地址
 * @param id
 */
export function getAddress(id = 0, level) {
  var list = [];
  $.ajax({
    url: requestUrl('/sys/syspbarea/list'),
    type: 'get', // GET
    async: false, // 或false,是否异步
    data: {
      page: 1,
      limit: 10000, parentid: id
    },
    dataType: 'json', // 返回的数据格式：
    beforeSend: function (request) {
      request.setRequestHeader('token', getCookie('token'))
    },
    success: function (data, textStatus, jqXHR) {
      list = data.data.list;
      for (var i in list) {
        var item = list[i];
        //console.log(item.level,level);
        if (item.isNext != '0' && item.level != level) {
          item.children = [];
        }
      }
    }
  })

  return list;
}

/**
 * 树形数据转换
 * @param {*} data
 * @param {*} id
 * @param {*} pid
 */
export function treeDataTranslate(data, id = 'id', pid = 'parentId') {
  var res = []
  var temp = {}
  for (var i = 0; i < data.length; i++) {
    temp[data[i][id]] = data[i]
  }
  for (var k = 0; k < data.length; k++) {
    if (temp[data[k][pid]] && data[k][id] !== data[k][pid]) {
      if (!temp[data[k][pid]]['children']) {
        temp[data[k][pid]]['children'] = []
      }
      if (!temp[data[k][pid]]['_level']) {
        temp[data[k][pid]]['_level'] = 0
      }
      data[k]['_level'] = temp[data[k][pid]]._level + 1
      temp[data[k][pid]]['children'].push(data[k])
    } else {
      res.push(data[k])
    }
  }
  return res
}

/**
 * 获取字符串字节长度
 * @param {*} s
 */
export function getStringLength(s) {
  return s.replace(/[\u4e00-\u9fa5\uff00-\uffff]/g, '**').length
}

/**
 * 获取uuid
 */
export function getUUID() {
  return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, c => {
    return (c === 'x' ? (Math.random() * 16 | 0) : ('r&0x3' | '0x8')).toString(16)
  })
}

/**
 * 实现笛卡尔积//console.log(descartes([[1,3],[1,1]]))
 * @returns {T | (function(*=, *): Array)}
 */
export function descartes(list) {
//parent上一级索引;count指针计数
  var point = {};
  var result = [];
  var pIndex = null;
  var tempCount = 0;
  var temp = [];
//根据参数列生成指针对象
  for (var index in list) {
    if (typeof list[index] == 'object') {
      point[index] = {'parent': pIndex, 'count': 0}
      pIndex = index;
    }
  }
//单维度数据结构直接返回
  if (pIndex == null) {
    return list;
  }
//动态生成笛卡尔积
  while (true) {
    for (var index in list) {
      tempCount = point[index]['count'];
      temp.push(list[index][tempCount]);
    }
//压入结果数组
    result.push(temp);
    temp = [];
//检查指针最大值问题
    while (true) {
      if (point[index]['count'] + 1 >= list[index].length) {
        point[index]['count'] = 0;
        pIndex = point[index]['parent'];
        if (pIndex == null) {
          return result;
        }
//赋值parent进行再次检查
        index = pIndex;
      }
      else {
        point[index]['count']++;
        break;
      }
    }
  }
}


