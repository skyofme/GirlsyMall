<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Girlsy Mall</title>
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
    <link rel="shortcut icon" href="images/favicon.ico"/>
  </head>
  
  <body>
    
    
    <jsp:include page="header.jsp" ></jsp:include>
    <iframe name="top-banner_frame" marginwidth=0 marginheight=0 width=100% height=80px scrolling=no src="top-banner.jsp" frameborder=0></iframe>
	<jsp:include page="search.jsp"></jsp:include>
    <iframe name="shortcut_frame" marginwidth=0 marginheight=0 width=100% height=50px scrolling=no src="shortcut.jsp" frameborder=0></iframe>
    <iframe name="main_frame" marginwidth=0 marginheight=0 width=100% height=480px scrolling=no src="main.jsp" frameborder=0></iframe>
    <!--  <iframe name="today_frame" marginwidth=0 marginheight=0 width=100% height=220px scrolling=no src="today.jsp" frameborder=0></iframe>-->
    <iframe name="today_frame" marginwidth=0 marginheight=0 width=100% height=510px scrolling=no src="hot.jsp" frameborder=0></iframe>
    <iframe name="footer_frame" marginwidth=0 marginheight=0 width=100% height=500px scrolling=no src="footer.jsp" frameborder=0></iframe>
    
  </body>
</html>
