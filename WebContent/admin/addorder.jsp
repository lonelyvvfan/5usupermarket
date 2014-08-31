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
 <script language="javascript" src="../js/editornum.js"></script>
<title>新增订单</title>
</head>
<body>
<p id="index1"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
		<form action="admin/adminshowOrder!addorder1"  method="post"
enctype="multipart/form-data">
			
			<table class="table">
						<tr>
							<td>到达日期：</td>
							<td>
								<input class="t_text"  type="text" name="arrivedday" />
							</td>
						</tr>
						<tr>
							<td>送达时间：</td>
							<td>
								<input class="t_text"  type="text" name="arrivedtime"/>
							</td>
						</tr>
						<tr>
							<td>最终金额：</td>
							<td><input class="t_text"  type="text" name="totalamount" />
							</td>
						</tr>
						<tr>
							<td>用户名：</td>
							<td><input class="t_text"  type="text" name="username" />
							</td>
						</tr>
						<tr>
							<td>真实姓名：</td>
							<td><input class="t_text"  type="text" name="truename" />
							</td>
						</tr>
						<tr>
							<td>联系电话：</td>
							<td><input class="t_text"  type="text" name = "telephone"/>
						</td>
					  </tr>
					<tr>
						<td>学校：</td>
						<td><input class="t_text"  type="text" name = "school"/>
						</td>
					</tr>
					<tr>
						<td>寝室楼号：</td>
						<td><input class="t_text"  type="text" name = "doorplate"/>
						</td>
					</tr>
					<tr>
						<td>寝室号：</td>
						<td><input class="t_text"  type="text" name = "room"/>
						</td>
					</tr>
					<tr>
						<td>备注：</td>
						<td><textarea id="editor_1" rows="10" cols="40" name = "remark"></textarea>
						<p id="count">您当前输入了 <span class="word_count2">0</span> 个文字。<span class="word_surplus"></span></p>
						
						</td>
					</tr>
					<tr>
						<td>支付方式：</td>
						<td><select   name="payway"  >
									<option value="0">支付宝</option>
									<option value="1">财付通</option>
							</select></td>
					</tr>
					<tr>
						<td>订单状态：</td>
						<td><select name="isclosed"  >
									<option value="0">已完成</option>
									<option value="1">配送中</option>
							</select></td>
					</tr>
		
		</table>
		 <button class="btn" type="submit" onclick="return confirm('确定添加该订单？')" >添加</button>
	</form>
	</div>
</div>
</div>
	<script>
        KindEditor.ready(function(K) {
                window.editor = K.create('#editor_1',{ resizeType : 1,
            	    allowPreviewEmoticons : false,
            	    allowUpload : true,
            	    items : [
            	    'fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
            	    'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
            	    'insertunorderedlist', '|', 'emoticons',  'link' , 'unlink']
            });
        });
</script>
</body>
</html>