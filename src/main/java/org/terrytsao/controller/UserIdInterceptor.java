package org.terrytsao.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserIdInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uid = request.getParameter("uid");
		// TODO security
		if (null == uid) {
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("uid")) {
					uid = cookie.getValue();
					break;
				}
			}
			if (null == uid) { // uid not found in attr or cookies
				response.sendRedirect(request.getContextPath() + "/");
				return false;
			}
		}

		// uid found

		request.setAttribute("uid", uid);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		modelAndView.addObject("uid", request.getAttribute("uid"));
	}
}
