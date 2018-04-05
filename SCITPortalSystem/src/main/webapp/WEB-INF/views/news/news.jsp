<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>​
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[공지사항]</title>
<link rel="stylesheet" type="text/css" href="../resources/css/news.css" />
	<script type="text/javascript" src="<c:url value="/resources/js/news/news.js"/>"></script>
	<script type="text/javascript">
		function newsWrite() {
			location.href = "newsWrite"
		}
	</script>
</head>

<body>
	<div>
		<form action="NewsMain" method="get">
			<select name="targetAlumni">
				<!-- selected는 값이 있으면 targetAlumni == '34'값을 담아오겠다 라는 것이다. -->
				<option value="34" <c:if test="${targetAlumni == '34' }">selected</c:if>>34기</option>
				<option value="33" <c:if test="${targetAlumni == '33' }">selected</c:if>>33기</option>
			</select>
			<select name="targetClass">
				<option value="A" <c:if test="${targetClass == 'A' }">selected</c:if>>A반</option>
				<option value="B" <c:if test="${targetClass == 'B' }">selected</c:if>>B반</option>
				<option value="C" <c:if test="${targetClass == 'C' }">selected</c:if>>C반</option>
				<option value="D" <c:if test="${targetClass == 'D' }">selected</c:if>>D반</option>
			</select>
			<input type="submit" value="검색">
			<%-- <c:if test="${sessionScope.loginId == null}"> --%>
			<input type="button" value="글작성" onclick="newsWrite()">
			<%-- </c:if> --%>
		</form>		
	</div>
	<table>
		<tr>
			<th>말머리</th>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>

		<c:forEach var="news" items="${NewsList}">
			<tr>
				<td>${news.newsHeader}</td>
				<td>${news.newsNum}</td>				
				<td><a href="read?newsNum=${news.newsNum}">${news.newsTitle}</a><c:if test="${news.newsFileName != null}">
				<img width="10px" src="../resources/img/icon.png"></c:if>
				</td>
				<td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${news.newsDate}" /></td>
				<td>${news.newsHits}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>