<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[글 읽기]</title>
<script type="text/javascript">
	function deleteReply(askQuestionReplyNum, askQuestionNum) {
		if (confirm("정말로 삭제하시겠습니까?")) {
			location.href = "deleteReply?askQuestionReplyNum=" + askQuestionReplyNum + "&askQuestionNum="
					+ askQuestionNum;
		}
	}
	function askQestionlistReturn() {
		location.href = "QnA"
	}
	function updateReplyForm(askQuestionReplyNum, askQuestionNum, retext) {
		var div = document.getElementById("div" + replynum);

		var str = '<form id="editForm'+replynum+'" action="replyUpdate" method="post">';

		str += '<input type="hidden" name="askQuestionReplyNum" value="'+askQuestionReplyNum+'">'

		str += '<input type="hidden" name="askQuestionNum" value="'+askQuestionNum+'">'

		str += '<input type="text" name="text" value="'+retext+'">';

		str += '<a href="javascript:replyCancel(div' + askQuestionReplyNum + ')">[취소]</a>';
		str += '</form>';

		div.innerHTML = str;
	}

	function replyCancel(div) {
		div.innerHTML = "";
	}
	
</script>
<link rel="stylesheet" type="text/css"
	href="../resources/css/default.css" />
</head>
<body background="../resources/image/background.JPG">
	<table>
		<tr>
			<th>제목</th>
		</tr>
		<tr>
			<td>${askquestion.askQuestionTitle}</td>
		</tr>
		<tr>
			<th>내용</th>
		</tr>
		<tr>
			<td>${askquestion.askQuestionContent}</td>
		</tr>
	</table>
	<div class="centerdiv">
		<%-- <c:if test="${sessionScope.loginId != null }"> --%>
			<form action="insertReply" method="post" onsubmit="return ">
				<input type="hidden" name="askQuestionNum" value="${askquestion.askQuestionNum}">
				답글 <input type="text" name="text"> <input type="submit"	value="등록">
			</form>
			<input type="button" value="돌아가기" onclick="askQestionlistReturn()">
		<%-- </c:if> --%>
		<br>
		<table>
			<c:forEach var="reply" items="${replyList}">
				<tr>
					<td>${reply.id }</td>
					<td>${reply.text }</td>
					<td>${reply.inputdate }</td>
					<td><%-- <c:if test="${sessionScope.loginId == reply.id }"> --%>
							<a	href="javascript:deleteReply('${reply.askQuestionReplyNum}','${reply.askQuestionNum}')">
								[삭제] </a>
						<%-- </c:if> --%></td>
				</tr>
				<tr>
					<td colspan="4">
						<div id="div${reply.askQuestionNum}"></div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>