<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="js/check.js"></script>
<script language="javascript" src="js/idcard.js"></script>
<link rel="stylesheet" href="style/other.css" />
    <style type="text/css">
        a:link,a:visited{
            text-decoration:none;  /*超链接无下划线*/
        }
    </style>

<title></title>
</head>
<body>
    <div>
        <a href="goods.jsp"><img id="user_logo" src="image/logo.png"></a>
    </div>
    <div>
      
<form action="sellerlogin!resetpassword"  method = "post" name="myform" enctype="multipart/form-data" >
        <div id="user_name" class="input-prepend">
        <span class="add-on"><img src="image/5.png"></span>
            <input type="text" id="username" name="username"placeholder="请输入您的用户名" onblur="checkformname()" required><span id="sname" class="frbule"></span>
        </div>
        <br>
        <div id="user_num" class="input-prepend">
        <span class="add-on"><img src="image/5.png"></span>
            <input type="text" id="usernum" name="identification" placeholder="请输入您的身份证号码" onblur="IdCardValidate(this.value)" required><span id="snum" class="frbule"></span>
        </div>
        <br>
        <div id="number" class="input-prepend">
        <span class="add-on"><img src="image/6.png"></span>
            <input type="text" id="telephone" name="telephone" placeholder="请输入您的电话号码"  onblur="checkmobile()" required><span id="tel" class="frbule"></span>
        </div>
        <button id="find" style="top:490px" type="submit" onmousedown="find_able1();" >确定</button>
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
</body>
</html>