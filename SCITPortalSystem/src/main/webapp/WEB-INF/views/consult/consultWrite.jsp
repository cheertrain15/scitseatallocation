<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/consult/consultWrite.css"/>
<script type="text/javascript">
		function formCheck(){
			var title = document.getElementById('askQuestionTitle');
			var content = document.getElementById('askQuestionContent');
		
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
	</script>
<title>[문의하기]</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<br><br><br><br><br>
	<form action="writeQuestion" method="post"onsubmit="return formCheck();">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" id="askQuestionTitle" name="askQuestionTitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea id="askQuestionContent" name="askQuestionContent" rows="5" cols="40"></textarea></td>
			</tr>
			<tr>
				<th></th>
				<td colspan="2">
					<input type="submit" value="등록하기">
				</td>
			</tr>		
		</table>		
	</form>
	<%@ include file="../footer.jsp"%>
</body>
</html>