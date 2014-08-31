<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title></title>
<meta http-equiv="Expires" CONTENT="0">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">

<head>
<script language="javascript" src="js/goodnum.js"></script>
<script language="javascript" src="js/showgoods.js"></script>
<script type="text/javascript" src="js/keywordajax.js"></script>
<script language="javascript" src="js/ajax.js"></script>
</head>
<body>
    <script>
    function alterflag()
    {
        document.getElementById("flag").value="0";
    }
    </script>
    <p id="index1"></p>
 <p id="left"><img src="image/weixin1.png"/></p>
    <div id="good_main_body">

    <div id="information">
        <div id="information_img">
        <img id="big" src="images/goods${goods.savepath}" onerror="javascript:this.src='image/error.jpg'" onmouseover="show_big(this)" onmouseout="disshow_big()">
         <img id="bigsee" src="#" onerror="javascript:this.src='image/error.jpg'">
        <ul>
            <li><img src="images/goods${goods.savepath}" onerror="javascript:this.src='image/error.jpg'" onmouseover="good_show(this)"></li>
            <li><img src="images/goods${goods.savepath1}" onerror="javascript:this.src='image/error.jpg'" onmouseover="good_show(this)"></li>
            <li><img src="images/goods${goods.savepath2}" onerror="javascript:this.src='image/error.jpg'" onmouseover="good_show(this)"></li>
            <li><img src="images/goods${goods.savepath3}" onerror="javascript:this.src='image/error.jpg'" onmouseover="good_show(this)"></li>
        </ul>
        </div>
        <div id="main_information">
            <p id="goods_name">${goods.goodsname}</p>
            <div class="box_inf goods_price">
              <div class="in1">价格</div>
              <div class="in2">&#65509;${goods.nowprice}</div>
            </div>
            <div class="box_inf">
              <div class="in1">原价</div>
              <div class="in2"><strike>&#65509;${goods.price}</strike></div>
            </div>
            <div class="box_inf">
                <div class="in1"><script>selectgoods_supertypes('${goods.suptypeid}')</script> </div>
                <div class="in2"><script>selectgoods_subtypes('${goods.subtypeid}')</script></div>
                
            </div>
            <div class="box_inf">
                <div class="in1">推荐理由</div>
                <div class="in2">${goods.reason}</div>
            </div>
            <div class="box_inf">
            <div class="in1 zan">
                    <form action = "showGoods!dianzan?id=${goods.id}" method="post">
                    <input type="submit"  id="dianzan" class="btn btn-danger" value="赞" />
                    </form>
                    </div>
             <div class="in2">
                <table>
                    <tr>
                        <td><span style="color: #f6bd52;font-weight: bold">${goods.monthsell}</span><p>月销量</p></td>
                        
                        <td><span style="color: red ;font-weight: bold">${goods.zan}</span><p>被赞次数</p></td>
                        
                    </tr>
                </table>
                </div>
            </div>
           
            <div class="box_inf">
                <div class="in1">购买数</div>
                <div class="in2">
                    <button type="button" tabindex="2" class="reduce btn" id="reduce" onclick="delese(${goods.inventory})" >-</button>
                    <input type="text"  name="number" id="good_num" class="thing_num goods_num" tabindex="3" value="1" maxlength="3px" onchange="goodnum(${goods.inventory})">
                    <button type="button" tabindex="2" class="plus btn" id="plus" onclick="add(${goods.inventory})" >+</button>
                    <span id="inventory">库存${goods.inventory}件</span>
                </div>
            </div>
            <div class="box_inf">
                <div class="in2">
                	<input type="hidden" value="1" id="flag" name="flag"/>
                    <input type="submit" tabindex="17" class="in_b" onclick="buy_incar(${goods.id})" value="加入购物车">
                </div>
            </div>
        </div>
        <div id="inf_foot">
            <p class="goods_main">商品详情</p>
            <div id="goods_content"><span>${goods.introduce}</span></div>
        </div>
        <div id="gotop"></div>
        <div id="index_gotop">
        <img id="top_img"  style="margin-left:20px;height:38px;width:40px;" src="image/goto_top.png" onclick="window.scrollTo(0,0)">
        <a onClick="car();"><img id="buy_car" src="image/buy_car.png"></a>
    </div>
        </div>
</body>
</html>