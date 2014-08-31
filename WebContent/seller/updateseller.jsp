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
<link rel="stylesheet" href="../style/bootstrap.css" type="text/css">
<script language="javascript" src="../js/check.js"></script>
<script language="javascript" src="../js/idcard.js"></script>
<script language="javascript" src="../js/imagesize.js"></script>
<script language="javascript" src="../js/editornum.js"></script>
<title>修改外卖商家信息</title>
</head>
<body>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
	<form action="seller/sellershowSeller!alterseller"  method="post"
		enctype="multipart/form-data" action="">
		<table class="table table-bordered">
			<tr>
				<td>用户名：</td>
				<td>${seller.username}
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" onkeydown="if(event.keyCode==13)event.keyCode=9"  id="first_pwd1" name="password" value="${seller.password}" placeholder="请输入6-20位用户密码" onblur="checkpwd1()"  requierd  />
				</td>
			</tr>
			<tr>
				<td>外卖商家名：</td>
				<td><input type="text" name="name" value="${seller.name}"  requierd />
				</td>
			</tr>
			<tr>
				<td>联系电话：</td>
				<td><input type="text" id="telephone1"  name="telephone" value="${seller.telephone}"   placeholder="请输入您的手机号码" onblur="checkmobile1()" requierd  />
				</td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" name="address" value="${seller.address}"  requierd />
				</td>
			</tr>
			<tr>
				<td>电子邮件：</td>
				<td><input type="email" name="email" value="${seller.email}" />
				</td>
			</tr>
			<tr>
				<td>支付宝帐号：</td>
				<td><input type="text" name="alipaynum" value="${seller.alipaynum}" />
				</td>
			</tr>
			<tr>
				<td>身份证号：</td>
				<td>${seller.identification}
				</td>
			</tr>
			<tr>
				<td>推荐理由：</td>
				<td><input type="text" name="reason" value="${seller.reason}" maxlength="9" requierd />
				</td>
			</tr>
			<tr>
							<td>需要更新的图片：</td>
							<td><input type="file" name="upload" onchange="fileChange(this,upload);"  /><span style="color:gray;font-size:12px;">图片大小不得大于2M，且图片大小为300px*343px</span>
						</td>
					  </tr>
					  <tr>
						<td>当前图片：</td>
						<td><img style="width:280px;height:300px" alt="s_pic" src="images/seller${seller.savepath}">
						</td>
					</tr>
			<tr>
				<td>权限：</td>
				<td><script>selectauthor('${seller.author}')</script>
				</td>
			</tr>
			<tr>
				<td>介绍：</td>
				<td><textarea id="editor_1" rows="40" cols="40" name="content"> ${seller.content} </textarea>
				<p id="count">您当前输入了 <span class="word_count2">0</span> 个文字。<span class="word_surplus"></span></p>
				</td>
			</tr>
			
		</table>
		<button class="btn" type="submit" onclick="return confirm('确定修改信息吗？')">确定</button>
		<input type="hidden" name="id" value="${seller.id}"/>
		<input type="hidden" name="author" value="${seller.author}" />
		<input type="hidden" name="savepath" value="${seller.savepath}" />
		<input type="hidden" name="username" value="${seller.username}" />
		<input type="hidden" name="identification" value="${seller.identification}" />
	</form>
	</div>
</div>
</div>
<script type="text/javascript">
		//$("#clazz option[value='${method.clazz}']").attr("selected", "selected");
		//$("#overhead option[value='${method.overhead}']").attr("selected", "selected");
	</script>
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
            	    'insertunorderedlist', '|','image', 'emoticons',  'link' , 'unlink']
            	}
                );
        });
</script>

</body>
</html>