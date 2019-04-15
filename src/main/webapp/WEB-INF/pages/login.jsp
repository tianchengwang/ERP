<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录人事管理系统</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/cloud.js" type="text/javascript"></script>

<script language="javascript">

$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

<script language="javascript" type="text/javascript" >
$(document).ready(function(){
	
	var message = '${message}';
	if(message){
		$('#errorMessage').parent().parent().css('display','block');
		$('#errorMessage').text(message);
	}
		
})	
function checkParams(){
	debugger;
	var userName = $('#username').val();
	var userPwd = $('#userpwd').val();
	if(userName==''){
		$('#errorMessage').parent().parent().css('display','block');
		$('#errorMessage').text('用户名不能为空！');
		return false;
	}
	if(userPwd==''){
		$('#errorMessage').parent().parent().css('display','block');
		$('#errorMessage').text('密码不能为空！');
		return false;
	}
	return true;
	
}
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录人事管理系统</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    
     
    <form action="login.do" method ="post"  onsubmit="return checkParams()">
    <ul>
    <li>
    	<div class="alert alert-danger alert-dismissible" style="display:none">
        	<h4 style="margin-bottom: 0px;"><i class="fa fa-exclamation-triangle" id="errorMessage"></i></h4>
    </div>
    </li>
    <li>
    	<input id="username" name="username" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/>
    </li>
    <li>
    	<input id="userpwd" name="userpwd" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/>
    </li>
    <li>
	    <input id="btn-login" name="" type="submit" class="loginbtn" value="登录"   />
	    <label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label>
    </li>
    </ul>
      </form>
    
    </div>
    
    </div>
  
    
    
    <div class="loginbm">版权所有  @tcwang	 仅供学习交流，勿用于任何商业用途</div>
</body>
</html>


