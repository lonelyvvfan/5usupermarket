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
<script language="javascript" src="../js/typeajax.js"></script>
<script language="javascript" src="../js/imagesize.js"></script>
<script language="javascript" src="../js/jquery-1.7.2.min.js"></script>
 <script language="javascript" src="../js/editornum.js"></script>
<title>新增商品信息</title>
</head>
<body>
<p id="index2"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
		<form action="admin/adminshowGoods!addgoods" method="post"
enctype="multipart/form-data">
			
			<table class="table">
						<tr>
							<td>类别：</td>
							<td>
								<select id='suptype' name = "suptypeid" onchange="changesup()" style="width:100px">
								</select>>
								<select id='subtype' name = "subtypeid" style="width:100px">
								<option value="1">全部</option>
							</select>
							</td>
						</tr>
						<tr>
							<td>商品名：</td>
							<td>
								<input class="t_text"  type="text" name="goodsname"  value="${goods.goodsname}"  required />
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
								<input class="t_text"  type="text" name="inventory"   required/>
							</td>
						</tr>
						<tr>
							<td>推荐理由：</td>
							<td>
								<input class="t_text"  type="text" name="reason"  maxlength="9"  required/>可输入九个字符
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
							<td><input class="t_text"  type="text" name="monthsell" value="${goods.monthsell}" required/>
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
					</tr>
					<tr>
						<td>是否为新品：</td>
						<td>
						<select id="newgoods"  name="newgoods">
									<option value="0">否</option>
									<option value="1">是</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>是否为热销商品：</td>
						<td>
						<select id="hot"  name="hot">
									<option value="0">否</option>
									<option value="1">是</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>是否为特价商品：</td>
						<td>
						<select id="special"  name="special">
									<option value="0">否</option>
									<option value="1">是</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>是否为健康商品：</td>
						<td>
						<select id="health"  name="health">
									<option value="0">否</option>
									<option value="1">是</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>是否为推荐商品：</td>
						<td><select id="recommend"  name="recommend"  >
									<option value="0">否</option>
									<option value="1">是</option>
							</select></td>
					</tr>
					<tr>
						<td>是否上架：</td>
						<td><select id="shelves"  name="shelves"  >
									<option value="1">上架</option>
									<option value="0">下架</option>
							</select></td>
					</tr>
					<tr>
							<td>商品介绍：</td>
							<td><textarea id="editor_1" rows="40" cols="40" name="introduce" >${goods.introduce}</textarea>
							<p id="count">您当前输入了 <span class="word_count2">0</span> 个文字。<span class="word_surplus"></span></p>
							</td>
						</tr>
					
		
		</table>
		 <button class="btn" type="submit" onclick="return confirm('确定添加该商品？')" >添加</button>
	</form>
	</div>
</div>
</div>


			<!-- 	id：<input type="text" name="id" /> 
			类型名称：<s:select list="goods_subtypes" listKey="id" listValue="typename" name = "typeid" />
			 商品名：<input type="text"	name="goodsname" /> 
			 商品介绍：<input type="text" name="introduce" />
			单价：<input type="text" name="price" />
			 <button class="btn" type="submit">添加</button>
		</form>
	</div>
-->
</body>
</html>