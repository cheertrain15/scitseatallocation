<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설문조사 상세보기</title>
</head>
<body>
    
<br><br>
선생님 / 학생으로 구분
<br><br>
선생님 - 설문조사의 내용과 옵션 내용 확인하고 수정 가능
<br><br>
학생 - 참여 여부에 따라<br>
		(참여했을 경우)설문 내용과 자신의 응답내용 확인<br>
		(참여하지 않았을 경우)참여페이지<br>
		<br><br>
	  마감일 경과 여부에 따라<br>
	  	(경과했을 경우)설문 내용만 확인 가능 <br><br><br>
	  	
	  	
	  	<input type="button" value="수정"> 
	  	<table>
	  		<tr>
	  		<td>설문번호</td>
	  		<td>기수</td>
	  		<td>반</td>
	  		<td>제목</td>
	  		<td>응답내용</td>
	  		<td>설문작성일</td>
	  		<td>설문시작일</td>
	  		<td>설문마감일</td>
	  		<td>작성자</td>
	  		<td>참여수</td>
	  		</tr>
	  	</table>
	  	
	  	<table>
	  		<tr>
	  		<td>학생번호</td>
	  		<td>기수</td>
	  		<td>반</td>
	  		<td>이름</td>
	  		<td>응답내용</td>
	  		<td>응답일</td>
	  		<td>참여여부</td>
	  		</tr>
	  	</table>

</body>
</html>