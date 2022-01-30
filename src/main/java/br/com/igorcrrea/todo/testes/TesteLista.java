package br.com.igorcrrea.todo.testes;

import java.sql.SQLException;
import java.util.List;
import br.com.igorcrrea.todo.model.DAO;
import br.com.igorcrrea.todo.model.Tarefa;

public class TesteLista {

	public static void main(String[] args) throws SQLException {
		
		DAO dao = new DAO();
		
		//dao.insert("Fazer rosfife");
		//dao.remove(9);
		//dao.update(9, "Não parar de estudar!");
		List<Tarefa> tarefas = dao.select();
		
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa);
		}
	}
		
}
