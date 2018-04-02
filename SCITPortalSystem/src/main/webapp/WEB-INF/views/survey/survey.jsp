<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설문 목록</title>

<script type="text/javascript" src="./resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="./resources/js/survey/survey.js"></script>
<link rel="stylesheet" type="text/css" href="./resources/css/survey/survey.css">
	
</head>
<body> 
	
	<h1>설문 목록</h1>
	
	<a href="surveyCreate"><input type="button" value="새설문작성"></a>
	
	<hr>

	<div>
	<table>
	<tr>
	<td>글번호</td>
	<td>제목</td>
	<td>작성자</td>
	<td>설문 작성일</td>
	<td>설문 시작일</td>
	<td>설문 마감일</td>
	<td>참여자 수</td>
	</tr>
	
	<c:forEach items="${list}" var="v">
	<tr>
	<td>${v.surveyNum}</td>
	<td>${v.surveyTitle}</td>
	<td>${v.name}</td>
	<td>${v.surveyWrittenDate}</td>
	<td>${v.surveyStartDate}</td>
	<td>${v.surveyEndDate}</td>
	<td>차후join으로가져올것</td>
	</tr>
	</c:forEach>
 
	</table>
	</div>
	
	<div>
			<ul>
				<c:if test="${navi.currentPage > 1}">
					<li><a href="survey?page=1"><input class="button"
							type="button" value="맨앞"></a></li>
				</c:if>
				<c:if test="${navi.startPageGroup > 1 }">
					<li><a href="survey?page=${navi.startPageGroup-1}"><input
							class="button" type="button" value="이전"></a></li>
				</c:if>
				<c:forEach begin="${navi.startPageGroup}" end="${navi.endPageGroup}"
					var="p">
					<c:if test="${navi.currentPage == p}">
						<li>${p}</li>
					</c:if>
					<c:if test="${navi.currentPage != p}">
						<li><a href="survey?page=${p}">${p}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${navi.endPageGroup < navi.totalPageCount }">
					<li><a href="survey?page=${navi.endPageGroup+1}"><input
							class="button" type="button" value="다음"></a></li>
				</c:if>
				<c:if test="${navi.currentPage != navi.totalPageCount}">
					<li><a href="survey?page=${navi.totalPageCount}"><input
							class="button" type="button" value="맨뒤"></a></li>
				</c:if>
			</ul>
		</div>

</body>
</html>