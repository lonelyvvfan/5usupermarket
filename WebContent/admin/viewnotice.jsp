<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看公告</title>
</head>
<body>
<p id="index11"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
			<table class="table">
						<tr>
						<td>标题：</td>
						<td>${notice.title}</td>
						</tr>
						<tr>
							<td>内容：</td>
							<td>${notice.content}
						</td>
					  </tr>
		</table>
</div>
</div>

</body>
</html>