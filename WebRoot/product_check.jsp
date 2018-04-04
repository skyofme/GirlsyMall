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
<title>所有商品</title>
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
      <form action="<%=basePath%>AllGoods?op=getList"  method="post" style="position:relative;">
      <select class="select" name="goodsType" style="display:inline-block;height:38px;position:absolute;top:0px; left: 5px;">
	       <option value="商品类型">商品类型</option>
	       <c:forEach items="${listType}" var="listtype">
	        	<option <c:if test="${goodsType eq listtype.type}">selected="selected"</c:if>>${listtype.type}</option>
	        </c:forEach>
	       </select>
      <section class="mtb" style="display:inline-block">
       <input name="search"  value="${param.search}" class="textbox textbox_225" placeholder="输入产品关键词..." style="height:38px ;position:absolute;top:0px; left: 105px;" />
       <input type="submit" value="查询" class="group_btn" style="position:absolute;top:0px; left: 305px;"/>
      </section>
      </form>
      <h2 style="padding-top: 30px;">查询出来的商品:</h2>
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
        <td class="center">
         <a href="<%=basePath%>AllGoods?op=getOne&id=${good.id}" title="编辑" class="link_icon">&#101;</a>
        </td>
       </tr>
        </c:forEach>
      </table>
      <div class="paging">
      <a href="<%=basePath%>AllGoods?op=getPage&pageNow=1&search=${param.search}&option=${goodsType} ">第一页</a>
       <a href="<%=basePath%>AllGoods?op=getPage&pageNow=${pageNow-1 }&search=${param.search}&option=${goodsType}" >上一页</a>
       <a href="<%=basePath%>AllGoods?op=getPage&pageNow=${pageNow+1}&search=${param.search}&option=${goodsType}" >下一页</a>
       <a href="#">${pageNow}/${pageCnt}</a>
       <form action="<%=basePath%>AllGoods?op=getPage&search=${param.search}&option=${goodsType}&skip=true"method="post" style="display:inline-block">
	       <input type="number" name="searchPageNum" style="display:inline-block;width:50px;border: 1px #139667 solid;
    height: 26px;
    line-height: 26px;
    padding: 5px;
    font-size: 12px;
    vertical-align: middle;"/>
	       <input type="submit" value="跳到此页" style="display:inline-block;width:100px; background: #19a97b;background: #19a97b;
    border: 1px #139667 solid;
    color: white;
    padding: 5px 8px;
    cursor: pointer;">
	    </form>
       <a href="<%=basePath%>AllGoods?op=getPage&pageNow=${pageCnt}&search=${param.search}&option=${goodsType}">最后一页</a>
       </div>
 </div>
</section>
</body>
</html>
