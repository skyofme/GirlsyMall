<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'good_detail_center.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/good_center-detail.css">
    <style>
    	#msg{
		position:fixed; 
		top:337px; 
		right:35px; 
		z-index:10000;
		width:1px; 
		height:52px; 
		line-height:52px;
		 font-size:20px; 
		 text-align:center;
		 color:#fff; 
		 background:#360; 
		 display:none
	  }
	  .u-flyer{
	  display: block;
	  width: 50px;
	  height: 50px;
	  border-radius: 50px;
	  position: fixed;
	  z-index: 9999;}
	  
    </style>
    <script src="js/jquery.js"  type="text/javascript"></script>
   	<script src="js/requestAnimationFrame.js"  type="text/javascript"></script>
   	<script src="js/jquery.fly.min.js"  type="text/javascript"></script>
	<script type="text/javascript" src="js/good_detail_center.js"></script>
    <script type="text/javascript" src="js/magnifer.js"></script>
    
    <script type="text/javascript">
    
    function loginCheck2(loginState,role){
    	if(loginState == "true"&&role=="custom"){
    		
			var amount = $(".input").val();
			$.post("/mall/MyShoppingCarServlet", {
				buyNum : amount,
			}, function(data, status) {
				$(".search-car-icon3").text(data);
			});
			
    		return true;
    	}
    	else{
	    	if(window.confirm('你没登录哟，要去登录吗？')){
				window.parent.location.href = "/mall/login.jsp";
				return false;
			}else{
				return false;
			}
    	}
    }
    
    $(function() {
    	
    	var offset = $("#end").offset();
    	$(".add").click(function(event){
    		if(${loginState=='true'}&&${role=='custom'}){
    		var addcar = $(this);
    		var img = $("#big-img").attr('src');
    		var flyer = $('<img class="u-flyer" src="'+img+'">');
    		flyer.fly({
    			start: {
    				left: event.clientX,
    				top: event.clientY
    			},
    			end: {
    				left: offset.left+10,
    				top: offset.top+10,
    				width: 0,
    				height: 0
    			},
    			onEnd: function(){
    				$("#msg").show().animate({width: '250px'}, 200).fadeOut(1000);
    				//addcar.css("cursor","default").removeClass('orange').unbind('click');
    				this.destory();
    			}
    		});
    		var amount = $(".input").val();
    		$.post("/mall/MyShoppingCarServlet", {
    			buyNum : amount,
    		}, function(data, status) {
    			$(".search-car-icon3").text(data);
    		});
    		
    		return true;
    	}
    	else{
        	if(window.confirm('你没登录哟，要去登录吗？')){
    			window.parent.location.href = "/mall/login.jsp";
    			return false;
    		}else{
    			return false;
    		}
    	}
    		
    	});
    	
    	
    });
    </script>
  </head>
  
  <body>
    <div class="w detail-center">
        <div class="center-left" id="center-left">
            <div class="big" id="big">
                <img src="${p2 }" id="center-img">
                <div class="mask" id="mask"></div>
            </div>
            <div id="big-div" class="big-div">
                <img src="${p3 }" id="big-img">
            </div>
            <div class="left-small">
                <ul>
                    <li id="img1" onmouseover="a('${p1}')"><img src="${p1}" ></li>
                    <li id="img2" onmouseover="a('${p4}')"><img src="${p4}" ></li>
                    <li id="img3" onmouseover="a('${p7}')"><img src="${p7}" ></li>
                    <li id="img4" onmouseover="a('${p10}')"><img src="${p10}" ></li>
                    <li id="img5" onmouseover="a('${p13}')"><img src="${p13}"></li>
                </ul>
                	<div class="detail_arrow_l" id="detail_arrow_l" >&lt;</div>
                	<div class="detail_arrow_r" id="detail_arrow_r">&gt;</div>
            </div>
            <div class="left-bottom">
                <a href="/mall/CollectionServlet?op=add" target="_parent" onclick=" return loginCheck('${loginState}');">
                    <i class="left-bottom-spirit"></i>
                    <em>加入收藏</em>
                </a>
                <a href="javascript:void(0);" target="_parent">
                    <i class="left-bottom-spirit2"></i>
                    <em>分享</em>
                </a>
            </div>
        </div>
        <div class="center-right">
            <div class="center-right-left">
                <div class="brand">
                    <h1>${a_goods.name }  ${a_goods.desc }</h1>
                </div>
                <div class="price">
                    <span class="span1">优惠价：</span><span class="span11"><i>￥<fmt:formatNumber maxFractionDigits="2" value="${(a_goods.price)*(a_goods.discount)/10}" type="number"></fmt:formatNumber></i></span><del>${a_goods.price }</del><br>
                    <span class="span2">折扣：</span><span class="span22"><fmt:formatNumber maxFractionDigits="0" value="${a_goods.discount}" type="number"></fmt:formatNumber>折</span><br>
                    <span class="span3">数量：</span><span class="span33">${a_goods.storage}</span>
                </div>
                <div class="address">
                	<c:if test="${loginState=='true'}">
                		<c:if test="${role=='admin'}">
		                    <span class="span4">发送至：</span><span class="span44">江西省南昌市青山湖区江西理工大学1180号</span>
                		</c:if>
                		<c:if test="${role=='custom'}">
                			<span class="span4">发送至：</span><span class="span44">${custom.addr}</span>
                		</c:if>
                	</c:if>
                	<c:if test="${loginState!='true'}">
                    	<span class="span4">发送至：</span><span class="span44"><a href="login.jsp">您未登录，是否去登录？</a></span>
                	</c:if>
                </div>
                
               <!--  <form id="gotoShopppingCar" action="/mall/MyShoppingCarServlet" method="post" target="_parent"> -->
	                <div class="shopping-car">
	                    <div class="amount">
	                        <button class="dec"  type="button">-</button><input type="text" class="input" name="buyNum" value="1"><button class="inc"  type="button">+</button>
	                    </div>
	                    <input class="add" type="submit" value="加入购物车" >
	                </div>
            	<!-- </form>  -->
            </div>
            <div class="center-right-right">
               <span>看了又看</span>
	               <ul>
	              		<c:forEach items="${moreGoods }" var="moreGood">
	              					<li>
	              						<a href="/mall/ShoppingCarServlet?goodsId=${moreGood.id}" target="_parent">
	                          				<img src="${moreGood.img}">
	                      				</a>
	              					</li>
	              		</c:forEach>
	               </ul>
            </div>
        </div>
    </div>
  </body>
</html>

