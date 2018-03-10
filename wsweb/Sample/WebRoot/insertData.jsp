<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'insertData.jsp' starting page</title>

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
    //职位ID
    String id = "2000";
    //职位名称
    String name = "lisi";
    //最低工资
    double minWage = 3000;
    //最高工资
    double maxWage = 30000;
    
    Connection conn = null;
    //Statement st = null;
    PreparedStatement pst = null;
    //1.加载驱动
    try{    	
    	Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e){
    	System.out.println("加载驱动不成功！");
    }
    try{    	
    //2.创建jdbc连接，其中有三个参数，JDBC URL、数据库用户名和密码
    String url = "jdbc:mysql://localhost:3306/test?user=root&password=123456";
    conn = DriverManager.getConnection(url);
   	//3.创建JDBC对象
   	//st = conn.createStatement();
   	//4.拼接并执行Sql语句
   	/* String sql = "insert into hr(id,name,minWage,maxWage)values(?,?,?,?)";
   	pst = conn.prepareStatement(sql);
 	pst.setString(1, "2000");
 	pst.setString(2, "lili");
 	pst.setDouble(3, 200);
 	pst.setDouble(4, 20000); */
   	StringBuffer sql = new StringBuffer("INSERT INTO hr VALUES(");
   	sql.append(id+",");
   	sql.append(name+",");
   	sql.append(minWage+",");
   	out.print("hello");
   	sql.append(maxWage+")");
   	pst = conn.prepareStatement(sql.toString());
   	//pst.execute(sql);
   	pst.execute(sql.toString());
   	//int b = pst.execute(sql.toString());
   	//out.print("执行sql的返回值为："+b+"<br>");
   	out.print("sql语句为："+sql);
   	
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
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    }
    
    
    
    %>
</body>
</html>
