<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title></title>
</head>
<body>
<p id="left"><img src="image/weixin1.png"/>
        扫一扫</p>
    <div id="container_center">
           <div id="car_center">
               <div id="item_top">
                   <div class="thing_name"><b>商品名称</b></div>
                   <div class="thing_price"><b>价格</b></div>
                   <div class="thing_num"><b>数量</b></div>
                   <div class="thing_sum"><b>合计</b></div>
                   <div class="thing_action"><b>操作</b></div>
               </div>
                <s:set name="items" value="#session.cart.items"/>
               <s:iterator value="#items">
               <div class="item_center">
                   <div class="thing_name"><img src="images/goods/<s:property value="value.savepath"/>"><p><s:property value="value.goodsname"/></p></div>
                   <div class="thing_price"><p class="price">&#65509;<s:property value="value.price"/></p></div>
                   <div class="thing_num">
                       <input type="text"  name="#" id="#" class="thing_num" tabindex="3" maxlength="3px" value=<s:property value="value.number"/>>
                       <button type="button" tabindex="2" class="plus" id="plus">+</button>
                       <button type="button" tabindex="2" class="reduce" id="reduce">-</button>
                   </div>
                   <div class="thing_sum"><p class="sum">&#65509;<s:property value="value.total"/></p></div>
                   <div class="thing_action"><p class="operate"><a href="shopping!delete?goodsid=<s:property value="value.goodsid"/>">删除</a></p> </div>
               </div>
               </s:iterator>
           </div>      
		
           <div class="car_foot">
               <div class="car_center_foot">
                   <p>合计:<span id="all_price">&#65509;28.0</span><span id="save">[网络超市已为您节省4.0元]</span></p>
                   <p id="tip">亲，买够29、59元下方可以免费领取相应礼品的哟~</p>
                   <div id="confirm">

                       <button type="button" tabindex="17" class="" ><a href="goods.jsp">继续购物</a></button>
                       <button type="button" tabindex="17" class="" ><a href="order.jsp">填写订单</a></button>
                       <p>
                           	<a href="shopping!deleteall">清空购物车</a>
                       </p>
                   </div>
               </div>
           </div>
       </div>

       <div class="result increase">
                <span>凑个整数吧</span>

                <ul class="result_list">
                    <li>
                        <img src="image/goods.png">
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
            </div>
        </div>
</body>
</html>