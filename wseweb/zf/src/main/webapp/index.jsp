<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<body>
<h2>Hello World!</h2>
<c:if test="${empty logUser}">
<h1><a href="login_form.jsp">登录</a></h1>
<h1><a href="reg.jsp">注册</a></h1>
</c:if>
<c:if test="${!empty logUser}">
<h1><a href="user/logOut">注销</a></h1>
<h1><a href="house/list">列表</a></h1>
<h1><a href="test.jsp">test</a></h1>
</c:if>
</body>
</html>
