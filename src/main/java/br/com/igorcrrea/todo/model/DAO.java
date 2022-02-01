package br.com.igorcrrea.todo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	Connection con;

	public List<Tarefa> select() throws SQLException {
		List<Tarefa> listaDeTarefas = new ArrayList<>();

		PreparedStatement pstm = instanciaConection("SELECT ID, DESCRICAO, FEITO FROM TAREFA");
		pstm.execute();
		ResultSet rst = pstm.getResultSet();

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

		PreparedStatement pstm = instanciaConection("SELECT * FROM TAREFA WHERE ? = ?");
		pstm.setString(1, campo);
		pstm.setString(2, valor);
		pstm.execute();
		ResultSet rst = pstm.getResultSet();

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
		PreparedStatement pstm = instanciaConectionComRetorno("INSERT INTO TAREFA(DESCRICAO) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
		pstm.setString(1, item);
		pstm.execute();
		ResultSet rst = pstm.getGeneratedKeys();

		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		this.con.close();

	}

	public void remove(Integer id) throws SQLException {
		PreparedStatement pstm = instanciaConection("DELETE FROM TAREFA WHERE ID = ?");
		pstm.setInt(1, id);
		pstm.execute();

		System.out.println("Quantidade de linhas modificadas: " + pstm.getUpdateCount());
		this.con.close();
	}

	public void update(Integer id, String descricao) throws SQLException {
		PreparedStatement pstm = instanciaConection("UPDATE TAREFA SET DESCRICAO = ? WHERE ID=?");
		pstm.setInt(1, id);
		pstm.setString(2, descricao);
		pstm.execute();

		this.con.close();
	}

	private PreparedStatement instanciaConection(String sql) throws SQLException {
		ConnectionFactory conFactory = new ConnectionFactory();
		con = conFactory.conecta();
		PreparedStatement pstm = con.prepareStatement(sql);

		return pstm;
	}
	
	private PreparedStatement instanciaConectionComRetorno(String sql, Integer retorno) throws SQLException {
		ConnectionFactory conFactory = new ConnectionFactory();
		con = conFactory.conecta();
		PreparedStatement pstm = con.prepareStatement(sql, retorno);

		return pstm;
	}
	
}
