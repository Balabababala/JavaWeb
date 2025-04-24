package dao;

import java.util.List;

import model.entity.Order;
import model.entity.Product;

public class ProductDAOMemoryImpl implements ProductDAO{
	
	public List<Product> findAll() {
		return products;
	}
	
	public Product getProduct(String item) {
		return products.stream()
					   .filter(p -> p.getItem().equals(item))
					   .findFirst()
					   .orElseThrow();
	}
}
