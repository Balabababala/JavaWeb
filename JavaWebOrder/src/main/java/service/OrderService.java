package service;

import java.util.ArrayList;
import java.util.List;

import dao.OrderDAO;
import dao.OrderDAOFactory;
import dao.ProductDAO;
import dao.ProductDAOFactory;
import model.dto.OrderDTO;
import model.entity.Order;

public class OrderService {
	
	private OrderDAOFactory orderDAOFactory=new OrderDAOFactory();
	private OrderDAO orderDAO = orderDAOFactory.createOrderDAO();
	private ProductDAOFactory productDAOFactory=new ProductDAOFactory();
	private ProductDAO productDAO = productDAOFactory.createProductDAO();

	
	// 根據訂單項目(item)新增一筆訂單並回傳訂單顯示資訊(OrderDTO)
	public OrderDTO addOrder(String item,String quality) {
		// 1: 根據訂單項目(item)新增一筆訂單
		Order order = new Order();
		order.setItem(item);
		order.setQuality(Integer.parseInt(quality));
		//order.setPrice(100); // 價格一律 100 元
		order.setPrice(productDAO.getProduct(item).getPrice()*order.getQuality());
		// 傳給 orderDAO 儲存訂單
		orderDAO.save(order);
		//-------------------------------------
		// 2: 回傳訂單顯示資訊(OrderDTO)
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setMessage("您點了 " + order.getItem() + order.getQuality()+"個"+" 價格:" + order.getPrice() + "元");
		
		return orderDTO;
	}
	
	// 取得歷史資料
	public List<OrderDTO> getOrderHistory() {
		List<Order> orders = orderDAO.findAll(); // 取得所有資料
		// 將 List<Order> 轉 List<OrderDTO>
		List<OrderDTO> orderDTOs = new ArrayList<>();
		// 一筆一筆轉
		for(Order order : orders) {
			OrderDTO dto = new OrderDTO();
			dto.setMessage("您點了 " + order.getItem() + " 價格:" + order.getPrice() + "元");
			orderDTOs.add(dto); // 逐筆加入到集合中
		}
		return orderDTOs;
	}
	public OrderDTO getTotalPrice() {
		List<Order> orders = orderDAO.findAll();
		OrderDTO dto=new OrderDTO();
		int totel=orders.stream()
		 	      .mapToInt(Order::getPrice)
				  .sum();
		dto.setMessage(Integer.toString(totel));					
		return dto;
	}

	// 刪除一筆訂單根據 index
	public OrderDTO removeOrder(String index) {
		return removeOrder(Integer.parseInt(index));
	}
	
	// 刪除一筆訂單根據 index
	public OrderDTO removeOrder(int index) {
		orderDAO.remove(index);
		// 回報結果
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setMessage("index=" + index + ". 資料刪除成功");
		return orderDTO;
	}
	
	// 修改單筆
	public OrderDTO updateOrder(String index, String newItem,String quality) {
		Order order = orderDAO.getOrder(Integer.parseInt(index));
		order.setItem(newItem);
		order.setPrice(productDAO.getProduct(newItem).getPrice()*Integer.parseInt(quality));
		order.setQuality(Integer.parseInt(quality));
		orderDAO.update(Integer.parseInt(index), order,Integer.parseInt(quality));
		// 回報結果
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setMessage("index=" + index + ". 資料修改成功");
		return orderDTO;
	}
	
	
}
