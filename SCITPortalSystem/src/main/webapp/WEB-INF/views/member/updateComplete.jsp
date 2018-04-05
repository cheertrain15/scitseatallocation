<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<title>[Update MyPage Complete]</title>
	<script type="text/javascript" src="<c:url value="../js/jquery-3.2.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="../js/joinForm.js"/>"></script>
	<script type="text/javascript">
	function goToHome() {
		/* alert("왜?"); */
		location.href = '../home';
	}
	</script>
	</head>
	
<body>
<%@ include file="../header.jsp" %>
<br><br><br><br><br>
	<p>${userName}(${userID }) Information Change Complete</p>
	
	<br>
	
	
	 <button type="button" id="homebt" onclick='goToHome()'>Home</button> 
      

<%@ include file="../footer.jsp"%>
</body>
</html>