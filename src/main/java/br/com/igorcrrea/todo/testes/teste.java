package br.com.igorcrrea.todo.testes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.igorcrrea.todo.action.Action;

public class teste implements Action {

	@Override
	public String run(HttpServletRequest requets, HttpServletResponse response) throws ServletException, IOException {
		return "redirect:index.html";
	}

}
