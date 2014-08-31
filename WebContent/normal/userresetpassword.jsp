<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/other.css" />
    <style type="text/css">
        a:link,a:visited{
            text-decoration:none;  /*超链接无下划线*/
        }
    </style>
<script language="javascript" src="js/user_check.js"></script>
<title>无忧会员重置密码</title>
</head>
<body>
    <div>
        <a href="goods.jsp"><img id="user_logo" src="image/logo.png"></a>
    </div>
    <div>
        
   <form action="sellerlogin!resetpassword" method="post">
        <div id="user_name" class="input-prepend">
        <span class="add-on"><img src="image/5.png"></span>
            <input type="text" id="telephone" name="username" placeholder="请输入用户名" onblur="checkformname()" >
        </div>
        <br>
        <div id="number" class="input-prepend">
        <span class="add-on"><img src="image/6.png"></span>
            <input type="text" id="telephone" name="telephone" placeholder="请输入您的电话号码"  onblur="checkmobile()" required><span id="tel" class="frbule"></span>
        </div>
        <br>
        <br>
        <div id="re_password" class="input-prepend">
        <span class="add-on"><img src="image/22.png"></span>
            <input type="text"  id="second_pwd" name="identification" placeholder="请输入身份证"  required><span id="srpwd" class="frbule"></span>
        </div>
        <br>
        <button id="sign" type="submit" onmousedown="user_log()">登录</button>
        <a id="register" href="normal/register.jsp">立即注册</a>
    </form>

    </div>
    <div id="line" style="width:1px; height:445px; border-left:3px dashed #eaa759;"></div>
    <div>
        <div id="renren" onmouseover="this.className='shadow'" onmouseout="this.className=''">
       <img src="image/renren1.png">
       <a href="#">用人人账号登陆</a>
       </div>
       <div id="weibo" onmouseover="this.className='shadow'" onmouseout="this.className=''">
       <img src="image/weibo1.png">
       <a href="#">用微博账号登陆</a>
       </div>
       <div id="weixin" onmouseover="this.className='shadow'" onmouseout="this.className=''">
       <img src="image/qq1.png">
       <a href="#">用QQ账号登陆</a>
       </div>
    </div>
    <div id="foot">
    </div>
</body>
</html>