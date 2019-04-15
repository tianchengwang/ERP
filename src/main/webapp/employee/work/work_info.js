$(document).ready(function(){
	doFindObjectById();
});
/*根据id执行查找操作*/
function doFindObjectById(){
	var url="findWorkObjectByEId.do"
	$.post(url,function(result){
		if(result.state==1){
		 doInitEditFormData(result.data);	
		}else{
		 alert(result.message);
		}
	});
}
function doInitEditFormData(obj){
	$("#workmonth").val(obj.workmonth);
	$("#employeeID").val(obj.employeeID);
	$("#workdays").val(obj.workdays);
	$("#traveldays").val(obj.traveldays);
	$("#adddays").val(obj.adddays);
	$("#note").val(obj.note);
}




