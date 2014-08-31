<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script charset="utf-8" src="../kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh_CN.js"></script>
<title></title>
</head>
<body>
 <p id="left"><img src="image/weixin1.png"/>
        扫一扫</p>
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
                            <input type="text" name="sale_name" id="sale_name" class="txt" maxlength="30px">
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
                            <button type="button" tabindex="17" class="no_new" id="no_new">非全新</button>
                            <button type="button" tabindex="17" class="new" id="new">全新</button>
                        </div>
                    </div>

                    <div class="box box5">
                        <div class="a"> 价格</div>
                        <div class="c">
                            <input type="text" name="sale_price" id="sale_price" class="txt" maxlength="24px">
                        </div>
                    </div>
                    <div class="box box6">
                        <div class="a"> 联系方式：</div>
                        <div class="c">
                            <label><img src="image/5.png"></label>
                            <input type="text" name="contact_name" id="contact_name" class="contact" tabindex="3" maxlength="38px">
                            <label><img src="image/foot_phone.png"></label>
                            <input type="text" name="contact_tel" id="contact_tel" class="contact" tabindex="3" maxlength="38px">
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
                            <img src="#">
                            <input type="file" name="upload"/>
                            <p>最多可上传十张照片，图片每张最大5M</p>
                        </div>
                    </div>
                    <div class="box box9">
                        <div class="a"> 宝贝描述</div>
                        <div class="c">
                           <textarea id="s_editor_1" rows="10" cols="40" name="content"> </textarea>
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
<script type="text/javascript">
		//$("#clazz option[value='${method.clazz}']").attr("selected", "selected");
		//$("#overhead option[value='${method.overhead}']").attr("selected", "selected");
	</script>
	<script>
        KindEditor.ready(function(K) {
                window.editor = K.create('#s_editor_1');
        });
</script>
</body>
</html>