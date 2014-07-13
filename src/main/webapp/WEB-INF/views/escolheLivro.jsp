<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>
	<head>
		<title><spring:message code="votacao.title" /></title>
	</head>
	<body>
		<div class="jumbotron">
			<h1><spring:message code="qual.livro.voce.prefere.label" /></h1>
			
			<c:url var="url" value="/votacao/votar.do" />
			<form:form action="${url}" method="post" modelAttribute="votacao" name="form" id="form">
				<form:hidden path="usuario" />
				<c:forEach items="${votacao.ids}" var="id" varStatus="status">
					<input type="hidden" name="ids[${status.index}]" value="${id}" />
				</c:forEach>
				<form:hidden path="votoAtual"/>
				
				<div class="row">
					<c:forEach items="${livros}" var="livro">
						<div class="col-md-6">
							<div class="thumbnail">
								<a href="javascript:escolherLivro('${livro.id}');">
									<c:url value="/resources/img/livros/${livro.arquivo}.jpg" var="imagem" />
									<img src="${imagem}" data-src="holder.js/600x600" class="img-circle imagem" />
								</a>
								<div class="caption">
									<h3>${livro.nome}</h3>
									
									<p><spring:message code="genero.label" />: <spring:message code="${livro.genero.descricao}" /></p>
									
									<c:if test="${not empty livro.descricao}">
										<p>${livro.descricao}</p>
									</c:if>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				
			</form:form>
		</div>
	</body>
</html>