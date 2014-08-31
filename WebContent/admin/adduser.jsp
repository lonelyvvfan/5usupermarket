<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="../js/comfirm.js"></script>
<title>新增普通用户信息</title>
</head>
<body>
<p id="index7"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
	<form action="admin/adminshowUser!adduser"  method="post"
		enctype="multipart/form-data">
		<table>
						<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" value="${user.username}" required/ >
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" onkeydown="if(event.keyCode==13)event.keyCode=9"  name="password" value="${user.password}" required/>
				</td>
			</tr>
			<tr>
				<td>昵称：</td>
				<td><input type="text" name="nickname" value="${user.nickname}" required/>
				</td>
			</tr>
			<tr>
				<td>联系电话：</td>
				<td><input type="text" name="telephone" value="${user.telephone}" required/>
				</td>
			</tr>
			<tr>
						<td>所在地：</td>
						<td>
						<div class="input-prepend">
							<span class="add-on">学校</span> 
							<select class="address" style="width:195px" name="school" id="sch" onchange="changeSch()" required>
							<option></option>
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
							</select>
						</div>
						</td>
			<tr>
				<td>详细地址：</td>
				<td><input type="text" name="address" value="${user.address}" />
				</td>
			</tr>
			<tr>
				<td>电子邮件：</td>
				<td><input type="text" name="email" value="${user.email}" />
				</td>
			</tr>
			<tr>
				<td>支付宝帐号：</td>
				<td><input type="text" name="alipaynum" value="${user.alipaynum}" />
				</td>
			</tr>
			<tr>
				<td>QQ：</td>
				<td><input type="text" name="qq" value="${user.qq}" />
				</td>
			</tr>
			<tr>
				<td>人人：</td>
				<td><input type="text" name="renren" value="${user.renren}" />
				</td>
			</tr>
			<tr>
						<td>性别：</td>
						<td><select id="sex"  name="sex"  >
									<option value="0">女</option>
									<option value="1">男</option>
							</select></td>
					</tr>
			<tr>
				<td>权限：</td>
				<td>普通用户
				</td>
			</tr>
			<tr>
				<td>微博：</td>
				<td><input type="text" name="weibo" value="${user.weibo}" />
				</td>
			</tr>
		</table>
		<input type="hidden" name="author" value="2" />
		<button class="btn" type="submit" onclick="return confirm('确定添加该用户？')" >保存</button>
	</form>
</div>
</div>
</div>
</body>
</html>