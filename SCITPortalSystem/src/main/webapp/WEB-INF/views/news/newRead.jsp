<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/news/newsRead.css"/>
<link href="<c:url value ="/resources/css/mainMenu.css"/>" rel="stylesheet" type="text/css" />	
<title>[해달 글 읽기]</title>
	<script type="text/javascript">
	function deleteBoard(newsNum) {
		if (confirm("정말로 삭제하시겠습니까?")) {
			location.href = "deleteBoard?newsNum=" + newsNum;
		}
	}
	function askQestionlistReturn() {
		location.href = "NewsMain"
	}
		
	</script>
</head>
<body>
<%@ include file="../header.jsp" %>
<br><br><br><br><br>
	<table>
		<tr>
		<th>
			<span class="page-header" style="border-left: 5px solid #7a1705; font-size:22px; font-weight:bold; font-family:inherit; margin-left:1%;" data-langnum="105">&nbsp 공지사항 확인</span>
		</th>
		</tr>
		<tr>
			<th id="newReadth">제목</th>
		</tr>
		<tr>
			<td id="newTd" height="50px" width="500px">${news.newsTitle}</td>
		</tr>
		<tr>
			<th id="newReadth">내용</th>
		</tr>
		<tr>
			<td id="newTd" height="300px" width="500px">${news.newsContent}</td>
		</tr>
		<tr>
			<th id="newReadfile">첨부파일</th>
		</tr>
		<tr>
			<td>
			<a href="download?newsNum=${news.newsNum}"> 
					${news.newsFileName}
			</a></td>
		</tr>
		<tr>
			<th>
				<c:if test="${sessionScope.loginMemberClass == 'teacher'}">
					<a href="javascript:deleteBoard('${news.newsNum}')">삭제</a>
					<a href="updateForm?newsNum=${news.newsNum}">수정</a>
				</c:if>
			</th>
		</tr>
		<tr>
			<th class="return">
				<input id="button2" type="button" value="돌아가기" onclick="askQestionlistReturn()">
			</th>
		</tr>
	</table>
	<br><br><br>
<%@ include file="../footer.jsp"%>
</body>
</html>