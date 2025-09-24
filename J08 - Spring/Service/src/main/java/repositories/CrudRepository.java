package repositories;

import java.util.List;

public interface CrudRepository<T> {
	
	public T findById(long toFind);
	public List<T> findAll();
	public void save(T entity);
	public void update(T entity);
	public void delete(long id);

}
