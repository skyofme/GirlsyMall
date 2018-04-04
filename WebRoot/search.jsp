<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'search.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/index.css"/>
    <script type="text/javascript">
    function loginCheck(loginState,role){
    	if(loginState != "true"){
    		alert("您还未登录哟");
	 		return false;
    	}
    	else{
	    	if(role=="admin"){
	    		alert("请用您的会员账号登录吧QwQ");
		 		return false;
	    	}else{
		    	console.log(loginState);
	    		document.getElementById("gotoShopppingCar").submit();
	    	}
    	}
    }
    
    </script>
  </head>
  
  <body>
    <!--search部分start-->
	<div class="w search clearfix">
	    <div class="search-logo">
	        <a href="http://www.jd.com" class="logo-a" target="_parent" title="京西正品">京西</a>
	        <a href="#" class="jd-db11" target="_parent">
	            <img src="images/dong.gif"/>
	        </a>
	    </div>
	    <form action="/mall/SearchGoodsListServlet" method="post" target="_parent">
		    <div class="search-input">
		        <input type="text" name="searchName"  id="search-input-text"/>
		        <label for="search-input-text"  id="search-input-label">食品</label>
		        <button>搜索</button>
		    </div>
	    </form>
	    <div class="search-car">
	        <a href="/mall/MyShoppingCarServlet?op=sea" target="_parent" onclick="return loginCheck('${loginState}','${role}');">我的购物车</a>
	        <i class="search-car-icon1"></i>
	        <i class="search-car-icon2">&gt;</i>
	        <i class="search-car-icon3">${CarCnt}</i>
	    </div>
	    <div class="search-more">
	        <a href="#" class="col-red" target="_parent">领红包</a>
	        <a href="#" target="_parent">买1赠1</a>
	        <a href="#" target="_parent">感恩钜惠</a>
	        <a href="#" target="_parent">珠宝箱包</a>
	        <a href="#" target="_parent">5折好货</a>
	        <a href="#" target="_parent">帮宝适</a>
	        <a href="#" target="_parent">电脑桌</a>
	        <a href="#" target="_parent">乐视</a>
	        <a href="#" target="_parent">投影仪</a>
	    </div>
	</div>
	<!--search部分end-->
	<script src="js/search.js"></script>
  </body>
</html>
