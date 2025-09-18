package edu.ecole42.repositories;

import java.util.List;
import java.util.Optional;

import edu.ecole42.modules.Product;

public interface  ProductRepository {
		
	List<Product> findAll();
	public Optional<Product> findById(int id);
	public void update(Product product);
	public void save(Product product);
	public void delete(int id);
}
