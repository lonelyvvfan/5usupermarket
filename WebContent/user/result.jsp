<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title></title>
<head>
<script language="javascript" src="js/userajax.js"></script>
</head>
<body>

    <div id="left">
        <img src="image/weixin1.png"/>
    </div>

<div id="good_main_body">


<div class="result">
    <span>搜索&nbsp;"${goodsname}"&nbsp;结果:</span>

    
    	<div  class="sort chaoshi_result">
    	<h4 style="float:left;width:100%;line-height:30px;margin-left: 10px;margin-right: 60px;">超市 搜索结果如下：</h4>
    	<br />
    	<ul class="front1" id="result1">
       <s:iterator value="goodspage.list">
       
        <li>
            <a class='good good${id}' href="user/showGoods!altershow?id=${id}" target="_blank">
            	<img src="images/goods${savepath}" onerror="javascript:this.src='image/error.jpg'">
            </a>
            <p id="goodsname" title=${goodsname}>${goodsname}</p>
            <p>
                <b class="price">
                   &#65509;${nowprice}
                </b>
                <strike> ${price}</strike>
                <button onclick="buy('result1',${id})">购买</button>
            </p>
            <h3>${reason}</h3>
        </li>
        </s:iterator>
        </ul>
        </div>
        <div  class="sort">
        <h4 style="float:left;width:100%;line-height:30px;margin-left: 10px;margin-right: 60px;">二手商品 搜索结果如下：</h4>
    	<br />
    	<ul class="front1" id="result2">
        <s:iterator value="secgoodspage.list">
        
        <li>
        <a href="user/showSecgoods?id=${id}" target="_blank">
            <img src="images/secondgoods${savepath}" onerror="javascript:this.src='image/error.jpg'">
            </a>
             <p id="goodsname" title=${goodsname}>${goodsname}</p>
            <p>
                <b class="price">
                   &#65509; ${price}
                </b>
            </p>
            <h3>${reason}</h3>
        </li>
        </s:iterator>
        </ul>
        </div>
        <div  class="sort">
        	<h4 style="float:left;width:100%;line-height:30px;margin-left: 10px;margin-right: 60px;">套餐搜索结果如下：</h4>
        	<br />
        <ul class="front1" id="result3">
         <s:iterator value="combopage.list">
        
        <li>
        <a class='good good${id}'  href="user/showCombo!altershow?id=${id}" target="_blank">
            <img src="images/combo${savepath}" onerror="javascript:this.src='image/error.jpg'">
            </a>
             <p id="goodsname" title=${goodsname}>${goodsname}</p>
            <p>
                <b class="price">
                    ${nowprice}
                </b>
                <strike>${price}</strike>
                <button onclick="buycombo('result3',${id})">购买</button>
            </p>
            <h3>${reason}</h3>
        </li>
        </s:iterator>
        
        </ul>
	</div>
	<div class="sort">
	<h4 style="float:left;width:100%;line-height:30px;line-height:30px;margin-left: 10px;margin-right: 60px;">外卖搜索结果如下：</h4>
	<br />
         <ul class="front1" id="result4">
         <s:iterator value="takeoutpage.list">
        <li>
        <a href="user/showTakeout?sellerid=${sellerid}&&suptypeid=${suptypeid}&&subtypeid=${subtypeid}" target="_blank">
            <img src="images/takeout${savepath}" onerror="javascript:this.src='image/error.jpg'">
            </a>
             <p id="goodsname" title=${goodsname}>${goodsname}</p>
            <h3>${reason}</h3>
        </li>
        </s:iterator>
        </ul>
       </div>
    <p style="clear: both"></p>
</div>
     <div id="gotop"><img style="margin-left=20px;" src="image/goto_top.png" onclick="window.scrollTo(0,0)"></div>
    <div id="index_gotop">
        <img  id="top_img" style="margin-left:20px;height:38px;width:40px;" src="image/goto_top.png" onclick="window.scrollTo(0,0)">
        <a onClick="car();"><img id="buy_car" src="image/buy_car.png"></a>
    </div>
    
</body>
</html>