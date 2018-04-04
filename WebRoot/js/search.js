    /**
     * Created by Administrator on 2017/7/2 0002.
     */
    var search = document.getElementById("search-input-text");
    var label = document.getElementById("search-input-label");
    var text = search.value;
//    search.onfocus = function(){
//        if(search.value == text){
//            search.value = "";
//            search.style.color="#333";
//        }
//    };
//    search.onblur = function(){
//        if((search.value == text)||(search.value=="")){
//            search.value = text;
//            search.style.color="#888";
//        }
//    };
    search.oninput = search.onpropertychange = function(){
    	label.style.display = "none";
    }
    search.onblur = search.onpropertychange = function(){
    	if(search.value == ""){
    		label.style.display = "block";
    	}else {
    		label.style.display = "none";
    	}
    }