$(document).ready(function(){
	doFindObjectById();
});
/*根据id执行查找操作*/
function doFindObjectById(){
	var url="findEmpObjectById.do"
	$.post(url,function(result){
		if(result.state==1){
		 doInitEditFormData(result.data);	
		}else{
		 alert(result.message);
		}
	});
}
function doInitEditFormData(obj){
	$("#employeeID").val(obj.employeeID);
	$("#employeeName").val(obj.employeeName);
	$("#certID").val(obj.certID);
	
	var sexitemno = obj.sex;
	doFindCodeObject("sex","Sex",sexitemno)
	
	$("#birthday").val(obj.birthday);
	
	var gradeitemno = obj.grade;
	doFindCodeObject("grade","Rank",gradeitemno);
	
	$("#inDate").val(obj.inDate);
	$("#regularDate").val(obj.regularDate);
	$("#contractDate").val(obj.contractDate);
	$("#endDate").val(obj.endDate);
	
	var educationitemno = obj.education;
	doFindCodeObject("education","Education",educationitemno)
	
	$("#University").val(obj.university);
	$("#graduatedDate").val(obj.graduatedDate);
	

	var Nitemno = obj.nativePlace;
	doFindCodeObject("nativePlace","Address",Nitemno);
	
	var Hitemno = obj.registeredResidence;
	doFindCodeObject("registeredResidence","Address",Hitemno);

	var Fitemno = obj.fileLocation;
	doFindCodeObject("fileLocation","Address",Fitemno);
	
	
	$("#mobilePhone").val(obj.mobilePhone);
	$("#officePhone").val(obj.officePhone);
	$("#emergencyContact").val(obj.emergencyContact);
	$("#emergencyContactPhone").val(obj.emergencyContactPhone);
	$("#company").val(obj.company);
}

function doFindCodeObject(id,codeno,itemno){
	var url="findCodeObject.do"
	var params = {"codeno":codeno,"itemno":itemno};
	$.post(url,params,function(result){
		if(result.state==1){
			initAdderss(id,itemno,result.data);
		}else{
		 alert(result.message);
		}
	});
}

function initAdderss(id,qu,result){
	var address = result.itemname;
	$("#"+id).val(address);
}





