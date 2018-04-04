<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单详情</title>
    
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
    <link rel="stylesheet" href="css/check-detail.css">
     <style>
     .box1-1{display:block;}
     </style>
  </head>
  
  <body>
    <iframe name="header_frame" marginwidth=0 marginheight=0 width=100% height=30px scrolling=no src="header.jsp" frameborder=0></iframe>
    <div class="top-color">
        <a href="index.jsp">Girlsy Mall</a> <span class="top-color-one">购物安全有保障</span><span class="top-color-two">您身边的生活专家</span>
    </div>
    <!--  -->
     <div class="w">
         <div class="check-deal">           
             <div class="deal-table">          
                 <i class="deal-i-1">订单编号：${orderDetails[0].orderList.id}</i>
                 <i class="deal-i-2">收件人ID：${orderDetails[0].custom.id}</i>
                 <i class="deal-i-3">下单时间：<br>${orderDetails[0].orderList.orderDatetime}</i>
                 <i class="deal-i-4">收件人姓名：${orderDetails[0].custom.name}</i> 
                 <i class="deal-i-5">收件人电话：${orderDetails[0].custom.tel}</i>
                 <i class="deal-i-6">收件人地址：<br>${orderDetails[0].custom.addr}</i>
                 <i class="deal-i-7">订单状态：${orderDetails[0].orderList.orderState}</i>
                 <i class="deal-i-8">订单总价：${totalPrice}</i>             
             </div>
              <table width='500px' height="" border='0' class="goodstable" align="center"  >  
                <tr>       
                 <th >商品名称</th>
                 <th >商品数量</th>   
                </tr>
                  <c:forEach items="${orderDetails}" var="orderDetail">
       			<tr>
         		<td class="center">${orderDetail.goods.name }</td>
        		<td class="center">${orderDetail.goodNum }</td>
       			</tr>
      			</c:forEach>
              </table>
             </div>
         </div>
  </body>
</html>
