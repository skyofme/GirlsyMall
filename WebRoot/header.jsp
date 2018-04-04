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
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<script src="js/jquery.js"></script>
	<script src="js/header.js"></script>
	<script type="text/javascript">
	function loginCheck(loginState,role){
    	if(loginState != "true"){
    		alert("您还未登录哟");
	 		return false;
    	}
    	else{
	    	if(role=="admin"){
	    		console.log(role);
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
    <!--site-nav部分start-->
<div class="site-nav">
    <div class="w">
        <div class="fl">
            <div class="site-nav-send">
                送至：北京
                <i><s>◇</s></i>
            </div>
            <div class="site-nav-city"></div>
        </div>
        <div class="fr site-nav-r">
            <ul>
                <li>
	               	<c:if test="${loginState=='true' }">
	               		你好，${admin.name}${custom.name}
	               		<li><a href="index.html" class="col-red" target="_parent">GirlsyMall商城首页</a></li>
	               		<c:if test="${role=='admin'}">
	               			<a href="adminindex.jsp" class="col-red" target="_parent">管理员界面</a>
	               		</c:if>
	               	</c:if>
	               	<c:if test="${(loginState!='true'&&exitLogin=='true')||(loginState!='true'&&exitLogin!='true')}">
	               		<a href="login.jsp" target="_parent">你好，请登录</a>&nbsp;
                        <a href="register/register.jsp" class="col-red" target="_parent">免费注册</a>
	               	</c:if>
	               	
                </li>
                <li class="line "></li>
                <li class="fore order-download">
                	<a href="/mall/MyOrderServlet?op=see" target="_parent" onclick="return loginCheck('${loginState}','${role}');">我的订单</a>
                	<i><s>◇</s></i>
                	<div class="order-download-one">
                		<h1>最近购买的商品：</h1>
                		<ul>
	                		<c:forEach items="${orderDetails}" var="orderDetail" begin="0" end="4" step="1">
	                			<li>
	                				<a href="/mall/ShoppingCarServlet?goodsId=${orderDetail.goods.id}" target="_parent"><div class="div-order-img"><img src="${orderDetail.goods.img}"></div></a>
	                				<div class="div-order-inf">
	                					<div>
	                						<a href="/mall/ShoppingCarServlet?goodsId=${orderDetail.goods.id}" target="_parent">
		                						<span class="div-order-brand">${orderDetail.goods.name}</span>
		                						<span class="div-order-price">￥<span><fmt:formatNumber maxFractionDigits="2" value="${(orderDetail.goods.price)*(orderDetail.goods.discount)/10}" type="number"></fmt:formatNumber></span></span>
	                						</a>
	                					</div>
	                					<div>
	                						<span class="div-order-date">${orderDetail.orderList.orderDatetime }</span>
	                						<span class="div-order-op">数量：${orderDetail.goodNum}</span>
	                					</div>
	                				</div>
	                			</li>
	                		</c:forEach>
                		</ul>
                		<span style="float: right; padding-right: 10px;"><a href="/mall/MyOrderServlet?op=see">查看更多订单</a></span>
                	</div>
                </li>
                <li class="line"></li>
                <li class="fore">
                    <a href="#" target="_parent">我的浏览</a>
                    <i><s>◇</s></i>
                </li>
                <li class="line"></li>
                <li><a href="/mall/CollectionServlet" target="_parent" onclick="return loginCheck('${loginState}','${role}');">我的收藏</a></li>
                <li class="line"></li>
                <li class="fore jd-tel contact-download">
                    <a href="#" target="_parent">联系我们</a>
                    <i><s>◇</s></i>
                    <span class="tel"></span>
                    <div class="contact-us">
                    	<div>
                    		<span><a href="help.jsp">帮助中心</a></span>
                    	</div>
                    </div>
                </li>
                <li class="line"></li>
                <li>
                <c:if test="${ loginState=='true'}">
                	<a href="/mall/ExitLogin" target="_parent">退出登录</a>&nbsp;                 
                </c:if>
                </li>
            </ul>
        </div>
    </div>
</div>
<!--site-nav部分end-->
  </body>
</html>
