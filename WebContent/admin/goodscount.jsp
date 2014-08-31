<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="../js/comfirm.js"></script>
<title>商品销售统计查询</title>
</head>
<body>
<p id="index12"></p>
<div id="win">
		<div id="left">
			<ul>
			</ul>
			
		</div>
		<div id="right">

		<form action="admin/adminshowOrder!goodscount" method="post">
			商品名：<input type="text" class="search_box" name="goodsname" required placeholder="请输入商品名" /> 
			<input type="text" class="search_box" name="startdate" onclick="new Calendar().show(this);"  readonly="readonly" placeholder="请选择订单起始日期" />
			—<input type="text" class="search_box" name="enddate" onclick="new Calendar().show(this);"  readonly="readonly" placeholder="请选择订单截止日期" /> 
			订单是否完成：<select name = "isclosed" >
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
					<!--<td><input class="btn btn-danger all_option"  name= "bt1"  id= "bt1" type="button" value="删除" onclick="orderupjia('1')" onmousedown="admin_delAllOrder_confirm()" /></td>
					 <td><input class="btn btn-update all_option" type="submit" value="修改" /></td>
					 
					 <td><input class="btn btn-info all_option" name= "bt2" id= "bt2" type="button" value="完成" onclick="orderupjia('2')"  onmousedown="admin_finishAllOrder_confirm()"  /></td>
					 <td><input class="btn btn-warning all_option" name= "bt3" id= "bt3" type="button" value="配送中" onclick="orderupjia('3')" onmousedown="admin_doingAllOrder_confirm()" /></td>
					 -->
					</tr>
						
					</thead>
					<tbody>
						
					</tbody>
				</table>
				</form>
							
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