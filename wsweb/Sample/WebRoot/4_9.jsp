<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.*"%>
<%@page import="java.sql.*,javax.sql.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '4_9.jsp' starting page</title>

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
    Context ctx = new InitialContext();
    DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
    conn = ds.getConnection();
    st = conn.createStatement();
    rs = st.executeQuery("SELECT * FROM hr");
    %>
    <table border="1">
    	<caption>信息</caption>
    	<tr>
    		<th>职位ID</th>
    		<th>职位名称</th>
    		<th>最低工资</th>
    		<th>最高工资</th>
    	</tr>
    	<%
    	while(rs.next()){
    		%>
    		<tr>
    			<td><%=rs.getString("id") %></td>
    			<td><%=rs.getString("name") %></td>
    			<td><%=rs.getDouble("minWage") %></td>
    			<td><%=rs.getDouble("maxWage") %></td>
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
    		if(null!=st){
    			st.close();
    		}
    		if(null!=conn){
    			conn.close();
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    }
    %>
  </body>
</html>
