<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>联系我们</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/help.css"/>
  </head>
  
  <body>
  <jsp:include page="header.jsp" ></jsp:include>
  <iframe name="top-banner_frame" marginwidth=0 marginheight=0 width=100% height=80px scrolling=no src="top-banner.jsp" frameborder=0></iframe>
  <div class="w">
  <div class="m mod-h01 contact-us-box">
            <div class="mt">
                <h3 class="title" >联系我们</h3>
            </div>
            <div class="mod-h02" style="text-align:center">
                <div class="jimi-box">        
                    <a href="//jimi.jd.com" target="_blank" class="btn-s03" clstag="pageclick|keycount|index_201502103|1">立即咨询</a>
                </div>
                <div class="contact-us-in" >
                    <dl class="dl-list fore01">
                    <dt class="title">电话客服</dt>
                        <dd class="cnt hot-line-box">
                            <p class="text">预约客服，主动回电<em class="yline">|</em><a href="//help.jd.com/user/issue/270-314.html">更多热线&gt;</a></p>
                            <table>
                            <tr>罗干：157********<br>
                            <tr>张雯：166********<br> 
                            <tr>李娜：188********<br>
                            <tr>刘小燕：138********<br>
                            <tr>邓诗琪：136********<br>
                            <tr>敖紫迎：177********
                            
                            </table>
                        </dd>
                        
                    </dl>
                    <dl class="dl-list fore02" style="margin-left:85px">
                        <dt class="title">在线客服</dt>
                        <dd class="cnt">
                            <p class="text">在线解答您的咨询，高效、便捷</p>
                            <table>
                            <tr>罗干：9696*****<br>
                            <tr>张雯：9696*****<br> 
                            <tr>李娜：9696*****<br>
                            <tr>刘小燕：9696*****<br>
                            <tr>邓诗琪：9696*****<br>
                            <tr>敖紫迎：9696*****                            
                            </table>
                        </dd> 
                    </dl>
                    <dl class="dl-list fore03" style="margin-left:100px">
                        <dt class="title">提建议</dt>
                        <dd class="cnt">
                            <p class="text">对帮助中心提建议<em class="yline" >|</em>邮件留言<a href="mailto:service@jd.com" clstag="pageclick|keycount|index_201502103|6">service@jd.com</a></p>
                            <table>
                            <tr>罗干：9696*****@qq.com<br>
                            <tr>张雯：9697*****@qq.com<br> 
                            <tr>李娜：9698*****@qq.com<br>
                            <tr>刘小燕：9699*****@qq.com<br>
                            <tr>邓诗琪：9690*****@qq.com<br>
                            <tr>敖紫迎：9691*****@qq.com                            
                            </table>
                        </dd>
                    </dl>
                </div>
            </div>
        </div>
        </div>
    <iframe name="footer_frame" marginwidth=0 marginheight=0 width=100% height=500px scrolling=no src="footer.jsp" frameborder=0></iframe>

  </body>
</html>
