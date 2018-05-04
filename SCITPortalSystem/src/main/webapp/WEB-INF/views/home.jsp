<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>[HOME]</title>	
		<meta charset="UTF-8">	
		<!-- Javascript -->
		<link href="<c:url value ="resources/css/main/home.css"/>" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script src="http://malsup.github.com/jquery.cycle2.js"></script>	
	</head>

<body>
<%@ include file="header.jsp" %>

<div class="a">
	<img alt="" src="<c:url value="./resources/img/main_img_2.jpg"/>" style="opacity: 0.8;">
		<div class="text">
		<h2>Smart IT Cloud</h2>
		<p>There are admirable potentialities in every human being. <br>Believe in your strength and your youth. <br>Learn to repeat endlessly to yourself, 'It all depends on me.'
</p>
		<div class="d">
			<a href="<c:url value="/member/joinType"/>">Go to the Tokyo!</a>
		</div>
	</div>	
</div>
<div class="b">
	<ul>
		<li>
			<img alt="" src="<c:url value="./resources/img/main_img_3.jpg"/>">
			<div class="black"></div>
			<div class="e">
				<h4>News</h4>
				<p>
					Nothing great in the world <br>has been accomplished <br>without passion.
				</p>
			</div>
			<div class="ea">
				<a href="http://scitmaster.blog.me/" style="right: 85px;">MORE</a>
			</div>
		</li>
		<li>
			<img alt="" src="<c:url value="./resources/img/34th.jpg"/>">
			<div class="black"></div>
			<div class="e">
				<h4>Gallery</h4>
				<p>					
					It has never been <br>my object to record my dreams<br> just to realize them.
				</p>
			</div>
			<div class="ea">
				<a href="http://scitmaster.blog.me/" style="-46px;">MORE</a>
			</div>
		</li>
	</ul>
</div>

<!-- 여기에 내용 입력하면 됨 -->
<%-- <div class="slideDi" style="max-width:800px;margin-bottom:80px" align="center">
	 <div class="cycle-slideshow"  data-cycle-fx=scrollHorz data-cycle-timeout=2000  align="center" >
	    <img src="<c:url value="./resources/img/Jabrate.png"/>" style="width:90%">
	    <img src="<c:url value="./resources/img/preschool.jpg"/>" style="width:90%">		    
	    <img src="<c:url value="./resources/img/34th.jpg"/>" style="width:90%">
	</div>
</div> --%>

<!-- 헤더 / 푸터 나눠서 include -->
<%@ include file="footer.jsp"%>
</body>
</html>


