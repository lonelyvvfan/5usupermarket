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
<script language="javascript" src="../js/sectypeajax.js"></script>
<script language="javascript" src="../js/imagesize.js"></script>
<script language="javascript" src="../js/jquery-1.7.2.min.js"></script>
<title>新增二手商品</title>
</head>
<body>
<p id="index4"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
		<form action="admin/adminshowsecGoods!addsecgoods" method="post"
enctype="multipart/form-data">
			
			<table class="table">
						<tr>
							<td>类别：</td>
							<td><select id='suptype' name = "suptypeid" onchange="changesup()" style="width:100px">
	</select>>
	<select id='subtype' name = "subtypeid" style="width:100px">
		<option value="1">全部</option>
	</select></td>
						</tr>
						<tr>
							<td>发布者真实姓名：</td>
							<td>
								<input class="t_text"  type="text"  name="nickname" required />
							</td>
						</tr>
						<tr>
							<td>商品名：</td>
							<td>
								<input class="t_text"  type="text"  name="goodsname" required />
							</td>
						</tr>
						<tr>
						<td>新旧：</td>
						<td>
						<input type="radio" tabindex="17" name="recency" value="1" class="no_new" id="no_new">非全新</input>
                            <input type="radio" tabindex="17" name="recency" value="0" class="new" id="new">全新</input>
						</td>
						</tr>
						<tr>
							<td>推荐理由：</td>
							<td>
								<input class="t_text"  type="text" name="reason"  maxlength="9"  required/>可输入九个字符
							</td>
						</tr>
						<tr>
							<td>现价：</td>
							<td><input class="t_text"  type="text" name="price" />元
							</td>
						</tr>
						<tr>
						<td class="for">所在地：</td>
						<td>
						<div class="input-prepend">
							<span class="add-on">学校</span> 
							<select class="address" style="width:195px" name="school" id="sch" onchange="changeSch()" required>
							<option></option>
							<option value="0">浙江工商大学</option>
							<option value="1">浙江财经大学</option>
							<option value="2">中国计量学院现代科技学院</option>
							<option value="3">杭州师范大学</option>
							<option value="4">浙江经贸职业技术学院</option>
							<option value="5">浙江金融职业技术学院</option>
							<option value="6">浙江水利水电学院</option>
							<option value="7">浙江经济职业技术学院</option>
							</select>
						</div>
						<div class="input-prepend">
							<span class="add-on">生活区</span> 
							<select class="address" style="width:150px" name="living" id="buil" required>
							</select>
						</div>
						</td>
						</tr>
						<tr>
							<td>QQ：</td>
							<td>
								<input class="t_text"  type="text" name="qq"/>
							</td>
						</tr>
						<tr>
							<td>手机号：</td>
							<td>
								<input class="t_text"  type="text" name="telephone"/>
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
							<td>商品介绍：</td>
							<td><textarea id="editor_1" rows="40" cols="40" name="introduce" ></textarea>
							<p id="count">您当前输入了 <span class="word_count2">0</span> 个文字。<span class="word_surplus"></span></p>
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
		<input type="hidden" name="userid" value="${id}" />
		<input type="hidden" name="username" value="${username}" />
		 <button class="btn" type="submit" onclick="return confirm('确定添加该二手商品？')">添加</button>
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
                    afterChange : function() {
                        $('.word_count2').html(this.count('text'));  //字数统计包含纯文本、IMG、EMBED，不包含换行符，IMG和EMBED算一个文字
                        //////////
                        //限制字数
                        var limitNum = 2000;  //设定限制字数
                        var pattern = '还可以输入' + limitNum + '字';
                        $('.word_surplus').html(pattern); //输入显示
                        if(this.count('text') > limitNum) {
                            pattern = ('字数超过限制，请适当删除部分内容');
                            //超过字数限制自动截取
                            var strValue = editor.text();
                            strValue = strValue.substring(0,limitNum);
                            editor.text(strValue);
                        } else {
                            //计算剩余字数
                            var result = limitNum - this.count('text');
                            pattern = '还可以输入' +  result + '字';
                        }
                        $('.word_surplus').html(pattern); //输入显示
                        ////////
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