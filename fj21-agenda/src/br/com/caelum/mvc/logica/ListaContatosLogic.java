package br.com.caelum.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class ListaContatosLogic implements LogicaInterface {
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Connection connection = (Connection) req.getAttribute("conexao");
		List<Contato> contatos = new ContatoDao(connection).getLista();

		req.setAttribute("contatosList", contatos);

		return "/WEB-INF/jsp/lista-contatos.jsp";
	}

}
