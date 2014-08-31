<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/other.css" />
<script language="javascript" src="js/admin_check.js"></script>
    <style type="text/css">
        a:link,a:visited{
            text-decoration:none;  /*超链接无下划线*/
        }
    </style>

<title>超级管理员登录</title>
</head>
<body>
    <div>
        <a href="goods.jsp"><img id="user_logo" src="image/logo.png"></a>
    </div>
    <div>
   <form action="login" method="post">
        <div id="user_name" class="input-prepend">
        <span class="add-on"><img src="image/5.png"></span>
            <input type="text" id="username" name="username" placeholder="请输入用户名" onblur="checkformname()" >
        </div>
        <br>
        <div id="password" class="input-prepend">
        <span class="add-on"><img src="image/22.png"></span>
            <input type="password" class="password" id="fir_pwd" name="password" placeholder="请输入密码" onblur="checkpwd()" >
        </div>
        <br>
        
        <button id="admin_sign" type="submit" onmousedown="admin_log()">登录</button>
    </form>

    </div>
    <div id="line" style="width:1px; height:445px; border-left:3px dashed #eaa759;"></div>
    <div>
       <div id="admin_login">
       <p>&lt;&lt;后台管理员登陆</p>
       </div>
    </div>
    <div id="foot">
    </div>
</body>
</html>