<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title></title>
</head>
<body>
	<script language="javascript" src="js/jquery-1.7.2.min.js"></script>
	<script language="javascript" src="js/usertakeoutajax.js"></script>
	<p id="index3"></p>
<div id="good_main_body">                                   <!--1-->
    <a  id="contact" href="#"><img   src="image/contect.png"></a>
	
    <div id="capital">
        <div id="capital_top">
            <p>${seller.name}</p>
        </div>
        <div id="capital_image">
        	<img	src="images/seller${seller.savepath}" onerror="javascript:this.src='image/error.jpg'">
        </div>
        <div id="capital_right">
            <p>${seller.name}</p>
            <br>
            <ul>
                <li>订餐电话 ：${seller.telephone}</li>
                <li><span>地    址</span> ：${seller.address}</li>
                <li>工作时间 ：早上8:00--晚上0:00</li>
                <li>供应类型 ：<script>selecttakeout_supertypes('${suptypeid}')</script>
                		  <script>selecttakeout_subtypes('${subtypeid}')</script></li>
            </ul>
            <ul class="share">
               <li><a href="#"><img src="image/success_zone.png"></a></li>
                        <li><a href="#"><img src="image/success_renren.png"></a></li>
                        <li><a href="#"><img src="image/succese_weibo.png"></a></li>
                        <li><a href="#"><img src="image/succese_plause.png"></a></li>
                        <li><a href="#"><img src="image/success_5.png"></a></li>
                        <li><a href="#"><img src="image/success_6.png"></a></li>
            </ul>
        </div>
        <div class="sort1">
            <h2>
                <span style="color: #f5b41e">今日供应</span>
            </h2>
            <ul id="q2" class="front front1">
             
            </ul>
            <p style="clear: both"></p>
            <table id="p2" class="index">
               
            </table>
        </div>
        <div id="capital_explain">
            <p>商家发布的说明</p>
            <p>${seller.content}</p>
        </div>
    </div>
	<div>
		<input	type="hidden" id="sellerid" value=${sellerid}>
		<input	type="hidden" id="suptypeid" value=${suptypeid}>
		<input	type="hidden" id="subtypeid" value=${subtypeid}>
	</div>
</body>
</html>