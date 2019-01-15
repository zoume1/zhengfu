package com.szt.modules.sys.inteceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述: 浏览器语言拦截器
 *
 *
 * @author：xujianjun
 * @date：2017年3月20日 下午8:24:07
 * @version V1.0
 *
 */
public class LoginInteceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		Object cj=request.getSession().getAttribute("vender");//厂家
		Object shr=request.getSession().getAttribute("receiver");//收货人
		Object sj=request.getSession().getAttribute("");//司机
		if (cj==null) {
			String requestType = request.getHeader("X-Requested-With");
			
			if (requestType!=null) {
				response.setStatus(911);
				response.getWriter().write("{\"code\":\"9999\"}");
				return false;
			}
			
			//response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
