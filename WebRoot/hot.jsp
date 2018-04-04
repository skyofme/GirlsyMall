<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hot.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/three-part.css">
    <script>
    	
    </script>
  </head>

  <body>
    <div class="three-part w">
        <div class="first">
            <div class="first-top">
                <h1>推荐好货</h1>
                <a href="javascript:void(0);" target="_parent">发现品质生活</a>
                <i></i>
            </div>
            <div class="first-bottom">
                <ul>
                    <li>
                        <div class="fl border border-bottom a">
                            <a href="/mall/ShoppingCarServlet?goodsId=${first_hot[0].id}" class="first-bottom-brand" target="_parent">${first_hot[0].name}</a>
                            <a href="/mall/ShoppingCarServlet?goodsId=${first_hot[0].id}" class="first-bottom-img first-bottom-img1" target="_parent">
                            	<div id="first-bottom-img1"></div>
                            </a>
                        </div>
                        <div class="fl border-bottom a">
                            <a href="/mall/ShoppingCarServlet?goodsId=${first_hot[1].id}" class="first-bottom-brand" target="_parent">${first_hot[1].name }</a>
                            <a href="/mall/ShoppingCarServlet?goodsId=${first_hot[1].id}" class="first-bottom-img first-bottom-img2" target="_parent">
                            <div id="first-bottom-img2"></div>
                            </a>
                        </div>
                    </li>
                    <li>
                        <div class="fl border border-bottom a">
                            <a href="/mall/ShoppingCarServlet?goodsId=${first_hot[2].id}" class="first-bottom-brand" target="_parent">${first_hot[2].name}</a>
                            <a href="/mall/ShoppingCarServlet?goodsId=${first_hot[2].id}" class="first-bottom-img first-bottom-img3" target="_parent">
                            <div id="first-bottom-img3"></div></a>
                        </div>
                        <div class="fl border-bottom a">
                            <a href="/mall/ShoppingCarServlet?goodsId=${first_hot[3].id}" class="first-bottom-brand" target="_parent">${first_hot[3].name}</a>
                            <a href="/mall/ShoppingCarServlet?goodsId=${first_hot[3].id}" class="first-bottom-img first-bottom-img4"  target="_parent">
                            <div id="first-bottom-img4"></div></a>
                        </div>
                    </li>
                    <li>
                        <div class="fl border a">
                            <a href="/mall/ShoppingCarServlet?goodsId=${first_hot[4].id}" class="first-bottom-brand" target="_parent">${first_hot[4].name}</a>
                            <a href="/mall/ShoppingCarServlet?goodsId=${first_hot[4].id}" class="first-bottom-img first-bottom-img5" target="_parent">
                            <div id="first-bottom-img5"></div></a>
                        </div>
                        <div class="fl a">
                            <a href="/mall/ShoppingCarServlet?goodsId=${first_hot[5].id}" class="first-bottom-brand" target="_parent">${first_hot[5].name}</a>
                            <a href="/mall/ShoppingCarServlet?goodsId=${first_hot[5].id}" class="first-bottom-img first-bottom-img6"  target="_parent">
                            <div id="first-bottom-img6"></div></a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="second">
            <div class="second-top">
                <h1>打折特惠</h1>
                <a href="javascript:void(0);" target="_parent">发现实惠货道</a>
                <i></i>
            </div>
            <div class="second-bottom">
                <ul>
                    <li class="second-bottom-one">
                        <h1 id="second-bottom-one-h1">女人天生爱颜色，彩色数码送佳人</h1>
                        <div class="second-bottom-one-img">
                            <a href="/mall/ShoppingCarServlet?goodsId=${second_hot[0].id}" target="_parent">
                            <div id="second-bottom-one-img1" ></div></a>
                            <a href="/mall/ShoppingCarServlet?goodsId=${second_hot[1].id}"  target="_parent">
                            <div id="second-bottom-one-img2" ></div></a>
                            <a href="/mall/ShoppingCarServlet?goodsId=${second_hot[2].id}" target="_parent">
                            <div id="second-bottom-one-img3" ></div></a>
                        </div>
                    </li>
                    <li class="second-bottom-two">
                        <h1 id="second-bottom-two-h1">变频能省几个钱？还是定频划算</h1>
                        <div class="second-bottom-one-img">
                            <a href="/mall/ShoppingCarServlet?goodsId=${second_hot[3].id}" target="_parent">
                            <div id="second-bottom-two-img4" ></div></a>
                            <a href="/mall/ShoppingCarServlet?goodsId=${second_hot[4].id}" target="_parent">
                            <div id="second-bottom-two-img5" ></div></a>
                            <a href="/mall/ShoppingCarServlet?goodsId=${second_hot[5].id}"  target="_parent">
                            <div id="second-bottom-two-img6"></div></a>
                        </div>
                    </li>
                </ul>
                <ul class="list">
                    <li id="list-li01" class="current"></li>
                    <li id="list-li02"></li>
                    <li id="list-li03"></li>
                </ul>
                <div class="list-arrow">
                    <div class="list-arrow-left" id="list-arrow-left">&lt;</div>
                    <div class="list-arrow-right" id="list-arrow-right">&gt;</div>
                </div>
            </div>
        </div>
        <div class="third">
            <div class="third-top">
                <h1>热销排行</h1>
                <a href="javascript:void(0);">查看更多排行</a>
                <i></i>
            </div>
            <div class="third-bottom">
                <ul class="clearfix">
                    <li class="fl third-border-right third-current">智能手环</li>
                    <li class="fl third-border-right">手机通讯</li>
                    <li class="fl third-border-right">男士内裤</li>
                    <li class="fl third-border-right">早教启智</li>
                    <li class="fl">洗衣机</li>
                </ul>
                <div class="table fl padding-left border-bottom  border-right">
                    <a href="/mall/ShoppingCarServlet?goodsId=${third_hot[0].id}" target="_parent">
                        <img src="${third_hot_imgs[0][5]}" class="br">
                        <span>${third_hot[0].name}</span>
                    </a>
                    <div class="rank rank1">1
                    </div>
                </div>
                <div class="table fl border-bottom border-right">
                    <a href="/mall/ShoppingCarServlet?goodsId=${third_hot[1].id}" target="_parent">
                        <img src="${third_hot_imgs[1][5]}" class="br">
                        <span>${third_hot[1].name}</span>
                    </a>
                    <div class="rank rank2">2
                    </div>
                </div>
                <div class="table fl padding-right border-bottom">
                    <a href="/mall/ShoppingCarServlet?goodsId=${third_hot[2].id}" target="_parent">
                        <img src="${third_hot_imgs[2][5]}" class="br">
                        <span>${third_hot[2].name}</span>
                    </a>
                    <div class="rank rank3">3
                    </div>
                </div>
                <div class="table fl padding-left border-right">
                    <a href="/mall/ShoppingCarServlet?goodsId=${third_hot[3].id}" target="_parent">
                        <img src="${third_hot_imgs[3][5]}" class="br">
                        <span>${third_hot[3].name}</span>
                    </a>
                    <div class="rank rank4">4
                    </div>
                </div>
                <div class="table fl border-right">
                    <a href="/mall/ShoppingCarServlet?goodsId=${third_hot[4].id}" target="_parent">
                        <img src="${third_hot_imgs[4][5]}" class="br">
                        <span>${third_hot[4].name}</span>
                    </a>
                    <div class="rank rank5">5
                    </div>
                </div>
                <div class="table fl padding-right">
                    <a href="/mall/ShoppingCarServlet?goodsId=${third_hot[5].id}" target="_parent">
                        <img src="${third_hot_imgs[5][5]}" class="br">
                        <span>${third_hot[5].name}</span>
                    </a>
                    <div class="rank rank6">6
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
			window.onload=function(){
				var first_hot1 = document.getElementById("first-bottom-img1");
				first_hot1.style.backgroundImage = "url(${first_hot_imgs[0][1]})";
				var first_hot2 = document.getElementById("first-bottom-img2");
				first_hot2.style.backgroundImage = "url(${first_hot_imgs[1][1]})";
				var first_hot3 = document.getElementById("first-bottom-img3");
				first_hot3.style.backgroundImage = "url(${first_hot_imgs[2][1]})";
				var first_hot4 = document.getElementById("first-bottom-img4");
				first_hot4.style.backgroundImage = "url(${first_hot_imgs[3][1]})";
				var first_hot5 = document.getElementById("first-bottom-img5");
				first_hot5.style.backgroundImage = "url(${first_hot_imgs[4][1]})";
				var first_hot6 = document.getElementById("first-bottom-img6");
				first_hot6.style.backgroundImage = "url(${first_hot_imgs[5][1]})";
				
				var second_hot1 = document.getElementById("second-bottom-one-img1");
				second_hot1.style.backgroundImage = "url(${second_hot_imgs[0][1]})";
				var second_hot2 = document.getElementById("second-bottom-one-img2");
				second_hot2.style.backgroundImage = "url(${second_hot_imgs[1][1]})";
				var second_hot3 = document.getElementById("second-bottom-one-img3");
				second_hot3.style.backgroundImage = "url(${second_hot_imgs[2][1]})";
				var second_hot4 = document.getElementById("second-bottom-two-img4");
				second_hot4.style.backgroundImage = "url(${second_hot_imgs[3][1]})";
				var second_hot5 = document.getElementById("second-bottom-two-img5");
				second_hot5.style.backgroundImage = "url(${second_hot_imgs[4][1]})";
				var second_hot6 = document.getElementById("second-bottom-two-img6");
				second_hot6.style.backgroundImage = "url(${second_hot_imgs[5][1]})";
				
			}
</script> 
  </body>
</html>
