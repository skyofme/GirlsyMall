/**加载省份列表到选择框*/
$("#province").empty();
for(var i=0,length=arrCity.length; i<length; i++){
    $("#province").append("<option value='"+arrCity[i].name+"'>"+arrCity[i].name+"</option>");
}

var province;
var city;
var county;

/**省份选择后加载城市数据*/
$("#province").change(function(){
    console.log("省份:" + $("#province").val());
    for(var i=0,length=arrCity.length; i<length; i++){
        if($("#province").val()==arrCity[i].name){
            city = arrCity[i].sub;
            break;
        }
    }
    $("#city").empty();
    for(var i=0,length=city.length; i<length; i++){
        $("#city").append("<option value='"+city[i].name+"'>"+city[i].name+"</option>");
    }
})

/**城市选择后加载区县数据*/
$("#city").change(function(){
    console.log("城市:"+$("#city").val());
    for(var i=0,length=city.length;i<length;i++){
        if($("#city").val()==city[i].name){
            county = city[i].sub;
            break;
        }
    }
    $("#county").empty();
    for(var i=0,length=county.length; i<length; i++){
        $("#county").append("<option value='"+county[i].name+"'>"+county[i].name+"</option>");
    }
})

$("#province").val();//获取当前选择项的值.
var options=$("#province option:selected");//获取当前选择项.
options.val();//获取当前选择项的值.

$("#city").val();//获取当前选择项的值.
var options=$("#city option:selected");//获取当前选择项.
options.val();//获取当前选择项的值.

$("#county").val();//获取当前选择项的值.
var options=$("#county option:selected");//获取当前选择项.
options.val();//获取当前选择项的值.
