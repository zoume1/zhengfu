//package com.szt.config;
//
//import lombok.experimental.var;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.junit.Assert;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Proxy;
//import java.util.Map;
//
//@Aspect
//@Component
//@Slf4j
//public class AccessConfiguration {
//
//    @Pointcut("@annotation(requiresPermissions)")
//    public void serviceStatistics(RequiresPermissions requiresPermissions) {
//    }
//
//    @Before("serviceStatistics(requiresPermissions)")
//    public void doBefore(JoinPoint joinPoint, RequiresPermissions requiresPermissions) throws NoSuchFieldException, IllegalAccessException {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        // 记录请求到达时间
//        String[] qx = requiresPermissions.value();
//        if(qx[0].equals("null")){
//            InvocationHandler ih = Proxy.getInvocationHandler(requiresPermissions);
//            Field memberValuesField = ih.getClass().getDeclaredField("memberValues");
//            memberValuesField.setAccessible(true);
//            Map memberValues = (Map)memberValuesField.get(ih);
//            memberValues.put("value", new String[]{request.getServletPath().substring(1).replaceAll("/",":")});  // set value to false
//        }
//
////设置允许跨域的配置
//        //  String token =  request.getHeader(YczjAppConstant.TOKEN);
//        //header方式
//        // Cookie token = CookieUtil.get(request, CommonConstant.TOCKEN_KEY);
//        //2.如果没有token，未登录状态
////        if (StringUtils.isBlank(token)) {
////            throw new RRException("token失效，请重新登录！",401);
////        }
////        String json = (String) redisUtils.get(YczjAppConstant.TOKEN+ token);
////        if (StringUtils.isBlank(json)) {
////            throw new RRException("登录已经失效，请重新登录！",401);
////        }
////        //5.取到用户信息。登录状态。
////        ZszjUserEntity user = JSON.parseObject(json, ZszjUserEntity.class);
////        YczjAppUserUtils.setUser(user);
////        redisUtils.set(YczjAppConstant.TOKEN + token, json, YczjAppConstant.TOCKEN_EXPIRE);
////        //  6.把用户信息放到request中,只需要在controller中判断request中是否包含user信息。
//    }
//
////    @After("serviceStatistics(analysisActuator)")
////    public void doAfter(AnalysisActuator analysisActuator) {
////        log.info("cy666 statistic time:{}, note:{}", System.currentTimeMillis() - beginTime.get(), analysisActuator.note());
////    }
//}
