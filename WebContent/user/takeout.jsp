<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title></title>
<head>
	<script language="javascript" src="js/jquery-1.7.2.min.js"></script>
	 <script type="text/javascript" src="js/foucus.js"></script>
	 <script type="text/javascript" src="js/usercnmajax.js"></script>
	 <script type="text/javascript" src="js/AnchorArt.js"></script>
</head>
<body>
<p id="index3"></p>
<div id="main_body">
<div id="left">
        <img src="image/weixin1.png"/>
    </div>
<div id="container_slider">
    
    <div id="slider">
                <ul>
                    <li><a href="#"><img src="image/slider1.png"/></a></li>
                    <li><a href="#"><img src="image/slider2.png"/></a></li>
                    <li><a href="#"><img src="image/slider3.png"/></a></li>
                    <li><a href="#"><img src="image/slider4.png"/></a></li>
                    <li><a href="#"><img src="image/slider5.png"/></a></li>
                </ul>
            </div>
    <div id="right">
        <img src="image/right.png">
        <table>
             <tr class="firstline">
                    <td id="gonggao" onmouseover="out1()">公告</td>
                    <td id="wuyou" onmouseover="out2()">了解无忧</td>
                </tr>
                <tr><td id="right_table_content" colspan="2" rowspan="2"></td></tr>
        </table>
    </div>
</div>
<div style="clear: both"></div>
<div id="right_sort">
    <ul>
        <li id="l1" style="background-color:#5dc3e4" onclick="scroller('t1', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>早餐</a></li>
        <li id="l2" style="background-color:#f4b217" onclick="scroller('t2', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>中餐</a></li>
        <li id="l3" style="background-color:#9ac949" onclick="scroller('t3', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>晚餐</a></li>
    </ul>
</div>


<div id="container_sort">

<div class="sort" onmouseover="right_active1('l1')">
    <h2 style="border-color: cornflowerblue">
        <span id="t1" style="color: cornflowerblue">早餐</span>
        <p style="background-color: cornflowerblue">
        	<b  onclick="clickall(2);two_active('t1',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(2,2);two_active('t1',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">豆制品</b>
            <b onclick="choose(2,3);two_active('t1',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">面包类</b>
            <b onclick="choose(2,4);two_active('t1',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q2" class="front">
        <li id="sort_left"><img src="image/takeout/index2.png"></li>
      
    </ul>
    <p style="clear: both"></p>
    <table id="p2" class="index">
        <tr>
            <td class="hover">1</td>
            <td>2</td>
            <td>3</td>
            <td>更多>></td></tr>
    </table>
</div>
<div id="index_gotop">
        <img id="top_img" style="margin-left:20px;height:38px;width:40px;" src="image/goto_top.png" onclick="window.scrollTo(0,0)">
        <a onClick="car();"><img id="buy_car" src="image/buy_car.png"></a>
    </div>
<div class="sort" onmouseover="right_active1('l2')">
    <h2 style="border-color: #e99b0f">
        <span id="t2" style="color: #e99b0f">中餐</span>
        <p style="background-color: #e99b0f">
        	<b  onclick="clickall(3);two_active('t2',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(3,5);two_active('t2',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">面类</b>
            <b onclick="choose(3,6);two_active('t2',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">饭类</b>
            <b onclick="choose(3,7);two_active('t2',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">煲仔类</b>
            <b onclick="choose(3,8);two_active('t2',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q3" class="front">
        <li id="sort_left"><img src="image/takeout/index3.png"></li>
        
    </ul>
    <p style="clear: both"></p>
    <table id="p3" class="index">
        <tr>
            <td class="hover">1</td>
            <td>2</td>
            <td>3</td>
            <td>更多>></td></tr>
    </table>
</div>
<div class="sort" onmouseover="right_active1('l3')">
    <h2 style="border-color: #99c94d">
        <span id="t3" style="color: #99c94d">晚饭</span>
        <p style="background-color: #99c94d">
        	<b  onclick="clickall(4);two_active('t3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(4,9);two_active('t3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">面类</b>
            <b onclick="choose(4,10);two_active('t3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">汤类</b>
            <b onclick="choose(4,11);two_active('t3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q4" class="front">
        <li id="sort_left"><img src="image/takeout/index4.png"></li>
        

    </ul>
    <p style="clear: both"></p>
    <table id="p4" class="index">
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