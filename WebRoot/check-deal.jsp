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
    
    <title>我的订单</title>
    
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
    <link rel="stylesheet" href="css/check-deal.css">
    <script>
    function logoutConfirm() {
			var cf=window.confirm("你真的要删除本宝贝吗");
			return cf;
		}
    </script>
  </head>
  <!-- 判断是否删除成功 -->
  <c:if test="${deleteFlag=='true'}">
 		<script type="text/javascript">
	   		alert("你成功把人家删掉了啦~");
	   </script>
   </c:if>
 
  
  <body>
    <iframe name="header_frame" marginwidth=0 marginheight=0 width=100% height=30px scrolling=no src="header.jsp" frameborder=0></iframe>
    <div class="top-color">
        <a href="index.jsp">Girlsy Mall</a> <span class="top-color-one">购物安全有保障</span><span class="top-color-two">您身边的生活专家</span>
    </div>
     <div class="w">
         <div class="check-deal">
             
             <div class="deal-select">
                 
             </div>
             <div class="deal-table">
                 <i class="deal-i-1">订单编号</i>
                 <i class="deal-i-2">下单时间</i>
                 <i class="deal-i-3">收件人姓名</i>
                 <i class="deal-i-4">收件人电话</i>
                 <i class="deal-i-5">收件人地址</i>
                 <i class="deal-i-6">查看订单</i>
                 <i class="deal-i-7">删除订单</i>
                <table>
                <c:forEach items="${orderLists}" var="orderList">
       			<tr>
        		<td class="center">${orderList.id }</td>
       			<td class="center">${orderList.orderDatetime }</td>
        		<td class="center">${orderList.custom.name }</td>
        		<td class="center">${orderList.custom.tel }</td>
        		<td class="center"><address>${orderList.custom.addr }</address></td>
                <td><a href="<%=basePath%>MyOrderDetailServlet?orderId=${orderList.id }">查看订单详情</a></td>
                <td class="center"> <a href="<%=basePath%>MyOrderServlet?op=del&id=${orderList.id }" onclick="return logoutConfirm();" >删除</a></td>
                </tr>
       </c:forEach> 
                    
                  
                </table>
             </div>
         </div>
     </div>
  </body>
</html>
