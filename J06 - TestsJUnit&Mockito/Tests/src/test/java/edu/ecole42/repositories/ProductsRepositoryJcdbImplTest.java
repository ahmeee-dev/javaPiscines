package edu.ecole42.repositories;

import java.util.List;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import edu.ecole42.modules.Product;
public class ProductsRepositoryJcdbImplTest {
	
	DataSource dataSource;

	final List<Product> EXPECTED_FIND_ALL_PRODUCTS = List.of(
		new Product(1, "Spazzolino", 1),
		new Product(2, "Macchina", 20000),
		new Product(3, "Fionda", 5),
		new Product(4, "AirPods", 150),
		new Product(5, "Laptop", 600)
	);

	final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(3, "Fionda", 5);
	final Product EXPECTED_UPDATED_PRODUCT = new Product(2, "Ventilatore", 35);

	@BeforeEach
	public void init() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder()
		.setType(EmbeddedDatabaseType.HSQL)
		.setName("testdb:" + System.nanoTime())
		.addScript("schema.sql")
		.addScript("data.sql");
		dataSource = builder.build();
	}

	@Test
	public void isFindAllWorking() {
		ProductRepository repo = new ProductRepositoryJcdbImpl(this.dataSource);
		assertEquals(EXPECTED_FIND_ALL_PRODUCTS, repo.findAll());
	}

	@Test
	public void isFindByIdWorking() {
		ProductRepository repo = new ProductRepositoryJcdbImpl(this.dataSource);
		Product value = repo.findById(3).get();
		System.out.println(value.getName() + "\n\n\n");
		System.out.println(EXPECTED_FIND_BY_ID_PRODUCT.getName());
		assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, value);
	}

	@Test
	public void isUpdateProductWorking() {
		ProductRepository repo = new ProductRepositoryJcdbImpl(this.dataSource);
		Product product = repo.findById(2).get();
		product.setName("Ventilatore");
		product.setPrice(35);
		repo.update(product);
		Product updated = repo.findById(2).get();
		assertEquals(EXPECTED_UPDATED_PRODUCT, updated);
	}


	



}
