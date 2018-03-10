<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'doLogin.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    Connection conn=null; 
    PreparedStatement pst = null;
    ResultSet rs = null;
    String name = request.getParameter("name").trim();
    String pwd = request.getParameter("pwd").trim();
    try{
    Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException c){
    	c.getStackTrace();
    }
    try{
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?name=user&password=123456");
    String sql = "select * from user where name=?and password=?";
    pst = conn.prepareStatement(sql);
    rs = pst.executeQuery();
    out.print("执行的SQL语句为："+sql+"<br>");
	if(rs.next()){
		session.setAttribute("name", name);
		session.setMaxInactiveInterval(10*60);
		out.print("登录成功！");
	}else{
		out.print("登录失败！");
		response.sendRedirect("3_5_3login.jsp");
	}
    }catch(SQLException e){
    	e.printStackTrace();
    }finally{
    	try{
    		if(null!=pst){
    			pst.close();
    		}
    		if(null!=conn){
    			conn.close();
    		}
    	}catch(SQLException s){
    		s.printStackTrace();
    	}
    }
    %>
  </body>
</html>
