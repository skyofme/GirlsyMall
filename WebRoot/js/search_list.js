/**
 * Created by Administrator on 2017/7/5 0005.
 */

$(document).ready(function(){
	$(".w-ul li").mouseover(function(){
		$(this).children().eq(1).css('display','block');
	});
	$(".w-ul li").mouseout(function(){
		$(this).children().eq(1).css('display','none');
	});
});