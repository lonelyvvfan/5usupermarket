<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script charset="utf-8" src="../kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh_CN.js"></script>
<script language="javascript" src="../js/comfirm.js"></script>
<link rel="stylesheet" href="../style/bootstrap.css" type="text/css">
<title>查看外卖信息</title>
</head>
<body>
	<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
				
					<table class="table table-bordered">
						<tr>
							<td>卖家名：</td>
							<td>
								${takeout.sellername}
							</td>
						</tr>
						<tr>
							<td>类型：</td>
							<td><script>selecttakeout_supertypes('${takeout.suptypeid}')</script>><script>selecttakeout_subtypes('${takeout.subtypeid}')</script></td>
						</tr>
						<tr>
							<td>商品名：</td>
							<td>${takeout.goodsname}</td>
						</tr>
						<tr>
							<td>推荐理由：</td>
							<td>${takeout.reason}</td>
						</tr>
						
						<tr>
							<td>原价：</td>
							<td>${takeout.price}</td>
						</tr>
						<tr>
							<td>现价：</td>
							<td>${takeout.nowprice}</td>
						</tr>
						<tr>
							<td>当前主图片：</td>
							<td><img alt="pic" class="good_img" src="images/takeout/${takeout.savepath}">
							</td>
						</tr>
						<tr>
							<td>当前其他图片1：</td>
							<td><img alt="pic" class="good_img" src="images/takeout/${takeout.savepath1}">
							</td>
						</tr>
						<tr>
							<td>当前其他图片2：</td>
							<td><img alt="pic" class="good_img" src="images/takeout/${takeout.savepath2}">
							</td>
						</tr>
						<tr>
							<td>当前其他图片3：</td>
							<td><img alt="pic" class="good_img" src="images/takeout/${takeout.savepath3}">
							</td>
						</tr>
						<tr>
							<td>商品介绍：</td>
							<td>
							${takeout.introduce}
							</td>
						</tr>
						<tr>
						<td>是否上架：</td>
						<td><script>selectshelves('${takeout.shelves}')</script></td>
					</tr>
					</table>
			</div>
		</div>
	</div>
<script type="text/javascript">
        KindEditor.ready(function(K) {
                window.editor = K.create('#s_editor_1');
        });
</script>

</body>
</html>