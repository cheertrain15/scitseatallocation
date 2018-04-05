<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>[Join Success]</title>
	</head>
	
<body>
<%@ include file="../header.jsp" %>
  <br><br><br><br><br><br><br><br><br><br><br>
<form action="login" style="border:1px solid #ccc" method="post">
  <div class="container">
  <br>
    <h1>Log in</h1><br>
    <p>Welcome Back!</p>
    <hr>

	<label><b>SCIT</b></label>    
    <label><b>Thank you for Us</b></label>
    
    <div class="clearfix">     
      <button type="submit" class="LoginBT">Log in</button>
    </div>
  </div>
</form>
<%@ include file="../footer.jsp"%>
</body>
</html>