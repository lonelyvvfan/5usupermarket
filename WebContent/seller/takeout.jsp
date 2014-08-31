<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title></title>
<head>
	<script language="javascript" src="js/jquery-1.7.2.min.js"></script>
	<script language="javascript" src="js/ajax.js"></script>
	<script type="text/javascript" src="js/foucus.js"></script>
	<script type="text/javascript" src="js/AnchorArt.js"></script>
</head>
<body>
<div id="main_body">
<div id="container_slider">
    <div id="left">
        <img src="image/weixin1.png"/>
        <p>扫一扫</p>
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
                    <td id="gonggao" onmouseover="out1()">公告</td>
                    <td id="wuyou" onmouseover="out2()">了解无忧</td>
                </tr>
                <tr><td id="right_table_content" colspan="2" rowspan="2">公告1：<br> 公告2:</td></tr>
        </table>
    </div>
</div>
<div style="clear: both"></div>
<div id="right_sort">
    <table>
        <tr style="background-color:#5dc3e4"><td style="color: red"><a href="seller/takeout.jsp#1F">早餐</a></td></tr>
        <tr style="background-color:#f4b217"><td><a href="seller/takeout.jsp#2F">中餐</a></td></tr>
        <tr style="background-color:#9ac949"><td><a href="seller/takeout.jsp#3F">晚餐</a></td></tr>
    </table>
</div>


<div id="container_sort">

<div class="sort">
    <h2 style="border-color: rgb(221,197,70)">
        <span id="1F" style="color: cornflowerblue">早餐</span>
        <p style="background-color: #e99518">
            <b>豆制品</b>
            <b>面包类</b>
            <b>其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <a href="onetakeout.jsp">
            <img src="image/goods.png"></a>
            <p>
                <b class="price">
                    &#65509; 1.2
                </b>
                <strike>&#65509;2</strike>
                <button>购买</button>
            </p>
            <h3>确找无忧食品</h3>
        </li>
    </ul>
    <p style="clear: both"></p>
    <table class="index">
        <tr>
            <td class="hover" >1</td>
            <td>2</td>
            <td>3</td>
            <td>更多>></td></tr>
    </table>
</div>
<div id="gotop">
    <img style="margin-left=20px;" src="image/goto_top.png" onclick="window.scrollTo(0,0)">
    <a href="seller/car.jsp"><img id="buy_car" src="image/buy_car.png"></a>
</div>
<div class="sort">
    <h2 style="border-color: rgb(221,197,70)">
        <span id="2F" style="color: #e99b0f">中餐</span>
        <p style="background-color: #e99518">
            <b>面类</b>
            <b>饭类</b>
            <b>煲仔类</b>
            <b>其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <a href="onetakeout.jsp">
                <img src="image/goods.png"></a>
            <p>
                <b class="price">
                    &#65509; 1.2
                </b>
                <strike>&#65509;2</strike>
                <button>购买</button>
            </p>
            <h3>确找无忧食品</h3>
        </li>
    </ul>
    <p style="clear: both"></p>
    <table class="index">
        <tr>
            <td class="hover">1</td>
            <td>2</td>
            <td>3</td>
            <td>更多>></td></tr>
    </table>
</div>
<div class="sort">
    <h2 style="border-color: rgb(221,197,70)">
        <span id="3F" style="color: #99c94d">晚饭</span>
        <p style="background-color: #e99518">
            <b>面类</b>
            <b>汤类</b>
            <b>其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <a href="onetakeout.jsp">
                <img src="image/goods.png"></a>
            <p>
                <b class="price">
                    &#65509; 1.2
                </b>
                <strike>&#65509;2</strike>
                <button>购买</button>
            </p>
            <h3>确找无忧食品</h3>
        </li>

    </ul>
    <p style="clear: both"></p>
    <table class="index">
        <tr>
            <td class="hover">1</td>
            <td>2</td>
            <td>3</td>
            <td>更多>></td></tr>
    </table>
</div>


</body>
</html>