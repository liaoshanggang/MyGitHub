package com.forward.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.entity.User;

public class UserLoginSvt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLoginSvt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if ("123456@126.com".equals(email)&&"123456".equals(password)){
			User user = new User();
			user.setEmail(email);
			user.setPassword("来自数据库中的加密密码：md5(123456)");
			request.getSession().setAttribute("userinfo",user);
			request.setAttribute("result","success");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("userinfo.jsp");
			dispatcher.forward(request, response);
			//return ;//第一种方法
//			Jul 17, 2017 11:02:04 PM org.apache.catalina.core.StandardWrapperValve invoke
//			SEVERE: Servlet.service() for servlet UserLoginSvt threw exception
//			java.lang.IllegalStateException
//				at org.apache.catalina.connector.ResponseFacade.sendRedirect(ResponseFacade.java:435)
//				at com.forward.servlet.UserLoginSvt.doGet(UserLoginSvt.java:35)
//				at com.forward.servlet.UserLoginSvt.doPost(UserLoginSvt.java:38)
//				

		} else {
		response.sendRedirect("login.jsp");//第二种方法
		}
		//response.sendRedirect("login.jsp");//第一种方法
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
