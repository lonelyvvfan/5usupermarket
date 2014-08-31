<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单管理</title>
</head>
<body>
<div id="good_main_body">
<div id="s_win">
		<div id="s_left">
		</div>
		<div id="s_right">

		<div id="s_all">
				<table class="table table-striped table-hover table-bordered s_m_table "  border="0" cellspacing="0" cellpadding="0"
					class="s_table s_table-hover">
					<thead>
						<tr
							style="background-color: #d9d8d8; font-size: 14px; color: #464646;">
							<td>订单号</td>
							<td>真名</td>
							<td>总金额</td>	
							<td>支付方式</td>			
							<td>地址</td>
							<td>送货时间</td>
							<td>订单状态</td>
							<td style="width:80px;">操作</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="orderpage.list">
							<tr>
								<td>${orderNo}</td>
								<td>${truename}</td>
								<td>${totalamount}元</td>
								<td><script>selectpayway('${payway}')</script></td>
								<td>${other_address}<script>selectschool('${school}')</script><br><script>selectliving('${living}')</script><br>&nbsp;${doorplate}楼&nbsp;${room}室</td>						
								<td>${arrivedday}&nbsp;<br><script>selectarrivedtime('${arrivedtime}')</script></td>
								<td><script>select('${isclosed}')</script></td>
								<td>
									<form action="user/ordermanage!altershow" method="post" target="_blank">
										<input type="hidden" value="${id}" name="id" /> 
										<input class="s_btn s_btn-view" type="submit" value="查看详情" />
									</form>								
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
		
							<tr>	
								<td>
									<a href="user/ordermanage?orderpage.currentPage=1">首页</a>
								</td>
								<s:iterator value="orderpage.pageList" id="e">
									<td>
										<a href="user/ordermanage?orderpage.currentPage=${e}&&username=${username}">${e}</a>
									</td>
								</s:iterator>
							<td>
								<a href="user/ordermanage?orderpage.currentPage=${orderpage.totalPage}">末页</a>
							</td>	
							<td>共有${orderpage.totalPage}页，${orderpage.allRow}条记录
							</td>
						</tr>
		<a href="user/ordermanage">返回</a>
		</div>
	</div>
</div>

</body>
</html>