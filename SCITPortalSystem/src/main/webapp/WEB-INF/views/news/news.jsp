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
	</script>
</head>

<body>
<%@ include file="../header.jsp" %>
<br><br><br><br><br>	
	<table>
			<tr>
				<th colspan="3" class="selectNews">
					<form action="NewsMain" method="get">
						<select name="targetAlumni">
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
					</form>
				</th>
				<th>
					<c:if test="${sessionScope.loginMemberClass == 'Teacher'}">
						<input class="newsinput" type="button" value="글작성" onclick="newsWrite()">
					</c:if>
				</th>
			</tr>
		<tr>
			<th>말머리</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>

		<c:forEach var="news" items="${NewsList}">
			<tr>
				<td class="tdnews" width="100px">${news.newsHeader}</td>			
				<td width="300px"><a href="read?newsNum=${news.newsNum}">${news.newsTitle}</a><c:if test="${news.newsFileName != null}">
				<img width="10px" src="../resources/img/icon.png"></c:if>
				</td>
				<td class="tdnews" width="100px"><fmt:formatDate pattern = "yyyy-MM-dd" value = "${news.newsDate}" /></td>
				<td class="tdnews" width="100px">${news.newsHits}</td>
			</tr>
		</c:forEach>
	</table>
<%@ include file="../footer.jsp"%>
</body>
</html>