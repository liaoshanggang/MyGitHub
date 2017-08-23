<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>成功修改！</h1>
	request作用域中：${requestScope.student.stuName }
	<br /> session作用域中：${sessionScope.student.stuName }
	<br />
	<fmt:message key="resource.welcome"></fmt:message>
	<br>
	<fmt:message key="resource.exist"></fmt:message>
</body>
</html>