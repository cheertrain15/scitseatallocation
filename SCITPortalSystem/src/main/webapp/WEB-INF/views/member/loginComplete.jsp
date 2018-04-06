<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>[Login Complete]</title>
	<script type="text/javascript">
	function goHome() {
		
		location.href = '../home';
	}
	</script>
	</head>
	
<body>
<%@ include file="../header.jsp" %>
<br><br>
	<div class="newDiv">
		<h1>${sessionScope.loginID }님 </h1>
		<br>
		<h1>WelCome Back!!</h1>
	</div>
<br><br>
	<div class="clearfix">    
      <button type="button" id="homebt" onclick="goHome()">Home</button>     
    </div>

<%@ include file="../footer.jsp"%>
</body>
</html>