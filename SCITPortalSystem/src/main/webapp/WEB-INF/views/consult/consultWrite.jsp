<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/consult/consultWrite.css"/>
<link href="<c:url value ="/resources/css/mainMenu.css"/>" rel="stylesheet" type="text/css" />	
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
		<th></th>
		<td>
			<span class="page-header" style="border-left: 5px solid #7a1705; font-size:22px; font-weight:bold; font-family:inherit; margin-left:1%;" data-langnum="105">&nbsp 1:1문의 작성</span>
		</td>
		</tr>
			<tr>
				<th id="consultTh1">제목</th>
				<td ><input id="consultTd" type="text" id="askQuestionTitle" name="askQuestionTitle"></td>
			</tr>
			<tr>
				<th id="consultTh">내용</th>
				<td><textarea id="askQuestionContent" name="askQuestionContent" rows="5" cols="40"></textarea></td>
			</tr>
			<tr>
				<th></th>
				<td colspan="2">
					<input id="consultButton" type="submit" value="등록하기">
				</td>
			</tr>		
		</table>		
	</form>
	<br><br>
	<%@ include file="../footer.jsp"%>
</body>
</html>