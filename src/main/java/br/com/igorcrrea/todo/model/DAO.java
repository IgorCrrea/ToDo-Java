package br.com.igorcrrea.todo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	Connection con;

	public List<Tarefa> select() throws SQLException {
		List<Tarefa> listaDeTarefas = new ArrayList<>();

		Statement stm = instanciaConection();
		stm.execute("SELECT ID, DESCRICAO, FEITO FROM TAREFA");
		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("ID");
			String descricao = rst.getString("DESCRICAO");
			Integer feito = rst.getInt("FEITO");

			Tarefa tarefa = new Tarefa(id, descricao, feito);
			listaDeTarefas.add(tarefa);
		}

		this.con.close();
		return listaDeTarefas;
	}

	public List<Tarefa> select(String campo, String valor) throws SQLException {
		List<Tarefa> listaDeTarefas = new ArrayList<>();

		Statement stm = instanciaConection();
		stm.execute("SELECT * FROM TAREFA WHERE "+campo+"="+valor+"");
		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("ID");
			String descricao = rst.getString("DESCRICAO");
			Integer feito = rst.getInt("FEITO");

			Tarefa tarefa = new Tarefa(id, descricao, feito);
			listaDeTarefas.add(tarefa);
		}

		this.con.close();
		return listaDeTarefas;
	}

	public void insert(String item) throws SQLException {
		Statement stm = instanciaConection();
		stm.execute("INSERT INTO TAREFA(DESCRICAO) VALUES ('" + item + "')", Statement.RETURN_GENERATED_KEYS);
		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		this.con.close();

	}

	public void remove(Integer id) throws SQLException {
		Statement stm = instanciaConection();
		stm.execute("DELETE FROM TAREFA WHERE ID = " + id + "");

		System.out.println("Quantidade de linhas modificadas: " + stm.getUpdateCount());
		this.con.close();
	}

	public void update(Integer id, String descricao) throws SQLException {
		Statement stm = instanciaConection();
		stm.execute("UPDATE TAREFA SET DESCRICAO = '" + descricao + "' WHERE ID=" + id + "");

		this.con.close();
	}

	private Statement instanciaConection() throws SQLException {
		ConnectionFactory conFactory = new ConnectionFactory();
		con = conFactory.conecta();
		Statement stm = con.createStatement();

		return stm;
	}

}
