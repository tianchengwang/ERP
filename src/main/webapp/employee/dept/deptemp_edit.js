$(document).ready(function(){
	$("#modal-dialog").on("click",".ok",doSaveOrUpdate);
	$("#modal-dialog").on("hidden.bs.modal",function(){
		$(this).off("click",".ok").removeData("id");
	});
	var id=$("#modal-dialog").data("id");
	doFindObjectDept();
	if(id)doFindObjectById(id);
});


function doFindObjectDept(){
	var url="findDeptObjects.do"
	$.post(url,function(result){
		if(result.state==1){
		 InitAddressFormData(result.data.list);	
		}else{
		 alert(result.message);
		}
	});
}

function InitAddressFormData(result){
	/*console.log(JSON.stringify(result));*/
	var address = $("#deptno");
	address.empty();
	address.append("<option>请选择</option>");
	for(var i=0;i<result.length;i++){
		var option = $("<option></option>");
		option.val(result[i].deptNo)
		option.html(result[i].deptName);		
		address.append(option);
	}
}


function doFindObjectById(id){
	var url="findDeptEmpObjectById.do"
	var params={"id":id};
	$.post(url,params,function(result){
		if(result.state==1){
		 doInitEditFormData(result.data);	
		}else{
		 alert(result.message);
		}
	});
}
function doInitEditFormData(obj){
	$("#employeeID").val(obj.attribute1);
	$("#employeeID").attr("readonly","readonly");
	$("#deptno").val(obj.deptno);
	$("#job").val(obj.job);
	$("#noteId").val(obj.note);
	
}


/* 点击模态框上的save按钮时执行此函数,
 * 通过此函数发送异步请求将页面上的数据
 * 发送到服务端.
 */
function doSaveOrUpdate(){
	//1.简单验证表单数据,当valid()返回值为false,
	//表示验证没有通过
	//1.1使用valid函数首先要引入验证框架
	//jquery.validate.min.js
	//1.2在不能为空的html对象上添加required选择器
	if(!$("#editFormId").valid())return;
	//2.获得输入的数据
	var params=getEditFormData();
	//3.将数据异步发送到服务端
	//3.1定义url(对应controller中的一个方法)
	//获得模态框上绑定的id值
	var id=$("#modal-dialog").data("id");
	if(id)params.id=id;//动态添加属性(修改时需要id的值)
	//根据id是否有值来判定是修改还是添加
	var updateUrl="doUpdateDeptEmpObject.do";
	var insertUrl="doSaveDeptEmpObject.do";
	var url=id?updateUrl:insertUrl;
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
	"deptno":$("#deptno").val(),
	"job":$("#job").val(),
	"note":$("#noteId").val()
  }
  //2.返回json对象
  return params;
}




