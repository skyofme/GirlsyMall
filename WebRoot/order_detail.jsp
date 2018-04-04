<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8"/>
<title>订单详情示例</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css">
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>

	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
	
	function OrderDetailConfirm(id,state){
		var url = "/mall/OrderDetaiServlet?orderId="+id+"&state=" + state;
		if(window.confirm('你确定要修改吗？')){
			window.location.href = url;
		}else{
			return false;
		}
	}
	
</script>
</head>
<body>
<!--header-->
<header>
 <h1><img src="images/admin_logo.png"/></h1>
 <ul class="rt_nav">
  <li><a href="index.html" target="_blank" class="website_icon">Girls Mall商城首页</a></li>
  <li><a href="login.jsp" class="quit_icon">安全退出</a></li>
 </ul>
</header>
<!--aside nav-->
<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <ul>
  <li>
   <dl>
    <dt>商品管理</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="/mall/AllGoods">所有商品</a></dd>
    <dd><a href="product_add.jsp" >添加商品</a></dd>
    <dd><a href="product_delete.jsp">商品下架</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>订单信息</dt>
    <dd><a href="/mall/OrderListServlet">订单列表示例</a></dd>
    <dd><a href="#">订单详情示例</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>会员管理</dt>
    <dd><a href="/mall/SearchCustom?search=">会员列表示例</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>公告管理</dt>
    <dd><a href="setting.jsp">编辑主页公告</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>主页管理</dt>
    <dd><a href="">编辑主页</a></dd>
   </dl>
  </li>
  <li>
   <p class="btm_infor">© GirlsMall.cn 版权所有</p>
  </li>
 </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">订单详情</h2>
      </div>
      <table class="table">
       <tr>
        <td>订单编号：${orderDetails[0].orderList.id}</td>
        <td>收件人ID：${orderDetails[0].custom.id}</td>
        <td>下单时间：${orderDetails[0].orderList.orderDatetime}</td>
        <td>收件人姓名：${orderDetails[0].custom.name}</td>

       </tr>
       <tr>  
        <td>收件人电话：${orderDetails[0].custom.tel}</td>
        <td>收件人地址：${orderDetails[0].custom.addr}</td>
        <td>订单状态：${orderDetails[0].orderList.orderState}</td>
        <td>订单总价：${totalPrice}</td>
        </tr>
      </table>
      <table class="table">
      <tr><td>商品名称</td><td>商品数量</td></tr>
      <c:forEach items="${orderDetails}" var="orderDetail">
       <tr>
         <td class="center">${orderDetail.goods.name }</td>
        <td class="center">${orderDetail.goodNum }</td>
       </tr>
      </c:forEach>
      </table>
      <aside class="mtb" style="text-align:right; margin-top: 100px" >
       <label>管理员操作：</label>
       <!-- /mall/OrderDetaiServlet?orderId=${orderDetails[0].orderList.id}&state= -->
       	<c:set var="orderId">${orderDetails[0].orderList.id}</c:set>
	      <input type="button" value="已付款" class="group_btn"  onClick="OrderDetailConfirm(${orderId},'1');"/>
	      <input type="button" value="已发货" class="group_btn"  onClick="OrderDetailConfirm(${orderId},'2');"/>
	      <input type="button" value="交易完成" class="group_btn" onClick="OrderDetailConfirm(${orderId},'3');"/>
      </aside>
 </div>
</section>
</body>
</html>
