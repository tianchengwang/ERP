<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="${basePath}/employee/dept/dept_info.js"></script>
<script type="text/javascript" src="${basePath}/jquery/jquery-1.11.1.js"></script> 


<script src="${basePath}/jquery/jquery-ui.min.js"></script>
<script src="${basePath}/jquery/jquery.validate.min.js"></script>
<script src="${basePath}/jquery/jquery.form.js"></script>
<script type="text/javascript">
$(function(){
	$("input").attr("disabled","disabled");
})
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="right.do">个人信息</a></li>
    <li><a href="deptInfo.do">部门信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>部门信息</span></div>
    
    <ul class="forminfo">
	    <li><label>部门编号</label><input id="deptno" name="" type="text" class="dfinput"  /></li>
	   	<li><label>部门名称</label><input id="deptname" name="" type="text" class="dfinput" value="" /></li>
	   	<li><label>部门所在地</label><input id="local" name="" type="text" class="dfinput"  /></li>
	    <li><label>部门领导</label><input id="deptleader" name="" type="text" class="dfinput" /></li>
    </ul>
    
    
    </div>
</body>
</html>
