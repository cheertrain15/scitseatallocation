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
	<div id="title">Login</div>
	<div id="loginForm">
		<div id="inner">	
		<form action="member/irregularLogin" method="POST" onsubmit="return loginCheck()">
			<div>
				<p>ID <input type="text" id="loginId" name="memberId"></p><br>
				<p>PW <input type="password" id="loginPassword" name="memberPassword"></p><br>
			</div>
			<p></p>
				<div><input type="submit" id="login" value="Login"></div>
		</form>
		</div>
	</div>
</body>
</html>