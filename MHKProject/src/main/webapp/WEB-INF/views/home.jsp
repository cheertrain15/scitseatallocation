<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
	<title>Home</title>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/home.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>">
	<link href='https://fonts.googleapis.com/css?family=Arbutus' rel='stylesheet'>
</head>
<body>
	<div id="title">
		JobQuest
	</div>
	<div>
		<div id="menu">
			<div id="insideMenu">
				<c:choose>			
					<c:when test="${sessionScope.loginId == null}">
						<div id="loginDiv">
							<p>ID -<input type="text" id="loginId" name="loginId"></p>
							<p>PW -<input type="password" id="loginPassword" name="loginPassword"></p>
							<p style="display: inline-block;"><input type="button" id="login" value="Login"></p>
							<p style="display: inline-block;"><a href="member/join"><input type="button" id="join" value="Join"></a></p>
						</div>
					</c:when>
					<c:otherwise>
							<p>Welcome, ${sessionScope.loginName}!</p>
						<div id="logoutDiv">
							<p style="display: inline-block;"><input type="button" id="logout" value="Logout"></p>
						</div>
						<div id="myInfoDiv">
							<p style="display: inline-block;"><a href="member/update" id="myInfo">Update My Information</a></p>
						</div>
					</c:otherwise>
				</c:choose>
				<div id="viewMoreCompaniesDiv">
					<p><a href="company/brief"><input type="button" id="view" value="View Companies"></a><p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
