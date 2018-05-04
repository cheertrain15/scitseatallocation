<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JOIN</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/join.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/join.css"/>">
<link href='https://fonts.googleapis.com/css?family=Arbutus' rel='stylesheet'>
</head>
<body>
	<div id="title">JOIN</div>
	<div>
		<div id="menu">
			<form action="joinProcess" id="joinForm" method="post" onsubmit="return joinFormCheck()">
				<div>
					<p>ID - <input type="text" id="joinId" name="memberId" required>
					<input type="button" id="duplicate" value="ID Check"></p>
					<div id="idResult"></div>
				</div>
				<div>
					<p>Password - <input type="password" id="joinPw" name="memberPassword" required></p>
				</div>
				<div>
					<p>Password Check - <input type="password" id="joinPwc" required></p>
				</div>
				<div>
					<p>Name - <input type="text" id="joinName" name="memberName" required></p>
				</div>
				<div>
					<p>E-mail - <input type="email" id="joinEmail" name="memberEmail" required></p>
				</div>
				<div>
					<p style="display: inline-block;">Phone - <input type="text" id="joinPhone" name="memberPhone" required maxlength="11"></p>
						<div id="fill">*No hyphens.</div>
				</div>
				<div>
					<p>Gender -  
					Male <input type="radio" name="memberGender" value="Male">
					Female <input type="radio"  name="memberGender" value="Female"></p>
				</div>
				<div>
					<p>Address - <input type="text" id="joinAddress" name="memberAddress" required></p>
				</div>
				<div>
					<p>DesireField<br>
					IT <input type="radio"  name="memberDesireField" value="IT" checked>
					Logistics <input type="radio"  name="memberDesireField" value="Logistics">
					Education <input type="radio"  name="memberDesireField" value="Education">
					Advertisement <input type="radio"  name="memberDesireField" value="Advertisement"><br>
					HR <input type="radio"  name="memberDesireField" value="HR">
					Finance <input type="radio"  name="memberDesireField" value="Finance">
					Business Administration <input type="radio"  name="memberDesireField" value="Business Administration">
					Art <input type="radio"  name="memberDesireField" value="Art">
					Etc <input type="radio"  name="memberDesireField" value="Etc">
					</p>
				</div>
				<div>
					<p>Desired Working Time - <input type="text" id="joinWT" name="memberDesiredWorkingTime" required> Hrs.</p>
				</div>
				<div>
					<p>Desire Payment - <input type="text" id="joinPayment" name="memberDesirePayment" required> 万円</p>
				</div>
				<div>
					<p>Desire Commute Distance - <input type="text" id="joinCD" name="memberDesireCommuteDistance" required> Km.</p>
				</div>
				<div>
					<p>Recieve Notice - 
					Yes <input type="radio"  name="memberRecieveNotice" value="1" checked="checked">
					No <input type="radio"  name="memberRecieveNotice" value="0"></p>
				</div>
				<div>
				<input type="reset" id="resetButton" value="Reset">
				<input type="submit" id="submitButton" value="Join">
				</div>
				<br>
				<a href="../"><input type="button" id="backButton" value="Back"></a>
			</form>
		</div>
	</div>
</body>
</html>