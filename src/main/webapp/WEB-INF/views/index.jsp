<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page isELIgnored="false" %> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>
	<head>
		<title><spring:message code="home.label" /></title>
	</head>
	<body>
		<div class="jumbotron">
			<h1><spring:message code="vote.no.livro.label" /></h1>
			
			<c:url var="url" value="/iniciar.do" />
			<form:form cssClass="form-signin" action="${url}" method="post" modelAttribute="usuario" name="form" id="form">
				<spring:message code="nome.label" var="nome" />
				<form:input path="nome" cssClass="form-control input-top" placeholder="${nome}" />
				<form:errors path="nome" cssClass="error" />
				
				<spring:message code="email.label" var="email" />				
				<form:input path="email" cssClass="form-control input-bottom" placeholder="${email}" />
				<form:errors path="email" cssClass="error" />
			</form:form>
			
			<p>				
				<a class="btn btn-lg btn-success" href="javascript:iniciarVotacao();">
					<spring:message code="iniciar.label" />
				</a>
			</p>
		</div>	
	</body>
</html>