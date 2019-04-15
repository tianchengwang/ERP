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
	$('.rightinfo')
	.on("click",".btn-add,.btn-update",doShowEditDialog);
	//初始化页面数据
	doGetObjects();
	
});
/*点击添加按钮时执行一个动作
 *1)初始化index页面的模态框(bootstrap 框架提供)
 *2)在模态框内部显示project_edit.jsp
 * */
function doShowEditDialog(){
	var title;
	//1.定义模态框的标题
	if($(this).hasClass("btn-add")){
		title="添加项目"
	}
	if($(this).hasClass("btn-update")){
		
		$("#modal-dialog").data("id",$(this).parent().parent().data("id"));
		title="修改项目,id为"+$("#modal-dialog").data("id");
	}
	var url="DeptEmpEditUI.do";
	$("#modal-dialog .modal-body")
	.load(url,function(){//异步加载完成回调此函数
		$(".modal-title").html(title);
		$("#modal-dialog").modal("show");
	});
}


/*执行表单查询*/
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
	};
	//一定要记得返回
    return params;
}

function doGetObjects(){
	//定义一个url(对应服务端控制器中的一个方法)
	var url="findDeptEmpObjects.do"
	//获取当前页的页码值,假如没有值,默认值设置为1
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(!pageCurrent){
		pageCurrent=1;
	}
	var params=getQueryFormData();
	params.pageCurrent=pageCurrent;
    $.ajaxSettings.async = true;
    $.post(url,params,function(result){//result为一个json对象(JsonResult)
    	if(result.state==1){//成功
	    	setTableBodyRows(result.data.list);//data属性的值对应一个json对象
	    	setPagination(result.data.pageObject);
    	}else{//失败了(获取数据时出现异常了)
    		alert(result.message);
    	}
    });	

}

//定义函数将json对象中的数据取出来填充到表格中
function setTableBodyRows(result){//result 为一个json对象
	var tBody=$("#tbodyId");
	tBody.empty();//doc.tedu.cn
	for(var i in result){//循环一次取一行[{"name":"AAA",...},{},{}]
	var tr=$("<tr></tr>");
	tr.data("id",result[i].id);//key/value
	var firstTd='<td><input type="checkbox" name="checkedItem" value="[id]"></td>';
	firstTd=firstTd.replace("[id]",result[i].id);
	tr.append(firstTd);	
	
//	tr.append("<td>"+result[i].e_id+"</td>");
	tr.append("<td>"+result[i].attribute2+"</td>");
//	tr.append("<td>"+result[i].deptno+"</td>");
	tr.append("<td>"+result[i].attribute1+"</td>");
	tr.append("<td>"+result[i].manager+"</td>");
	tr.append("<td>"+result[i].job+"</td>");
	tr.append('<td><input type="button" class="scbtn  btn-update" style="width:50px;height:30px;" value="修改"/></td>');
	tBody.append(tr);//将每一行记录再追加到tbody中
	}
	
}
