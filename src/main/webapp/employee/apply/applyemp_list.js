$(document).ready(function(){
	//在queryFormId对应对象的btn-search元素上注册click事件
	/*$("#queryFormId").on("click",
			".btn-search",doQueryObjects);*/
	//在禁用和启用按钮上注册点击事件
	/*$("#queryFormId").on(
			"click",
			".btn-valid,.btn-invalid",
			 doValidById);*/		
	//在添加,修改按钮上注册点击事件
	$('.tabson').on("click",".btn-update",doShowEditDialog);
	//初始化页面数据
	doGetObjects();
	
});

function doShowEditDialog(){
	var title;
	$("#modal-dialog").data("id",$(this).parent().parent().data("id"));
	title="修改项目,id为"+$("#modal-dialog").data("id");
	var url="applyEmpEditUI.do";
	$("#modal-dialog .modal-body").load(url,function(){//异步加载完成回调此函数
		$(".modal-title").html(title);
		$("#modal-dialog").modal("show");
	});
}

/*执行表单查询*/
function doQueryObjects(){
	$("#pageId").data("pageCurrent",1);
	doGetObjects();
}
/*获得查询表单中的数据*/
function getQueryFormData(){
	//根据id获得具体对象的值,然后封装到JSON对象
	var params={
		name:$("#searchNameId").val()
	};
    return params;
}
function doGetObjects(){
	doGetObjectsTab1();
	doGetObjectsTab2();
}

function doGetObjectsTab1(){
	//定义一个url(对应服务端控制器中的一个方法)
	var url="findApplyMObjects.do"
	//获取当前页的页码值,假如没有值,默认值设置为1
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(!pageCurrent){
		pageCurrent=1;
	}
	//定义一个params对象
	var params={};
	//动态的向params对象中添加key/value
	params.pageCurrent=pageCurrent;
	params.type="1";
    $.ajaxSettings.async = true;
    $.post(url,params,function(result){//result为一个json对象(JsonResult)
    	if(result.state==1){//成功
	    	setTable1BodyRows(result.data.list);//data属性的值对应一个json对象
	    	setPagination(result.data.pageObject);
    	}else{
    		alert(result.message);
    	}
    });	
}




function doGetObjectsTab2(){
	//定义一个url(对应服务端控制器中的一个方法)
	var url="findApplyMObjects.do"
	//获取当前页的页码值,假如没有值,默认值设置为1
	var pageCurrent=$("#pageId2").data("pageCurrent2");
	if(!pageCurrent){
		pageCurrent=1;
	}
	//定义一个params对象
	var params={};
	//动态的向params对象中添加key/value
	params.pageCurrent=pageCurrent;
	params.type="2";
    $.ajaxSettings.async = true;
    $.post(url,params,function(result){//result为一个json对象(JsonResult)
    	if(result.state==1){//成功
	    	setTable2BodyRows(result.data.list);//data属性的值对应一个json对象
	    	setPagination(result.data.pageObject);
    	}else{
    		alert(result.message);
    	}
    });	
}



function setTable1BodyRows(result){//result 为一个json对象
	//获得tbody对象(根据id获得)
	//在使用$函数获得某个id对应的对象一定要添加#
	var tBody=$("#tbodyId1");
	//清空body中内容(假如方法不记得了怎么办)
	tBody.empty();//doc.tedu.cn
	//迭代json对象
	for(var i in result){//循环一次取一行[{"name":"AAA",...},{},{}]
	//构建一个tr对象
		var tr=$("<tr></tr>");
		//在tr对象上绑定一个值
		tr.data("id",result[i].applyno);//key/value
		//tr对象中追加td字符串对象
		tr.append("<td>"+result[i].applyman+"</td>");
		/*tr.append("<td>"+result[i].applyno+"</td>");
		tr.append("<td>"+result[i].employeeID+"</td>");*/
		tr.append("<td>"+result[i].applytime+"</td>");
		tr.append("<td>"+result[i].applystatus+"</td>");
		
		tr.append("<td>"+result[i].applycontent+"</td>");
		tr.append('<td><input type="button" class="scbtn  btn-update" style="width:50px;height:30px;" value="修改"/></td>');
		tBody.append(tr);//将每一行记录再追加到tbody中
	}
	
}

function setTable2BodyRows(result){//result 为一个json对象
	//获得tbody对象(根据id获得)
	//在使用$函数获得某个id对应的对象一定要添加#
	var tBody=$("#tbodyId2");
	//清空body中内容(假如方法不记得了怎么办)
	tBody.empty();//doc.tedu.cn
	//迭代json对象
	for(var i in result){//循环一次取一行[{"name":"AAA",...},{},{}]
		//构建一个tr对象
		var tr=$("<tr></tr>");
		//在tr对象上绑定一个值
		tr.data("id",result[i].applyno);//key/value
		tr.append("<td>"+result[i].applyman+"</td>");
		/*tr.append("<td>"+result[i].applyno+"</td>");
		tr.append("<td>"+result[i].employeeID+"</td>");*/
		tr.append("<td>"+result[i].applytime+"</td>");
		tr.append("<td>"+result[i].applystatus+"</td>");
		tr.append("<td>"+result[i].applycontent+"</td>");
		tr.append('<td><input type="button" class="scbtn  btn-update" style="width:50px;height:30px;" value="修改"/></td>');
		tBody.append(tr);//将每一行记录再追加到tbody中
	}
	
}
