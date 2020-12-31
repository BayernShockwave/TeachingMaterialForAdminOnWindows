<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登录界面</title>
		<style type="text/css">
body {
background-color: #FFFFFF;font-family: "楷体";
}
a {
color: #000000;text-decoration: none;
}
a:hover {
color: #FF0000;
}
#container {
width: 100%;
margin: 0 auto;
text-align:center;
}
#logo {
width: 100%;height: 150px;
}
#title {
width: 100%;height: 50px;font-size: 50px;font-weight: bolder;text-align: center;background-color: #7FFFD4;
}
#content {
width: 100%;
}
#leftmenu {
float:left;width: 25%;height: 500px;font-size: 25px;font-weight: bolder;background-color: #00FFFF;border:1px solid #000000;
}
#mainmenu {
float:left;width:1123px;height: 500px;font-size: 25px;font-weight: bolder;text-align: center;background-color: #00FFFF;
border-right:1px solid #000000;border-top:1px solid #000000;border-bottom:1px solid #000000;
}
#foot {
clear: both;width: 100%;height: 20px;background-color: #7FFFD4;text-align: center;color: #FFFFFF;
}
</style>
	</head>
	<body>
	<div id="container">
	<div id="logo">
	<img src="img/logo.JPG" />
	</div>
	<div id="title">教材管理系统</div>
	<div id="content">
	<div id="leftmenu">
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	 欢迎使用本系统!<br/>
	 <br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	特别鸣谢:Dick Chen(陈靖秋)
	        Stone Zhang(张秋石)
	</div>
	<div id="mainmenu">
	<br/>
	<br/>
	<br/>
	            <form action="login_rs" method="post">
				<h4 align="center">欢迎!!!</h4>
				<h4 align="center">用户名:<input type="text" id="userid" name="userid" placeholder="请输入用户名"/><br/></h4>
				<h4 align="center">密码:<input type="password" id="password" name="password" placeholder="请输入密码"/><br/></h4>
				<h4 align="center"><input type="submit" id="login" name="login" value="登录"/>
				<input type="reset" id="clean" name="clean" value="清空"/></h4>
				</form>
	</div>
	</div>
	<div id="foot">网站版权声明:The app was created by Dick Chen and Stone Zhang</div>
	</div>
	</body>
</html>