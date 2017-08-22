<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<HTML>
<HEAD>
<base href="<%=basePath%>" />

<TITLE>搜房网租房</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="style/mycss.css" rel="stylesheet" type="text/css" />
<link href="style/texts.css" rel="stylesheet" type="text/css" />
<link href="style/btn.css" rel="stylesheet" type="text/css" />

</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
	MARGINHEIGHT=0>

	<table width="780" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td colspan="5"><img src="images/top.jpg" width="780"
				height="213"></td>
		</tr>
		<tr>
			<td colspan="5"><img src="images/middle1.jpg" width="780"
				height="47"></td>
		</tr>
		<tr>
			<td width="38" background="images/middle2.jpg">&nbsp;</td>
			<td width="172" valign="top"><script language="javascript">
				
			</script>

				<table align="center">
					<tr>
						<td width=''><font color='red'>当前用户：
								${sessionScope.logUser.username}</font></td>
					</tr>
					<tr>
						<td width='150'><a
							href="house/selectMe?userId=${logUser.userId }">管理我的租房信息</a></td>
					</tr>
					<tr>
						<td width='100'><a
							href="house/toInsert?userId=${logUser.userId }">发布租房信息</a></td>
					</tr>
					<tr>
						<td width='100'><a href="index.jsp">返回首页</a></td>
					</tr>
					<tr>
						<td width='100'><a href="user/logOut">[注销]</a></td>
					</tr>
				</table></td>
			<td width="35" background="images/layout_24.gif">&nbsp;</td>
			<td width="495">
				<table>
					<tr>
						<td width="3%">&nbsp;</td>
						<td width="97%">


							<table width='450' border='0'>
								<tr>
									<TD>标题</TD>
									<TD width='100' align='center'>月租金</TD>
									<TD width='110' align='center'>发布日期</TD>
									<TD width='50'>&nbsp;</TD>
									<TD width='50'>&nbsp;</TD>
								</tr>
								<tr>
									<td colspan='5'><hr /></td>
								</tr>

								<!-- 显示的我的出租信息 -->
								<c:forEach var="h" items="${houses }">
									<tr>
										<td><a href='detail.htm'>${h.title }</a></td>
										<td align='center' style='height: 30px;'>${h.price }元</td>
										<td align='center' style='height: 30px;'><fmt:formatDate
												value="${h.pubdate }" pattern="yyyy-MM-dd" /></td>
										<td align='center' style='height: 30px;'><a
											href='house/delete?hid=${h.id }&userId=${logUser.userId }'>[删除]</a></td>

										<td align='center' style='height: 30px;'><a
											href='house/toUpdate/${h.id}'>[修改]</a></td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan='5'><hr /></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="2"></td>
					</tr>
				</table>
			</td>
			<td width="40" background="images/middle4.jpg">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="5"><img src="images/bottom.jpg" width="780"
				height="82"></td>
		</tr>
	</table>
	<P align="center">2014 搜房网 版权所有</P>
	<br />
</BODY>
</HTML>