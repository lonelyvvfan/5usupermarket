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
                    <div style="background-color: gainsboro;width: 160px;height: 30px;top:0px;left:-2px;position: absolute">
                        <p class="int_text">超市公告    </p>
                    </div>
                </div>
                <div id="int_right">
                    <p id="title">${notice.title}</p>
                    <p id="article">${notice.content}</p>
                </div>
            </div>
        
</body>
</html>