<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看套餐信息</title>
</head>
<body>
<p id="index3"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
					<table class="table">
						<tr>
							<td>商品名：</td>
							<td>
								${combo.goodsname}
							</td>
						</tr>
						<tr>
							<td>库存：</td>
							<td>
								${combo.inventory}
							</td>
						</tr>
						<tr>
							<td>推荐理由：</td>
							<td>
								${combo.reason}
							</td>
						</tr>
						<tr>
							<td>原价：</td>
							<td>${combo.price}元
							</td>
						</tr>
						<tr>
							<td>现价：</td>
							<td>${combo.nowprice}元
							</td>
						</tr>
						<tr>
							<td>点赞数：</td>
							<td>${combo.zan}个
							</td>
						</tr>
						<tr>
							<td>月销量：</td>
							<td>${combo.monthsell}
							</td>
						</tr>
					<tr>
						<td>当前主图片：</td>
						<td><img alt="pic" class="good_img"  src="images/goods${combo.savepath}">
						</td>
					</tr>
					<tr>
						<td>当前其他图片1：</td>
						<td><img alt="pic1" class="good_img"  src="images/goods${combo.savepath1}">
						</td>
					</tr>
					<tr>
						<td>当前其他图片2：</td>
						<td><img alt="pic2" class="good_img"  src="images/goods${combo.savepath2}">
						</td>
					</tr>
					<tr>
						<td>当前其他图片3：</td>
						<td><img alt="pic3" class="good_img"  src="images/goods${combo.savepath3}">
						</td>
					</tr>
					<tr>
							<td>商品介绍：</td>
							<td>${combo.introduce}
							</td>
						</tr>
					<tr>
						<td>是否上架：</td>
						<td><script>selectshelves('${combo.shelves}')</script></td>
					</tr>
					
		</table>
	
	</div>
</div>
</div>
</body>
</html>