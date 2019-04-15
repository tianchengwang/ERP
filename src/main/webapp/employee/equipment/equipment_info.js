$(document).ready(function(){
	//在添加,修改按钮上注册点击事件
	/*$('.rightinfo').on("click",".btn-add,.btn-update",doShowEditDialog);*/
	//初始化页面数据
	doGetObjects();
	
});
function doQueryObjects(){
	//1.修改当前页的值为1
	$("#pageId").data("pageCurrent",1);
	//2.执行查询动作(重用doGetObjects方法)
	doGetObjects();
}
/*获得查询表单中的数据*/
function getQueryFormData(){
	//根据id获得具体对象的值,然后封装到JSON对象
	var params={
		name:$("#searchNameId").val(),
		valid:$("#searchValidId").val()
	};
	console.log(JSON.stringify(params));
	//一定要记得返回
    return params;
}
function doGetObjects(){
	//定义一个url(对应服务端控制器中的一个方法)
	var url="findequipmentObjects.do"
	//获取当前页的页码值,假如没有值,默认值设置为1
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(!pageCurrent){
		pageCurrent=1;
	}
	//定义一个params对象
	var params={};
	//动态的向params对象中添加key/value
	params.pageCurrent=pageCurrent;
	console.log(JSON.stringify(params))
    $.ajaxSettings.async = true;
    $.post(url,params,function(result){//result为一个json对象(JsonResult)
    	if(result.state==1){//成功
	    	setTableBodyRows(result.data.list);//data属性的值对应一个json对象
	    	setPagination(result.data.pageObject);
    	}else{
    		alert(result.message);
    	}
    });	

}

/*根据id执行查找操作*/
function doFindObjectById(){
	var url="findEquipmentObjectById.do"
	$.post(url,function(result){
		if(result.state==1){
		 doInitEditFormData(result.data);	
		}else{
		 alert(result.message);
		}
	});
}
function setTableBodyRows(result){//result 为一个json对象
	//获得tbody对象(根据id获得)
	//在使用$函数获得某个id对应的对象一定要添加#
	var tBody=$("#tbodyId");
	//清空body中内容(假如方法不记得了怎么办)
	tBody.empty();//doc.tedu.cn
	//迭代json对象
	for(var i in result){//循环一次取一行[{"name":"AAA",...},{},{}]
		//构建一个tr对象
		var tr=$("<tr></tr>");
		//在tr对象上绑定一个值
		tr.data("id",result[i].id);//key/value
		//tr对象中追加td字符串对象
		
		tr.append("<td>"+result[i].employeeID+"</td>");
		tr.append("<td>"+result[i].equipmentno+"</td>");
		tr.append("<td>"+result[i].startdate+"</td>");
		tr.append("<td>"+result[i].enddate+"</td>");
		tr.append("<td>"+result[i].days+"</td>");
		tr.append("<td>"+result[i].status+"</td>");
		tr.append('<td><a href="javascript:;" onclick="updateEquiment(this);" class="tablelink  btn-update">归还</a></td>');
		tBody.append(tr);//将每一行记录再追加到tbody中
	}
	
}

function updateEquiment(a){
	var id = $(a).parent().parent().data("id");
	var url = "UpdateEquipmentObject.do";
	var params = {"id":id};
	$.post(url,params,function(result){//result为一个json对象(JsonResult)
    	if(result.state==1){//成功
	    	alert(result.data);
	    	doGetObjects();
    	}else{
    		alert(result.message);
    	}
    });	
}



