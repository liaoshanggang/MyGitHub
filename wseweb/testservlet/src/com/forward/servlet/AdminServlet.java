package com.forward.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		if(name==null||!name.equals("admin")){
			response.sendRedirect("login.jsp");
		}
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>管理后台页面</title></head>");
		out.print("<body>");
		out.print("您好，您是管理员：！"+name+",欢迎进入管理后台！");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
