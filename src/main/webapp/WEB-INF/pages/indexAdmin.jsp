<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ERP-TCWANG</title>
<script type="text/javascript" src="js/jquery.js"></script>

</head>

<frameset rows="88,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="topUI.do" name="topFrame" scrolling="no"
		noresize="noresize" id="topFrame" title="topFrame" />

	<frameset cols="187,*" frameborder="no" border="0" framespacing="0">
		<frame src="leftUI.do" name="leftFrame" scrolling="no"
			noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="rightUI.do" name="rightFrame" id="rightFrame"
			title="rightFrame" />
	</frameset>
</frameset>
<body>
</body>
</html>