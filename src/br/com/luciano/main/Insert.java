package br.com.luciano.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert extends Conexao {

	public static void main(String[] args) throws SQLException {
		
		Connection conection = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "insert into pessoa(nome, email) values(?, ?)";
		PreparedStatement preparedStatement = conection.prepareStatement(sql);
		preparedStatement.setString(1, "José Souza");
		preparedStatement.setString(2, "jose@gmail.com");
		preparedStatement.execute();	

		System.out.println("Inserido com sucesso!");
	}

}
