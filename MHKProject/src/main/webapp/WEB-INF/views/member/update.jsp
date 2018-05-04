<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UPDATE</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/update.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/update.css"/>">
<link href='https://fonts.googleapis.com/css?family=Arbutus' rel='stylesheet'>
</head>
<body>
	<div id="title">UPDATE</div>
	<div>
		<div>
			<form action="updateProcess" id="updateForm" method="post" onsubmit="return joinFormCheck()">
				<div>
					<p>ID - <input type="text" id="joinId" name="memberId" required readonly value="${loginMember.memberId}"></p>
				</div>
				<div>
					<p>Password - <input type="password" id="joinPw" name="memberPassword" required value="${loginMember.memberPassword}"></p>
				</div>
				<div>
					<p>Password Check - <input type="password" id="joinPwc" required value="${loginMember.memberPassword}"></p>
				</div>
				<div>
					<p>Name - <input type="text" id="joinName" name="memberName" required value="${loginMember.memberName}"></p>
				</div>
				<div>
					<p>E-mail - <input type="email" id="joinEmail" name="memberEmail" required value="${loginMember.memberEmail}"></p>
				</div>
				<div>
					<p style="display: inline-block;">Phone - <input type="text" id="joinPhone" name="memberPhone" required maxlength="11" value="${loginMember.memberPhone}"></p>
					<div id="fill">*Fill the blank without hyphens.</div>
				</div>
				<div>
					<p>Gender - 
					Male <input type="radio" name="memberGender" value="Male"
						<c:if test="${loginMember.memberGender == 'Male'}">
						checked="checked"
						</c:if>
					>
					Female <input type="radio"  name="memberGender" value="Female"
						<c:if test="${loginMember.memberGender == 'Female'}">
						checked="checked"
						</c:if>
					></p>
				</div>
				<div>
					<p>Address - <input type="text" id="joinAddress" name="memberAddress" required value="${loginMember.memberAddress}"></p>
				</div>
				<div>
					<p>DesireField</p><br>
					<div>
					<p>IT <input type="radio"  name="memberDesireField" value="IT" 
						<c:if test="${loginMember.memberDesireField == 'IT'}">
						checked="checked"
						</c:if>
					>
					Logistics <input type="radio"  name="memberDesireField" value="Logistics"
						<c:if test="${loginMember.memberDesireField == 'Logistics'}">
						checked="checked"
						</c:if>
					>
					Education <input type="radio"  name="memberDesireField" value="Education"
						<c:if test="${loginMember.memberDesireField == 'Education'}">
						checked="checked"
						</c:if>
					>
					Advertisement <input type="radio"  name="memberDesireField" value="Advertisement"
						<c:if test="${loginMember.memberDesireField == 'Advertisement'}">
						checked="checked"
						</c:if>
					></p>
					<br>
					<p>HR <input type="radio"  name="memberDesireField" value="HR"
						<c:if test="${loginMember.memberDesireField == 'HR'}">
						checked="checked"
						</c:if>
					>
					Finance <input type="radio"  name="memberDesireField" value="Finance"
						<c:if test="${loginMember.memberDesireField == 'Finance'}">
						checked="checked"
						</c:if>
					>
					Business Administration <input type="radio"  name="memberDesireField" value="Business Administration"
						<c:if test="${loginMember.memberDesireField == 'Business Administration'}">
						checked="checked"
						</c:if>
					>
					Art <input type="radio"  name="memberDesireField" value="Art"
						<c:if test="${loginMember.memberDesireField == 'Art'}">
						checked="checked"
						</c:if>
					>
					Etc <input type="radio"  name="memberDesireField" value="Etc"
						<c:if test="${loginMember.memberDesireField == 'Etc'}">
						checked="checked"
						</c:if>
					></p>
					</div>
				</div>
				<div>
					<p>Desired WorkingTime - <input type="text" id="joinWT" name="memberDesiredWorkingTime" required value="${loginMember.memberDesiredWorkingTime}"> Hrs.</p>
				</div>
				<div>
					<p>Desire Payment - <input type="text" id="joinPayment" name="memberDesirePayment" required value="${loginMember.memberDesirePayment}"> 万円</p>
				</div>
				<div>
					<p>Desire Commute Distance - <input type="text" id="joinCD" name="memberDesireCommuteDistance" required value="${loginMember.memberDesireCommuteDistance}"> Km.</p>
				</div>
				<div>
					<p>Recieve Notice - 
					Yes <input type="radio"  name="memberRecieveNotice" value="1" 
							<c:if test="${loginMember.memberRecieveNotice == '1'}">
							checked="checked"
							</c:if>
						>
					No <input type="radio"  name="memberRecieveNotice" value="0"
							<c:if test="${loginMember.memberRecieveNotice == '0'}">
							checked="checked"
							</c:if>
						></p>
				</div>
				<div style="text-align: center;">
					<p style="display:inline-block;">
						<a href="../"><input type="button" id="back" value="Back"></a>
					</p>
					<p style="display:inline-block;">
						<input type="submit" id="update" value="Update">
					</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>