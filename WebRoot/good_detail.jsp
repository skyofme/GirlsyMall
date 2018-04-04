<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'good_detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/index.css"/>
    <link rel="stylesheet" href="css/fix-table.css"/>
  </head>
  
  <body>
    <jsp:include page="header.jsp" ></jsp:include>
    <iframe name="top-banner_frame" marginwidth=0 marginheight=0 width=100% height=80px scrolling=no src="top-banner.jsp" frameborder=0></iframe>
	<jsp:include page="search.jsp" ></jsp:include>
	<iframe name="shortcut_frame" marginwidth=0 marginheight=0 scrolling=no width=100% height=50px src="shortcut.jsp" frameborder=0></iframe>
    <jsp:include page="good_detail_center.jsp"></jsp:include>
    <iframe name="footer_frame" marginwidth=0 marginheight=0 scrolling=no width=100% height=500px src="footer.jsp" frameborder=0></iframe>
    <div class="fix-div">
    	<i class="fix-div-li01" ></i>
    	<i class="fix-div-white1"></i>
    	<a href="/mall/MyShoppingCarServlet?op=sea" target="_parent" onclick="return loginCheck2('${loginState}','${role}');"><i class="fix-div-li02" id="end"></i></a>
    	<i class="fix-div-white2"></i>
    	<a href="/mall/CollectionServlet" target="_parent" onclick="return loginCheck2('${loginState}','${role}');"><i class="fix-div-li03"></i></a>
    	<i class="fix-div-white3"></i>
    	<i class="fix-div-li04"></i>
    </div>
	<div id="msg">已成功加入购物车！</div>
  </body>
</html>
