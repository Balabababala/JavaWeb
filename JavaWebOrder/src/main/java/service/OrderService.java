package service;

import java.util.*;

import dao.*;
import model.dto.*;
import model.entity.*;


public class OrderService {
	private static final int BEEF_PRICE = 100;
	private static final int PLAIN_PRICE = 120;
	private static final int TOMATO_PRICE = 140;
	private OrderDAO order =new OrderDAO();
	
	public OrderDTO addOrder(String[] item) {
		Order order=new Order();
		order.setPorkNumber(Integer.parseInt(item[0]));
		order.setPorkPrice(BEEF_PRICE*order.getPorkNumber());
		order.setPlainNumber(Integer.parseInt(item[1]));
		order.setPlainPrice(PLAIN_PRICE*order.getPlainNumber());
		order.setPotatoNumber(Integer.parseInt(item[2]));
		order.setPotatoPrice(TOMATO_PRICE*order.getPotatoNumber());
		int totalPrice=order.getPorkPrice()+order.getPlainPrice()+order.getPotatoPrice();
		
		OrderDAO.save(order);
			
		OrderDTO orderDTO=new OrderDTO();
		
		orderDTO.setMessage("你點了牛肉麵 數量"+order.getPorkNumber()+"價格"+order.getPorkPrice()+"元"+"\n"+
							"你點了陽春麵 數量"+order.getPlainNumber()+"價格"+order.getPlainPrice()+"元"+"\n"+
							"你點了番茄麵 數量"+order.getPotatoNumber()+"價格"+order.getPotatoPrice()+"元"+"\n"+
							"總價錢:"+ totalPrice+ "元"
							);
		return orderDTO;
	}
	public List<OrderDTO> getOrderHistory() {
		List<Order> orders = OrderDAO.findAll();
		
		List<OrderDTO> orderDTOs=new ArrayList<>();
		
		for(Order order:orders ) {
			OrderDTO dto=new OrderDTO();
			int totalPrice = order.getPorkPrice() + order.getPlainPrice() + order.getPotatoPrice();
			
			dto.setMessage("你點了牛肉麵 數量"+order.getPorkNumber()+"價格"+order.getPorkPrice()+"元"+"\n"+
						   "你點了陽春麵 數量"+order.getPlainNumber()+"價格"+order.getPlainPrice()+"元"+"\n"+
						   "你點了番茄麵 數量"+order.getPotatoNumber()+"價格"+order.getPotatoPrice()+"元"+"\n"+
						   "總價錢:"+ totalPrice
						   );
			orderDTOs.add(dto);			
		}
		return orderDTOs;
	}
	
	
}
