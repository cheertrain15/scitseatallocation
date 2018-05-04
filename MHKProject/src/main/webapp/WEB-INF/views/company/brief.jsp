<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>brief</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/brief.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/brief.css"/>">
<link href='https://fonts.googleapis.com/css?family=Arbutus' rel='stylesheet'>
</head>
<body>
	<div id="title">Companies</div>
	<div>
		<p> </p>
		<div>
		<div>
			<c:if test="${sessionScope.loginId != null}">
				<div id="addCompanyDiv">
					<input type="button" id="addCompanyButton" value="Add a new company">
				</div>
			</c:if>
		<br>
		</div>
		<div id="companyBriefDiv">
		
			<div>
				<c:forEach items="${companyList}" var="company">
					<c:if test="${company.companyDeletedStatus == 0}">
					<div>
						<div class="companyInnerDIv">
							<div class="companyImage">
								<a href="companyInfo?companyNum=${company.companyNum}">
								<img alt="${company.companyName}" height="100px" src="<c:url value="${company.companyImageFileRoot}"/>" >
								</a>
							</div>
							<div style="display: inline-block;">　<p>　</p>
							</div>
							<div class="companyInfoA">
								<a href="companyInfo?companyNum=${company.companyNum}" class="companyLink">${company.companyName}</a>
							</div>	
						</div>
					</div>
					<p></p>		
					</c:if>
				</c:forEach>
				<div style="text-align: center;">
				<a href="javascript:pagingFormSubmit(${navi.currentPage-1})">◀</a>
					<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
						<c:if test="${counter==navi.currentPage}"><b></c:if>
						${counter}
						<c:if test="${counter==navi.currentPage}"></b></c:if>
					</c:forEach>
				<a href="javascript:pagingFormSubmit(${navi.currentPage+1})">▶</a>
				</div>
				<br>
				<div style="text-align: center;">
					<form action="brief" method="get" id="pagingForm">
					<input type="hidden" name="page" id="page">
					<p style="display: inline-block;">Company Name 
					<input type="text" id="searchBox" name="searchName" value="${searchName}"></p>
					<input type="button" value="Search" onclick="pagingFormSubmit(1)">
					</form>
				</div>
				<br>
			</div>
			
		</div>
		</div>
	</div>
	<br>
	<div id="backButtonDiv">
		<a href="../"><input type="button" id="backButton" value="Back"></a>
	</div>
	<br><br>
</body>
</html>