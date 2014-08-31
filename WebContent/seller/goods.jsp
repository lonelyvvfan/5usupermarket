<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title></title>
<head>
	<script language="javascript" src="js/jquery-1.7.2.min.js"></script>
	<script language="javascript" src="js/ajax.js"></script>
	<script type="text/javascript" src="js/foucus.js"></script>
    <script type="text/javascript" src="js/AnchorArt.js"></script>
</head>
<body>
 <div id="main_body">                                   <!--1-->
    <div id="container_slider">
        <div id="left">
            <img src="image/weixin1.png"/>
            <p>扫一扫</p>
        </div>
         <div id="slider">
                <ul>
                    <li><a href="#"><img src="image/slider.png"/></a></li>
                    <li><a href="#"><img src="image/slider.png"/></a></li>
                    <li><a href="#"><img src="image/slider.png"/></a></li>
                    <li><a href="#"><img src="image/slider.png"/></a></li>
                    <li><a href="#"><img src="image/slider.png"/></a></li>
                </ul>
            </div>
        <div id="right">

            <img src="image/right.png">
            <table>
                 <tr class="firstline">
                    <td id="gonggao" onmouseover="out1()">公告</td>
                    <td id="wuyou" onmouseover="out2()">了解无忧</td>
                </tr>
                <tr><td id="right_table_content" colspan="2" rowspan="2">公告1：<br> 公告2:</td></tr>
            </table>
        </div>
    </div>
    <div id="right_sort">
        <table>
            <tr style="background-color:#5dc3e4"><td><a href="seller/goods.jsp#1F">进口零食</a></td></tr>
            <tr style="background-color:#f4b217"><td><a href="seller/goods.jsp#2F">水果专区</a></td></tr>
            <tr style="background-color:#9ac949"><td><a href="seller/goods.jsp#3F">休闲素食</a></td></tr>
            <tr style="background-color:#cd508c"><td><a href="seller/goods.jsp#4F">乳品饮料</a></td></tr>
            <tr style="background-color:#9ac949"><td><a href="seller/goods.jsp#5F">生活用品</a></td></tr>
            <tr style="background-color:#f4b217"><td><a href="seller/goods.jsp#6F">办公数码</a></td></tr>
            <tr style="background-color:#5dc3e4"><td><a href="seller/goods.jsp#7F">其它专区</a></td></tr>
        </table>
    </div>


    <div id="container_sort">
    <div class="sort">
        <table id="first_line">
            <tr>
                <td onmouseover="this.bgColor='#e99518';this.style.color='#FFF'" onmouseout="this.bgColor='';this.style.color='black'">无忧推荐</td>
                <td onmouseover="this.bgColor='#e99518';this.style.color='#FFF'" onmouseout="this.bgColor='';this.style.color='black'">套餐专区</td>
                <td onmouseover="this.bgColor='#e99518';this.style.color='#FFF'" onmouseout="this.bgColor='';this.style.color='black'">营养系列</td>
                <td onmouseover="this.bgColor='#e99518';this.style.color='#FFF'" onmouseout="this.bgColor='';this.style.color='black'">热销系列</td>
                <td onmouseover="this.bgColor='#e99518';this.style.color='#FFF'" onmouseout="this.bgColor='';this.style.color='black'">特价促销</td>
                <td onmouseover="this.bgColor='#e99518';this.style.color='#FFF'" onmouseout="this.bgColor='';this.style.color='black'">最新上架</td>
            </tr>
        </table>
        <ul class="front">
            <li>
            <a href="onegoods.jsp">
                <img src="image/goods.png">
            </a>
                <p>
                    <b class="price">
                        &#65509; 1.2
                    </b>
                    <strike>&#65509;2</strike>
                    <button>购买</button>
                </p>
                <h3>确找无忧食品</h3>

            </li>

        </ul>
        <p style="clear: both"></p>
        <table class="index">
            <tr>
                <td class="hover">1</td>
                <td>2</td>
                <td>3</td>
                <td>更多>></td></tr>
        </table>

    </div>

        <div name="1F" class="sort" >
            <h2 id="1F" style="border-color: rgb(221,197,70)">
                <span style="color: cornflowerblue">进口食品</span>
                <p style="background-color: #e99518">
                    <b>零食进口</b>
                    <b>饮料</b>
                    <b>其它</b>
                </p>
            </h2>
            <ul class="so"></ul>
            <ul class="front">
                <li><img src="image/sort_left.png"></li>
                <li>
                    <a href="onegoods.jsp">
                        <img src="image/goods.png">
                    </a>
                    <p>
                        <b class="price">
                            &#65509; 1.2
                        </b>
                        <strike>&#65509;2</strike>
                        <button>购买</button>
                    </p>
                    <h3>确找无忧食品</h3>

                </li>

            </ul>
            <p style="clear: both"></p>
            <table class="index">
                <tr>
                <td class="hover">1</td>
                <td>2</td>
                <td>3</td>
                <td>更多>></td></tr>
            </table>
        </div>
        <div class="sort">
            <h2 id="2F" style="border-color: rgb(221,197,70)">
                <span style="color: #e99b0f">水果专区</span>
                <p style="background-color: #e99518">
                    <b>苹果</b>
                    <b>香蕉</b>
                    <b>梨</b>
                    <b>其它</b>
                </p>
            </h2>
            <ul class="so"></ul>
            <ul class="front">
                <li><img src="image/sort_left.png"></li>
                <li>
                    <a href="onegoods.jsp">
                        <img src="image/goods.png">
                    </a>
                    <p>
                        <b class="price">
                            &#65509; 1.2
                        </b>
                        <strike>&#65509;2</strike>
                        <button>购买</button>
                    </p>
                    <h3>确找无忧食品</h3>

                </li>

            </ul>
            <p style="clear: both"></p>
            <table class="index">
                <tr>
                    <td class="hover">1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>更多>></td></tr>
            </table>
        </div>
        <div class="sort">
            <h2 id="3F" style="border-color: rgb(221,197,70)">
                <span style="color: #99c94d">休闲素食</span>
                <p style="background-color: #e99518">
                    <b>零食</b>
                    <b>方便面</b>
                    <b>其它</b>
                </p>
            </h2>
            <ul class="so"></ul>
            <ul class="front">
                <li><img src="image/sort_left.png"></li>

                <li>
                    <a href="onegoods.jsp">
                        <img src="image/goods.png">
                    </a>
                    <p>
                        <b class="price">
                            &#65509; 1.2
                        </b>
                        <strike>&#65509;2</strike>
                        <button>购买</button>
                    </p>
                    <h3>确找无忧食品</h3>

                </li>

            </ul>
            <p style="clear: both"></p>
            <table class="index">
                <tr>
                    <td class="hover">1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>更多>></td></tr>
            </table>
        </div>
        <div class="sort">
            <h2 id="4F" style="border-color: rgb(221,197,70)">
                <span style="color: #f3b418">乳品饮料</span>
                <p style="background-color: #e99518">
                    <b>奶制品</b>
                    <b>饮料</b>
                    <b>水</b>
                    <b>其它</b>
                </p>
            </h2>
            <ul class="so"></ul>
            <ul class="front">
                <li><img src="image/sort_left.png"></li>

                <li>
                    <a href="onegoods.jsp">
                        <img src="image/goods.png">
                    </a>
                    <p>
                        <b class="price">
                            &#65509; 1.2
                        </b>
                        <strike>&#65509;2</strike>
                        <button>购买</button>
                    </p>
                    <h3>确找无忧食品</h3>

                </li>

            </ul>
            <p style="clear: both"></p>
            <table class="index">
                <tr>
                    <td class="hover">1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>更多>></td></tr>
            </table>
        </div>

        <div class="sort">
            <h2 id="5F" style="border-color: rgb(221,197,70)">
                <span style="color:#66c3e5">生活用品</span>
                <p style="background-color: #e99518">
                    <b>纸制品</b>
                    <b>美容</b>
                    <b>洗护</b>
                    <b>其它</b>
                </p>
            </h2>
            <ul class="so"></ul>
            <ul class="front">
                <li><img src="image/sort_left.png"></li>

                <li>
                    <a href="onegoods.jsp">
                        <img src="image/goods.png">
                    </a>
                    <p>
                        <b class="price">
                            &#65509; 1.2
                        </b>
                        <strike>&#65509;2</strike>
                        <button>购买</button>
                    </p>
                    <h3>确找无忧食品</h3>

                </li>

            </ul>
            <p style="clear: both"></p>
            <table class="index">
                <tr>
                    <td class="hover">1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>更多>></td></tr>
            </table>
        </div>
        <div class="sort">
            <h2 id="6F" style="border-color: rgb(221,197,70)">
                <span style="color: #cc598f">办公数码</span>
                <p style="background-color: #e89711">
                    <b>电子数码</b>
                    <b>办公文具</b>
                    <b>其它</b>
                </p>
            </h2>
            <ul class="so"></ul>
            <ul class="front">
                <li><img src="image/sort_left.png"></li>

                <li>
                    <a href="onegoods.jsp">
                        <img src="image/goods.png">
                    </a>
                    <p>
                        <b class="price">
                            &#65509; 1.2
                        </b>
                        <strike>&#65509;2</strike>
                        <button>购买</button>
                    </p>
                    <h3>确找无忧食品</h3>

                </li>


            </ul>
            <p style="clear: both"></p>
            <table class="index">
                <tr>
                    <td class="hover">1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>更多>></td></tr>
            </table>
        </div>
    <div id="gotop">
        <img style="margin-left=20px;" src="image/goto_top.png" onclick="window.scrollTo(0,0)">
        <a href="seller/car.jsp"><img id="buy_car" src="image/buy_car.png"></a>
    </div>
        <div class="sort">
            <h2 id="7F" style="border-color: rgb(221,197,70)">
                <span style="color: #e89711">其它专区</span>
                <p style="background-color: #e99518">
                    <b>      </b>
                    <b>      </b>
                    <b>      </b>
                    <b>       </b>
                </p>
            </h2>
            <ul class="front last">
            </ul>
            <p style="clear: both"></p>
        </div>
    </div>

</body>
</html>