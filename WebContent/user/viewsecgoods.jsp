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
<div id="good_main_body">
	<div id="s_win">
		<div id="s_left"></div>
		<div id="s_right">

			<div id="s_form">
					<table class="table table-striped table-hover table-bordered s_table" style="position:relative;top:-41px;">
						<tr>
							<td class="for"><img src="image/meg_sex.png"/>类别：</td>
							<td><script>selectsecgoods_supertypes('${secondgoods.suptypeid}')</script>><script>selectsecgoods_subtypes('${secondgoods.subtypeid}')</script></td>
						</tr>
						<tr>
							<td class="for"><img src="image/meg.png"/>发布者真实姓名：</td>
							<td>${secondgoods.nickname}</td>
						</tr>
						<tr>
							<td class="for"><img src="image/sec_new.png"/>商品名：</td>
							<td>${secondgoods.goodsname}</td>
						</tr>
						<tr>
							<td class="for"><img src="image/sec_new.png"/>新旧程度：</td>
							<td><script>selectrecency('${secondgoods.recency}')</script></td>
						</tr>
						<tr>
							<td class="for"><img src="image/sec_price.png"/>单价：</td>
							<td>${secondgoods.price}元</td>
						</tr>
						<tr>
							<td class="for"><img src="image/meg_email.png"/>QQ：</td>
							<td>${secondgoods.qq}</td>
						</tr>
						<tr>
							<td class="for"><img src="image/meg_pho.png"/>手机：</td>
							<td>${secondgoods.telephone}</td>
						</tr>
						<tr>
							<td class="for"><img src="image/meg_email.png"/>地址：</td>
							<td><script>selectschool('${secondgoods.school}')</script>&nbsp;<script>selectliving('${secondgoods.living}')</script></td>
						</tr>
						<tr>
							<td class="for"><img src="image/sec_img.png"/>当前主图片：</td>
							<td><img alt="pic" class="good_img" src="images/secondgoods/${secondgoods.savepath}" onerror="javascript:this.src='image/error.jpg'">
							</td>
						</tr>
						<tr>
							<td class="for"><img src="image/sec_img.png"/>当前其他图片1：</td>
							<td><img alt="pic" class="good_img" src="images/secondgoods/${secondgoods.savepath1}" onerror="javascript:this.src='image/error.jpg'">
							</td>
						</tr>
						<tr>
							<td class="for"><img src="image/sec_img.png"/>当前其他图片2：</td>
							<td><img alt="pic" class="good_img" src="images/secondgoods/${secondgoods.savepath2}" onerror="javascript:this.src='image/error.jpg'">
							</td>
						</tr>
						<tr>
							<td class="for"><img src="image/sec_img.png"/>当前其他图片3：</td>
							<td><img alt="pic" class="good_img" src="images/secondgoods/${secondgoods.savepath3}" onerror="javascript:this.src='image/error.jpg'">
							</td>
						</tr>
						<tr>
							<td class="for"><img src="image/sec_write.png"/>商品介绍：</td>
							<td>${secondgoods.introduce}</td>
						</tr>
						<tr>
						<td class="for"><img src="image/sec_write.png"/>是否上架：</td>
						<td><script>selectshelves('${secondgoods.shelves}')</script></td>
					</tr>
					</table>
			</div>
		</div>
	</div>
	
</body>
</html>