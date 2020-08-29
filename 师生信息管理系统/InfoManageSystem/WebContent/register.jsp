<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息管理系统注册</title>
<script>
        var status = '${sessionScope.pwdFail}';
        if (status=='yes'){
            alert("两次密码输入不一样，请重新输入")
        }
    </script>
</head>
<body>
	<div align="center" style="padding-top: 50px;">
		<form action="${pageContext.request.contextPath}/Register" method="post">
		<table  width="740" height="500" background="images/login.jpg" >
			<tr height="180">
				<td colspan="4"></td>
			</tr>
			<tr height="10">
				
				<td width="40%"></td>
				<td width="10%">用户名：</td>
				<td><input type="text" value="${userName }" name="userName"  required id="userName"/></td>
				<td width="30%"></td>
			</tr>
			<tr height="10">
				<td width="40%"></td>
				<td width="13%">密  码：</td>
				<td><input type="password" value="${password }" name="password" required id="password"/></td>
				<td width="30%"></td>
			</tr>
			
			<tr height="10">
				<td width="40%"></td>
				<td width="13%">确认密码：</td>
				<td><input type="password" value="${repassword }" name="repassword"  required id="repassword"/></td>
				<td width="30%"></td>
			</tr>
			<tr height="10">
				<td width="40%"></td>
				<td width="13%"><input type="submit" value="立即注册"/></td>
				<td><input type="reset"></td>
				<td width="30%"></td>
			</tr>
			<tr height="10">
				<td width="40%"></td>
				<td colspan="3">
					<font color="red">${error }</font>
				</td>
			</tr>
			<tr >
				<td></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>