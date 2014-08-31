<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="../js/comfirm.js"></script>
<script language="javascript" src="../js/jquery-1.7.2.min.js"></script>
<script language="javascript" src="../js/greattypeajax.js"></script>
<script language="javascript" src="../js/imagesize.js"></script>
<title>新增推荐商家信息</title>
</head>
<body>
<p id="index6"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
		<form action="admin/adminshowGreatseller!addgreatseller"  method="post"
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
							<td>推广商家名：</td>
							<td>
								<input class="t_text"  type="text" name="name"  value="${greatseller.name}" required/>
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
						<td>是否上架：</td>
						<td><select id="shelves"  name="shelves"  >
									<option value="1">上架</option>
									<option value="0">下架</option>
							</select></td>
					</tr>
		
		</table>
		 <button class="btn" type="submit" onclick="return confirm('确定添加该推荐商家？')" >添加</button>
	</form>
	</div>
</div>
</div>
</body>
</html>