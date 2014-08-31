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
        <tr style="background-color:#5dc3e4"><td style="color: red"><a href="seller/greatseller.jsp#1F">女装/内衣</a></td></tr>
        <tr style="background-color:#f4b217"><td><a href="seller/greatseller.jsp#2F">男/运动休闲</a></td></tr>
        <tr style="background-color:#9ac949"><td><a href="seller/greatseller.jsp#3F">男装/内衣</a></td></tr>
        <tr style="background-color:#cd508c"><td><a href="seller/greatseller.jsp#4F">手机数码</a></td></tr>
        <tr style="background-color:#9ac949"><td><a href="seller/greatseller.jsp#5F">电脑办公</a></td></tr>
        <tr style="background-color:#f4b217"><td><a href="seller/greatseller.jsp#6F">食品</a></td></tr>
        <tr style="background-color:#5dc3e4"><td><a href="seller/greatseller.jsp#7F">图书影像</a></td></tr>
        <tr style="background-color:#f4b217"><td><a href="seller/greatseller.jsp#8F">医药保健</a></td></tr>
    </table>
</div>


<div id="container_sort">
<div class="sort">
    <h2 id="1F" style="border-color: rgb(221,197,70)">
        <span style="color: cornflowerblue">女装/内衣</span>
        <p style="background-color: #e99518">
            <b>套装</b>
            <b>上衣</b>
            <b>下衣</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <img src="image/goods.png">
            <p>
                <b class="price">
                    &#65509; 1.2
                </b>
                <strike>&#65509;2</strike>
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
        <span style="color: #e99b0f">男/运动户外</span>
        <p style="background-color: #e99518">
            <b>休闲</b>
            <b>运动套装</b>
            <b>其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <img src="image/goods.png">
            <p>
                <b class="price">
                    &#65509; 1.2
                </b>
                <strike>&#65509;2</strike>
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
    <h2 id="3F" style="border-color: rgb(221,197,70)">
        <span style="color: #99c94d">男装/内衣</span>
        <p style="background-color: #e99518">
            <b>套装</b>
            <b>上衣</b>
            <b>下衣</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <img src="image/goods.png">
            <p>
                <b class="price">
                    &#65509; 1.2
                </b>
                <strike>&#65509;2</strike>
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
        <span style="color: #f3b418">手机数码</span>
        <p style="background-color: #e99518">
            <b>手机</b>
            <b>相机</b>
            <b>手表</b>
            <b>其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <img src="image/goods.png">
            <p>
                <b class="price">
                    &#65509; 1.2
                </b>
                <strike>&#65509;2</strike>
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
    <h2 id="5F" style="border-color: rgb(221,197,70)">
        <span style="color:#66c3e5">电脑办公</span>
        <p style="background-color: #e99518">
            <b>电脑</b>
            <b>电脑配件</b>
            <b>其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <img src="image/goods.png">
            <p>
                <b class="price">
                    &#65509; 1.2
                </b>
                <strike>&#65509;2</strike>
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
    <h2 id="6F" style="border-color: rgb(221,197,70)">
        <span style="color: #cc598f">食品</span>
        <p style="background-color: #e89711">
            <b>进口</b>
            <b>饮料</b>
            <b>其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <img src="image/goods.png">
            <p>
                <b class="price">
                    &#65509; 1.2
                </b>
                <strike>&#65509;2</strike>
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
    <h2 id="6F" style="border-color: rgb(221,197,70)">
        <span style="color: #cc598f">图书影像</span>
        <p style="background-color: #e89711">
            <b>专业书籍</b>
            <b>文学</b>
            <b>法律</b>
            <b>其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <img src="image/goods.png">
            <p>
                <b class="price">
                    &#65509; 1.2
                </b>
                <strike>&#65509;2</strike>
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
    <h2 id="7F" style="border-color: rgb(221,197,70)">
        <span style="color: #cc598f">医药保健</span>
        <p style="background-color: #e89711">
            <b>食疗保健</b>
            <b>医药保健</b>
            <b>其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul class="front">
        <li><img src="image/sort_left.png"></li>
        <li>
            <img src="image/goods.png">
            <p>
                <b class="price">
                    &#65509; 1.2
                </b>
                <strike>&#65509;2</strike>
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

</div>

</body>
</html>