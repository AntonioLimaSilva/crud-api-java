package br.com.luciano.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update extends Conexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "update pessoa set nome = ?, email = ? where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, "Gloria Pirez");
		preparedStatement.setString(2, "gloria@gmail.com");
		preparedStatement.setLong(3, 3);
		preparedStatement.execute();
		
		System.out.println("Pessoa atualizada com sucesso!");
	}

}
