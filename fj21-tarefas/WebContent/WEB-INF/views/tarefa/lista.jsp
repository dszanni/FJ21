<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous
">

<html>

<head>
<script type="text/javascript" src="resources/js/jquery.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Tarefas</title>
</head>

	<body>
		<script type="text/javascript">
			function finalizaAgora(id){
				$.post("finalizaTarefa", {'id' : id}, function(){
					$("#tarefa_"+id).html("Finalizado");
				});
			}
		</script>
		
	
		<table class="table table-sm">
			
			<thead>
				<tr>
				    <th scope="col">Id</th>
					<th scope="col">Descricao</th>
					<th scope="col">Finalizado?</th>
					<th scope="col">Data de finalizacao</th>
					<th scope="col">Operacao</th>
				</tr>
			</thead>
				
			<c:forEach items="${tarefas}" var="tarefa">
			  <tr>
				  	<td>${tarefa.id}</td>
				  	<td>${tarefa.descricao}</td>
				  	  	
<!-- 				  	  	Pode ser utilizado um IF Ternário -->

					  	<c:if test="${tarefa.finalizado eq false}">
					  		<td id="tarefa_${tarefa.id}">
					  			<a href="#" onClick="finalizaAgora(${tarefa.id})" >Finaliza agora!</a>
					  		</td>
					  	</c:if>
					  	
					  	<c:if test="${tarefa.finalizado eq true}">
					  		<td>Finalizado</td>
					  	</c:if>
		
				  	<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/></td>			  	
				  	
				  	<td>
				  	<a href="removeTarefa?id=${tarefa.id}">Remover</a>
				  	<a href="mostraTarefa?id=${tarefa.id}&dataFinalizacao=<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>">Alterar</a>
				  	</td>					  					  	
			  </tr>	
			</c:forEach>
		</table>
		
				<a href="novaTarefa">Criar Nova Tarefa</a>
	</body>
</html>