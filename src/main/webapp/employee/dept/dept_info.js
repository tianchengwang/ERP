$(document).ready(function(){
	doFindObjectById();
});
/*根据id执行查找操作*/
function doFindObjectById(){
	var url="findDeptObjectById.do"
	$.post(url,function(result){
		if(result.state==1){
		 doInitEditFormData(result.data);	
		}else{
		 alert(result.message);
		}
	});
}
function doInitEditFormData(obj){
	$("#deptno").val(obj.deptNo);
	$("#deptname").val(obj.deptName);
	$("#local").val(obj.local);
	$("#deptleader").val(obj.deptleader);
}




