<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>未登录</title>
</head>
<body>
<center>
<p id="nolog">
			您尚未登录，请登录后再进行操作
		</p>
		<br />
		<a href="normal/userlogin.jsp">返回登录页面</a>
		<p id="jump" style="margin-top:20px;">系统将会在<strong id="endtime"></strong>秒后跳转到登陆页面！</p>
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