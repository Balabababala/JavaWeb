package dao;

public class OrderDAOFactory {
	public OrderDAO createOrderDAO()  {
		return new OrderDAOMemoryImpl();
	}
}
