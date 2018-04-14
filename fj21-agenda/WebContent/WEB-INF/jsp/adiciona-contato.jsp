<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<html>
<head>
<meta charset="UTF-8">
<title>Adiciona contato</title>
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<c:import url="/WEB-INF/jsp/cabecalho.jsp" />
</head>
<body>
	<form action="mvc">
		<table>
			<input type="hidden" name="ParamLinklogica" value="AlteraContatoLogic" />
			<input type="hidden" name="id" value="${param.id}" />
			<br />
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" value="${param.nome}" /><br />
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><input type="text" name="email" value="${param.email}" /><br />				
			</tr>
			<tr>
				<td>Endereço:</td>
				<td><input type="text" name="endereco" value="${param.endereco}" /> <br />			
			</tr>
			<tr>
				<td>Data Nascimento:</td>
				<td><caelum:campoData id="dataNascimento" data="${param.dataNascimento}"/> <br />
			</tr>
			<td><input type="submit" value="Salvar" />
		</table>
	</form>
	<c:import url="/WEB-INF/jsp/rodape.jsp" />
</body>
</html>