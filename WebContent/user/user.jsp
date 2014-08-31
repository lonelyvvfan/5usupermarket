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
    <script language="javascript" src="js/left_label.js"></script>
<title>会员信息</title>
</head>
<body>

<div id="left">
            <img src="image/weixin1.png"/>
        </div>
<div id="good_main_body">
<div id="s_win">
		<div id="s_right">

		<div id="s_all">
				<table class="table table-striped table-hover table-bordered s_m_table "  border="0" cellspacing="0" cellpadding="0"
					class="s_table s_table-hover">
					<thead>
						<tr
							style="background-color: #d9d8d8; font-size: 20px; color: #464646;">
							<td colspan="2"><img src="image/meg.png"/>用户信息</td>
						</tr>
					</thead>
					<tbody>
							<tr><td><img src="image/meg_name.png"/>用户名</td>
								<td>${user.username}</td></tr>
								<tr><td><img src="image/meg_nike.png"/>昵称</td>
								<td>${user.nickname}</td></tr>
								<tr><td><img src="image/meg_pho.png"/>联系电话</td>
								<td>${user.telephone}</td></tr>
								<tr><td><img src="image/meg_addr.png"/>地址</td>
								<td><script>selectschool('${user.school}')</script>&nbsp;<script>selectliving('${user.living}')</script>&nbsp;<br/>${user.address}</td></tr>
								<tr><td><img src="image/meg_email.png"/>电子邮件</td>
								<td>${user.email}</td></tr>
								<tr><td><img src="image/meg_lock.png"/>权限</td>
								<td><script>selectauthor('${user.author}')</script></td></tr>
								<tr><td><img src="image/meg_sex.png"/>性别</td>
								<td><script>selectsex('${user.sex}')</script></td></tr>
								<tr>
								<td colspan="2">
									<form action="user/usermanage!altershow" method="post">
										<input type="hidden" value="${user.id}" name="id" /> <input
											class="btn s_btn-update" type="submit" value="修改个人信息" />
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