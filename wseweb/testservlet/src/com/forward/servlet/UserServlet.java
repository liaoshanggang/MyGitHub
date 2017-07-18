package com.forward.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("m");
		String returnPage = "/index.jsp"; 
		System.out.println("hello");
		if ("login".equals(method)){
			returnPage = login(request, response);
		} else if ("register".equals(method)) {
			userReg(request, response);
		} else {
			getUserInfo(request, response);
		}
		//response.getWriter().append("Served at:").append(request.getContextPath());
		request.getRequestDispatcher(returnPage).forward(request, response);
	}

	private void getUserInfo(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("获得用户信息方法");
	}

	private void userReg(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("注册方法");
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("登录方法");
		return "/login.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
