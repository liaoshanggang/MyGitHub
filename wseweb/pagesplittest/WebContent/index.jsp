<%@page import="com.forward.entity.Emp"%>
<%@page import="java.util.List"%>
<%@page import="com.forward.server.EmpServer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
			.index{
				border:1px solid #E1E2E3;
				width: 30px;
				float:left;
				text-align:center;
				margin-left: 5px;
				margin-right: 5px;
			}
			.border{
				border: solid 1px #666666;
				background-color: #BBBBBB;
			}
</style>

		<script type="text/javascript" src="js/jquery-3.2.1.min.js" ></script>
		<script>
			$(document).ready(function(){
				$(".index").mouseenter(function(){
					$(this).addClass("border");
				});
				$(".index").mouseleave(function(){
					$(this).removeClass("border");
				});
			});

		</script>
</head>
<body>

<%

//1、传入当前页要显示的记录数和当前页页码数
String pageIndexStr = request.getParameter("pageIndex");
int pageIndex;
if(pageIndexStr==null){
	pageIndex = 1;//第一页页码
}else{
pageIndex = Integer.parseInt(pageIndexStr);//还要检查get参数，abc...
}
int records = 20;//一页要显示多少条记录

/* int min = records*(pageIndex-1);
int max = records*pageIndex;
List<Emp> emps = empServer.getEmpInfos(max, min); */

EmpServer empServer = new EmpServer();
List<Emp> emps = empServer.getEmpInfos(records, pageIndex); 

//2、记录总共要显示多少个页面，从数据库取出总记录数/records,如果，否则
int nums = empServer.getEmpNums();
int pageNums = nums%records==0? nums/records : nums/records+1;
int i=0;

%>
<hr>
<%
//3、链接
if(pageIndex>1){ %>
<a href="index.jsp?pageIndex=<%=1 %>">首页</a>
<a href="index.jsp?pageIndex=<%=pageIndex-1 %>">上一页</a>
<%}
	if(pageIndex<pageNums){%>
<a href="index.jsp?pageIndex=<%=pageIndex+1 %>">下一页</a>
<a href="index.jsp?pageIndex=<%=pageNums %>">尾页</a><br>
<%
} %>
<hr>
当前页数为：<%=pageIndex %> 数据库里总记录数为：<%=nums %> 总页数为：<%=pageNums %> 每次取<%=records %>条记录<br>
<hr>
<div>
<%for(int j=1;j<=pageNums;j++){
%><a href="index.jsp?pageIndex=<%=j%>">
<span class="index">
<%out.print(j); %>
</span></a><%
}%>
</div>
<br>
<hr>
<%
for(Emp emp: emps){
	out.print("页面中第"+(++i)+"条记录======"+emp+"<br>");
}
%>
</body>
</html>