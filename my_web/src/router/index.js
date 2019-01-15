import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  // mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/home'
    },
    {
      path: '/home',  // 第一栏：首页
      component: resolve => require(['../views/home.vue'], resolve)
    },
    {
      path: '/Img_list',  // 第一栏：图片列表
      component: resolve => require(['../views/Img_list.vue'], resolve)
    },
    {
      path: '/Img_detail',  // 第一栏：图片详情
      component: resolve => require(['../views/Img_detail.vue'], resolve)
    },
    {
      path: '/news_list',  // 第一栏：新闻列表
      component: resolve => require(['../views/news_list.vue'], resolve)
    },
    {
      path: '/news_detail',  // 第一栏：新闻详情
      component: resolve => require(['../views/news_detail.vue'], resolve)
    },
    {
      path: '/talentPoolApply',  // 第一栏：人才库申请
      component: resolve => require(['../views/talentPoolApply.vue'], resolve)
    },
    {
      path: '/talentPoolList',  // 第一栏：人才库列表
      component: resolve => require(['../views/talentPoolList.vue'], resolve)
    },
    {
      path: '/talentPoolDetail',  // 第一栏：人才库详情
      component: resolve => require(['../views/talentPoolDetail.vue'], resolve)
    },
    {
      path: '/activityList',  // 第一栏：活动列表
      component: resolve => require(['../views/activityList.vue'], resolve)
    },
    {
      path: '/activitySignUp',  // 第一栏：活动报名
      component: resolve => require(['../views/activitySignUp.vue'], resolve)
    },
    {
      path: '/onlineMsg',  // 第一栏：在线交流
      component: resolve => require(['../views/onlineMsg.vue'], resolve)
    },
    {
      path: '/login',  // 第一栏：登录
      component: resolve => require(['../views/login.vue'], resolve)
    },
    {
      path: '/register',  // 第一栏：登录
      component: resolve => require(['../views/registerMain.vue'], resolve),
      children: [
        {
          path: '/personal',
          component: resolve => require(['../components/registerOne.vue'], resolve)
        },
        {
          path: '/enterprise',
          component: resolve => require(['../components/registerTwo.vue'], resolve)
        },
        {
          path: '/group',
          component: resolve => require(['../components/registerThree.vue'], resolve)
        }
      ]
    },
    {
      path: '/registerSuc',  // 第一栏：注册成功页
      component: resolve => require(['../views/registerSuc.vue'], resolve)
    },

    // 手机端
    {
      path: '/SignIn',  // 第一栏：登录
      component: resolve => require(['../views/mobile/SignIn.vue'], resolve)
    },
    {
      path: '/signUpDetail',  // 第一栏：报名详情
      component: resolve => require(['../views/mobile/signUpDetail.vue'], resolve)
    },
    {
      path: '/newsDetailMob',  // 第一栏：新闻详情
      component: resolve => require(['../views/mobile/newsDetailMob.vue'], resolve)
    },
    {
      path: '/newsListMob',  // 第一栏：新闻详情
      component: resolve => require(['../views/mobile/newsListMob.vue'], resolve)
    },
    {
      path: '/HomeMob',  // 第一栏：新闻详情
      component: resolve => require(['../views/mobile/HomeMob.vue'], resolve)
    }


  ]
})
