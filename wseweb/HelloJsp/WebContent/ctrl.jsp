<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	if(name.equals("admin")&&pwd.equals("admin")){
		//response.sendRedirect("admin.jsp");
		//①解决第一次请求参数丢失问题
		//response.sendRedirect("admin.jsp?name="+name);
		//②请求转发http://localhost:8080/HelloJsp/ctrl.jsp
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}else{
		//response.sendRedirect("normal.jsp");
		//response.sendRedirect("normal.jsp?name="+name);
		request.getRequestDispatcher("normal.jsp").forward(request,response);
	}
	%>
</body>
</html>