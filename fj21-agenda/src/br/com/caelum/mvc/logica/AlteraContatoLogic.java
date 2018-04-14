package br.com.caelum.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AlteraContatoLogic implements LogicaInterface {
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// long id = Long.parseLong(req.getParameter("id"));

		Contato contato = new Contato();
		try{
			contato.setId(Long.parseLong(req.getParameter("id")));
		}catch (Exception e){
			System.out.println();
			
		}

		contato.setNome(req.getParameter("nome"));
		contato.setEndereco(req.getParameter("endereco"));
		contato.setEmail(req.getParameter("email"));

		Date c = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dataNascimento = Calendar.getInstance();
		c = sdf.parse(req.getParameter("dataNascimento"));
		dataNascimento.setTime(c);

		contato.setDataNascimento(dataNascimento);

		Connection connection = (Connection) req.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);

		if (contato.getId() == null) {
			dao.adiciona(contato);
		} else {
			dao.atualiza(contato);
		}

		return "mvc?ParamLinklogica=ListaContatosLogic";

	}

}
