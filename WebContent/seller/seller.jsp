<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>外卖商家信息</title>
</head>
<body>
<div id="win">
		<div id="left">
		</div>
		<div id="right">

		<div id="all">
				<table  class="m_table"  border="0" cellspacing="0" cellpadding="0"
					class="table table-hover">
					<thead>
						<tr
							style="background-color: #d9d8d8; font-size: 18px;height:35px; color: #464646;">
							<td>用户名</td>
							<td>店名</td>
							<td>联系电话</td>
							<td>地址</td>
							<td>权限</td>
							<td>图片</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>${seller.username}</td>
								<td>${seller.name}</td>
								<td>${seller.telephone}</td>
								<td>${seller.address}</td>
								<td><script>selectauthor('${seller.author}')</script></td>
								<td><img alt="s_pic" style="width:100px;height:100px" src="images/seller${seller.savepath}"></td>
								<td>
									<form action="seller/sellershowSeller!altershow" method="post">
										<input type="hidden" value="${seller.id}" name="id" /> <input
											class="btn btn-update" type="submit" value="修改个人信息" />
									</form>
								</td>
							</tr>
					</tbody>
				</table>
		</div>
	</div>
</div>

</body>
</html>