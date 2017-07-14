<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			* {
				margin: 0px;
			}
			
			.head {
				height: 80px;
			}
			
			.body {}
			
			.foot {
				text-align: center;
				margin-top: 20px;
				color: #666666;
			}
			
			.content {
				background-color: #E93854;
				left: 0;
				top: 80px;
				width: 100%;
				height: 475px;
			}
			
			form {
				z-index: 4;
				overflow: visible;
				background: #fff fixed;
				position: absolute;
				border: #1E1E96;
				font: "微软雅黑";
				color: #0066FF;
				top: 200px;
			}
			
			.bg_class {
				position: absolute;
				height: 475px;
				left: 300px;
				right: 300px;
				top: 80px;
			}
			
			.copyright {
				margin: 10px 0;
				font-size: 13px;
			}
			
			.links {
				margin: 10px;
				font: "微软雅黑";
			}
			
			table {
				border: groove;
				border-color: #FFFF00;
			}
			.head_text{
				font-size: 50px;
			}
			a{
				color: red;
			}
		</style>
	</head>

	<body>
		<div class="head">
			<h1 class="head_text">Welcome login!</h1>
			<h6 align="right">登录页面，调查问卷</h6>
		</div>
		<div class="body">
			<div class="content">
				<form method="post" action="loginCtrl.jsp">
				<h1>帐号登录</h1>
				<table>
					<tr>
						<td>卡号:</td>
						<td><input type="text" name="cardNo"/>
						<span id="carNoFeedback"></span>
						</td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="text" name="pwd"/>
						<span id="carNoFeedback"></span>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" name="submit" value="登录" />
						<input type="reset" name="reset" value="取消"/>
						</td>
					</tr>
				</table>
				<h5><a href="atmRegister.jsp">立即注册</a></h5>
			</form>
				
				<!-- <div><img class="bg_class" src="./WEB-INF/imges/ban2.jpg"></div> -->
				<div class="bg_class" style="background:url(images/ban2.jpg);">
				</div>
			</div>
			<div>

			</div>
		</div>
		<div class="foot">
			<div class="links">
				<a>联系我们</a>
				<a>人才招聘</a>
				<a>广告服务</a>
				<a>ATM</a>
				<a>友情链接</a>
				<a>ATM社区</a>
				<a>English Site</a>
			</div>
			<div class="copyright">
				Copyright © 1995-2017 1995forward.com 版权所有
			</div>
		</div>
	</body>

</html>