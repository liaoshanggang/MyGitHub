<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${request.info }</title>
<link rel="stylesheet" href="image/style.css" />
<script src="js/remind.js"></script>
</head>

<body topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
		<form id="Form1" method="post">
			<table width="1000" cellpadding="0" cellspacing="0" border="0">
				<tr height="100">
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" width="400"><img src="image/success.gif"></td>
					<td width="20">&nbsp;</td>
					<td valign="top">
						<table width="400" border="1" cellpadding="0" cellspacing="0" style="BORDER-RIGHT:#cccccc 1px solid;BORDER-TOP:#cccccc 1px solid;BORDER-LEFT:#cccccc 1px solid;BORDER-BOTTOM:#cccccc 1px solid;BORDER-COLLAPSE:collapse;BACKGROUND-COLOR:#ffffff">
							<tr height="30">
								<td colspan="2" align="center" background="image/main/l-bg5.jpg"><font color="#ffff66"><b>${request.info }</b></font></td>
							</tr>
							<tr height="150">
								<td align="center">${request.info}</td>
								
								<% 
									/*  url = login.jsp or user/getBlogInfo.action*/
									String url = (String)request.getAttribute("url");
									//response.sendRedirect(url);//太快了
									//等待3秒后跳转
									response.setHeader("Refresh","3;url=" + url);
								%>
								<h3>
									<span id="myspan">3</span>秒后跳转到<%=url %>
								</h3>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
