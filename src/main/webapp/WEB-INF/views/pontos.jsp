<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
	<head>
		<title><spring:message code="pontos.title" /></title>
	</head>
	<body>
		<div class="jumbotron">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th><spring:message code="usuario.label" /></th>
						<th><spring:message code="pontos.label" /></th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${pontos}" var="ponto" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${ponto.usuario.nome}</td>
							<td>${ponto.quantidade}</td>
						</tr>
					</c:forEach>
				</tbody>			
			</table>
		</div>
	</body>
</html>