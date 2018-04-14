package br.caelum.jdbc.teste;

import br.caelum.jdbc.jdbc.dao.ContatoDao;
import br.caelum.jdbc.modelo.Contato;

public class TestaRemove {

	public static void main(String[] args) {
		ContatoDao contatoDao = new ContatoDao();
		Contato contato = new Contato();
		
		// (1l) ou ((long)1) -> Cast explicito pq o tipo do atributo é Long =>Classe wrapper (Boas Praticas)		
		contato.setId(1);
		contatoDao.remove(contato);
	}
}
