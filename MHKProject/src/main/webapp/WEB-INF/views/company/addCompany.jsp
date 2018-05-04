<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register A New Company</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/addCompany.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/addCompany.css"/>">
<link href='https://fonts.googleapis.com/css?family=Arbutus' rel='stylesheet'>
</head>
<body>
	<div id="title">Register A New Company</div>
	<div>
		<div id="formDiv">
			<form action="addCompanyProcess" id="addCompanyForm" method="post"  onsubmit="return addCompanyBlankCheck()">
				<div id="formInner">
					<div>
						<p>Company Name
						<input type="text" id="companyName" name="companyName" required>
						<input type="button" id="duplicate" value="Name Check">
						</p>
					<div id="nameResult"></div>
					</div>
					<div>
						<p>Company CEO
						<input type="text" id="companyCEO" name="companyCEO" required></p>
					</div>
					<div>
						<p>Company Email
						<input type="email" id="companyEmail" name="companyEmail" required></p>
					</div>
					<div>
						<p>Company Phone
						<input type="text" id="companyPhone" name="companyPhone" required maxlength="11"></p>
					</div>
					<div>
						<p>Company Address
						<input type="text" id="companyAddress" name="companyAddress" required></p>
					</div>
					<div>
						<p>Company Field</p>
						<div>
						<p>IT <input type="radio"  name=companyField value="IT" checked>
						Logistics <input type="radio"  name="companyField" value="Logistics">
						Education <input type="radio"  name="companyField" value="Education">
						Advertisement <input type="radio"  name="companyField" value="Advertisement"><br>
						HR <input type="radio"  name="companyField" value="HR">
						Finance <input type="radio"  name="companyField" value="Finance">
						Business Administration <input type="radio"  name="companyField" value="Business Administration">
						Art <input type="radio"  name="companyField" value="Art">
						Etc <input type="radio"  name="companyField" value="Etc">
						</p></div>
					</div>
					<div>
						<p>Company Payment
						<input type="text" id="companyPayment" name="companyPayment" required>万円</p>
					</div>
					<div>
						<p>Company WorkingTime
						<input type="text" id="companyWorkingTime" name="companyWorkingTime" required maxlength="2">hrs.</p>
					</div>
					<div>
						<p>Company Employee
						<input type="text" id="companyEmployee" name="companyEmployee" required></p>
					</div>
					<div>
						<p>Company Capital
						<input type="text" id="companyCapital" name="companyCapital" required>万円</p>
					</div>
					<div>
						<p>Company Foundation
						<input type="date" id="companyFoundation" name="companyFoundation" required></p>
						<div style="color: red; display:inline-block;">ex:) 2020-01-01 </div>
					</div>
					<div>
						<p>Company Homepage
						<input type="text" id="companyHomepage" name="companyHomepage"></p>
					</div>
					<div>
						<p>Company Image</p>
						<input type="text" id="companyImageFileRoot" name="companyImageFileRoot">
						<div id="image">*Input URL of an image.</div>
					</div>
					<br>
					<div style="text-align: center;">
					<a href="brief"><input type="button" id="backButton" value="Back"></a>
					<input type="reset"  id="resetButton" value="Reset">
					<input type="submit" id="submitButton" value="Add">
					</div>
				</div>
			</form>
		</div>
	</div>
	<br>
</body>
</html>