<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<script language="javascript" src="js/jquery-1.7.2.min.js"></script>
<script language="javascript" src="js/check.js"></script>
<link href="style/bootstrap.css" rel="stylesheet">
<script language="javascript" src="js/settip.js"></script>
<script language="javascript" src="js/get_date.js"></script>
<script language="javascript" src="js/final.js"></script>
<script language="javascript" src="js/selectSchool.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function closet(){
	document.getElementById("ucart").style.visibility='hidden';
	window.reload('good.jsp');
 }
</script>
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
						<span class="del"><a href="shopping!delete?goodsid=<s:property value="value.goodsid"/>">×</a></span> <b><button onclick="jian(<s:property value="value.goodsid"/>)">-</button></b> <input id="<s:property value="value.goodsid"/>" class="a_num" type="text" style="width:20px; text-align:center" value=<s:property value="value.number"/>> <b><button onclick="jia(<s:property value="value.goodsid"/>);">+</button></b>
						<span class="sum">&#65509;<s:property value="value.total"/></span>
					</div></li>
					 </s:iterator>
			</ul>
			<span id="count">合计
			</span><span id="sum"><s:property value="#session.cart.totalPrice"/></span><span>元</span>
		</div>
		<div id="userinfo">
		<form name="alipayment" action="shopping!checkout" method="post" target="_blank" onsubmit="closet()" >
				<div class="ordinfo">
					<h3>订单信息</h3>
					<div class="input-prepend">
						<span class="add-on">名字</span> <input type="text" class="span3" name="truename"
							id="order_name" placeholder="请输入您的姓名" onblur="o_checkformname()" required>
						<span id="oname" class="frbule"></span>
					</div>
					<div class="input-prepend">
						<span class="add-on">学校地址</span>
						<div class="input-prepend">
							<span class="add-on">学校</span> 
							<select class="span2" style="width:160px" name="school" id="sch" onchange="changeSch()" required>
							<option></option>
							<option value="0">浙江工商大学</option>
							<option value="1">浙江财经大学</option>
							<option value="2">中国计量学院现代科技学院</option>
							<option value="3">杭州师范大学</option>
							<option value="4">浙江经贸职业技术学院</option>
							<option value="5">浙江金融职业技术学院</option>
							<option value="6">浙江水利水电学院</option>
							<option value="7">浙江经济职业技术学院</option>
							</select>
						</div>
						<div class="input-prepend">
							<span class="add-on">生活区</span> 
							<select class="span2" style="width:150px" name="living" id="buil" required>
							</select>
						</div>
					</div>
					<div class="input-prepend">
						<span class="add-on">详细地址</span>
						<div class="input-prepend">
							<span class="add-on">楼号</span> <input type="text" class="span1"
							 name="doorplate"	id="order_building" placeholder="楼号" onclick="foraddr()" onblur="room()" required>
						</div>
						<div class="input-prepend">
							<span class="add-on">房间</span> <input type="text" class="span1"
							name="room"	id="order_room" placeholder="房间号" onblur="room()" required>
						</div>
						<span id="addr" class="frbule"></span>
					</div>
					<div class="input-prepend">
						<span class="add-on">联系电话</span> <input type="text" class="span3"  name="telephone"
							id="telephone" placeholder="请输入您的电话" onblur="checkmobile()" required>
						<span id="tel" class="frbule"></span>
					</div>
					 <div class="box3">
                        <div class="d">收货日期</div>
                        <div class="e">
                            <input type="text" name="arrivedday" value="" onclick="new Calendar().show(this);"  readonly="readonly" class="rad" id="order_day1" required />
                        </div>
                    </div>
                    <div class="box3">
                        <div class="d">收货时间</div>
                        <div class="e">
                             <select name="arrivedtime" id="arrivedtime" required>
                            </select>
                        </div>
                    </div>
					<div class="box3">
                        <div class="d">支付方式</div>
                        <div class="e">
                            <input type="radio" name="payway" value="1" class="way" id="pay_way1" tabindex="9" checked="checked">
                            <label for="pay_way1"><img src="image/huodao.png"/></label>
                            <input type="radio" name="payway" value="0" class="way" id="pay_way2" tabindex="9">
                            <label for="pay_way2"><img src="image/zhifubao.png"/></label>
                        </div>
                    </div>
                    <div class="box3">
                        <div class="d">备注</div>
                        <div class="e">
                            <textarea rows="4px" cols="35px" id="beizhu"  name="remark"></textarea>
                            <button type="button" onclick="setTip(this.value)" value="100找零" >100找零</button>
                            <button type="button" onclick="setTip(this.value)" value="快点送货吖~" >快点送货吖~</button>
                            <button type="button" onclick="setTip(this.value)" value="东西易碎，轻拿轻放" >东西易碎，轻拿轻放~</button>
                        </div>
                    </div>
				</div>
				<button type="submit" class="btn" id="a_order">结算</button>
			</form>
		</div>
		<p class="clear"></p>
	</div>
	
</body>
</html>