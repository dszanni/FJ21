package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Obriga as outras classes que implementam esta interface, a utilizar o método executa
public interface LogicaInterface {
	String executa(HttpServletRequest req, HttpServletResponse res) throws Exception;

}
