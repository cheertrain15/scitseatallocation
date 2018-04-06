<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value ="/resources/css/mainMenu.css"/>" rel="stylesheet" type="text/css" />
		<title>[Login Form]</title>
<script type="text/javascript">	
<c:if test="${errorPW != null}">
alert('${errorPW}');		
</c:if>		
<c:if test="${errorEmail != null}">
alert('${errorEmail}');
</c:if>		
<c:if test="${errorID != null}">
alert('${errorEmail}');
</c:if>	
</script>
	</head>
<body>
<%@ include file="../header.jsp" %>

<br><br><br>
<form action="login" style="border:1px solid #ccc" method="post">
  <div class="container">
  <br>
    <h1>Log in</h1><br>
    <p>Welcome Back!</p>
    <hr>

	<label><b>ID</b></label>
    <input type="text" placeholder="Enter ID" name="id">    
    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password">
	<br><br>
    <div class="clearfix">
      <button type="reset" class="LoginCanBT">Cancel</button>
      <button type="submit" class="LoginBT">Log in</button>
    </div>
  </div>
</form>

<%@ include file="../footer.jsp"%>
</body>
</html>