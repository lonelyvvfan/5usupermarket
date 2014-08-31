<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
<form action ="admin/login!alteradmin" method = "post">
	<table class="table">
		<tr>
		<td>请输入用户名：</td>
		<td><input type = "text" name = "username" />
		</td>
		</tr>
		<tr>
		<td>请输入密码：</td>
		<td><input type = "password"  onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" onkeydown="if(event.keyCode==13)event.keyCode=9"  name = "password" /></td>
		</tr>
		<tr>
		<td>请输入新密码：</td>
		<td><input type = "password"  onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" onkeydown="if(event.keyCode==13)event.keyCode=9"  name = "nowpassword" /></td>
		</tr>
		<input class="btn btn-danger" style="width:80px" type="submit" value="修改密码" onclick="return confirm('确定修改密码？')" />
		
	</table>
	</form>
</div>
		</div>
	</div>
</body>
</html>