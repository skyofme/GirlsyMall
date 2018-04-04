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
    
    <title>My JSP 'pay.jsp' starting page</title>
    
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
    <link rel="stylesheet" href="css/pay.css">
    <script type="text/javascript">
    function loginCheck(loginState){
    	if(loginState == "true"){
    		return true;
    	}
    	else{
    	    alert("您还未登录哟");
	 		return false;
    	}
    }
    
    </script>
  </head>
  
  <body>
 
    <jsp:include page="header.jsp" ></jsp:include>
    <div class="top-color">
        <a href="index.jsp">Girlsy Mall</a> <span class="top-color-one">购物安全有保障</span><span class="top-color-two">您身边的生活专家</span>
    </div>
    <div class="w">
        <div class="pay-part">
            <div class="state">
                <ul class="process-text">
                    <li class="process-text-li01">查看购物车</li>
                    <li class="process-text-li02">拍下商品</li>
                    <li class="process-text-li03">付款</li>
                    <li class="process-text-li04">确认收货</li>
                    <li class="process-text-li05">评价</li>
                </ul>
                <ul class="process-img">
                    <li class="process-img-li01"><i></i></li>
                    <li class="process-img-li02"><i>2</i></li>
                    <li class="process-img-li03"><i>3</i></li>
                    <li class="process-img-li04"><i>4</i></li>
                    <li class="process-img-li05"><i>5</i></li>
                </ul>
            </div>
            <div class="address">
                <h1>选择地址：</h1>
                <div>
                    <p>${cus_name}(收)&nbsp;&nbsp;${cus_tel}<br>${cus_addr}</p>
                    <a href="javascript:void(0);"></a>
                    <i></i>
                </div>
            </div>
            <div class="confirm">
                <div class="good-pay-inf">
                    <h1>确认订单信息</h1>
                    <i class="pay-inf-ins1">商品</i>
                    <i class="pay-inf-ins2">价格</i>
                    <i class="pay-inf-ins3">数量</i>
                    <i class="pay-inf-ins4">小计</i>
                    
                    <table>
                    	<c:forEach items="${pickShoppingCars}" var="pickShoppingCar">
	                        <tr>
	                            <td><img src="${pickShoppingCar.goods.img}"></td>
	                            <td>${pickShoppingCar.goods.name}</td>
	                            <td><fmt:formatNumber  value="${(pickShoppingCar.goods.price)*(pickShoppingCar.goods.discount)/10}" type="CURRENCY"></fmt:formatNumber></td>
	                            <td>${pickShoppingCar.buyNum}</td>
	                            <td><fmt:formatNumber  value="${(pickShoppingCar.goods.price)*(pickShoppingCar.goods.discount)*(pickShoppingCar.buyNum)/10}" type="CURRENCY"></fmt:formatNumber></td>
	                        </tr>
                         </c:forEach>
                    </table>
                </div>
            </div>
            <div class="confirm-buy">
                    <span class="buy-span1">需付款: <i><fmt:formatNumber  value="${sumPrice}" type="CURRENCY"></fmt:formatNumber></i></span>
                    <span class="buy-span2">
                        <span >寄送至：</span>
                        <p>${cus_addr}</p>
                    </span>
                    <span class="buy-span3">
                        <span>收货人：</span>
                        <p>${cus_name}(收)&nbsp;&nbsp;${cus_tel}</p>
                    </span>
                    <a href="/mall/MyOrderServlet?op=searchByCusId" onclick="return loginCheck('${loginState}');"><span class="buy-span4">确认购买</span></a>
                </div>
        </div>
    </div>
  </body>
</html>
