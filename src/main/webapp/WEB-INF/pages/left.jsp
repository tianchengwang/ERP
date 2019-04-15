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
	$('dd').find('ul').slideUp();
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
	
})	


</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>管理菜单</div>
    
    <dl class="leftmenu">
        	
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>个人信息
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="empInfo.do" target="rightFrame">基本信息</a><i></i></li>
        <li><cite></cite><a href="deptInfo.do" target="rightFrame">部门信息</a><i></i></li>
        <li><cite></cite><a href="salaryInfo.do" target="rightFrame">薪酬信息</a><i></i></li>
        <li><cite></cite><a href="workInfo.do" target="rightFrame">出勤信息</a><i></i></li>
        <li><cite></cite><a href="equipmentInfo.do" target="rightFrame">设备信息</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>功能菜单
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="apply.do" target="rightFrame">请假、设备申请</a><i></i></li>
        </ul>     
    </dd> 
    </dl>
</body>
</html>
