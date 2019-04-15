<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript"></script>
<form  class="form-horizontal" role="form" id="editFormId" style="height:300px;overflow:auto; ">

	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >薪酬编号:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="salaryno" id="salaryno"  placeholder="">
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">基本薪资:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="basicssalary" id="basicssalary">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">职级薪资:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="ranksalary" id="ranksalary">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">绩效薪资:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="achievements" id="achievements">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">餐饮补贴:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="mealsalary" id="mealsalary">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">住房补贴:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="housesalary" id="housesalary">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">差旅补贴:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="travelexpenses" id="travelexpenses">
		</div>
	</div>
	<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="note" id="noteId"></textarea>
		</div> 
	</div>
</form>
<c:url var="url" value="employee/salary/salary_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>