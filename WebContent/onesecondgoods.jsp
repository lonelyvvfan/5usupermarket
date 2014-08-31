<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<title></title>
 <script src="js/showgoods.js" type="text/javascript"></script>
</head>
<body>
<p id="index2"></p>
<p id="left"><img src="image/weixin1.png"/></p>
    <div id="good_main_body">

        <div id="s_center">
            <div id="center_image">
                <table>
                <tr>
                <td  colspan='4'><img style="width:320px;height:366px;" id="sec_big" src="images/secondgoods${secondgoods.savepath}" onerror="javascript:this.src='image/error.jpg'" onmouseover="show_secbig(this)" onmouseout="disshow_secbig()"></td></tr>
                    <tr>
                        <td><img src="images/secondgoods${secondgoods.savepath}" onmouseover="show(this)" onerror="javascript:this.src='image/error.jpg'"></td>
                        <td><img src="images/secondgoods${secondgoods.savepath1}" onmouseover="show(this)" onerror="javascript:this.src='image/error.jpg'"></td>
                        <td><img src="images/secondgoods${secondgoods.savepath2}" onmouseover="show(this)" onerror="javascript:this.src='image/error.jpg'"></td>
                        <td><img src="images/secondgoods${secondgoods.savepath3}" onmouseover="show(this)" onerror="javascript:this.src='image/error.jpg'"></td>
                     </tr>
                </table>
                <img style="width:415px;height:475px;" id="sec_bigsee" src="images/secondgoods${secondgoods.savepath}" onerror="javascript:this.src='image/error.jpg'">
            </div>
            <div id="center_infor">
                <p id="link">联系我</p>
                <ul class="image">
                    <li><img src="image/6.png"><p>${secondgoods.telephone}</p></li>
                    <li><img src="image/success_qq.png"><p>${secondgoods.qq}</p></li>
                </ul>
                <ul class="infor">
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <div id="center_right">
            
                <p id="goods_name">${secondgoods.goodsname}</p>
            <div class="sec_inf goods_price">
              <div class="sec1 in1">价格</div>
              <div class="sec2">&#65509;${secondgoods.price}</div>
            </div>
            <div class="sec_inf">
              <div class="sec1">发布者</div>
              <div class="sec2">${secondgoods.nickname}</div>
            </div>
            <div class="sec_inf">
                <div class="sec1">新旧程度 </div>
                <div class="sec2"><script>selectrecency('${secondgoods.recency}')</script></div>
                
            </div>
            <div class="sec_inf">
                <div class="sec1"><script>selectsecgoods_supertypes('${secondgoods.suptypeid}')</script></div>
                <div class="sec2"><script>selectsecgoods_subtypes('${secondgoods.subtypeid}')</script></div>
            </div>
            <div class="sec_inf">
                <div class="sec1">推荐理由</div>
                <div class="sec2">${secondgoods.reason}</div>
            </div>
             <div class="sec_inf">
                <div class="sec1">地址</div>
                <div class="sec2"><script>selectschool('${secondgoods.school}')</script>&nbsp;<script>selectliving('${secondgoods.living}')</script></div>
            </div>
             <div class="sec_inf">
                <div class="sec1">交易方式</div>
                <div class="sec2">当面交易</div>
            </div>
            </div>
            
        <div id="inf_foot">
            <p class="goods_main">商品详情</p>
            <div id="goods_content"><span>${secondgoods.introduce}</span></div>
        </div>
        </div>

</body>
</html>