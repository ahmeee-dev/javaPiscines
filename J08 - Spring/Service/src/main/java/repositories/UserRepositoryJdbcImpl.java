package repositories;

import javax.sql.DataSource;

public class UserRepositoryJdbcImpl implements  UserRepository {
	
	DataSource ds;

	public UserRepositoryJdbcImpl(DataSource ds) { this.ds = ds; }

	@Override
	public void delete(long Id) {
		
	}
}
