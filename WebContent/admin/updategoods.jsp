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
<script language="javascript" src="../js/typeajax.js"></script>
<script language="javascript" src="../js/imagesize.js"></script>
<script language="javascript" src="../js/jquery-1.7.2.min.js"></script>
 <script language="javascript" src="../js/editornum.js"></script>
<title>修改商品信息</title>
</head>
<body>
<p id="index2"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
				<form action="admin/adminshowGoods!altergoods"  method="post"
					enctype="multipart/form-data">
					<table class="table">
						<tr>
							<td>类别：</td>
							<td>
							<select class="span2" style="width:160px" name="suptypeid" id="goods" onchange="changeGoods()" required>
							<option value="${goods.suptypeid}">当前：<script>selectgoods_supertypes('${goods.suptypeid}')</script></option>
							<option value="2">进口零食</option>
							<option value="3">水果专区</option>
							<option value="4">休闲素食</option>
							<option value="5">乳品饮料</option>
							<option value="6">生活用品</option>
							<option value="7">办公数码</option>
							<option value="8">其他专区</option>
						</select>
							<select class="span2" style="width:150px" name="subtypeid" id="subgoods" required>
								<option value="${goods.subtypeid}">当前：<script>selectgoods_subtypes('${goods.subtypeid}')</script></option>
								
							</select>
							
							</td>
						</tr>
						<tr>
							<td>商品名：</td>
							<td>
								<input class="t_text"  type="text" name="goodsname"  value="${goods.goodsname}"  required/>
							</td>
						</tr>
						<tr>
							<td>优先级别：（越小级别越高）</td>
							<td>
								<input class="t_text"  type="text" name="indexx" value="${goods.indexx}" />
							</td>
						</tr>
						<tr>
							<td>库存：</td>
							<td>
								<input class="t_text"  type="text" name="inventory" value="${goods.inventory}"  required/>
							</td>
						</tr>
						<tr>
							<td>推荐理由：</td>
							<td>
								<input class="t_text"  type="text" name="reason" value="${goods.reason}"  maxlength="9"  required/>可输入九个字符
							</td>
						</tr>
						<tr>
							<td>单价：</td>
							<td><input class="t_text"  type="text" name="price" value="${goods.price}" />元
							</td>
						</tr>
						<tr>
							<td>现价：</td>
							<td><input class="t_text"  type="text" name="nowprice" value="${goods.nowprice}" />元
							</td>
						</tr>
						<tr>
							<td>赞：</td>
							<td><input class="t_text"  type="text" name="zan" value="${goods.zan}" />个赞
							</td>
						</tr>
						<tr>
							<td>月销量：</td>
							<td><input class="t_text"  type="text" name="monthsell" value="${goods.monthsell}" />
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
					<tr>
						<td>当前商品主图片：</td>
						<td><img alt="pic" class="good_img" src="images/goods/${goods.savepath}">
						</td>
					</tr>
					<tr>
						<td>当前商品其他图片1：</td>
						<td><img alt="pic" class="good_img"   src="images/goods/${goods.savepath1}">
						</td>
					</tr>
					<tr>
						<td>当前商品其他图片2：</td>
						<td><img alt="pic" class="good_img"  src="images/goods/${goods.savepath2}">
						</td>
					</tr>
					<tr>
						<td>当前商品其他图片3：</td>
						<td><img alt="pic" class="good_img"  src="images/goods/${goods.savepath3}">
						</td>
					</tr>
					
					<tr>
						<td>是否为新品：</td>
						<td>
						<select id="newgoods"  name="newgoods">
						<option value="${goods.newgoods}" >当前选择：<script>selectnewgoods('${goods.newgoods}')</script></option>
									<option value="0">否</option>
									<option value="1">是</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>是否为热销商品：</td>
						<td>
						<select id="hot"  name="hot">
						<option value="${goods.hot}" >当前选择：<script>selecthot('${goods.hot}')</script></option>
									<option value="0">否</option>
									<option value="1">是</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>是否为特价商品：</td>
						<td>
						<select id="special"  name="special">
						<option value="${goods.special}" >当前选择：<script>selectspecial('${goods.special}')</script></option>
									<option value="0">否</option>
									<option value="1">是</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>是否为健康商品：</td>
						<td>
						<select id="health"  name="health">
						<option value="${goods.health}" >当前选择：<script>selecthealth('${goods.health}')</script></option>
									<option value="0">否</option>
									<option value="1">是</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>是否为推荐商品：</td>
						<td><select id="recommend"  name="recommend"  >
									<option value="${goods.recommend}" >当前选择：<script>selectrecommend('${goods.recommend}')</script></option>
									<option value="0">否</option>
									<option value="1">是</option>
							</select></td>
					</tr>
					<tr>
						<td>是否上架：</td>
						<td><select id="shelves"  name="shelves"  >
									<option value="${goods.shelves}" >当前选择：<script>selectshelves('${goods.shelves}')</script></option>
									<option value="0">下架</option>
									<option value="1">上架</option>
							</select></td>
					</tr>
					<tr>
							<td>商品介绍：</td>
							<td><textarea id="editor_1"  rows="40" cols="40" name="introduce" >${goods.introduce}</textarea>
							<p id="count">您当前输入了 <span class="word_count2">0</span> 个文字。<span class="word_surplus"></span></p>
							</td>
						</tr>
						
		
		</table>
		<button class="btn" type="submit" onclick="return confirm('确定修改该商品信息？')" >修改</button>
		<input type="hidden" name="id" value="${goods.id}"/>
		<input type="hidden" name="savepath" value="${goods.savepath}"/>
		<input type="hidden" name="savepath1" value="${goods.savepath1}"/>
		<input type="hidden" name="savepath2" value="${goods.savepath2}"/>
		<input type="hidden" name="savepath3" value="${goods.savepath3}"/>
	
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