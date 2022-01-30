package br.com.igorcrrea.todo.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.igorcrrea.todo.model.DAO;

public class AdicionaTarefa implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		DAO dao = new DAO();
		String novaTarefa = request.getParameter("nova-tarefa");
		dao.insert(novaTarefa);
		
		return "redirect:/todo";
	}

}
