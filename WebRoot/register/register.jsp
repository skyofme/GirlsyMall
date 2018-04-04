<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/register/register.css" />
<script type="text/javascript">
  	function registCheck(){
  		var user = document.getElementById("user").value;
  		var pswd = document.getElementById("password").value;
  		var tpswd = document.getElementById("password2").value;
  		
  		obj = document.getElementsByName("Read");
    	check_val = [];
    	for(k in obj){
        	if(obj[k].checked)
            	check_val.push(obj[k].value);
    	}
    	
 		if(user==""||pswd==""||tpswd==""){
 			alert("请输入完整信息");
 			return false;
 		} else if (pswd != tpswd) {
 			alert("两次密码输入不一致");
 			return false;
 		}else if(check_val!="read"){
 			alert("您未勾选《用户注册协议哟~》");
 			return false;
 		}
  		document.getElementById("registForm").submit();
  	}
  </script>
  

</head>

<body>
<div class='box5'>
    <a href="http://localhost:8080/mall/index.jsp"><div id='div1'></div></a>
    <div class='box6'>欢迎注册</div>
    <div class='box7'>已有账号？ <a href="http://localhost:8080/mall/login.jsp">请登录</a></div>
    </div>
	<div class='box1'>
		<div class='box2'>
			<form id="registForm" action = "/mall/RegistCustom" method = "post">
				<div class='box3' >
				<ul>
				 <li class=''>						
				   <input id='user' class='wh bord user' type="text"   placeholder='用户名' name="User" onblur="checkUserName()" >
				   <span id="nameInfo" style="color: red;" ></span>
				 </li>
                 
				 <li class=''>
				   <input id='password' class='wh bord' type="password" placeholder='填写密码' name="Pswd" onblur="checkPassword()">
				   <span id="passwordInfo" style="color: red;"></span>
				 </li>
				
				 <li class=''>
				   <input id='password2' class='wh bord tu' type="password" placeholder='确定密码' name="Tpswd" onblur="checkRepassword()">
				   <span id="repasswordInfo" style="color: red;"></span>
				 </li>
				 
				 <li class=''>
				   <input id='tel' class='wh bord tel' type="text" placeholder='手机号' name="Tel" onblur="checkTel()">
				   <span id="telInfo" style="color: red;"></span>
				 </li>
				 
				  <li class=''>
				   <input id='addr' class='wh bord addr' type="text" placeholder='详细地址' name="Addr" onblur="checkAddr()">
				   <span id="addrInfo" style="color: red;"></span>
				 </li>	
				 
				 
				 <ul  >
                 <li style="float: left"  >
                   <a class="add" style="text-align:left">地址&nbsp;</a>
                   <select id="province" name="province">
                   <option value=""></option>
                   </select>
                 </li>
                 <li style="float: left">
                   <select id="city" name="city">
                   <option value="" >城市</option>
                   </select>
                 </li>
                 <li style="float: left">
                   <select id="county" name="county">
                   <option value="" >区县</option>
                   </select>
                 </li>
                  
                 </ul>                
				 <li class='' text-decoration="none;" style="margin-top: 15px;margin-left: 10px;">
				 <label><input id='Man' name="Regi" type="radio" value="男" checked="checked"/><p>男&nbsp;&nbsp;</p> </label> 
					  <label><input name="Regi" type="radio" value="女" /><p>女</p> </label><br>
					   <input id='checkbox' type="checkbox" value='read' name="Read"><p>阅读并同意</p>
					   <a href="#" >《用户注册协议》</a><a href="#" >《隐私政策》</a>
				 </li>	
				 
				 <li>
				 <input id='button' class='but' name="Butt" type='button' onclick="registCheck()">
				 </li>
				</ul>
				</div>
			</form>
		</div>
	</div>
	<div  class='box8'>
    <div class='box9'>
        <a rel="nofollow" target="_blank" href="#">关于我们|</a>
        <a rel="nofollow" target="_blank" href="#">联系我们|</a>
        <a rel="nofollow" target="_blank" href="#">人才招聘|</a>
        <a rel="nofollow" target="_blank" href="#">商家入驻|</a>
        <a rel="nofollow" target="_blank" href="#">广告服务|</a>
        <a rel="nofollow" target="_blank" href="#">手机京东|</a>
        <a target="_blank" href="#">友情链接|</a>
        <a target="_blank" href="#">销售联盟|</a>
        <a href="#" target="_blank">京东社区|</a>
        <a href="#" target="_blank">京东公益|</a>
        <a target="_blank" href="#" clstag="pageclick|keycount|20150112ABD|9">English Site</a>
    </div>
    <div class='box10'>
        Copyright&copy;2004-2016&nbsp;&nbsp;Girlsy Mall.com&nbsp;版权所有
    </div>
</div>
<script src="js/rejs/jquery.js" type="text/javascript"></script>
<script src="js/rejs/sitedata_bas.js" type="text/javascript"></script>
<script src="js/rejs/register.js" type="text/javascript"></script>
<script src="js/rejs/regis.js" type="text/javascript"></script>
</body>
</html>
