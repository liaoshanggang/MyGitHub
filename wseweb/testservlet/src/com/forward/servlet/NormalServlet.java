package com.forward.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class NormalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NormalServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		String pwd = (String) session.getAttribute("pwd");
		if(name==null){
			response.sendRedirect("servletLogin.jsp");
		}

		ServletContext sContext = getServletContext();
		pwd = sContext.getInitParameter("defaultName2");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>显示结果页面</title></head>");
		out.print("<body>");
		out.print("您好，这是普通用户内容页，您是：！"+name+",欢迎进入本页面！"+pwd);
		out.print("</body>");
		out.print("</html>");
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
