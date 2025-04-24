package dao;

import java.util.List;

import model.entity.Order;

public class OrderDAOMemoryImpl implements OrderDAO{
	
@Override
// 存入一筆資訊
	public void save(Order order) {
		orders.add(order);
	}
@Override	
	// 取得所有歷史資料
	public List<Order> findAll() {
		return orders;
	}
@Override	
	// 刪除一筆資訊
	public void remove(int index) {
		orders.remove(index);
	}
@Override	
	// 修改一筆資訊
	public void update(int index, Order newOrder) {
		orders.set(index, newOrder);
	}
@Override	
	// 取得單筆資料
	public Order getOrder(int index) {
		return orders.get(index);
	}
}
