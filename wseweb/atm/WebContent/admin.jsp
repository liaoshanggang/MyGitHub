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
$("#btn1").click(function(){
	/* $.post("UserServlet?method=query1",{
		name:$("#name").val(),
		pwd:$("#pwd").val()
	},function(data,status){
		$("#show1").html(data);
	}) */
	var account = $("#account").val();  
    var cardNo = $("#cardNo").val()
    $.post("UserServlet?m=query1", //利用ajax发起请求，这里写servlet的路径  
              {"account":account,"cardNo":cardNo},  
              function(data){    
                  if(data.IsOK == true){    
                       //window.location.href="UserServlet?m=query"; //如果返回的IsOK的值为true,则执行该跳转
                       
                  }else{  
                      //window.location.href="http://www.baidu.com";  
                  }  
                 },  
             "json"    
     );  
})
})
</script>
</head>
<body>
<a href="UserServlet?m=query">查询所有用户信息</a>
<a href="UserServlet?m=add">添加用户信息</a>
<hr>
<div>
账号：<input type="text" id="account" name="account">
卡号：&nbsp;&nbsp;<input type="text" id="cardNo" name="cardNo">
<button id="btn1">查询</button>
</div>
<div id="show1">
</div>
<hr>
</body>
</html>