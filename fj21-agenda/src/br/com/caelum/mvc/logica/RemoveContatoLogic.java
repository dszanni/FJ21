package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class RemoveContatoLogic implements LogicaInterface {
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// recebe uma string do request e converte para long que é o tipo do
		// atributo da Classe Contato.
		long id = Long.parseLong(req.getParameter("id"));

		Contato contato = new Contato();
		contato.setId(id);

		// ContatoDao dao = new ContatoDao();
		
		//Busca a conexao pendurada na requisicao
		Connection connection = (Connection) req.getAttribute("conexao");
		//Passando a conexao para o construtor
		ContatoDao dao = new ContatoDao(connection);
		dao.exclui(contato);

		System.out.println("Excluindo contato...");

		// http://localhost:8080/fj21-agenda/mvc?ParamLinklogica=ListaContatosLogic
		return "mvc?ParamLinklogica=ListaContatosLogic";
	}

}
