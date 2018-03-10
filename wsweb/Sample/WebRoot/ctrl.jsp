<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- <%
String ckname = request.getParameter("name").trim();
String ckpwd = request.getParameter("pwd").trim();

Cookie ck = new Cookie("ckname",ckname);
//设置有效3分钟
ck.setMaxAge(3*60);
response.addCookie(ck);

if(ckname.equals("admin")&&ckpwd.equals("admin")){
	response.sendRedirect("admin.jsp");
}else{
	response.sendRedirect("normal.jsp");
}
%> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>控制页面</title>

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
    String name = request.getParameter("name").trim();
    String pwd = request.getParameter("pwd").trim();
    
    session.setAttribute("adsesstionname", name);
    
    session.setMaxInactiveInterval(10*60);
    if(name.equals("admin")&&pwd.equals("admin")){
    	response.sendRedirect("admin.jsp");
    %>
	<%@include file="LoginC.jsp"%>

	<%
    }else{
    	response.sendRedirect("normal.jsp");
    	 %>
	<%@include file="LoginC.jsp"%>

	<%	
    }
    
    /*String name = request.getParameter("name");
    String pwd = request.getParameter("pwd"); */
    
   /*  if(name.equals("admin")&&name.equals("admin")){
    	RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
    	rd.forward(request, response);
    }else{
    	RequestDispatcher rd = request.getRequestDispatcher("normal.jsp");
    	rd.forward(request, response);
    } */
    
    /* if(name.equals("admin")&&name.equals("admin")){
    	response.sendRedirect("admin.jsp?name="+name);
    }else{
    	response.sendRedirect("normal.jsp?name="+name);
    } */
    
    %>
</body>
</html>
