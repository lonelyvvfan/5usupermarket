<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>关键字管理</title>
</head>
<body>
<p id="index10"></p>
<div id="win">
		<div id="left">
			<ul>
				<li id="tianjia"><a href="admin/addkeyword.jsp">添加</a></li>
			</ul>
			
		</div>
		<div id="right">

		<form action="admin/adminshowKeyword!findkeywordspecial" method="post">
			<input type="text" class="search_box" name="title" value="${title}" placeholder="请输入关键字"/> <input
				type="submit" class="search_btn" value="查找" />
		</form>

		<div id="all">
				<table class="m_table"  border="0" cellspacing="0" cellpadding="0"
					class="table table-hover">
					<thead>
<!-- 					<tr> -->
<!-- 					<td><input class="btn btn-danger all_option" type="submit" value="删除" onclick=admin_GoodDeleteAll_comfirm()   /></td> -->
<!-- 					<td><input class="btn btn-update all_option" type="submit" value="修改" /></td> -->
<!-- 					<td><label><input type="checkbox" id="check_all" onclick=selectAll()>全选</label>
						<td><input type="checkbox" name="checkbox" ></td>
</tr> -->
						<tr
							style="background-color: #d9d8d8; font-size: 14px; color: #464646;">
							<td>序号</td>
							<td>关键字</td>
							<td style="width:80px;">操作</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="page.list">
							<tr>
								<td>${id}</td>
								<td><a href="admin/adminshowKeyword!view?id=${id}">${title}</a></td>
								<td>
								<form action="admin/adminshowKeyword!view" method="post" target="_blank">
										<input type="hidden" value="${id}" name="id" /> <input
											class="btn btn-view" type="submit" value="查看" />
									</form>
								<form action="admin/adminshowKeyword!altershow" method="post" target="_blank">
										<input type="hidden" value="${id}" name="id" /> <input
											class="btn btn-update" type="submit" value="修改" />
									</form>
									<form action="admin/adminshowKeyword!deletekeywordbyid"  method="post">
 										<input type="hidden" value="${id}" name="id" /> <input
 											class="btn btn-danger" type="submit" value="删除" onclick="return confirm('确定删除该关键字？')"   />
									</form>
									
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
						<tr>
						<td><a href="admin/adminshowKeyword!findkeywordspecial?page.currentPage=1&&title=${title}">首页</a></td>
				<s:iterator value="page.pageList" id="e">
					<td><a href="admin/adminshowKeyword!findkeywordspecial?page.currentPage=${e}&&title=${title}">${e}</a></td>
				</s:iterator>
				<td><a href="admin/adminshowKeyword!findkeywordspecial?page.currentPage=${page.totalPage}&&title=${title}">末页</a></td>	
				<td>共有${page.totalPage}页，${page.allRow}条记录</td>
					</tr>	
		<a href="admin/adminshowKeyword">返回</a>
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