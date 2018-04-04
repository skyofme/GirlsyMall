<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'search_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/search_list.css">
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
		    	/* console.log(loginState);
	    		document.getElementById("gotoShopppingCar").submit(); */
	    		var amount = 1;
				$.post("/mall/MyShoppingCarServlet", {
					buyNum : amount,
				}, function(data, status) {
					$(".search-car-icon3").text(data);
				});
	    	}
    	}
    }
    
    </script>
  </head>
  
  <body>
	<jsp:include page="header.jsp" ></jsp:include>
	<iframe name="top-banner_frame" marginwidth=0 marginheight=0 width=100% height=80px scrolling=no src="top-banner.jsp" frameborder=0></iframe>
	<iframe name="search_frame" marginwidth=0 marginheight=0 width=100% height=100px scrolling=no src="search.jsp" frameborder=0></iframe>
    <div class="w">
    <c:if test="${addFlag=='addCollection'}">
 		<script type="text/javascript">
	   		alert("已经加到收藏夹啦~");
	   </script>
 	</c:if> 
    <%-- <c:if test="${addFlag=='addShoppingCar'}">
 		<script type="text/javascript">
	   		alert("已经加到购物车啦~");
	   </script>
 	</c:if>  --%>
    <c:if test="${addFlag=='alreadyIn'}">
 		<script type="text/javascript">
	   		alert("您已经加过该商品了哟~");
	   </script>
 	</c:if> 
    <c:if test="${addFlag=='fail'}">
 		<script type="text/javascript">
	   		alert("哭唧唧抱歉添加失败了");
	   </script>
 	</c:if>
        <ul class="w-ul">
            <c:forEach items="${searchGoods}" var="searchGood">
        		<li>
		            <a href="/mall/ShoppingCarServlet?goodsId=${searchGood.id}">
		                <div class="li-div2">
		                    <div class="li-div-img">
		                    	<img src="${searchGood.img}" >
		                    </div>
		                    <span class="li-div-span">￥</span><span class="li-div-span2">${searchGood.price }</span>
		                    <p class="li-div-p">${searchGood.name }${searchGood.desc} </p>
		                </div>
		                </a>
		                <div class="li-div-icon">
		                        <a href="/mall/CollectionServlet?op=add&searchGoodId=${searchGood.id}" onclick="return loginCheck('${loginState}','${role}');"><i class="li-div-icon1"></i></a>
		                        <a href="/mall/MyShoppingCarServlet?searchGoodId=${searchGood.id}" onclick="return loginCheck('${loginState}','${role}');"><i class="li-div-icon2"></i></a>
		                </div>
                 </li>
        	</c:forEach>
            
        </ul>
    </div>
    <script src="js/jquery.js" ></script>
    <script src="js/search_list.js"></script>
    
  </body>
</html>
