<%@page import="java.sql.SQLException"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP '4_5_4.jsp' starting page</title>

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
	  	int pageSize = 5;//每页行数
	  	int allRecords = 0;//总行数
	  	int totalPages = 0;//总页数
	  	int pageIndex = 1;//当前页
	  	try{
	  		Context ctx = new InitialContext();
	  		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
	  		conn = ds.getConnection();
	  		st = conn.createStatement();
	  		
	  		//获取总行数
	  		rs = st.executeQuery("select count(*)from hr");
	  		if(rs.next()){
	  			allRecords = rs.getInt(1);
	  		}
	  		//计算总页数
	  		totalPages = allRecords%pageSize==0?allRecords/pageSize:allRecords/(pageSize+1);
	  		
	  		//获得当前页
	  		String pageIndexStr = request.getParameter("pageIndex");
	  		if(pageIndexStr==null){
		pageIndexStr="1";  			
	  		}
	  		pageIndex = Integer.parseInt(pageIndexStr);
	  		//执行分页查询SQL查询，获取结果集
	  		String sql = "select id,name,minWage,maxWage(select limit as rn,r.*from(select * from hr order by id)t where limit<="+pageSize*pageIndex+")where rn>"+pageSize*(pageIndex-1);
	 	rs = st.executeQuery(sql);
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
			<td><%=rs.getString("id")%></td>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getDouble("minWage")%></td>
			<td><%=rs.getDouble("maxWage")%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		if(pageIndex>1){
		
			}
	%>
	<a href="pages.jsp?pageIndex=1">首页</a>&nbsp;
	<a href="pages.jsp?pageIndex=<%=pageIndex - 1%>">上一页</a>
	<%
	  	if(pageIndex<totalPages){
	%>
	<a href="pages.jsp?pageIndex=1<%=pageIndex + 1%>">下一页</a>&nbsp;
	<a href="pages.jsp?pageIndex=<%=totalPages%>">末页</a>
	<%
	  	}}catch(SQLException e){
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
