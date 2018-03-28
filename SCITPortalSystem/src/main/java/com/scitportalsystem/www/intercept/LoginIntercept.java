package com.scitportalsystem.www.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercept extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		if(loginId==null){
			String path = request.getContextPath();
			response.sendRedirect(path+"/login");
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	

}
