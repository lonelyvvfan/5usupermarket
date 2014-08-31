
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9;IE=8;IE=7;IE=EDGE"> 
<title><decorator:title default="无忧超市网" /></title>
<link rel="shortcut icon" href="image/favicon.ico">
<link rel="Bookmark" href="static/image/favicon.ico">
<meta name="author" content="tidweb">
<meta name="Copyright" content="版权信息">
<meta name="description" content="站点介绍">
<meta name="keywords" content="下沙大学城东区，下沙高教东区校园网络超市，送货上门，货到付款，安全，放心。外卖，吃货，二手交易平台，跳蚤市场，下沙学生购物一条街。">
    <link rel="stylesheet" href="style/other.css" type="text/css"/>
<link rel="stylesheet" href="style/bootstrap.css" />
<decorator:head />
</head>
<body>
<!--[if lte IE 7]>
<div id="ie6-warning">您正在使用 Internet Explorer 7或Internet Explorer 7以下版本，在本页面的显示效果可能有差异。建议您升级到 <a href="http://www.microsoft.com/china/windows/internet-explorer/" target="_blank">Internet Explorer 11</a> 或以下浏览器： <a href="http://www.mozillaonline.com/">Firefox</a> / <a href="http://www.google.com/chrome/?hl=zh-CN">Chrome</a> / <a href="http://www.apple.com.cn/safari/">Safari</a> / <a href="http://www.operachina.com/">Opera</a>
</div>
<script type="text/javascript">
    function position_fixed(el, eltop, elleft){
        // check if this is IE6
        if(!window.XMLHttpRequest)
            window.onscroll = function(){
                el.style.top = (document.documentElement.scrollTop + eltop)+"px";
                el.style.left = (document.documentElement.scrollLeft + elleft)+"px";
            }
        else el.style.position = "fixed";
    }
    function sAlert(){
        var str='您正在使用 Internet Explorer 7或Internet Explorer 7以下版本，在本页面的显示效果可能有差异。建议您升级到 <a href='+'"http://www.microsoft.com/china/windows/internet-explorer/"'+' target='+'"_blank"'+'>Internet Explorer 11</a> 或以下浏览器： <a href='+'"http://www.mozillaonline.com/"'+'>Firefox</a> / <a href='+'"http://www.google.com/chrome/?hl=zh-CN"'+'>Chrome</a> / <a href="'+'http://www.apple.com.cn/safari/"'+'>Safari</a> / <a href='+'"http://www.operachina.com/"'+'>Opera</a>;<br/><br/>若为360/搜狗/猎豹等浏览器请切换到极速模式.';
        var msgw,msgh,bordercolor;
        msgw=400;//提示窗口的宽度
        msgh=100;//提示窗口的高度
        titleheight=25 //提示窗口标题高度
        bordercolor="#c51100";//提示窗口的边框颜色
        titlecolor="#c51100";//提示窗口的标题颜色

        var sWidth,sHeight;
        sWidth=screen.width;
        sHeight=screen.height;

        var bgObj=document.createElement("div");
        bgObj.setAttribute('id','bgDiv');
        bgObj.style.position="absolute";
        bgObj.style.top="0";
        bgObj.style.background="#cccccc";
        bgObj.style.left="0";
        bgObj.style.width=sWidth + "px";
        bgObj.style.height=sHeight + "px";
        bgObj.style.zIndex = "10000";
        document.body.appendChild(bgObj);

        var msgObj=document.createElement("div")
        msgObj.setAttribute("id","msgDiv");
        msgObj.setAttribute("align","center");
        msgObj.style.background="white";
        msgObj.style.border="1px solid " + bordercolor;
        msgObj.style.position = "absolute";
        msgObj.style.left = "40%";
        msgObj.style.top = "50%";
        msgObj.style.font="20px Verdana, Geneva, Arial, Helvetica, sans-serif";
        msgObj.style.marginLeft = "-225px" ;
        msgObj.style.marginTop = -75+document.documentElement.scrollTop+"px";
        msgObj.style.width = msgw+400 + "px";
        msgObj.style.height =msgh +100+ "px";
        msgObj.style.textAlign = "center";
        msgObj.style.lineHeight ="25px";
        msgObj.style.zIndex = "10001";

        var title=document.createElement("h4");
        title.setAttribute("id","msgTitle");
        title.setAttribute("align","right");
        title.style.margin="0";
        title.style.padding="3px";
        title.style.background=bordercolor;
        title.style.filter="progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
        title.style.opacity="0.75";
        title.style.border="1px solid " + bordercolor;
        title.style.height="18px";
        title.style.font="12px Verdana, Geneva, Arial, Helvetica, sans-serif";
        title.style.color="white";
        title.style.cursor="pointer";
        document.body.appendChild(msgObj);
        document.getElementById("msgDiv").appendChild(title);
        var txt=document.createElement("p");
        txt.style.margin="1em 0"
        txt.setAttribute("id","msgTxt");
        txt.innerHTML=str;
        document.getElementById("msgDiv").appendChild(txt);
    }

    position_fixed(document.getElementById("ie6-warning"),0, 0);
    sAlert();
</script>
<![endif]-->
<decorator:body />
     


</body>
</html>