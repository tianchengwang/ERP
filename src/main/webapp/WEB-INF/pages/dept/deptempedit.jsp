<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript"></script>
<form  class="form-horizontal" role="form" id="editFormId" style="height:300px;overflow:auto; ">

	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >员工姓名:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="employeeID" id="employeeID"  placeholder="">
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">所属部门:</label> 
		<div class="col-sm-10">
		<select class="form-control" id = "deptno">
			<option>请选择</option>
		</select>
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">工作岗位:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="job" id="job">
		</div>
	</div>
	<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="note" id="noteId"></textarea>
		</div> 
	</div>
</form>
<c:url var="url" value="employee/dept/deptemp_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>