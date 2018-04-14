package br.caelum.jdbc.teste;

import java.util.Calendar;

import br.caelum.jdbc.jdbc.dao.ContatoDao;
import br.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Diego");
		contato.setEmail("diego@contato.com.br");
		contato.setEndereco("Endereco teste");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		System.out.println("Gravado!");
	}

}
