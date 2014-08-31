<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<title></title>
<head>
	<script language="javascript" src="js/jquery-1.7.2.min.js"></script>
	<script language="javascript" src="js/usersecajax.js"></script>
	 <script type="text/javascript" src="js/foucus.js"></script>
	 <script type="text/javascript" src="js/AnchorArt.js"></script>
</head>
<body>
<p id="index2"></p>
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
        <li id="l1" style="background-color:#5dc3e4" onclick="scroller('s1', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a> 二手书籍</a></li>
        <li id="l2" style="background-color:#f4b217" onclick="scroller('s2', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>手机数码</a></li>
        <li id="l3" style="background-color:#9ac949" onclick="scroller('s3', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>电瓶单车</a></li>
        <li id="l4" style="background-color:#cd508c" onclick="scroller('s4', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>电脑周边</a></li>
        <li id="l5" style="background-color:#9ac949" onclick="scroller('s5', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>其它专区</a></li>
    </ul>
</div>


<div id="container_sort">

<div class="sort" onmouseover="right_active1('l1')">
    <h2 id="s1" style="border-color: cornflowerblue">
        <span style="color: cornflowerblue">二手书籍</span>
        <p style="background-color: cornflowerblue">
         	<b onclick="clickall(2);two_active('s1',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(2,2);two_active('s1',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">英语类</b>
            <b onclick="choose(2,3);two_active('s1',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">数学类</b>
            <b onclick="choose(2,4);two_active('s1',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">公共科学</b>
            <b onclick="choose(2,5);two_active('s1',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q2" class="front">
        <li id="sort_left"><img src="image/secondgoods/index2.png"></li>
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
<div class="sort" onmouseover="right_active1('l2')">
    <h2 id="s2" style="border-color: #e99b0f">
        <span style="color: #e99b0f">手机数码</span>
        <p style="background-color: #e99b0f">
        	<b onclick="clickall(3);two_active('s2',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(3,6);two_active('s2',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">手机数码</b>
            <b onclick="choose(3,7);two_active('s2',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它数码</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q3" class="front">
        <li id="sort_left"><img src="image/secondgoods/index3.png"></li>
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
<div id="index_gotop">
        <img id="top_img" style="margin-left:20px;height:38px;width:40px;" src="image/goto_top.png" onclick="window.scrollTo(0,0)">
        <a onClick="car();"><img id="buy_car" src="image/buy_car.png"></a>
    </div>
<div class="sort" onmouseover="right_active1('l3')">
    <h2 id="s3" style="border-color: #99c94d">
        <span style="color: #99c94d">电瓶单车</span>
        <p style="background-color: #99c94d">
            <b onclick="clickall(4);two_active('s3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(4,8);two_active('s3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">自行车</b>
            <b onclick="choose(4,9);two_active('s3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">电瓶车</b>
            <b onclick="choose(4,10);two_active('s3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q4" class="front">
        <li id="sort_left"><img src="image/secondgoods/index4.png"></li>
       

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
<div class="sort" onmouseover="right_active1('l4')">
    <h2 id="s4" style="border-color: #cc598f">
        <span style="color: #cc598f">电脑周边</span>
        <p style="background-color: #cc598f">
            <b onclick="clickall(5);two_active('s4',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(5,11);two_active('s4',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">笔记本相关</b>
            <b onclick="choose(5,12);two_active('s4',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">台式机相关</b>
            <b onclick="choose(5,13);two_active('s4',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q5" class="front">
        <li id="sort_left"><img src="image/secondgoods/index5.png"></li>
       

    </ul>
    <p style="clear: both"></p>
    <table id="p5" class="index">
        <tr>
            <td class="hover">1</td>
            <td>2</td>
            <td>3</td>
            <td>更多>></td></tr>
    </table>
</div>

<div class="sort" onmouseover="right_active1('l5')">
    <h2 id="s5" style="border-color: #99c94d">
        <span style="color: #99c94d">其它专区</span>
        <p style="background-color: #99c94d">
        	<b onclick="clickall(6);two_active('s5',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q6" class="front">
        <li id="sort_left"><img src="image/secondgoods/index6.png"></li>
       

    </ul>
    <p style="clear: both"></p>
    <table id="p6" class="index">
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