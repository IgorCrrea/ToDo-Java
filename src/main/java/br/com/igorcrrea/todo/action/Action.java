package br.com.igorcrrea.todo.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;
	
}
