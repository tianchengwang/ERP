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
<script type="text/javascript" src="${basePath}/employee/work/work_info.js"></script>
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
    <li><a href="salaryInfo.do">考勤信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>考勤信息</span></div>
    
    <ul class="forminfo">
	    <li><label>工作月份</label><input id="workmonth" name="" type="text" class="dfinput"  /></li>
	   	<li><label>员工编号</label><input id="employeeID" name="" type="text" class="dfinput" value="" /></li>
	   	<li><label>正常工作天数</label><input id="workdays" name="" type="text" class="dfinput"  /></li>
	    <li><label>差旅天数</label><input id="traveldays" name="" type="text" class="dfinput" /></li>
	   	<li><label>加班天数</label><input id="adddays" name="" type="text" class="dfinput" value="" /></li>
	   	<li><label>备注</label><input id="note" name="" type="text" class="dfinput"  /></li>
    </ul>
    
    
    </div>
</body>
</html>
