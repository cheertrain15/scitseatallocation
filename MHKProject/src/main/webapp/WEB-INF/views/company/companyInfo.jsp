<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CompanyInfo</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/companyInfo.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/companyInfo.css"/>">
<link href='https://fonts.googleapis.com/css?family=Arbutus' rel='stylesheet'>
</head>
<body>
	<c:if test="${selectedCompany.companyDeletedStatus == 0}">
	
	<div id="title">${selectedCompany.companyName}</div>
	<div>
		
		<div id="whole">
			<c:if test="${sessionScope.loginId != null}">
				<div>
					<input type="button" id="updateCompany" value="Update the information">
				</div>
			</c:if>
			<c:if test="${sessionScope.loginId == 'admin'}">
				<div>
					<input type="button" id="deleteCompany" value="Delete the information">
				</div>
				</c:if>
			<br>
				<div>
					<img src="<c:url value="${selectedCompany.companyImageFileRoot}"/>"/>
				</div>
				<div id="middle">
					<div>
						<p>Name :</p>
						<div style="display:inline-block;">
							${selectedCompany.companyName}
						</div>
					</div>
					<div>
					<p>CEO :</p>
						<div style="display:inline-block;">
							${selectedCompany.companyCEO}
						</div>
					</div>
					<div>
					<p>E-Mail :</p> 
						<div style="display:inline-block;">
							${selectedCompany.companyEmail}
						</div>
					</div>
					<div>
					<p>Phone Number :</p> 
						<div style="display:inline-block;">
							${selectedCompany.companyPhone}
						</div>
					<div>
					<div>
					<p>Address :</p> 
						<div style="display:inline-block;">
							${selectedCompany.companyAddress}
						</div>
					</div>
					<div>
					<p>Specialty :</p> 
						<div style="display:inline-block;">
							${selectedCompany.companyField}
						</div>
					</div>
					<div>
					<p>Payment :</p> 
						<div style="display:inline-block;">
							${selectedCompany.companyPayment}
						</div>
					</div>
					<div>
					<p>Labor hour :</p> 
						<div style="display:inline-block;">
							${selectedCompany.companyWorkingTime}
						</div>
					</div>
					<div>
					<p>Number of employees :</p> 
						<div style="display:inline-block;">
							${selectedCompany.companyEmployee}
						</div>
					</div>
					<div>
					<p>Capital :</p> 
						<div style="display:inline-block;">
							${selectedCompany.companyCapital}
						</div>
					</div>
					<div>
					<p>The date of foundation :</p> 
						<div style="display:inline-block;">
							${selectedCompany.companyFoundation}"
						</div>
					</div>
					<div>
					<p>Homepage :</p> 
						<div style="display:inline-block;">
							${selectedCompany.companyHomepage}
						</div>
					</div>
					<div>
					<p>Score :</p> 
						<div style="display:inline-block;">
							<fmt:formatNumber type="number" pattern="#.#" value="${avgScore}"></fmt:formatNumber> out of 5
						</div>
					</div>
					<div>
					<p>Grade :</p> 
						<div style="display:inline-block;">
							${grade}
						</div>
					</div>
				</div>
			</div>
			</div>
			<br>
			<c:if test="${sessionScope.loginId != null}">
				<input type="button" id="analyze" value="Analyze">
			</c:if>
			<br>
		</div>
	</div>
	<hr>
	<div id="lower">
		<div>
			<div id="replyId" style="display:inline-block;"><p>ID</p>
				<c:forEach items="${replyList}" var="reply">
					<c:if test="${reply.replyDeletedStatus == 0 }">	
					<div>
					<div id="replyId" style="display:inline-block;">${reply.writer}</div>
					</div>
					<div></div>
					</c:if>
				</c:forEach>
			</div>
			<p>　　　</p>
			<div id="replyContent" style="display:inline-block;"><p>Content</p>
				<c:forEach items="${replyList}" var="reply">
					<c:if test="${reply.replyDeletedStatus == 0  }">		
					<div>
					<input type="hidden" id="replyNum" value="${reply.companyReplyNum}">
					<div id="replyTextDiv" style="display:inline-block;">${reply.replyMessage}</div>
					</div>
					</c:if>
				</c:forEach>
			</div>
			<p>　　　</p>
			<div id="replyScore" style="display:inline-block;"><p>Score</p>
				<c:forEach items="${replyList}" var="reply">
					<c:if test="${reply.replyDeletedStatus == 0  }">		
					<div>
					<div id="replyScore" style="display:inline-block;">${reply.companyScore}</div>
					</div>
					</c:if>
				</c:forEach>
			</div>
			<p>　　　</p>
			<div id="replyDate" style="display:inline-block; "><p>Written Date</p>
				<c:forEach items="${replyList}" var="reply">	
				<c:if test="${reply.replyDeletedStatus == 0  }">	
				<div>
				<div id="replyDate" style="display:inline-block;"><fmt:formatDate value="${reply.replyDate}" type="BOTH"/></div>
				<div style="display:inline-block;">
						<c:if test="${sessionScope.loginId == reply.writer || sessionScope.loginId == 'admin'}">
						<a href="javascript:deleteCompanyReply('${reply.companyReplyNum}')"><input type="button" value="Delete"></a>
						</c:if>
					</div>
				</div>
				<div></div>
				</c:if>
				</c:forEach>
			</div>
		</div>
		<div style="text-align: center;">
				<a href="javascript:replyPaging(${navi.currentPage-1})">◀</a>
				<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
					<c:if test="${counter == navi.currentPage }"><b></c:if>
						${counter}
					<c:if test="${counter == navi.currentPage }"></b></c:if>
				</c:forEach>
				<a href="javascript:replyPaging(${navi.currentPage+1})">▶</a> 
			</div>
		<br>
		<c:if test="${sessionScope.loginId != null}">
			<div>
				<a href="javascript:companyReplySection()"><input type="button" value="Add Comment"></a>
			</div>
			<div id="companyReplySection"></div>
		</c:if>
	</div>
	<br>
	<hr>
	<br>
	
	<input type="hidden" name="page" id="page">
	<input type="hidden" id="companyNum" name="companyNum" value="${selectedCompany.companyNum}">
	<input type="hidden" id="loginId" name="writer" value="${sessionScope.loginId}">
	<input type="hidden" id="memberNum" name="memberNum" value="${sessionScope.loginMemberNum}">
	<div id="bottom">
		<a href="brief"><input type="button" id="back" value="Back"></a>
	</div>
	</c:if>
	<br><br>
</body>
</html>

