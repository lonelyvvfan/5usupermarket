<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="../js/comfirm.js"></script>
<title>修改普通用户信息</title>
</head>
<body>
<p id="index7"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
	<form action="admin/adminshowUser!alteruser"  method="post"
		enctype="multipart/form-data">
		<table>
						<tr>
				<td>用户名：</td>
				<td><p>${user.username}</p>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" onkeydown="if(event.keyCode==13)event.keyCode=9" name="password" value="${user.password}" required/>
				</td>
			</tr>
			<tr>
				<td>昵称：</td>
				<td><p>${user.nickname}</p>
				</td>
			</tr>
			<tr>
				<td>联系电话：</td>
				<td><p>${user.telephone}</p>
				</td>
			</tr>
			<tr>
						<td>地址：</td>
						<td>
						<div class="input-prepend">
							<span class="add-on">学校</span> 
							<select class="address" style="width:195px" name="school" id="sch" onchange="changeSch()" required>
							<option value="${user.school}">当前选择的是：<script>selectschool('${user.school}')</script></option>
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
							<select class="address" style="width:150px" name="living" id="buil" required>
								<option value="${user.living}">当前选择的是：<script>selectliving('${user.living}')</script></option>
							</select>
						</div>
						</td>
						</tr>
			<tr>
				<td>具体地址：</td>
				<td><p>${user.address}</p>
				</td>
			</tr>
			<tr>
				<td>电子邮件：</td>
				<td><p>${user.email}</p>
				</td>
			</tr>
			<tr>
				<td>支付宝帐号：</td>
				<td><p>${user.alipaynum}</p>
				</td>
			</tr>
			<tr>
				<td>QQ：</td>
				<td><p>${user.qq}</p>
				</td>
			</tr>
			<tr>
				<td>人人：</td>
				<td><p>${user.renren}</p>
				</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><p><script>selectsex('${user.sex}')</script></p>
				</td>
			</tr>
			<tr>
				<td>权限：</td>
				<td><script>selectauthor('${user.author}')</script>
				</td>
			</tr>
			<tr>
				<td>微博：</td>
				<td><p>${user.weibo}</p>
				</td>
			</tr>
		</table>
		<input type="hidden" name="nickname" value="${user.nickname}" />
		<input type="hidden" name="telephone" value="${user.telephone}" />
		<input type="hidden" name="address" value="${user.address}" />
		<input type="hidden" name="email" value="${user.email}" />
		<input type="hidden" name="alipaynum" value="${user.alipaynum}" />
		<input type="hidden" name="qq" value="${user.qq}" />
		<input type="hidden" name="renren" value="${user.renren}" />
		<input type="hidden" name="sex" value="${user.sex}" />
		<input type="hidden" name="author" value="${user.author}" />
		<input type="hidden" name="weibo" value="${user.weibo}" />
		<input type="hidden" name="username" value="${user.username}" />
		<button class="btn" type="submit" onclick="return confirm('确定修改该用户信息？')" >修改</button>
		<input type="hidden" name="id" value="${user.id}"/>
	</form>
</div>
</div>
</div>
</body>
</html>