<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page isELIgnored="false" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<link rel="icon" href="<c:url value="/resources/img/favicon.png" />" type="image/png" />
		
		<script type="text/javascript" src="<c:url value="/resources/scripts/jquery.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/scripts/bootstrap.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/scripts/jquery.validate.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/scripts/functions.js" />"></script>
		
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-theme.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styles.css" />">
		
		<title><spring:message code="title.label" /> - <sitemesh:write property="title" /></title>
		
		<sitemesh:write property="head" />
	</head>
	<body>
		<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<c:url value="/" var="rootUrl" />
					<a class="navbar-brand" href="${rootUrl}">
						<img data-placement="right" src="<c:url value="/resources/img/logo.png" />" class="logo" />
						<spring:message code="project.name" />
					</a>
				</div>
			</div>
		</div>
		
		<div class="container body">
			<sitemesh:write property="body" />
		</div>
		
		<div class="footer">
			<div class="container">
				<p class="footer-label">
					<spring:message code="footer.label" />
				</p>
			</div>
		</div>
	</body>
</html>