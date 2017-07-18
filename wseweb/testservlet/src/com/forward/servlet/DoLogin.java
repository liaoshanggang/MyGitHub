package com.forward.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name").trim();
		System.out.println(name.length());

		
		String pwd = request.getParameter("pwd").trim();
		
		if(pwd.length()==0){
			//name = getInitParameter("defaultName");
		}
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		if("admin".equals(name)&&"admin".equals(pwd)){
			response.sendRedirect("AdminServlet");
			//response.sendRedirect("admin.jsp");
		}else{
			response.sendRedirect("NormalServlet");
			//response.sendRedirect("normal.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
