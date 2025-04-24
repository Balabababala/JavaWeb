package dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.entity.Order;

public interface OrderDAO {
	
	// 利用 List 來模擬資料庫/資料表 (稱為:InMemoryDatabase)
	public static List<Order> orders = new CopyOnWriteArrayList<>();
	
	// 存入一筆資訊
	public void save(Order order) throws DAOException;
	
	// 取得所有歷史資料
	public List<Order> findAll() throws DAOException;
	
	// 刪除一筆資訊
	public void remove(int index)throws DAOException ;

	// 修改一筆資訊
	public void update(int index, Order newOrder) ;

	// 取得單筆資料
	public Order getOrder(int index) ;
}
