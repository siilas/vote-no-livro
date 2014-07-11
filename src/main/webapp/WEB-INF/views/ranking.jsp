<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
	<head>
		<title><spring:message code="ranking.title" /></title>
	</head>
	<body>
		<div class="jumbotron">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th><spring:message code="livro.label" /></th>
						<th><spring:message code="votos.label" /></th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${votos}" var="voto" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${voto.livro.nome}</td>
							<td>${voto.quantidade}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<c:url value="/pontos.do" var="url" />
			<a href="${url}" class="btn btn-primary">
				<spring:message code="pontuacao.usuarios.label" />
			</a>
		</div>
	</body>
</html>