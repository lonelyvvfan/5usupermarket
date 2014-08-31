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

<title></title>
</head>
<body>

<body style="background-color:#d3d2cf">
    <div id="user_logo">
        <img src="image/logo3.png" style="width: 235px;height: 80px;top:110px;left:280px;position: absolute;">
    </div>
    <div>
        <img src="image/round_angle.jpg" style="width: 242px;height: 50px;top:230px;left:280px;position: absolute">
        <img src="image/5.png" style="width: 37px;height: 39px;top:233px;left:285px;position: absolute">
        <img src="image/round_angle.jpg" style="width: 242px;height: 50px;top:300px;left:280px;position: absolute">
        <img src="image/6.png" style="width: 37px;height: 39px;top:302px;left:282px;position: absolute">
        <img src="image/round_angle.jpg" style="width: 242px;height: 50px;top:370px;left:280px;position: absolute">
        <img src="image/22.png" style="width: 50px;height: 50px;top:366px;left:284px;position: absolute">
        <img src="image/round_angle.jpg" style="width: 242px;height: 50px;top:440px;left:280px;position: absolute">
        <img src="image/22.png" style="width: 50px;height: 50px;top:437px;left:285px;position: absolute">
        <button id="sign" type="button">注册</button>
<form action="register"  method = "post" enctype="multipart/form-data" >
        <p id="user_name">
            用户名:<input type = "text" name = "username" placeholder="用户名">
        </p>
        <br>
        <p id="number">
           联系电话:<input type = "text" name = "telephone" placeholder="联系电话">
        </p>
        <br>
        <p id="password">
            密码:<input type = "password" name = "password" placeholder="密码">
        </p>
        <br>
        <p id="re_password">
            再次输入密码:<input type = "password" name = "password1" placeholder="再次输入密码">
        </p>
        <br>
    </form>

    </div>
    <div id="line" style="width:1px; height:445px; border-left:3px dashed #eaa759;"></div>
    <div>
        <img src="image/round_angle.jpg" style="width: 225px;height: 63px;top:150px;left:750px;position: absolute">
        <img src="image/renren.jpg" style="width: 37px;height: 39px;top:162px;left:770px;position: absolute">
        <img src="image/round_angle.jpg" style="width: 225px;height: 63px;top:254px;left:750px;position: absolute">
        <img src="image/weibo.jpg" style="width: 37px;height: 39px;top:265px;left:770px;position: absolute">
        <img src="image/round_angle.jpg" style="width: 225px;height: 63px;top:354px;left:750px;position: absolute">
        <img src="image/weixin.jpg" style="width: 37px;height: 39px;top:365px;left:770px;position: absolute">
        <p><a id="renren" href="#">用人人帐号登陆</a></p>
        <p><a id="weibo" href="#">用微博帐号登陆</a></p>
        <p><a id="weixin" href="#">用微信帐号登陆</a></p>
    </div>
    <div id="foot">
        <span id="denglu">已有账户 我要<a href="#">登陆</a></span>
    </div>
    <div style="clear:both" />
</body>
</html>