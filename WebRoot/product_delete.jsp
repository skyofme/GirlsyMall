<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8"/>
<title>商品下架</title>
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
  <script type="text/javascript">
  		function logoutConfirm() {
			var cf=window.confirm("你真的要下架本宝贝吗");
			return cf;
		}
  </script>
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
       <h2 class="fl">商品列表示例</h2>
      </div>
      <form action="GoodsSearch"  method="post">
      <section class="mtb">
       <input name="search"  value="${param.search}" type="text" class="textbox textbox_225" placeholder="输入产品关键字..." style="height:38px"/>
       <input type="submit" value="查询" class="group_btn"/>
      </section>
      </form>
      <h2 >查询出来的商品:</h2>
      <span style="color:red;">${msg}<c:remove var="msg" scope="session"/></span>
      <table class="table">
       <tr>
        <th>产品货号</th>
        <th>产品名称</th>
        <th>库存量</th>
        <th>价格</th>
        <th>折扣</th>
        <th>销量</th>
        <th>产品类别</th>
        <th>操作</th>
       </tr>
        <c:forEach items="${goods}"  var="good">
		<tr>
        	<td class="center">${good.id}</td>
        	<td class="center">${good.name}</td>
        	<td class="center">${good.storage}</td>
        	<td class="center">${good.price}</td>
        	<td class="center">${good.discount}</td>
        	<td class="center">${good.sellCount}</td>
        	<td class="center">${good.type}</td>
        	<td class="center"><a href="<%=basePath%>GoodsSearch?op=drop&id=${good.id}" onclick="return logoutConfirm();">下架</a></td>
       </tr>
        </c:forEach>
      </table>
 </div>
</section>
</body>
</html>
