<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="../resources/css/news/newsUpdate.css"/>
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
	<form action="update" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
		<input type="hidden" name=newsNum value="${news.newsNum}">
		<table>
			<tr>
			<th></th>
			<td>
				<span class="page-header" style="border-left: 5px solid #7a1705; font-size:22px; font-weight:bold; font-family:inherit; margin-left:1%;" data-langnum="105">&nbsp 공지사항 수정</span>
			</td>
		</tr>
			<tr>
				<th id="newWriteTh">제목</th>
				<td><input type="text" id="newWriteinput" name="newsTitle" value="${news.newsTitle}"></td>
			</tr>
			<tr>
				<th></th>
				<td>
				<input id="WritecheckBox" type="checkbox" id="newsHeader" name="newsHeader" value="중요">중요
					<select id="WriteSelect" name="writeAlumni">
							<option value="0">전체공지</option>
							<option value="34">34기</option>
							<option value="35">35기</option>
						</select>
						<select id="WriteSelect" name="writeClass">
							<option value="Z">--</option>
							<option value="A">A반</option>
							<option value="B">B반</option>
							<option value="C">C반</option>
							<option value="D">D반</option>
						</select>
				</td>
			</tr>
			<tr>
				<th id="newWriteTh">내용</th>
				<td><textarea id="newWritetextarea" name="newsContent" rows="5" cols="40" >${news.newsContent}</textarea></td>
			</tr>
			<tr>
				<th id="newWriteTh">첨부파일</th>
				<td>
					${news.newsFileName}
					<input type="file" name="upload">
				</td>
			</tr>
		</table>
		<div style="width: 50px; height: 50px; margin: auto;" id="submitDiv">
			<input id="button" type="submit" value="저장">
		</div>		
	</form>	
	<br><br><br>
	<%@ include file="../footer.jsp"%>
	</body>
</html>