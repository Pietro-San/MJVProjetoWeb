package br.com.mjv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

	public Connection connection = null;
	public Statement statement = null;
	public ResultSet resultSet = null;
	
	public boolean getConnection() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String login="root";
		final String senha="root";
		final String banco="db";
		final String servidor = "localhost";
		final String url = "jdbc:mysql://"+servidor+":3306/"+banco+"?useTimezone=true&serverTimezone=UTC";
		
		connection = DriverManager.getConnection(url, login, senha);
		
		return true;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}catch (ClassNotFoundException e){
			e.printStackTrace();
			return false;
		}
	}
	
	private void closeResultSet() {
		try {
			if(resultSet!=null) {
				resultSet.close();
			}
		}
		catch(Exception erro) {
			erro.printStackTrace();
		}
	}
	
	private void closeStatement() {
		try {
			if(statement!=null) {
				statement.close();
			}
		}
		catch(Exception erro) {
			erro.printStackTrace();
		}
	}
	
	private void closeConnection() {
		try {
			if(connection!=null) {
				connection.close();
			}
		}
		catch(Exception erro) {
			erro.printStackTrace();
		}
	}
	
	public void close(){
		closeResultSet();
		closeStatement();
		closeConnection();
	}
	
	
}
