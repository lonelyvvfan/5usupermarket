<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="js/check.js"></script>
<title></title>
</head>
<body>
<p id="left"><img src="image/weixin1.png"/></p>
 <div id="main_body">
    <div id="container_center">


        <div id="order">
            <div id="order_left">
                <form action="shopping!checkout" method="post">
                    <div class="box3">
                        <div class="d">姓名</div>
                        <div class="e">
                            <input type="text" name=truename id="order_name" class="in" onclick="o_forname()" onblur="o_checkformname()">
                            <span id="oname" class="frbule"></span>
                        </div>
                    </div>
                    
                    <div class="box3">
                    	<div class="d">楼号</div>
                    	<div class="e">
                    		<input type="text" name="doorplate" id="order_building" class="in" onclick="foraddr()" onblur="room()">
                    		 <span id="addr" class="frbule"></span>
                    	</div>
                    </div>
                    <div class="box3">
                    	<div class="d">房间号</div>
                    	<div class="e">
                    		<input type="text" name="room" id="order_room" class="in" onclick="foraddr()" onblur="room()">
                    		 <span id="addr" class="frbule"></span>
                    	</div>
                    </div>
                    
                    
                    <div class="box3">
                        <div class="d">联系电话</div>
                        <div class="e"><input type="text" name="telephone" id="telephone" name="telephone" onclick="formobile()" onblur="checkmobile()">
                        <span id="tel" class="frbule"></span>
                    </div>
                    </div>
                    <div class="box3">
                        <div class="d">收货日期</div>
                        <div class="e">
                            <input type="text" name="arrivedday" value="" onclick="new Calendar().show(this);" readonly="readonly" class="rad" id="order_day1"/>
                            
                        </div>
                    </div>
                    <div class="box3">
                        <div class="d">收货时间</div>
                        <div class="e">
                            <select name="arrivedtime">
                                <option value="0">早上8:00至10:00</option>
                                <option value="1">下午13:00至15：00</option>
                                <option value="2">晚上19：00至21：00</option>
                            </select>
                        </div>
                    </div>
                    <div class="box3">
                        <div class="d">支付方式</div>
                        <div class="e">
                            <input type="radio" name="payway" value="1" class="way" id="pay_way1" tabindex="9" checked="checked">
                            <label for="way1"><img src="image/huodao.png"/></label>
                            <input type="radio" name="payway" value="1" class="way" id="pay_way2" tabindex="9">
                            <label for="way2"><img src="image/zhifubao.png"/></label>
                        </div>
                    </div>
                    <div class="box3">
                        <div class="d">备注</div>
                        <div class="e">
                            <textarea rows="4px" cols="35px" id="beizhu" name="remark"></textarea>
                            <button type="button" onclick="setTip(this.value)" value="100找零" >100找零</button>
                            <button type="button" onclick="setTip(this.value)" value="囧" >囧</button>
                            <button type="button" onclick="setTip(this.value)" value="快点送货吖~" >快点送货吖~</button>
                            <button type="button" onclick="setTip(this.value)" value="东西易碎，轻拿轻放" >东西易碎，轻拿轻放~</button>
                        </div>
                    </div>
                    <div class="box3">
                        <div class="d">订单详情</div>
                        <div class="e">
                            <ul>
                                <li>4份台湾雪之恋手造麻薯（&#65509;7）</li>
                                <li>商品总数量：4件</li>
                                <li>商品总价格：&#65509;28.0元</li>
                            </ul>
                        </div>
                    </div>
                    <div class="car_center_foot order_foot">
                        <p>合计:<span id="all_price">&#65509;28.0</span></p>
                        <p id="tip">亲，本次为您节省了4.0元，买东西再来哈一年省好多的哟~</p>
                        <div id="confirm">
							
							<button type="button" tabindex="17" class="" ><a href="goods.jsp">继续购物</a></button>
                            <button type="submit" tabindex="17" class="" >确认下单</button>
                            
                        </div>
                    </div>
                </form>
                
            </div>
            <div id="order_right">
                <img src="image/message.png">
                <p id="welcome">
                         您好，xxx<br/>
                         登陆成功<br/>
                    欢迎您的登录，地址和电话也为您读取
                </p>
                <p id="please">
                        目前您的账户没有抵金券或者奖品，请在提交本订单后点击分享图标分享给您的好友（支持人人、QQ空间、微博等）~
                </p>
            </div>
        </div>
        <div style="clear: both"></div>
    </div>

</body>
</html>