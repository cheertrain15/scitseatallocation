<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="../resources/css/news/newsWrite.css"/>
	<script type="text/javascript">
		function formCheck(){
			var title = document.getElementById('newsTitle');
			var content = document.getElementById('newsContent');
		
			if (title.value == '') {
				alert('제목을 입력해 주세요.');
				return false;
			}
			if (content.value == '') {
				alert('내용을 입력해 주세요.');
				return false;
			}
			return true;
		}
		$("#upload").change(function() {
			readURL(this);
		});
	</script>
	<title>[문의하기]</title>
	</head>	
	<body>
	<%@ include file="../header.jsp" %>
	<br><br><br><br><br>
	<form action="insertNewsWrite" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" id="newsTitle" name="newsTitle"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="checkbox" id="newsHeader" name="newsHeader" value="중요">중요</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea id="newsContent" name="newsContent" rows="5" cols="40"></textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="upload">
				</td>
			</tr>
				
		</table>
		<input type="submit" value="저장">		
	</form>	
	<%@ include file="../footer.jsp"%>
	</body>
</html>