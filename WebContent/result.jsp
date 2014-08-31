<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title></title>
<head>
<script language="javascript" src="js/ajax.js"></script>
</head>
<body>
 <div id="left">
        <img src="image/weixin1.png"/>
    </div>
<div id="good_main_body">

<div class="result">
    <span>搜索&nbsp;"${goodsname}"&nbsp;结果</span>

    
    	<div  class="sort chaoshi_result">
    	<h4 style="float:left;width:100%;line-height:30px;margin-left: 10px;margin-right: 60px;">超市 搜索结果如下：</h4>
    	<br />
    	<ul class="front1" id="result1">
       <s:iterator value="goodspage.list">
       
        <li>
            <a class='good good${id}' href="showGoods!altershow?id=${id}" target="_blank">
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
        <table>
          <tr>	
			<td><a href="search?goodspage.currentPage=1&&goodsname=${goodsname}">首页</a></td>
			<s:iterator value="goodspage.pageList" id="e">
			<td><a href="search?goodspage.currentPage=${e}&&goodsname=${goodsname}">${e}&nbsp;&nbsp;</a></td>
			</s:iterator>
			<td><a href="search?goodspage.currentPage=${goodspage.totalPage}&&goodsname=${goodsname}">末页</a></td>	
			<td>共有${goodspage.totalPage}页，${goodspage.allRow}条记录</td>
		</tr>
		</table>
        </div>
        <div  class="sort">
        <h4 style="float:left;width:100%;line-height:30px;margin-left: 10px;margin-right: 60px;">二手商品 搜索结果如下：</h4>
    	<br />
    	<ul class="front1">
        <s:iterator value="secgoodspage.list">
        
        <li>
        <a href="showSecgoods?id=${id}" target="_blank">
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
        <table>
        <tr>	
			<td><a href="search?secgoodspage.currentPage=1&&goodsname=${goodsname}">首页</a></td>
			<s:iterator value="secgoodspage.pageList" id="e">
			<td><a href="search?secgoodspage.currentPage=${e}&&goodsname=${goodsname}">${e}&nbsp;&nbsp;</a></td>
			</s:iterator>
			<td><a href="search?secgoodspage.currentPage=${secgoodspage.totalPage}&&goodsname=${goodsname}">末页</a></td>	
			<td>共有${secgoodspage.totalPage}页，${secgoodspage.allRow}条记录</td>
		</tr>
		</table>
        </div>
        <div  class="sort">
        	<h4 style="float:left;width:100%;line-height:30px;margin-left: 10px;margin-right: 60px;">套餐搜索结果如下：</h4>
        	<br />
        <ul class="front1" id="result3">
         <s:iterator value="combopage.list">
        
        <li>
        <a class='good good${id}' href="showCombo!altershow?id=${id}" target="_blank">
            <img src="images/combo${savepath}" onerror="javascript:this.src='image/error.jpg'">
            </a>
             <p id="goodsname" title=${goodsname}>${goodsname}</p>
            <p>
                <b class="price">
                    ${nowprice}
                </b>
                <strike>${price}</strike>
                <button><a  onclick="buycombo('result3',${id})">购买</a></button>
            </p>
            <h3>${reason}</h3>
        </li>
        </s:iterator>
        </ul>
        <table>
         <tr>	
			<td><a href="search?combopage.currentPage=1&&goodsname=${goodsname}">首页</a></td>
			<s:iterator value="combopage.pageList" id="e">
			<td><a href="search?combopage.currentPage=${e}&&goodsname=${goodsname}">${e}&nbsp;&nbsp;</a></td>
			</s:iterator>
			<td><a href="search?combopage.currentPage=${combopage.totalPage}&&goodsname=${goodsname}">末页</a></td>	
			<td>共有${combopage.totalPage}页，${combopage.allRow}条记录</td>
		</tr>
		</table>
	</div>
	<div class="sort">
	<h4 style="float:left;width:100%;line-height:30px;line-height:30px;margin-left: 10px;margin-right: 60px;">外卖搜索结果如下：</h4>
	<br />
         <ul class="front1">
         <s:iterator value="takeoutpage.list">
        <li>
        <a href="showTakeout?sellerid=${sellerid}&&suptypeid=${suptypeid}&&subtypeid=${subtypeid}" target="_blank">
            <img src="images/takeout${savepath}" onerror="javascript:this.src='image/error.jpg'">
            </a>
             <p id="goodsname" title=${goodsname}>${goodsname}</p>
            <h3>${reason}</h3>
        </li>
        </s:iterator>
        </ul>
        <table>
        <tr>	
			<td><a href="search?takeoutpage.currentPage=1&&goodsname=${goodsname}">首页</a></td>
			<s:iterator value="takeoutpage.pageList" id="e">
			<td><a href="search?takeoutpage.currentPage=${e}&&goodsname=${goodsname}">${e}&nbsp;&nbsp;</a></td>
			</s:iterator>
			<td><a href="search?takeoutpage.currentPage=${takeoutpage.totalPage}&&goodsname=${goodsname}">末页</a></td>	
			<td>共有${takeoutpage.totalPage}页，${takeoutpage.allRow}条记录</td>
		</tr>
		</table>
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