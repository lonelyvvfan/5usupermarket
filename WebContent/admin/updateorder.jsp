<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script charset="utf-8" src="../kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh_CN.js"></script>
<script language="javascript" src="../js/comfirm.js"></script>
<title>修改订单</title>
</head>
<body>
<p id="index1"></p>
<div id="win">
		<div id="left">
		</div>
		<div id="right">

	<div id="form">
	<form action="admin/adminshowOrder!alterorder"  method="post"
		enctype="multipart/form-data">
		<table class="table">
						<tr>
							<td>到达日期：</td>
							<td>
								<input class="t_text"  type="text" name="arrivedday" value = "${order.arrivedday}" />
							</td>
						</tr>
						<tr>
							<td>送达时间：</td>
							<td>
								 <select name="arrivedtime">
								 <option value="${order.arrivedtime}">当前是<script>selectarrivedtime('${order.arrivedtime}')</script></option>
                                <option value="0">早上8:00至10:00</option>
                                <option value="1">下午13:00至15：00</option>
                                <option value="2">晚上19：00至21：00</option>
                            </select>
							</td>
						</tr>
						<tr>
							<td>最终金额：</td>
							<td><input class="t_text"  type="number" name="totalamount" value = "${order.totalamount }" />
							</td>
						</tr>
						<tr>
							<td>用户名：</td>
							<td><input class="t_text"  type="text" name="username" value = "${order.username }" />
							</td>
						</tr>
						<tr>
							<td>真实姓名：</td>
							<td><input class="t_text"  type="text" name="truename" value = "${order.truename }" />
							</td>
						</tr>
						<tr>
							<td>联系电话：</td>
							<td><input class="t_text"  type="text" name = "telephone" value = "${order.telephone }"/>
						</td>
					  </tr>
					<tr>
						<td>学校：</td>
						<td><input class="t_text"  type="text" name = "school" value = "${order.school }"/>
						</td>
					</tr>
					<tr>
						<td>寝室楼号：</td>
						<td><input class="t_text"  type="number" name = "doorplate" value = "${order.doorplate }"/>
						</td>
					</tr>
					<tr>
						<td>寝室号：</td>
						<td><input class="t_text"  type="number" name = "room" value = "${order.room }"/>
						</td>
					</tr>
					<tr>
						<td>备注：</td>
						<td><textarea id="editor_1" rows="10" cols="40" name = "remark">${order.remark }</textarea>
						</td>
					</tr>
					<tr>
						<td>支付方式：</td>
						<td><select   name="payway"  >
						<option value="${order.payway }">当前是<script>selectpayway('${order.payway}')</script></option>
									<option value="0">支付宝</option>
									<option value="1">当面付</option>
							</select></td>
					</tr>
					<tr>
						<td>订单状态：</td>
						<td><select name="isclosed"  >
						<option value="${order.isclosed}">当前是<script>select('${order.isclosed}')</script></option>
									<option value="0">完成</option>
									<option value="1">配送中</option>
							</select></td>
					</tr>
		
		</table>
		<input type="hidden" name="id" value="${order.id}"/>
		<input type="hidden" name="orderNo" value="${order.orderNo}"/>
		<button class="btn" type="submit" onclick="return confirm('确定修改该订单信息？')">修改</button>
	</form>
	<br><br>
	<h1>订单详情：</h1><br>
		<form action="admin/adminshowOrder!alterorderdetail"  method="post"
		enctype="multipart/form-data">
			<table class="table">
			<thead>
				<tr>
				  <td></td>
					<td>订单编号</td>
					<td>商品编号</td>
					<td>商品单价</td>
					<td>购买数量</td>
				</tr>
			<tbody>
			  <%int i= -1; %>
			<s:iterator value="list_detail">
			  <%i++;%>
				<tr>
					<td><input type="hidden" name="list_detail1[<%= i%>].id" value="${id}"/></td>
					<td><input class="t_detail"  type="text"  name = "list_detail1[<%= i%>].orderid" value = "${orderid}" />
					<td><input class="t_detail"  type="text"  name = "list_detail1[<%= i%>].goodsid" value = "${goodsid}"/>
					<td><input class="t_detail"  type="number"  name = "list_detail1[<%= i%>].price" value = "${price}"/>
					<td><input class="t_detail"  type="number"  name = "list_detail1[<%= i%>].number" value = "${number}"/>
				</tr>
				</s:iterator>
			</tbody>
			</table>
			 <button class="btn" type="submit" onclick="return confirm('确定修改该订单信息？')" >修改</button> 
		</form>
	</div>
</div>
</div>
<script>
        KindEditor.ready(function(K) {
                window.editor = K.create('#editor_1',
                { 
                	imageUploadJson : '/kindeditor/jsp/upload_json.jsp',

                	fileManagerJson : '/kindeditor/jsp/file_manager_json.jsp',

      
                    afterUpload :function(url){
                    	alert(url);
                    },
                    allowImageUpload : true, 
                	resizeType : 1,
            	    allowPreviewEmoticons : false,
            	    allowUpload : true,
            	    items : [
            	    'fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
            	    'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
            	    'insertunorderedlist', '|', 'emoticons',  'link' , 'unlink']
            	}
                );
        });
</script>
</body>
</html>