<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:util="urn:jsptagdir:/WEB-INF/tags/util" version="2.0">
	<html>
<jsp:output doctype-root-element="HTML"
	doctype-system="about:legacy-compat" />

<jsp:directive.page contentType="text/html;charset=UTF-8" />
<jsp:directive.page pageEncoding="UTF-8" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=8" />

<util:load-scripts />

<spring:message code="application_name" var="app_name"
	htmlEscape="false" />


<title><spring:message code="welcome_h3" arguments="${app_name}" /></title>


<spring:url value="/resources/styles/loginStyle/t1_logging.css"
	var="t1_simple" />
<spring:url value="/resources/styles/loginStyle/t1_more.bundle.css"
	var="t1_more" />

<link rel="stylesheet" type="text/css" href="${t1_simple}" />
<link rel="stylesheet" type="text/css" href="${t1_more}" />

<c:url value="/resources/images/bg.jpg" var="background_image" />



</head>

<body
	class="t1 logged-out ms-windows front-random-image-jp-mountain front-page"
	dir="ltr" style="height: 100%; margin: 0; padding: 0;">

	<div id="doc" class="">
		<div class="topbar js-topbar">
			<div class="global-nav" data-section-term="top_nav">
				<div class="global-nav-inner">
					<div class="">

						<a href="#" class="brandreview">Welcome on ${app_name}</a>

					</div>
				</div>
			</div>
		</div>

		<div id="page-outer">
			<div id="page-container" class=" wrapper-front white">
				<div class="front-container front-container-full-signup  "
					id="front-container">




					<div class="front-bg">
						<img class="front-image" src="${background_image}" />
					</div>

					<div class="front-card">
						<div class="front-welcome">
							<div class="front-welcome-text">
								<h1>Welcome to Presenter.</h1>
								<p>Make Prezi</p>
							</div>

						</div>
						<tiles:insertAttribute name="body" ignore="true" />
						
						<tiles:insertAttribute name="auth" ignore="true" />
					</div>
				</div>

			</div>
		</div>

	</div>




</body>
	</html>
</jsp:root>
