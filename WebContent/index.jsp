<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
	<script language="javascript" src="js/jquery-1.7.2.min.js"></script>
	 <script type="text/javascript" src="js/foucus.js"></script>
</head>
<body>
<div id="main_body">
<div id="container_slider">
    <div id="left">
        <img src="image/weixin1.png"/>
    </div>
    <div id="slider">
                <ul>
                    <li><a href="#"><img src="image/slider.png"/></a></li>
                    <li><a href="#"><img src="image/slider.png"/></a></li>
                    <li><a href="#"><img src="image/slider.png"/></a></li>
                    <li><a href="#"><img src="image/slider.png"/></a></li>
                    <li><a href="#"><img src="image/slider.png"/></a></li>
                </ul>
            </div>
    <div id="right">
        <img src="image/right.png">
        <table>
            <tr class="firstline">
                <td>公告</td>
                <td>了解无忧</td>
            </tr>
            <tr><td >公告1：</td><td></td></tr>
            <tr><td>公告2：</td><td></td></tr>
        </table>
    </div>
</div>
<div style="clear: both"></div>

<div class="sort">
    <h2 style="border-color: rgb(221,197,70)">
        <span style="color: cornflowerblue">admin/seller/user</span>
        <p style="background-color: #e99518">
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front login" style="margin-left:400px;">
        <li style="background: #e84a4f"><a href = "login.jsp">admin登陆</a></li>
         <li style="background: #e84a4f"><a href = "UserLogin.jsp">user登陆</a></li>
        <li style="background: #e84a4f"><a href = "SellerLogin.jsp">seller登陆</a>
        </li>
    </ul>
    <p style="clear: both"></p>
</div>

</body>
</html>