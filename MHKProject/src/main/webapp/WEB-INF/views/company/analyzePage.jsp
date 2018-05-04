<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html >
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/analyzePage.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/analyzePage.css"/>">
<link href='https://fonts.googleapis.com/css?family=Arbutus' rel='stylesheet'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Analyze</title>
</head>
<body>
	<div id="title">Result Of Analysis</div>
	<div id="bothInfoDiv">
		<div id="leftMemberSideDiv" style="display: inline-block;">
			<div><p>Your Information<p></div><br>
			<div><p>Specialty :</p> 
				<div style="display: inline-block;">${User.memberDesireField}</div>
			</div>
			<div><p>Payment Expectation :</p> 
				<div style="display: inline-block;">${User.memberDesirePayment}</div>
			</div>
			<div><p>Desired Labor Time :</p> 
				<div style="display: inline-block;">${User.memberDesiredWorkingTime}</div>
			</div>
			<div><p>Current Address :</p> 
				<div style="display: inline-block;">${User.memberAddress}</div>
			</div>
			<input type="hidden" id="loginId" value="${sessionScope.loginId}">
		</div>
		<div  style="display: inline-block;">　</div>
		<div id="rightCompanySideDiv" style="display: inline-block;">
			<div><p>${Company.companyName}'s Information</p></div><br>
			<div><p>Specialty :</p>
				<div style="display: inline-block;">${Company.companyField}</div>
			</div>
			<div><p>Payment :</p> 
				<div style="display: inline-block;">${Company.companyPayment}</div>
			</div>
			<div><p>Labor Time :</p> 
				<div style="display: inline-block;">${Company.companyWorkingTime}</div>
			</div>
			<div><p>Address :</p> 
				<div style="display: inline-block;">${Company.companyAddress}</div>
			</div>
			<input type="hidden" id="companyNum" value="${Company.companyNum}">
		</div>
	<hr>
	<div id="result">
	<p>Result</p>
	<br>
		<div id="analyze">
			<div id="analyzeMessage">
				<div>${Result.first}</div>
				<div>${Result.second}</div>
				<div>${Result.third}</div>
				<div>${Result.fourth}</div>
				<div>${Result.fourthSub}</div>
				<div>${Result.fifth}</div>
				<div>${Result.sixth}</div>
				<div>${Result.seventh}</div>
			</div>
		</div>
	</div>
	<div></div>
	<br>
	<hr>
	<div style="text-align: center;">
		<a href="companyInfo?companyNum=${Company.companyNum}">
			<input type="button" id="backButton" value="Back">
		</a>
	</div>
	<br>
	</div>
</body>
</html>