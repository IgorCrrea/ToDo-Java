package br.com.igorcrrea.todo.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.igorcrrea.todo.action.Action;

@WebFilter("/")
public class ControllerFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ControladorFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("action");
		if(paramAcao == null) {
			paramAcao ="CarregaLista";
		}
		String nomeDaClasse = "br.com.igorcrrea.todo.action."+paramAcao;
		String nome;
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse); //carrega a classe com o nome
			Action acao = (Action) classe.getDeclaredConstructor().newInstance();
			nome = acao.run(request,response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		String[] tipoEEndereco = nome.split(":");
		
		if(tipoEEndereco[0].equals("forward")) {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
		rd.forward(request, response);
		
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
	}

}
