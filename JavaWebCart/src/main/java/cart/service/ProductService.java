package cart.service;

import java.util.List;

import cart.model.dto.ProductDTO;
import cart.model.entity.Product;

public interface ProductService {
	List<ProductDTO> findAllProducts();//查全部
	void add(String productName,String price,String qty,String productImageBase64);//新增
	void delete(Integer productID);//刪除
}
