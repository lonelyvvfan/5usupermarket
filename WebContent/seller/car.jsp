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


       <div id="car_info">
           <div id="car_top">
               <ol class="num">
                   <li class="first">
                       <p ><span>1</span> 我的购物车</p>
                   </li>
                   <li class="second">
                       <p><span>2</span> 填写订单信息</p>
                   </li>
                   <li class="last">
                       <p><span>3</span> 成功提交订单</p>
                   </li>
               </ol>
           </div>
           <div id="car_center">
               <div id="item_top">
                   <div class="thing_name"><b>商品名称</b></div>
                   <div class="thing_price"><b>价格</b></div>
                   <div class="thing_num"><b>数量</b></div>
                   <div class="thing_sum"><b>合计</b></div>
                   <div class="thing_action"><b>操作</b></div>
               </div>
               <div class="item_center">
                   <div class="thing_name"><img src="image/thing.png"><p>台湾雪之恋手造麻薯</p></div>
                   <div class="thing_price"><p class="price">&#65509;7.0</p></div>
                   <div class="thing_num">
                       <input type="text"  name="#" id="#" class="thing_num" tabindex="3" maxlength="3px">
                       <button type="button" tabindex="2" class="plus" id="plus">+</button>
                       <button type="button" tabindex="2" class="reduce" id="reduce">-</button>

                   </div>
                   <div class="thing_sum"><p class="sum">&#65509;28</p></div>
                   <div class="thing_action"><p class="operate">删除</p> </div>
               </div>
           </div>
           <div class="car_foot">
               <div class="car_center_foot">
                   <p>合计:<span id="all_price">&#65509;28.0</span><span id="save">[网络超市已为您节省4.0元]</span></p>
                   <p id="tip">亲，买够29、59元下方可以免费领取相应礼品的哟~</p>
                   <div id="confirm">

                       <button type="button" tabindex="17" class="" >继续购物</button>
                       <button type="button" tabindex="17" class="" >确认付款</button>
                       <p>
                           清空购物车
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