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
	 <script type="text/javascript" src="js/usergreatajax.js"></script>
	 <script type="text/javascript" src="js/AnchorArt.js"></script>
</head>
<body>
<p id="index4"></p>
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
        <li id="l1" style="background-color:#5dc3e4" onclick="scroller('1F', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>女装/内衣</a></li>
        <li id="l2" style="background-color:#f4b217" onclick="scroller('2F', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>运动休闲</a></li>
        <li id="l3" style="background-color:#9ac949" onclick="scroller('3F', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>男装/内衣</a></li>
        <li id="l4" style="background-color:#cd508c" onclick="scroller('4F', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>手机数码</a></li>
        <li id="l5" style="background-color:#9ac949" onclick="scroller('5F', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>电脑办公</a></li>
        <li id="l6" style="background-color:#f4b217" onclick="scroller('6F', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>食品</a></li>
        <li id="l7" style="background-color:#5dc3e4" onclick="scroller('7F', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>图书影像</a></li>
        <li id="l8" style="background-color:#f4b217" onclick="scroller('8F', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)" ><a>医药保健</a></li>
    </ul>
</div>


<div id="container_sort">
<div class="sort" onmouseover="right_active1('l1')">
    <h2 id="1F" style="border-color: cornflowerblue">
        <span style="color: cornflowerblue">女装/内衣</span>
        <p style="background-color: cornflowerblue">
        	<b onclick="clickall(2);two_active('1F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(2,2);two_active('1F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">套装</b>
            <b onclick="choose(2,3);two_active('1F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">上衣</b>
            <b onclick="choose(2,4);two_active('1F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">下衣</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q2" class="front gseller">
        <li id="sort_left"><img src="image/greatseller/index2.png"></li>
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
    <h2 id="2F" style="border-color: #e99b0f">
        <span style="color: #e99b0f">男/运动户外</span>
        <p style="background-color: #e99b0f">
        	<b onclick="clickall(3);two_active('2F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(3,5);two_active('2F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">休闲</b>
            <b onclick="choose(3,6);two_active('2F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">运动套装</b>
            <b onclick="choose(3,7);two_active('2F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q3" class="front gseller">
        <li id="sort_left"><img src="image/greatseller/index3.png"></li>

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
    <h2 id="3F" style="border-color: #99c94d">
        <span style="color: #99c94d">男装/内衣</span>
        <p style="background-color: #99c94d">
       		<b onclick="clickall(4);two_active('3F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(4,8);two_active('3F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">套装</b>
            <b onclick="choose(4,9);two_active('3F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">上衣</b>
            <b onclick="choose(4,10);two_active('3F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">下衣</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q4" class="front gseller">
        <li id="sort_left"><img src="image/greatseller/index4.png"></li>
     
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
    <h2 id="4F" style="border-color: #cd508c">
        <span style="color: #cd508c">手机数码</span>
        <p style="background-color: #cd508c">
        	<b onclick="clickall(5);two_active('4F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(5,11);two_active('4F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">手机</b>
            <b onclick="choose(5,12);two_active('4F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">相机</b>
            <b onclick="choose(5,13);two_active('4F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">手表</b>
            <b onclick="choose(5,14);two_active('4F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q5" class="front gseller">
        <li id="sort_left"><img src="image/greatseller/index5.png"></li>
       
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
<div id="index_gotop">
        <img id="top_img" style="margin-left:20px;height:38px;width:40px;" src="image/goto_top.png" onclick="window.scrollTo(0,0)">
        <a onClick="car();"><img id="buy_car" src="image/buy_car.png"></a>
    </div>
<div class="sort" onmouseover="right_active1('l5')">
    <h2 id="5F" style="border-color: #9ac949">
        <span style="color:#9ac949">电脑办公</span>
        <p style="background-color: #9ac949">
        	<b onclick="clickall(6);two_active('5F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(6,15);two_active('5F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">电脑</b>
            <b onclick="choose(6,16);two_active('5F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">电脑配件</b>
            <b onclick="choose(6,17);two_active('5F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q6" class="front gseller">
        <li id="sort_left"><img src="image/greatseller/index6.png"></li>
      
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
<div class="sort" onmouseover="right_active1('l6')">
    <h2 id="6F" style="border-color: #f4b217">
        <span style="color: #f4b217">食品</span>
        <p style="background-color: #f4b217">
        	<b onclick="clickall(7);two_active('6F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(7,18);two_active('6F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">进口</b>
            <b onclick="choose(7,19);two_active('6F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">饮料</b>
            <b onclick="choose(7,20);two_active('6F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q7" class="front gseller">
        <li id="sort_left"><img src="image/greatseller/index7.png"></li>
 
    </ul>
    <p style="clear: both"></p>
    <table id="p7" class="index">
        <tr>
            <td class="hover">1</td>
            <td>2</td>
            <td>3</td>
            <td>更多>></td></tr>
    </table>
</div>
<div class="sort" onmouseover="right_active1('l7')">
    <h2 id="7F" style="border-color: #5dc3e4">
        <span style="color: #5dc3e4">图书影像</span>
        <p style="background-color: #5dc3e4">
        	<b onclick="clickall(8);two_active('7F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(8,21);two_active('7F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">专业书籍</b>
            <b onclick="choose(8,22);two_active('7F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">文学</b>
            <b onclick="choose(8,23);two_active('7F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">法律</b>
            <b onclick="choose(8,24);two_active('7F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q8" class="front gseller">
        <li id="sort_left"><img src="image/greatseller/index8.png"></li>
      
    </ul>
    <p style="clear: both"></p>
    <table id="p8" class="index">
        <tr>
            <td class="hover">1</td>
            <td>2</td>
            <td>3</td>
            <td>更多>></td></tr>
    </table>
</div>
<div class="sort" onmouseover="right_active1('l8')">
    <h2 id="8F" style="border-color: #f4b217">
        <span style="color: #f4b217">医药保健</span>
        <p style="background-color: #f4b217">
        	<b onclick="clickall(9);two_active('8F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
            <b onclick="choose(9,25);two_active('8F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">食疗保健</b>
            <b onclick="choose(9,26);two_active('8F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">医药保健</b>
            <b onclick="choose(9,27);two_active('8F',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
        </p>
    </h2>
    <ul class="so"></ul>
    <ul id="q9" class="front gseller">
        <li id="sort_left"><img src="image/greatseller/index9.png"></li>
      
    </ul>
    <p style="clear: both"></p>
    <table id="p9" class="index">
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