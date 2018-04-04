
$(document).ready(function() {
		$(".order-download").mouseover(function(){
			$(".order-download-one").css("display","block");
			$(this).css("background","#fff");
		});
		$(".order-download").mouseout(function(){
			$(".order-download-one").css("display","none");
			$(this).css("background","#F1F1F1");
		});
		
		$(".site-nav-send").mouseover(function(){
			$(this).children().children().css("top","-6px");
		});
		$(".site-nav-send").mouseout(function(){
			$(this).children().children().css("top","1px");
		});
		$(".fore").mouseover(function(){
			$(this).children().eq(1).children().css("top","-6px");
		});
		$(".fore").mouseout(function(){
			$(this).children().eq(1).children().css("top","1px");
		});
		
		$(".contact-download").mouseover(function(){
			$(".contact-us").css("display","block");
			$(this).css("background","#fff");
		});
		$(".contact-download").mouseout(function(){
			$(".contact-us").css("display","none");
			$(this).css("background","#F1F1F1");
		});
	});