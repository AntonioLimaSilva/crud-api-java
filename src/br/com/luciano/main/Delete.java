package br.com.luciano.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete extends Conexao {

	public static void main(String[] args) throws SQLException {
		
		Connection conection = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "delete from pessoa where id = ?";
		PreparedStatement preparedStatiment = conection.prepareStatement(sql);
		preparedStatiment.setLong(1, 2);
		boolean excluido = preparedStatiment.execute();
		
		System.out.println("Deletado com sucesso " + excluido);
	}

}
