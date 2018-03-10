<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.2.1.min.js"></script>
</head>  
<body>  
    <form id="form" action="" method="post">  
        <input type="text" id="username"> <br>  
        <input type="password" id="password"> <br>  
        <input type="button" id="btn" value="登录">  
    </form>  
  
<script>  
$(document).ready(function(){  
    $("#btn").click(function(){  
       var name = $("#username").val();  
       var pwd = $("#password").val()  
       $.post("Login?method=1", //利用ajax发起请求，这里写servlet的路径  
                 {"username":name,"password":pwd},   //传参  
                 function(data){    //请求成功时的回调函数  
                     if(data.IsOK == true){    
                          window.location.href="Login?method=2"; //如果返回的IsOK的值为true,也就是用户名密码都正确，则执行该跳转  
                     }else{  
                         window.location.href="http://www.baidu.com";  
                     }  
                    },  
                "json"    
        );  
    })    
})  
</script>  
</body>  
</html> 