package cart.service;

import java.util.List;

import cart.model.dto.OrderDTO;
import cart.model.dto.OrderItemDTO;
import cart.model.dto.ProductDTO;
import cart.model.entity.Order;
import cart.model.entity.OrderItem;

public interface OrderService {
		//建訂單
		void addOrder(Integer userId,List<ProductDTO> cart);
		//查使用者的訂單 含明細
		List<OrderDTO> findAllOrderByUserId(Integer userId);

}
