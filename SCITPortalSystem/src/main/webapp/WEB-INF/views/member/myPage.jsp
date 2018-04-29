<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">		
		<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/mypage/Mypage_1.css"/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/mypage/Mypage_2.css"/>" />
		<script type="text/javascript" src="<c:url value ="/resources/js/mypage/Mypage.js"/>"></script>
		<title>[My Page]</title>
		<script type="text/javascript">
		function goHome() {
			location.href = "../";
		}
		function goPersonal() {
			location.href = 'updateMypage';
		}
		function goCertificate() {
			location.href = 'updateCertificate';
		}
		function goStaff() {
			location.href = 'staffPage';
		}
		
		</script>
	</head>
	
<body>
<%@ include file="../header.jsp" %>
<div>
     <section class="tabs">
      <input id="tab-1" type="radio" name="radio-set" class="tab-selector-1" checked="checked" />
         <label for="tab-1" class="tab-label-1">Personal</label>
                
           <input id="tab-2" type="radio" name="radio-set" class="tab-selector-2" />
           <c:if test="${searchOne.memberClass != 'student'}">
           	<label for="tab-2" class="tab-label-2">Work</label> 
           </c:if>
            <c:if test="${searchOne.memberClass == 'student'}">
           	<label for="tab-2" class="tab-label-2">Academic</label> 
           </c:if>               
                    <div class="clear-shadow"></div>
                        <div class="content">
                            <div class="content-1">                                 
                                <ul class="profile_box">
                                    <li>
                                        <h2 style="width: 52%;">Profile</h2>
                                        <img width="160" height="180" src="downLoad?id=${searchOne.id }" alt="사진 없음">
                                    </li>
                                    <li>
                                        <table>                                     
                                            <tr>
                                                <th>ID</th>
                                                <td>${searchOne.id}</td>
                                            </tr>
                                            <tr>
                                                <th>Name</th>
                                                <td>${searchOne.name}</td>
                                            </tr>
                                            <tr>
                                                <th>Phone</th>
                                                <td>${searchOne.phone}</td>
                                            </tr>
                                            <tr>
                                                <th>Email</th>
                                                <td>${searchOne.email}</td>
                                            </tr>
                                            <tr>
                                                <th>Address</th>
                                                <td>${searchOne.address}</td>
                                            </tr>    
                                            <tr>
                                            <td>
                                            <label id="cancelBtn" onclick='goHome()' >Home</label>                                            
                                            </td> 
                                            <td>
                                            <label id="ChangeBtn" onclick='goPersonal()' >Change</label>
                                            </td>
                                            </tr> 
                                        </table>     
                                    </li>
                                </ul>                                  
                            </div>                        
                        <c:if test="${searchOne.memberClass == 'student'}">
                         <div class="content-2">
                         <h2 style="width: 88%;">Student No.  ${searchStudent.memberstudentNum}</h2> 
                         
                         	<ul class="academic_box">              	
		                         	<li style="margin-top: 20px;">		                           
		                           	<table>								    	
								    	<tr>
								    		<th>기수</th>
								    		<td>${searchStudent.alumni} 기</td>
								    	</tr>
								    	<tr>
								    		<th>IT(유사전공 포함)</th>
								    		<c:if test="${searchStudent.itMajor == 1}">    		
								    		<td>전공자</td>
								    		</c:if>
								    		<c:if test="${searchStudent.itMajor == 0}">    		
								    		<td>비전공자</td>
								    		</c:if>
								    	</tr>
								    	<tr>
								    		<th>일본어</th>
								    		<c:if test="${searchStudent.jpMajor == 1}">    		
								    		<td>전공자</td>
								    		</c:if>
								    		<c:if test="${searchStudent.jpMajor == 0}">    		
								    		<td>비전공자</td>
								    		</c:if>
								    	</tr>
								    	<tr>
								    		<th>반(Class)</th>
								    		<td>${searchStudent.classroom} 반</td>
								    	</tr>								    	
								    </table>
								   </li>
								    
								    <li>
								    <table>
								   	    <tr>
								    		<th>조(Group)</th>
								    		<td>${searchStudent.groupNum} 조</td>
								    	</tr>      
								    	<tr>
								    		<th>좌석(Seat)</th>
								    		<td>${searchStudent.seat}</td>
								    	</tr>
								    	<tr>
								    		<th>지각</th>
								    		<td>${searchStudent.late} 회</td>
								    	</tr>
								    	<%-- <tr>
								    		<th>조퇴</th>
								    		<td>${searchStudent.early} 회</td>
								    	</tr>      --%>
								    	<tr>
								    		<th>결석</th>
								    		<td>${searchStudent.absent} 회</td>
								    	</tr>      
								    	<tr>
                                            <td>
                                            <label id="cancelBtn" onclick='goHome()' >Home</label>                                            
                                            </td> 
                                            <td>
                                            <label id="ChangeBtn" onclick='goCertificate()' >Change</label>
                                            </td>
                                            </tr>  
								    </table>  
								  </li>
						    </ul>                      	
                           </div>
                        </c:if>             
                        <c:if test="${searchOne.memberClass != 'student'}">
                         <div class="content-2">
                         <h2 style="width: 88%;">Teacher No.  ${searchStaff.teacherNum}</h2> 
                         
                         	<ul class="academic_box">              	
		                         	<li style="margin-top: 20px;">		                           
		                           	<table>								    	
								    	<tr>
								    		<th>기수</th>
								    		<td>${searchStaff.inChargeAlumni} 기</td>
								    	</tr>				    	
								      	<tr>
								    		<th>담당</th>
								    		<td>${searchStaff.inChargeSubject} </td>
								    	</tr>
								    	 <tr>
                                            <td>
                                            <label id="cancelBtn" onclick='goHome()' >Home</label>                                            
                                            </td> 
                                            <td>
                                            <label id="ChangeBtn" onclick='goStaff()' >Change</label>
                                            </td>
                                            </tr> 								    	
								    </table>
								 </li>								    
						    </ul>                      	
                           </div>
                        </c:if>     
                        </div>                          
                 </section>                         
 </div>
<%@ include file="../footer.jsp"%>
</body>
</html>