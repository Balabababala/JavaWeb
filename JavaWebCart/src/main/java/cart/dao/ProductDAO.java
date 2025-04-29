package cart.dao;

import java.util.List;

import cart.model.entity.*;


public interface ProductDAO {
	List<Product> findAllProducts();//查全部
	void add(Product product);//新增
	void delete(Integer productID);//刪除
}
