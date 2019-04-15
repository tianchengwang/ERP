<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台管理系统HTML模板--模板之家 www.cssmoban.com</title>

<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="${basePath}/common/page.js"></script>
<script type="text/javascript" src="${basePath}/employee/message/messageMList.js"></script>
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



</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">员工培训信息信息列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="seachform">
        	<li><label>综合查询</label><input id="searchNameId" name="" type="text" class="scinput" /></li>
	    	<li><input id="btn-search" name="" type="button" class="scbtn" value="查询"/></li>
	    	<li><label>&nbsp;</label><input id="btn-add" name="" type="button" class="scbtn btn-add" value="新增"/></li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>ID</th>
        <th>创建消息人</th>
        <th>详情</th>
        <th>参加人员</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody id="tbodyId">
       
        </tbody>
    </table>
    
   
     <%@include file="../common/page.jsp" %>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
   <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	
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



