package com.forward.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//http://localhost:8080/testservlet/LifeCycleServlet
public class LifeCycleServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public LifeCycleServlet() {
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化，init()方法被调用");
		super.init(config);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doGet()方法被调用");
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPost()方法被调用");
		super.doPost(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("销毁时，destroy()方法被调用！");
		super.destroy();
	}
}
