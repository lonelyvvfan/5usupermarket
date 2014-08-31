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
<script language="javascript" src="../js/comfirm.js"></script>
<title>我的二手商品</title>
</head>
<body>
	<div id="good_main_body">
	<div id="s_win">
		<div id="s_left">
			<ul>
				<li><a href="user/secgoodsmanage!showsecsubtype"><font style="color:white;">发布二手商品</font></a></li>
			</ul>
		</div>
		<p style="clear:both"></p>
		<div id="s_right">
		
		<div id="s_all">
				<form method="post" action = ""  id="myform" name="myform" >
				<table style="top:0px" class="table table-striped table-hover table-bordered s_m_table"  border="0" cellspacing="0" cellpadding="0"
					class="s_table s_table-hover">
					<thead>
					<input class="btn btn-danger all_option" id="del_all" type="submit" value="删除" onclick="usersecupjia('1')" onmousedown="user_allOption_comfirm()"    />
					<!-- <input class="btn s_btn-update all_option" type="submit" value="修改"  />
					<input class="btn s_btn-view all_option" type="submit" value="查看" />
					 -->
					 <input class="btn btn-info all_option" id="up_all" type="submit" value="上架"  onclick="usersecupjia('2')" onmousedown="user_allUp_comfirm()" />
					<input class="btn btn-warning all_option" id="down_all" type="submit" value="下架"  onclick="usersecupjia('3')" onmousedown="user_allDown_comfirm()" />
					<p style="clear:both"></p>
						<tr
							style="background-color: #d9d8d8; font-size: 14px; color: #464646;">
							<td><label><input type="checkbox" id="check_all" onclick=selectAll()>全选</label>
							<td>序号</td>
							<td>商品名</td>
							<td>发布用户名</td>
							<td>父类</td>
							<td>子类</td>
							<td>价格</td>
							<td>图片</td>
							<td>状态</td>
							<td style="width:80px;">操作</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="secgoodspage.list">
							<tr>
							    <td><input type="checkbox" name="checkbox" value="${id}"></td>
								<td>${id}</td>
								<td><a href="user/secgoodsmanage!view?id=${id}">${goodsname}</a></td>
								<td>${username}</td>
								<td><script>selectsecgoods_supertypes('${suptypeid}')</script></td>
								<td><script>selectsecgoods_subtypes('${subtypeid}')</script></td>
								<td>${price}元</td>
								<td><img alt="pic" class="good_img_small" src="images/secondgoods/${savepath}" onerror="javascript:this.src='image/error.jpg'"></td>
								<td><script>selectshelves('${shelves}')</script></td>
								<td>
								<form action="user/secgoodsmanage!view" method="post" target="_blank">
									</form>
								<form action="user/secgoodsmanage!view" method="post" target="_blank">
										<input type="hidden" value="${id}" name="id" /> <input
											class="s_btn s_btn-view" type="submit" value="查看" />
									</form>
								<form action="user/secgoodsmanage!altershow" method="post">
										<input type="hidden" value="${id}" name="id" /> <input
											class="s_btn s_btn-update" type="submit" value="修改" />
									</form>
								<form action="user/secgoodsmanage!deletesecgoodsbyid"  method="post">
									<input type="hidden" value="${id}" name="id" /> <input
										class="s_btn s_btn-danger" type="submit" value="删除" onclick="return confirm('确定删除该二手商品吗?')"  />
								</form>
									
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				</form>
			<tr>	
				<td><a href="user/secgoodsmanage?secgoodspage.currentPage=1">首页</a></td>
				<s:iterator value="secgoodspage.pageList" id="e">
					<td><a href="user/secgoodsmanage?secgoodspage.currentPage=${e}">${e}</a></td>
				</s:iterator>
				<td><a href="user/secgoodsmanage?secgoodspage.currentPage=${secgoodspage.totalPage}">末页</a></td>	
				<td>共有${secgoodspage.totalPage}页，${secgoodspage.allRow}条记录</td>
			</tr>

		<a href="user/adminshowsecGoods">返回</a>
	</div>
	</div>
</div>
</body>
</html>