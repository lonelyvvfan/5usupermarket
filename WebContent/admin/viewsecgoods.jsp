<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看二手商品信息</title>
</head>
<body>
<p id="index4"></p>
	<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
					<table class="table">
						<tr>
							<td>类别：</td>
							<td><script>selectsecgoods_supertypes('${secondgoods.suptypeid}')</script>><script>selectsecgoods_subtypes('${secondgoods.subtypeid}')</script></td>
								
						</tr>
						<tr>
							<td>发布用户名：</td>
							<td>
								${secondgoods.username}
							</td>
						</tr>
							<tr>
							<td>发布者真实姓名：</td>
							<td>
								${secondgoods.nickname}
							</td>
						</tr>
						<tr>
							<td>商品名：</td>
							<td>${secondgoods.goodsname}</td>
						</tr>
						<tr>
							<td>新旧程度：</td>
							<td><script>selectrecency('${secondgoods.recency}')</script></td>
						</tr>
						<tr>
							<td>推荐理由：</td>
							<td>
								${secondgoods.reason}
							</td>
						</tr>
						<tr>
							<td>现价：</td>
							<td>${secondgoods.price}元</td>
						</tr>
						<tr>
							<td >地址：</td>
							<td><script>selectschool('${secondgoods.school}')</script>&nbsp;<script>selectliving('${secondgoods.living}')</script></td>
						</tr>
						<tr>
							<td>QQ：</td>
							<td>${secondgoods.qq}</td>
						</tr>
						<tr>
							<td>手机：</td>
							<td>${secondgoods.telephone}</td>
						</tr>
						<tr>
							<td>当前主图片：</td>
							<td><img alt="pic" class="good_img"  src="images/secondgoods/${secondgoods.savepath}">
							</td>
						</tr>
						<tr>
							<td>当前其他图片1：</td>
							<td><img alt="pic" class="good_img"  src="images/secondgoods/${secondgoods.savepath1}">
							</td>
						</tr>
						<tr>
							<td>当前其他图片2：</td>
							<td><img alt="pic" class="good_img"  src="images/secondgoods/${secondgoods.savepath2}">
							</td>
						</tr>
						<tr>
							<td>当前其他图片3：</td>
							<td><img alt="pic" class="good_img"  src="images/secondgoods/${secondgoods.savepath3}">
							</td>
						</tr>
						<tr>
							<td>商品介绍：</td>
							<td>${secondgoods.introduce}</td>
						</tr>
						<tr>
						<td>是否上架：</td>
						<td><script>selectshelves('${secondgoods.shelves}')</script></td>
					</tr>
					</table>
			</div>
		</div>
	</div>
	
</body>
</html>