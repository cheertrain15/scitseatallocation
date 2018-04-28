<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>[지각 및 결석 관리]</title>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/seat/seat.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/attendance/attendance.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/attendance/attendance.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.structure.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.structure.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.theme.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.theme.min.css"/>">
	
	
	<script type="text/javascript">
	
		function pagingFormSubmit(currentPage) {
			var form = document.getElementById("pagingForm");
			var page = document.getElementById("page");
			page.value = currentPage;
			form.submit();
		}
		
		function writeRegist(){
			window.open("writeRegist", "newWindow", "top=300,left=500,height=400,width=700");
		}
		
		$(function() {
	        $( '.selected_all' ).click( function() {
	          $( '.reginumCheck' ).prop( 'checked', this.checked );
	        } );
		});
		
		$(function() {
			$('#delRegiBtn').on('click',function(){
				var registrationNum = '';
				$('.reginumCheck:checked').each(function(index, item){
					if(index == 0){
						registrationNum += $(this).closest('.trList').find('.reginumCheck').val();
					}else{
						registrationNum += ','+$(this).closest('.trList').find('.reginumCheck').val();
					}
				});
		
				$('#registrationNum').val(registrationNum);
				$('#delList').submit();
			});
		});	
		
	</script>
	
	
</head>
<body>	
	<%@ include file="../header.jsp" %>
	<br><br><br><br><br>	
	<div class="attendanceMain" id="attendanceMain" align="center">
		<c:if test="${memberClass == 'staff' }">
			<input type="button" id="delRegiBtn" value="삭제">
			<table>
				<tr>
					<th><input type="checkbox" name="selected_all" class="selected_all"/></th>
					<th width="70px">번호</th>
					<th width="70px"> 기수</th>
					<th width="70px">반</th>	
					<th width="90px">이름</th>
					<th width="70px">종류</th>
					<th width="200px">사유</th>
					<th width="150px">도착예정시간</th>
					<th width="150px">작성일시</th>
					<th width="150px">확인</th>
		  	 	</tr>
	  	 		<c:choose>
	  	 			<c:when test="${registlist != null }">
						<c:forEach var="list" items="${registlist }" varStatus="status">
							<tr class="trList" >
								<td>
									<input type="checkbox" class="reginumCheck" value="${list.registrationNum }">
								</td>
								<td width="50px" align="center"> ${list.registrationNum }</>
								<td width="50px" align="center"> ${list.alumni } </td>
								<td width="50px" align="center"> ${list.classroom } </td>
								<td width="70px" align="center"> 
									<a> ${list.name } </a> <!-- 이름 클릭 시, 학생 정보 창 보여기주기 위한 a Tag -->
								</td>
								<c:if test="${list.registrationReason == 0}">
									<td width="50px" align="center"> 지각</td>
								</c:if>
								<c:if test="${list.registrationReason == 1}">
									<td width="50px" align="center"> 결석</td>
								</c:if>								
								<td width="300px"> ${list.registrationContent }</td>
								<td width="100px" > ${list.estimatedTime } </td>
								<td width="150px"> <fmt:formatDate  value="${list.registrationDate }" pattern="yyyy/MM/dd HH:mm"/> </td> <!-- 시간 까지 출력되도록 설정 -->
								<td>						
								<c:if test="${list.attendance_stu == 'N'}">
									<input type="button" value="확인" i="${list.registrationNum }" class="comFirmBTN"/>											
								</c:if>	
								<c:if test="${list.attendance_stu == 'Y'}">
									<b>Complete</b>										
								</c:if>	
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr height="100px">
							<td colspan="8" align="center">출력할 결과가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
			<form action="delRegistration" method="get" id="delList">
				<input type="hidden" name="reginumCheck" id="registrationNum">
			</form>
			<br>
			
			<a href="javascript:pagingFormSubmit(${navi.currentPage -5 })" style="text-decoration:none">◁◁ </a>&nbsp;&nbsp;
			<a href="javascript:pagingFormSubmit(${navi.currentPage -1 })" style="text-decoration:none">◀ </a>&nbsp;&nbsp;
			<c:forEach var="counter" begin="${navi.startPageGroup }" end="${navi.endPageGroup }">
				<c:if test="${counter == navi.currentPage }" >
					<b>
				</c:if>
					<a href="javascript:pagingFormSubmit(${counter })" style="text-decoration:none">${counter }</a>&nbsp;&nbsp;
				<c:if test="${counter == navi.currentPage }">
					</b>
				</c:if>
			</c:forEach>&nbsp;&nbsp;
			<a href="javascript:pagingFormSubmit(${navi.currentPage +1 },${searchMap.boardname })" style="text-decoration:none">▶ </a>&nbsp;&nbsp;
			<a href="javascript:pagingFormSubmit(${navi.currentPage +5 })" style="text-decoration:none"> ▷▷</a>
			<br>
			<form action="attendance" id="pagingForm" method="get"><!-- 전에 만들었던 list를 사용하기 위해 get -->
				<select name="selAlumni" id="selalumni">
					<option value="">기수 </option>
					<option value="1"  <c:if test="${selAlumni == '1' }">selected</c:if>>1기</option>
					<option value="2" <c:if test="${selAlumni == '2' }">selected</c:if>>2기</option>
					<option value="34" <c:if test="${selAlumni == '34' }">selected</c:if>>34기</option>
					<option value="35" <c:if test="${selAlumni == '35' }">selected</c:if>>35기</option>
				</select>
			
				<select name="selClassroom">
					<option value="">반 </option>
					<option value="A" <c:if test="${selClassroom == 'A' }">selected</c:if>>A반</option>
					<option value="B" <c:if test="${selClassroom == 'B' }">selected</c:if>>B반</option>
					<option value="C" <c:if test="${selClassroom == 'C' }">selected</c:if>>C반</option>
					<option value="D" <c:if test="${selClassroom == 'D' }">selected</c:if>>D반</option>
					<option value="E" <c:if test="${selClassroom == 'E' }">selected</c:if>>E반</option>
				</select>
				
				<input type="text" name ="searchText" value="${searchText }"  style="width:200px;height:30px;"> 
				<input type="hidden" name="page" id="page">
			
				<input type="button" onclick="pagingFormSubmit(1)" value="검색" >
						
			</form>
		</c:if>
		
		
		<!-- 학생 로그인시 보여줄 화면 -->
		<c:if test="${memberClass == 'student' }">
			<table>
				<tr>
					<td colspan="7">
						<input type="button" value="글쓰기" onclick="writeRegist()" align="right">
					</td>
				</tr>
				<tr>
					<th width="70px">번호</th>
					<th width="70px">기수</th>
					<th width="70px">반</th>
					<th width="90px">이름</th>
					<th width="90px">종류</th>
					<th width="350px">사유</th>
					<th width="150px">도착예정시간</th>
					<th width="150px">작성일시</th>
		  	 	</tr>
	  	 			<c:if test="${registlist_stu != null }">
	  	 				<c:set var="n" value="1"/>
	  	 				<c:forEach var="list" items="${registlist_stu }" varStatus="status">
							<tr>
								<td width="50px" align="center"> ${n}</td>
								<td width="50px" align="center"> ${list.alumni } </td>
								<td width="50px" align="center"> ${list.classroom } </td>
								<td width="70px" align="center"> 
									<a> ${list.name } </a> <!-- 이름 클릭 시, 학생 정보 창 보여기주기 위한 a Tag -->
								</td>
								<c:if test="${list.registrationReason == 1}">
									<td width="50px" align="center"> 결석 </td>
								</c:if>
								<c:if test="${list.registrationReason == 0}">
									<td width="50px" align="center"> 지각 </td>
								</c:if>								
								<td width="300px"> ${list.registrationContent }</td>
								<td width="100px" > ${list.estimatedTime } </td>
								<td width="150px"> <fmt:formatDate  value="${list.registrationDate }" pattern="yyyy/MM/dd HH:mm"/> </td> <!-- 시간 까지 출력되도록 설정 -->
							</tr>
							<c:set var="n" value="${n+1 }"/>
						</c:forEach>
					</c:if>
					<c:if test="${registlist_stu == null }">
						<tr height="100px">
							<td colspan="7" align="center">출력할 결과가 없습니다.</td>
						</tr>
					</c:if>
			</table>
		</c:if>					
	</div>
	<br><br><br><br><br>
<%@ include file="../footer.jsp"%>	
</body>
</html>