package br.com.caelum.tarefas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

//	@Autowired - Erro qu•••••e aconteceu ao definir a anatacao para o atributo ao inves de ser no construtor sendo necessario criar um construtor vazio
	private final JdbcTarefaDao dao;
	
	@Autowired
	public TarefasController(JdbcTarefaDao dao){
		this.dao = dao;	
	}
	
//	public TarefasController(){
//		this(null);
//	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) //@Valida Verifica se tem erros no atributo descricao e se tiver volta para o formulario
	{

		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
	    dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}

	@RequestMapping("listaTarefas")
	public String lista(Model model) // Possui a request (Model model) recurso do Spring o model é um objeto
	{
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		dao.remove(tarefa);
		return "redirect:listaTarefas";//o "Redirect" Redireciona para o metodo listaTarefas: "@RequestMapping("listaTarefas")"

	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra";

	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		dao.altera(tarefa);
		return "redirect:listaTarefas";

	}

	@ResponseBody //Responde o status do protocolo HTTP: 200 / 404 / 500
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id) {
		dao.finaliza(id);
	}
	
//	public void finaliza(Tarefa tarefa) { --Poderia receber a tarefa ao inves do ID
//		JdbcTarefaDao dao = new JdbcTarefaDao();
//		dao.finaliza(tarefa.getId());
//	}
	

}
