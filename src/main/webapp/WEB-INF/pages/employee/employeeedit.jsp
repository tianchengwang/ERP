<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$('.datepicker').datepicker({
    format: 'yyyy/mm/dd',
    autoclose: true//选中自动关闭
})
</script>
<form  class="form-horizontal" role="form" id="editFormId" style="height:300px;overflow:auto; ">
	<!-- 
	<label>工号</label><input id="employeeID" name="" type="text" class="dfinput"  />
    -->
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >姓名:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="employeeName" id="employeeName"  placeholder="请输入名字">
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">性别:</label> 
		<div class="col-sm-10">
            <label class="radio-inline"><input  type="radio" name="sex" checked value="1" >男</label>
            <label class="radio-inline"><input  type="radio" name="sex" value="2">女</label>
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">身份证号:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="certID" id="certID">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">出生年月:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker" name="birthday" id="birthday">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">籍贯:</label> 
		<div class="col-sm-10" id="nativePlace">
			省：
			<select class="form-control" onchange="chg1('Lsheng');" id = "Lsheng">
				<option>请选择</option>
			</select>
			市：
			<select class="form-control" onchange="chg2('Lshi');" id = "Lshi">
				<option>请选择</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">学历:</label> 
		<div class="col-sm-10">
		<select class="form-control" id = "education">
			<option value="0">其他</option>
			<option value="1">高中</option>
			<option value="2">大专</option>
			<option value="3">本科</option>
			<option value="4">硕士</option>
			<option value="5">博士</option>
		</select>
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">毕业院校:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="university" id="university">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">毕业时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker" name="graduatedDate" id="graduatedDate">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">手机:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="mobilePhone" id="mobilePhone">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">入职日期:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker" name="inDate" id="inDate">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">职级:</label> 
		<div class="col-sm-10">
		<select class="form-control" id = "grade">
			<option value="T0">普通员工</option>
			<option value="T1">组长</option>
			<option value="T2">项目经理</option>
			<option value="T3">项目总监</option>
			<option value="T4">总经理</option>
			<option value="T5">总裁</option>
		</select>
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">户口所在地:</label> 
		<div class="col-sm-10" id="registeredResidence">
		省：
			<select class="form-control" onchange="chg1('Hsheng');" id = "Hsheng">
				<option>请选择</option>
			</select>
			市：
			<select class="form-control" onchange="chg2('Hshi');" id = "Hshi">
				<option>请选择</option>
			</select>
			区县：
			<select class="form-control" id = "Hqu">
				<option>请选择</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">档案所在地:</label> 
		<div class="col-sm-10" id="fileLocation">
		省：
			<select class="form-control" onchange="chg1('Fsheng');" id = "Fsheng">
				<option>请选择</option>
			</select>
			市：
			<select class="form-control" onchange="chg2('Fshi');" id = "Fshi">
				<option>请选择</option>
			</select>
			区县：
			<select class="form-control" id = "Fqu">
				<option>请选择</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">合同开始日期:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker" name="contractDate" id="contractDate">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">合同结束日期:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker" name="endDate" id="endDate">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">办公电话:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="officePhone" id="officePhone">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">紧急联系人:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="emergencyContact" id="emergencyContact">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">紧急联系电话:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="emergencyContactPhone" id="emergencyContactPhone">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">转正日期:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker" name="regularDate" id="regularDate">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">公司:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="company" id="company">
		</div>
	</div>
   	
	<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="note" id="noteId"></textarea>
		</div> 
	</div>
</form>
<c:url var="url" value="employee/employee/employee_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>