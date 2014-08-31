<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title></title>
<head>
<script language="javascript" src="js/imagesize.js"></script>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
<script language="javascript" src="js/sellsec_check.js"></script>
</head>
<body>
 <p id="left"><img src="image/weixin1.png"/></p>
    <div id="main_body">
    <div id="container_center">


        <div id="sale">
            <p id="sale_top">今天您有什么闲置宝贝想要出售</p>
            <div id="right_form">
                <h4>
                    <span>发布闲置</span>
                </h4>
                <form>
                    <div class="box box2">
                        <div class="a"> 标题：</div>
                        <div class="c">
                            <input type="text" name="sale_name" id="sale_name" class="txt" maxlength="30px" required>
                        </div>
                    </div>

                    <div class="box box3">
                        <div class="a"> 类目</div>
                        <div class="c">
                            <select>
                                <option>请选择</option>
                                <option>请选择</option>
                                <option>请选择</option>
                                <option>请选择</option>
                            </select>
                        </div>
                    </div>

                    <div class="box box4">
                        <div class="a">新旧</div>
                        <div class="c">
                           <input type="radio" tabindex="17" name="new" class="no_new" id="no_new">非全新</input>
                            <input type="radio" tabindex="17" name="new" class="new" id="new">全新</input>
                        </div>
                    </div>

                    <div class="box box5">
                        <div class="a"> 价格</div>
                        <div class="c">
                            <input type="number" name="sale_price" id="sale_price" class="txt" maxlength="24px" required>
                        </div>
                    </div>
                    <div class="box box6">
                        <div class="a"> 联系方式：</div>
                        <div class="c">
                            <label><img src="image/5.png"></label>
                            <input type="text" name="contact_name" id="contact_name" class="contact" tabindex="3" maxlength="38px" required>
                            <label><img src="image/foot_phone.png"></label>
                            <input type="text" name="contact_tel" id="contact_tel" class="contact" tabindex="3" maxlength="38px"  required onblur="checkmobile()" >
                            <label><img src="image/success_qq.png"></label>
                            <input type="text" name="contact_qq" id="contact_qq" class="contact" tabindex="3" maxlength="38px">
                        </div>
                    </div>
                    <div class="box box7">
                        <div class="a"> 所在地</div>
                        <div class="c">
                            <p>浙江杭州市江干区</p>
                            <select name="sale_addr" id="sale_addr" class="sale_addr" tabindex="13">
                                <option value="1">浙江工商大学</option>
                                <option value="1">浙江工商大学</option>
                                <option value="1">浙江工商大学</option>
                                <option value="1">浙江工商大学</option>
                                <option value="1">浙江工商大学</option>
                            </select>

                        </div>
                    </div>

                    <div class="box box8">
                        <div class="a"> 宝贝图片</div>
                        <div class="c">
                           <input type="file" id="upload" name="upload" onchange="fileChange(this,upload);" />
                        </div>
                    </div>
                    <div class="box box9">
                        <div class="a"> 宝贝描述</div>
                        <div class="c">
                             <textarea id="editor_1" rows="10" cols="40"
									name="introduce"></textarea>
                        </div>
                    </div>
                    <div class="box box10">
                        <div class="a"></div>
                        <div class="c">
                            <button type="submit">立刻发布</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div style="clear: both"></div>
    </div>
<script>
		KindEditor.ready(function(K) {
			window.editor = K.create('#editor_1',{ resizeType : 1,
        	    allowPreviewEmoticons : false,
        	    allowUpload : true,
        	    items : [
        	    'fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
        	    'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
        	    'insertunorderedlist', '|', 'emoticons',  'link' , 'unlink']
        });
		});
	</script>
</body>
</html>