<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  	<meta content="width=device-width" id="viewport" name="viewport" />
    <title>IU unveils new master's degree in cybersecurity | IT News &amp; Events</title>
    <link href="<c:url value="https://itnews.iu.edu/files/favicon.ico"/>" rel="shortcut icon" type="image/x-icon" />
    <meta charset="utf-8" />
    <!-- CSS -->   
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/main/uits.css"/>" media="all" rel="stylesheet" type="text/css" />   
    <link href="<c:url value="/resources/css/main/app.css"/>" media="all" rel="stylesheet" type="text/css" />
    
     <script>
        var phpRoot = '/files/php/';
        var mediaRoot = '/media';
        var articleRoot = '/articles';
    </script>
    <!-- Google Tag Manager -->
    <noscript>
        <iframe src="<c:url value="//www.googletagmanager.com/ns.html?id=GTM-P8S3H4"/>" height="0" width="0" style="display:none;visibility:hidden"></iframe>
    </noscript>
    <script>
        (function(w, d, s, l, i) {
            w[l] = w[l] || [];
            w[l].push({
                'gtm.start': new Date().getTime(),
                event: 'gtm.js'
            });
            var f = d.getElementsByTagName(s)[0],
                j = d.createElement(s),
                dl = l != 'dataLayer' ? '&l=' + l : '';
            j.async = true;
            j.src = '//www.googletagmanager.com/gtm.js?id=' + i + dl;
            f.parentNode.insertBefore(j, f);
        })(window, document, 'script', 'dataLayer', 'GTM-P8S3H4');
    </script>
    <!-- End Google Tag Manager -->

<div>
    <div class="clearfix">
        <div id="branding-bar-v1" itemscope="itemscope" itemtype="http://schema.org/CollegeOrUniversity">
            <div class="bar">
                <div class="header--subsite" role="banner">
                    <div class="header container">
                        <div class="header__wrapper">
                            <div class="header__masthead">
                                <a class="header__masthead-link" href="http://www.iu.edu" title="Indiana University">
                                    <img class="header__masthead-image" src="<c:url value="/resources/img/logo_sample.png"/>" height="73" width="64" alt="">
                                    <span class="header__masthead-text" itemprop="name sourceOrganization provider" style="font-size: 20px;">SCIT&nbsp;PORTAL</span>
                                </a>
                            </div>
                            <!-- UITS Navigation -->
                            <div class="uits-nav uits-nav--with-search search-nudge js-expandable-search__nudge">                               
                                    <nav role="navigation" class="uits-nav__menu">
                                        <ul class="uits-nav__list">
                                        <c:if test="${sessionScope.loginID == null}">                                        
                                            <li class="uits-nav__item">
                                                <a href="<c:url value="/member/loginForm"/>" class="js-dropdown__trigger js-services" data-dropdown="uits-nav-dropdown--quicklinks">LOGIN</a>
                                            </li>
                                            <li class="uits-nav__item">
                                                <a href="<c:url value="/member/joinType"/>" class="js-dropdown__trigger js-about" data-dropdown="uits-nav-dropdown--about">JOIN </a>
                                            </li>   
                                        </c:if>  
                                        <c:if test="${sessionScope.loginID != null}">
                                        	<li class="uits-nav__item">
                                                <a href="<c:url value="/member/myPage"/>" class="js-dropdown__trigger js-services" data-dropdown="uits-nav-dropdown--quicklinks">MYPAGE</a>
                                            </li>
                                            <li class="uits-nav__item">
                                                <a href="<c:url value="/member/logoutForm"/>" class="js-dropdown__trigger js-about" data-dropdown="uits-nav-dropdown--about">LOGOUT</a>
                                            </li>                                           
                                        </c:if>                                                                             
                                        </ul>                                       
                                    </nav>                                            
                            </div>
                            <!-- /.search -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="page-wrapper">
            <div class="results-area" role="main" tabindex="-1">
                <div class="results-target">
                    <div class="hero__site hero__site--small">
                        <div class="row">
                            <div class="large-12 columns">                                
                                <nav class="hero__nav" id="nav-toggle">
                              	<c:choose>
                              		
                              		<c:when test="${sessionScope.loginID != null}">
                              			<c:if test="${sessionScope.loginID eq 'admin'}">
                              			<ul>
                              				<li><a href="<c:url value="/admin/management"/>">  Management  </a></li>
                              			 </ul> 
                                   		</c:if>
                                   		<c:if test="${sessionScope.loginID != 'admin'}">
                                   		<ul>
	                                        <li><a href="">  News  </a></li>
	                                        <c:if test="${sessionScope.loginMemberClass == 'staff'}">
	                                        <li><a href="<c:url value="/additionalInfo/staffPage"/>">  Work Information  </a></li>
	                                        </c:if>
	                                        <li><a href="<c:url value="/attendance/attendance"/>">  Attendance  </a></li>
	                                        <li><a href="">  Survey  </a></li>
	                                        <li><a href="">  Seat  </a></li>
	                                        
	                                    </ul> 
                               			</c:if>
                               			<%-- <c:if test="${sessionScope.loginMemberClass == 'staff'}">
                               				<li><a href="">  News  </a></li>
	                                        <li><a href="">  Attendance  </a></li>
	                                        <li><a href="">  Survey  </a></li>
	                                        <li><a href="">  Seat  </a></li>
	                                        <li><a href="">  Work Information  </a></li>                               			
                               			</c:if>   
                               			   --%>
                               			  		
                                     </c:when>
                                     
                               </c:choose>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>