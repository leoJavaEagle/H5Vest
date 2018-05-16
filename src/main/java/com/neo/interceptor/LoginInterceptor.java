package com.neo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
* 自定义拦截器1
*
*/
public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
          throws Exception {
		if("/console/login".equals(request.getRequestURI()) || 
				"/console/checkLogin".equals(request.getRequestURI())) {
			return true;
		}
		HttpSession session = request.getSession();
	  	if(session.getAttribute("username") == null) { // 判断用户是否登录
	  		System.out.println(">>>  " + request.getRequestURI() + "  <<< 已被拦截");
	//      System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
	  		response.sendRedirect(request.getContextPath() + "/console/login");
	  		return false;
	  	}else {
	  		return true;// 只有返回true才会继续向下执行，返回false取消当前请求
	  	}
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
          ModelAndView modelAndView) throws Exception {
//      System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
          throws Exception {
//      System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
  }

}

