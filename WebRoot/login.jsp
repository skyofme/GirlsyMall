<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>登录</title>
  
  <link rel="stylesheet" href="css/login.css"/>
  <script type="text/javascript">
  	function loginCheck(){
  	
	  	console.log("进了logincheck");
	  	var id = document.getElementById("id").value;
	  	var pwd = document.getElementById("password").value;
	  		
	  	if(id==""||pwd=="")
	  	{
	  		alert("请输入完整的用户名和密码信息");
	 		return false;
	  	}
	  	
	 	document.getElementById("loginForm").submit();
	}
  </script>
 </head>
 <body>
 	<c:if test="${pwdFlag=='false'}">
 		<script type="text/javascript">
	   		alert("用户名或密码错误，请重新登录");
	   </script>
 	</c:if> 
 
  <div class="box1">
   <div class='box2'>
       <form id="loginForm" action="/mall/AdminOrCustom" method="post">
	       <div class='box3'>
		      <ul>
			     <li class=''>
				   <input id='id' name="id" class='wh bord user' type="text" placeholder='请输入ID' value="${l_regId}">
				 </li>
				 <li class=''>
				   <input id='password' name="password" class='wh bord' type="password" value="<%=session.getAttribute("l_regPswd")==null ? "" : session.getAttribute("l_regPswd") %>" placeholder='填写密码' >
				 </li>
				 <li class=''>
				 	  <label><input name="login" type="radio" value="admin" checked="checked" /><p>管理员登录</p> </label> 
					  <label><input name="login" type="radio" value="custom" /><p>用户登录</p> </label>
				 </li>
				 <li class=''>
				   <input id='checkbox' name="remember" type="checkbox" value='remember'><p>记住账号</p><a href='register/register.jsp'>欢迎注册</a><a href=' ' onClick="return confirm('请联系Girlsy Mall客服！');">忘记密码？</a>
				 </li>
				 <li>
				   <input id="button" class="but" name=' ' type="button" value='' onclick="loginCheck()">
				 </li>
			  </ul>
		   </div>
	   </form>
		   <div class='box4'>
		       合作网站账号登录：<input type='image' src='images/login/5.png' onclick="window.open('vxlogin.jsp')" >  <input type='image' src='images/login/6.png' onclick="window.open('qqlogin.jsp')"></a>
		   <br><br><br><p>客服电话：4008208820</p>
		   </div>
   </div>
  </div>
 </body>
</html>
