<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/login.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
<link href='https://fonts.googleapis.com/css?family=Arbutus' rel='stylesheet'>
</head>
<body>
	<div id="title">Unexpected Error</div>
	<div id="loginForm">
		<div id="inner">	
			<div>
				Technical problem occurred during the process.<br>
				Please return to the home page. 						
			</div>
			<p></p>
			<div>
			<a href="../"><input type="button" id="login" value="Home"></a>
			</div>
		</div>
	</div>
</body>
</html>