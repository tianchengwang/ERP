<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form  class="form-horizontal" role="form" id="editFormId" style="height:300px;overflow:auto; ">
	<input type="hidden"  id="employeeID">
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >申请人:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="applyman" id="applyman"  placeholder="">
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">申请类型:</label> 
		<div class="col-sm-10">
		<select class="form-control" id = "applytype">
			<option value="1">请假申请</option>
			<option value="2">设备申请</option>
			
		</select>
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">申请内容:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="applycontent" id="applycontent">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">申请时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="applytime" id="applytime">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">申请状态:</label> 
		<div class="col-sm-10">
		<select class="form-control" id ="applystatus">
			<option value="0">申请中</option>
			<option value="1">通过</option>
			<option value="2">拒绝</option>
		</select>
		</div>
	</div>
	<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="note" id="noteId"></textarea>
		</div> 
	</div>
</form>
<c:url var="url" value="employee/apply/applyemp_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>