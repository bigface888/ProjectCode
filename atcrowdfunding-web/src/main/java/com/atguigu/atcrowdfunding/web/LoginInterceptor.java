package com.atguigu.atcrowdfunding.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.atcrowdfunding.bean.User;
/*
 * ��¼������
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * �ڿ�����ִ��֮ǰ���ҵ���߼�����
	 * �����ķ���ֵ�����߼��Ƿ����ִ�У� true����ʾ����ִ�У� false, ��ʾ���ټ���ִ�С�
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// �жϵ�ǰ�û��Ƿ��Ѿ���½
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if ( loginUser == null ) {
			String path = session.getServletContext().getContextPath();
			response.sendRedirect(path + "/login");
			return false;	
		} else {
			return true;
		}
	}

	/**
	 * �ڿ�����ִ�����֮��ִ�е��߼�����
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * �������ͼ��Ⱦ֮��ִ�д˷�����
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
