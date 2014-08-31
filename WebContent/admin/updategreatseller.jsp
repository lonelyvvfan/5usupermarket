<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<script charset="utf-8" src="../editor/kindeditor.js"></script>
<script charset="utf-8" src="../editor/lang/zh_CN.js"></script>
-->
<script charset="utf-8" src="../kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh_CN.js"></script>
<script language="javascript" src="../js/comfirm.js"></script>
<script language="javascript" src="../js/jquery-1.7.2.min.js"></script>
<script language="javascript" src="../js/greattypeajax.js"></script>
<script language="javascript" src="../js/imagesize.js"></script>
<title>修改推荐商家信息</title>
</head>
<body>
<p id="index6"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
				<form action="admin/adminshowGreatseller!altergreatseller"  method="post"
					enctype="multipart/form-data">
					<table class="table">
						<tr>
							<td>类别：</td>
							<td>
								<select class="span2" style="width:160px" name="suptypeid" id="greatseller" onchange="changeGreatseller()" required>
							<option value="${greatseller.suptypeid}">当前：<script>selectgreatseller_supertypes('${greatseller.suptypeid}')</script></option>
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
								<option value="${greatseller.subtypeid}">当前：<script>selectgreatseller_subtypes('${greatseller.subtypeid}')</script></option>
								
							</select>
							</td>
						</tr>
						<tr>
							<td>推广商家名：</td>
							<td>
								<input class="t_text"  type="text"   name="name" value="${greatseller.name}"  required />
							</td>
						</tr>
						<tr>
							<td>商家链接：</td>
							<td><input class="t_text"  type="text" name="url" value="${greatseller.url}" />
							</td>
						</tr>
						<tr>
						<td>商品主图片：</td>
							<td> 
							<input type="file" name="upload" id="upload" onchange="fileChange(this,upload,'imgView','divNewPreview')"/> <span style="color:gray;font-size:12px;">推荐上传图片像素:306px*350px;图片大小不得大于2M</span>
								<img id="imgView" src=""  alt="" />
								<div id="divNewPreview"></div>
						</td>
					  </tr>
					  <tr>
						<td>当前图片：</td>
						<td><img alt="pic" class="good_img"  src="images/greatseller/${greatseller.savepath}">
						</td>
					</tr>
					  <tr>
						<td>是否上架：</td>
						<td><select id="shelves"  name="shelves"  >
									<option value="${greatseller.shelves}" >当前选择：<script>selectshelves('${greatseller.shelves}')</script></option>
									<option value="0">下架</option>
									<option value="1">上架</option>
							</select></td>
					</tr>
						<!-- 
						<tr>
							<td>商家介绍：</td>
							<td><textarea id="editor_1"  rows="10" cols="40" name="content" >${greatseller.content}</textarea>
							</td>
						</tr>
						<tr>
							<td>电话：</td>
							<td><input class="t_text"  type="text" name="telephone" value="${greatseller.telephone}" />
							</td>
						</tr>
						<tr>
							<td>地址：</td>
							<td><input class="t_text"  type="text" name="address" value="${greatseller.address}" />
							</td>
						</tr>
						
					  <tr>
							<td>需要更新商品其他图片1：</td>
							<td><input type="file" name="upload1"/>
						</td>
					  </tr>
					  <tr>
							<td>需要更新商品其他图片2：</td>
							<td><input type="file" name="upload2"/>
						</td>
					  </tr>
					  <tr>
							<td>需要更新商品其他图片3：</td>
							<td><input type="file" name="upload3"/>
						</td>
					  </tr>
					
					<tr>
						<td>当前其他图片1：</td>
						<td><img alt="pic" src="images/greatseller/${greatseller.savepath1}">
						</td>
					</tr>
					<tr>
						<td>当前其他图片2：</td>
						<td><img alt="pic" src="images/greatseller/${greatseller.savepath2}">
						</td>
					</tr>
					<tr>
						<td>当前其他图片3：</td>
						<td><img alt="pic" src="images/greatseller/${greatseller.savepath3}">
						</td>
					</tr>
					 -->
		</table>
		<button class="btn" type="submit" onclick="return confirm('确定修改该推荐商家信息？')" >修改</button>
		<input type="hidden" name="id" value="${greatseller.id}"/>
		<input type="hidden" name="savepath" value="${greatseller.savepath}"/>
		<input type="hidden" name="savepath1" value="${greatseller.savepath1}"/>
		<input type="hidden" name="savepath2" value="${greatseller.savepath2}"/>
		<input type="hidden" name="savepath3" value="${greatseller.savepath3}"/>
	
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
            	    'insertunorderedlist', '|', 'emoticons',  'link' , 'unlink']
            	}
                );
        });
</script>
</body>
</html>