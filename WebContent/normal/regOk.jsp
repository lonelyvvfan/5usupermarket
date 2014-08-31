<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
</head>
<body>
	<center>
		<h1 style="margin-top:100px">
			注册成功！
		</h1>
		<br />
		<a href="normal/userlogin.jsp">前往登陆</a>
		<p id="jump">系统将会在<strong id="endtime"></strong>秒后跳转到登陆界面！</p>
	</center>
	<script type="text/javascript">
    var i = 3;
    function remainTime(){
        if(i==0){
            location.href='normal/userlogin.jsp';
        }
        document.getElementById('endtime').innerHTML=i--;
        setTimeout("remainTime()",1000);
    }
    remainTime();
</script>
</body>
</html>