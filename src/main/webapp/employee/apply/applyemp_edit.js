$(document).ready(function(){
	$("#modal-dialog").on("click",".ok",doSaveOrUpdate);
	$("#modal-dialog").on("hidden.bs.modal",function(){
		$(this).off("click",".ok").removeData("id");
	});
	var id=$("#modal-dialog").data("id");
	doFindObjectById(id);
});



/*根据id执行查找操作*/
function doFindObjectById(id){
	var params = {"applyno":id};
	var url="findApplyObjectById.do"
	$.post(url,params,function(result){
		if(result.state==1){
		 doInitEditFormData(result.data);	
		}else{
		 alert(result.message);
		}
	});
}


function doInitEditFormData(obj){
	$("#applyman").val(obj.applyman);
	$("#employeeID").val(obj.employeeID);
	$("#applytype").val(obj.applytype);
	
	$("#applycontent").val(obj.applycontent);
	$("#applytime").val(obj.applytime);
	$("#applystatus").val(obj.applystatus);
	$("#noteId").val(obj.note);
	
}


/* 点击模态框上的save按钮时执行此函数,
 * 通过此函数发送异步请求将页面上的数据
 * 发送到服务端.
 */
function doSaveOrUpdate(){
	
	if(!$("#editFormId").valid())return;
	var params=getEditFormData();
	var id=$("#modal-dialog").data("id");
	var url="doUpdateApplyObject.do";
	params.applyno = id;
	//3.2发送异步请求	
	$.post(url,params,function(result){
		if(result.state==1){
		 //隐藏模态框
		 $("#modal-dialog").modal("hide");
		 //重新查询(调用的project_list.js中的doGetObjects)
		 	doGetObjects();
		}else if(result.state==2){
			alert(result.message);
		}
	});//doSaveObject(Project entity)
}
function getEditFormData(){
	 //1.获得页面上用户输入的数据,封装为json对象(相对比较灵活)
	  var params={//根据id获得数据
		  "applytype":$("#applytype").val(),
		  "employeeID":$("#employeeID").val(),
		  "applytime":$("#applytime").val(),
		  "applystatus":$("#applystatus").val(),
		  "applyman":$("#applyman").val(),
		  "applycontent":$('#applycontent').val(),
		  "note":$("#note").val()
	  }
	  //2.返回json对象
	  return params;
	}




