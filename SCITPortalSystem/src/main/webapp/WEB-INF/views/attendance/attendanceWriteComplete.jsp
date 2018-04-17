<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[Registraion Complete page]</title>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/home.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>">
	
	<script type="text/javascript">
		
		/*
		**	완료 후 리스트 창으로  이동
		**/
		function closeThis() {
			window.opener.location.reload();
			this.close();
		}
		
	</script>
	
	
	
</head>
<body>
	<div align="center"> 
		<br><br><br><br><br>
		<p> 작성이 완료 되었습니다.</p>
		<input type="button" value="닫기" onclick="closeThis()">
	</div>
</body>
</html>