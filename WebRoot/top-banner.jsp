<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top-banner.jsp' starting page</title>
    
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
  </head>
  
  <body>
    <!--topbanner部分start-->
	<div class="topbanner">
	    <div class="w tp">
	        <a href="#" target="_parent">
	            <img src="images/topbanner.jpg" />
	        </a>
	        <a href="#" class="close-topbanner" target="_parent"></a>
	    </div>
	</div>
	<!--topbanner部分end-->
  </body>
</html>
