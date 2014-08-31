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
	<script language="javascript" src="js/check.js"></script>
	<script type="text/javascript" src="js/foucus.js"></script>
	 <script type="text/javascript" src="js/AnchorArt.js"></script>
	<style type="text/css" media="all">
		@import "style/thickbox.css";
	</style>
	 <script src="js/thickbox-compressed.js" type="text/javascript"></script>
</head>
<html>
<body>
<div id="main_body">
<p id="index1"></p>
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
    <div id="right_sort">
        <ul>
            <li id="l2" style="background-color:#5dc3e4;height:16px" onclick="scroller('o2', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)"><a>进口零食</a></li>
            <li id="l3"  style="background-color:#f4b217;height:16px" onclick="scroller('o3', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)"><a >水果专区</a></li>
            <li id="l4"  style="background-color:#9ac949;height:16px" onclick="scroller('o4', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)"><a >休闲素食</a></li>
            <li id="l5"  style="background-color:#cd508c;height:16px"  onclick="scroller('o5', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)"><a >乳品饮料</a></li>
            <li id="l6"  style="background-color:#9ac949;height:16px"  onclick="scroller('o6', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)"><a >生活用品</a></li>
            <li id="l7"  style="background-color:#f4b217;height:16px"  onclick="scroller('o7', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)"><a >办公数码</a></li>
            <li id="l8"  style="background-color:#5dc3e4;height:16px" onclick="scroller('o8', 1500);right_active(this)" onmouseover="right_over(this)" onmouseout="right_out(this)"><a >其它专区</a></li>
            
        </ul>
    </div>
    <p style="clear:both"></p>

    <div id="container_sort">
    <div class="sort">
        <table id="first_line">
            <tr>
                <td onmouseover="Over1();now(this)">无忧推荐</td>
                <td onmouseover="Over2();now(this)">套餐专区</td>
                <td onmouseover="Over3();now(this)">营养系列</td>
                <td onmouseover="Over4();now(this)">热销系列</td>
                <td onmouseover="Over5();now(this)">特价促销</td>
                <td onmouseover="Over6();now(this)">最新上架</td>
            </tr>
        </table>
        <ul id="q1" class="front">
           
        </ul>
        <p style="clear: both"></p>
      
		
    </div>

        <div id="o2" class="sort" onmouseover="right_active1('l2')">
            <h2 style="border-color: #5dc3e4">
                <span style="color: cornflowerblue">进口食品</span>
                <p style="background-color: #5dc3e4">
                	<b onclick="clickall(2);two_active('o2',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
                    <b onclick="choose(2,2);two_active('o2',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">零食进口</b>
                    <b onclick="choose(2,3);two_active('o2',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">饮料</b>
                    <b onclick="choose(2,4);two_active('o2',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
                </p>
            </h2>
            <ul class="so"></ul>
            <ul id="q2" class="front">
                <li id="sort_left"><img src="image/goods/index2.png"></li>

            </ul>
            <p style="clear: both"></p>
           	 <table id="p2" class="index">
                <tr>
                    <td class="hover"  onmouseover="mOver(2,1);this.style.backgroundColor='#e99518';this.style.color='#FFF'">1</td>
                    <td  onmouseover="mOver(2,2);this.bgColor='#e99518';this.style.color='#FFF'">2</td>
                    <td  onmouseover="mOver(2,3);this.bgColor='#e99518';this.style.color='#FFF'">3</td>
                    <td onmouseover="this.bgColor='#e99518';this.style.color='#FFF'">更多>></td></tr>
            </table>
		</div>
		
        <div id="o3" class="sort" onmouseover="right_active1('l3')">
            <h2 style="border-color: rgb(221,197,70)">
                <span style="color: #e99b0f">水果专区</span>
                <p style="background-color: #e99518" >
               		<b onclick="clickall(3);two_active('o3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
                    <b onclick="choose(3,5);two_active('o3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">苹果</b>
                    <b onclick="choose(3,6);two_active('o3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">香蕉</b>
                    <b onclick="choose(3,7);two_active('o3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">梨</b>
                    <b onclick="choose(3,8);two_active('o3',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
                </p>
            </h2>
            <ul class="so"></ul>
            <ul id="q3" class="front">
                <li id="sort_left"><img src="image/goods/index3.png"></li>
             

            </ul>
            <p style="clear: both"></p>
            <table id="p3" class="index">
                <tr>
                    <td class="hover"  onmouseover="mOver(3,1);bgchange()">1</td>
                    <td  onmouseover="mOver(3,2);bgchange()">2</td>
                    <td  onmouseover="mOver(3,3);bgchange()">3</td>
                    <td>更多>></td></tr>
            </table>
        </div>
        
        <div id="o4" class="sort" onmouseover="right_active1('l4')">
            <h2 style="border-color: #9ac949">
                <span style="color: #99c94d">休闲素食</span>
                <p style="background-color: #9ac949">
                	<b onclick="clickall(4);two_active('o4',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
                    <b onclick="choose(4,9);two_active('o4',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">零食</b>
                    <b onclick="choose(4,10);two_active('o4',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">方便面</b>
                    <b onclick="choose(4,11);two_active('o4',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
                </p>
            </h2>
            <ul class="so"></ul>
            <ul id="q4" class="front">
                <li id="sort_left"><img src="image/goods/index4.png"></li>              
            </ul>
            <p style="clear: both"></p>
            <table id="p4" class="index">
                <tr>
                    <td class="hover"  onmouseover="mOver(4,1);bgchange()">1</td>
                    <td  onmouseover="mOver(4,2);bgchange()">2</td>
                    <td  onmouseover="mOver(4,3);bgchange()">3</td>
                    <td>更多>></td></tr>
            </table>
        </div>
        <div id="o5" class="sort" onmouseover="right_active1('l5')">
            <h2 style="border-color: #cd508c">
                <span style="color: #cd508c">乳品饮料</span>
                <p style="background-color: #cd508c">
                	<b onclick="clickall(5);two_active('o5',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
                   <b onclick="choose(5,12);two_active('o5',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">奶制品</b>
                    <b onclick="choose(5,13);two_active('o5',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">饮料</b>
                    <b onclick="choose(5,14);two_active('o5',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">水</b>
                    <b>其它</b>
                </p>
            </h2>
            <ul class="so"></ul>
            <ul id="q5" class="front">
                <li id="sort_left"><img src="image/goods/index5.png"></li>
                
            </ul>
            <p style="clear: both"></p>
            <table id="p5" class="index">
                 <tr>
                    <td class="hover"  onmouseover="mOver(5,1);bgchange()">1</td>
                    <td  onmouseover="mOver(5,2);bgchange()">2</td>
                    <td  onmouseover="mOver(5,3);bgchange()">3</td>
                    <td>更多>></td></tr>
            </table>
        </div>
    <div id="index_gotop">
        <img id="top_img" style="margin-left:20px;height:38px;width:40px;" src="image/goto_top.png" onclick="window.scrollTo(0,0)">
        <a onClick="car();"><img id="buy_car" src="image/buy_car.png"></a>
    </div>
        <div id="o6" class="sort" onmouseover="right_active1('l6')">
            <h2 style="border-color: #9ac949">
                <span style="color:#9ac949">生活用品</span>
                <p style="background-color: #9ac949">
                	<b onclick="clickall(6);two_active('o6',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
                     <b onclick="choose(6,15);two_active('o6',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">纸制品</b>
                    <b onclick="choose(6,16);two_active('o6',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">美容</b>
                    <b onclick="choose(6,17);two_active('o6',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">洗护</b>
                    <b onclick="choose(6,18);two_active('o6',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
                </p>
            </h2>
            <ul class="so"></ul>
            <ul id="q6" class="front">
                <li id="sort_left"><img src="image/goods/index6.png"></li>
                
            </ul>
            <p style="clear: both"></p>
            <table id="p6" class="index">
                 <tr>
                    <td class="hover"  onmouseover="mOver(6,1);bgchange()">1</td>
                    <td  onmouseover="mOver(6,2);bgchange()">2</td>
                    <td  onmouseover="mOver(6,3);bgchange()">3</td>
                    <td>更多>></td></tr>
            </table>
        </div>
        <div id="o7" class="sort" onmouseover="right_active1('l7')">
            <h2 style="border-color: #f4b217">
                <span style="color: #f4b217">办公数码</span>
                <p style="background-color: #f4b217">
                	<b onclick="clickall(7);two_active('o7',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">全部</b>
                    <b onclick="choose(7,19);two_active('o7',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">电子数码</b>
                    <b onclick="choose(7,20);two_active('o7',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">办公文具</b>
                    <b onclick="choose(7,21);two_active('o7',this)" onmouseover="this.style.background='rgba(255, 255, 255, 0.4)'" onmouseout="this.style.background=''">其它</b>
                </p>
            </h2>
            <ul class="so"></ul>
            <ul id="q7" class="front">
                <li id="sort_left"><img src="image/goods/index7.png"></li>       
            </ul>
            <p style="clear: both"></p>
            <table id="p7" class="index">
                 <tr>
                    <td class="hover"  onmouseover="mOver(7,1);bgchange()">1</td>
                    <td  onmouseover="mOver(7,2);bgchange()">2</td>
                    <td  onmouseover="mOver(7,3);bgchange()">3</td>
                    <td>更多>></td></tr>
            </table>
        </div>
        
        <div id="o8" class="sort" onmouseover="right_active1('l8')">
            <h2 style="border-color:  #5dc3e4">
                <span style="color: #5dc3e4">其它专区</span>
            </h2>
            <ul class="so"></ul>
            <ul id="q8" class="front">
                <li id="sort_left"><img src="image/goods/index8.png"></li>       
            </ul>
            <p style="clear: both"></p>
            <table id="p8" class="index">
                 <tr>
                    <td class="hover"  onmouseover="mOver(8,1);bgchange()">1</td>
                    <td  onmouseover="mOver(8,2);bgchange()">2</td>
                    <td  onmouseover="mOver(8,3);bgchange()">3</td>
                    <td>更多>></td></tr>
            </table>
            <p style="clear: both"></p>
        </div>
    </div>
    
    
</body>
</html>