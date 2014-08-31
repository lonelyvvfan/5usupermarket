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
<script language="javascript" src="../js/jquery-1.7.2.min.js"></script>
<script language="javascript" src="../js/takeouttypeajax.js"></script>
<title>外卖管理</title>
</head>
<body>
	<p id="index5"></p>
	<div id="win">
		<div id="left">
			<ul>
				<li id="tianjia"><a href="admin/adminshowTakeout!showsubtype">添加</a></li>
			</ul>
			
		</div>
		<div id="right">
		
			<form action = "admin/adminshowTakeout!findtakeoutspecial" method = "post">
	<input type="text" class="search_box" name="goodsname" placeholder="请输入商品名"/>
	一级分类：<select id='suptype' name = "suptypeid" onchange="changesup()" style="width:100px">
	</select>
	二级分类：<select id='subtype' name = "subtypeid" style="width:100px">
		<option value="1">全部</option>
	</select>
	<input	type="submit" class="search_btn" value="查找" />
	</form> 
		<div id="all">
				<form method="post" action = ""  id="myform" name="myform" >
				<table class="table-hove m_table"  border="0" cellspacing="0" cellpadding="0">
					<thead>
				<tr>
					<td><input class="btn btn-danger all_option"  name= "bt1"  id= "bt1" type="button" value="删除" onclick="takeupjia('1')"  onmousedown="delAll_confirm()" /></td>
					<!-- <td><input class="btn btn-update all_option" type="submit" value="修改" /></td>
					 -->
					 <td><input class="btn btn-info all_option" name= "bt2" id= "bt2" type="button" value="上架" onclick="takeupjia('2')" onmousedown="upAll_confirm()"/></td>
					 <td><input class="btn btn-warning all_option" name= "bt3" id= "bt3" type="button" value="下架" onclick="takeupjia('3')" onmousedown="downAll_confirm()"/></td>
					</tr>
						<tr
							style="background-color: #d9d8d8; font-size: 18px; color: #464646;height:35px;">
							<td><label><input type="checkbox" id="check_all" onclick=selectAll()>全选</label></td>
							<td>序号</td>
							<td>商品名</td>
							<td>商家名</td>
							<td>父类</td>
							<td>子类</td>
							<td>原价</td>
							<td>现价</td>
							<td>图片</td>
							<td>状态</td>
							<td style="width:80px;">操作</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="takeoutpage.list">
							<tr>
							<td><input type="checkbox" name="checkbox" value="${id}"></td>
								<td>${id}</td>
								<td><a href="admin/adminshowTakeout!view?id=${id}">${goodsname}</a></td>
								<td>${sellername}</td>
								<td><script>selecttakeout_supertypes('${suptypeid}')</script></td>
								<td><script>selecttakeout_subtypes('${subtypeid}')</script></td>
								<td>${price}元</td>
								<td>${nowprice}元</td>
								<td><img alt="pic" src="images/takeout/${savepath}"></td>
								<td><script>selectshelves('${shelves}')</script></td>
								<td>
								<form action="admin/adminshowTakeout!view" method="post">
									</form>
								<form action="admin/adminshowTakeout!view" method="post" target="_blank">
										<input type="hidden" value="${id}" name="id" /> 
										<input class="btn btn-view" type="submit" value="查看" />
									</form>
								<form action="admin/adminshowTakeout!altershow" method="post" target="_blank">
										<input type="hidden" value="${id}" name="id" /> <input
											class="btn btn-update" type="submit" value="修改" />
									</form>
								<form action="admin/adminshowTakeout!deletetakeoutbyid"  method="post">
									<input type="hidden" value="${id}" name="id" /> <input
										class="btn btn-danger" type="submit" value="删除" onclick="return confirm('确定删除该外卖商品？')" />
								</form>
									
									
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				</form>
			<tr>	
				<td><a href="admin/adminshowTakeout?takeoutpage.currentPage=1">首页</a></td>
				<s:iterator value="takeoutpage.pageList" id="e">
					<td><a href="admin/adminshowTakeout?takeoutpage.currentPage=${e}">${e}</a></td>
				</s:iterator>
				<td><a href="admin/adminshowTakeout?takeoutpage.currentPage=${takeoutpage.totalPage}">末页</a></td>	
				<td>共有${takeoutpage.totalPage}页，${takeoutpage.allRow}条记录</td>
			</tr>

		<a href="admin/adminshowTakeout">返回</a>
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