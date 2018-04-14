package br.com.caelum.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.LogicaInterface;

@WebServlet("/mvc")//Faz parte da url: http://localhost:8080/fj21-agenda/mvc?ParamLinklogica=AdicionaContatoLogic&id=4
public class ControllerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		Para testar: http://localhost:8080/fj21-agenda/mvc?ParamLinklogica=PrimeiraLogica
		String parametro = request.getParameter("ParamLinklogica");
		String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;
		
//		String nomeDaClasse = "br.com.caelum.mvc.logica" + request.getParameter("ParamLinklogica");
		   
		try {
			
			Class classe = Class.forName(nomeDaClasse);
//			Instanciando uma classe através do nome dela - Devolve um object
			LogicaInterface logica = (LogicaInterface) classe.newInstance();
			
			//Recebe a String após a execucao da lógica
			String pagina = logica.executa(request, response);

			//Faz o forward para a página JSP 	
			request.getRequestDispatcher(pagina).forward(request, response);

		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}

}
