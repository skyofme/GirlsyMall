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
<title>订单列表</title>
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
  		function logoutConfirm() {
			var cf=window.confirm("你真的要删除本宝贝吗");
			return cf;
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

<!-- 判断是否删除成功 -->
<c:if test="${deleteFlag=='true'}">
 		<script type="text/javascript">
	   		alert("你成功把人家删掉了啦~");
	   </script>
 </c:if>
 
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
    <dd><a href="order_detail.jsp">订单详情示例</a></dd>
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
       <h2 class="fl">订单列表示例</h2>
       <a class="fr top_rt_btn add_icon">添加商品</a>
      </div>
      
      <form action="/mall/OrderListServlet?op=sea" method="post">
	     <section class="mtb">
	       <select class="select" name=orderState >
	        <option value="订单状态">订单状态</option>
	        <option value="已付款">已付款</option>
	        <option value="已发货">已发货</option>
	        <option value="交易完成">交易完成</option>
	        <option value="">全部订单</option>
	       </select>
	       <input type="text" class="textbox textbox_225" name="orderId" placeholder="请输入订单编号或收件人姓名" value="${orderId}" style="height:38px"/>
	       <input type="submit" value="查询" class="group_btn"/>
      	 </section>
      </form>
      
      <table class="table">
       <tr>
        <th>订单编号</th>
        <th>收件人id</th>
        <th>下单时间</th>
        <th>收件人姓名</th>
        <th>收件人电话</th>
        <th>收件人地址</th>
        <th>打开订单详情</th>
        <th>删除订单</th>
       </tr>
       
    	<c:forEach items="${orderLists}" var="orderList">
       <tr>
        <td class="center">${orderList.id }</td>
        <td class="center">${orderList.cusId }</td>
        <td class="center">${orderList.orderDatetime }</td>
        <td class="center">${orderList.custom.name }</td>
        <td class="center">${orderList.custom.tel }</td>
        <td class="center">
         <address>${orderList.custom.addr }</address>
        </td>
        <td><a href="/mall/OrderDetaiServlet?orderId=${orderList.id }">查看订单详情</a></td>
        <td class="center"> <a href="/mall/OrderListServlet?op=del&id=${orderList.id }" onclick="return logoutConfirm();" >删除</a></td>
       </tr>
       </c:forEach>            
      </table>
      <aside class="paging">
       <a href="/mall/OrderListServlet?op=sea&whichPage=1&orderId=${orderId}">首页</a>
       <c:if test="${nowPage>=5}">
       <a href="/mall/OrderListServlet?op=sea&whichPage=${nowPage-3}&orderId=${orderId}">${nowPage-3}</a>
       <a href="/mall/OrderListServlet?op=sea&whichPage=${nowPage-2}&orderId=${orderId}">${nowPage-2}</a>
       <a href="/mall/OrderListServlet?op=sea&whichPage=${nowPage-1}&orderId=${orderId}">${nowPage-1}</a>
       </c:if>
       <c:if test="${!(nowPage>=5)}">
       <a href="/mall/OrderListServlet?op=sea&whichPage=2&orderId=${orderId}">2</a>
       <a href="/mall/OrderListServlet?op=sea&whichPage=3&orderId=${orderId}">3</a>
       <a href="/mall/OrderListServlet?op=sea&whichPage=4&orderId=${orderId}">4</a>
       </c:if>
       <a href="/mall/OrderListServlet?op=sea&whichPage=0&orderId=${orderId}">下一页</a>
       <a href="/mall/OrderListServlet?op=sea&whichPage=-1&orderId=${orderId}">最后一页</a>
      </aside>
 </div>
</section>
</body>
</html>
