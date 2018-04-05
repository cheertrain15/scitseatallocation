<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../js/joinForm.js"></script>	
	<title>[Join Complete]</title>
	<script type="text/javascript">
	function goToHome() {
		alert("왜?");
		location.href = '../home';
	}
	
	function goLogin() {
		location.href ='loginForm';
	}
	</script>
	</head>
	
<body>
<%@ include file="../header.jsp" %>
<div class="newDiv">
<br><br><br><br><br><br><br><br><br>
	<h1>${id }</h1>
	<br>
	<h1>Please! Check Your Email!!</h1>
</div>
<br><br>

<!-- <div class="clearfix">    
      <button type="button" id="homebt" onclick='goToHome()'>Home</button>         
      <button type="button" id="loginbt" onclick='goLogin()'>Login</button>   
</div> -->
<%@ include file="../footer.jsp"%>
</body>
</html>