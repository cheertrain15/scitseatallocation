<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[해달 글 읽기]</title>
</head>
<body>
	<table>
		<tr>
			<th>제목</th>
		</tr>
		<tr>
			<td>${news.newsTitle}</td>
		</tr>
		<tr>
			<th>내용</th>
		</tr>
		<tr>
			<td>${news.newsContent}</td>
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

</body>
</html>