package edu.ecole42.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import edu.ecole42.modules.Product;
 

public class ProductRepositoryJcdbImpl implements ProductRepository {
	
	private final DataSource dataSource;

	public ProductRepositoryJcdbImpl(DataSource dataSource) { this.dataSource = dataSource; }

	@Override
	public List<Product> findAll() {
		List<Product> productList = new ArrayList<>();
		String sql = "SELECT * FROM product;";
		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
				productList.add(product);
			}
		} catch (SQLException err) { System.err.println(err.getMessage());}
		return productList;
	}

	@Override
	public Optional<Product> findById(int id) {
		String sql = "SELECT * FROM product WHERE id = ?";
		
		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
				return Optional.of(product);
			}
		} catch (SQLException err) { System.err.println(err.getMessage());}
		return Optional.empty();
	}

	@Override
	public void update(Product product) {
		String sql = "UPDATE product SET name = ?, price = ? WHERE id = ?;";
		int changed = 0;
		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement st = conn.prepareStatement(sql);
			Object[] params = { product.getName(), product.getPrice(), product.getId() };
			for (int i = 0; i < params.length; i++) { st.setObject(i + 1, params[i]);}
			changed = st.executeUpdate();
		} catch (SQLException err) { System.err.println(err.getMessage());}
		System.out.println("Changed lines: " + changed);
	}

	@Override
	public void save(Product product) {
		String sql = "INSERT INTO product (name, price) VALUES (?,?);";

		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement st = conn.prepareStatement(sql);
			Object[] params = { product.getName(), product.getPrice()};
			for (int i = 0; i < params.length; i++) { st.setObject(i + 1, params[i]);}
			try {
				if (st.executeUpdate() < 1) { throw new SQLException("Couldn't save the Product"); }
				ResultSet rs = st.getGeneratedKeys();
				product.setId(rs.getInt(1));
			} catch (SQLException err) { System.err.println("Error: " + err.getMessage());}
		} catch (SQLException err) { System.err.println(err.getMessage());}
	}

	@Override 
	public void delete(int id) {
		String sql = "DELETE FROM product WHERE id = ?";
		int result = 0;
		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			result = st.executeUpdate();
		} catch (SQLException err) { System.err.println(err.getMessage());}
		System.out.println("Executed Deletions: " + result);
	}
}
