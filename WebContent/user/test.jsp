<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>thickbox</title>
<head>
	<style type="text/css" media="all">
		@import "style/thickbox.css";
	</style>
	 <script language="javascript" src="js/jquery-1.7.2.min.js"></script>
	 <script src="js/thickbox-compressed.js" type="text/javascript"></script>
	 <script type="text/javascript" src="js/shoppingcar.js"></script>
</head>
<body>
	<a href="shoppingcar.jsp;TB_iframe=true&amp;height=300&amp;width=500" title="订单" class="thickbox">test</a>
	<a  onClick="sAlert();" ><img id="buy_car" src="image/buy_car.png"></a>
</body>
</html>