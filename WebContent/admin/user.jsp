<%@page import="cs.vo.UserPage"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script language="javascript" src="../js/comfirm.js"></script>
<title>用户管理</title>
</head>
<body>
<p id="index7"></p>
<div id="win">
		<div id="left">
			<ul>
				<li id="tianjia"><a href="admin/adduser.jsp">添加</a></li>
			</ul>
			
		</div>
		<div id="right">

		<form action="admin/adminshowUser!finduserspecial" method="post">
			<input type="text" class="search_box" name="username" placeholder="请输入用户名" /> <input
				type="submit" class="search_btn" value="查找" />
		</form>

		<div id="all">
				<form method="post" action = "admin/adminshowUser!deletecheckbox">
				<table class="m_table"  border="0" cellspacing="0" cellpadding="0"
					class="table table-hover">
					<thead>
					<tr>
					<td><input class="btn btn-danger all_option" id="bt1" type="submit" value="删除"  onmousedown="delAll_confirm()"   /></td>
<!-- 					<td><input class="btn btn-update all_option" type="submit" value="修改" /></td> -->
					</tr>
						<tr
							style="background-color: #d9d8d8; font-size: 18px; color: #464646;height:35px;">
							<td><label><input type="checkbox" id="check_all" onclick=selectAll()>全选</label>
							<td>序号</td>
							<td>用户名</td>
							<td>联系电话</td>
							<td>地址</td>
							<td>权限</td>
							<td style="width:80px;">操作</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="userpage.list">
							<tr>
								<td><input type="checkbox" name="checkbox" value="${id}"></td>
								<td>${id}</td>
								<td>${username}</td>
								<td>${telephone}</td>
								<td>${address}</td>
								<td><script>selectauthor('${author}')</script></td>
								<td>
								<form action="admin/adminshowUser!deleteuserbyid" method="post">
										</form>
										
										<form action="admin/adminshowUser!altershow" method="post" target="_blank">
											<input type="hidden"
												value="${id}" name="id" />
											<input
												class="btn btn-update"  type="submit" value="修改" />
										</form>
										<form action="admin/adminshowUser!deleteuserbyid" method="post">
											<input type="hidden"
												value="${id}" name="id" />
											<input
												class="btn btn-danger" type="submit" value="删除"
												onclick="return confirm('确定删除该用户？')" />
										</form>
								</td>
							</tr>
						</s:iterator>	
					</tbody>
				</table>
			</form>
					<tr>	
						<td><a href="admin/adminshowUser?userpage.currentPage=1">首页</a></td>
						<s:iterator value="userpage.pageList" id="e">
							<td><a href="admin/adminshowUser?userpage.currentPage=${e}">${e}</a></td>
						</s:iterator>
						<td><a href="admin/adminshowUser?userpage.currentPage=${userpage.totalPage}">末页</a></td>	
						<td>共有${userpage.totalPage}页，${userpage.allRow}条记录</td>
					</tr>
		<a href="admin/adminshowUser">返回</a>
	</div>
</div>
</div>
<script type="text/javascript">
    $(function () {
        var ie6 = document.all;
        var dv = $("#tianjia"), st;
        var is360=false;
        if(window.navigator.userAgent.indexOf('Chrome')!=-1){
			if(window.navigator.webkitPersistentStorage){
				isCrome = true;
			}else{
				is360 = true;
			}
		}
        dv.attr('tianjia', dv.offset().top); //存储原来的距离顶部的距离
        $(window).scroll(function () {
            st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
            if (st > parseInt(dv.attr('tianjia'))) {
                if (is360) {//IE6不支持fixed属性，所以只能靠设置position为absolute和top实现此效果
                    dv.css({ position: 'absolute', top: st,'width':'100%' });
                }
                else if (dv.css('position') != 'fixed') dv.css({ 'position': 'fixed', top: -7,'width':'100px','right':'20px','height':'43px' });
            } else if (dv.css('position') != 'static') dv.css({ 'position': 'static','width':'1178px' });
        });
    });
</script>
</body>
</html>