<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'query.jsp' starting page</title>

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
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException c){
    	System.out.println("加载驱动不成功！");
    }
    try{
    	String url = "jdbc:mysql://localhost:3306/test?user=root&password=123456";
        conn = DriverManager.getConnection(url);
    	st=conn.createStatement();
    	rs = st.executeQuery("select * from hr");
    %>
    <table border="1">
    	<capition>
    	信息
    	</capition>
    	<tr>
    		<th>id</th>
    		<th>姓名</th>
    		<th>最小工资</th>
    		<th>最大工资</th>
    	</tr>
    	<%
    	while(rs.next()){
    		%>
    		<tr>
    		<td><%=rs.getString(1) %></td>
    		<td><%=rs.getString(2) %></td>
    		<td><%=rs.getDouble(3) %></td>
    		<td><%=rs.getDouble(4) %></td>
    		<%=rs.getRow() %>
    		</tr>
    		<%
    	}
    	%>
    </table>
    
    <%	
    }catch(SQLException e){
    	e.printStackTrace();
    }finally{
    	try{
    	if(conn!=null){
    		conn.close();
    	}
    	if(null!=st){
    		st.close();
    	}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    }
    %>
  </body>
</html>
