<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title></title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
  <div id="main_body">
        <p id="left"><img src="image/weixin1.png"/></p>
    <div id="container_center">


            <div class="success_one">
                <div class="s1">
                    <img src="image/success.png">
                    <p>订单提交成功<a href="#">查看订单详情</a></p>

                </div>
                <div class="s2">
                    <p>订单将在<span>${arrivedday} 
                    <script>selectarrivedtime('${arrivedtime}')</script>
                    
                    </span>内精确送达，请保持电话畅通：）<a href="#">了解配送说明</a></p>
                </div>
                <br /><br />
                <div class="s3">
                    <ul>
                        <li><a href="#"><img src="image/success_zone.png"></a></li>
                        <li><a href="#"><img src="image/success_renren.png"></a></li>
                        <li><a href="#"><img src="image/succese_weibo.png"></a></li>
                        <li><a href="#"><img src="image/succese_plause.png"></a></li>
                        <li><a href="#"><img src="image/success_5.png"></a></li>
                        <li><a href="#"><img src="image/success_6.png"></a></li>
                        <li><p>把本次订购分享给好友，好友订购成功后100%返</p></li>
                    </ul>
                </div>
            </div>
        <div id="gotop">
            <img  src="image/goto_top.png">
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

</body>
</html>