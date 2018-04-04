<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shortcut.jsp' starting page</title>
    
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
    <!--shortcut部分start-->
<div class="shortcut">
    <div class="w">
        <div class="shortcut-dropdown">
            <div class="shortcut-dropdown-all">
                <a href="#" class="dropdown-all-a" target="_parent">全部商品分类</a>
            </div>
            <!--<div class="shortcut-dropdown-one">-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">家用电器</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">手机、数码、京东通信</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">电脑、办公</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">家居、家具、家装、厨具</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">男装、女装、内衣、珠宝</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">家用电器</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">手机、数码、京东通信</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">电脑、办公</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">家居、家具、家装、厨具</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">男装、女装、内衣、珠宝</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">家用电器</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">手机、数码、京东通信</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">电脑、办公</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">家居、家具、家装、厨具</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
                <!--<div class="shortcut-item">-->
                    <!--<h1>-->
                        <!--<a href="#">男装、女装、内衣、珠宝</a>-->
                    <!--</h1>-->
                    <!--<i>></i>-->
                <!--</div>-->
            <!--</div>-->
        </div>
        <div class="shortcut-items">
            <ul>
                <li><a href="#" target="_parent">服装城</a></li>
                <li><a href="#" target="_parent">美妆馆</a></li>
                <li><a href="#" target="_parent">超市</a></li>
                <li><a href="#" target="_parent">全球购</a></li>
                <li><a href="#" target="_parent">闪购</a></li>
                <li><a href="#" target="_parent">团购</a></li>
                <li><a href="#" target="_parent">拍卖</a></li>
                <li><a href="#" target="_parent">金融</a></li>
            </ul>
        </div>
        <div class="shortcut-free">
            <a href="#" target="_parent"></a>
        </div>
    </div>
</div>
<!--shortcut部分end-->
  </body>
</html>
