<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>​
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[공지사항]</title>
<link rel="stylesheet" type="text/css" href="../resources/css/news/news.css" />
	<script type="text/javascript" src="<c:url value="/resources/js/news/news.js"/>"></script>
	<script type="text/javascript">
		function newsWrite() {
			location.href = "newsWrite"
		}
		function pagingFormSubmit(currentPage){
			var form = document.getElementById("pagingForm");
			var page = document.getElementById("page");
			page.value = currentPage;
			form.submit();
		}
	</script>
</head>
<body>
<%@ include file="../header.jsp" %>
<br><br><br><br><br>
	<table id="table">
			<tr>
				<th colspan="1" class="page-header" style="border-left: 5px solid #7a1705;" >
				<span style="font-size:22px; font-weight:bold; font-family:inherit; margin-left:1%;" data-langnum="105">공지사항</span>
				</th>
			</tr>
			<tr>
				<th colspan="3" class="selectNews">
					<form action="NewsMain" method="get">
						<select name="searchSelectAlumni">
							<option value="34" <c:if test="${targetAlumni == '34' }">selected</c:if>>34기</option>
							<option value="35" <c:if test="${targetAlumni == '35' }">selected</c:if>>35기</option>
						</select>
						<select name="searchSelectClass">
							<option value="A" <c:if test="${targetClass == 'A' }">selected</c:if>>A반</option>
							<option value="B" <c:if test="${targetClass == 'B' }">selected</c:if>>B반</option>
							<option value="C" <c:if test="${targetClass == 'C' }">selected</c:if>>C반</option>
							<option value="D" <c:if test="${targetClass == 'D' }">selected</c:if>>D반</option>
						</select>
						<input id="submit" type="submit" value="검색">
					</form>
				</th>
				<th>
					<c:if test="${sessionScope.loginMemberClass == 'teacher'}">
						<input id="button" class="newsinput" type="button" value="글작성" onclick="newsWrite()">
					</c:if>
				</th>
			</tr>
		<tr>
			<th id="th" width="10%">말머리</th>
			<th id="th" width="60%">제목</th>
			<th id="th" width="10%">작성일</th>
			<th id="th" width="10%">조회수</th>
		</tr>

		<c:forEach var="news" items="${NewsList}">
			<tr>
				<td id="td" class="tdnews">${news.newsHeader}</td>			
				<td id="td" ><a id="atitle" href="read?newsNum=${news.newsNum}">${news.newsTitle}</a><c:if test="${news.newsFileName != null}">
				<img width="15px" src="../resources/img/icon.png"></c:if>
				</td>
				<td id="td" class="tdnews"><fmt:formatDate pattern = "yyyy-MM-dd" value = "${news.newsDate}" /></td>
				<td id="td" class="tdnews">${news.newsHits}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="consultdiv">
		<a id="a" href="javascript:pagingFormSubmit(1)">◁◁</a> 
		<a id="a" href="javascript:pagingFormSubmit(${navi.currentPage-1})">◀</a>
		<c:forEach var="counter" begin="${navi.startPageGroup}"	end="${navi.endPageGroup}">
			<c:if test="${counter == navi.currentPage}">
				<b>
			</c:if>
				<a id="a" href="javascript:pagingFormSubmit(${counter})">${counter}</a>
			<c:if test="${counter == navi.currentPage}">
				</b>
			</c:if>
		</c:forEach>
		<a id="a" href="javascript:pagingFormSubmit(${navi.currentPage+1})">▶</a> 
		<a id="a" href="javascript:pagingFormSubmit(${navi.totalPageCount})">▷▷</a>
	</div>
	<div class="consultdiv">
		<form action="NewsMain" method="GET" id="pagingForm">
				<input type="hidden" name="page" id="page">
		</form>
	</div>
	<br><br><br>
	<%@ include file="../footer.jsp"%>
</body>
</html>