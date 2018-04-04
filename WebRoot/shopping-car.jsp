<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>购物车界面</title>

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
<script type="text/javascript">
    	function getByType(type){
    		var url="/mall/MyShoppingCarServlet?op=sea&type="+type;
    		window.parent.location.href = url;
    	}
    </script>
</head>
<body>
	<iframe name="header_frame" marginwidth=0 marginheight=0 width=100%
		height=30px src="header.jsp" frameborder=0></iframe>
	<div class="top-color">
		<a href="index.jsp">Girlsy Mall</a> <span class="top-color-one">购物安全有保障</span><span
			class="top-color-two">您身边的生活专家</span>
	</div>
	<div class="w ">
		<div class="shopping-car-part">
			<select onchange="getByType(this.options.selectedIndex)">
				<option value="0">商品分类</option>
				<option value="1">食品</option>
				<option value="2">生活用品</option>
				<option value="3">衣物</option>
				<option value="4">电器</option>
				<option value="5">全部商品</option>
			</select>
			<form action="<%=basePath%>ShoppingServlet" method="post">
				<div class="type clearfix">
					<ul>
						<li class="type-li01"><input id="all-check" type="checkbox">&nbsp;&nbsp;&nbsp;全选
						</li>
						<li class="type-li02">商品</li>
						<li class="type-li03">单价</li>
						<li class="type-li04">数量</li>
						<li class="type-li05">小计</li>
						<li class="type-li06">操作</li>
					</ul>
				</div>
				<div class="good">
        <table>
            <c:forEach items="${shoppingCars}" var="shoppingCar">
                <tr class="tr-pos">
                    <td class="td1">
                        <input type="checkbox" class="single-checkbox">
                        <input type="hidden" value="${shoppingCar.goods.id}" name="id1" disabled="disabled">
                        <input type="hidden" value="${shoppingCar.custom.id}" name="id2" disabled="disabled">
                    </td>
                    <td class="td2"><a href="/mall/ShoppingCarServlet?goodsId=${shoppingCar.goods.id }"><img src="${shoppingCar.goods.img }"></a></td>
                    <td class="shopping-brand">
                        ${shoppingCar.goods.name }
                    </td>
                    <td class="td4">
                        <span>￥ <span><fmt:formatNumber maxFractionDigits="2" value="${(shoppingCar.goods.price)*(shoppingCar.goods.discount)/10}" type="number"></fmt:formatNumber></span></span>
                    </td>
                    <td class="td5">
                        <div class="amount">
                            <button type="button"  class="shopping-car-dec">-</button>
                            <input type="text" class="shopping-car-input" value="${shoppingCar.buyNum}">
                            <button type="button"  class="shopping-car-inc">+</button>
                        </div>
                        <input type="hidden" value="num" name="num1" disabled="disabled">
                    </td>
                    <td class="td6">
                    	<span>￥ <span><fmt:formatNumber pattern="##.##" value="${(shoppingCar.goods.price)*(shoppingCar.goods.discount)*(shoppingCar.buyNum)/10}" type="number"></fmt:formatNumber></span></span>
                    </td>
                    <td class="td7"><a href="/mall/MyShoppingCarServlet?op=del&carId=${shoppingCar.id}">删除</a></td>
                </tr>
            </c:forEach>
					</table>
					
					<div class="buy-buy-buy">
						<div class="buy-buy">
							<div class="shopping-car-amount">
								已选择&nbsp;&nbsp;<span>0</span>&nbsp;&nbsp;件商品
							</div>
							<div class="shopping-car-money">
								总价：&nbsp;&nbsp;￥<span>0</span>
							</div>
							<button type="submit" class="shopping-car-buy">去结算</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/shopping-car.js" type="text/javascript"></script>
	<%-- <script type="text/javascript">

    $(".shopping-car-dec").click(function(){
        $.post("<%=basePath%>UpdateServlet",
        {
            amount: $(this).next().val(),
            cusId: ${shoppingCar.custom},
            goodsId:$(this).parent().parent().parent().childrent().children().eq(1).val(),
           
        },
            function(data,status){
            alert("数据: \n" + data + "\n状态: " + status);
        });
    });
    $(".shopping-car-inc").click(function(){
        $.post("<%=basePath%>UpdateServlet",
        {
            amount: $(this).prev().val(),
            cusId: ${shoppingCar.custom},
            goodsId:$(this).parent().parent().parent().childrent().children().eq(1).val(),
            url:"<%=basePath%>
							UpdateServlet"
										}, function(data, status) {
											alert("数据: \n" + data + "\n状态: "
													+ status);
										});
									});
						</script> --%>
</body>
</html>
