$(document).ready(function(){
	//在添加,修改按钮上注册点击事件
	$('.seachform')
	.on("click","#btn-add",doShowEditDialog);
	/*
	$(".seachform").on("click","#btn-search",doQueryObjects);*/
	//初始化页面数据
	doGetObjects();
	
});

function doShowEditDialog(){
	
	//1.定义模态框的标题
	var title = "新增申请";
	//2.启动模态框,并加载页面
	//在模态框对应位置异步加载url
	var url="applyEditUI.do";
	$("#modal-dialog .modal-body")
	.load(url,function(){//异步加载完成回调此函数
		//设置标题内容
		$(".modal-title").html(title);
		//显示模态框(index.jsp中)
		$("#modal-dialog").modal("show");
	});
}

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
	doGetObjectsTab1();
	doGetObjectsTab2();
}

function doGetObjectsTab1(){
	//定义一个url(对应服务端控制器中的一个方法)
	var url="findApplyObjects.do"
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
	console.log(JSON.stringify(params))
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
	var url="findApplyObjects.do"
	//获取当前页的页码值,假如没有值,默认值设置为1
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(!pageCurrent){
		pageCurrent=1;
	}
	//定义一个params对象
	var params={};
	//动态的向params对象中添加key/value
	params.pageCurrent=pageCurrent;
	params.type="2";
	console.log(JSON.stringify(params))
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
	tr.data("id",result[i].id);//key/value
	//tr对象中追加td字符串对象

	tr.append("<td>"+result[i].applyno+"</td>");
	tr.append("<td>"+result[i].employeeID+"</td>");
	tr.append("<td>"+result[i].applytime+"</td>");
	tr.append("<td>"+result[i].applystatus+"</td>");
	tr.append("<td>"+result[i].applyman+"</td>");
	tr.append("<td>"+result[i].applycontent+"</td>");
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
	tr.data("id",result[i].id);//key/value
	
	
	tr.append("<td>"+result[i].applyno+"</td>");
	tr.append("<td>"+result[i].employeeID+"</td>");
	tr.append("<td>"+result[i].applytime+"</td>");
	tr.append("<td>"+result[i].applystatus+"</td>");
	tr.append("<td>"+result[i].applyman+"</td>");
	tr.append("<td>"+result[i].applycontent+"</td>");
	tBody.append(tr);//将每一行记录再追加到tbody中
	}
	
}
/*
 * <th>申请编号</th>
	<th>员工编号</th>
	<th>申请时间</th>
	<th>申请状态</th>
	<th>员工姓名</th>
	<th>申请内容</th>
*/