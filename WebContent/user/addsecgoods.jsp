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
<script language="javascript" src="js/imagesize.js"></script>
<script language="javascript" src="js/selectSchool.js"></script>
<script>
     var o_editor=document.getElementById("s_editor_1");
     var str=false;
     if(str)
    	 {
    	 o_editor.innerHTML=str;
    	 }
     else{
    	 str='<ol style='+'"color:gray;"'+'><li>使用时长： 例如 - 2011购买使用至今，已经有两年时间</li><li>新旧程度描述： 例如 - 保护得很好，基本没有什么硬伤</li><li>存在的问题： 例如 - 完好，没有任何问题</li><li>到手时间/有效期/适用条件： 例如 - 2012年买的，现在已经使用了一年多了</li></ol>'
     }
</script>
<title>发布二手商品</title>
</head>
<body>
<p id="index5"></p>

<div id="left">
            <img src="image/weixin1.png"/>
        </div>
<div id="good_main_body">
<div id="s_win">
		<div id="s_left"></div>
		<div id="s_right">

			<div id="s_form">
		<form action="user/secgoodsmanage!addsecgoods"  method="post"
enctype="multipart/form-data">
			
			<table class="table table-striped table-hover table-bordered " >
						<tr>
							<td class="t_head for"><img src="image/meg_name.png"/>发布者真实姓名：</td>
							<td>
								<input type="text" class="s_t_text" name="nickname" value="" required >
							</td>
						</tr>
						<tr>
							<td class="for"><img src="image/meg_sex.png"/>类别：</td>
							<td><select id='suptype' name = "suptypeid" onchange="changesup()" style="width:100px">
							
	</select><select id='subtype' name = "subtypeid" style="width:100px">
		<option value="1">全部</option>
	</select>
	</td>
	
						</tr>
						<tr>
						<td class="for"><img src="image/sec_new.png"/>新旧：</td>
						<td>
						<input type="radio" tabindex="17" name="recency" value="1" class="no_new" id="no_new" checked>非全新</input>
                            <input type="radio" tabindex="17" name="recency" value="0" class="new" id="new">全新</input>
						</td>
						</tr>
						<tr>
							<td class="for"><img src="image/sec_new.png"/>商品名：</td>
							<td>
								<input class="s_t_text"   type="text" name="goodsname" value="${sellgoodsname}" required />
							</td>
						</tr>
						<tr>
							<td class="for"><img src="image/sec_price.png"/>价格：</td>
							<td><input class="s_t_text"  type="text" name="price" value="${sellprice}"  onkeyup="checkNum(this)" />元
							</td>
						</tr>
						<tr>
							<td class="for"><img src="image/sec_write.png"/>推荐理由：</td>
							<td><input class="s_t_text"  type="text" name="reason" maxlength="9"  value="${sellreason}" required/>
							</td>
						</tr>
						<tr>
						<td class="for"><img src="image/sec_way.png"/>交易方式：</td>
						<td>
                            <input type="radio" name="way" checked>见面交易</input>
						</td>
						</tr>
						<tr>
							<td class="for"><img src="image/sec_img.png"/>商品主图片：</td>
							<td><input type="file" name="upload" onchange="fileChange(this,upload);" required /> <span style="color:gray;font-size:12px;">图片大小不得大于2M，推荐图片大小为320px*366px</span>
						</td>
					  </tr>
					  <tr>
							<td class="for"><img src="image/sec_img.png"/>商品其他图片1：</td>
							<td><input type="file" name="upload1" onchange="fileChange(this,upload1);" /><span style="color:gray;font-size:12px;">图片大小不得大于2M，推荐图片大小为320px*366px</span>
						</td>
					  </tr>
					  <tr>
							<td class="for"><img src="image/sec_img.png"/>商品其他图片2：</td>
							<td><input type="file" name="upload2" onchange="fileChange(this,upload2);" /><span style="color:gray;font-size:12px;">图片大小不得大于2M，推荐图片大小为320px*366px</span>
						</td>
					  </tr>
					  <tr>
							<td class="for"><img src="image/sec_img.png"/>商品其他图片3：</td>
							<td><input type="file" name="upload3" onchange="fileChange(this,upload3);" /><span style="color:gray;font-size:12px;">图片大小不得大于2M，推荐图片大小为320px*366px</span>
						</td>
					  </tr>
						<tr>
						<td class="for"><img src="image/meg_addr.png"/>所在地：</td>
						<td>
						<div class="input-prepend">
							<span class="add-on">学校</span> 
							<select class="address" style="width:195px" name="school" id="sch" onchange="changeSch()" required>
							<option value="${userschool}">当前：<script>selectschool('${userschool}')</script></option>
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
							<option value="${living}">当前：<script>selectliving('${living}')</script></option>
							</select>
						</div>
						</td>
						</tr>
						<tr>
							<td class="for"><img src="image/meg_email.png"/>QQ：</td>
							<td>
								<input class="s_t_text"  type="text" name="qq" value="${sellqq}" required />
							</td>
						</tr>
						<tr>
							<td class="for"><img src="image/meg_pho.png"/>手机号：</td>
							<td>
								<input class="s_t_text"  type="text" name="telephone" value="${telephone}" required/>
							</td>
						</tr>
						
					  <tr>
							<td class="for"><img src="image/sec_write.png"/>商品介绍：<br><span id="show_example" onclick="example.style.display='block'">示例</span><br>
							<ol id="example">
							<li>使用时长： 例如 - 2011购买使用至今，已经有两年时间</li>
							<li>新旧程度描述： 例如 - 保护得很好，基本没有什么硬伤</li>
							<li>存在的问题： 例如 - 完好，没有任何问题</li>
							<li>到手时间/有效期/适用条件： 例如 - 2012年买的，现在已经使用了一年多了</li>
							</ol></td>
							<td><textarea id="s_editor_1" rows="40" cols="40" name="introduce" value="${sellintroduce}" >${sellintroduce}
							</textarea>
							<p id="count">您当前输入了 <span class="word_count2">0</span> 个文字。<span class="word_surplus"></span></p>
							</td>
						</tr>
					<tr>
						<td class="for"><img src="image/sec_write.png" />是否上架：</td>
						<td><select id="shelves"  name="shelves"  >
									<option value="1">上架</option>
									<option value="0">下架</option>
							</select></td>
					</tr>
		</table>
		<input type="hidden" name="userid" value="${id}">
		<input type="hidden" name="username" value="${username}">
		 <button class="s_btn" type="submit" style="display:block;margin:auto"  onclick="return confirm('确定添加该二手商品吗?')" >立刻发布</button>
	</form>
	<div id="index_gotop">
        <img id="top_img" style="margin-left:20px;height:38px;width:40px;" src="image/goto_top.png" onclick="window.scrollTo(0,0)">
        <a onClick="car();"><img id="buy_car" src="image/buy_car.png"></a>
    </div>
	</div>
	</div>
	</div>
	
<script>
        KindEditor.ready(function(K) {
        	window.editor = K.create('#s_editor_1',
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
                	    'fontname', 'fontsize','forecolor', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
                	    'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                	    'insertunorderedlist', '|','image', 'emoticons',  'link' , 'unlink']
                	}
                    );
        });
</script>


</body>
</html>