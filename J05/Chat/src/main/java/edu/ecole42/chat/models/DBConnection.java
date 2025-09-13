package edu.ecole42.chat.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:postgresql://localhost:5432/Chat";
	private static final String USER = "user";
	private static final String PASS = "pass";

	public static Connection getConnection() throws  SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}
}