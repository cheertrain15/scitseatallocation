<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/news/newsRead.css"/>
<title>[해달 글 읽기]</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<br><br><br><br><br>
	<table>
		<tr>
			<th>제목</th>
		</tr>
		<tr>
			<td height="50px" width="300px">${news.newsTitle}</td>
		</tr>
		<tr>
			<th>내용</th>
		</tr>
		<tr>
			<td height="100px" width="300px">${news.newsContent}</td>
		</tr>
		<tr>
			<th>첨부파일</th>
		</tr>
		<tr>
			<td>
			<a href="download?newsNum=${news.newsNum}"> 
					${news.newsFileName}
			</a></td>
		</tr>
	</table>
<%@ include file="../footer.jsp"%>
</body>
</html>