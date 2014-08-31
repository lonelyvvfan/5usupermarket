<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="js/check.js"></script>
<link rel="stylesheet" href="style/other.css" />
    <style type="text/css">
        a:link,a:visited{
            text-decoration:none;  /*超链接无下划线*/
        }
    </style>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/final.js"></script>
<title></title>
</head>
<body>
    <div>
        <a href="goods.jsp"><img id="user_logo" src="image/logo.png"></a>
    </div>
    <div>
      
<form action="register"  method = "post" name="myform" enctype="multipart/form-data" >
        <div id="user_name" class="input-prepend">
        <span class="add-on"><img src="image/5.png"></span>
            <input type="text" id="username" name="username" onBlur="isexist();" placeholder="请输入至少4位用户名"  required><span id="sname" class="frbule"></span>
        </div>
        <br>
        <div id="number" class="input-prepend">
        <span class="add-on"><img src="image/6.png"></span>
            <input type="text" id="telephone" name="telephone" placeholder="请输入您的电话号码"  onblur="checkmobile()" required><span id="tel" class="frbule"></span>
        </div>
        <br>
        <div id="password" class="input-prepend">
        <span class="add-on"><img src="image/22.png"></span>
            <input type="password" onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" onkeydown="if(event.keyCode==13)event.keyCode=9"  id="first_pwd" name="password" placeholder="请输入密码"  onblur="checkpwd()" required><span id="spwd" class="frbule"> </span>
        </div>
        <br>
        <div id="re_password" class="input-prepend">
        <span class="add-on"><img src="image/22.png"></span>
            <input type="password" onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" onkeydown="if(event.keyCode==13)event.keyCode=9"   id="second_pwd" name="password1" placeholder="请再次输入密码" onblur="rcheckpwd()" required><span id="srpwd" class="frbule"></span>
        </div>
        <br>
        <button id="sign" type="submit" onmousedown="sign_able()" >注册</button>
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
        <a href="normal/userlogin.jsp"><span id="denglu">已有账户 我要登陆</span></a>
    </div>
</body>
</html>