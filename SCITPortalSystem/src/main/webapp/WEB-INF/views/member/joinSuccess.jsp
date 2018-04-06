<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>[Join Success]</title>
	<script type="text/javascript">
	function goLogin() {
		location.href ="loginForm";
	}	
	</script>
	</head>
	
<body>
<%@ include file="../header.jsp" %>
  <br><br><br><br><br><br><br><br><br><br><br>

  <div class="container">
  <br>
    <h1>Log in</h1><br>
    <p>Welcome Back!</p>
    <hr>

	<label><b>SCIT</b></label>    
    <label><b>Thank you for Us</b></label>
    
    <div class="clearfix">     
      <button type="button" class="LoginBT" onclick="goLogin()">Log in</button>
    </div>
  </div>

<%@ include file="../footer.jsp"%>
</body>
</html>