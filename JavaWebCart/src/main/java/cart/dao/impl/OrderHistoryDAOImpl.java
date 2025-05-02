package cart.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cart.dao.BaseDAO;
import cart.dao.OrderHistoryDAO;
import cart.model.entity.OrderHistory;

public class OrderHistoryDAOImpl extends BaseDAO implements OrderHistoryDAO{

	@Override
	public List<OrderHistory> findHistory(String username) {
		String sql="SELECT o.order_id, oi.quantity, p.product_name\r\n"
				+ "FROM cart.user u\r\n"
				+ "JOIN cart.order o ON u.id = o.user_id\r\n"
				+ "JOIN cart.order_item oi ON o.order_id = oi.order_id\r\n"
				+ "JOIN cart.product p ON oi.product_id = p.product_id\r\n"
				+ "WHERE u.username = ?";
		try (PreparedStatement pstmt =conn.prepareStatement(sql)){
			pstmt.setString(1, username);
			List<OrderHistory> histories =new ArrayList<>();
			try (ResultSet rs= pstmt.executeQuery()){
				while(rs.next()) {
					OrderHistory history=new OrderHistory();
					
					history.setOrderId(rs.getInt("order_id"));
					history.setQuantity(rs.getInt("quantity"));
					history.setProductName(rs.getString("product_name"));
					
					histories.add(history);
				}
				return histories;	
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
