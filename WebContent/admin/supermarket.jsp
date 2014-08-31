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
<script language="javascript" src="../js/typeajax.js"></script>
<title>超市管理</title>
</head>
<body>
	<p id="index2"></p>
	<div id="win">
		<div id="left">
			<ul>
				<li id="tianjia"><a href="admin/adminshowGoods!showsubtype">添加</a></li>
			</ul>
			
		</div>
		<div id="right">
		
			<form action ="admin/adminshowGoods!findgoodsspecial1" method = "post">
	<input type="text" class="search_box" name="goodsname" placeholder="请输入商品名"/>	
	一级分类：<select id='suptype' name = "suptypeid" onchange="changesup()" style="width:100px">
	</select>
	二级分类：<select id='subtype' name = "subtypeid" style="width:100px">
		<option value="1">全部</option>
	</select>
	上下架状态：<select name="shelves" value="">
		<option value="2">全部</option>
		<option value="1">已上架</option>
		<option value="0">已下架</option>
	</select>
	<input	type="submit" class="search_btn" value="查找" />
	</form>
		<div id="all">
				<form method="post" action = ""  id="myform" name="myform" >
				<table class="m_table"  border="0" cellspacing="0" cellpadding="0"
					class="table table-hover">
					<thead>
					<tr>
					<td><input class="btn btn-danger all_option"  name= "bt1"  id= "bt1" type="button" value="删除" onclick="upjia('1')"  onmousedown="delAll_confirm()"  /></td>
					<!-- <td><input class="btn btn-update all_option" type="submit" value="修改" /></td>
					 -->
					 <td><input class="btn btn-info all_option" name= "bt2" id= "bt2" type="button" value="上架" onclick="upjia('2')" onmousedown="upAll_confirm()" /></td>
					 <td><input class="btn btn-warning all_option" name= "bt3" id= "bt3" type="button" value="下架" onclick="upjia('3')" onmousedown="downAll_confirm()" /></td>
					 <td><input class="btn btn-warning all_option" name= "bt4" id= "bt4" type="button" value="仓库" onclick="upjia('4')"/></td>
					</tr>
						<tr
							style="background-color: #d9d8d8; font-size: 18px; color: #464646;height:35px;">
							<td><label><input type="checkbox" id="check_all" onclick=selectAll()>全选</label>
							</td>
							<td>序号</td>
							<td>商品名</td>
							<td>类别</td>
							<td>库存</td>
							<td>原价</td>
							<td>现价</td>
							<td>图片</td>
							<td>新品</td>
							<td>热销</td>
							<td>特价</td>
							<td>健康</td>
							<td>推荐</td>
							<td>状态</td>
							<td>优先数</td>
							<td style="width:80px;">操作</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="goodspage.list">
							<tr>
							<td><input type="checkbox" name="checkbox" value="${id}"></td>
								<td>${id}</td>
								<td><a href="admin/adminshowGoods!view?id=${id}">${goodsname}</a></td>
								<td><script>selectgoods_supertypes('${suptypeid}')</script><br><script>selectgoods_subtypes('${subtypeid}')</script></td>
								<td>${inventory}</td>
								<td>${price}元</td>
								<td>${nowprice}元</td>
								<td><img alt="pic" src="images/goods/${savepath}"></td>
								<td><script>selectnewgoods('${newgoods}')</script></td>
								<td><script>selecthot('${hot}')</script></td>
								<td><script>selectspecial('${special}')</script></td>
								<td><script>selecthealth('${health}')</script></td>
								<td><script>selectrecommend('${recommend}')</script></td>
								<td><script>selectshelves('${shelves}')</script></td>
								<td>${indexx}</td>
								<td>
								
								<form action="admin/adminshowGoods!view" method="post">
									</form>
								<form action="admin/adminshowGoods!view" method="post" target="_blank">
										<input type="hidden" value="${id}" name="id" /> <input
											class="btn btn-view" type="submit" value="查看" />
									</form>
								<form action="admin/adminshowGoods!altershow" method="post" target="_blank">
										<input type="hidden" value="${id}" name="id" /> <input
											class="btn btn-update" type="submit" value="修改" />
									</form>
								<form id="goods_form" action="admin/adminshowGoods!deletegoodsbyid"  method="post">
									<input type="hidden" value="${id}" name="id" /> <input
										class="btn btn-danger" type="submit" value="删除" onclick="return confirm('确定删除该商品')" />
								</form>
									
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				</form>
			<tr>	
				<td><a href="admin/adminshowGoods?goodspage.currentPage=1">首页</a></td>
				<s:iterator value="goodspage.pageList" id="e">
					<td><a href="admin/adminshowGoods?goodspage.currentPage=${e}">${e}</a></td>
				</s:iterator>
				<td><a href="admin/adminshowGoods?goodspage.currentPage=${goodspage.totalPage}">末页</a></td>	
				<td>共有${goodspage.totalPage}页，${goodspage.allRow}条记录</td>
			</tr>

		<a href="admin/adminshowGoods">返回</a>
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