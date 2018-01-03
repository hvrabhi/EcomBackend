package org.spring.DAO;

import java.util.List;

import org.spring.model.Product;

public interface ProductDAO {

	public boolean saveProduct(Product product);
	public List<Product> retrieveProduct();
	public Product getProductById(int id);
	public Product removeProductyById(int id);
}
