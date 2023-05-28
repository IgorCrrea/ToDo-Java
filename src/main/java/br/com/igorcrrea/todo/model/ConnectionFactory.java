package br.com.igorcrrea.todo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("ERRO");
			e.printStackTrace();
		}
	}
	
	public Connection conecta() throws SQLException {
		
		Connection conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/todo_list?useTimezone=true&serverTimezone=UTC", "root", "suaSenha");
			return conexao;
		
	}

}
