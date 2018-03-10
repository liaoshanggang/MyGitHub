<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="score" >80</c:set>
<c:choose>
	<c:when test="${score>=90 }">成绩优秀，继续保持！</c:when>
</c:choose>
<c:choose>
	<c:when test="${score>=80&&score<90 }">成绩良，继续保持！</c:when>
</c:choose>
<c:choose>
	<c:when test="${score>=70&&score<80 }">成绩中，继续保持！</c:when>
</c:choose>
<c:choose>
	<c:when test="${score>=60&&score<70 }">成绩及格，继续保持！</c:when>
</c:choose>
<c:choose>
	<c:when test="${score<60 }">成绩不及格，继续保持？</c:when>
</c:choose>
<%
	List<String> lists = new ArrayList<String>();
	lists.add("hello1");
	lists.add("hello2");
	lists.add("hello3");
	request.setAttribute("lists", lists);
%>
<hr>
<c:forEach var="list" items="${lists }">
	<c:out value="${list }"/>
</c:forEach>
<hr>
<c:out value="${null }" escapeXml="false">使用的表达式结果为null，则输出该默认值</c:out>
<hr>
<c:set var="salary" scope="session" value="${2000*2}"/>
<c:out value="${salary}"/>
<hr>
</body>
</html>