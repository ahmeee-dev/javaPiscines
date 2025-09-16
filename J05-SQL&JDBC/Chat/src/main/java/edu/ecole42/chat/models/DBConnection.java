package edu.ecole42.chat.models;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class DBConnection {

	private static final String URL = "jdbc:postgresql://localhost:5432/chat";
	private static final String USER = "chatuser";
	private static final String PASS = "pass";
	private static final HikariDataSource ds;

	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(URL);
		config.setUsername(USER);
		config.setPassword(PASS);
		ds = new HikariDataSource(config);

		// try { Connection conn = ds.getConnection();
		// 	readSchema(conn); } catch (SQLException err) { System.err.println("Error: "  + err.getMessage());}


	}

	public static DataSource getDataSource() { return ds; }
	public static Connection getConnection() throws  SQLException {
		return ds.getConnection();
	}

	public static void shutdown() {
		if (ds != null) {
			ds.close();
		}
	}
}