<%@page import="com.hr.buzi.impl.EmployeeBuziDaoImpl"%>
<%@page import="com.hr.dao.impl.EmployeeDaoImpl"%>
<%@page import="com.hr.buzi.EmployeeBuziDao"%>
<%@page import="com.hr.dao.EmployeeDao"%>
<%@page import="com.hr.bean.Employee"%>
<%@page import="com.hr.buz.EmploeeBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '5_5.jsp' starting page</title>

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
  EmployeeBuziDao ebd = new EmployeeBuziDaoImpl();
  List<Employee> list = ebd.findAllEmployees();
  %>
  <table border="1">
  	<tr>
  		<th>id</th>
  		<th>name</th>
  		<th>minWage</th>
  		<th>maxWage</th>
  	</tr>
  	<%
  	for(Object o:list){
  		Employee e = (Employee)o;
  	%>
  	<tr>
  	<%String id = e.getId(); %>
	  	<td><%=id%></td>
		<td><%=e.getName()%></td>
		<td><%=e.getMinWage()%></td>
		<td><%=e.getMaxWage()%></td>
		<%-- <td><a href="http://localhost:8080/Sample/showDetailInfoByID.jsp">查看详情<%request.setAttribute("id",id); %></a></td>
  	 --%>
  	 </tr>
  	<%
  	 }
  	 %>
  </table>
  </body>
</html>
