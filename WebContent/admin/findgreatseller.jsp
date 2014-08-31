<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="../js/comfirm.js"></script>
<script language="javascript" src="../js/jquery-1.7.2.min.js"></script>
<script language="javascript" src="../js/greattypeajax.js"></script>
<title>外卖商家管理</title>
</head>
<body>
	<p id="index6"></p>
	<div id="win">
		<div id="left">
			<ul>
				<li id="tianjia"><a href="admin/adminshowGreatseller!showgreatsellersubtype">添加</a></li>
			</ul>
			
		</div>
		<div id="right">
		
		<form action ="admin/adminshowGreatseller!findgreatsellerspecial" method = "post">
		<input type="text" class="search_box" name="name" value="${name}" placeholder="请输入店名"/>
	<select class="span2" style="width:160px" name="suptypeid" id="greatseller" onchange="changeGreatseller()" required>
							<option value="${suptypeid}">当前：<script>selectgreatseller_supertypes('${suptypeid}')</script></option>
							<option value="1">全部</option>
							<option value="2">女装/内衣</option>
							<option value="3">运动休闲</option>
							<option value="4">男装/内衣</option>
							<option value="5">手机数码</option>
							<option value="6">电脑办公</option>
							<option value="7">食品</option>
							<option value="8">图书影像</option>
							<option value="9">医药保健</option>
						</select>
							<select class="span2" style="width:150px" name="subtypeid" id="subgreatseller" required>
								<option value="${subtypeid}">当前：<script>selectgreatseller_subtypes('${subtypeid}')</script></option>
								
							</select>
	<input	type="submit" class="search_btn" value="查找" />
	</form>
		<div id="all">
		<form method="post" action = ""  id="myform" name="myform" >
				<table class="m_table"  border="0" cellspacing="0" cellpadding="0"
					class="table table-hover">
					<thead>
					<tr>
					<td><input class="btn btn-danger all_option"  name= "bt1"  id= "bt1" type="button" value="删除" onclick="greatsellerupjia('1')"  onmousedown="delAll_confirm()"  /></td>
					<!-- <td><input class="btn btn-update all_option" type="submit" value="修改" /></td>
					 -->
					 <td><input class="btn btn-info all_option" name= "bt2" id= "bt2" type="button" value="上架" onclick="greatsellerupjia('2')" onmousedown="upAll_confirm()" /></td>
					 <td><input class="btn btn-warning all_option" name= "bt3" id= "bt3" type="button" value="下架" onclick="greatsellerupjia('3')" onmousedown="downAll_confirm()" /></td>
					</tr>
						<tr
							style="background-color: #d9d8d8; font-size: 14px; color: #464646;">
							<td><label><input type="checkbox" id="check_all" onclick=selectAll()>全选</label>
							<td>序号</td>
							<td>店名</td>
							<td>父类</td>
							<td>子类</td>
							<td>照片</td>
							<td>链接</td>
							<td>状态</td>
							<td style="width:80px;">操作</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="greatsellerpage.list">
							<tr>
								<td><input type="checkbox" name="checkbox" value="${id}"></td>
								<td>${id}</td>
								<td><a href="admin/adminshowGreatseller!view?id=${id}">${name}</a></td>
								<td><script>selectgreatseller_supertypes('${suptypeid}')</script></td>
								<td><script>selectgreatseller_subtypes('${subtypeid}')</script></td>
								<td><img alt="pic" src="images/greatseller/${savepath}"></td>
								<td><a href="http://${url}" target="_blank" >${url}</a></td>
								<td><script>selectshelves('${shelves}')</script></td>
								<td>
								<form action="admin/adminshowCombo!view" method="post">
									</form>
								<form action="admin/adminshowGreatseller!view" method="post" target="_blank">
										<input type="hidden" value="${id}" name="id" /> <input
											class="btn btn-view" type="submit" value="查看" />
									</form>
								<form action="admin/adminshowGreatseller!altershow" method="post" target="_blank">
										<input type="hidden" value="${id}" name="id" /> <input
											class="btn btn-update" type="submit" value="修改" />
									</form>
								<form action="admin/adminshowGreatseller!deletegreatsellerbyid" method="post">
									<input type="hidden" value="${id}" name="id" /> <input
										class="btn btn-danger" type="submit" value="删除" onclick="return confirm('确定删除该推荐商家?')" />
								</form>
									
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				</form>
			<tr>	
				<td><a href="admin/adminshowGreatseller!findgreatsellerspecial?greatsellerpage.currentPage=1&&name=${name}&&suptypeid=${suptypeid}&&subtypeid=${subtypeid}">首页</a></td>
				<s:iterator value="goodspage.pageList" id="e">
					<td><a href="admin/adminshowGreatseller!findgreatsellerspecial?greatsellerpage.currentPage=${e}&&name=${name}&&suptypeid=${suptypeid}&&subtypeid=${subtypeid}">${e}</a></td>
				</s:iterator>
				<td><a href="admin/adminshowGreatseller!findgreatsellerspecial?greatsellerpage.currentPage=${greatsellerpage.totalPage}&&name=${name}&&suptypeid=${suptypeid}&&subtypeid=${subtypeid}">末页</a></td>	
				<td>共有${greatsellerpage.totalPage}页，${greatsellerpage.allRow}条记录</td>
				</tr>
		<a href="admin/adminshowGreatseller">返回</a>
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