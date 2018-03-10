<%@page import="com.hr.bean.Employee"%>
<%@page import="com.hr.buz.EmploeeBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showDetailInfoByID.jsp' starting page</title>

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
    String id = (String)request.getAttribute("id");
    EmploeeBiz ebiz = new EmploeeBiz();
    Employee e = ebiz.getEmployeeById(id);
    out.print(id);
    out.print("hello");
    %>
    <h1>员工id:<%=e.getId() %></h1>
    <h2>员工姓名：<%=e.getName() %></h2>
    <h3>员工最大工资：<%=e.getMinWage() %></h3>
    <h4>员工最小工资：<%=e.getMaxWage() %></h4>
  </body>
</html>
