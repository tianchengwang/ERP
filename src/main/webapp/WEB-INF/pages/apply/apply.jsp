<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript" src="${basePath}/employee/apply/apply_list.js"></script>
<script type="text/javascript" src="${basePath}/common/page.js"></script>
<script type="text/javascript" src="${basePath}/jquery/jquery-1.11.1.js"></script> 


<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap-datepicker.min.css" />
<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap-table.min.css"/>
<link rel="stylesheet" href="${basePath}/bootstrap/css/font-awesome.min.css"/>
<link rel="stylesheet" href="${basePath}/bootstrap/plugins/ztree/css/metroStyle/metroStyle.css"/>
<link rel="stylesheet" href="${basePath}/bootstrap/plugins/treegrid/jquery.treegrid.css"/>

<script src="${basePath}/jquery/jquery-ui.min.js"></script>
<script src="${basePath}/jquery/jquery.validate.min.js"></script>
<script src="${basePath}/jquery/jquery.form.js"></script>
<script src="${basePath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${basePath}/bootstrap/js/bootstrap-datepicker.min.js"></script>
<script src="${basePath}/bootstrap/js/bootstrap-table.min.js"></script>
<script src="${basePath}/bootstrap/plugins/layer/layer.js"></script>
<script src="${basePath}/bootstrap/plugins/treegrid/jquery.treegrid.min.js"></script>
<script src="${basePath}/bootstrap/plugins/treegrid/jquery.treegrid.bootstrap3.js"></script>
<script src="${basePath}/bootstrap/plugins/treegrid/jquery.treegrid.extension.js"></script>
<script src="${basePath}/bootstrap/plugins/treegrid/tree.table.js"></script>
<script src="${basePath}/bootstrap/plugins/ztree/jquery.ztree.all.min.js"></script>

<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>



  
<script type="text/javascript">
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">功能菜单</a></li>
    <li><a href="#">申请信息列表</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">请假申请</a></li> 
    <li><a href="#tab2">设备申请</a></li> 
  	</ul>
    </div> 
    <div  class="tabson">
    <ul class="seachform">
    
<!--     <li><label>综合查询</label><input id="searchNameId" name="" type="text" class="scinput" /></li> -->
    <li><label>&nbsp;</label><input id="btn-add" name="" type="button" class="scbtn" value="新增"/></li>
   <!--  <li><label>&nbsp;</label><input id="btn-search" name="" type="button" class="scbtn" value="查询"/></li> -->
    
    </ul>
    </div>
  	<div id="tab1" class="tabson">
    
   
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>申请编号</th>
        <th>员工编号</th>
        <th>申请时间</th>
        <th>申请状态</th>
        <th>员工姓名</th>
        <th>申请内容</th>
        </tr>
        </thead>
        <tbody id="tbodyId1">
        </tbody>
    </table>
     <%@include file="../common/page.jsp" %>
    </div> 
    
    
  	<div id="tab2" class="tabson">
    
    
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>申请编号</th>
        <th>员工编号</th>
        <th>申请时间</th>
        <th>申请状态</th>
        <th>员工姓名</th>
        <th>申请内容</th>
        </tr>
        </thead>
        <tbody id="tbodyId2">
        
        </tbody>
    </table>
    
    <%@include file="../common/page.jsp" %>
  
    
    </div> 
     
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    
    
    
    
    </div>
<!-- Modal(模态框) -->
 <div class="modal fade" id="modal-dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <!-- 此位置放置具体页面的位置 -->
      <div class="modal-body"></div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary ok">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- modal -->
</body>
</html>
