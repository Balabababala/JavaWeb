package cart.dao;

import java.util.List;

import cart.model.entity.Order;
import cart.model.entity.OrderItem;

public interface OrderDAO {
	//建訂單主檔 return orderId
	Integer addOrder(Integer userId);
	//建訂單明細 
	void addOrderItem(Integer orderId,Integer productId,Integer qualtity );
	//查使用者的訂單
	List<Order> findAllOrderByUserId(Integer userId);
	//查使用者訂單明細
	List<OrderItem> findAllOrderItemsByOrderId(Integer orderId);
}
