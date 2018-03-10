<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("h3").click(function(){
		$(this).hide();
	})
	$("#btn").click(function(){
		$.get("jquery.jsp",function(data,status){
			$("#show").html(data);
		})
	})
	$("#btn1").click(function(){
		$.post("doLogin.jsp",{
			name:$("#name").val(),
			pwd:$("#pwd").val()
		},function(data,status){
			$("#show1").html(data);
		})
	})
})
</script>
</head>
<body>
<h3>点我试试，我会隐藏！</h3>
<h3>点我试试，我也会隐藏！</h3>
<h3>点我试试，据说我不会！</h3>
<button id="btn">向jquery.jsp页面发送HTPP GET请求，获得返回的结果</button>
<div id="show"></div>
<hr>
<div id="show1">
用户名：<input type="text" id="name" name="name"><br>
密码：&nbsp;&nbsp;<input type="password" id="pwd" name="pwd"><br>
<button id="btn1">登录</button>
</div>
</body>
</html>