<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:util="urn:jsptagdir:/WEB-INF/tags/util"  version="2.0">

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
</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar"
	data-twttr-rendered="true">
	<tiles:insertAttribute name="menu" ignore="true" />
	<div class="container">
		<tiles:insertAttribute name="body" />
	</div>
	
	
</body>

</jsp:root>
