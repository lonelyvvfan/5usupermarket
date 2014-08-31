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
<script language="javascript" src="../js/jquery-1.7.2.min.js"></script>
<script language="javascript" src="../js/takeouttypeajax.js"></script>
<script language="javascript" src="../js/imagesize.js"></script>
<script language="javascript" src="../js/jquery-1.7.2.min.js"></script>
 <script language="javascript" src="../js/editornum.js"></script>
<title>修改外卖信息</title>
</head>
<body>
<p id="index5"></p>
	<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
				<form action="admin/adminshowTakeout!altertakeout" method="post"
					enctype="multipart/form-data">
					<table class="table">
						<tr>
							<td>卖家名：</td>
							<td>
								<input class="t_text"  type="text" name="sellername"  value= "${takeout.sellername}" required />
							</td>
						</tr>
						<tr>
							<td>类别：</td>
							<td><select class="span2" style="width:160px" name="suptypeid" id="takeout" onchange="changeTakeout()" required>
							<option value="${takeout.suptypeid}">当前：<script>selecttakeout_supertypes('${takeout.suptypeid}')</script></option>
							<option value="2">早餐</option>
							<option value="3">中餐</option>
							<option value="4">晚餐</option>
						</select>
							<select class="span2" style="width:150px" name="subtypeid" id="subtakeout" required>
								<option value="${takeout.subtypeid}">当前：<script>selecttakeout_subtypes('${takeout.subtypeid}')</script></option>
								
							</select>
							</td>
						</tr>
						<tr>
							<td>商品名：</td>
							<td><input class="t_text" type="text" maxlength="11"  name="goodsname"
								value="${takeout.goodsname}" required  /></td>
						</tr>
						<tr>
							<td>推荐理由：</td>
							<td>
								<input class="t_text"  type="text" name="reason" value="${takeout.reason}"  required/>
							</td>
						</tr>
						<tr>
							<td>原价：</td>
							<td><input class="t_text" type="text" name="price"
								value="${takeout.price}" />元</td>
						</tr>
						<tr>
							<td>现价：</td>
							<td><input class="t_text" type="text" name="nowprice"
								value="${takeout.nowprice}" />元</td>
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
							<td>商品其他图片1：</td>
							<td>
							<input type="file" name="upload1" id="upload1" onchange="fileChange(this,upload1,'imgView1','divNewPreview1')" /><span style="color:gray;font-size:12px;">推荐上传图片像素:306px*350px;图片大小不得大于2M</span>
							<img id="imgView1" src=""  alt="" />
								<div id="divNewPreview1"></div>
						</td>
					  </tr>
					  <tr><td>商品其他图片2：</td>
							<td>
							<input type="file" name="upload2" id="upload2" onchange="fileChange(this,upload2,'imgView2','divNewPreview2')" /><span style="color:gray;font-size:12px;">推荐上传图片像素:306px*350px;图片大小不得大于2M</span>
							<img id="imgView2" src=""  alt="" />
								<div id="divNewPreview2"></div>
						</td>
					  </tr>
					  <tr>
							<td>商品其他图片3：</td>
							<td>
							<input type="file" name="upload3" id="upload3" onchange="fileChange(this,upload3,'imgView3','divNewPreview3')" /><span style="color:gray;font-size:12px;">推荐上传图片像素:306px*350px;图片大小不得大于2M</span>
							<img id="imgView3" src=""  alt="" />
								<div id="divNewPreview3"></div>
						</td>
					</tr>
						<tr>
							<td>当前主图片：</td>
							<td><img alt="pic" class="good_img"  src="images/takeout/${takeout.savepath}">
							</td>
						</tr>
						<tr>
							<td>当前其他图片1：</td>
							<td><img alt="pic" class="good_img"  src="images/takeout/${takeout.savepath1}">
							</td>
						</tr>
						<tr>
							<td>当前其他图片2：</td>
							<td><img alt="pic" class="good_img"  src="images/takeout/${takeout.savepath2}">
							</td>
						</tr>
						<tr>
							<td>当前其他图片3：</td>
							<td><img alt="pic" class="good_img"  src="images/takeout/${takeout.savepath3}">
							</td>
						</tr>
						<tr>
							<td>商品介绍：</td>
							<td><textarea id="editor_1" rows="40" cols="40"
									name="introduce">${takeout.introduce}</textarea>
									<p id="count">您当前输入了 <span class="word_count2">0</span> 个文字。<span class="word_surplus"></span></p></td>
						</tr>
					<tr>
						<td>是否上架：</td>
						<td><select id="shelves"  name="shelves"  >
									<option value="${takeout.shelves}" >当前选择：<script>selectshelves('${takeout.shelves}')</script></option>
									<option value="0">下架</option>
									<option value="1">上架</option>
							</select></td>
					</tr>
					</table>
					<button class="btn" type="submit" onclick="return confirm('确定修改该外码商品信息？')">修改</button>
					<input type="hidden" name="id" value="${takeout.id}" />
					<input type="hidden" name="savepath" value="${takeout.savepath}"/>
					<input type="hidden" name="savepath1" value="${takeout.savepath1}"/>
					<input type="hidden" name="savepath2" value="${takeout.savepath2}"/>
					<input type="hidden" name="savepath3" value="${takeout.savepath3}"/>
					<input type="hidden" name="sellerid" value= "${takeout.sellerid}"/>
	
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