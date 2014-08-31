<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="../js/comfirm.js"></script>
<script language="javascript" src="js/check.js"></script>
<title>修改会员信息</title>
</head>
<body>
<div id="good_main_body">
<div id="s_win">
		<div id="s_left"></div>
		<div id="s_right">

			<div id="s_form">
	<form action="user/usermanage!alteruser"  method="post"
		enctype="multipart/form-data">
		<table class="table table-striped table-hover table-bordered " style="position:relative;top:-41px;">
			<tr>
				<td class="for"><img src="image/meg_name.png"/>用户名：</td>
				<td>${username}
				</td>
			</tr>
			<tr>
				<td class="for"><img src="image/meg_pwd.png"/>密码：</td>
				<td><input type="text" onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" onkeydown="if(event.keyCode==13)event.keyCode=9"  id="first_pwd1" name="password" value="${user.password}" placeholder="请输入4-20位用户密码" onblur="checkpwd1()" />
				</td>
			</tr>
			<tr>
				<td class="for"><img src="image/meg_nike.png"/>昵称：</td>
				<td><input type="text" name="nickname" value="${user.nickname}" />
				</td>
			</tr>
			<tr>
				<td class="for"><img src="image/meg_pho.png"/>联系电话：</td>
				<td><input type="text" id="telephone1" name="telephone" value="${user.telephone}"  placeholder="请输入您的手机号码" onblur="checkmobile1()" />
				</td>
			</tr>
			<tr>
						<td class="for"><img src="image/meg_addr.png"/>地址：</td>
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
				<td class="for"><img src="image/meg_addr.png"/>具体地址：</td>
				<td><input type="text" name="address" value="${user.address}" />
				</td>
			</tr>
			<tr>
				<td class="for"><img src="image/meg_email.png"/>电子邮件：</td>
				<td><input type="email" name="email" value="${user.email}" />
				</td>
			</tr>
			
			<tr>
				<td class="for"><img src="image/meg_email.png"/>支付宝帐号：</td>
				<td><input type="text" name="alipaynum" value="${user.alipaynum}" />
				</td>
			</tr>
			<tr>
				<td class="for"><img src="image/meg_email.png"/>QQ：</td>
				<td><input type="text" name="qq" value="${user.qq}" />
				</td>
			</tr>
			<tr>
				<td class="for"><img src="image/meg_email.png"/>人人：</td>
				<td><input type="text" name="renren" value="${user.renren}" />
				</td>
			</tr>
			<tr>
				<td class="for"><img src="image/meg_sex.png"/>性别：</td>
				<td>
				<select id="sex" name="sex">
					<option value="${user.sex}">当前选择：<script>selectsex('${user.sex}')</script></option>
					<option value="0">女</option>
					<option value="1">男</option>
				</select>
				</td>
			</tr>
			<tr>
				<td class="for"><img src="image/meg_lock.png"/>权限：</td>
				<td><script>selectauthor('${user.author}')</script>
				</td>
			</tr>
			<tr>
				<td class="for"><img src="image/meg_email.png"/>微博：</td>
				<td><input type="text" name="weibo" value="${user.weibo}" />
				</td>
			</tr>
		</table>
		<input type="hidden" name="id" value="${user.id}"/>
		<input type="hidden" name="author" value="${user.author}" />
		<input type="hidden" name="username" value="${user.username}" />
		<button class="btn s_btn-update" style="display:block;margin:auto"  type="submit" onclick="return confirm('确定修改信息吗?')" >确定</button>
	</form>
	</div>
</div>
</div>
</body>
</html>