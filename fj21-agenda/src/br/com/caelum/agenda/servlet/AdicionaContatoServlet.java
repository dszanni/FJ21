package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");

		Calendar dataNascimento = null;

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro de conversão de data");
			return;

		}

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		Connection connection = (Connection) request.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);
		dao.adiciona(contato);

//		Dispatch de requisições - Pág.101
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/contato-adicionado.jsp");
		rd.forward(request, response);

//		Organizando o cód. para separar cód. HTML "abaixo" da lógica.
//		(Servlet fica com a regra de negócio e a JSP com a apresentação)
		
//		out.println("<html>");
//		out.println("<body>");
//		out.println("Contato " + contato.getNome() + " adicionado com sucesso");
//		out.println("</body>");
//		out.println("</html>");
	}

}
