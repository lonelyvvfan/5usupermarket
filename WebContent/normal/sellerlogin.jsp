<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/other.css" />
<script language="javascript" src="js/seller_check.js"></script>
    <style type="text/css">
        a:link,a:visited{
            text-decoration:none;  /*超链接无下划线*/
        }
    </style>

<title>无忧卖家登录</title>
</head>
<body>
     <div>
        <a href="goods.jsp"><img id="user_logo" src="image/logo.png"></a>
    </div>
    <div>
		<form action="sellerlogin" method="post">
         <div id="user_name" class="input-prepend">
        <span class="add-on"><img src="image/5.png"></span>
            <input type="text" id="username" name="username" placeholder="请输入用户名" onblur="checkformname()" >
        </div>
        <br>
        <div id="password" class="input-prepend">
        <span class="add-on"><img src="image/22.png"></span>
            <input type="password" id="fir_pwd"  class="password" name="password" placeholder="请输入密码" onblur="checkpwd()" >
        </div>
        <br>
        
        <button id="admin_sign" type="submit" onmousedown="seller_log()">登录</button>
        <a id="sellerforget" href="normal/sellerreset.jsp">忘记密码</a>
    </form>

    </div>
    <div id="line" style="width:1px; height:445px; border-left:3px dashed #eaa759;"></div>
      <div>
       <div id="admin_login">
       <p>&lt;&lt;外卖商家登陆</p>
       </div>
    </div>
    <div id="foot">
    </div>
</body>
</html>