<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8"/>
<title>编辑主页公告</title>
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
<form action="NewsServlet" method="post">
<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">编辑公告内容</h2>
      </div>
     <section>
      <ul class="ulColumn2">      
       <li style="position:relative">
        <span class="item_name" style="width:120px;">修改公告1：</span>
        <textarea class="textarea" style="height:40px;width:650px;" name="new1" ></textarea>        
        <input type="submit"  class="link_btn" name="news1" value="保存" onClick="return confirm('确定修改公告内容吗？');" style="text-align: center; width:100px ;height:40px;position:absolute;bottom:4px;right:200px;" />
       </li >
       <li style="position:relative">
        <span class="item_name" style="width:120px;">修改公告2：</span>
        <textarea class="textarea" style="height:40px;width:650px;" name="new2"></textarea>
        <input type="submit"  class="link_btn" name="news2" value="保存" onClick="return confirm('确定修改公告内容吗？');" style="text-align: center; width:100px ;height:40px;position:absolute;bottom:4px;right:200px;" />
       </li >
       <li style="position:relative">
        <span class="item_name" style="width:120px;">修改公告3：</span>
        <textarea class="textarea" style="height:40px;width:650px;" name="new3"></textarea>
         &nbsp; &nbsp; &nbsp;
        <input type="submit"  class="link_btn" name="news3" value="保存" onClick="return confirm('确定修改公告内容吗？');" style="text-align: center; width:100px ;height:40px;position:absolute;bottom:4px;right:200px;" />
       </li>
       <li style="position:relative">
        <span class="item_name" style="width:120px;">修改公告4：</span>
        <textarea class="textarea" style="height:40px;width:650px;" name="new4"></textarea>
         &nbsp; &nbsp; &nbsp;
         <input type="submit"  class="link_btn" name="news4" value="保存" onClick="return confirm('确定修改公告内容吗？');" style="text-align: center; width:100px ;height:40px;position:absolute;bottom:4px;right:200px;" />
       </li>
       <li style="position:relative">
        <span class="item_name" style="width:120px;">修改公告5：</span>
        <textarea class="textarea" style="height:40px;width:650px;" name="new5"></textarea>
         &nbsp; &nbsp; &nbsp;
        <input type="submit"  class="link_btn" name="news5" value="保存" onClick="return confirm('确定修改公告内容吗？');" style="text-align: center; width:100px ;height:40px;position:absolute;bottom:4px;right:200px;" />      
       </li>        
      </ul>
     </section>     
 </div>
</section>
</form>
</body>
</html>
