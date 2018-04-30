<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/consult/consultRead.css"/>
<title>[글 읽기]</title>
<script type="text/javascript">
	function deleteBoard(askQuestionNum) {
		if (confirm("정말로 삭제하시겠습니까?")) {
			location.href = "deleteBoard?askQuestionNum=" + askQuestionNum;
		}
	}
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
<body>
<%@ include file="../header.jsp" %>
<br><br><br><br><br>
	<table>
		
		<tr>
			<th id="consultReadTh">&nbsp 제목</th>
		</tr>
		<tr>
			<td id="consultTitle" height="50px" width="300px">${askquestion.askQuestionTitle}</td>
		</tr>
		<tr>
			<th id="consultReadTh">&nbsp 내용</th>
		</tr>
		<tr>
			<td id="consultContent" height="100px" width="300px">${askquestion.askQuestionContent}</td>
		</tr>
		<tr>
			<th>
				<a href="javascript:deleteBoard('${askquestion.askQuestionNum}')">삭제</a>
			</th>
		</tr>
		<tr>
			<th class="return">
				<input id="button2" type="button" value="돌아가기" onclick="askQestionlistReturn()">
			</th>
		</tr>
		<tr>
			<th>
				<%-- <c:if test="${sessionScope.loginId != null }"> --%>
				<form action="insertReply" method="post" onsubmit="return ">
					<input type="hidden" name="askQuestionNum" value="${askquestion.askQuestionNum}">
					답글 <input style="width: 200px; height: 25px" type="text" name="text"> 
					<input id="button" type="submit" value="등록">
				</form>				
				<%-- </c:if> --%>
			</th>
		</tr>
	</table>
	<table>
		<c:forEach var="reply" items="${replyList}">
				<tr>
					<td style="width: 100px" >${reply.name}</td>
					<td class="replyconsult" style="width: 300px">${reply.text }</td>
					<td style="width: 100px"><fmt:formatDate pattern = "yyyy-MM-dd" value = "${reply.inputdate }" /></td>
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
	<br><br>
	<%@ include file="../footer.jsp"%>
</body>
</html>