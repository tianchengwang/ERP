<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form  class="form-horizontal" role="form" id="editFormId">
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >消息内容:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="m_question" id="question"  placeholder="请输入名字">
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">消息详情:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="m_answer" id="answer">
		</div>
	</div>
	

	<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="remark" id="remark"></textarea>
		</div> 
	</div>
</form>
<c:url var="url" value="employee/message/message_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>