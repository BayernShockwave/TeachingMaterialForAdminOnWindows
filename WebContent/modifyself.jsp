<%@ page language="java" import="java.util.*,Dao.*,Entity.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人信息</title>
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
#leftmenu ul {
list-style-type: none;margin:0px;padding:0px;
}
#leftmenu li {
border-bottom:0px solid #000000;padding:0px;width: 100%;height: 63px;line-height: 60px;
}
#mainmenu {
float:left;width:1123px;height: 500px;font-size: 15px;font-weight: bolder;text-align: center;background-color: #00FFFF;
border-right:1px solid #000000;border-top:1px solid #000000;border-bottom:1px solid #000000;
}
#foot {
clear: both;width: 100%;height: 20px;background-color: #7FFFD4;text-align: center;color: #FFFFFF;
}
</style>
<%
request.setCharacterEncoding("utf-8");
String college=(String)session.getAttribute("college");
%>
</head>
<body>
<div id="container">
<div id="logo">
<img src="img/logo.JPG" />
</div>
<div id="title">教材管理系统</div>
<div id="content">
<div id="leftmenu">
<ul>
<li><%out.println("<a href=\"check.action?type=checkself\">查看个人信息</a><br/>");%></li>
<li><%out.println("<a href=\"check.action?type=checkuser\">查看用户信息</a><br/>");%></li>
<li><%out.println("<a href=\"check.action?type=checkemail\">忘记密码申请</a><br/>");%></li>
<li><%out.println("<a href=\"check.action?type=checkdiary\">查看系统日志</a><br/>");%></li>
<li><a href="Login.jsp">退出登录</a></li>
</ul>
</div>
<div id="mainmenu">
<h1 align="center">欢迎!!!您可以修改您的个人信息!!!</h1>
<div style="width:100%;text-align:center">
<form action="change_pwd_rs" method = "post">
	原密码：<input type="password" id="oldpassword" name="oldpassword" placeholder="请输入原密码"><br/>
	新密码：<input type="password" id="newpassword" name="newpassword" placeholder="请输入新密码"><br/>
	确认新密码：<input type="password" id="check_newpassword" name="check_newpassword" placeholder="请再次输入新密码"><br/>
	<input type="submit" id="confirm" name="confirm" value="确认">
</form>
</div>
</div>
</div>
<div id="foot">网站版权声明:The app was created by Dick Chen and Stone Zhang</div>
</div>