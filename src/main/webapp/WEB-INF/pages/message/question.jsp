<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<!-- <script src="js/jquery-1.11.0.min.js"></script> -->
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />

<script src="jquery/jquery-1.11.1.js"></script>
<script src="jquery/jquery-ui.min.js"></script>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/jquery.form.js"></script>
<script src="js/bootstrap.min.js"></script>


<script type="text/javascript">

 $(document).ready(function(){
	 doGetObjects();
	//回车按钮
	$(document).keyup(function(event) {
		if (event.keyCode == 13) {
			//触发btn-login绑定的submit事件
			$("#add-message").trigger("click");
		}
	});
	//点击登录按钮
	$('#add-message').click(addMessage);
})


function addMessage(){
	var params = getParams();
	var url = "insertMessage.do";
	var createdUser = $("#username").text().substr(2);
	params.createdUser = createdUser;
	$.ajaxSettings.async = true;
    $.post(url,params,function(result){//result为一个json对象(JsonResult)
    	if(result.state==1){//成功
    		alert("发送成功！");
    		var url="questionUI.do";
    		$(".product").load(url); 
    	}else{
    		alert(result.message);
    	}
    });	 
	
	
}

function getParams(){
	var params = {};
	var m_question = $("#m_question").val();
	var m_type = "1";
	params.m_question = m_question;
	params.m_type = m_type;
	return params;
}


function doGetObjects(){
	//定义一个url(对应服务端控制器中的一个方法)
	var url="doFindQuestionObjects.do"
	var type = "1";
	var params = {"m_type":type};
    $.ajaxSettings.async = true;
    $.post(url,params,function(result){//result为一个json对象(JsonResult)
    	if(result.state==1){//成功
    		setQuestionList(result.data.list);
    	}else{//失败了(获取数据时出现异常了)
    		alert(result.message);
    	}
    });	

}

//定义函数将json对象中的数据取出来填充到div中
function setQuestionList(result){//result 为一个json对象
	//获得div对象(根据class获得)产品列表的div
	//在使用$函数获得某个class对应的对象一定要添加.
	var qList=$(".blc-layer3-grids1");
	//清空div中内容(假如方法不记得了怎么办)
	qList.empty();
	//迭代json对象
	for(var i in result){
		
		var qInfo=$(' <div class="alert alert-info" role="alert"></div>');
		
		qInfo.append('<h3>'+result[i].m_name+'发布：'+result[i].m_question+'</h3>');
		qInfo.append('<p>详情：'+result[i].m_answer+'</p>');
		qInfo.append('<hr style="height:10px;border:none;border-top:10px groove skyblue;" />');
		qList.append(qInfo);
	}
	
	
}



</script>

<div class="blc-layer3">
	<div class="container">
		<div class="blc-layer3-main">
			   <div class=" blc-layer3-grids1" >
			   	
  	
			   </div>
			   
		</div>
	</div>
	
</div>

