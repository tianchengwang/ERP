<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form  class="form-horizontal" role="form" id="editFormId" style="height:300px;overflow:auto; ">
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >申请类型:</label> 
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
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="note" id="note"></textarea>
		</div> 
	</div>
</form>


<c:url var="url" value="/employee/apply/apply_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>