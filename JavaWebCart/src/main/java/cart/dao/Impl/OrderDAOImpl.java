package cart.dao.Impl;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cart.dao.BaseDAO;
import cart.dao.OrderDAO;
import cart.model.entity.Order;
import cart.model.entity.OrderItem;

public class OrderDAOImpl extends BaseDAO implements OrderDAO{

	@Override
	public Integer addOrder(Integer userId) {
		String sql="INSERT INTO `order`(user_id) values(?)";
		Integer orderId=null;
		//因為後續要取得新增後自動生成的 order_id 所以要加上 Statement.RETURN_GENERATED_KEYS 參數設定
		try(PreparedStatement pstmt=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ) {
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
			
			ResultSet generateKeys=pstmt.getGeneratedKeys();
			if(generateKeys.next()) {
				orderId=generateKeys.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderId;
	}

	@Override
	public void addOrderItem(Integer orderId, Integer productId, Integer qualtity) {
		String sql="INSERT INTO order_item(order_id,product_id,quantity) values(?,?,?)";
		try(PreparedStatement pstmt=conn.prepareStatement(sql) ) {
			pstmt.setInt(1, orderId);
			pstmt.setInt(2, productId);
			pstmt.setInt(3, qualtity);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sql="UPDATE product set qty=qty - ? where product_id =?";
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setInt(1, orderId);
			pstmt.setInt(2, productId);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> findAllOrderByUserId(Integer userId) {
		List<Order> orders =new ArrayList<Order>();
		String sql="SELECT order_id ,user_id,order_date from `order` WHERE user_id=?";
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setInt(1, userId);
			try(ResultSet rs=pstmt.executeQuery()) {
				while (rs.next()) {
					Order order =new Order();
					order.setOrderId(rs.getInt("order_id"));
					order.setUserId(rs.getInt("user_id"));
					order.setOrderDate(rs.getDate("order_date"));
					
					orders.add(order);
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<OrderItem> findAllOrderItemsByUserId(Integer orderId) {
		List<OrderItem> items =new ArrayList<>();
		String sql="SELECT item_id,order_id ,product_id,quantity from order_item WHERE order_id=?";
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setInt(1, orderId);
			try(ResultSet rs=pstmt.executeQuery()) {
				while (rs.next()) {
					OrderItem orderItem =new OrderItem();
					orderItem.setItemId(rs.getInt("item_id"));
					orderItem.setOrderId(rs.getInt("order_id"));
					orderItem.setProductId(rs.getInt("product_id"));
					orderItem.setQuantity(rs.getInt("quantity"));
					
					items.add(orderItem);
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	
}
