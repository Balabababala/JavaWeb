package dao;

public class OrderDAOFactory {
	public OrderDAO createOrderDAO() throws Exception {
		return new OrderDAOMemoryImpl();
	}
}
