package com.szt.modules.lpgzh.interceptor;

import com.szt.common.exception.RRException;
import com.szt.config.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class AnalysisGzjActuatorAspect {
    private static String TOKEN="GZH_TOKEN";

    @Autowired
    private RedisUtil redisUtils;

    @Pointcut("@annotation(analysisGzhActuator)")
    public void serviceStatistics(AnalysisGzhActuator analysisGzhActuator) {
    }

    @Before("serviceStatistics(analysisGzhActuator)")
    public void doBefore(JoinPoint joinPoint, AnalysisGzhActuator analysisGzhActuator) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录请求到达时间
        log.info("cy666 note:{}", analysisGzhActuator.note());
//设置允许跨域的配置
        String token =  request.getHeader(TOKEN);
        //header方式
        // Cookie token = CookieUtil.get(request, CommonConstant.TOCKEN_KEY);
        //2.如果没有token，未登录状态
        if (StringUtils.isBlank(token)) {
            throw new RRException("token失效，请重新登录！",401);
        }
        String json = (String) redisUtils.get(TOKEN+ token);
        if (StringUtils.isBlank(json)) {
            throw new RRException("登录已经失效，请重新登录！",401);
        }
//        //5.取到用户信息。登录状态。
//        ZszjUserEntity user = JSON.parseObject(json, ZszjUserEntity.class);
//        YczjAppUserUtils.setUser(user);
//        redisUtils.set(YczjAppConstant.TOKEN + token, json, YczjAppConstant.TOCKEN_EXPIRE);
      //  6.把用户信息放到request中,只需要在controller中判断request中是否包含user信息。
    }

}