<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="style/other.css" type="text/css"/>
 <title>校区选择</title>
 
</head>
<body >
<div id="school">
    <div id="logo">
        <a href="goods.jsp"><img src="image/logo.png"></a>
    </div>
    <div id="wuyou">
        <p style="color: green;font-weight: bold">因为<span style="color: red;font-weight: bold">5</span>优   所以无忧</p>
    </div>
    <div class="school">
        <a href="setschool?id=0"><img class="gong" src="image/gongshang.png">
        </a>
        <b id="gongshang">浙江工商大学</b>
        <a href="setschool?id=1"><img class="cai" src="image/zhecai.png" >
        </a>
        <b id="zhecai">浙江财经大学</b>
        <a href="setschool?id=2"><img class="ji" src="image/zhongguojiliang.png" >
        </a>
        <b id="zhongguojiliang">中国计量学院现代科技学院</b>
        <a href="setschool?id=3"><img class="hangshi" src="image/hangshi.png">
        </a>
        <b id="hangshi">杭州师范大学</b>
        <a href="setschool?id=4"><img class="jingmao" src="image/jingmaozhiye.png">
        </a>
        <b id="jingmaozhiye">浙江经贸职业技术学院</b>
        <a href="setschool?id=5"><img class="jingrong" src="image/jingrongzhiye.png" >
        </a>
        <b id="jingrongzhiye">浙江金融职业技术学院</b>
        <a href="setschool?id=6"><img class="shuili" src="image/shuilishuidian.png">
        </a>
        <b id="shuilishuidian">浙江水利水电学院</b>
        <a href="setschool?id=7"><img class="jingji" src="image/jingjizhiye.png" >
        </a>
        <b id="jingjizhiye">浙江经济职业技术学院</b>
    </div>
    </div>
</body>
</html>