package Manager;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class DBConnectionManager {
	static DataSource dataSource;

	static {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder()
		.setType(EmbeddedDatabaseType.HSQL)
		.setName("db_" + System.nanoTime());
		dataSource = builder.build();
	}

	public static DataSource getDataSource() { return dataSource; }
}
