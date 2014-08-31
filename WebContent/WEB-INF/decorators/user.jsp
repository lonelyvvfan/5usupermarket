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
<decorator:head />
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
<!-- 代码导入 -->
<meta property="wb:webmaster" content="b502ec3de03533e5" />
<meta property="qc:admins" content="122466150165530173016375" />
<meta name="baidu-site-verification" content="UY0yv8gdR4" /> 
    <link rel="stylesheet" href="style/index.css" type="text/css"/>
    <link rel="stylesheet" href="style/mainbody.css" type="text/css">
     <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
     <script type="text/javascript" src="js/keywordajax.js"></script>
    <script language="javascript" src="js/bRoundCurve1.0.js"></script>
    <script language="javascript" src="js/left_label.js"></script>
    <script type="text/javascript" src="js/check.js"></script>
    <script type="text/javascript" src="js/bar.js"></script>
     <script type="text/javascript" src="js/usergonggao.js"></script>
 <script language="javascript" type="text/javascript" src="js/Calendar.js"></script>
	 <script type="text/javascript" src="js/shoppingcarforuser.js"></script>
	 <script type="text/javascript" src="js/chrometype.js"></script>
	 <script language="javascript" type="text/javascript" src="js/selectSchool.js"></script>
	 <script language="javascript" type="text/javascript" src="js/select_type.js"></script>
	 <script type="text/javascript" src="js/show_time.js"></script>
<script type="text/javascript">

var timeout         = 100;
var closetimer		= 0;
var ddmenuitem      = 0;

// open hidden layer
function mopen(id)
{	
	// cancel close timer
	mcancelclosetime();

	// close old layer
	if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';

	// get new layer and show it
	ddmenuitem = document.getElementById(id);
	ddmenuitem.style.visibility = 'visible';

}
// close showed layer
function mclose()
{
	if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';
}

// go close timer
function mclosetime()
{
	closetimer = window.setTimeout(mclose, timeout);
}

// cancel close timer
function mcancelclosetime()
{
	if(closetimer)
	{
		window.clearTimeout(closetimer);
		closetimer = null;
	}
}

// close layer when click-out
document.onclick = mclose; 
</script>

<decorator:head />
</head>
<body  onload="active();getSeverTime()">
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
<div id="forcar"></div>
<div id="top">
    <span id="top_name"><script>selectschool('${school}')</script>  [<a href="normal/userschool.jsp" style="color: red;text-decoration: none;">切换学校</a>] </span>
    <p id="welcome">您好：<span>${username}</span></p>
    <div  id="about" onmouseout="out()">
    <p id="servertime"></p>
        <b id="wo"  onmouseover="a_way.style.visibility='visible'">关注我们</b>
      <div id="a_way" style="visibility:hidden;" >
        <a id="a_link" onmouseover="this.style.color='white';this.style.background='#f4b217'" onmouseout="this.style.color='#e99517';this.style.background=''" href="#" ><img id="a_weibo" src="image/succese_weibo.png"/>关注微博</a>
        <a id="a_link" onmouseover="this.style.color='white';this.style.background='#f4b217'" onmouseout="this.style.color='#e99517';this.style.background=''"  href="#"><img id="a_qq" src="image/success_qq.png"/>关注QQ</a>
        <a  id="a_link" onmouseover="this.style.color='white';this.style.background='#f4b217'" onmouseout="this.style.color='#e99517';this.style.background=''"  href="#"><img id="a_renren" src="image/success_renren.png"/>关注人人</a>
    </div>
    <p id="top_message">
        <a href="user/usermanage" class="m1">会员中心&nbsp;&nbsp;&nbsp;|</a>
        <a href="user/login!logout" class="m1" >登出&nbsp;&nbsp;&nbsp;|</a>
        <a href="user/ordermanage"  class="m1 ">我的订单&nbsp;&nbsp;&nbsp;|</a>
        <a href="user/secgoodsmanage!showsecgoods" class="m1">我的二手商品 </a>
    </p>
    </div>
    
</div>
<p style="clear:both;margin:0!important;padding:0!important;"></p>
<div id="head">
    <a href="user/goods.jsp" id="logo"><img src="image/logo.png"/></a>
    <div id="main">
        <div class="search">
            <form action="user/search" method="post" class="search_form">
                <input type="text" name="goodsname" value="${findgoodsname}" class="sinput" placeholder="搜一搜  省时  方便  快捷" required >
                <input type="submit" value="搜索" class="sbtn">
            </form>
        </div>
        <div id="term">
        </div>
    </div>
    <div id="main_right">
    <img id="time" src="image/right_time.png"/>

    <div id="bag">
        <a onClick="car();"><img id="bag_image" src="image/bag.png"></a>
        <p>购物袋</p>
    </div>
    </div>
