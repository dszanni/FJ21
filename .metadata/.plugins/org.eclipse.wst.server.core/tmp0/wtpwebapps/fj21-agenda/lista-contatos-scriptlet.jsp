<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ page import="java.util.*, br.com.caelum.agenda.dao.*, br.com.caelum.agenda.modelo.*, java.text.SimpleDateFormat, java.util.Date"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
	<body>
		<table>
			<%
				ContatoDao dao = new ContatoDao();
				List<Contato> contatos = dao.getLista();
	
				for (Contato contato : contatos) {
			%>
			<tr>
				<td><%=contato.getNome()%></td>
				<td><%=contato.getEmail()%></td>
				<td><%=contato.getEndereco()%></td>
<%-- 				<td><%=contato.getDataNascimento().getTime()%></td> --%>
<%-- 				<td><%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date())%></td> --%>
			</tr>
			<%
				}
			%>
		</table>
	</body>
</html>