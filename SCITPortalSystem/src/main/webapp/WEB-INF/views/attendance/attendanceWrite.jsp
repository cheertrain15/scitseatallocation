<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	th,td {padding: 15px;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 지각 및 결석 글쓰기 ] - SC IT Master</title>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/home.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>">


	
	
</head>
<body>
	<br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="radio" name="registrationReason" id="lateBtn" value="0"  checked>지각&nbsp;&nbsp;
	<input type="radio" name="registrationReason" id="absenceBtn" value="1"  >결석&nbsp;&nbsp;
	<div id="viewLate" class="descAttend" align="center">
		<form action="write" method="post" >
			<table>
				<tr>
					<td align="right" colspan="5">
						<input type="submit" value="등록">		
					</td>
				</tr>
				<tr>
					<td width="200px">
						<a>지각 사유</a>
					</td>
					<td width="200px">
						<a>예상 도착 시간</a>
					</td>
				</tr>
				<tr>
					<td width="150px">
						<select name="registrationContent" id="registrationContent" onchange="addInput(this.value);">
							<option value="" >사유 선택</option>
							<option value="oversleep" >늦잠</option>
							<option value="hospital" >병원</option>
							<option value="delaySubway" >지하철 연착</option>
							<option value="etc" >기타</option>
						</select>
					</td>
					<td>
						<select name="arrive_h" id="arrive_h">
							<c:set var="n" value="0"/>
							<c:forEach begin="0" end="23">
								<option value="${n}">${n }</option>
								<c:set var="n" value="${n+1 }"/>
							</c:forEach>					
						</select>
						<span>시</span>
						<select name="arrive_m" id="arrive_m">
							<c:set var="n" value="0"/>
							<c:forEach begin="0" end="5">
								<option value="${n}">${n }</option>
								<c:set var="n" value="${n+10 }"/>
							</c:forEach>					
						</select>
						<span>분</span>
					</td>
				</tr>
				<tr>
					<td id="inputBox" colspan="5" ></td>	
				</tr>
			</table>
			<input type="hidden" id="estimatedTime" name="estimatedTime" value="">
			<input  type="hidden" name="registrationReason" value="0">
		</form>
	</div>	
	
	
	
	<div id="viewAbsence" align="center">
		<form action="write" method="post" >
			<table>
				<tr>
					<td align="right" colspan="5">
						<input type="submit" value="등록"  >
					</td>
				</tr>
				<tr>
					<td width="200px">
						<a >결석 사유</a>
					</td>
					<td width="200px">
						<a>예상 연락 시간</a>
					</td>
				</tr>
				<tr>
					<td>
						<select name="registrationContent" id="registrationContent" onchange="addInput(this.value);">
							<option value="" >사유 선택</option>
							<option value="oversleep" >늦잠</option>
							<option value="hospital" >병원</option>
							<option value="delaySubway" >지하철 연착</option>
							<option value="etc" >기타</option>
						</select>
					</td>
					<td>
						<select name="arrive_h" id="arrive_h">
							<c:set var="n" value="0"/>
							<c:forEach begin="0" end="23">
								<option value="${n }">${n }</option>
								<c:set var="n" value="${n+1 }"/>
							</c:forEach>					
						</select>
						<span>시</span>
						<select name="arrive_m" id="arrive_m">
							<c:set var="n" value="0"/>
							<c:forEach begin="0" end="5">
								<option value="${n }">${n }</option>
								<c:set var="n" value="${n+10 }"/>
							</c:forEach>					
						</select>
						<span>분</span>
					</td>
				</tr>
				<tr>
					<td id="inputBox2" colspan="5"><input type="text" ></td>
				</tr>
			</table>
			<input type="hidden" id="estimatedTime" name="estimatedTime" value="">
			<input  type="hidden" name="registrationReason" value="1">
		</form>
	</div>	

	<!-- 지각 및 결석 입력 스크립트 -->
	<script type="text/javascript">
		/* 팝업 로딩 시 결석 화면 보이지 안헥 하기 위한 셋팅 */
		window.onload = function(){
			document.getElementById('viewAbsence').style.display = 'none';
			
		}
		
		/* 라디오 버튼 변경시 값 초기화 하기  */
		function fn_initialization(){
			$("[name=registrationReason] > option[value='']").attr("selected", "true");   //select box
			
		}
		
		/* 라디오 버튼 변경 시 Div 화면 전환 및 값 초기화 */
	 	$(function(){
 			$("input[name='registrationReason']").click(function(){
 				if ($("#lateBtn").is(":checked")) {
					$("#viewLate").show();
					$("#viewAbsence").hide();
					$("#registrationContent").val("");
					fn_initialization();
					delInput();
				} else {
					$("#viewAbsence").show();
					$("#viewLate").hide();
					$("#registrationContent").val("");
					fn_initialization();
					delInput();
				}
 				
 			});
		}); 
		
	
		/**
		**	SelectBox 선택에서 기타 선택 시 input tag 추가하기  
		**/
		function addInput(input) {
			var strInput = "";
			inputBox.innerHTML = "";
			inputBox2.innerHTML = "";
			
			if (input == 'etc') {
			  strInput = "<input type='text' name='etcReason' size='40' placeholder='기타 사유를 직접 장석하세요.'><br>";
			}
			inputBox.innerHTML = strInput; 
			inputBox2.innerHTML = strInput; 
		}
		
		/* 기타 항목 시 생성된 InnerHTML삭제하기 */
		function delInput() {
			var strInput = "";
			inputBox.innerHTML = strInput;
			inputBox2.innerHTML = strInput;
		}
		

	
	</script> 
	


</body>
</html>