<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8"/>
<title>添加商品</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css">
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
 	<dd><a href="product_add.jsp">添加商品</a></dd>
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
       <h2 class="fl">开始添加商品</h2>
       <a href="product_check.jsp"   class="fr top_rt_btn">返回产品列表</a>
      </div>
     <form  action="<%=basePath%>AllGoods?op=add" method="post" enctype="multipart/form-data">
     <section>
      <ul class="ulColumn2">
       <li>
        <span class="item_name" style="width:120px; ">商品名称：</span>
        <input id="goodsName" name="goodsName"type="text" class="textbox textbox_295" placeholder="例如：0.5元辣条" style="height:38px"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">商品库存：</span>
        <input id="goodsStorage" name="goodsStorage" type="text" class="textbox" placeholder="例如：10000" style="height:38px"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">商品单价：</span>
        <input id="goodsPrice" name="goodsPrice" type="text" class="textbox" placeholder="例如：20" style="height:38px"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">商品类别</span>
        <select id="goodsKinds" name="goodsKinds" class="select">
         	<option value="商品分类">商品分类</option>
            <option value="食品">食品</option>
            <option value="生活用品">生活用品</option>
            <option value="衣物">衣物</option>
            <option value="电器">电器</option>
        </select>
       </li>
       <li>
        <span class="item_name" style="width:120px;">商品折扣：</span>
        <input id="goodsDiscount" name="goodsDiscount" type="text" class="textbox textbox_295" placeholder="例如：9" style="height:38px"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">上传图片：</span>
        <label class="uploadImg">
         <input type="file" name="fileUpload" multiple="multiple"/>
         <span>上传图片</span>
        </label>
       </li>
       <li>
        <span class="item_name" style="width:120px;">产品详情：</span>
        <input id="goodsDesc" name="goodsDesc" type="text" class="textbox textbox_295" style="height:38px"/>
          
       </li>
       <li>
        <span class="item_name" style="width:120px;"></span>
        <input type="submit" class="link_btn"  onClick="return confirm('确定添加该商品吗？');"/>
       </li>
      </ul>
     </section>
     </form>
 </div>
</section>
<script src="js/ueditor.config.js"></script>
<script src="js/ueditor.all.min.js"> </script>

</body>
</html>
