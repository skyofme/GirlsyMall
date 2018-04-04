$(document).ready(function () {
   function validateForm(){
     if(checkUserName()&&checkPassword()&&checkRepassword()&&checkTel()){
         alert("恭喜您！注册成功！");
     }
}
});

//验证用户名（为3~16个字符，且不能包含”@”和”#”字符）
function checkUserName(){
    var name=document.getElementById("user").value.trim();
    var nameRegex=/^[^@#]{3,16}$/;
    if(!nameRegex.test(name)){
        document.getElementById("nameInfo").innerHTML="用户名为3~16个字符，且不能包含”@”和”#”字符";
    }else{
        document.getElementById("nameInfo").innerHTML="";
        return true;
    }

}

//验证密码（长度在8个字符到16个字符）
function checkPassword(){
    var password=document.getElementById("password").value.trim();
    //var password=$("#password").value;
    //$("#passwordInfo").innerHTML="";
    //密码长度在8个字符到16个字符，由字母、数字和".""-""_""@""#""$"组成
    //var passwordRegex=/^[0-9A-Za-z.\-\_\@\#\$]{8,16}$/;
    //密码长度在8个字符到16个字符，由字母、数字和"_"组成
    var passwordRegex=/^[0-9A-Za-z_]\w{5,15}$/;
    if(!passwordRegex.test(password)){
        document.getElementById("passwordInfo").innerHTML="密码长度必须在6个字符到16个字符之间";
    }else{
        document.getElementById("passwordInfo").innerHTML="";
    }
}
//验证校验密码（和上面密码必须一致）
function checkRepassword(){
    var password2=document.getElementById("password2").value.trim();
    var password=document.getElementById("password").value.trim();
    //校验密码和上面密码必须一致
    if(password2!==password){
        document.getElementById("repasswordInfo").innerHTML="两次输入的密码不一致";
    }else if(password2==password){
        document.getElementById("repasswordInfo").innerHTML="";
    }
}

//验证手机号
function checkTel(){
    var tel=document.getElementById("tel").value.trim();
    //手机号位数   
    var reg = /^[1][3578]\d{9}$/;
    if(!reg.test(tel)){
    	
        document.getElementById("telInfo").innerHTML="手机号必须为以13、15、17、18开头的11位数字";
    }else {
        document.getElementById("telInfo").innerHTML="";
    }
}