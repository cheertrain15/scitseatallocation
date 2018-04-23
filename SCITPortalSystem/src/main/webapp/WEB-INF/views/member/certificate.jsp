<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[Student Certificate]</title>
	</head>
	
<body>
<%@ include file="../header.jsp" %>
<form action="insertCertificate" style="border:1px solid #ccc" method="post">
<input type="hidden" name="id" value="${loginID}">
  <br><br><br><br>
    <h1>Student Certificate</h1><br>   
    <hr>
    
    <table>    		
    	<tr>
    		<th>기수</th>
    		<td>
	    	<select name="alumni">
	    		<option value="">선택</option>
	    		<option value="33">33기</option>
	    		<option value="34">34기</option>
	    		<option value="35">35기</option>
	    		<option value="36">36기</option>    		
    		</select>
    		</td>
    	</tr>
    	<tr>
    		<th>IT전공</th>
    		<td>
    		<select name="itMajor">
    			<option value="">선택</option>
	    		<option value="1">전공자</option>
	    		<option value="0">비전공자</option>
	    	</select>
    		</td>
    	</tr>    	
    	<tr>    		
    		<th>일본어 전공자</th>
    		<td>
    		<select name="jpMajor">
    			<option value="">선택</option>
	    		<option value="1">전공자</option>
	    		<option value="0">비전공자</option>
	    	</select>
    		</td>
    		
    	</tr>
    	<tr>
    		<th>정보처리기사(산업)보유</th>
    		<td>
    		<select name="itCertificate">
    			<option value="">선택</option>
	    		<option value="1">유</option>
	    		<option value="0">무</option>
	    	</select>
    		</td>
    	</tr>
    	<tr>
    		<th>JLPT</th>
    		<td>
    		<select name="jpCertificate">
    			<option value="">선택</option>
	    		<option value="1">유</option>
	    		<option value="0">무</option>
	    	</select>
    		</td>
    	</tr>      
    	<tr>
    		<th>기타자격증</th>
    		<td><input type="text" name="otherCertificate"></td>
    	</tr>       	
    </table> 
    
 <button type="submit">Complete</button>
</form>

<%@ include file="../footer.jsp"%>
</body>
</html>