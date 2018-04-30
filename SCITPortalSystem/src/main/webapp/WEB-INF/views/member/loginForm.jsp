<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value ="/resources/css/loginForm.css"/>" rel="stylesheet" type="text/css" />
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
 
	<div class="memberLogin">
		<form action="login"  method="post">
			<div class="login_Img">
				<img src="<c:url value="../resources/img/logo_ses.png"/>" alt="logo">
			</div>
			<ul class="loginUl">
				<li>	
	    			<input type="text" placeholder="Enter ID" name="id" autofocus required="required">    
				</li>
				<li>
	    			<input type="password" placeholder="Enter Password" name="password" required="required">
				</li>
			</ul>
			<div class="loginBtn">
			      <button type="submit" class="LoginBT">Log in</button>
			</div>
		</form>
  </div>

<%@ include file="../footer.jsp"%>
</body>
</html>