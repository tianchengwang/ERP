<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})
	//用户信息
	var username = '${emp.employeeName}';
	$("#head-login").html('欢迎,'+username);
	
})	

</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    	<img src="images/logo.png" title="系统首页" /> 
    </div>
        
    <ul class="nav">
    <li><a href="emplist.do" target="rightFrame" class="selected"><img src="images/icon01.png" title="人事档案" /><h2>员工档案</h2></a></li>
    <li><a href="deptemplistM.do" target="rightFrame"><img src="images/icon02.png" title="关系调动" /><h2>关系调动</h2></a></li>
    <li><a href="salarylistM.do" target="rightFrame"><img src="images/icon05.png" title="员工调薪" /><h2>员工调薪</h2></a></li>
    <li><a href="applylistM.do"  target="rightFrame"><img src="images/icon03.png" title="申请信息" /><h2>申请信息</h2></a></li>
    <li><a href="messageMlist.do"  target="rightFrame"><img src="images/icon04.png" title="员工培训" /><h2>员工培训</h2></a></li>
    <li><a href="userMlist.do"  target="rightFrame"><img src="images/icon06.png" title="系统设置" /><h2>用户管理</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="toLogin.do" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span id="head-login"></span>
    </div>    
    
    </div>
</body>
</html>