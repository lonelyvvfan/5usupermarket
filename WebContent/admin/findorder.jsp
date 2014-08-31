<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="../js/comfirm.js"></script>
<title>超市管理</title>
</head>
<body>

	<p id="index1"></p>
	<div id="win">
		<div id="left">
			<ul>
				<li id="tianjia"><a href="admin/addorder.jsp">添加</a></li>
			</ul>
			
		</div>
		<div id="right">
		
		<form action="admin/adminshowOrder!findorderspecial" method="post">
			用户名：<input type="text" class="search_box" name="username" value="${username}" placeholder="请输入用户名"/>
			订单号：<input type="text" class="search_box" name="orderNo" value="${orderNo}" placeholder="请输入订单号" />&nbsp;&nbsp;
			<input type="text" class="search_box" name="startdate" value="${startdate}" onclick="new Calendar().show(this);"  readonly="readonly" placeholder="请选择订单起始日期" />
			—<input type="text" class="search_box" name="enddate" value="${enddate}" onclick="new Calendar().show(this);"  readonly="readonly" placeholder="请选择订单截止日期" /> 
			订单是否完成：<select name = "isclosed">
				<option value="${isclosed}">当前选择:<script>select('${isclosed}');</script></option>
				<option value="2">全部</option>
				<option value="0">完成</option>
				<option value="1">配送中</option>
				<option value="3">已下单</option>
			</select> 
			<input type="submit" class="search_btn" value="查找" />
		</form>
		<div id="all">
		<form method="post" action = ""  id="myform" name="myform" >
				<table class="m_table"  border="0" cellspacing="0" cellpadding="0"
					class="table table-hover">
					<thead>
					<tr>
					<!-- <td><input class="btn btn-danger all_option"  name= "bt1"  id= "bt1" type="button" value="删除" onclick="orderupjia('1')"  onmousedown="admin_delAllOrder_confirm()" /></td>
					 <td><input class="btn btn-update all_option" type="submit" value="修改" /></td>
					 -->
					 <td><input class="btn btn-info all_option" name= "bt2" id= "bt2" type="button" value="完成" onclick="orderupjia('2')" onmousedown="admin_finishAllOrder_confirm()"   /></td>
					 <td><input class="btn btn-warning all_option" name= "bt3" id= "bt3" type="button" value="配送中" onclick="orderupjia('3')" onmousedown="admin_doingAllOrder_confirm()" /></td>
					 <td><input class="btn btn-warning all_option" name= "bt4" id= "bt4" type="button" value="导出到excel" onclick="orderupjia('4')" onmousedown="admin_doingAllOrder_confirm()" /></td>
					 <td><input class="btn btn-warning all_option" name= "bt4" id= "bt4" type="button" value="批量导出打印" onclick="orderupjia('5')" onmousedown="admin_doingAllOrder_confirm()" /></td>
					</tr>
						<tr
							style="background-color: #d9d8d8; font-size: 14px; color: #464646;">
							<td><label><input type="checkbox" id="check_all" onclick=selectAll()>全选</label></td>
							<td>序号</td>
							<td style="width:100px;">订单号</td>
							<td style="width:80px;">用户名</td>
							<td>真名</td>
							<td>总金额</td>	
							<td>支付方式</td>			
							<td>地址</td>
							<td style="width:100px;">下单时间</td>
							<td  style="width:108px;">送货时间</td>
							<td>订单状态</td>
							<td style="width:80px;">操作</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="orderpage.list">
							<tr>
							<td><input type="checkbox" name="checkbox" value="${id}"></td>
								<td>${id}</td>
								<td><a href="admin/adminshowOrder!view?id=${id}" target="_blank">${orderNo}</a></td>
								<td>${username}</td>
								<td>${truename}</td>
								<td>${totalamount}元</td>
								<td><script>selectpayway('${payway}')</script></td>
								<td><script>selectschool('${school}')</script><br><script>selectliving('${living}')</script>&nbsp;${doorplate}楼&nbsp;${room}室</td>						
								<td>${orderday}</td>
								<td>${arrivedday}&nbsp;<br><script>selectarrivedtime('${arrivedtime}')</script></td>
								<td><script>select('${isclosed}')</script></td>
								<td>
								<form action="admin/adminshowOrder!view" method="post" >
									</form>
									<form action="admin/adminshowOrder!view" method="post" target="_blank">
										<input type="hidden" value="${id}" name="id" /> <input
											class="btn btn-view" type="submit" value="查看" />
									</form>
									<!-- <form action="admin/adminshowOrder!altershow" method="post">
										<input type="hidden" value="${id}" name="id" /> <input
											class="btn btn-update" type="submit" value="修改" />
									</form>
									<form action="admin/adminshowOrder!deleteorderbyid" method="post">
										<input type="hidden" value="${id}" name="id" /> <input
											class="btn btn-danger" type="submit" value="删除" onclick="return confirm('确定删除该订单？')" />
									</form>-->
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				</form>
			<tr>	
				<td><a href="admin/adminshowOrder!findorderspecial?orderpage.currentPage=1&&username=${username}&&orderNo=${orderNo}&&startdate=${startdate}&&enddate=${enddate}&&isclosed=${isclosed}">首页</a></td>
				<s:iterator value="orderpage.pageList" id="e">
					<td><a href="admin/adminshowOrder!findorderspecial?orderpage.currentPage=${e}&&username=${username}&&orderNo=${orderNo}&&startdate=${startdate}&&enddate=${enddate}&&isclosed=${isclosed}">${e}</a></td>
				</s:iterator>
				<td><a href="admin/adminshowOrder!findorderspecial?orderpage.currentPage=${orderpage.totalPage}&&username=${username}&&orderNo=${orderNo}&&startdate=${startdate}&&enddate=${enddate}&&isclosed=${isclosed}">末页</a></td>	
				<td>共有${orderpage.totalPage}页，${orderpage.allRow}条记录</td>
				</tr>
		<a href="admin/adminshowOrder">返回</a>
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