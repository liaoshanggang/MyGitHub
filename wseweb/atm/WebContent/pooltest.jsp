<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
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
Context ctx = null;
DataSource ds = null;
Connection conn = null;
try{

ctx = new InitialContext();

ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/myoracle");
conn = ds.getConnection();
String sql = "SELECT * FROM EMP";
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(sql);
while(rs.next()){
	out.print(rs.getInt("EMPNO")+"||"+rs.getString("ENAME")+"||"+rs.getString("JOB"));
}
}catch(SQLException e){
	e.printStackTrace();
}finally{
	
}
%>
</body>
</html>