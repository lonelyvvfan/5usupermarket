<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script charset="utf-8" src="../kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh_CN.js"></script>
<title>查看订单</title>
</head>
<body>
<div id="good_main_body">
<div id="s_win">
		<div id="s_left">
		</div>
		<div id="s_right">

	<div id="s_form" style="width:76%">
	<h4>订单编号：${order.orderNo}</h4>
			<table class="table" id="order_good">
			<thead>
				<tr>
					<td>商品名称</td>
					<td>商品单价</td>
					<td>购买数量</td>
				</tr>
			</thead>
			<tbody>
			  <%int i= -1; %>
			<s:iterator value="list_detail">
			  <%i++;%>
				<tr>
					<input type="hidden" name="list_detail1[<%= i%>].id" value="${id}"/>
					<td>${goodsname}</td>
					<td>${price}元</td>
					<td>${number}件</td>
				</tr>
				</s:iterator>
			</tbody>
			</table>
		<table class="table table-bordered" id="order_table">
						<tr>
							<td>用户名</td>
							<td>${order.username }
							</td>
							<td>真实姓名</td>
							<td>${order.truename }
							</td>
						</tr>
						
						<tr>
							<td>送货时间</td>
							<td>
								${order.arrivedday}&nbsp;<script>selectarrivedtime('${order.arrivedtime}')</script>
							</td>
							<td>地址</td>
						    <td>${order.other_address}<script>selectschool('${order.school}')</script>&nbsp;<script>selectliving('${order.living}')</script>&nbsp;${order.doorplate }幢 &nbsp;${order.room }室
						    </td>
						</tr>
						<tr>
						<td>支付方式</td>
						<td><script>selectpayway('${order.payway}')</script></td>
						<td>最终金额</td>
							<td>${order.totalamount }元
							</td>
					    </tr>
						<tr>
							<td>联系电话</td>
							<td>${order.telephone }
						</td>
						<td>备注</td>
						<td>${order.remark }
						</td>
					  </tr>
					
		</table>
	</div>
</div>
</div>


</body>
</html>