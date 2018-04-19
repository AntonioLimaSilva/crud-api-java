package br.com.luciano.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
	public static void main(String[] args) {

		final String DATABASE_URL = "jdbc:sqlserver://localhost;databaseName=crud";
		final String DATABASE_USER = "user";
		final String DATABASE_PASSWORD = "******";
		final String QUERY = "select * from pessoa";
		
		try {
			Connection conexao = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
			Statement statement = conexao.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int numeroColunas = resultSetMetaData.getColumnCount();
			System.out.println("Tabela pessoa");
			
			for(int i = 1; i <= numeroColunas; i++) 
				System.out.printf("%-8s\t", resultSetMetaData.getColumnName(i));
			System.out.println();
				
			while(resultSet.next()) {
				for(int i = 1; i <= numeroColunas; i++) 
					System.out.printf("%-8s\t", resultSet.getObject(i).toString().trim());
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
