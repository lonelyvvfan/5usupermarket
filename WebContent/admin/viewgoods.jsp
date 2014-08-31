<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看商品信息</title>
</head>
<body>
<p id="index2"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
					<table class="table">
						<tr>
							<td>类别：</td>
								<td><script>selectgoods_supertypes('${goods.suptypeid}')</script>><script>selectgoods_subtypes('${goods.subtypeid}')</script></td>
								
						</tr>
						<tr>
							<td>商品名：</td>
							<td>
								${goods.goodsname}
							</td>
						</tr>
						<tr>
							<td>优先级别：（越小级别越高）</td>
							<td>
								${goods.indexx}
							</td>
						</tr>
						<tr>
							<td>库存：</td>
							<td>
								${goods.inventory}
							</td>
						</tr>
						<tr>
							<td>推荐理由：</td>
							<td>
								${goods.reason}
							</td>
						</tr>
						<tr>
							<td>单价：</td>
							<td>${goods.price}元
							</td>
						</tr>
						<tr>
							<td>新价：</td>
							<td>${goods.nowprice}元
							</td>
						</tr>
						<tr>
							<td>点赞数：</td>
							<td>${goods.zan}个
							</td>
						</tr>
						<tr>
							<td>月销量：</td>
							<td>${goods.monthsell}
							</td>
						</tr>
					<tr>
						<td>当前主图片：</td>
						<td><img alt="pic" class="good_img" src="images/goods/${goods.savepath}">
						</td>
					</tr>
					<tr>
						<td>当前其他图片1：</td>
						<td><img alt="pic1" class="good_img"  src="images/goods/${goods.savepath1}">
						</td>
					</tr>
					<tr>
						<td>当前其他图片2：</td>
						<td><img alt="pic2" class="good_img"  src="images/goods/${goods.savepath2}">
						</td>
					</tr>
					<tr>
						<td>当前其他图片3：</td>
						<td><img alt="pic3" class="good_img"  src="images/goods/${goods.savepath3}">
						</td>
					</tr>
					
					<tr>
						<td>是否为新品：</td>
						<td>
						<script>selectnewgoods('${goods.newgoods}')</script>
						</td>
					</tr>
					<tr>
						<td>是否为热销商品：</td>
						<td><script>selecthot('${goods.hot}')</script></td>
					</tr>
					<tr>
						<td>是否为特价商品：</td>
						<td><script>selectspecial('${goods.special}')</script></td>
					</tr>
					<tr>
						<td>是否为健康商品：</td>
						<td><script>selecthealth('${goods.health}')</script></td>
					</tr>
					<tr>
						<td>是否为推荐商品：</td>
						<td><script>selectrecommend('${goods.recommend}')</script></td>
					</tr>
					<tr>
						<td>是否上架：</td>
						<td><script>selectshelves('${goods.shelves}')</script></td>
					</tr>
					<tr>
							<td>商品介绍：</td>
							<td>${goods.introduce}
							</td>
					</tr>
					
		
		</table>
</div>
</div>

</body>
</html>