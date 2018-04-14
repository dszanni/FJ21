package br.com.caelum.tarefas.controller;

import javax.validation.Valid;

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

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) //@Valida Verifica se tem erros no atributo descricao e se tiver volta para o formulario
	{

		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}

		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}

	@RequestMapping("listaTarefas")
	public String lista(Model model) // Possui a request (Model model) recurso do Spring o model é um objeto
	{
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(tarefa);
		return "redirect:listaTarefas";//o "Redirect" Redireciona para o metodo listaTarefas: "@RequestMapping("listaTarefas")"

	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra";

	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.altera(tarefa);
		return "redirect:listaTarefas";

	}

	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.finaliza(id);
	}

}
