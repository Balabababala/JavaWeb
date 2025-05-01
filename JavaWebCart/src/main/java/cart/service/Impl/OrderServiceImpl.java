package cart.service.Impl;

import java.util.ArrayList;
import java.util.List;

import cart.dao.OrderDAO;
import cart.dao.impl.OrderDAOImpl;
import cart.model.dto.OrderDTO;
import cart.model.dto.OrderItemDTO;
import cart.model.dto.ProductDTO;
import cart.model.entity.Order;
import cart.model.entity.OrderItem;
import cart.service.OrderService;

public class OrderServiceImpl implements OrderService{
	private OrderDAO orderDAO=new OrderDAOImpl();
	@Override
	public void addOrder(Integer userId, List<ProductDTO> cart) {//ProductDTO 不是產品本身的 是cart 本身的
		//新增訂單主檔
		Integer orderID=orderDAO.addOrder(userId);
		for(ProductDTO productDTO:cart) {
			orderDAO.addOrderItem(orderID, productDTO.getProductId(),productDTO.getQty());
		}
	}
	@Override
	public List<OrderDTO> findAllOrderByUserId(Integer userId) {
		List<OrderDTO> orderDTOs=new ArrayList<OrderDTO>();
		//取訂單資訊
		List<Order> orders=orderDAO.findAllOrderByUserId(userId);
		for(Order order:orders) {
			OrderDTO orderDTO=new OrderDTO();
			
			orderDTO.setOrderID(order.getOrderId());		
			orderDTO.setUserId(order.getUserId());
			orderDTO.setOrderDate(order.getOrderDate());	
			
			List<OrderItemDTO> orderItemDTOs= new ArrayList<OrderItemDTO>();
			for(OrderItem item:orderDAO.findAllOrderItemsByOrderId(order.getOrderId())) {
				OrderItemDTO itemDTO=new OrderItemDTO();
				itemDTO.setItemId(item.getItemId());
				itemDTO.setOrderId(item.getOrderId());
				itemDTO.setProductId(item.getProductId());
				itemDTO.setQuantity(item.getQuantity());
				
				orderItemDTOs.add(itemDTO);
				}
			orderDTO.setItems(orderItemDTOs);
			
			orderDTOs.add(orderDTO);
		}	
		return orderDTOs;
	}
}
