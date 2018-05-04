<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value ="/resources/css/mainMenu.css"/>" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/mypage/Mypage_1.css"/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/mypage/Mypage_2.css"/>" />
		<script type="text/javascript" src="<c:url value="../js/jquery-3.2.1.js"/>"></script>
		<script type="text/javascript" src="<c:url value="../js/myPage.js"/>"></script>
		<title>[Staff Page]</title>
		<script type="text/javascript">	
		<c:if test="${errorUP != null}">
		${errorMsg }
		</c:if>		
		</script>
		<script type="text/javascript">
		
		function staffInfo() {	
			alert("Success");
			document.updateStaffSub.submit();
			 
		}
		
		</script>
	</head>
	
<body>
<%@ include file="../header.jsp" %>
<form action="addStaffInfo" method="post" name="updateStaffSub" enctype="multipart/form-data">
<input type="hidden" id="id" name="id" value="${staff.id}">
  <section class="tabs">
      <input id="tab-1" type="radio" name="radio-set" class="tab-selector-1" checked="checked" />
         <label for="tab-1" class="tab-label-1" style="background: #990000;color: #fff;">Work</label>
                
           <input id="tab-2" type="radio" name="radio-set" class="tab-selector-2" />
                    <div class="clear-shadow"></div>
                        <div class="content">
                            <div class="content-1">                                 
                                <ul class="profile_box">                                   
                                    <li>
                                        <table>                               
                                          			                           					    	
								    	<tr>
								    		<th>기수</th>
								    		<td>
								    		<select name="inChargeAlumni">
									    		<option value="">선택</option>
									    		<option value="33">33기</option>
									    		<option value="34">34기</option>
									    		<option value="35">35기</option>
									    		<option value="36">36기</option>    		
								    		</select>
								    		</td>
								    	</tr>				    	
								      	<tr>
								    		<th>담당</th>
								    		<td>
								    		<select name="inChargeSubject">
								    			<option value="">선택</option>
									    		<option value="Staff">학사</option>
									    		<option value="IT">IT</option>
									    		<option value="Japanese">일본어</option>
									    	</select>
								    		</td>
								    	</tr>
                                            <tr>
                                           <!--  <td>
                                            <label id="cancelBtn" onclick='goHome()' >Home</label>                                            
                                            </td>  -->
                                            <td>
                                            <label id="ChangeBtn" onclick='staffInfo()' style="font-size: 16px;">Compelete</label>
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