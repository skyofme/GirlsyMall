<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'today.jsp' starting page</title>
    
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
    <!--today部分start-->
    <div class="w today clearfix">
        <div class="today-l">
            <a href="#" target="_parent"></a>
        </div>
        <div class="today-r">
            <ul>
                <li><a href="#" target="_parent"><img src="images/pic1.jpg" alt=""/></a></li>
                <li><a href="#" target="_parent"><img src="images/pic2.jpg" alt=""/></a></li>
                <li><a href="#" target="_parent"><img src="images/pic3.jpg" alt=""/></a></li>
                <li><a href="#" target="_parent"><img src="images/pic4.jpg" alt=""/></a></li>
            </ul>
        </div>
    </div>
    <!--today部分end-->
  </body>
</html>