</div>
<div style="clear: both"></div>                                    <!--1-->
<div id="container">
    <div id="container_top">
     <a id="wangwang" target='_blank' href='http://amos.im.alisoft.com/msg.aw?v=2&uid=%E7%9E%A7%E4%B8%80%E7%9E%A711111&site=cntaobao&s=1&charset=utf-8' ><img border=0 src='http://amos.im.alisoft.com/online.aw?v=2&uid=%E7%9E%A7%E4%B8%80%E7%9E%A711111&site=cntaobao&s=1&charset=utf-8' alt='点击这里给我发消息' /></a>
    <a  id="contact" href="tencent://message/?uin=2497537771&Site=www.5uchaoshi.com.cn&Menu=yes"><img   src="image/contect.png"></a>
          <p id="for">生活无忧</p>
        <ul id="c_top_term">
            <li style="border-bottom-color: red"><a href="user/goods.jsp" onmouseover="this.style.backgroundColor='red'" onmouseout="this.style.backgroundColor=''"> 校园超市</a></li>
            <li style="border-bottom-color: palevioletred"><a  href="user/secondgoods.jsp" onmouseover="this.style.backgroundColor='palevioletred'" onmouseout="this.style.backgroundColor=''"> 跳蚤市场</a></li>
            <li style="border-bottom-color: plum"><a href="user/takeout.jsp" onmouseover="this.style.backgroundColor='plum'" onmouseout="this.style.backgroundColor=''"> 外卖专区</a></li>
            <li style="border-bottom-color: greenyellow"><a  href="user/greatseller.jsp" onmouseover="this.style.backgroundColor='greenyellow'" onmouseout="this.style.backgroundColor=''"> 推荐商家</a></li>
        </ul>
        <a  href="user/addsecgoods.jsp"  target="_blank" id="two" class="set_green"  onmouseover="ctwo()" onmouseout="rtwo()">免费卖二手</a>
        <ul id="pho">
            <li><img style="width:32px;margin-top:-6px;" src="image/phone.png"/></li>
            <li><img src="image/tel.png" style="width:145px;"/></li>
        </ul>
    </div>

     
<decorator:body />
     
    <ul id="container_foot">
        <li><a href="#"><img src="image/qq.png"/></a></li>
        <li><a href="#"><img src="image/weibo.png"/></a> </li>
        <li><a href="#"><img src="image/renren.png"/></a> </li>
    </ul>
    </div>

<div id="footer">
    <ul id="foot_top">
        <li>配送方式</li>
        <li>购物方式</li>
        <li>加入我们</li>
        <li>帮助中心</li>
        <li>商家中心</li>
    </ul>
    <div id="foot_d">
    <ul class="foot_list">
        <li><a href="user/showHelp!view?id=2" target="_blank">配送时间/范围</a> </li>
        <li><a href="user/showHelp!view?id=6" target="_blank">网站免责声明</a> </li>
    </ul>
    <ul class="foot_list">
        <li><a href="user/showHelp!view?id=7" target="_blank">购物流程</a> </li>
        <li><a href="user/showHelp!view?id=8" target="_blank">支付方式</a> </li>
    </ul>
    <ul class="foot_list">
        <li><a href="user/showHelp!view?id=9" target="_blank">招贤纳士</a> </li>
        <li><a href="user/showHelp!view?id=10" target="_blank">业务合作</a> </li>
    </ul>
    <ul class="foot_list">
        <li><a href="user/showHelp!view?id=11" target="_blank">关于我们</a> </li>
        <li><a href="user/showHelp!view?id=12" target="_blank">消费者保障</a> </li>
    </ul>
     <ul class="foot_list">
        <li><a href="user/showHelp!view?id=16" target="_blank">商家须知</a> </li>
        <li><a href="normal/sellerlogin.jsp">商家登陆</a> </li>
    </ul>
    </div>
    <p id="foot_phone"><img id="phone" src="image/foot_phone.png"/></p>
     <span id="foot_num">Copyright @ <a href="http://www.5uchaoshi.com" target="_blank">5uchaoshi.com</a> (浙ICP备14000523号-1)   
<script type="text/javascript">
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fd22493b1a0b9acf086623118f22d15ec' type='text/javascript'%3E%3C/script%3E"));
</script>
<!-- 代码导入结束 -->
     </span>
</div>

<!--[if lte IE 7]>
<script type="text/javascript">
document.getElementById("container").innerHTML="";
alert('1');
</script>
<![endif]-->
<script type="text/javascript" src="js/fixed.js"></script>

</body>
</html>