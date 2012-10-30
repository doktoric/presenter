<jsp:root xmlns:spring="http://www.springframework.org/tags"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:util="urn:jsptagdir:/WEB-INF/tags/util"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.0">
	<jsp:directive.page contentType="text/html;charset=UTF-8" />
	<jsp:output omit-xml-declaration="yes" />
	<spring:message code="security_login_title" var="title"
		htmlEscape="false" />



	<spring:url value="/resources/images/social_icons/facebook.png"
		var="facebook" />
	<spring:url value="/resources/images/social_icons/google.png"
		var="google" />
	<spring:url value="/resources/images/social_icons/youtube.png"
		var="youtube" />
	<spring:url value="/resources/images/social_icons/github.png"
		var="github" />

	<div class="front-signup js-front-signup">

		<h2>
			<strong>New to Presenter?</strong>
		</h2>
		<form class="signup">
			<div style="width: 90%; margin-left: 10px;">
				<ul class=""> 
					<li>
					<a href="#" class="btn btn-mini" style="width: 95%; height: 20px;position: initial !important;">
							<img src="${github}" class="pull-left"
							style="width: 23px; height: 23px;" />
					Login with Github
					</a>
					</li>
					<li style="margin-top: 4px;">
					<a href="#" class="btn btn-mini" style="width: 95%; height: 20px;position: initial !important;">
							<img src="${facebook}" class="pull-left"
							style="width: 23px; height: 23px;" />
						Login with Facebook
					</a>
					</li>
				</ul>
				
				
			</div>
		</form>


	</div>




</jsp:root>