<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>运用后端技术处理业务逻辑</title>

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
	<!--HTML输出-->
	今天是学习JSP的第一天
	<br>
	<%--用输出标签直接输出--%>
	<%="明天是学习JSP的第二天！"%><br>
	<%//定义字符串变量，用out对象输出%>
	<%
		String str = "后天是学习JSP的第三天！";
		out.println(str);
	%>
</body>
</html>
