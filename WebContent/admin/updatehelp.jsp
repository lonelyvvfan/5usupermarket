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
<title>修改帮助中心</title>
</head>
<body>
<p id="index9"></p>
<div id="win">
		<div id="left"></div>
		<div id="right">

			<div id="form">
		<form action="admin/adminshowHelpcenter!alterhelp" method="post"
enctype="multipart/form-data">
			
			<table class="table">
						<tr>
						<td>标题：</td>
						<td><input type = "text" name ="title"  value = "${helpCenter.title}"/></td>
						</tr>
						<tr>
							<td>内容：</td>
							<td><textarea id="editor_1" rows="40" cols="40" name="content" >${helpCenter.content}</textarea>
							<p id="count">您当前输入了 <span class="word_count2">0</span> 个文字。<span class="word_surplus"></span></p>
						</td>
					  </tr>
		</table>
		 <button class="btn" type="submit" onclick="return confirm('确定修改该帮助信息？')" >修改</button>
		 <input type="hidden" name="id" value="${helpCenter.id}" />
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