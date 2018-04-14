<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous
">


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Contatos</title>
</head>
<body>
 	<c:import url="/WEB-INF/jsp/cabecalho.jsp"/>
 	
<!--  	Removendo a instaciação do DAO da VIEW para a camada model -->
<%-- 	<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao"></jsp:useBean> --%>

	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Nome</th>
				<th scope="col">E-Mail</th>
				<th scope="col">Endereco</th>
				<th scope="col">Data Nascimento</th>
			</tr>
		</thead>
		<c:forEach var="contato" items="${contatosList}">

			<tbody>
				<tr>
					<td>${contato.nome}</td>
					<td>
						<c:if test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:if>
						
						<c:if test="${empty contato.email}">
							E-mail não informado
						</c:if>
					</td>
					<td>${contato.endereco}</td>				
					<td>
					 <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
					</td>
					
					<td>
					 <a href="mvc?ParamLinklogica=RemoveContatoLogic&id=${contato.id}">Remover</a>				
					</td>
					
					<td>
					 <a href="mvc?ParamLinklogica=AdicionaContatoLogic&id=${contato.id}&nome=${contato.nome}&email=${contato.email}&endereco=${contato.endereco}&dataNascimento=<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>">Alterar</a>				
					</td>
					
				</tr>
			</tbody>
		</c:forEach>
	</table>
<c:import url="/WEB-INF/jsp/rodape.jsp"/>
</body>
</html>