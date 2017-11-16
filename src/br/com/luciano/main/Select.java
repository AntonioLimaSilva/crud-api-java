package br.com.luciano.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Select extends Conexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "select * from pessoa order by id desc";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int totalColuna = resultSetMetaData.getColumnCount();

		for (int i = 1; i <= totalColuna; i++)
			System.out.printf("%-8s\t", resultSetMetaData.getColumnName(i));
		System.out.println();

		while (resultSet.next()) {
			for (int i = 1; i <= totalColuna; i++)
				System.out.printf("%-8s\t", resultSet.getObject(i).toString().trim());
			System.out.println();
		}

	}

}
