package br.caelum.jdbc.teste;

import java.sql.SQLException;
import br.caelum.jdbc.jdbc.dao.ContatoDao;
import br.caelum.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) throws SQLException {

		ContatoDao contatoDao = new ContatoDao();
		Contato contato = new Contato();

		contato = contatoDao.getLista().get(0);
		System.out.println(contato.getNome());

		contato.setNome("NomeAlterado");
		contatoDao.alterar(contato);

		System.out.println("Atualizado");

	}

}
