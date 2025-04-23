package dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.entity.Order;

public class OrderDAO {
	
	//利用List 模擬資料庫 (InMemoryDatabase)
	private static List<Order> orders=new CopyOnWriteArrayList<>();
	
	public static void save(Order order) {
		orders.add(order);
	}
	
	public static List<Order> findAll(){
		return orders;
	}
	
}
