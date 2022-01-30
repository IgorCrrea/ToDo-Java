package br.com.igorcrrea.todo.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.igorcrrea.todo.model.DAO;

public class RemoveTarefa implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		DAO dao = new DAO();
		String id = request.getParameter("id");
		dao.remove(Integer.parseInt(id));
		
		return "redirect:/todo";
	}

}
