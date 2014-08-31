<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title></title>
<meta http-equiv="Expires" CONTENT="0">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">

<head>
<script language="javascript" src="js/goodnum.js"></script>
<script language="javascript" src="js/showgoods.js"></script>
<script type="text/javascript" src="js/keywordajax.js"></script>
</head>
<body>
<p id="index3"></p>
 <p id="left"><img src="image/weixin1.png"/></p>
    <div id="good_main_body">

    <div id="information">
        <div id="information_img">
        <img id="big" src="images/takeout${takeout.savepath}" onerror="javascript:this.src='image/error.jpg'" onmouseover="show_big(this)" onmouseout="disshow_big()">
        <img id="bigsee" src="#" onerror="javascript:this.src='image/error.jpg'">
       <ul>
            <li><img src="images/takeout${takeout.savepath}"  onmouseover="good_show(this)" onerror="javascript:this.src='image/error.jpg'"></li>
            <li><img src="images/takeout${takeout.savepath1}"  onmouseover="good_show(this)" onerror="javascript:this.src='image/error.jpg'"></li>
            <li><img src="images/takeout${takeout.savepath2}"  onmouseover="good_show(this)" onerror="javascript:this.src='image/error.jpg'"></li>
            <li><img src="images/takeout${takeout.savepath3}"  onmouseover="good_show(this)" onerror="javascript:this.src='image/error.jpg'"></li>
        </ul>
        </div>
        <div id="main_information">
            <p id="goods_name">${takeout.goodsname}</p>
            <div class="box_inf goods_price">
              <div class="in1">价格</div>
              <div class="in2">&#65509;${takeout.price}</div>
            </div>
            <div class="box_inf">
                <div class="in1"><script>selecttakeout_supertypes('${takeout.suptypeid}')</script></div>
                <div class="in2"><script>selecttakeout_subtypes('${takeout.subtypeid}')</script></div>
            </div>
             <div class="box_inf">
              <div class="in1">供应商家</div>
              <div class="in2">${takeout.sellername}</div>
            </div>
            <div class="box_inf">
              <div class="in1">推荐理由</div>
              <div class="in2">${takeout.reason}</div>
            </div>
        </div>
        <div id="inf_foot">
            <p class="goods_main">商品详情</p>
            <div id="goods_content"></div>
        </div>
    </div>
   
</body>
</html>