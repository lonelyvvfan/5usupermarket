<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title></title>
</head>
<body>
<div id="left">
            <img src="image/weixin1.png"/>
        </div>
<div id="main_body">
            <div id="int_center">
                <div id="int_left">
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:50px;left:-2px;">
                        <p>  <a class="int_text" href="showHelp!view?id=2" target="show">配送时间/范围</a>     </p>
                    </div>
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:48px;left:-2px;position: absolute">
                        <p>  <a class="int_text" href="showHelp!view?id=6" target="show">网站免责声明</a>     </p>
                    </div>
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:95px;left:-2px;position: absolute">
                        <p>  <a class="int_text" href="showHelp!view?id=7" target="show">购物流程</a>     </p>
                    </div>
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:140px;left:-2px;position: absolute">
                        <p>  <a class="int_text" href="showHelp!view?id=8" target="show">支付方式</a>     </p>
                    </div>
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:186px;left:-2px;position: absolute">
                        <p>  <a class="int_text" href="showHelp!view?id=9" target="show">招贤纳士</a>     </p>
                    </div>
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:230px;left:-2px;position: absolute">
                        <p>  <a class="int_text" href="showHelp!view?id=10" target="show">业务合作</a>     </p>
                    </div>
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:274px;left:-2px;position: absolute">
                        <p>  <a class="int_text" href="showHelp!view?id=11" target="show">关于我们</a>     </p>
                    </div>
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:317px;left:-2px;position: absolute">
                        <p>  <a class="int_text" href="showHelp!view?id=12" target="show">消费者保障</a>     </p>
                    </div>
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:358px;left:-2px;position: absolute">
                        <p>  <a class="int_text" href="showHelp!view?id=15" target="show">了解无忧</a>     </p>
                    </div>
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:398px;left:-2px;position: absolute">
                        <p>  <a class="int_text" href="showHelp!view?id=16" target="show">商家须知</a>     </p>
                    </div>
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:438px;left:-2px;position: absolute">
                        <p>  <a class="int_text" href="showHelp!view?id=17" target="show">合作招商</a>     </p>
                    </div>
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:478px;left:-2px;position: absolute">
                        <p>  <a class="int_text" href="showHelp!view?id=18" target="show">用户须知</a>     </p>
                    </div>
                </div>
                <div id="int_right">
                    <p id="title">${helpCenter.title}</p>
                    <p id="article">${helpCenter.content}</p>
                </div>
            </div>
        
</body>
</html>