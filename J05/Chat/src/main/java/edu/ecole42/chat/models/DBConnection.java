package edu.ecole42.chat.models;

import java.sql.Connection;
import java.sql.SQLException;

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

	// public static void readSchema(Connection conn) {
	// 	try {
	// 		String sql = new String(Files.readAllBytes(Paths.get("../resources/schema.sql")), StandardCharsets.UTF_8);
	// 		for (String line : sql.split(";")) {
	// 			if (!line.trim().isEmpty()) {
	// 				try (Statement st = conn.createStatement()) {
	// 					st.execute(line);
	// 				}
	// 			}
	// 		}
	// 	} catch (Exception err) { System.err.println("Error: " + err.getMessage());}
	// }

	public static Connection getConnection() throws  SQLException {
		return ds.getConnection();
	}

	public static void shutdown() {
		if (ds != null) {
			ds.close();
		}
	}
}