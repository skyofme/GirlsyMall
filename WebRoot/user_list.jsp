<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8"/>
<title>查看所有会员</title>
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
    <dd><a href="product_check.jsp">所有商品</a></dd>
    <dd><a href="product_add.jsp" >添加商品</a></dd>
    <dd><a href="product_delete.jsp">商品下架</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>订单信息</dt>
    <dd><a href="order_list.jsp">订单列表示例</a></dd>
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
       <h2 class="fl">会员列表</h2>
      </div>
      <section class="mtb">
      <form action="SearchCustom" method="post">
       <input type="text" class="textbox textbox_225" placeholder="输入会员号或姓名....查询" name="search" value="${param.search}" style="height:38px"/>
       <input type="submit" value="查询" class="group_btn" />
       </form>
      </section>
      <table class="table"  border="1" width="500px" > 
       <tr>
        <th>Id</th>
        <th>会员姓名</th>
        <th>会员性别</th>
        <th>手机号码</th>
        <th>地址</th>
       </tr>
       <c:forEach var="custom" items="${customs}">
       <tr>
       <td>${custom.id}</td>
       <td>${custom.name}</td>
       <td>${custom.sex}</td>    
       <td>${custom.tel}</td>
       <td>${custom.addr}</td>
       </tr>
      </c:forEach>      
      </table>
      <aside class="paging">
       <a href="SearchCustom?pageNow=1&search=${param.search}">第一页</a>
       <a href="SearchCustom?pageNow=2&search=${param.search}">2</a>
       <a href="SearchCustom?pageNow=3&search=${param.search}">3</a>
       <a href="SearchCustom?pageNow=4&search=${param.search}">4</a>             
       <a href="SearchCustom?pageNow=${pageNow+1 }&search=${param.search}">下一页</a>
       <a href="SearchCustom?pageNow=${pageCnt}&search=${param.search}">尾页</a>        
      </aside>
 </div>
</section>
</body>
</html>
