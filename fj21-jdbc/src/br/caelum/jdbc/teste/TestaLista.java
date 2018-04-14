package br.caelum.jdbc.teste;

import java.util.List;

import br.caelum.jdbc.jdbc.dao.ContatoDao;
import br.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();

		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereco: " + contato.getEndereco());
			System.out.println("Data Nascimento: " + contato.getDataNascimento().getTime() + "\n");
		}

	}

}
