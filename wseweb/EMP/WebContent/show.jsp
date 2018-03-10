<%@page import="com.oracle.entity.Emp"%>
<%@page import="java.util.List"%>
<%@page import="com.oracle.server.EmpServer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.index {
	border: 1px solid #E1E2E3;
	width: 50px;
	float: left;
	text-align: center;
	margin-left: 5px;
	margin-right: 5px;
}

.border {
	border: solid 1px #666666;
	background-color: #BBBBBB;
}
</style>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function() {
		$(".index").mouseenter(function() {
			$(this).addClass("border");
		});
		$(".index").mouseleave(function() {
			$(this).removeClass("border");
		});
		$.post("EmpServlet?m=show", {

		}, function(data) {

		})
	});
</script>
</head>
<body>
	<a href="index.jsp">返回导航页</a>
	<hr>
	<%
		//1、传入当前页要显示的记录数和当前页页码数
		String pageIndexStr = request.getParameter("pageIndex");
		int pageIndex;
		if (pageIndexStr == null) {
			pageIndex = 1;//第一页页码
		} else {
			pageIndex = Integer.parseInt(pageIndexStr);//还要检查get参数，abc...
		}
		int records = 6;//一页要显示多少条记录

		EmpServer empServer = new EmpServer();

		//2、记录总共要显示多少个页面，从数据库取出总记录数/records,如果，否则
		int nums = empServer.getEmpNums();
		int pageNums = nums % records == 0 ? nums / records : nums
				/ records + 1;
		int i = 0;
		//3、链接
		if (pageIndex > 1) {
	%>
	<a href="userInfo.jsp?pageIndex=<%=1%>"><span class="index">首页</span></a>
	<a href="userInfo.jsp?pageIndex=<%=pageIndex - 1%>"><span
		class="index">上一页</span></a>
	<%
		}
		if (pageIndex < pageNums) {
			//每页显示10个链接，共多少页
			int sumpages = pageNums / 10;
			if (pageIndex > 6) {
				for (int j = pageIndex - 5; j <= pageIndex + 4; j++) {
	%>
	<a href="userInfo.jsp?pageIndex=<%=j%>"> <span class="index">
			<%
				out.print(j);
			%>
	</span></a>
	<%
		}
	%>
	<%
		} else {
				for (int j = 1; j <= 10; j++) {
	%><a href="userInfo.jsp?pageIndex=<%=j%>"> <span class="index">
			<%
				out.print(j);
			%>
	</span></a>
	<%
		}
			}
	%>
	<a href="userInfo.jsp?pageIndex=<%=pageIndex + 1%>"><span
		class="index">下一页</span></a>
	<a href="userInfo.jsp?pageIndex=<%=pageNums%>"> <span class="index">
			尾页 </span></a>
	<br>
	<%
		}
	%>
	<br>
	<hr>
	当前页数为：<%=pageIndex %>
	数据库里总记录数为：<%=nums %>
	总页数为：<%=pageNums %>
	每次取<%=records %>条记录
	<br>
	<hr>
	<%
		List<Emp> emps = empServer.getEmpInfos(records, pageIndex);
		for (Emp emp : emps) {
			out.print("页面中第" + (++i) + "条记录======" + emp + "<br>");
		}
	%>
</body>
</html>