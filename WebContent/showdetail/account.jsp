<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<script language="javascript" src="js/check.js"></script>
<link href="style/bootstrap.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	<div id="ucart">
		<div id="ordlist">
			<ul class="ordinfo">
			<s:set name="items" value="#session.cart.items"/>
        <s:iterator value="#items">
				<li><img src="images/goods/<s:property value="value.savepath"/>">
					<h3><s:property value="value.goodsname"/>×<span><s:property value="value.number"/></span></h3>
					<p>
						<b class="price"> &#65509;<s:property value="value.price"/> </b>
					</p>
					<div>
						<span class="del"><a href="shopping!delete?goodsid=<s:property value="value.goodsid"/>">×</a></span> <b>-</b> <span class="a_num">1</span> <b>+</b>
						<span class="sum">&#65509;<s:property value="value.total"/></span>
					</div></li>
					 </s:iterator>
			</ul>
			<span id="count">合计
			</span><span id="sum"><s:property value="#session.cart.totalPrice"/></span>
		</div>
		<div id="userinfo">
			<form>
				<div class="ordinfo">

					<h3>订单信息</h3>
					<div class="input-prepend">
						<span class="add-on">名字</span> <input type="text" class="span3"
							id="order_name" placeholder="请输入您的姓名" onblur="o_checkformname()" required>
						<span id="oname" class="frbule"></span>
					</div>
					<div class="input-prepend">
						<span class="add-on">详细地址</span>
						<div class="input-prepend">
							<span class="add-on">楼号</span> <input type="text" class="span1"
								id="order_building" placeholder="楼号" onclick="foraddr()" onblur="room()" required>
						</div>
						<div class="input-prepend">
							<span class="add-on">房间</span> <input type="text" class="span1"
								id="order_room" placeholder="房间号" onblur="room()" required>
						</div>
						<span id="addr" class="frbule"></span>
					</div>
					<div class="input-prepend">
						<span class="add-on">联系电话</span> <input type="text" class="span3"
							id="telephone" placeholder="请输入您的电话" onblur="checkmobile()" required>
						<span id="tel" class="frbule"></span>
					</div>
					 <div class="box3">
                        <div class="d">收货日期</div>
                        <div class="e">
                            <input type="radio" name="order_day" value="1" class="rad" id="order_day1" tabindex="9" checked="checked">
                            <label for="day1">6月7日</label>
                            <input type="radio" name="order_day" value="1" class="rad" id="order_day2" tabindex="9">
                            <label for="day2">6月8日</label>
                            <input type="radio" name="order_day" value="1" class="rad" id="order_day3" tabindex="9">
                            <label for="day3">6月9日</label>
                        </div>
                    </div>
                    <div class="box3">
                        <div class="d">收货时间</div>
                        <div class="e">
                            <select class="span3">
                                <option>今日结束，请选择明天</option>
                                <option>今日结束，请选择明天</option>
                                <option>今日结束，请选择明天</option>
                            </select>
                        </div>
                    </div>
					<div class="box3">
                        <div class="d">支付方式</div>
                        <div class="e">
                            <input type="radio" name="pay_way" value="1" class="way" id="pay_way1" tabindex="9" checked="checked">
                            <label for="pay_way1"><img src="image/huodao.png"/></label>
                            <input type="radio" name="pay_way" value="1" class="way" id="pay_way2" tabindex="9">
                            <label for="pay_way2"><img src="image/zhifubao.png"/></label>
                        </div>
                    </div>
                    <div class="box3">
                        <div class="d">备注</div>
                        <div class="e">
                            <textarea rows="4px" cols="35px" id="beizhu"></textarea>
                            <button type="button" onclick="setTip(this.value)" value="100找零" >100找零</button>
                            <button type="button" onclick="setTip(this.value)" value="快点送货吖~" >快点送货吖~</button>
                            <button type="button" onclick="setTip(this.value)" value="东西易碎，轻拿轻放" >东西易碎，轻拿轻放~</button>
                        </div>
                    </div>
				</div>
				<button type="submit" class="btn" id="a_order" >结算</button>
			</form>
		</div>
		<p class="clear"></p>
	</div>
</body>
</html>