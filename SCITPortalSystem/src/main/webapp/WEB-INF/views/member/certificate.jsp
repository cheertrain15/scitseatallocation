<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value ="/resources/css/mainMenu.css"/>" rel="stylesheet" type="text/css" />	
		<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/mypage/Mypage_1.css"/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/mypage/Mypage_2.css"/>" />
		<title>[Student Certificate]</title>
		<script type="text/javascript">
		
		function goComplete() {	
			alert("Success");
			document.updateStuSub.submit();
			 
		}
		
		
		</script>
	</head>
	
<body>
<%@ include file="../header.jsp" %>
<form action="insertCertificate" style="border:1px solid #ccc" method="post" name="updateStuSub">
<input type="hidden" name="id" value="${loginID}">
    <section class="tabs">
      <input id="tab-1" type="radio" name="radio-set" class="tab-selector-1" checked="checked" />
    	<label for="tab-1" class="tab-label-1" style="width: 150px;background: #990000;color: #fff;">Academic Info</label>
    	    
                    <div class="clear-shadow"></div>
                        <div class="content">
                            <div class="content-1">                                 
                                <ul class="profile_box">                                   
                                    <li>
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
								    		<th>IT 관련 자격증</th>
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
								    		<td><input type="text" name="otherCertificate" 
								    		style="position: static;opacity: 1;width: 220px; height: 25px;"></td>
								    	</tr>   
								    	
                                            <tr>                                           
                                            <td>
                                            <label id="ChangeBtn" onclick='goComplete()' style="margin-left: -2px;">Complete&nbsp;&nbsp;</label>
                                            </td>
                                            </tr> 
                                        </table>     
                                    </li>
                                </ul>                                  
                            </div>                      
                      </div>                          
                 </section>                        
</form>

<%@ include file="../footer.jsp"%>
</body>
</html>