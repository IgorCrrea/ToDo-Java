package br.com.igorcrrea.todo.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.igorcrrea.todo.model.DAO;
import br.com.igorcrrea.todo.model.Tarefa;

public class CarregaLista implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		DAO dao = new DAO();
		List<Tarefa> tarefas = dao.select();
				
		request.setAttribute("tarefas", tarefas);
		
		return "forward:index.jsp";
	}

}
