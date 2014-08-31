<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看推荐商家信息</title>
</head>
<body>
<p id="index6"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
					<table class="table">
						<tr>
							<td>类型：</td>
							<td><script>selectgreatseller_supertypes('${greatseller.suptypeid}')</script>><script>selectgreatseller_subtypes('${greatseller.subtypeid}')</script></td>
						</tr>
						<tr>
							<td>推广商家名：</td>
							<td>
								${greatseller.name}
							</td>
						</tr>
						<tr>
							<td>商家链接：</td>
							<td><a href="http://${greatseller.url}">${greatseller.url}</a>
							</td>
						</tr>
					<tr>
						<td>当前主图片：</td>
						<td><img alt="pic" class="good_img"  src="images/greatseller/${greatseller.savepath}">
						</td>
					</tr>
					<tr>
						<td>是否上架：</td>
						<td><script>selectshelves('${greatseller.shelves}')</script></td>
					</tr>
		</table>
	
	</div>
</div>
</div>
</body>
</html>