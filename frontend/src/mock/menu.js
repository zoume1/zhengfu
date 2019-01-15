import {
  baseUrl
} from '@/config/env'
const first = [{
  id: 33,
  name: "引导页",
  url: '/guide/index',
  icon: 'icon-canshu',
  children: [],
}, {
  id: 13,
  name: "权限测试页",
  url: '/role/index',
  icon: 'icon-quanxian',
  meta: {
    roles: ['admin'],
  },
  children: [],
}, {
  id: 14,
  name: "数据展示",
  url: '/exhibition/index',
  icon: 'icon-shujuzhanshi2',
  children: [],
}, {
  id: 14,
  name: "自定义组件",
  url: '/forms/transfer',
  icon: 'icon-biaodan',
  children: [],
}, {
  id: 2,
  name: "第三方网站",
  url: '',
  icon: 'icon-iframe',
  meta: {},
  children: [{
    id: 3,
    name: "百度",
    url: 'https://www.baidu.com',
    icon: 'icon-baidu1',
    children: [],
  }, {
    id: 4,
    name: "搜狐",
    url: 'http://www.shouhu.com',
    icon: 'icon-souhu',
    children: [],
  }, {
    id: 5,
    name: "360",
    url: 'http://www.360.com',
    icon: 'icon-msnui-360',
    children: [],

  }]
}, {
  id: 6,
  name: "表格&表单",
  url: '',
  icon: 'icon-biaoge',
  meta: {},
  children: [{
    id: 16,
    name: "表格",
    url: '/table/index',
    query: {
      a: 1
    },
    icon: 'icon-biaoge',
    meta: {},
    children: []
  }, {
    id: 161,
    name: "普通树表格",
    url: '/table/tree',
    query: {
      a: 1
    },
    icon: 'icon-biaoge',
    meta: {},
    children: []
  }, {
    id: 16,
    name: "自定义树表格",
    url: '/table/alltree',
    query: {
      a: 1
    },
    icon: 'icon-biaoge',
    meta: {},
    children: []
  }, {
    id: 9,
    name: "生成器",
    url: `/table/generator`,
    icon: 'icon-huanyingye',
    meta: {},
    children: []
  }, {
    id: 9,
    name: "表单",
    url: '/forms/index',
    query: {
      a: 1
    },
    icon: 'icon-biaodan',
    meta: {},
    children: []
  }, {
    id: 10,
    name: "select联动",
    url: '/select/index',
    icon: 'icon-biaodan',
    meta: {},
    children: []
  }]
}, {
  id: 7,
  name: "阿里图标",
  url: '/iconfont/index',
  icon: 'icon-changyonglogo27',
  meta: {},
  children: []
}, {
  id: 15,
  name: "高级路由",
  url: '#',
  icon: 'icon-iconset0265',
  meta: {},
  children: [{
    id: 16,
    name: "动态路由",
    url: '/advanced-router/mutative-router',
    icon: 'icon-dongtai',
    children: []
  }, {
    id: 17,
    name: "参数路由",
    url: '/advanced-router/argument-page',
    icon: 'icon-canshu',
    children: []
  }, ]
}, {
  id: 8,
  name: "综合错误",
  url: '#',
  icon: 'icon-cuowu',
  meta: {},
  children: [{
    id: 14,
    name: "错误日志",
    url: '/logs/error',
    icon: 'icon-rizhi',
    children: []
  }, {
    id: 15,
    name: "错误页面",
    url: '/logs/page',
    icon: 'icon-cuowutishitubiao',
    children: []
  }]
}]
const second = [{
  id: 23,
  name: "环境变量",
  icon: 'icon-dongtai',
  url: '/dev/index',
  meta: {

  },
  children: []
}, {
  id: 24,
  name: "数据持久化",
  url: `/store/index`,
  icon: 'icon-huanyingye',
  meta: {},
  children: []
}, {
  id: 25,
  name: "剪切板",
  url: `/clipboard/index`,
  icon: 'icon-canshu',
  meta: {},
  children: []
}, {
  id: 25,
  name: "标签页操作",
  url: `/tags/index`,
  icon: 'icon-canshu',
  meta: {},
  children: []
}, {
  id: 26,
  name: "灰度模式",
  url: `/gray/index`,
  icon: 'icon-shujuzhanshi2',
  meta: {},
  children: []
}, {
  id: 9,
  name: "系统管理",
  icon: 'icon-liuliangyunpingtaitubiao08',
  meta: {

  },
  children: [{
    id: 20,
    name: "用户管理",
    url: '/admin/user',
    icon: 'icon-yonghuguanli',
    children: []
  }, {
    id: 21,
    name: "角色管理",
    url: '/admin/role',
    icon: 'icon-jiaoseguanli',
    children: []
  },
    {
      id: 22,
      name: "菜单管理",
      url: '/admin/menu',
      icon: 'icon-caidanguanli',
      children: []
    }
  ]
}]
export const menu = [first, second];
