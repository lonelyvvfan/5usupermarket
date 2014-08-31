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
<script language="javascript" src="../js/idcard.js"></script>
<script language="javascript" src="../js/imagesize.js"></script>
 <script language="javascript" src="../js/editornum.js"></script>
<title>新增外卖商家信息</title>
</head>
<body>
<p id="index8"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
	<form action="admin/adminshowSeller!addseller"  method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" value="${seller.username}" requierd >
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text"  onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" onkeydown="if(event.keyCode==13)event.keyCode=9"  name="password" value="${seller.password}" requierd  />
				</td>
			</tr>
			<tr>
				<td>外卖商家名：</td>
				<td><input type="text" name="name" value="${seller.name}" requierd  />
				</td>
			</tr>
			<tr>
				<td>早餐：</td>
				<td><input type="checkbox" name="subtypeid2" value=2 />豆制品
				<input type="checkbox" name="subtypeid2" value=3 />面包
				<input type="checkbox" name="subtypeid2" value=4 />其他</td>
			</tr>
			<tr>
				<td>午餐：</td>
				<td><input type="checkbox" name="subtypeid3" value=5 />面类
				<input type="checkbox" name="subtypeid3" value=6 />饭类
				<input type="checkbox" name="subtypeid3" value=7 />煲仔类
				<input type="checkbox" name="subtypeid3" value=8 />其他</td>
			</tr>
			<tr>
				<td>晚餐：</td>
				<td><input type="checkbox" name="subtypeid4" value=9 />面类
				<input type="checkbox" name="subtypeid4" value=10 />汤类
				<input type="checkbox" name="subtypeid4" value=11 />其他</td>
			</tr>
			<tr>
				<td>联系电话：</td>
				<td><input type="text" name="telephone" value="${seller.telephone}" requierd />
				</td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" name="address" value="${seller.address}" requierd />
				</td>
			</tr>
			<tr>
				<td>电子邮件：</td>
				<td><input type="text" name="email" value="${seller.email}" />
				</td>
			</tr>
			<tr>
				<td>支付宝帐号：</td>
				<td><input type="text" name="alipaynum" value="${seller.alipaynum}" />
				</td>
			</tr>
			<tr>
				<td>身份证号：</td>
				<td><input type="text" id="cardNum" name="identification" value="${seller.identification}" onblur="IdCardValidate1(this.value)"  requierd  />
				</td>
			</tr>
			<tr>
				<td>推荐理由：</td>
				<td><input type="text" name="reason" value="${seller.reason}" maxlength="9" required/>可输入九个字符
				</td>
			</tr>
			<tr>
							<td>LOGO：</td>
							<td><input type="file" name="upload" onchange="fileChange(this,upload);" required/><span style="color:gray;font-size:12px;">图片大小不得大于2M，推荐图片大小为300px*343px</span>
						</td>
					  </tr>
			<tr>
				<td>介绍：</td>
				<td><textarea id="editor_1" rows="40" cols="40" name="content"> ${seller.content} </textarea>
				<p id="count">您当前输入了 <span class="word_count2">0</span> 个文字。<span class="word_surplus"></span></p>
				</td>
			</tr>
			
		</table>
		<input type="hidden" name="author" value="1" />
		<button class="btn" type="submit" onclick="return confirm('确定添加该外卖商家？')" >保存</button>
	</form>
	</div>
</div>
</div>
<script type="text/javascript">
		//$("#clazz option[value='${method.clazz}']").attr("selected", "selected");
		//$("#overhead option[value='${method.overhead}']").attr("selected", "selected");
	</script>
</body>
</html>