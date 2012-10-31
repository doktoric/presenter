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


	<c:url value="https://github.com/login/oauth/authorize" var="git_auth_page">
		<c:param name="client_id" value="1bbec341e648577faabe" />
		<c:param name="redirect_uri" value="http://localhost:8080/presenter/auth/github/login" />
	</c:url>

	<spring:url value="/auth/facebook/login" var="facebook_url" />
	<spring:url value="/auth/github/login" var="github_url" />
	<spring:url value="/resources/images/social_icons/facebook.png"
		var="github_url" />
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
						<a	href="${git_auth_page}">
							<input href="#" type="button" value="Github" class="btn btn-mini"
								style="width: 95%; height: 20px; position: initial !important;">

							</input>
						</a>
					</li>
					
				</ul>


			</div>
		</form>


	</div>




</jsp:root>