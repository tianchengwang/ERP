$(document).ready(function(){
	doFindObjectById();
});
/*根据id执行查找操作*/
function doFindObjectById(){
	var url="findSalaryObjectByEId.do"
	$.post(url,function(result){
		if(result.state==1){
		 doInitEditFormData(result.data);	
		}else{
		 alert(result.message);
		}
	});
}
function doInitEditFormData(obj){
	/*$("#salaryno").val(obj.salaryno);*/
	/*$("#employeeID").val(obj.employeeID);*/
	$("#employeeName").val(obj.attribute);
	$("#basicssalary").val(obj.basicssalary);
	$("#ranksalary").val(obj.ranksalary);
	$("#achievements").val(obj.achievements);
	$("#mealsalary").val(obj.mealsalary);
	$("#housesalary").val(obj.housesalary);
	$("#travelexpenses").val(obj.travelexpenses);
	$("#totalsalary").val(obj.totalsalary);
}




