package edu.ecole42.repositories;

import java.sql.SQLException;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class EmbeddedDataSourceTest {
	
	static DataSource dataSource;

	@BeforeEach
	public static void init() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder()
		.setType(EmbeddedDatabaseType.HSQL)
		.addScript("schema.sql")
		.addScript("data.sql");
		dataSource = builder.build();
	}

	@Test
	void isGetConnectionVoid() {
		boolean result = false;
		try { result = dataSource.getConnection() != null; } catch (SQLException err) { System.err.println(err.getMessage());}
		assertEquals(true, result);
	}
}
