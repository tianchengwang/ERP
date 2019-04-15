//$(function(){})
$(document).ready(function(){
//1.在模态框的保存按钮上注册事件,
	//事件执行时调用doSaveOrUpdate
	$("#modal-dialog").on("click",".ok",doSaveOrUpdate);
	//模态框隐藏时移除相关数据
	$("#modal-dialog")//获得模态框对象
	//"hidden.bs.modal"代表模态框的隐藏事件
	.on("hidden.bs.modal",function(){
		//当模态框隐藏以后移除.ok对象的click事件
		//假如没有执行此操作,可能会出现表单重复提交的问题
		$(this).off("click",".ok")
		       .removeData("id");
		//模态框隐藏以后移除绑定的数据(也可以参考上面的写法)
		//$(this).removeData("id");
	});
	//获得模态框上绑定的数据:id
	var id=$("#modal-dialog").data("id");
	//假如id有值,则根据此值进行查询.
	doFindObjectSheng("Lsheng");
	doFindObjectSheng("Hsheng");
	doFindObjectSheng("Fsheng");
	if(id)doFindObjectById(id);
});
/*根据id执行查找操作*/
function doFindObjectById(id){
	var url="findEmpObjectByIdM.do"
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
	
	$("#employeeID").val(obj.employeeID);
	$("#employeeName").val(obj.employeeName);
	$("#certID").val(obj.certID);
	$("#editFormId input[name='sex']")//radio
	//迭代input标签中name为valid的dom对象
	.each(function(){
		//假如这个对象的值等于obj.valid的值
		//则让其选中.
		if($(this).val()==obj.valid){
		   //设置radio对象的checked属性为true
		   $(this).prop("checked",true)
		}
	});
	$("#birthday").val(obj.birthday);
	$("#grade").val(obj.grade);
	$("#inDate").val(obj.inDate);
	$("#regularDate").val(obj.regularDate);
	$("#contractDate").val(obj.contractDate);
	$("#endDate").val(obj.endDate);
	$("#education").val(obj.education);
	$("#university").val(obj.university);
	$("#graduatedDate").val(obj.graduatedDate);
	
	var shi = obj.nativePlace;
	doFindCodeObject("Lshi","Address",shi);
	
	var Hqu = obj.registeredResidence;
	doFindCodeObject("Hqu","Address",Hqu);
	
	var Fqu = obj.fileLocation;
	doFindCodeObject("Fqu","Address",Fqu);
	
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
	$("#"+id).empty();
	$("#"+id).append("<option value="+qu+">"+address+"</option>");
	$("#"+id).val(qu);
}


function doFindObjectSheng(sheng){
	var url="findShengObjects.do"
	$.post(url,function(result){
		if(result.state==1){
		 InitAddressFormData(sheng,result.data.list);	
		}else{
		 alert(result.message);
		}
	});
}

function InitAddressFormData(address,result){
	var address = $("#"+address);
	address.empty();
	address.append("<option>请选择</option>");
	for(var i=0;i<result.length;i++){
		var option = $("<option></option>");
		option.val(result[i].itemno)
		option.html(result[i].itemname);		
		address.append(option);
	}
}

function chg1(sheng){
	var sval = $("#"+sheng).val();
	sval = sval.substring(0,2);
	var params = {"itemno":sval};
	var url = "findShiObjects.do";
	var hid = sheng.substring(0,1);
	$.post(url,params,function(result){
		if(result.state==1){
		 InitAddressFormData(hid+"shi",result.data.list);	
		}else{
		 alert(result.message);
		}
	});
}
function chg2(shi){
	var sval = $("#"+shi).val();
	sval = sval.substring(0,4);
	
	var params = {"itemno":sval};
	var url = "findQuObjects.do";
	var hid = shi.substring(0,1);
	$.post(url,params,function(result){
		if(result.state==1){
		 InitAddressFormData(hid+"qu",result.data.list);	
		}else{
		 alert(result.message);
		}
	});
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
	console.log(JSON.stringify(params));
	//return;
	var updateUrl="doUpdateEmployeeObject.do";
	var insertUrl="doSaveEmployeeObject.do";
	var url=id?updateUrl:insertUrl;
	//3.2发送异步请求	
	$.post(url,params,function(result){
		console.log(JSON.stringify(result));
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
	/*"employeeID":$("#employeeID").val(),*/
	"employeeName":$("#employeeName").val(),
	"certID":$("#certID").val(),
	"sex":$('input[name="sex"]:checked').val(),
	"birthday":$("#birthday").val(),
	"grade":$("#grade").val(),
	"inDate":$("#inDate").val(),
	"regularDate":$("#regularDate").val(),
	"contractDate":$("#contractDate").val(),
	"endDate":$("#endDate").val(),
	"education":$("#education").val(),
	"university":$("#university").val(),
	"graduatedDate":$("#graduatedDate").val(),
	
	//户籍地址做成下拉菜单
	"nativePlace":$("#Lshi").val(),
	
	"registeredResidence":$("#Hqu").val(),
	"fileLocation":$("#Fqu").val(),
	"mobilePhone":$("#mobilePhone").val(),
	"officePhone":$("#officePhone").val(),
	"emergencyContact":$("#emergencyContact").val(),
	"emergencyContactPhone":$("#emergencyContactPhone").val(),
	"company":$("#company").val(),
	"note":$("#noteId").val()
  }
  console.log(JSON.stringify(params));
  //2.返回json对象
  return params;
}




