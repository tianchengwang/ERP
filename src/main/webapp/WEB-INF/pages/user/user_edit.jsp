<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form  class="form-horizontal" role="form" id="editFormId">
<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >员工编号:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="e_id" id="e_id"  placeholder="请输入名字">
	    </div>
	</div>
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >用户名:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="u_username" id="u_username"  placeholder="请输入名字">
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">用户密码:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="u_password" id="u_password">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">电子邮箱:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="u_email" id="u_email">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">用户电话:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="u_mobile" id="u_mobile">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">用户地址:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="u_address" id="u_address">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">是否有效:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="u_valid" id="u_valid">
		</div>
	</div>

	<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="remark" id="remark"></textarea>
		</div> 
	</div>
</form>
<c:url var="url" value="employee/user/user_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>