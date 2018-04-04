
    /**
     * Created by Administrator on 2017/6/27 0027.
     */
    window.onload = function(){
        var play = null;
        var id = 1;
        var main_slider = document.getElementById("main-slider");
        function getId(Id){
            return document.getElementById(Id);
        }
        function setCurrent(id){
            getId(id).className = "current";
        }
        function setNotCurrent() {
            getId("slider-circle1").className = "";
            getId("slider-circle2").className = "";
            getId("slider-circle3").className = "";
            getId("slider-circle4").className = "";
            getId("slider-circle5").className = "";
            getId("slider-circle6").className = "";
        }
        function show(id){
            setNotCurrent();
            if(id==1){
                img.src="images/slider/slider-img1.jpg";
                setCurrent("slider-circle1")
            }else if(id==2){
                img.src="images/slider/slider-img2.jpg";
                setCurrent("slider-circle2")
            }else if(id==3){
                img.src="images/slider/slider-img3.jpg";
                setCurrent("slider-circle3")
            }else if(id==4){
                img.src="images/slider/slider-img4.jpg";
                setCurrent("slider-circle4")
            }else if(id==5){
                img.src="images/slider/slider-img5.jpg";
                setCurrent("slider-circle5")
            }else {
                img.src="images/slider/slider-img6.jpg";
                setCurrent("slider-circle6")
            }
        }
        getId("slider-circle1").onmouseover = function() {
            id = 1;
            show(1);
        };
        getId("slider-circle2").onmouseover = function() {
            id = 2;
            show(2);
        };
        getId("slider-circle3").onmouseover = function() {
            id = 3;
            show(3);
        };
        getId("slider-circle4").onmouseover = function() {
            id = 4;
            show(4);
        };
        getId("slider-circle5").onmouseover = function() {
            id = 5;
            show(5);
        };
        getId("slider-circle6").onmouseover = function() {
            id = 6;
            show(6);
        };

        function autoplay(){
            if(id==6){
                id=0;
            }
            id++;
            show(id);
        }
        play = setInterval(autoplay,2000);
        main_slider.onmouseover = function(){
            getId("arrow-l").style.display = "block";
            getId("arrow-r").style.display = "block";
            clearInterval(play);
        };
        main_slider.onmouseout = function(){
            getId("arrow-l").style.display = "none";
            getId("arrow-r").style.display = "none";

            play=setInterval(autoplay,2000);
        };

        getId("arrow-l").onclick = function(){
        	if(id<=1){
        		id=7;
        	}
            id--;
            show(id);
        };
        getId("arrow-r").onclick = function(){
        	if(id>=6){
        		id=0;
        	}
            id++;
            show(id);
        };
    };


