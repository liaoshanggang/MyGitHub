<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��Աע��</title>
    
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
    <div align="center">
    	<form name="reg" method="get" action="RegShow.jsp">
    		<table border="1" align="center">
	    		<tr>
	    			<td>�û�����</td>
	    			<td><input type="text" name="name"></td>
	    		</tr>
	    		<tr>
	    			<td>���룺</td>
	    			<td><input type="text" name="pwd"></td>
	    		</tr>
	    		<tr>
	    			<td>ȷ�����룺</td>
	    			<td><input type="text" name="repwd"></td>
	    		</tr>
	    		<tr>
	    			<td>�������䣺</td>
	    			<td><input type="text" name="email"></td>
	    		</tr>
	    		<tr>
	    			<td>�Ա�</td>
	    			<td><input type="radio" name="sex" value="��">��
						<input type="radio" name="sex" value="Ů">Ů</td>
	    		</tr>
	    		<tr>
	    			<td>����:</td>
	    			<td><input type="checkbox" name="like" value="����">����
	    				<input type="checkbox" name="like" value="����">����
	    				<input type="checkbox" name="like" value="��Ϸ">��Ϸ<br>
	    				<input type="checkbox" name="like" value="����">����
	    				<input type="checkbox" name="like" value="������">������
	    				<input type="checkbox" name="like" value="�Ķ�">�Ķ�	
	    			</td>
	    		</tr>
	    		<tr>
	    			<td colspan="2" align="center">
	    			<input type="submit" name="submit" value="�ύ">
	    			<input type="reset" name="reset" value="ȡ��">
	    			</td>
	    		</tr>
    		</table>
    	</form>  	
    </div>
  </body>
</html>
