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
<script type="text/javascript" src="${basePath}/employee/employee/employee_info.js"></script>
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
    <li><a href="#">个人信息</a></li>
    <li><a href="#">基本信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <table>
	    <tr>
		    <td>
		    	<ul class="forminfo">
				    <li><label>工号</label><input id="employeeID" name="" type="text" class="dfinput"  /></li>
				   	<li><label>性别</label><input id="sex" name="" type="text" class="dfinput" value="" /></li>
				   	<li><label>入职日期</label><input id="inDate" name="" type="text" class="dfinput"  /></li>
				    <li><label>合同结束日期</label><input id="endDate" name="" type="text" class="dfinput" /></li>
				   	<li><label>毕业时间</label><input id="graduatedDate" name="" type="text" class="dfinput" value="" /></li>
				   	<li><label>档案所在地</label><input id="fileLocation" name="" type="text" class="dfinput"  /></li>
				    <li><label>紧急联系人</label><input id="emergencyContact" name="" type="text" class="dfinput" /></li>
			    </ul>
		    
		    </td>
		    	
		    <td>
		    	<ul class="forminfo">
				    <li><label>身份证号</label><input id="certID" name="" type="text" class="dfinput" /></li>
				   	<li><label>出生年月</label><input id="birthday" name="" type="text" class="dfinput" value="" /></li>
				   	<li><label>转正日期</label><input id="regularDate" name="" type="text" class="dfinput"  /></li>
				    <li><label>学历</label><input id="education" name="" type="text" class="dfinput" /></li>
				   	<li><label>籍贯</label><input id="nativePlace" name="" type="text" class="dfinput" value="" /></li>
				   	<li><label>手机</label><input id="mobilePhone" name="" type="text" class="dfinput"  /></li>
				    <li><label>紧急联系电话</label><input id="emergencyContactPhone" name="" type="text" class="dfinput" /></li>
			    </ul>
		    	
		    </td>
		    
		    <td>
		    	<ul class="forminfo">
				    <li><label>姓名</label><input id="employeeName" name="" type="text" class="dfinput" /></li>
				    <li><label>职级</label><input id="grade" name="" type="text" class="dfinput" value="" /></li>
				    <li><label>合同开始日期</label><input id="contractDate" name="" type="text" class="dfinput" /></li>
				    <li><label>毕业院校</label><input id="University" name="" type="text" class="dfinput" /></li>
				    <li><label>户口所在地</label><input id="registeredResidence" name="" type="text" class="dfinput" value="" /></li>
				    <li><label>办公电话</label><input id="officePhone" name="" type="text" class="dfinput"  /></li>
				    <li><label>公司</label><input id="company" name="" type="text" class="dfinput" /></li>
			    </ul>
		    
		    </td>
	    </tr>
    </table>
   
    
    </div>
</body>
</html>
