<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>注册成功</title>

</head>
<body>
<h1>注册成功！</h1>
<%--通过sessionScope得到信息--%>
<p> 用户名：${sessionScope.userName}</p>
<p> 密码：${sessionScope.password}</p>
<a href="${pageContext.request.contextPath}/Out">返回登录</a>
</body>
</html>
