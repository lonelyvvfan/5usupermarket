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
        <tr style="background-color:#5dc3e4"><td><a href="seller/secondgoods.jsp#1F"> 二手书籍</a></td></tr>
        <tr style="background-color:#f4b217"><td><a href="seller/secondgoods.jsp#2F">手机数码</a></td></tr>
        <tr style="background-color:#9ac949"><td><a href="seller/secondgoods.jsp#3F">电瓶单车</a></td></tr>
        <tr style="background-color:#cd508c"><td><a href="seller/secondgoods.jsp#4F">电脑周边</a></td></tr>
        <tr style="background-color:#9ac949"><td><a href="seller/secondgoods.jsp#5F">其它专区</a></td></tr>
    </table>
</div>


<div id="container_sort">

<div class="sort">
    <h2 id="1F" style="border-color: rgb(221,197,70)">
        <span style="color: cornflowerblue">二手书籍</span>
        <p style="background-color: #e99518">
            <b>英语类</b>
            <b>数学类</b>
            <b>公共科学</b>
            <b>其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <a href="onesecondgoods.jsp"><img src="image/goods.png"></a>
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
    <h2 id="2F" style="border-color: rgb(221,197,70)">
        <span style="color: #e99b0f">手机数码</span>
        <p style="background-color: #e99518">
            <b>手机数码</b>
            <b>其它数码</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <a href="onesecondgoods.jsp"><img src="image/goods.png"></a>
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
<div id="gotop">
    <img style="margin-left=20px;" src="image/goto_top.png" onclick="window.scrollTo(0,0)">
    <a href="seller/car.jsp"><img id="buy_car" src="image/buy_car.png"></a>
</div>
<div class="sort">
    <h2 id="3F" style="border-color: rgb(221,197,70)">
        <span style="color: #99c94d">电瓶单车</span>
        <p style="background-color: #e99518">
            <b>自行车</b>
            <b>电瓶车</b>
            <b>其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <a href="onesecondgoods.jsp"><img src="image/goods.png"></a>
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
    <h2 id="4F" style="border-color: rgb(221,197,70)">
        <span style="color: #cc598f">电脑周边</span>
        <p style="background-color: #e99518">
            <b>笔记本相关</b>
            <b>台式机相关</b>
            <b>其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <a href="onesecondgoods.jsp"><img src="image/goods.png"></a>
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
    <h2 id="5F" style="border-color: rgb(221,197,70)">
        <span style="color: #99c94d">其它专区</span>
        <p style="background-color: #e99518">
            <b>          </b>
            <b>          </b>
            <b>          </b>
            <b>           </b>
        </p>
    </h2>
    <ul class="front last">
    </ul>
    <p style="clear: both"></p>
</div>
</div>

</body>
</html>