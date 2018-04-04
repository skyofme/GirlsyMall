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
    
    <title>My JSP 'collect.jsp' starting page</title>
    
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
    <link rel="stylesheet" href="css/shopping-car.css">
    <style>
        .good table .tr-pos td:nth-child(2){
            left: 50px;
        }
        .good table .tr-pos td:nth-child(3){
            left: 200px;
        }
        .good table .tr-pos td:nth-child(4){
            left: 700px;
        }
        .type ul li:nth-child(2){
            left: 270px;
        }
        .type ul li:nth-child(3){
            left: 710px;
        }
        .collect {
            display: inline-block;
            font: 700 30px/30px "microsoft yahei";
            padding-left: 350px;
        }
    </style>
    <script type="text/javascript">
    	function getByType(type){
    		var url="/mall/CollectionServlet?op=sea&type="+type;
    		window.parent.location.href = url;
    	}
    </script>
  </head>
  
  <body>
    <iframe name="header_frame" marginwidth=0 marginheight=0 width=100% height=30px src="header.jsp" frameborder=0></iframe>
    <div class="top-color">
        <a href="index.jsp">Girlsy Mall</a> <span class="top-color-one">购物安全有保障</span><span class="top-color-two">您身边的生活专家</span>
    </div>
<div class="w ">
    <div class="shopping-car-part">
        <select style="display: inline-block;" onchange="getByType(this.options.selectedIndex)">
            <option value="0">商品分类</option>
            <option value="1">食品</option>
            <option value="2">生活用品</option>
            <option value="3">衣物</option>
            <option value="4">电器</option>
            <option value="5">全部商品</option>
        </select>
        <h1 class="collect">收藏夹</h1>
        <div class="type clearfix">
            <ul>
                <li class="type-li01">
                    <input id="all-check" type="checkbox">&nbsp;&nbsp;&nbsp;全选
                </li>
                <li class="type-li02">商品</li>
                <li class="type-li03"  style="position: absolute;left: 500px;">分类</li>
                <li class="type-li03"  style="position: absolute;left: 730px;">单价</li>
                <li class="type-li06">操作</li>
            </ul>
        </div>
        <div class="good">
            <table>
            	<c:forEach items="${collections }" var="collection">
            		<tr class="tr-pos">
                    <td class="td1">
                        <input type="checkbox">
                    </td>
                    <td class="td2"><a href="/mall/ShoppingCarServlet?goodsId=${collection.goods.id }"><img src="${collection.goods.img }"></a></td>
                    <td class="shopping-brand">
                        ${collection.goods.name }
                    </td>
                    <td class="td3" style="position: absolute;left: 500px;">
                        ${collection.goods.type }
                    </td>
                    <td class="td4" style="position: absolute;left: 710px;">
                        <span><fmt:formatNumber value="${(collection.goods.price)*(collection.goods.discount)}" type="currency"></fmt:formatNumber></span>
                    </td>
                    <td class="td7"><a href="/mall/CollectionServlet?op=del&colId=${collection.id}">删除</a></td>
                </tr>
            	</c:forEach>
            </table>
        </div>
    </div>
</div>
<script src="js/shopping-car.js" type="text/javascript"></script>
  </body>
</html>
