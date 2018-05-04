<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Company</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/updateCompany.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/updateCompany.css"/>">
<link href='https://fonts.googleapis.com/css?family=Arbutus' rel='stylesheet'>
</head>
<body>
	<div id="title">Update ${selectedCompany.companyName}</div>
	<div>
		<div>
			<form action="updateCompanyProcess" id="updateCompanyForm" method="post" onsubmit="return updateCompanyBlankCheck()">
				<div id="innerForm">	
					<div>
						<p>Company Name</p> 
						<input type="text" value="${selectedCompany.companyName}" readonly>
					</div>
					<div>
						<p>Company CEO</p>
						<input type="text" id="companyCEO" name="companyCEO" value="${selectedCompany.companyCEO}" required>
					</div>
					<div>
						<p>Company Email</p>
						<input type="email" id="companyEmail" name="companyEmail" value="${selectedCompany.companyEmail}" required>
					</div>
					<div>
						<p>Company Phone</p>
						<input type="text" id="companyPhone" name="companyPhone" value="${selectedCompany.companyPhone}" required maxlength="11">
					</div>
					<div>
						<p>Company Address</p>
						<input type="text" id="companyAddress" name="companyAddress" value="${selectedCompany.companyAddress}" required>
					</div>
					<div>
						<p>Company Field</p>
						<div>
						<p>
						IT <input type="radio"  name=companyField value="IT" 
								<c:if test="${selectedCompany.companyField == 'IT'}">
								checked="checked"
								</c:if>
							>
						Logistics <input type="radio"  name="companyField" value="Logistics"
								<c:if test="${selectedCompany.companyField == 'Logistics'}">
								checked="checked"
								</c:if>
							>
						Education <input type="radio"  name="companyField" value="Education"
								<c:if test="${selectedCompany.companyField == 'Education'}">
								checked="checked"
								</c:if>
							>
						Advertisement <input type="radio"  name="companyField" value="Advertisement"
								<c:if test="${selectedCompany.companyField == 'Advertisement'}">
								checked="checked"
								</c:if>
							></p><br>
						<p>HR <input type="radio"  name="companyField" value="HR"
								<c:if test="${selectedCompany.companyField == 'HR'}">
								checked="checked"
								</c:if>
							>
						Finance <input type="radio"  name="companyField" value="Finance"
								<c:if test="${selectedCompany.companyField == 'Finance'}">
								checked="checked"
								</c:if>
							>
						Business Administration <input type="radio"  name="companyField" value="Business Administration"
								<c:if test="${selectedCompany.companyField == 'Business Administration'}">
								checked="checked"
								</c:if>
							>
						Art <input type="radio"  name="companyField" value="Art"
								<c:if test="${selectedCompany.companyField == 'Art'}">
								checked="checked"
								</c:if>
							>
						Etc <input type="radio"  name="companyField" value="Etc"
								<c:if test="${selectedCompany.companyField == 'Etc'}">
								checked="checked"
								</c:if>
							></p>
						</div>
					</div>
					<div>
						<p>Company Payment</p>
						<input type="text" id="companyPayment" name="companyPayment" value="${selectedCompany.companyPayment}" required><p>万円</p>
					</div>
					<div>
						<p>Company WorkingTime</p>
						<input type="text" id="companyWorkingTime" name="companyWorkingTime" value="${selectedCompany.companyWorkingTime}" required maxlength="2"><p>Hrs.</p>
					</div>
					<div>
						<p>Company Employee</p>
						<input type="text" id="companyEmployee" name="companyEmployee" value="${selectedCompany.companyEmployee}" required>
					</div>
					<div>
						<p>Company Capital</p>
						<input type="text" id="companyCapital" name="companyCapital" value="${selectedCompany.companyCapital}" required><p>万円</p>
					</div>
					<div>
						<p>Company Foundation</p>
						<input type="date" id="companyFoundation" name="companyFoundation" required>
						<div style="color: red; display:inline-block;">
						<div id="previousValueDiv">Previous value : ${selectedCompany.companyFoundation}</div>
						</div>
					</div>
					<div>
						<p>Company Homepage</p>
						<input type="text" id="companyHomepage" name="companyHomepage" value="${selectedCompany.companyHomepage}">
					</div>
					<div>
						<p>Current Image</p>
						<div><img src="<c:url value="${selectedCompany.companyImageFileRoot}"/>" width="510px"/></div>
						<div>
							<input type="text" id="companyImageFileRoot" name="companyImageFileRoot" value="${selectedCompany.companyImageFileRoot}" style="width:500px;">
						</div>
						<div id="lowerURLDiv">*Input URL of an image.</div>
					</div>
					<br>
					<input type="hidden" id="companyNum" name="companyNum" value="${selectedCompany.companyNum}">
					<div style="text-align: center;">
					<a href="./companyInfo?companyNum=${selectedCompany.companyNum}"><input type="button" id="backButton" value="Back"></a>
					<input type="reset" id="resetButton" value="Reset">
					<input type="submit" id="submitButton" value="Update">
					</div>
				</div>	
			</form>
		</div>
	</div>
	<br>
	<p> </p>
	<br>
</body>
</html>