package dao;

public class ProductDAOFactory {
	public ProductDAO createProductDAO() {
		return new ProductDAOMemoryImpl();
	}
}
