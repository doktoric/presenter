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






	<fmt:bundle basename="application">

	</fmt:bundle>



	<div class="front-signin js-front-signin">
		<spring:url value="/resources/j_spring_security_check" var="form_url" />

		<form class="signin " name="f" action="${fn:escapeXml(form_url)}"
			method="POST">


			<div class="placeholding-input username">

				<input id="j_username" type='text' name='j_username' 	autocomplete="on" class="signup-user-email" title="Username" placeholder="Username or email" style="width: 95%;"/>
				<spring:message code="security_login_form_name_message" 	var="name_msg" htmlEscape="false" />
			</div>
			<table class="flex-table password-signin">
				<tbody>
					<tr>
						<td class="flex-table-primary">
						<div class="placeholding-input password flex-table-form">
								<input id="j_password" type='password' name='j_password' class="text-input flex-table-input" title="Password"	autocomplete="on" placeholder="Password" /> 
								<spring:message code="security_login_form_password_message" var="pwd_msg" htmlEscape="false" />
						</div>

						</td>
						<td class="flex-table-secondary">
							<fmt:message					key="submit_label" var="submit_label"></fmt:message>
						 	<input					type="submit" code="button_login"			class="submit btn primary-btn flex-table-btn js-submit"		value="${submit_label}" tabindex="4"  /> 
						 	<spring:message	code="button_login" var="submit_label" htmlEscape="false" />
						</td>
					</tr>
				</tbody>
			</table>
			
		</form>
	</div>





</jsp:root>

