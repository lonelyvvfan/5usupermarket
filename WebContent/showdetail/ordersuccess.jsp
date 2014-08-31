<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
 <style type="text/css">body{width:100%}</style>
    <title></title>
    <script type="text/javascript" src="js/left_label.js"></script>
   
</head>
<body style="width:100%">
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
        var str='您正在使用 Internet Explorer 7或Internet Explorer 7以下版本， Internet Explorer版本过低，在本页面的显示效果可能有差异。建议您升级到 <a href='+'"http://www.microsoft.com/china/windows/internet-explorer/"'+' target='+'"_blank"'+'>Internet Explorer 11</a> 或以下浏览器： <a href='+'"http://www.mozillaonline.com/"'+'>Firefox</a> / <a href='+'"http://www.google.com/chrome/?hl=zh-CN"'+'>Chrome</a> / <a href="'+'http://www.apple.com.cn/safari/"'+'>Safari</a> / <a href='+'"http://www.operachina.com/"'+'>Opera</a>;';
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
            <div class="success_one">
                <div class="s1">
                    <img src="image/success.png">
                    <p>订单提交成功</p>
					<p><span id="ordernum">请牢记您的订单号:${ordernum}
					<br></span></p>
					<h3>这是您查询您商品配送信息的凭证！</h3>
                </div>
                <div class="s2">
                    <p>订单将在<span>${arrivedday} 
                    <script>selectarrivedtime('${arrivedtime}')</script>
                    
                    </span>内精确送达，请保持电话畅通：）
                    <br/>
                    <a href="showHelp!view?id=2" target="_blank">了解配送说明</a></p>
                </div>
                <br /><br />
                <div class="s3">
                    <ul>
                        <li><a href="#" target="_blank"><img src="image/success_zone.png"></a></li>
                        <li><a href="#" target="_blank"><img src="image/success_renren.png"></a></li>
                        <li><a href="#" target="_blank"><img src="image/succese_weibo.png"></a></li>
                        <li><a href="#" target="_blank"><img src="image/succese_plause.png"></a></li>
                        <li><a href="#" target="_blank"><img src="image/success_5.png"></a></li>
                        <li><a href="#" target="_blank"><img src="image/success_6.png"></a></li>
                        <li><p>把本次订购分享给好友，惊喜不断，折扣不断。</p></li>
                    </ul>
                </div>
        <!-- 
            <div class="success_two">
                <p>本次消费成功后您将获得<span>28</span>消费积分，对本单每个商品评价将获得<span>2</span>消费积分</p>
                <ul class="prog_num">
                    <li class="p1">800</li>
                    <li class="p2">1000</li>
                    <li class="p3">1570</li>
                </ul>
                <progress class="prog" value="70" max="100"></progress>
            </div>
             -->
    </div>
<script type="text/javascript">

</script>
</body>
</html>